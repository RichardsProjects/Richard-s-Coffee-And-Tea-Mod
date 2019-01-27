package net.richardsprojects.teamod.items;

import net.minecraft.item.Item;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemRoastedCoffeeBean extends Item {

	public ItemRoastedCoffeeBean() {
		super();
		setUnlocalizedName("roastedCoffeeBean");
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
		setRegistryName("roasted_coffee_bean");
	}
	
}
