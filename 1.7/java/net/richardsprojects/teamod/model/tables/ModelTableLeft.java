package net.richardsprojects.teamod.model.tables;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTableLeft extends ModelBase
{
  //fields
    ModelRenderer TableSurface;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
  
  public ModelTableLeft()
  {
    textureWidth = 16;
    textureHeight = 16;
    
      TableSurface = new ModelRenderer(this, 0, 0);
      TableSurface.addBox(0F, 0F, 0F, 16, 2, 16);
      TableSurface.setRotationPoint(-8F, 12F, -8F);
      TableSurface.setTextureSize(textureWidth, textureHeight);
      TableSurface.mirror = true;
      setRotation(TableSurface, 0F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 0, 0);
      Leg1.addBox(0F, 0F, 0F, 3, 10, 3);
      Leg1.setRotationPoint(2F, 14F, -6F);
      Leg1.setTextureSize(textureWidth, textureHeight);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 0, 0);
      Leg2.addBox(0F, 0F, 0F, 3, 10, 3);
      Leg2.setRotationPoint(2F, 14F, 4F);
      Leg2.setTextureSize(textureWidth, textureHeight);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, int metadata)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    TableSurface.render(f5);
    Leg1.render(f5);
    Leg2.render(f5);
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
