package net.richardsprojects.teamod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class BlockFullCoffeeCup extends Block {

	public static final IProperty<EnumFacing> DIRECTION = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL); 
	
	public BlockFullCoffeeCup() {
		super(Material.wood);
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.495F, 0.8F);
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
		this.setDefaultState(blockState.getBaseState().withProperty(DIRECTION, EnumFacing.NORTH));
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean isFullCube() {
		return false;
	}
	
	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}
	
	@Override
	public BlockState createBlockState() {
		return new BlockState(this, DIRECTION);
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
    {
		return ((EnumFacing)state.getValue(DIRECTION)).getIndex();
    }

	@Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(DIRECTION, enumfacing);
    }
	
	@Override
	/**
	 * Called when a player places the block and is what is used to set direction
	 */
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(DIRECTION, placer.getHorizontalFacing().getOpposite());
    }
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			// add potion effect and update hunger
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 4800, 0));
			player.getFoodStats().addStats(4, 2.4F);
			
			// change the block to a half coffee cup if they are not in creative
	    	if(!player.capabilities.isCreativeMode) {
	    		int meta = this.getMetaFromState(world.getBlockState(pos));
				world.setBlockState(pos, CoffeeAndTeaModBlocks.halfCoffeeCup.getStateFromMeta(meta));
	    	}
		}
		
		return true;
	}
}
