package icbm.explosion.model.missiles;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import icbm.core.prefab.render.ModelICBM;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class MMWan extends ModelICBM
{
    // fields
    ModelRenderer MAIN_MODULE;
    ModelRenderer MOTOR_MODULE_1;
    ModelRenderer MOTOR_MODULE_2;
    ModelRenderer MOTOR_MODULE_3;
    ModelRenderer MOTOR_MODULE_4;
    ModelRenderer C1;
    ModelRenderer C2;
    ModelRenderer C3;
    ModelRenderer C4;
    ModelRenderer T1;
    ModelRenderer T2;
    ModelRenderer T3;
    ModelRenderer T4;
    ModelRenderer WING_1A;
    ModelRenderer WING_2A;
    ModelRenderer WING_1B;
    ModelRenderer WING_2B;
    ModelRenderer WING_3A;
    ModelRenderer WING_3B;
    ModelRenderer WING_4B;
    ModelRenderer WING_4A;
    ModelRenderer TOP;
    ModelRenderer TOP_WINGS_1;
    ModelRenderer TOP_WINGS_2;
    ModelRenderer TOP_SUPPORT_1;
    ModelRenderer TOP_SUPPORT_2;
    ModelRenderer TOP_SUPPORT_3;
    ModelRenderer TOP_SUPPORT_4;
    ModelRenderer TOP_WINGS_A;
    ModelRenderer TOP_WINGS_B;
    ModelRenderer TOP_WINGS_C;
    ModelRenderer TOP_WINGS_D;
    ModelRenderer PORTAL_CORE_ROT;

    public MMWan()
    {
        textureWidth = 128;
        textureHeight = 128;

        MAIN_MODULE = new ModelRenderer(this, 0, 0);
        MAIN_MODULE.addBox(0F, 0F, 0F, 8, 70, 8);
        MAIN_MODULE.setRotationPoint(-4F, -63F, -4F);
        MAIN_MODULE.setTextureSize(128, 128);
        MAIN_MODULE.mirror = true;
        setRotation(MAIN_MODULE, 0F, 0F, 0F);
        MOTOR_MODULE_1 = new ModelRenderer(this, 0, 79);
        MOTOR_MODULE_1.addBox(0F, 0F, 0F, 6, 20, 6);
        MOTOR_MODULE_1.setRotationPoint(-8F, 0F, -8F);
        MOTOR_MODULE_1.setTextureSize(128, 128);
        MOTOR_MODULE_1.mirror = true;
        setRotation(MOTOR_MODULE_1, 0F, 0F, 0F);
        MOTOR_MODULE_2 = new ModelRenderer(this, 0, 79);
        MOTOR_MODULE_2.addBox(0F, 0F, 0F, 6, 20, 6);
        MOTOR_MODULE_2.setRotationPoint(-8F, 0F, 2F);
        MOTOR_MODULE_2.setTextureSize(128, 128);
        MOTOR_MODULE_2.mirror = true;
        setRotation(MOTOR_MODULE_2, 0F, 0F, 0F);
        MOTOR_MODULE_3 = new ModelRenderer(this, 0, 79);
        MOTOR_MODULE_3.addBox(0F, 0F, 0F, 6, 20, 6);
        MOTOR_MODULE_3.setRotationPoint(2F, 0F, -8F);
        MOTOR_MODULE_3.setTextureSize(128, 128);
        MOTOR_MODULE_3.mirror = true;
        setRotation(MOTOR_MODULE_3, 0F, 0F, 0F);
        MOTOR_MODULE_4 = new ModelRenderer(this, 0, 79);
        MOTOR_MODULE_4.addBox(0F, 0F, 0F, 6, 20, 6);
        MOTOR_MODULE_4.setRotationPoint(2F, 0F, 2F);
        MOTOR_MODULE_4.setTextureSize(128, 128);
        MOTOR_MODULE_4.mirror = true;
        setRotation(MOTOR_MODULE_4, 0F, 0F, 0F);
        C1 = new ModelRenderer(this, 0, 106);
        C1.addBox(0F, 0F, 0F, 2, 1, 2);
        C1.setRotationPoint(-6F, 20F, -6F);
        C1.setTextureSize(128, 128);
        C1.mirror = true;
        setRotation(C1, 0F, 0F, 0F);
        C2 = new ModelRenderer(this, 0, 106);
        C2.addBox(0F, 0F, 0F, 2, 1, 2);
        C2.setRotationPoint(-6F, 20F, 4F);
        C2.setTextureSize(128, 128);
        C2.mirror = true;
        setRotation(C2, 0F, 0F, 0F);
        C3 = new ModelRenderer(this, 0, 106);
        C3.addBox(0F, 0F, 0F, 2, 1, 2);
        C3.setRotationPoint(4F, 20F, -6F);
        C3.setTextureSize(128, 128);
        C3.mirror = true;
        setRotation(C3, 0F, 0F, 0F);
        C4 = new ModelRenderer(this, 0, 106);
        C4.addBox(0F, 0F, 0F, 2, 1, 2);
        C4.setRotationPoint(4F, 20F, 4F);
        C4.setTextureSize(128, 128);
        C4.mirror = true;
        setRotation(C4, 0F, 0F, 0F);
        T1 = new ModelRenderer(this, 0, 111);
        T1.addBox(0F, 0F, 0F, 4, 3, 4);
        T1.setRotationPoint(-7F, 21F, -7F);
        T1.setTextureSize(128, 128);
        T1.mirror = true;
        setRotation(T1, 0F, 0F, 0F);
        T2 = new ModelRenderer(this, 0, 111);
        T2.addBox(0F, 0F, 0F, 4, 3, 4);
        T2.setRotationPoint(-7F, 21F, 3F);
        T2.setTextureSize(128, 128);
        T2.mirror = true;
        setRotation(T2, 0F, 0F, 0F);
        T3 = new ModelRenderer(this, 0, 111);
        T3.addBox(0F, 0F, 0F, 4, 3, 4);
        T3.setRotationPoint(3F, 21F, -7F);
        T3.setTextureSize(128, 128);
        T3.mirror = true;
        setRotation(T3, 0F, 0F, 0F);
        T4 = new ModelRenderer(this, 0, 111);
        T4.addBox(0F, 0F, 0F, 4, 3, 4);
        T4.setRotationPoint(3F, 21F, 3F);
        T4.setTextureSize(128, 128);
        T4.mirror = true;
        setRotation(T4, 0F, 0F, 0F);
        WING_1A = new ModelRenderer(this, 43, 15);
        WING_1A.addBox(-1F, 0F, 0F, 2, 12, 12);
        WING_1A.setRotationPoint(0F, -10F, 0F);
        WING_1A.setTextureSize(128, 128);
        WING_1A.mirror = true;
        setRotation(WING_1A, -0.7853982F, 0F, 0F);
        WING_2A = new ModelRenderer(this, 43, 0);
        WING_2A.addBox(0F, 0F, -1F, 12, 12, 2);
        WING_2A.setRotationPoint(0F, -10F, 0F);
        WING_2A.setTextureSize(128, 128);
        WING_2A.mirror = true;
        setRotation(WING_2A, 0F, 0F, 0.7853982F);
        WING_1B = new ModelRenderer(this, 72, 28);
        WING_1B.addBox(-1F, 0F, -8F, 2, 25, 16);
        WING_1B.setRotationPoint(0F, -2F, 0F);
        WING_1B.setTextureSize(128, 128);
        WING_1B.mirror = true;
        setRotation(WING_1B, 0F, 0F, 0F);
        WING_2B = new ModelRenderer(this, 72, 0);
        WING_2B.addBox(-8F, 0F, -1F, 16, 25, 2);
        WING_2B.setRotationPoint(0F, -2F, 0F);
        WING_2B.setTextureSize(128, 128);
        WING_2B.mirror = true;
        setRotation(WING_2B, 0F, 0F, 0F);
        WING_3A = new ModelRenderer(this, 34, 55);
        WING_3A.addBox(-1F, 0F, -8F, 2, 10, 16);
        WING_3A.setRotationPoint(0F, -41F, 0F);
        WING_3A.setTextureSize(128, 128);
        WING_3A.mirror = true;
        setRotation(WING_3A, 0F, 0F, 0F);
        WING_3B = new ModelRenderer(this, 34, 82);
        WING_3B.addBox(-1F, -6F, -6F, 2, 12, 12);
        WING_3B.setRotationPoint(0F, -41F, 0F);
        WING_3B.setTextureSize(128, 128);
        WING_3B.mirror = true;
        setRotation(WING_3B, 0.7853982F, 0F, 0F);
        WING_4B = new ModelRenderer(this, 34, 41);
        WING_4B.addBox(-8F, 0F, -1F, 16, 10, 2);
        WING_4B.setRotationPoint(0F, -41F, 0F);
        WING_4B.setTextureSize(128, 128);
        WING_4B.mirror = true;
        setRotation(WING_4B, 0F, 0F, 0F);
        WING_4A = new ModelRenderer(this, 34, 107);
        WING_4A.addBox(-6F, -6F, -1F, 12, 12, 2);
        WING_4A.setRotationPoint(0F, -41F, 0F);
        WING_4A.setTextureSize(128, 128);
        WING_4A.mirror = true;
        setRotation(WING_4A, 0F, 0F, -0.7853982F);
        TOP = new ModelRenderer(this, 72, 70);
        TOP.addBox(0F, 0F, 0F, 10, 10, 10);
        TOP.setRotationPoint(-5F, -64F, -5F);
        TOP.setTextureSize(128, 128);
        TOP.mirror = true;
        setRotation(TOP, 0F, 0F, 0F);
        TOP_WINGS_1 = new ModelRenderer(this, 87, 92);
        TOP_WINGS_1.addBox(0F, 0F, 0F, 14, 12, 2);
        TOP_WINGS_1.setRotationPoint(-7F, -64F, -1F);
        TOP_WINGS_1.setTextureSize(128, 128);
        TOP_WINGS_1.mirror = true;
        setRotation(TOP_WINGS_1, 0F, 0F, 0F);
        TOP_WINGS_2 = new ModelRenderer(this, 65, 101);
        TOP_WINGS_2.addBox(0F, 0F, 0F, 2, 12, 14);
        TOP_WINGS_2.setRotationPoint(-1F, -64F, -7F);
        TOP_WINGS_2.setTextureSize(128, 128);
        TOP_WINGS_2.mirror = true;
        setRotation(TOP_WINGS_2, 0F, 0F, 0F);
        TOP_SUPPORT_1 = new ModelRenderer(this, 74, 91);
        TOP_SUPPORT_1.addBox(0F, 0F, 0F, 2, 6, 2);
        TOP_SUPPORT_1.setRotationPoint(-5F, -70F, -1F);
        TOP_SUPPORT_1.setTextureSize(128, 128);
        TOP_SUPPORT_1.mirror = true;
        setRotation(TOP_SUPPORT_1, 0F, 0F, 0F);
        TOP_SUPPORT_2 = new ModelRenderer(this, 74, 91);
        TOP_SUPPORT_2.addBox(0F, 0F, 0F, 2, 6, 2);
        TOP_SUPPORT_2.setRotationPoint(-1F, -70F, 3F);
        TOP_SUPPORT_2.setTextureSize(128, 128);
        TOP_SUPPORT_2.mirror = true;
        setRotation(TOP_SUPPORT_2, 0F, 0F, 0F);
        TOP_SUPPORT_3 = new ModelRenderer(this, 74, 91);
        TOP_SUPPORT_3.addBox(0F, 0F, 0F, 2, 6, 2);
        TOP_SUPPORT_3.setRotationPoint(3F, -70F, -1F);
        TOP_SUPPORT_3.setTextureSize(128, 128);
        TOP_SUPPORT_3.mirror = true;
        setRotation(TOP_SUPPORT_3, 0F, 0F, 0F);
        TOP_SUPPORT_4 = new ModelRenderer(this, 74, 91);
        TOP_SUPPORT_4.addBox(0F, 0F, 0F, 2, 6, 2);
        TOP_SUPPORT_4.setRotationPoint(-1F, -70F, -5F);
        TOP_SUPPORT_4.setTextureSize(128, 128);
        TOP_SUPPORT_4.mirror = true;
        setRotation(TOP_SUPPORT_4, 0F, 0F, 0F);
        TOP_WINGS_A = new ModelRenderer(this, 64, 91);
        TOP_WINGS_A.addBox(0F, 0F, 0F, 2, 3, 2);
        TOP_WINGS_A.setRotationPoint(-5F, -66F, -1F);
        TOP_WINGS_A.setTextureSize(128, 128);
        TOP_WINGS_A.mirror = true;
        setRotation(TOP_WINGS_A, 0F, 0F, 0.7853982F);
        TOP_WINGS_B = new ModelRenderer(this, 64, 91);
        TOP_WINGS_B.addBox(0F, 0F, -2F, 2, 3, 2);
        TOP_WINGS_B.setRotationPoint(-1F, -66F, 5F);
        TOP_WINGS_B.setTextureSize(128, 128);
        TOP_WINGS_B.mirror = true;
        setRotation(TOP_WINGS_B, 0.7853982F, 0F, 0F);
        TOP_WINGS_C = new ModelRenderer(this, 64, 91);
        TOP_WINGS_C.addBox(-2F, 0F, 0F, 2, 3, 2);
        TOP_WINGS_C.setRotationPoint(5F, -66F, -1F);
        TOP_WINGS_C.setTextureSize(128, 128);
        TOP_WINGS_C.mirror = true;
        setRotation(TOP_WINGS_C, 0F, 0F, -0.7853982F);
        TOP_WINGS_D = new ModelRenderer(this, 64, 91);
        TOP_WINGS_D.addBox(0F, 0F, 0F, 2, 3, 2);
        TOP_WINGS_D.setRotationPoint(-1F, -66F, -5F);
        TOP_WINGS_D.setTextureSize(128, 128);
        TOP_WINGS_D.mirror = true;
        setRotation(TOP_WINGS_D, -0.7853982F, 0F, 0F);
        PORTAL_CORE_ROT = new ModelRenderer(this, 99, 107);
        PORTAL_CORE_ROT.addBox(-3F, -3F, -3F, 6, 6, 6);
        PORTAL_CORE_ROT.setRotationPoint(0F, -74F, 0F);
        PORTAL_CORE_ROT.setTextureSize(128, 128);
        PORTAL_CORE_ROT.mirror = true;
        setRotation(PORTAL_CORE_ROT, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        this.render(f5);
    }

    @Override
    public void render(float f5)
    {
        MAIN_MODULE.render(f5);
        MOTOR_MODULE_1.render(f5);
        MOTOR_MODULE_2.render(f5);
        MOTOR_MODULE_3.render(f5);
        MOTOR_MODULE_4.render(f5);
        C1.render(f5);
        C2.render(f5);
        C3.render(f5);
        C4.render(f5);
        T1.render(f5);
        T2.render(f5);
        T3.render(f5);
        T4.render(f5);
        WING_1A.render(f5);
        WING_2A.render(f5);
        WING_1B.render(f5);
        WING_2B.render(f5);
        WING_3A.render(f5);
        WING_3B.render(f5);
        WING_4B.render(f5);
        WING_4A.render(f5);
        TOP.render(f5);
        TOP_WINGS_1.render(f5);
        TOP_WINGS_2.render(f5);
        TOP_SUPPORT_1.render(f5);
        TOP_SUPPORT_2.render(f5);
        TOP_SUPPORT_3.render(f5);
        TOP_SUPPORT_4.render(f5);
        TOP_WINGS_A.render(f5);
        TOP_WINGS_B.render(f5);
        TOP_WINGS_C.render(f5);
        TOP_WINGS_D.render(f5);
        PORTAL_CORE_ROT.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
