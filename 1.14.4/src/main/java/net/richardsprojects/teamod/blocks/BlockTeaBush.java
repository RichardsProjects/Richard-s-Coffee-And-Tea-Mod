package net.richardsprojects.teamod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.richardsprojects.teamod.items.CoffeeAndTeaModItems;

public class BlockTeaBush extends CropsBlock implements IGrowable {

	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;

	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {
			Block.makeCuboidShape(0.0D, -1.0D, 0.0D, 16.0D, 2.0D, 16.0D),
			Block.makeCuboidShape(5D, -1.0D, 5D, 11D, 3D, 11D),
			Block.makeCuboidShape(4.5D, -1.0D, 4.5D, 11.5D, 4.0D, 11.5D),
			Block.makeCuboidShape(4.0D, -1.0D, 4.0D, 12.0D, 6.0D, 12.0D),
			Block.makeCuboidShape(3.5D, -1.0D, 3.5D, 12.4D, 8.0D, 12.5D),
			Block.makeCuboidShape(2.5D, -1.0D, 2.5D, 13.5D, 10.0D, 13.5D),
			Block.makeCuboidShape(1.5D, -1.0D, 1.5D, 14.5D, 13D, 14.5D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
	};

	@Override
	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	@Override
	public int getMaxAge() {
		return 7;
	}

	@Override
	protected int getAge(BlockState state) {
		return state.get(this.getAgeProperty());
	}

	public BlockTeaBush() {
		super(Properties.create(Material.PLANTS).hardnessAndResistance(0.0F).tickRandomly());
		this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)));
	}


	protected IItemProvider getSeedsItem() {
		return CoffeeAndTeaModItems.TEA_SEED.get();
	}


	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE_BY_AGE[state.get(this.getAgeProperty())];
	}

}