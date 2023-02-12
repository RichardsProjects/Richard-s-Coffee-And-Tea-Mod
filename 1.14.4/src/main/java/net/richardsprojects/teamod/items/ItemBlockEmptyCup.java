package net.richardsprojects.teamod.items;

import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;

import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;

public class ItemBlockEmptyCup extends BlockNamedItem {

    public ItemBlockEmptyCup() {
        super(
            CoffeeAndTeaModBlocks.EMPTY_CUP.get(),
            new Properties().group(CoffeeAndTeaMod.ITEM_GROUP).maxStackSize(1)
        );
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        RayTraceResult raytraceresult = rayTrace(context.getWorld(), context.getPlayer(), RayTraceContext.FluidMode.SOURCE_ONLY);

        if (isWater(context.getWorld(), raytraceresult)) {
            context.getItem().shrink(1);
            ItemStack waterCup = new ItemStack(CoffeeAndTeaModItems.WATER_CUP.get());
            context.getPlayer().addItemStackToInventory(waterCup);

            return ActionResultType.SUCCESS;
        }

        return super.onItemUse(context);
    }

    /**
     * Checks if the position has water in it.
     *
     * @param world the world the event occurred in
     * @param result the RayTraceResult to use in the calculation
     * @return whether or not there was water
     */
    private boolean isWater(World world, RayTraceResult result) {
        if (result != null && result.getType() == RayTraceResult.Type.BLOCK)
        {
            Vec3d pos = result.getHitVec();
            BlockState blockState = world.getBlockState(new BlockPos(pos.x, pos.y, pos.z));
            Material material = blockState.getMaterial();

            return material == Material.WATER;
        }

        return false;
    }
}
