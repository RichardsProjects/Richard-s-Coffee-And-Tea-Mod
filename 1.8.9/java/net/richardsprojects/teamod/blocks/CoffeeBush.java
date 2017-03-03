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
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.items.CoffeeAndTeaModItems;

public class CoffeeBush extends BlockCrops implements IGrowable {

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);

	public CoffeeBush() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
        this.setTickRandomly(true);
        float f = 0.5F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        this.setCreativeTab(CoffeeAndTeaMod.teaTab);
        this.setHardness(0.0F);
        this.setStepSound(soundTypeGrass);
        this.disableStats();
	}
	
	@Override
    public boolean canPlaceBlockOn(Block ground)
    {
        return ground == Blocks.farmland;
    }
	
    @Override
    public Item getSeed()
    {
        return CoffeeAndTeaModItems.unroastedCoffeeBean;
    }

    @Override
    public Item getCrop()
    {
    	return CoffeeAndTeaModItems.unroastedCoffeeBean;
    }

}
