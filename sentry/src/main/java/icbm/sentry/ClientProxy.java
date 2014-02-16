package icbm.sentry;

import calclavia.lib.render.FxLaser;
import calclavia.lib.render.item.GlobalItemRenderer;
import calclavia.lib.render.item.ISimpleItemRenderer;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import icbm.core.prefab.EmptyRenderer;
import icbm.sentry.render.SentryRenderAAGun;
import icbm.sentry.render.SentryRenderGunTurret;
import icbm.sentry.render.SentryRenderLaserTurret;
import icbm.sentry.render.SentryRenderRailGun;
import icbm.sentry.turret.EntitySentryFake;
import icbm.sentry.turret.SentryRegistry;
import icbm.sentry.turret.block.RenderSentry;
import icbm.sentry.turret.block.TileSentry;
import icbm.sentry.turret.modules.AutoSentryAntiAir;
import icbm.sentry.turret.modules.AutoSentryClassic;
import icbm.sentry.turret.modules.AutoSentryTwinLaser;
import icbm.sentry.turret.modules.mount.MountedRailGun;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import universalelectricity.api.vector.Vector3;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit()
    {
        super.preInit();
    }

    @Override
    public void init()
    {
        super.init();

        /** TileEntities */
        RenderingRegistry.registerEntityRenderingHandler(EntitySentryFake.class, new EmptyRenderer());

        //Sentry render registry TODO find a way to automate
        SentryRegistry.registerSentryRenderer(AutoSentryAntiAir.class, new SentryRenderAAGun());
        SentryRegistry.registerSentryRenderer(AutoSentryClassic.class, new SentryRenderGunTurret());
        SentryRegistry.registerSentryRenderer(AutoSentryTwinLaser.class, new SentryRenderLaserTurret());
        SentryRegistry.registerSentryRenderer(MountedRailGun.class, new SentryRenderRailGun());
        
        GlobalItemRenderer.register(ICBMSentry.blockTurret.blockID, new ISimpleItemRenderer()
		{
			@Override
			public void renderInventoryItem(ItemStack itemStack)
			{
			}
		});
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {

        return null;
    }

    @Override
    public void renderBeam(World world, Vector3 position, Vector3 target, float red, float green, float blue, int age)
    {
        FMLClientHandler.instance().getClient().effectRenderer.addEffect(new FxLaser(world, position, target, red, green, blue, age));
    }
}