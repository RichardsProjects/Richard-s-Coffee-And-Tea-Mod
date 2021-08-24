package net.richardsprojects.teamod.model.cups;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelHalfCoffeeCup extends ModelBase
{
  //fields
    ModelRenderer PlateBottom;
    ModelRenderer CupBottom;
    ModelRenderer CupSide1;
    ModelRenderer CupSide2;
    ModelRenderer CupSide3;
    ModelRenderer CupSide4;
    ModelRenderer PlateSide1;
    ModelRenderer PlateSide2;
    ModelRenderer PlateSide3;
    ModelRenderer PlateSide4;
    ModelRenderer Handle1;
    ModelRenderer Handle2;
    ModelRenderer Handle3;
    ModelRenderer Liquid;
  
  public ModelHalfCoffeeCup()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      PlateBottom = new ModelRenderer(this, 0, 0);
      PlateBottom.addBox(0F, 0F, 0F, 8, 1, 8);
      PlateBottom.setRotationPoint(-4F, 23F, -4F);
      PlateBottom.setTextureSize(64, 32);
      PlateBottom.mirror = true;
      setRotation(PlateBottom, 0F, 0F, 0F);
      CupBottom = new ModelRenderer(this, 0, 0);
      CupBottom.addBox(0F, 0F, 0F, 4, 1, 4);
      CupBottom.setRotationPoint(-2F, 22F, -2F);
      CupBottom.setTextureSize(64, 32);
      CupBottom.mirror = true;
      setRotation(CupBottom, 0F, 0F, 0F);
      CupSide1 = new ModelRenderer(this, 0, 0);
      CupSide1.addBox(0F, 0F, 0F, 1, 6, 4);
      CupSide1.setRotationPoint(2F, 16F, -2F);
      CupSide1.setTextureSize(64, 32);
      CupSide1.mirror = true;
      setRotation(CupSide1, 0F, 0F, 0F);
      CupSide2 = new ModelRenderer(this, 0, 0);
      CupSide2.addBox(0F, 0F, 0F, 4, 6, 1);
      CupSide2.setRotationPoint(-2F, 16F, -3F);
      CupSide2.setTextureSize(64, 32);
      CupSide2.mirror = true;
      setRotation(CupSide2, 0F, 0F, 0F);
      CupSide3 = new ModelRenderer(this, 0, 0);
      CupSide3.addBox(0F, 0F, 0F, 4, 6, 1);
      CupSide3.setRotationPoint(-2F, 16F, 2F);
      CupSide3.setTextureSize(64, 32);
      CupSide3.mirror = true;
      setRotation(CupSide3, 0F, 0F, 0F);
      CupSide4 = new ModelRenderer(this, 0, 0);
      CupSide4.addBox(0F, 0F, 0F, 1, 6, 4);
      CupSide4.setRotationPoint(-3F, 16F, -2F);
      CupSide4.setTextureSize(64, 32);
      CupSide4.mirror = true;
      setRotation(CupSide4, 0F, 0F, 0F);
      PlateSide1 = new ModelRenderer(this, 0, 0);
      PlateSide1.addBox(0F, 0F, 0F, 1, 1, 10);
      PlateSide1.setRotationPoint(4F, 22F, -5F);
      PlateSide1.setTextureSize(64, 32);
      PlateSide1.mirror = true;
      setRotation(PlateSide1, 0F, 0F, 0F);
      PlateSide2 = new ModelRenderer(this, 0, 0);
      PlateSide2.addBox(0F, 0F, 0F, 9, 1, 1);
      PlateSide2.setRotationPoint(-5F, 22F, 4F);
      PlateSide2.setTextureSize(64, 32);
      PlateSide2.mirror = true;
      setRotation(PlateSide2, 0F, 0F, 0F);
      PlateSide3 = new ModelRenderer(this, 0, 0);
      PlateSide3.addBox(0F, 0F, 0F, 9, 1, 1);
      PlateSide3.setRotationPoint(-5F, 22F, -5F);
      PlateSide3.setTextureSize(64, 32);
      PlateSide3.mirror = true;
      setRotation(PlateSide3, 0F, 0F, 0F);
      PlateSide4 = new ModelRenderer(this, 0, 0);
      PlateSide4.addBox(0F, 0F, 0F, 1, 1, 8);
      PlateSide4.setRotationPoint(-5F, 22F, -4F);
      PlateSide4.setTextureSize(64, 32);
      PlateSide4.mirror = true;
      setRotation(PlateSide4, 0F, 0F, 0F);
      Handle1 = new ModelRenderer(this, 0, 0);
      Handle1.addBox(0F, 0F, 0F, 1, 1, 1);
      Handle1.setRotationPoint(3F, 17F, 0F);
      Handle1.setTextureSize(64, 32);
      Handle1.mirror = true;
      setRotation(Handle1, 0F, 0F, 0F);
      Handle2 = new ModelRenderer(this, 0, 0);
      Handle2.addBox(0F, 0F, 0F, 1, 2, 1);
      Handle2.setRotationPoint(4F, 18F, 0F);
      Handle2.setTextureSize(64, 32);
      Handle2.mirror = true;
      setRotation(Handle2, 0F, 0F, 0F);
      Handle3 = new ModelRenderer(this, 0, 0);
      Handle3.addBox(0F, 0F, 0F, 1, 1, 1);
      Handle3.setRotationPoint(3F, 20F, 0F);
      Handle3.setTextureSize(64, 32);
      Handle3.mirror = true;
      setRotation(Handle3, 0F, 0F, 0F);
      Liquid = new ModelRenderer(this, 0, 0);
      Liquid.addBox(0F, 0F, 0F, 4, 1, 4);
      Liquid.setRotationPoint(-2F, 19F, -2F);
      Liquid.setTextureSize(64, 32);
      Liquid.mirror = true;
      setRotation(Liquid, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, int metadata)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    PlateBottom.render(f5);
    CupBottom.render(f5);
    CupSide1.render(f5);
    CupSide2.render(f5);
    CupSide3.render(f5);
    CupSide4.render(f5);
    PlateSide1.render(f5);
    PlateSide2.render(f5);
    PlateSide3.render(f5);
    PlateSide4.render(f5);
    Handle1.render(f5);
    Handle2.render(f5);
    Handle3.render(f5);
    Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("teamod:textures/blocks/Coffee.png"));
    Liquid.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
