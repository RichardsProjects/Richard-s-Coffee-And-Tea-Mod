package net.richardsprojects.teamod.items;

import net.minecraft.item.BlockNamedItem;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;

public class ItemBlockHalfTeaCup extends BlockNamedItem {

    public ItemBlockHalfTeaCup() {
        super(CoffeeAndTeaModBlocks.HALF_TEA_CUP.get(), new Properties().group(CoffeeAndTeaMod.ITEM_GROUP).maxStackSize(1).maxStackSize(1));
    }
}
