package net.richardsprojects.teamod.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemTeaSeeds extends Item implements IPlantable
{
	
		public static Item teaSeeds;
		
		public ItemTeaSeeds()
		{
			super();
			this.maxStackSize = 36;
		}
	
		public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int p_77648_4_, 
				int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
		{
			if (p_77648_7_ != 1)
			{
				return false;
			}
			else if (player.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, itemStack) && player.canPlayerEdit(p_77648_4_, p_77648_5_ + 1, p_77648_6_, p_77648_7_, itemStack))
			{
				if (world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_).canSustainPlant(world, p_77648_4_, p_77648_5_, p_77648_6_, ForgeDirection.UP, this) && world.isAirBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_))
				{
					//Previous Block
					Block previousBlock = world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
					int blokMeta = world.getBlockMetadata(p_77648_4_, p_77648_5_, p_77648_6_);
					
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockTeaBush.teaBush);
					
					//Change the block back to farmland
					world.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, previousBlock, blokMeta, 3);
					
					itemStack.stackSize--;
					return true;
				}
			else
			{
				return false;
			}
			}
			else
			{
				return false;
		    }
		}
        
        
		@Override
		public EnumPlantType getPlantType(IBlockAccess world, int x, int y,
				int z) {
			return EnumPlantType.Crop;
		}

		@Override
		public Block getPlant(IBlockAccess world, int x, int y, int z)
		{
			return BlockCoffeeBush.coffeeBush;
		}

		@Override
		public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
		{
			return 0;
		}
		
		//Item Registration Code
		public static void mainRegistry()	
		{
			initializeItem();
			registerItem();
		}

		private static void initializeItem()
		{
			teaSeeds = new ItemTeaSeeds().setTextureName("teamod:teaseed").setUnlocalizedName("teaSeeds").setCreativeTab(TeaMod.teaModTab);
		}
		
		private static void registerItem()
		{
			GameRegistry.registerItem(teaSeeds, teaSeeds.getUnlocalizedName());
		}
}
