package net.richardsprojects.teamod.common.items;

import net.minecraft.world.item.ItemNameBlockItem;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemBlockMortarAndPestle extends ItemNameBlockItem {

    public ItemBlockMortarAndPestle() {
        super(CoffeeAndTeaMod.MORTAR_AND_PESTLE.get(), new Properties().stacksTo(1).defaultDurability(64));
    }

}