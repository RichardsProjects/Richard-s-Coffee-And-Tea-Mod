package net.richardsprojects.teamod.items;

import net.minecraft.item.Item;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemCoffeeGrounds extends Item {

	public ItemCoffeeGrounds() {
		super();
		setUnlocalizedName("coffeeGrounds");
		setRegistryName("coffee_Grounds");
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
	}

}
