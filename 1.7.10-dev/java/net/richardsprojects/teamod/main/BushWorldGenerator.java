package net.richardsprojects.teamod.main;

import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import cpw.mods.fml.common.IWorldGenerator;

public class BushWorldGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.dimensionId){
		case -1:
		    generateNether(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 0:
		    generateSurface(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 1:
		    generateEnd(world, random, chunkX * 16, chunkZ * 16);
		    break;
		}
	}

	private void generateEnd(World world, Random random, int i, int j) {}
	
	private void generateNether(World world, Random random, int i, int j) {}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
	
		 //Check the Biome
		 BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
		 WorldGenFlowers bushGenerator = new WorldGenFlowers(BlockCoffeeBush.coffeeBush);
         if(b.biomeName.equals("Plains") || b.biomeName.equals("Extreme Hills"))
         {
        	 int addBush = random.nextInt(3);
        	 if(addBush == 0) {
                 int x = chunkX + random.nextInt(16) + 8;
                 int z = chunkZ + random.nextInt(16) + 8;
                 int y = world.getHeightValue(x, z);
                 int bushType = random.nextInt(2);
                 if(world.getBlock(x, y - 1, z) == Blocks.grass)  {
                	 if(bushType == 1){
                		 world.setBlock(x, y, z, BlockCoffeeBush.coffeeBush, 7, 2);
                	 } else if(bushType == 0) {
                		 world.setBlock(x, y, z, BlockTeaBush.teaBush, 7, 2);
                	 }
                	 TeaMod.logger.info(" x: " + x + " y: " + y + " z: " + z);
                 }
        	 }
         }
	}

}
