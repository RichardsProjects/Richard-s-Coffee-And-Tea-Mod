package net.richardsprojects.teamod.items;

import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;

public class ItemBlockFullCoffeeCup extends BlockNamedItem {

    public ItemBlockFullCoffeeCup() {
        super(CoffeeAndTeaModBlocks.FULL_COFFEE_CUP.get(), new Properties().group(CoffeeAndTeaMod.ITEM_GROUP));
    }
}
