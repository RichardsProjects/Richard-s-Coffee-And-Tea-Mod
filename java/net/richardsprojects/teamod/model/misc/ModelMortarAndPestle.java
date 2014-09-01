package net.richardsprojects.teamod.model.misc;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.richardsprojects.teamod.entity.MortarAndPestleEntity;

public class ModelMortarAndPestle extends ModelBase
{
  //fields
    ModelRenderer BowlBottom;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Pestle;
  
  public ModelMortarAndPestle()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      BowlBottom = new ModelRenderer(this, 0, 0);
      BowlBottom.addBox(0F, 0F, 0F, 8, 1, 8);
      BowlBottom.setRotationPoint(-4F, 23F, -4F);
      BowlBottom.setTextureSize(32, 32);
      BowlBottom.mirror = true;
      setRotation(BowlBottom, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 8, 5, 1);
      Shape1.setRotationPoint(-4F, 18F, 4F);
      Shape1.setTextureSize(32, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 8, 5, 1);
      Shape2.setRotationPoint(-4F, 18F, -5F);
      Shape2.setTextureSize(32, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(0F, 0F, 0F, 1, 5, 8);
      Shape3.setRotationPoint(-5F, 18F, -4F);
      Shape3.setTextureSize(32, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 0);
      Shape4.addBox(0F, 0F, 0F, 1, 5, 8);
      Shape4.setRotationPoint(4F, 18F, -4F);
      Shape4.setTextureSize(32, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 0);
      Shape5.addBox(0F, 0F, 0F, 1, 1, 8);
      Shape5.setRotationPoint(5F, 17F, -4F);
      Shape5.setTextureSize(32, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 0);
      Shape6.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape6.setRotationPoint(4F, 17F, 4F);
      Shape6.setTextureSize(32, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 0);
      Shape7.addBox(0F, 0F, 0F, 8, 1, 1);
      Shape7.setRotationPoint(-4F, 17F, 5F);
      Shape7.setTextureSize(32, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 0);
      Shape8.addBox(0F, 0F, 0F, 1, 1, 8);
      Shape8.setRotationPoint(-6F, 17F, -4F);
      Shape8.setTextureSize(32, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 0, 0);
      Shape9.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape9.setRotationPoint(-5F, 17F, 4F);
      Shape9.setTextureSize(32, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 0, 0);
      Shape10.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape10.setRotationPoint(-5F, 17F, -5F);
      Shape10.setTextureSize(32, 32);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 0, 0);
      Shape11.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape11.setRotationPoint(4F, 17F, -5F);
      Shape11.setTextureSize(32, 32);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 0, 0);
      Shape12.addBox(0F, 0F, 0F, 8, 1, 1);
      Shape12.setRotationPoint(-4F, 17F, -6F);
      Shape12.setTextureSize(32, 32);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
      Pestle = new ModelRenderer(this, 0, 0);
      Pestle.addBox(0F, 0F, 0F, 2, 14, 2);
      Pestle.setRotationPoint(-6F, 15F, -4F);
      Pestle.setTextureSize(16, 16);
      Pestle.mirror = true;
      setRotation(Pestle, 0.9294653F, 0.8179294F, -0.0371786F);
  }
  
  public void render(Entity te, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(te, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, te);
    
    BowlBottom.render(f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("teamod:textures/blocks/IronBlock.png"));
    Pestle.render(f5);
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
