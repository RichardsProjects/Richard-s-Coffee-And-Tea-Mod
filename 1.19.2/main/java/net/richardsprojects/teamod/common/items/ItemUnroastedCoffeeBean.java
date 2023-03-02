package net.richardsprojects.teamod.common.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemUnroastedCoffeeBean extends ItemNameBlockItem {

    public ItemUnroastedCoffeeBean() {
        super(CoffeeAndTeaMod.COFFEE_BUSH.get(), new Item.Properties().tab(CoffeeAndTeaMod.TAB));
    }

}
