package icbm.classic.content.blast.redmatter;

import icbm.classic.api.ICBMClassicAPI;
import icbm.classic.config.blast.ConfigBlast;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * Created by Dark(DarkGuardsman, Robert) on 4/19/2020.
 */
public class EntityRedmatter extends Entity
{
    public static final float MAX_SPEED = 0.5f;
    public static final float SPEED_REDUCTION = 0.98f;

    //Acts as an API wrapper for the entity
    protected final BlastRedmatterWrapper blastData = new BlastRedmatterWrapper(this);
    protected final CapRedmatterPull capRedmatterPull = new CapRedmatterPull(this);

    //Handlers
    protected final RedmatterClientLogic clientLogic = new RedmatterClientLogic(this);
    protected final RedmatterLogic redmatterLogic = new RedmatterLogic(this);

    private static final DataParameter<Float> SIZE_DATA = EntityDataManager.createKey(EntityRedmatter.class, DataSerializers.FLOAT);

    public EntityRedmatter(World world)
    {
        super(world);
        this.setSize(0.98F, 0.98F);
        this.preventEntitySpawning = true;
        this.ignoreFrustumCheck = true;
        this.ticksExisted = 0;
        this.noClip = true;
    }

    @Override
    protected void entityInit()
    {
        this.dataManager.register(SIZE_DATA, ConfigBlast.REDMATTER.NORMAL_RADIUS);
    }

    @Override
    public void onUpdate()
    {
        if (this.motionX != 0 || this.motionY != 0 || this.motionZ != 0) //TODO replace zero with range check to prevent rounding issues
        {
            reduceMotion();
            correctMotion();
            updateBoundsForMotion();
        }
    }

    //<editor-fold desc="motion">
    private void reduceMotion()
    {
        this.motionX *= SPEED_REDUCTION;
        this.motionY *= SPEED_REDUCTION;
        this.motionZ *= SPEED_REDUCTION;
    }

    private void correctMotion()
    {
        //TODO see if we can remove the sqrt and if the limit should be in an if-statement

        //Normalize motion as a speed value
        final float speed = MathHelper.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
        this.motionX /= speed;
        this.motionY /= speed;
        this.motionZ /= speed;

        //Limit our velocity vector by the updated speed
        final float limitedSpeed = Math.min(speed, MAX_SPEED);
        this.motionX *= limitedSpeed;
        this.motionY *= limitedSpeed;
        this.motionZ *= limitedSpeed;
    }

    private void updateBoundsForMotion()
    {
        this.setEntityBoundingBox(this.getEntityBoundingBox().offset(motionX, motionY, motionZ));

        //Reset position based on box
        this.posX = (this.getEntityBoundingBox().minX + this.getEntityBoundingBox().maxX) / 2.0D;
        this.posY = (this.getEntityBoundingBox().minY + this.getEntityBoundingBox().maxY) / 2.0D;
        this.posZ = (this.getEntityBoundingBox().minZ + this.getEntityBoundingBox().maxZ) / 2.0D;
    }
    //</editor-fold>

    //<editor-fold desc="saving">
    @Override
    protected void readEntityFromNBT(NBTTagCompound nbt)
    {
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbt)
    {

    }
    //</editor-fold>

    //<editor-fold desc="disabled-props">
    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }

    @Override
    public boolean canBeCollidedWith()
    {
        return false;
    }


    @Override
    public void move(MoverType type, double x, double y, double z)
    {
        //Remove default movement
    }
    //</editor-fold>

    //<editor-fold desc="cap-system">
    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)
    {
        return capability == ICBMClassicAPI.BLAST_CAPABILITY
                || capability == ICBMClassicAPI.BLAST_VELOCITY_CAPABILITY
                || super.hasCapability(capability, facing);
    }

    @Override
    @Nullable
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
    {
        if (capability == ICBMClassicAPI.BLAST_CAPABILITY)
        {
            return ICBMClassicAPI.BLAST_CAPABILITY.cast(blastData);
        }
        else if (capability == ICBMClassicAPI.BLAST_VELOCITY_CAPABILITY)
        {
            return ICBMClassicAPI.BLAST_VELOCITY_CAPABILITY.cast(capRedmatterPull);
        }
        return super.getCapability(capability, facing);
    }
    //</editor-fold>

    public float getBlastSize()
    {
        return this.dataManager.get(SIZE_DATA);
    }

    public void setBlastSize(float size)
    {
        this.dataManager.set(SIZE_DATA, Math.max(1, size));
    }
}
