package net.richardsprojects.teamod.main;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemUnroastedCoffeeBeans extends ItemFood implements IPlantable
{
		public ItemUnroastedCoffeeBeans()
		{
			super(1, 1, false);
			this.maxStackSize = 64;
			this.setCreativeTab(TeaMod.teaModTab);
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
					// previous Block
					Block previousBlock = world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
					int blockMeta = world.getBlockMetadata(p_77648_4_, p_77648_5_, p_77648_6_);

					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockCoffeeBush.coffeeBush);
					
					// change the block back to farmland
					world.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, previousBlock, blockMeta, 3);
					
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

	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
	{
		return p_77659_1_;
	}

	public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
	{
		return p_77654_1_;
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
}
