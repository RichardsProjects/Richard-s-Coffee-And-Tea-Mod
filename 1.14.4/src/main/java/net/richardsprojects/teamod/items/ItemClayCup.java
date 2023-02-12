package net.richardsprojects.teamod.items;

import net.minecraft.item.Item;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemClayCup extends Item {

	public ItemClayCup() {
		super(new Properties()
			.maxStackSize(1)
			.group(CoffeeAndTeaMod.ITEM_GROUP)
		);
	}
	
}
