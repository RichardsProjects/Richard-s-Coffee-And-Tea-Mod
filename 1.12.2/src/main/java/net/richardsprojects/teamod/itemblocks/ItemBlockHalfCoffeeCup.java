package net.richardsprojects.teamod.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemBlockHalfCoffeeCup extends ItemBlock {

	public ItemBlockHalfCoffeeCup(Block block) {
		super(block);
		this.maxStackSize = 1;
		this.setUnlocalizedName("halfCoffeeCup");
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
	}
}