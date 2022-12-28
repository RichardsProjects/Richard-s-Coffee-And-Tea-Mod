package net.richardsprojects.teamod.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;

public class ItemBlockMortarAndPestle extends BlockNamedItem {

    public ItemBlockMortarAndPestle() {
        super(
            CoffeeAndTeaModBlocks.MORTAR_AND_PESTLE.get(),
            new Properties().group(CoffeeAndTeaMod.ITEM_GROUP).maxStackSize(1)
        );
    }
}
