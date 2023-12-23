package net.richardsprojects.teamod.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemBlockEmptyCup extends ItemNameBlockItem {

    public ItemBlockEmptyCup() {
        super(CoffeeAndTeaMod.EMPTY_CUP.get(), new Properties());
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockHitResult result = getPlayerPOVHitResult(context.getLevel(), context.getPlayer(), ClipContext.Fluid.SOURCE_ONLY);

        if (isWater(context.getLevel(), result)) {
           if (context.getPlayer().getInventory().getFreeSlot() > -1) {
               context.getItemInHand().shrink(1);
               ItemStack waterCup = new ItemStack(CoffeeAndTeaMod.WATER_CUP.get());
               context.getPlayer().addItem(waterCup);
               return InteractionResult.PASS;
           } else {
               return InteractionResult.FAIL;
           }
        }

        return super.useOn(context);
    }

    /**
     * Checks if the position has water in it.
     *
     * @param level the world the event occurred in
     * @param result the RayTraceResult to use in the calculation
     * @return whether or not there was water
     */
    private boolean isWater(Level level, BlockHitResult result) {
        if (result != null && result.getType() == HitResult.Type.BLOCK)
        {
            BlockPos blockpos = result.getBlockPos();
            BlockState blockstate = level.getBlockState(blockpos);

            if (blockstate.getFluidState() != null) {
                return blockstate.getFluidState().is(Fluids.WATER);
            } else {
                return false;
            }
        }

        return false;
    }

}