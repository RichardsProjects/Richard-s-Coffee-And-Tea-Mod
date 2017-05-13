package net.richardsprojects.teamod.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.items.CoffeeAndTeaModItems;

public class BlockTeaBush extends BlockCrops implements IGrowable {

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);

	public static final AxisAlignedBB BB_0 = new AxisAlignedBB(0F, 0.0F, 0F, 1.0F, 0.25F, 1.0F);
	public static final AxisAlignedBB BB_1 = new AxisAlignedBB(0.2F, 0.0F, 0.2F, 0.8F, 0.25F, 0.8F);
	public static final AxisAlignedBB BB_2 = new AxisAlignedBB(0.17F, 0.0F, 0.17F, 0.83F, 0.36F, 0.83F);
	public static final AxisAlignedBB BB_3 = new AxisAlignedBB(0.13F, 0.0F, 0.13F, 0.86F, 0.50F, 0.86F);
	public static final AxisAlignedBB BB_4 = new AxisAlignedBB(0.115F, 0.0F, 0.115F, 0.88F, 0.62F, 0.88F);
	public static final AxisAlignedBB BB_5 = new AxisAlignedBB(0.085F, 0.0F, 0.085F, 0.91F, 0.74F, 0.91F);
	public static final AxisAlignedBB BB_6 = new AxisAlignedBB(0.055F, 0.0F, 0.050F, 0.925F, 0.86F, 0.925F);
	public static final AxisAlignedBB BB_7 = new AxisAlignedBB(0F, 0F, 0F, 1F, 1F, 1F);
	
	public BlockTeaBush() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
        this.setTickRandomly(true);
        this.setHardness(0.0F);
        this.disableStats();
	}
	
    @Override
    public Item getSeed()
    {
        return CoffeeAndTeaModItems.teaSeed;
    }

    @Override
    public Item getCrop()
    {
    	return CoffeeAndTeaModItems.teaLeaves;
    }
    
	@Override
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return false;
    }
    
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn) {
		if (state.getValue(AGE).intValue() == 0) {
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BB_0);
    	} else if (state.getValue(AGE).intValue() == 1) {
    		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BB_1);
    	} else if (state.getValue(AGE).intValue() == 2) {
    		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BB_2);
    	} else if (state.getValue(AGE).intValue() == 3) {
    		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BB_3);
    	} else if (state.getValue(AGE).intValue() == 4) {
    		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BB_4);
    	} else if (state.getValue(AGE).intValue() == 5) {
    		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BB_5);
    	} else if (state.getValue(AGE).intValue() == 6) {
    		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BB_6);
    	} else {
    		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BB_7);
    	}
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
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
}
