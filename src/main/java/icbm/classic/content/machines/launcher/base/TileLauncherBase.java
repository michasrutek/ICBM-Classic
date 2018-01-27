package icbm.classic.content.machines.launcher.base;

import com.builtbroken.jlib.data.vector.IPos3D;
import com.builtbroken.mc.api.energy.IEnergyBuffer;
import com.builtbroken.mc.api.energy.IEnergyBufferProvider;
import com.builtbroken.mc.api.tile.multiblock.IMultiTile;
import com.builtbroken.mc.api.tile.multiblock.IMultiTileHost;
import com.builtbroken.mc.api.tile.provider.IInventoryProvider;
import com.builtbroken.mc.data.Direction;
import com.builtbroken.mc.framework.multiblock.EnumMultiblock;
import com.builtbroken.mc.framework.multiblock.MultiBlockHelper;
import com.builtbroken.mc.imp.transform.rotation.EulerAngle;
import com.builtbroken.mc.imp.transform.vector.Pos;
import com.builtbroken.mc.lib.helper.LanguageUtility;
import com.builtbroken.mc.prefab.inventory.ExternalInventory;
import icbm.classic.ICBMClassic;
import icbm.classic.Settings;
import icbm.classic.content.entity.EntityMissile;
import icbm.classic.content.entity.EntityPlayerSeat;
import icbm.classic.content.explosive.Explosive;
import icbm.classic.content.explosive.Explosives;
import icbm.classic.content.items.ItemMissile;
import icbm.classic.content.machines.launcher.frame.TileLauncherFrame;
import icbm.classic.content.machines.launcher.screen.TileLauncherScreen;
import icbm.classic.prefab.BlockICBM;
import icbm.classic.prefab.TileMachine;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import resonant.api.explosion.ILauncherContainer;
import resonant.api.explosion.ILauncherController;

import java.util.HashMap;

/**
 * This tile entity is for the base of the missile launcher
 *
 * @author Calclavia
 */
public class TileLauncherBase extends TileMachine implements IMultiTileHost, ILauncherContainer, IEnergyBufferProvider, IInventoryProvider<ExternalInventory>
{
    public static HashMap<IPos3D, String> northSouthMultiBlockCache = new HashMap();
    public static HashMap<IPos3D, String> eastWestMultiBlockCache = new HashMap();

    private static EulerAngle angle = new EulerAngle(0, 0, 0);

    static
    {
        northSouthMultiBlockCache.put(new Pos(1, 0, 0), EnumMultiblock.INV_ENERGY.getTileName());
        northSouthMultiBlockCache.put(new Pos(1, 1, 0), EnumMultiblock.INV_ENERGY.getTileName());
        northSouthMultiBlockCache.put(new Pos(1, 2, 0), EnumMultiblock.INV_ENERGY.getTileName());
        northSouthMultiBlockCache.put(new Pos(-1, 0, 0), EnumMultiblock.INV_ENERGY.getTileName());
        northSouthMultiBlockCache.put(new Pos(-1, 1, 0), EnumMultiblock.INV_ENERGY.getTileName());
        northSouthMultiBlockCache.put(new Pos(-1, 2, 0), EnumMultiblock.INV_ENERGY.getTileName());

        eastWestMultiBlockCache.put(new Pos(0, 0, 1), EnumMultiblock.INV_ENERGY.getTileName());
        eastWestMultiBlockCache.put(new Pos(0, 1, 1), EnumMultiblock.INV_ENERGY.getTileName());
        eastWestMultiBlockCache.put(new Pos(0, 2, 1), EnumMultiblock.INV_ENERGY.getTileName());
        eastWestMultiBlockCache.put(new Pos(0, 0, -1), EnumMultiblock.INV_ENERGY.getTileName());
        eastWestMultiBlockCache.put(new Pos(0, 1, -1), EnumMultiblock.INV_ENERGY.getTileName());
        eastWestMultiBlockCache.put(new Pos(0, 2, -1), EnumMultiblock.INV_ENERGY.getTileName());
    }

    // The connected missile launcher frame
    public TileLauncherFrame supportFrame = null;
    public TileLauncherScreen launchScreen = null;

    /** Fake entity to allow player to mount the missile without using the missile entity itself */
    public EntityPlayerSeat seat;

    // The tier of this launcher base
    private boolean _destroyingStructure = false;

    ExternalInventory inventory;

    /** Client's render cached object, used in place of inventory to avoid affecting GUIs */
    public ItemStack cachedMissileStack;

    @Override
    public IEnergyBuffer getEnergyBuffer(Direction side)
    {
        if (launchScreen != null)
        {
            return launchScreen.getEnergyBuffer(Direction.UNKNOWN);
        }
        return null;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner
     * uses this to count ticks and creates a new spawn inside its implementation.
     */
    @Override
    public void update()
    {
        super.update();
        if (isServer())
        {
            if (ticks % 3 == 0)
            {
                //Update seat position
                if (seat != null)
                {
                    seat.setPosition(x() + 0.5, y() + 0.5, z() + 0.5);
                }

                //Create seat if missile
                if (!getMissileStack().isEmpty() && seat == null)
                {
                    seat = new EntityPlayerSeat(world);
                    seat.host = this;
                    seat.rideOffset = new Pos(getRotation()).multiply(0.5, 1, 0.5);
                    seat.setPosition(x() + 0.5, y() + 0.5, z() + 0.5);
                    seat.setSize(0.5f, 2.5f);
                    world.spawnEntity(seat);
                }
                //Destroy seat if no missile
                else if (getMissileStack().isEmpty() && seat != null)
                {
                    if (seat.getRidingEntity() != null)
                    {
                        seat.getRidingEntity().startRiding(null);
                    }
                    seat.setDead();
                    seat = null;
                }
            }
        }
        //1 second update
        if (ticks % 20 == 0)
        {
            //Only update if frame or screen is invalid
            if (this.supportFrame == null || launchScreen == null || launchScreen.isInvalid() || this.supportFrame.isInvalid())
            {
                //Reset data
                this.supportFrame = null;
                this.launchScreen = null;

                //Check on all 4 sides
                for (byte i = 2; i < 6; i++)
                {
                    //Get tile entity on side
                    Pos position = new Pos(getPos()).add(Direction.getOrientation(i));
                    TileEntity tileEntity = this.world.getTileEntity(position.toBlockPos());

                    //If frame update rotation
                    if (tileEntity instanceof TileLauncherFrame)
                    {
                        this.supportFrame = (TileLauncherFrame) tileEntity;
                        if (isServer())
                        {
                            this.supportFrame.setRotation(getRotation());
                        }
                    }
                    //If screen, tell the screen the base exists
                    else if (tileEntity instanceof TileLauncherScreen)
                    {
                        this.launchScreen = (TileLauncherScreen) tileEntity;
                    }
                }
            }
        }
    }

    @Override
    public void onInventoryChanged(int slot, ItemStack prev, ItemStack item)
    {
        if (slot == 0)
        {
            sendDescPacket();
        }
    }

    @Override
    public boolean canStore(ItemStack stack, Direction side)
    {
        return stack != null && stack.getItem() == ICBMClassic.itemMissile;
    }

    @Override
    public boolean canRemove(ItemStack stack, Direction side)
    {
        return true;
    }

    //@Override
    public String getInventoryName()
    {
        return LanguageUtility.getLocal("gui.launcherBase.name");
    }

    /**
     * Launches the missile
     *
     * @param target     - The target in which the missile will land in
     * @param lockHeight - height to wait before curving the missile
     */
    public boolean launchMissile(Pos target, int lockHeight)
    {
        final ItemStack stack = getMissileStack();
        if (stack.getItem() == ICBMClassic.itemMissile)
        {
            Explosive ex = Explosives.get(stack.getItemDamage()).handler;
            if (ex.hasMissileForm())
            {
                // Apply inaccuracy
                int inaccuracy = 30;

                //Get value from support frame
                if (this.supportFrame != null)
                {
                    inaccuracy = this.supportFrame.getInaccuracy();
                }

                //Randomize distance
                inaccuracy = getWorld().rand.nextInt(inaccuracy);

                //Randomize radius drop
                angle.setYaw(getWorld().rand.nextFloat() * 360);

                //Update target
                target = target.add(angle.x() * inaccuracy, 0, angle.z() * inaccuracy);

                //TODO add distance check? --- something seems to be missing
                //TODO add distance based inaccuracy addition
                //TODO add tier based inaccuracy, higher tier missiles have a high chance of hitting

                if (isServer())
                {
                    EntityMissile missile = new EntityMissile(getWorld());

                    //Set data
                    missile.explosiveID = Explosives.get(stack.getItemDamage());
                    missile.launcherPos = new Pos((TileEntity) this);
                    missile.setPosition(xi(), yi() + 3, zi());

                    //Trigger launch event
                    missile.launch(target, lockHeight);

                    //Spawn entity
                    getWorld().spawnEntity(missile);

                    //Grab rider
                    if (seat != null && seat.getRidingEntity() != null)
                    {
                        Entity entity = seat.getRidingEntity();
                        seat.getRidingEntity().startRiding(null);
                        entity.startRiding(missile);
                    }

                    //Remove item
                    getInventory().decrStackSize(0, 1);
                }
                return true;
            }
        }
        return false;
    }

    // Checks if the missile target is in range
    public boolean isInRange(Pos target)
    {
        if (target != null)
        {
            return !isTargetTooFar(target) && !isTargetTooClose(target);
        }
        return false;
    }

    /**
     * Checks to see if the target is too close.
     *
     * @param target
     * @return
     */
    public boolean isTargetTooClose(Pos target)
    {
        // Check if it is greater than the minimum range
        return new Pos(this.x(), 0, this.z()).distance(new Pos(target.x(), 0, target.z())) < 10;
    }

    // Is the target too far?
    public boolean isTargetTooFar(Pos target)
    {
        // Checks if it is greater than the maximum range for the launcher base
        double distance = new Pos(this.x(), 0, this.z()).distance(new Pos(target.x(), 0, target.z()));


        return distance > getRange();
    }

    public double getRange()
    {
        return getRangeForTier(getTier());
    }

    public static double getRangeForTier(BlockICBM.EnumTier tier)
    {
        if (tier == BlockICBM.EnumTier.ONE)
        {
            return Settings.LAUNCHER_RANGE_TIER1;
        }
        else if (tier == BlockICBM.EnumTier.TWO)
        {
            return Settings.LAUNCHER_RANGE_TIER2;
        }
        return Settings.LAUNCHER_RANGE_TIER3;
    }

    /** Reads a tile entity from NBT. */
    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        getInventory().load(nbt.getCompoundTag("inventory"));
    }

    /** Writes a tile entity to NBT. */
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        nbt.setTag("inventory", getInventory().save(new NBTTagCompound()));
        return super.writeToNBT(nbt);
    }

    @Override
    public void writeDescPacket(ByteBuf buf)
    {
        super.writeDescPacket(buf);
        ByteBufUtils.writeItemStack(buf, getMissileStack());
    }

    @Override
    public void readDescPacket(ByteBuf buf)
    {
        super.readDescPacket(buf);
        cachedMissileStack = ByteBufUtils.readItemStack(buf);
    }

    public ItemStack getMissileStack()
    {
        if (isClient() && cachedMissileStack != null)
        {
            return cachedMissileStack;
        }
        return getInventory().getStackInSlot(0);
    }

    protected boolean onPlayerRightClick(EntityPlayer player, EnumHand hand, ItemStack heldItem)
    {
        if (!heldItem.isEmpty())
        {
            if (heldItem.getItem() instanceof ItemMissile)
            {
                if (this.getMissileStack().isEmpty())
                {
                    if (isServer())
                    {
                        getInventory().setInventorySlotContents(0, heldItem);
                        if (!player.capabilities.isCreativeMode)
                        {
                            player.setItemStackToSlot(hand == EnumHand.MAIN_HAND ? EntityEquipmentSlot.MAINHAND : EntityEquipmentSlot.OFFHAND, ItemStack.EMPTY);
                            player.inventoryContainer.detectAndSendChanges();
                        }
                    }
                    return true;
                }
            }
            else if (launchScreen != null)
            {
                return ICBMClassic.blockLaunchScreen.onBlockActivated(world, launchScreen.getPos(), world.getBlockState(launchScreen.getPos()), player, hand, EnumFacing.NORTH, 0, 0, 0);
                //return launchScreen.onPlayerActivated(player, side, hit);
            }
        }
        else if (!this.getMissileStack().isEmpty())
        {
            if (isServer())
            {

                player.setItemStackToSlot(hand == EnumHand.MAIN_HAND ? EntityEquipmentSlot.MAINHAND : EntityEquipmentSlot.OFFHAND, this.getMissileStack());
                getInventory().setInventorySlotContents(0, ItemStack.EMPTY);
                player.inventoryContainer.detectAndSendChanges();
            }
            return true;
        }

        return true;
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        return INFINITE_EXTENT_AABB;
    }

    @Override
    public ExternalInventory getInventory()
    {
        if (inventory == null)
        {
            inventory = new ExternalInventory(this, 1);
        }
        return inventory;
    }

    @Override
    public boolean canStore(ItemStack stack, int slot, Direction side)
    {
        return slot == 0 && stack.getItem() instanceof ItemMissile;
    }

    @Override
    public ILauncherController getController()
    {
        for (byte i = 2; i < 6; i++)
        {
            Pos position = new Pos((TileEntity) this).add(Direction.getOrientation(i));

            TileEntity tileEntity = position.getTileEntity(this.world);

            if (tileEntity instanceof ILauncherController)
            {
                return (ILauncherController) tileEntity;
            }
        }

        return null;
    }

    //==========================================
    //==== Multi-Block code
    //=========================================

    @Override
    public void onLoad()
    {
        super.onLoad();
        MultiBlockHelper.buildMultiBlock(getWorld(), this, true, true);
    }

    @Override
    public void onMultiTileAdded(IMultiTile tileMulti)
    {
        if (tileMulti instanceof TileEntity)
        {
            if (getLayoutOfMultiBlock().containsKey(new Pos((TileEntity) this).sub(new Pos((TileEntity) tileMulti))))
            {
                tileMulti.setHost(this);
            }
        }
    }

    @Override
    public boolean onMultiTileBroken(IMultiTile tileMulti, Object source, boolean harvest)
    {
        if (!_destroyingStructure && tileMulti instanceof TileEntity)
        {
            Pos pos = new Pos((TileEntity) tileMulti).sub(new Pos((TileEntity) this));

            if (getLayoutOfMultiBlock().containsKey(pos))
            {
                MultiBlockHelper.destroyMultiBlockStructure(this, harvest, true, true);
                return true;
            }
        }
        return false;
    }

    //TODO @Override
    public boolean removeByPlayer(EntityPlayer player, boolean willHarvest)
    {
        _destroyingStructure = true;
        MultiBlockHelper.destroyMultiBlockStructure(this, false, true, false);
        //TODO return super.removeByPlayer(player, willHarvest);
        return true;
    }

    @Override
    public void onTileInvalidate(IMultiTile tileMulti)
    {

    }

    @Override
    public boolean onMultiTileActivated(IMultiTile tile, EntityPlayer player, EnumHand hand, EnumFacing side, float xHit, float yHit, float zHit)
    {
        return this.onPlayerRightClick(player, hand, player.getHeldItem(hand));
    }

    @Override
    public void onMultiTileClicked(IMultiTile tile, EntityPlayer player)
    {

    }

    @Override
    public HashMap<IPos3D, String> getLayoutOfMultiBlock()
    {
        if (getRotation() == EnumFacing.EAST || getRotation() == EnumFacing.WEST)
        {
            return eastWestMultiBlockCache;
        }
        return northSouthMultiBlockCache;
    }

    @Override
    public void setRotation(EnumFacing facingDirection)
    {
        //Only update if state has changed
        if (facingDirection != getRotation()

                //Prevent up and down placement
                && facingDirection != EnumFacing.UP
                && facingDirection != EnumFacing.DOWN)
        {
            //Clear old structure
            if (isServer())
            {
                MultiBlockHelper.destroyMultiBlockStructure(this, false, true, false);
            }

            //Update block state
            world.setBlockState(pos, getBlockState().withProperty(BlockICBM.ROTATION_PROP, facingDirection));

            //Create new structure
            if (isServer())
            {
                MultiBlockHelper.buildMultiBlock(getWorld(), this, true, true);
                markDirty();
            }
        }
    }
}
