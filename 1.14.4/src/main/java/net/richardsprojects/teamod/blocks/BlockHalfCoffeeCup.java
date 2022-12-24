package net.richardsprojects.teamod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class BlockHalfCoffeeCup extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public BlockHalfCoffeeCup() {
        super(Block.Properties.create(Material.CLAY).hardnessAndResistance(0.1F));
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    }

    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> stateContainer) {
        stateContainer.add(new IProperty[]{FACING});
    }

    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return this.getDefaultState().with(FACING, p_196258_1_.getPlacementHorizontalFacing().getOpposite());
    }

    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }

    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            return this.drinkCoffee(worldIn, pos, state, player);
        } else {
            ItemStack itemstack = player.getHeldItem(handIn);
            return this.drinkCoffee(worldIn, pos, state, player) || itemstack.isEmpty();
        }
    }

    private boolean drinkCoffee(IWorld worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canEat(false)) {
            return false;
        } else {
            player.getFoodStats().addStats(2, 0.1F);
            BlockState newState = CoffeeAndTeaModBlocks.EMPTY_CUP.get().getDefaultState();
            newState.with(BlockEmptyCup.FACING, state.get(BlockHalfCoffeeCup.FACING));
            worldIn.setBlockState(pos, newState, 3);
            return true;
        }
    }
}