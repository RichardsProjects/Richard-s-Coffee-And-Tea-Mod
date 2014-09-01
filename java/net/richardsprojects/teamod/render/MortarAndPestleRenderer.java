package net.richardsprojects.teamod.render;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.richardsprojects.teamod.entity.MortarAndPestleEntity;
import net.richardsprojects.teamod.model.cups.ModelFullCoffeeCup;
import net.richardsprojects.teamod.model.misc.ModelMortarAndPestle;

@SideOnly(Side.CLIENT)
public class MortarAndPestleRenderer extends TileEntitySpecialRenderer {
       
        //The model of your block
        private final ModelMortarAndPestle model1 = new ModelMortarAndPestle();
       
        public MortarAndPestleRenderer() {

        }
       
        private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
                int meta = world.getBlockMetadata(x, y, z);
                GL11.glPushMatrix();
                GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
                GL11.glPopMatrix();
        }
       
        @Override
        public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        	
        	//The PushMatrix tells the renderer to "start" doing something.
            GL11.glPushMatrix();
            //This is setting the initial location.
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

            //Texture is set in the model class

            //This rotation part is very important! Without it, your model will render upside-down! And for some reason you DO need PushMatrix again!                      
            GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            
            //Calculate rotation based on metadata
            int rotation = 1;
            int m = te.getBlockMetadata();
            if(m == 0 || m == 4 || m == 8 || m == 12) rotation = 1;
            if(m == 1 || m == 5 || m == 9 || m == 13) rotation = 2;
            if(m == 2 || m == 6 || m == 10 || m == 14) rotation = 3;
            if(m == 3 || m == 7 || m == 11 || m == 15) rotation = 4;
            GL11.glRotatef(90F * rotation, 0.0F, 1.0F, 0.0F);
            
            //Load Textures
            ResourceLocation texture0;
            ResourceLocation texture1;
            ResourceLocation texture2;
            ResourceLocation texture3;
            texture0 = new ResourceLocation("teamod:textures/blocks/stone.png");
            texture1 = new ResourceLocation("teamod:textures/blocks/stone1.png");
            texture2 = new ResourceLocation("teamod:textures/blocks/stone2.png");
            texture3 = new ResourceLocation("teamod:textures/blocks/stone3.png");
            
            //Bind Texture based on Metadata
            if(m < 4) {
            	Minecraft.getMinecraft().renderEngine.bindTexture(texture0);
            }
            if(m < 8 && m > 3) {
            	Minecraft.getMinecraft().renderEngine.bindTexture(texture1);
            }
            if(m < 12 && m > 7) {
            	Minecraft.getMinecraft().renderEngine.bindTexture(texture2);
            }
            if(m < 16 && m > 11) {
            	Minecraft.getMinecraft().renderEngine.bindTexture(texture3);
            }
            
            
           	//Render Model
            this.model1.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

            //Tell it to stop rendering for both the PushMatrix's
            GL11.glPopMatrix();
            GL11.glPopMatrix();
        }

        //Set the lighting stuff, so it changes it's brightness properly.      
        private void adjustLightFixture(World world, int i, int j, int k, Block block) {
                Tessellator tess = Tessellator.instance;
                float brightness = block.getLightValue(world, i, j, k);
                int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
                int modulousModifier = skyLight % 65536;
                int divModifier = skyLight / 65536;
                tess.setColorOpaque_F(brightness, brightness, brightness);
                OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) modulousModifier,  divModifier);
        }


}