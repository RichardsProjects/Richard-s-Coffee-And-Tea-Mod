package net.richardsprojects.teamod.common.blocks;

import com.stereowalker.survive.Survive;
import com.stereowalker.survive.core.SurviveEntityStats;
import com.stereowalker.survive.needs.StaminaData;
import com.stereowalker.survive.needs.WaterData;
import com.stereowalker.survive.world.effect.SMobEffects;
import com.stereowalker.survive.world.entity.ai.attributes.SAttributes;
import com.stereowalker.survive.world.temperature.TemperatureModifier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class BlockFullTeaCup extends Block {

    public static final DirectionProperty FACING = DirectionProperty.create("facing");

    public BlockFullTeaCup() {
        super(Properties.of().mapColor(MapColor.CLAY));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_48689_) {
        return this.defaultBlockState().setValue(FACING, p_48689_.getHorizontalDirection().getOpposite());
    }

    public boolean propagatesSkylightDown(BlockState p_49928_, BlockGetter p_49929_, BlockPos p_49930_) {
        return true;
    }

    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult result) {
        return drinkTea(level, blockPos, blockState, player);
    }

    private InteractionResult drinkTea(Level level, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false) && !CoffeeAndTeaMod.surviveEnabled) {
            return InteractionResult.FAIL;
        } else {
            player.getFoodData().eat(2, 1F);
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 1200, 0));

            BlockState newState = CoffeeAndTeaMod.HALF_TEA_CUP.get().defaultBlockState();
            newState = newState.setValue(BlockEmptyCup.FACING, state.getValue(BlockFullTeaCup.FACING));
            level.setBlock(pos, newState, 3);

            if (CoffeeAndTeaMod.surviveEnabled) {
                // update water stats
                WaterData waterStats = SurviveEntityStats.getWaterStats(player);
                int waterLevel = waterStats.getWaterLevel();
                if (waterLevel < 20) waterLevel = Math.min(waterLevel + 5, 20);
                float hydrationLevel = waterStats.getHydrationLevel();
                float waterHydrationLevel = Mth.clamp(hydrationLevel + 3f * Survive.THIRST_CONFIG.hydration_restoration, 1.0F, 3F);
                waterStats.setWaterLevel(waterLevel);
                waterStats.setWaterHydrationLevel(waterHydrationLevel);
                waterStats.save(player);

                // update stamina
                StaminaData stamina = SurviveEntityStats.getEnergyStats(player);
                stamina.relax(3, player.getAttributeValue(SAttributes.MAX_STAMINA));
                stamina.save(player);

                // add effects
                player.addEffect(new MobEffectInstance(SMobEffects.HEATED, 600));
                player.addEffect(new MobEffectInstance(SMobEffects.ENERGIZED, 3000));
            }

            return InteractionResult.CONSUME_PARTIAL;
        }
    }

}
