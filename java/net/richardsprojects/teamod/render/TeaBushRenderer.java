package net.richardsprojects.teamod.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.richardsprojects.teamod.model.plants.ModelPlantStage0;
import net.richardsprojects.teamod.model.plants.ModelPlantStage1;
import net.richardsprojects.teamod.model.plants.ModelPlantStage2;
import net.richardsprojects.teamod.model.plants.ModelPlantStage3;
import net.richardsprojects.teamod.model.plants.ModelPlantStage4;
import net.richardsprojects.teamod.model.plants.ModelPlantStage5;
import net.richardsprojects.teamod.model.plants.ModelPlantStage6;
import net.richardsprojects.teamod.model.plants.ModelPlantStage7;

public class TeaBushRenderer extends TileEntitySpecialRenderer {

	public TeaBushRenderer()
	{
		
	}
	
	private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		GL11.glPushMatrix();
        GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
        GL11.glPopMatrix();
	}
	
	private void setRotation()
	{
		//This rotation part is very important! Without it, your model will render upside-down! And for some reason you DO need PushMatrix again!                      
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
	{
		//The PushMatrix tells the renderer to "start" doing something.
		GL11.glPushMatrix();
		//This is setting the initial location.
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

		//Set Rotation
		setRotation();
		
		//Use metadata and to determine what model and textures to use
		if(te.getBlockMetadata() == 0)
		{
			//Set Texture
			ResourceLocation texture = (new ResourceLocation("teamod:textures/blocks/CoffeeStage0.png"));
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			
			//Render Model
			ModelPlantStage0 model = new ModelPlantStage0();
			model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}
		else if(te.getBlockMetadata() == 1)
		{
			//Set Texture
			ResourceLocation texture = (new ResourceLocation("teamod:textures/blocks/TeaStage1_3.png"));
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			
			//Render Model
			ModelPlantStage1 model = new ModelPlantStage1();
			model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}
		else if(te.getBlockMetadata() == 2)
		{
			//Set Texture
			ResourceLocation texture = (new ResourceLocation("teamod:textures/blocks/TeaStage1_3.png"));
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			
			//Render Model
			ModelPlantStage2 model = new ModelPlantStage2();
			model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}
		else if(te.getBlockMetadata() == 3)
		{
			//Set Texture
			ResourceLocation texture = (new ResourceLocation("teamod:textures/blocks/TeaStage1_3.png"));
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			
			//Render Model
			ModelPlantStage3 model = new ModelPlantStage3();
			model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}
		else if(te.getBlockMetadata() == 4)
		{
			//Set Texture
			ResourceLocation texture = (new ResourceLocation("teamod:textures/blocks/TeaStage4_5.png"));
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			
			//Render Model
			ModelPlantStage4 model = new ModelPlantStage4();
			model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}
		else if(te.getBlockMetadata() == 5)
		{
			//Set Texture
			ResourceLocation texture = (new ResourceLocation("teamod:textures/blocks/TeaStage4_5.png"));
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			
			//Render Model
			ModelPlantStage5 model = new ModelPlantStage5();
			model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}
		else if(te.getBlockMetadata() == 6)
		{
			//Set Texture
			ResourceLocation texture = (new ResourceLocation("teamod:textures/blocks/TeaStage6.png"));
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			
			//Render Model
			ModelPlantStage6 model = new ModelPlantStage6();
			model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}
		else if(te.getBlockMetadata() == 7)
		{
			//Set Texture
			ResourceLocation texture = (new ResourceLocation("teamod:textures/blocks/TeaStage7.png"));
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			
			//Render Model
			ModelPlantStage7 model = new ModelPlantStage7();
			model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}
		
		//Tell it to stop rendering for both the PushMatrix's
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	//Set the lighting stuff, so it changes it's brightness properly.      
	private void adjustLightFixture(World world, int i, int j, int k, Block block)
	{
		Tessellator tess = Tessellator.instance;
        float brightness = block.getLightValue(world, i, j, k);
        int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
        int modulousModifier = skyLight % 65536;
        int divModifier = skyLight / 65536;
        tess.setColorOpaque_F(brightness, brightness, brightness);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) modulousModifier,  divModifier);
	}	
}
