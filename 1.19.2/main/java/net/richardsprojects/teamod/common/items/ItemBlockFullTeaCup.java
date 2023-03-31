package net.richardsprojects.teamod.common.items;

import net.minecraft.world.item.ItemNameBlockItem;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemBlockFullTeaCup extends ItemNameBlockItem {

    public ItemBlockFullTeaCup() {
        super(CoffeeAndTeaMod.FULL_TEA_CUP.get(), new Properties().tab(CoffeeAndTeaMod.TAB));
    }

}