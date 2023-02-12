package net.richardsprojects.teamod.items;

import net.minecraft.item.BlockNamedItem;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;

public class ItemBlockFullTeaCup extends BlockNamedItem {

    public ItemBlockFullTeaCup() {
        super(CoffeeAndTeaModBlocks.FULL_TEA_CUP.get(), new Properties().group(CoffeeAndTeaMod.ITEM_GROUP));
    }
}
