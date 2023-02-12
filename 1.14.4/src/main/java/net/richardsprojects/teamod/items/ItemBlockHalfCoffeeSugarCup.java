package net.richardsprojects.teamod.items;

import net.minecraft.item.BlockNamedItem;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;

public class ItemBlockHalfCoffeeSugarCup extends BlockNamedItem {

    public ItemBlockHalfCoffeeSugarCup() {
        super(CoffeeAndTeaModBlocks.HALF_COFFEE_SUGAR_CUP.get(), new Properties().group(CoffeeAndTeaMod.ITEM_GROUP).maxStackSize(1));
    }
}
