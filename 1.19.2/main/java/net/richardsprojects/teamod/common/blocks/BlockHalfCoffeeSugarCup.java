package net.richardsprojects.teamod.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class BlockHalfCoffeeSugarCup extends Block {

    public static final DirectionProperty FACING = DirectionProperty.create("facing");

    public BlockHalfCoffeeSugarCup() {
        super(Properties.of(Material.CLAY));
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
        return drinkCoffee(level, blockPos, blockState, player);
    }

    private InteractionResult drinkCoffee(Level level, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.FAIL;
        } else {
            player.getFoodData().eat(2, 1F);
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1));

            BlockState newState = CoffeeAndTeaMod.EMPTY_CUP.get().defaultBlockState();
            newState = newState.setValue(BlockEmptyCup.FACING, state.getValue(FACING));
            level.setBlock(pos, newState, 3);

            return InteractionResult.CONSUME_PARTIAL;
        }
    }

}
