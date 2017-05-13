package net.richardsprojects.teamod.items;

import net.minecraft.item.Item;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemTeaLeaves extends Item {

	public ItemTeaLeaves() {
		super();
		setUnlocalizedName("teaLeaves");
		setRegistryName("teaLeaves");
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
	}

}
