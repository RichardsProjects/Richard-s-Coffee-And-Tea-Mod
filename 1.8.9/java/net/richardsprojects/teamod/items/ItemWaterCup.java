package net.richardsprojects.teamod.items;

import net.minecraft.item.Item;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemWaterCup extends Item {

	public ItemWaterCup() {
		super();
		this.setMaxStackSize(1);
		setUnlocalizedName("waterCup");
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
	}

}
