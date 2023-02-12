package net.richardsprojects.teamod.items;

import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;

public class ItemUnroastedCoffeeBean extends BlockNamedItem {

	public ItemUnroastedCoffeeBean() {
		super(CoffeeAndTeaModBlocks.COFFEE_BUSH.get(), new Properties().group(CoffeeAndTeaMod.ITEM_GROUP));
	}


}
