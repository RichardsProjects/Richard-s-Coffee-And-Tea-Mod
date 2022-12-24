package net.richardsprojects.teamod.items;

import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;

public class ItemBlockEmptyCup extends BlockNamedItem {

    public ItemBlockEmptyCup() {
        super(CoffeeAndTeaModBlocks.EMPTY_CUP.get(), new Item.Properties().group(CoffeeAndTeaMod.ITEM_GROUP));
    }

}
