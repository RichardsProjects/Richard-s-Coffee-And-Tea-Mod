package net.richardsprojects.teamod.items;

import net.minecraft.item.Item;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemGroundTeaLeaves extends Item {

	public ItemGroundTeaLeaves() {
		super();
		setUnlocalizedName("groundTeaLeaves");
		setRegistryName("ground_tea_leaves");
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
	}

}
