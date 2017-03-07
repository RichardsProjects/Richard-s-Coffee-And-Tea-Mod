package net.richardsprojects.teamod.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.items.CoffeeAndTeaModItems;

public class ItemBlockEmptyCup extends ItemBlock {

	public ItemBlockEmptyCup(Block block) {
		super(block);
		this.maxStackSize = 1;
		this.setUnlocalizedName("emptyCup");
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!processRightClickForWater(stack, worldIn, playerIn)) {
			return super.onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
		}
		return false;
    }
	
	/**
	 * Checks if the position has water in it. If there is the ItemStack is 
	 * updated and the method returns true. Otherwise the method returns false.
	 * 
	 * @param itemStackIn the emptyCup ItemStack
	 * @param worldIn the world the event occurred in
	 * @param playerIn the player who right clicked
	 * @return whether or not there was water
	 */
	private boolean processRightClickForWater(ItemStack is, World w, EntityPlayer p) {
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(w, p, true);

		if (movingobjectposition != null) {


			if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
				BlockPos blockpos = movingobjectposition.getBlockPos();

				if (p.canPlayerEdit(blockpos.offset(movingobjectposition.sideHit),movingobjectposition.sideHit, is) && w.isBlockModifiable(p, blockpos)) {
					IBlockState iblockstate = w.getBlockState(blockpos);
					Material material = iblockstate.getBlock().getMaterial();

					if (material == Material.water && ((Integer) iblockstate.getValue(BlockLiquid.LEVEL)).intValue() == 0) {			
						// update ItemStack
						int i = p.inventory.currentItem;
						p.inventory.setInventorySlotContents(i, new ItemStack(CoffeeAndTeaModItems.waterCup, 1));
						
						return true;
					}
				}
			}
		}
		
		return false;
	}

}
