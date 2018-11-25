package net.richardsprojects.teamod;

import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.richardsprojects.teamod.blocks.BlockCoffeeBush;
import net.richardsprojects.teamod.blocks.BlockTeaBush;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;

public class BushWorldGenerator implements IWorldGenerator {

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
	
		 // check the Biome
		 Chunk chunk = world.getChunkFromChunkCoords(chunkX, chunkZ);
		 Biome b = world.getBiomeForCoordsBody(new BlockPos(chunk.xPosition, chunk.zPosition, 60));
         if(b.getBiomeName().endsWith("Plains") || b.getBiomeName().endsWith("Hills"))
         {
        	 //int addBush = random.nextInt(1);
        	 //if(addBush == 0) {
			 int cX = random.nextInt(16);
			 int cZ = random.nextInt(16);

			 int x = chunkX + random.nextInt(16);
			 int z = chunkZ + random.nextInt(16);
			 int y = chunk.getHeightValue(cX, cZ);
			 int bushType = random.nextInt(2);
			 if(world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.GRASS)  {
				 if(bushType == 1){
					 world.setBlockState(new BlockPos(x, y + 1, z), CoffeeAndTeaModBlocks.coffeeBush.getDefaultState().
							 withProperty(BlockCoffeeBush.AGE, Integer.valueOf(7)), 2);
					 System.out.println("Coffee Bush added at x: " + x + " y: " + y + " z: " + z);
				 } else if(bushType == 0) {
					 world.setBlockState(new BlockPos(x, y + 1, z), CoffeeAndTeaModBlocks.teaBush.getDefaultState().
							 withProperty(BlockTeaBush.AGE, Integer.valueOf(7)), 2);
					 System.out.println("Tea Bush added at x: " + x + " y: " + y + " z: " + z);
				 }
			 }
        	 //}
         }
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.getDimensionType() == DimensionType.OVERWORLD) {
		    generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
	}
}	
