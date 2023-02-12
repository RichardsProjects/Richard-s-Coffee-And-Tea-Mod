package net.richardsprojects.teamod.items;

import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;

public class ItemTeaSeed extends BlockNamedItem {

	public ItemTeaSeed() {
		super(CoffeeAndTeaModBlocks.TEA_BUSH.get(), new Properties().group(CoffeeAndTeaMod.ITEM_GROUP));
	}
}
