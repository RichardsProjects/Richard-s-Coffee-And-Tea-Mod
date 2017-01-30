package net.richardsprojects.teamod.model.plants;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPlantStage0 extends ModelBase
{
  //fields
    ModelRenderer PlantSide1;
    ModelRenderer PlantSide2;
    ModelRenderer PlantSide3;
    ModelRenderer PlantSide4;
  
  public ModelPlantStage0()
  {
	  textureWidth = 16;
	  textureHeight = 16;
    
      PlantSide1 = new ModelRenderer(this, 0, 0);
      PlantSide1.addBox(0F, 0F, 0F, 1, 2, 12);
      PlantSide1.setRotationPoint(5F, 22F, -6F);
      PlantSide1.setTextureSize(16, 16);
      PlantSide1.mirror = true;
      setRotation(PlantSide1, 0F, 0F, 0F);
      PlantSide2 = new ModelRenderer(this, 0, 0);
      PlantSide2.addBox(0F, 0F, 0F, 1, 2, 12);
      PlantSide2.setRotationPoint(-5F, 22F, -6F);
      PlantSide2.setTextureSize(16, 16);
      PlantSide2.mirror = true;
      setRotation(PlantSide2, 0F, 0F, 0F);
      PlantSide3 = new ModelRenderer(this, 0, 0);
      PlantSide3.addBox(0F, 0F, 0F, 14, 2, 1);
      PlantSide3.setRotationPoint(-7F, 22F, -4F);
      PlantSide3.setTextureSize(16, 16);
      PlantSide3.mirror = true;
      setRotation(PlantSide3, 0F, 0F, 0F);
      PlantSide4 = new ModelRenderer(this, 0, 0);
      PlantSide4.addBox(0F, 0F, 0F, 14, 2, 1);
      PlantSide4.setRotationPoint(-7F, 22F, 4F);
      PlantSide4.setTextureSize(16, 16);
      PlantSide4.mirror = true;
      setRotation(PlantSide4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
	  super.render(entity, f, f1, f2, f3, f4, f5);
	  setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	  PlantSide1.render(f5);
	  PlantSide2.render(f5);
	  PlantSide3.render(f5);
	  PlantSide4.render(f5);
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
