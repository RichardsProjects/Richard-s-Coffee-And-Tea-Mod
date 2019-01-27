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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import squeek.applecore.api.food.FoodValues;
import squeek.applecore.api.food.IEdibleBlock;
import squeek.applecore.api.food.ItemFoodProxy;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;

import net.richardsprojects.teamod.CoffeeAndTeaMod;

@Optional.Interface(iface = "squeek.applecore.api.food.IEdibleBlock", modid = "applecore")
public class BlockFullCoffeeSugarCup extends Block implements IEdibleBlock {

	public static final IProperty<EnumFacing> DIRECTION = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	private boolean isEdibleAtMaxHunger = true;
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.2F, 0.0F, 0.2F, 0.8F, 0.495F, 0.8F);
	
	public BlockFullCoffeeSugarCup() {
		super(Material.WOOD);
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
		this.setDefaultState(blockState.getBaseState().withProperty(DIRECTION, EnumFacing.NORTH));
	}

	@Optional.Method(modid = "applecore")
	@Override
	public void setEdibleAtMaxHunger(boolean value)
	{
		isEdibleAtMaxHunger = value;
	}

	@Optional.Method(modid = "applecore")
	@Override
	public FoodValues getFoodValues(ItemStack itemStack)
	{
		return new FoodValues(2, 1F);
	}

	// This needs to be abstracted into an Optional method,
	// otherwise the ItemFoodProxy reference will cause problems
	@Optional.Method(modid = "applecore")
	public void onEatenCompatibility(ItemStack itemStack, EntityPlayer player)
	{
		player.getFoodStats().addStats(new ItemFoodProxy(this), itemStack);
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
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(DIRECTION, enumfacing);
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BOUNDING_BOX;
	}
	
	@Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_)
    {
        super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
    }
	
	@Override
	/**
	 * Called when a player places the block and is what is used to set direction
	 */
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return this.getDefaultState().withProperty(DIRECTION, placer.getHorizontalFacing().getOpposite());
    }
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			// add potion effect and update hunger
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 4800, 1));
			if (player.canEat(isEdibleAtMaxHunger))
			{
				if (Loader.isModLoaded("applecore"))
				{
					onEatenCompatibility(new ItemStack(this), player);
				}
				else
				{
					player.getFoodStats().addStats(2, 1F);
				}
			}
			
			// change the block to a half coffee cup if they are not in creative
	    	if(!player.capabilities.isCreativeMode) {
	    		int meta = this.getMetaFromState(world.getBlockState(pos));
				world.setBlockState(pos, CoffeeAndTeaModBlocks.halfCoffeeSugarCup.getStateFromMeta(meta));
	    	}
		}
		
		return true;
	}
}
