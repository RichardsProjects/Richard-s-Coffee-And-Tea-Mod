package net.richardsprojects.teamod.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.items.CoffeeAndTeaModItems;

public class BlockCoffeeBush extends BlockCrops implements IGrowable {

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);
	
	public static final AxisAlignedBB BB_0 = new AxisAlignedBB(0F, 0.0F, 0F, 1.0F, 0.25F, 1.0F);
	public static final AxisAlignedBB BB_1 = new AxisAlignedBB(0.2F, 0.0F, 0.2F, 0.8F, 0.25F, 0.8F);
	public static final AxisAlignedBB BB_2 = new AxisAlignedBB(0.17F, 0.0F, 0.17F, 0.83F, 0.36F, 0.83F);
	public static final AxisAlignedBB BB_3 = new AxisAlignedBB(0.13F, 0.0F, 0.13F, 0.86F, 0.50F, 0.86F);
	public static final AxisAlignedBB BB_4 = new AxisAlignedBB(0.115F, 0.0F, 0.115F, 0.88F, 0.62F, 0.88F);
	public static final AxisAlignedBB BB_5 = new AxisAlignedBB(0.085F, 0.0F, 0.085F, 0.91F, 0.74F, 0.91F);
	public static final AxisAlignedBB BB_6 = new AxisAlignedBB(0.055F, 0.0F, 0.050F, 0.925F, 0.86F, 0.925F);
	public static final AxisAlignedBB BB_7 = new AxisAlignedBB(0F, 0F, 0F, 1F, 1F, 1F);

	public BlockCoffeeBush() {
		this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0));
		this.setTickRandomly(true);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		this.setHardness(0.0F);
		this.setStepSound(soundTypeGrass);
		this.disableStats();
	}

	@Override
	public boolean canPlaceBlockOn(Block ground) {
		return ground == Blocks.farmland;
	}

	@Override
	public Item getSeed() {
		return CoffeeAndTeaModItems.unroastedCoffeeBean;
	}

	@Override
	public Item getCrop() {
		return CoffeeAndTeaModItems.unroastedCoffeeBean;
	}
	
	@Override
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return false;
    }
	
	@Override
	public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, 
			AxisAlignedBB mask, List<AxisAlignedBB> list, Entity collidingEntity) {
		if (state.getValue(AGE).intValue() == 0) {
    		this.setBlockBounds((float) BB_0.minX, (float) BB_0.minY, (float) BB_0.minZ, 
    				(float) BB_0.maxX, (float) BB_0.maxY, (float) BB_0.maxZ);
    		super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
    	} else if (state.getValue(AGE).intValue() == 1) {
    		this.setBlockBounds((float) BB_1.minX, (float) BB_1.minY, (float) BB_1.minZ, 
    				(float) BB_1.maxX, (float) BB_1.maxY, (float) BB_1.maxZ);
    		super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
    	} else if (state.getValue(AGE).intValue() == 2) {
    		this.setBlockBounds((float) BB_2.minX, (float) BB_2.minY, (float) BB_2.minZ, 
    				(float) BB_2.maxX, (float) BB_2.maxY, (float) BB_2.maxZ);
    		super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
    	} else if (state.getValue(AGE).intValue() == 3) {
    		this.setBlockBounds((float) BB_3.minX, (float) BB_3.minY, (float) BB_3.minZ, 
    				(float) BB_3.maxX, (float) BB_3.maxY, (float) BB_3.maxZ);
    		super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
    	} else if (state.getValue(AGE).intValue() == 4) {
    		this.setBlockBounds((float) BB_4.minX, (float) BB_4.minY, (float) BB_4.minZ, 
    				(float) BB_4.maxX, (float) BB_4.maxY, (float) BB_4.maxZ);
    		super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
    	} else if (state.getValue(AGE).intValue() == 5) {
    		this.setBlockBounds((float) BB_5.minX, (float) BB_5.minY, (float) BB_5.minZ, 
    				(float) BB_5.maxX, (float) BB_5.maxY, (float) BB_5.maxZ);
    		super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
    	} else if (state.getValue(AGE).intValue() == 6) {
    		this.setBlockBounds((float) BB_6.minX, (float) BB_6.minY, (float) BB_6.minZ, 
    				(float) BB_6.maxX, (float) BB_6.maxY, (float) BB_6.maxZ);
    		super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
    	} else {
    		this.setBlockBounds((float) BB_7.minX, (float) BB_7.minY, (float) BB_7.minZ, 
    				(float) BB_7.maxX, (float) BB_7.maxY, (float) BB_7.maxZ);
    		super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
    	}
    }
	
	@Override
    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
    	if (state.getValue(AGE).intValue() == 0)
    		return BB_0;
    	else if (state.getValue(AGE).intValue() == 1) 
    		return BB_1;
    	else if (state.getValue(AGE).intValue() == 2) 
    		return BB_2;
    	else if (state.getValue(AGE).intValue() == 3) 
    		return BB_3;
    	else if (state.getValue(AGE).intValue() == 4) 
    		return BB_4;
    	else if (state.getValue(AGE).intValue() == 5) 
    		return BB_5;
    	else if (state.getValue(AGE).intValue() == 6) 
    		return BB_6;
    	else 										  
    		return BB_7;
    }
    
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
    	IBlockState state = worldIn.getBlockState(pos);
    	
    	if (state.getValue(AGE).intValue() == 0) {
    		this.setBlockBounds((float) BB_0.minX, (float) BB_0.minY, (float) BB_0.minZ, 
    				(float) BB_0.maxX, (float) BB_0.maxY, (float) BB_0.maxZ);
    	} else if (state.getValue(AGE).intValue() == 1) {
    		this.setBlockBounds((float) BB_1.minX, (float) BB_1.minY, (float) BB_1.minZ, 
    				(float) BB_1.maxX, (float) BB_1.maxY, (float) BB_1.maxZ);
    	} else if (state.getValue(AGE).intValue() == 2) {
    		this.setBlockBounds((float) BB_2.minX, (float) BB_2.minY, (float) BB_2.minZ, 
    				(float) BB_2.maxX, (float) BB_2.maxY, (float) BB_2.maxZ);
    	} else if (state.getValue(AGE).intValue() == 3) {
    		this.setBlockBounds((float) BB_3.minX, (float) BB_3.minY, (float) BB_3.minZ, 
    				(float) BB_3.maxX, (float) BB_3.maxY, (float) BB_3.maxZ);
    	} else if (state.getValue(AGE).intValue() == 4) {
    		this.setBlockBounds((float) BB_4.minX, (float) BB_4.minY, (float) BB_4.minZ, 
    				(float) BB_4.maxX, (float) BB_4.maxY, (float) BB_4.maxZ);
    	} else if (state.getValue(AGE).intValue() == 5) {
    		this.setBlockBounds((float) BB_5.minX, (float) BB_5.minY, (float) BB_5.minZ, 
    				(float) BB_5.maxX, (float) BB_5.maxY, (float) BB_5.maxZ);
    	} else if (state.getValue(AGE).intValue() == 6) {
    		this.setBlockBounds((float) BB_6.minX, (float) BB_6.minY, (float) BB_6.minZ, 
    				(float) BB_6.maxX, (float) BB_6.maxY, (float) BB_6.maxZ);
    	} else {
    		this.setBlockBounds((float) BB_7.minX, (float) BB_7.minY, (float) BB_7.minZ, 
    				(float) BB_7.maxX, (float) BB_7.maxY, (float) BB_7.maxZ);
    	}
    }
}
