package net.richardsprojects.teamod.items;

import net.minecraft.item.Item;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemWaterCup extends Item {

	public ItemWaterCup() {
		super(new Properties()
			.maxStackSize(1)
			.group(CoffeeAndTeaMod.ITEM_GROUP)
		);
	}

}
