package net.richardsprojects.teamod.common.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

import javax.annotation.Nullable;

public class ItemBlockFullTeaCup extends ItemNameBlockItem {

    public ItemBlockFullTeaCup() {
        super(CoffeeAndTeaMod.FULL_TEA_CUP.get(), new Properties().tab(CoffeeAndTeaMod.TAB));
    }

    @Override
    public FoodProperties getFoodProperties(ItemStack stack, @Nullable LivingEntity entity)
    {
        return new FoodProperties.Builder().alwaysEat().nutrition(2).saturationMod(1F).build();
    }
}