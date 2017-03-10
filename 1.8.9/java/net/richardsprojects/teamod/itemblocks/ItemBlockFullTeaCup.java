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

public class ItemBlockFullTeaCup extends ItemBlock {

	public ItemBlockFullTeaCup(Block block) {
		super(block);
		this.maxStackSize = 1;
		this.setUnlocalizedName("fullTeaCup");
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
	}
}
