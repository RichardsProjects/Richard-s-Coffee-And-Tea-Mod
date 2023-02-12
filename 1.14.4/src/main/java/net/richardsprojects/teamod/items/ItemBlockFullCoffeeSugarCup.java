package net.richardsprojects.teamod.items;

import net.minecraft.item.BlockNamedItem;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;

public class ItemBlockFullCoffeeSugarCup extends BlockNamedItem {

    public ItemBlockFullCoffeeSugarCup() {
        super(CoffeeAndTeaModBlocks.FULL_COFFEE_SUGAR_CUP.get(), new Properties().group(CoffeeAndTeaMod.ITEM_GROUP));
    }
}
