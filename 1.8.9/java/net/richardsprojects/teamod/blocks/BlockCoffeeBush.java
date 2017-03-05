package net.richardsprojects.teamod.blocks;

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
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.items.CoffeeAndTeaModItems;

public class BlockCoffeeBush extends BlockCrops implements IGrowable {

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0,
			7);

	public BlockCoffeeBush() {
		this.setDefaultState(this.blockState.getBaseState().withProperty(AGE,
				Integer.valueOf(0)));
		this.setTickRandomly(true);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
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
    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
    	float f = 0.5F;
    	
    	if (state.getValue(AGE).intValue() == 0) {
    		return new AxisAlignedBB(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
    	} else if (state.getValue(AGE).intValue() == 1) {
    		return new AxisAlignedBB(0.2F, 0.0F, 0.2F, 0.8F, 0.25F, 0.8F);
    	} else if (state.getValue(AGE).intValue() == 2) {
    		return new AxisAlignedBB(0.17F, 0.0F, 0.17F, 0.83F, 0.36F, 0.83F);
    	} else if (state.getValue(AGE).intValue() == 3) {
    		return new AxisAlignedBB(0.13F, 0.0F, 0.13F, 0.86F, 0.50F, 0.86F);
    	} else if (state.getValue(AGE).intValue() == 4) {
    		return new AxisAlignedBB(0.115F, 0.0F, 0.115F, 0.88F, 0.62F, 0.88F);
    	} else if (state.getValue(AGE).intValue() == 5) {
    		return new AxisAlignedBB(0.085F, 0.0F, 0.085F, 0.91F, 0.74F, 0.91F);
    	} else if (state.getValue(AGE).intValue() == 6) {
    		return new AxisAlignedBB(0.055F, 0.0F, 0.050F, 0.925F, 0.86F, 0.925F);
    	} else {
    		return new AxisAlignedBB(0F, 0F, 0F, 1F, 1F, 1F);
    	}
    }


}
