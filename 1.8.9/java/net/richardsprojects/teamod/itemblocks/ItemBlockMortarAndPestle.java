package net.richardsprojects.teamod.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;

public class ItemBlockMortarAndPestle extends ItemBlock {

	public ItemBlockMortarAndPestle(Block block) {
		super(block);
		this.maxStackSize = 1;
		this.setUnlocalizedName("mortarAndPestle");
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
	}

}
