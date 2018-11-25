package net.richardsprojects.teamod.blocks;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class BlockEmptyCup extends Block {

	public static final IProperty<EnumFacing> DIRECTION = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL); 
	
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.2F, 0.0F, 0.2F, 0.8F, 0.495F, 0.8F);
	
	public BlockEmptyCup() {
		super(Material.WOOD);
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
		this.setDefaultState(blockState.getBaseState().withProperty(DIRECTION, EnumFacing.NORTH));
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, DIRECTION);
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
    {
		return ((EnumFacing)state.getValue(DIRECTION)).getIndex();
    }

	@Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(DIRECTION, enumfacing);
    }
	
	@Override
	/**
	 * Called when a player places the block and is what is used to set direction
	 */
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand)
    {
        return this.getDefaultState().withProperty(DIRECTION, placer.getHorizontalFacing().getOpposite());
    }
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_) {
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
    	return BOUNDING_BOX;
    }
}
