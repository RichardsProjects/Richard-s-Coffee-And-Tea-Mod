package net.richardsprojects.teamod.items;

import net.minecraft.item.BlockNamedItem;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;

public class ItemBlockHalfCoffeeCup extends BlockNamedItem {

    public ItemBlockHalfCoffeeCup() {
        super(CoffeeAndTeaModBlocks.HALF_COFFEE_CUP.get(), new Properties().group(CoffeeAndTeaMod.ITEM_GROUP));
    }
}
