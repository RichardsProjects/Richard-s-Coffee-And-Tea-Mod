package net.richardsprojects.teamod.common.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemTeaSeed extends ItemNameBlockItem {
    public ItemTeaSeed() {
        super(CoffeeAndTeaMod.TEA_BUSH.get(), new Item.Properties().tab(CoffeeAndTeaMod.TAB));
    }
}
