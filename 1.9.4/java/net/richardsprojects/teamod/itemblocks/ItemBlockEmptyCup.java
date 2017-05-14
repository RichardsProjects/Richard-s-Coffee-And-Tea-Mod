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
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
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
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		ActionResult<ItemStack> returnValue = new ActionResult(EnumActionResult.PASS, stack);
		
		System.out.println("Right clicked an empty cup");
		
		if (!processRightClickForWater(stack, worldIn, playerIn)) {
			RayTraceResult raytrace = this.rayTrace(worldIn, playerIn, true);
			
			if (raytrace != null && raytrace.typeOfHit == RayTraceResult.Type.BLOCK) {
				BlockPos blockPos = raytrace.getBlockPos();
				float hitX = raytrace.getBlockPos().getX();
				float hitY = raytrace.getBlockPos().getY();
				float hitZ = raytrace.getBlockPos().getZ();
				EnumFacing facing = playerIn.getHorizontalFacing();
				
				EnumActionResult result = super.onItemUse(stack, playerIn, worldIn, blockPos, hand, facing, hitX, hitY, hitZ);
				
				if (result == EnumActionResult.SUCCESS) {
					stack.stackSize--;
					returnValue = new ActionResult(EnumActionResult.SUCCESS, stack);
				}
			}
		} else {
			ItemStack waterCup = new ItemStack(CoffeeAndTeaModItems.waterCup);
			returnValue = new ActionResult(EnumActionResult.SUCCESS, waterCup);
		}
		
		return returnValue;
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
	private boolean processRightClickForWater(ItemStack is, World world, EntityPlayer player) {
		boolean result = false;
		RayTraceResult raytraceresult = this.rayTrace(world, player, true);
		
		
        if (raytraceresult != null && raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK)
        {
        	BlockPos blockpos = raytraceresult.getBlockPos();
            IBlockState blockState = world.getBlockState(blockpos);
            Material material = blockState.getMaterial();
            
            if (material == Material.WATER) {
            	result = true;
            }
        }
        
        return result;            
	}

}
