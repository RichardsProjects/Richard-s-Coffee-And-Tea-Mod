package net.richardsprojects.teamod.items;

import net.minecraft.item.Item;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemBoilingCup extends Item {

	public ItemBoilingCup() {
		super();
		this.setMaxStackSize(1);
		setUnlocalizedName("boilingCup");
		setRegistryName("boilingCup");
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
	}

}
