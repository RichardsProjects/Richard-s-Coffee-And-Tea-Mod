package net.richardsprojects.teamod.items;

import net.minecraft.item.Item;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemClayCup extends Item {

	public ItemClayCup() {
		super();
		this.setMaxStackSize(1);
		setUnlocalizedName("clayCup");
		setRegistryName("clay_cup");
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
	}
	
}
