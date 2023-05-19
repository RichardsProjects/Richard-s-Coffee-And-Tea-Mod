package net.richardsprojects.teamod.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemBlockFullCoffeeCup extends ItemNameBlockItem {

    public ItemBlockFullCoffeeCup() {
        super(CoffeeAndTeaMod.FULL_COFFEE_CUP.get(), new Properties().tab(CoffeeAndTeaMod.TAB));
    }

}