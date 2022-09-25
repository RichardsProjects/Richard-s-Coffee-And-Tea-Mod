package net.richardsprojects.teamod.items;

import net.minecraft.item.Item;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemBoilingCup extends Item {

	public ItemBoilingCup() {
		super(new Item.Properties()
			.maxStackSize(1)
			.group(CoffeeAndTeaMod.ITEM_GROUP)
		);
	}

}
