package net.richardsprojects.teamod.common.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemBlockEmptyCup extends ItemNameBlockItem {

    public ItemBlockEmptyCup() {
        super(CoffeeAndTeaMod.EMPTY_CUP.get(), new Item.Properties().tab(CoffeeAndTeaMod.TAB));
    }
}
