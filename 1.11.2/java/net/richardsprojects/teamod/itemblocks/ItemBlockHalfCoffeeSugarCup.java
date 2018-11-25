package net.richardsprojects.teamod.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemBlockHalfCoffeeSugarCup extends ItemBlock {

	public ItemBlockHalfCoffeeSugarCup(Block block) {
		super(block);
		this.maxStackSize = 1;
		this.setUnlocalizedName("halfCoffeeSugarCup");
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
	}
}