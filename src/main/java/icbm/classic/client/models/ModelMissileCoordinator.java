package icbm.classic.client.models;

import net.minecraft.client.model.ModelRenderer;

public class ModelMissileCoordinator extends ModelICBM
{
    // fields
    ModelRenderer Stand2;
    ModelRenderer Stand1;
    ModelRenderer Console6;
    ModelRenderer Stand3;
    ModelRenderer Console1;
    ModelRenderer Console3;
    ModelRenderer Screen1;
    ModelRenderer Screen2;
    ModelRenderer Radio1;
    ModelRenderer Radio_Cable2;
    ModelRenderer Radio_Antennae;
    ModelRenderer Radio2;
    ModelRenderer Radio_Antennae2;
    ModelRenderer Keyboard;
    ModelRenderer Button5;
    ModelRenderer Button4;
    ModelRenderer Button14;
    ModelRenderer Button15;
    ModelRenderer Button13;
    ModelRenderer Console5;
    ModelRenderer Console4;
    ModelRenderer Button8;
    ModelRenderer Button2;
    ModelRenderer Button7;
    ModelRenderer Button1;
    ModelRenderer Button11;
    ModelRenderer Button12;
    ModelRenderer Button10;
    ModelRenderer Button16;
    ModelRenderer Button17;
    ModelRenderer Button18;
    ModelRenderer Standend2;
    ModelRenderer Standend1;
    ModelRenderer Console2;
    ModelRenderer Radio_Cable;

    public ModelMissileCoordinator()
    {
        textureWidth = 64;
        textureHeight = 32;

        Stand2 = new ModelRenderer(this, 0, 9);
        Stand2.addBox(-1F, 0F, -10F, 2, 1, 17);
        Stand2.setRotationPoint(0F, 23F, 0F);
        Stand2.setTextureSize(64, 32);
        Stand2.mirror = true;
        setRotation(Stand2, 0F, 0.7853982F, 0F);
        Stand1 = new ModelRenderer(this, 0, 9);
        Stand1.addBox(-1F, 0F, -10F, 2, 1, 17);
        Stand1.setRotationPoint(0F, 23F, 0F);
        Stand1.setTextureSize(64, 32);
        Stand1.mirror = true;
        setRotation(Stand1, 0F, -0.7853982F, 0F);
        Console6 = new ModelRenderer(this, 12, 30);
        Console6.addBox(0.75F, -1.1F, 0.8F, 1, 1, 1);
        Console6.setRotationPoint(0F, 20F, 1F);
        Console6.setTextureSize(64, 32);
        Console6.mirror = true;
        setRotation(Console6, 0.1396263F, 0F, 0F);
        Stand3 = new ModelRenderer(this, 56, 15);
        Stand3.addBox(-1F, -5F, -1F, 2, 6, 2);
        Stand3.setRotationPoint(0F, 23F, 0F);
        Stand3.setTextureSize(64, 32);
        Stand3.mirror = true;
        setRotation(Stand3, -0.7853982F, 0F, 0F);
        Console1 = new ModelRenderer(this, 12, 30);
        Console1.addBox(0.8F, -1.1F, 0.8F, 1, 1, 1);
        Console1.setRotationPoint(-3.8F, 20F, -0.6F);
        Console1.setTextureSize(64, 32);
        Console1.mirror = true;
        setRotation(Console1, 0.1396263F, -0.7853982F, 0F);
        Console3 = new ModelRenderer(this, 12, 30);
        Console3.addBox(0.8F, -1.1F, 0.8F, 1, 1, 1);
        Console3.setRotationPoint(3.85F, 20F, -0.6F);
        Console3.setTextureSize(64, 32);
        Console3.mirror = true;
        setRotation(Console3, 0.1396263F, 0.7853982F, 0F);
        Screen1 = new ModelRenderer(this, 0, 27);
        Screen1.addBox(-7F, -3F, 0F, 6, 5, 0);
        Screen1.setRotationPoint(0F, 15F, 4F);
        Screen1.setTextureSize(64, 32);
        Screen1.mirror = true;
        setRotation(Screen1, 0F, -0.2792527F, 0F);
        Screen2 = new ModelRenderer(this, 0, 27);
        Screen2.addBox(1F, -3F, 0F, 6, 5, 0);
        Screen2.setRotationPoint(0F, 15F, 4F);
        Screen2.setTextureSize(64, 32);
        Screen2.mirror = true;
        setRotation(Screen2, 0F, 0.2792527F, 0F);
        Radio1 = new ModelRenderer(this, 50, 23);
        Radio1.addBox(-1F, 0F, -1F, 4, 6, 3);
        Radio1.setRotationPoint(-4F, 24F, 5F);
        Radio1.setTextureSize(64, 32);
        Radio1.mirror = true;
        setRotation(Radio1, 0F, 0F, 3.141593F);
        Radio_Cable2 = new ModelRenderer(this, 12, 20);
        Radio_Cable2.addBox(-0.5F, 0F, -0.5F, 1, 5, 1);
        Radio_Cable2.setRotationPoint(-3.5F, 22F, 5F);
        Radio_Cable2.setTextureSize(64, 32);
        Radio_Cable2.mirror = true;
        setRotation(Radio_Cable2, -1.570796F, -0.7853982F, 3.141593F);
        Radio_Antennae = new ModelRenderer(this, 46, 27);
        Radio_Antennae.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        Radio_Antennae.setRotationPoint(-6F, 18F, 5.5F);
        Radio_Antennae.setTextureSize(64, 32);
        Radio_Antennae.mirror = true;
        setRotation(Radio_Antennae, 0F, 0F, 3.141593F);
        Radio2 = new ModelRenderer(this, 50, 23);
        Radio2.addBox(-1F, 0F, -1F, 4, 6, 3);
        Radio2.setRotationPoint(6F, 24F, 5F);
        Radio2.setTextureSize(64, 32);
        Radio2.mirror = true;
        setRotation(Radio2, 0F, 0F, 3.141593F);
        Radio_Antennae2 = new ModelRenderer(this, 46, 27);
        Radio_Antennae2.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        Radio_Antennae2.setRotationPoint(5.75F, 18F, 5.5F);
        Radio_Antennae2.setTextureSize(64, 32);
        Radio_Antennae2.mirror = true;
        setRotation(Radio_Antennae2, 0F, 0F, 3.141593F);
        Keyboard = new ModelRenderer(this, 21, 23);
        Keyboard.addBox(-4F, -1F, 0F, 8, 1, 2);
        Keyboard.setRotationPoint(0F, 20F, 0F);
        Keyboard.setTextureSize(64, 32);
        Keyboard.mirror = true;
        setRotation(Keyboard, 3.141593F, 0F, 0F);
        Button5 = new ModelRenderer(this, 12, 30);
        Button5.addBox(-0.5F, -1.1F, 0.8F, 1, 1, 1);
        Button5.setRotationPoint(0F, 20F, 1F);
        Button5.setTextureSize(64, 32);
        Button5.mirror = true;
        setRotation(Button5, 0.1396263F, 0F, 0F);
        Button4 = new ModelRenderer(this, 12, 30);
        Button4.addBox(-1.8F, -1.1F, 0.8F, 1, 1, 1);
        Button4.setRotationPoint(0F, 20F, 1F);
        Button4.setTextureSize(64, 32);
        Button4.mirror = true;
        setRotation(Button4, 0.1396263F, 0F, 0F);
        Button14 = new ModelRenderer(this, 12, 30);
        Button14.addBox(-0.5F, -1.1F, -0.5F, 1, 1, 1);
        Button14.setRotationPoint(0F, 20F, 1F);
        Button14.setTextureSize(64, 32);
        Button14.mirror = true;
        setRotation(Button14, 0.1396263F, 0F, 0F);
        Button15 = new ModelRenderer(this, 12, 30);
        Button15.addBox(0.75F, -1.1F, -0.5F, 1, 1, 1);
        Button15.setRotationPoint(0F, 20F, 1F);
        Button15.setTextureSize(64, 32);
        Button15.mirror = true;
        setRotation(Button15, 0.1396263F, 0F, 0F);
        Button13 = new ModelRenderer(this, 12, 30);
        Button13.addBox(-1.8F, -1.1F, -0.5F, 1, 1, 1);
        Button13.setRotationPoint(0F, 20F, 1F);
        Button13.setTextureSize(64, 32);
        Button13.mirror = true;
        setRotation(Button13, 0.1396263F, 0F, 0F);
        Console5 = new ModelRenderer(this, 16, 28);
        Console5.addBox(-3F, -1F, -1F, 6, 1, 3);
        Console5.setRotationPoint(3.85F, 20F, -0.6F);
        Console5.setTextureSize(64, 32);
        Console5.mirror = true;
        setRotation(Console5, 0.1396263F, 0.7853982F, 0F);
        Console4 = new ModelRenderer(this, 16, 28);
        Console4.addBox(-3F, -1F, -1F, 6, 1, 3);
        Console4.setRotationPoint(-3.8F, 20F, -0.6F);
        Console4.setTextureSize(64, 32);
        Console4.mirror = true;
        setRotation(Console4, 0.1396263F, -0.7853982F, 0F);
        Button8 = new ModelRenderer(this, 12, 30);
        Button8.addBox(-0.5F, -1.1F, 0.8F, 1, 1, 1);
        Button8.setRotationPoint(3.85F, 20F, -0.6F);
        Button8.setTextureSize(64, 32);
        Button8.mirror = true;
        setRotation(Button8, 0.1396263F, 0.7853982F, 0F);
        Button2 = new ModelRenderer(this, 12, 30);
        Button2.addBox(-0.5F, -1.1F, 0.8F, 1, 1, 1);
        Button2.setRotationPoint(-3.8F, 20F, -0.6F);
        Button2.setTextureSize(64, 32);
        Button2.mirror = true;
        setRotation(Button2, 0.1396263F, -0.7853982F, 0F);
        Button7 = new ModelRenderer(this, 12, 30);
        Button7.addBox(-1.8F, -1.1F, 0.8F, 1, 1, 1);
        Button7.setRotationPoint(3.85F, 20F, -0.6F);
        Button7.setTextureSize(64, 32);
        Button7.mirror = true;
        setRotation(Button7, 0.1396263F, 0.7853982F, 0F);
        Button1 = new ModelRenderer(this, 12, 30);
        Button1.addBox(-1.8F, -1.1F, 0.8F, 1, 1, 1);
        Button1.setRotationPoint(-3.8F, 20F, -0.6F);
        Button1.setTextureSize(64, 32);
        Button1.mirror = true;
        setRotation(Button1, 0.1396263F, -0.7853982F, 0F);
        Button11 = new ModelRenderer(this, 12, 30);
        Button11.addBox(-0.5F, -1.1F, -0.5F, 1, 1, 1);
        Button11.setRotationPoint(-3.8F, 20F, -0.6F);
        Button11.setTextureSize(64, 32);
        Button11.mirror = true;
        setRotation(Button11, 0.1396263F, -0.7853982F, 0F);
        Button12 = new ModelRenderer(this, 12, 30);
        Button12.addBox(0.8F, -1.1F, -0.5F, 1, 1, 1);
        Button12.setRotationPoint(-3.8F, 20F, -0.6F);
        Button12.setTextureSize(64, 32);
        Button12.mirror = true;
        setRotation(Button12, 0.1396263F, -0.7853982F, 0F);
        Button10 = new ModelRenderer(this, 12, 30);
        Button10.addBox(-1.8F, -1.1F, -0.5F, 1, 1, 1);
        Button10.setRotationPoint(-3.8F, 20F, -0.6F);
        Button10.setTextureSize(64, 32);
        Button10.mirror = true;
        setRotation(Button10, 0.1396263F, -0.7853982F, 0F);
        Button16 = new ModelRenderer(this, 12, 30);
        Button16.addBox(-1.8F, -1.1F, -0.5F, 1, 1, 1);
        Button16.setRotationPoint(3.85F, 20F, -0.6F);
        Button16.setTextureSize(64, 32);
        Button16.mirror = true;
        setRotation(Button16, 0.1396263F, 0.7853982F, 0F);
        Button17 = new ModelRenderer(this, 12, 30);
        Button17.addBox(-0.5F, -1.1F, -0.5F, 1, 1, 1);
        Button17.setRotationPoint(3.85F, 20F, -0.6F);
        Button17.setTextureSize(64, 32);
        Button17.mirror = true;
        setRotation(Button17, 0.1396263F, 0.7853982F, 0F);
        Button18 = new ModelRenderer(this, 12, 30);
        Button18.addBox(0.8F, -1.1F, -0.5F, 1, 1, 1);
        Button18.setRotationPoint(3.85F, 20F, -0.6F);
        Button18.setTextureSize(64, 32);
        Button18.mirror = true;
        setRotation(Button18, 0.1396263F, 0.7853982F, 0F);
        Standend2 = new ModelRenderer(this, 0, 21);
        Standend2.addBox(0F, 0F, 0F, 3, 2, 3);
        Standend2.setRotationPoint(4.9F, 22.9F, -7.9F);
        Standend2.setTextureSize(64, 32);
        Standend2.mirror = true;
        setRotation(Standend2, 0F, 0F, 0F);
        Standend1 = new ModelRenderer(this, 0, 21);
        Standend1.addBox(0F, 0F, 0F, 3, 2, 3);
        Standend1.setRotationPoint(-7.9F, 22.9F, -7.9F);
        Standend1.setTextureSize(64, 32);
        Standend1.mirror = true;
        setRotation(Standend1, 0F, 0F, 0F);
        Console2 = new ModelRenderer(this, 16, 28);
        Console2.addBox(-3F, -1F, -1F, 6, 1, 3);
        Console2.setRotationPoint(0F, 20F, 1F);
        Console2.setTextureSize(64, 32);
        Console2.mirror = true;
        setRotation(Console2, 0.1396263F, 0F, 0F);
        Radio_Cable = new ModelRenderer(this, 12, 20);
        Radio_Cable.addBox(-0.5F, 0F, -0.5F, 1, 5, 1);
        Radio_Cable.setRotationPoint(3.5F, 22F, 5F);
        Radio_Cable.setTextureSize(64, 32);
        Radio_Cable.mirror = true;
        setRotation(Radio_Cable, -1.570796F, 0.7853982F, 3.141593F);
    }

    public void render(float rotation, float f5)
    {
        Stand2.render(f5);
        Stand1.render(f5);
        Console6.render(f5);
        Stand3.render(f5);
        Console1.render(f5);
        Console3.render(f5);
        Screen1.render(f5);
        Screen2.render(f5);
        Radio1.render(f5);
        Radio_Cable2.render(f5);
        Radio_Antennae.render(f5);
        Radio2.render(f5);
        Radio_Antennae2.render(f5);
        Keyboard.render(f5);
        Button5.render(f5);
        Button4.render(f5);
        Button14.render(f5);
        Button15.render(f5);
        Button13.render(f5);
        Console5.render(f5);
        Console4.render(f5);
        Button8.render(f5);
        Button2.render(f5);
        Button7.render(f5);
        Button1.render(f5);
        Button11.render(f5);
        Button12.render(f5);
        Button10.render(f5);
        Button16.render(f5);
        Button17.render(f5);
        Button18.render(f5);
        Standend2.render(f5);
        Standend1.render(f5);
        Console2.render(f5);
        Radio_Cable.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
