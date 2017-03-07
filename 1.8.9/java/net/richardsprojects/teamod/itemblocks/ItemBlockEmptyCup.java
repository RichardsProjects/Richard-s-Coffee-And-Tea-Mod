package net.richardsprojects.teamod.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemBlockEmptyCup extends ItemBlock {

	public ItemBlockEmptyCup(Block block) {
		super(block);
		this.maxStackSize = 1;
		this.setUnlocalizedName("emptyCup");
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
	}

}
