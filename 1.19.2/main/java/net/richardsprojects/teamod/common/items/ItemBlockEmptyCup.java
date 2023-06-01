package net.richardsprojects.teamod.common.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemBlockEmptyCup extends ItemNameBlockItem {

    public ItemBlockEmptyCup() {
        super(CoffeeAndTeaMod.EMPTY_CUP.get(), new Item.Properties().tab(CoffeeAndTeaMod.TAB));
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

            return blockstate.getMaterial() == Material.WATER;
        }

        return false;
    }

/*    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        BlockHitResult blockhitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);

        if (blockhitresult.getType() == HitResult.Type.BLOCK) {
            BlockPos blockpos = blockhitresult.getBlockPos();
            Direction direction = blockhitresult.getDirection();
            BlockPos blockpos1 = blockpos.relative(direction);

            if (player.mayInteract(level, blockpos) && player.mayUseItemAt(blockpos1, direction, itemstack)) {
                BlockState blockstate = level.getBlockState(blockpos1);

                if (blockstate.getMaterial() == Material.WATER) {
                    ItemStack itemstack2 = new ItemStack(CoffeeAndTeaMod.WATER_CUP.get(), 1);
                    return InteractionResultHolder.sidedSuccess(itemstack2, level.isClientSide());
                }
            } else {
                return InteractionResultHolder.fail(itemstack);
            }
        }

        return InteractionResultHolder.fail(itemstack);
    }*/
}