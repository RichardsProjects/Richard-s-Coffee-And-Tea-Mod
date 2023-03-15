package net.richardsprojects.teamod.common.items;

import net.minecraft.world.item.Item;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemWaterCup extends Item {

    public ItemWaterCup() {
        super(new Item.Properties().tab(CoffeeAndTeaMod.TAB).stacksTo(1));
    }

}
