package net.richardsprojects.teamod.common.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import org.jetbrains.annotations.Nullable;

public class ItemBlockHalfCoffeeCup extends ItemNameBlockItem {

    public ItemBlockHalfCoffeeCup() {
        super(CoffeeAndTeaMod.HALF_COFFEE_CUP.get(), new Properties());
    }

    @Override
    public FoodProperties getFoodProperties(ItemStack stack, @Nullable LivingEntity entity)
    {
        return new FoodProperties.Builder().alwaysEat().nutrition(2).saturationMod(1F).build();
    }
}