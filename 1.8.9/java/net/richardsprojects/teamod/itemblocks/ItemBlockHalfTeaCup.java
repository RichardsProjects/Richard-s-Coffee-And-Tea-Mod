package net.richardsprojects.teamod.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemBlockHalfTeaCup extends ItemBlock {

	public ItemBlockHalfTeaCup(Block block) {
		super(block);
		this.maxStackSize = 1;
		this.setUnlocalizedName("halfTeaCup");
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
	}
}