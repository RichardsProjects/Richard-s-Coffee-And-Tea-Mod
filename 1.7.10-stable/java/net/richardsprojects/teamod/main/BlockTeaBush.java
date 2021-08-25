package net.richardsprojects.teamod.main;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.richardsprojects.teamod.entity.CoffeeBushEntity;
import net.richardsprojects.teamod.entity.TeaBushEntity;

public class BlockTeaBush extends BlockContainer implements IGrowable {

	protected BlockTeaBush(Material mat) {
		super(mat);
		
		this.setTickRandomly(true);
		float f = 0.5F;
	    this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
	    this.setCreativeTab((CreativeTabs)null);
	    this.setHardness(0.0F);
	    this.setStepSound(soundTypeGrass);
	    this.disableStats();
	}
	
	public static void mainRegistry()
	{
		initializeBlock();
		registerBlock();
	}
	
	//Used to handle crops growing
    public void updateTick(World world, int x, int y, int z, Random random)
    {
    	if (world.getBlockLightValue(x, y + 1, z) >= 9)
    	{
    		int metadata = world.getBlockMetadata(x, y, z);

    		if (metadata < 7)
    		{
    			if (random.nextInt(2) == 0)
    			{
    				metadata++;
    				world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
    			}
    		}
    	}
    }
	
	public static Block teaBush;
	
	public static void initializeBlock()
	{
		teaBush = new BlockTeaBush(Material.plants).setBlockName("teaBush").setBlockTextureName("teamod:TeaStage4_5");
	}
	
	public static void registerBlock()
	{
		GameRegistry.registerBlock(teaBush, teaBush.getUnlocalizedName());
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new TeaBushEntity();
	}

	protected boolean canPlaceBlockOn(Block block)
    {
        return block == Blocks.farmland;
    }
	
	@Override
    public int getRenderType() {
            return -1;
    }
   
    @Override
    public boolean isOpaqueCube() {
            return false;
    }
   
    public boolean renderAsNormalBlock() {
            return false;
    }
	
	@Override
	public boolean func_149851_a(World world, int x, int y, int z, boolean flag)
	{		
		return world.getBlockMetadata(x, y, z) != 7;
	}

	//I have no idea what this is for.
	@Override
	public boolean func_149852_a(World world, Random random, int x, int y, int z)
	{
		return true;
	}

	//Handles Bonemeal
	@Override
	public void func_149853_b(World world, Random random, int x, int y, int z)
	{
		int metadata = 0;
		metadata = world.getBlockMetadata(x, y, z) + MathHelper.getRandomIntegerInRange(world.rand, 2, 5);

        if (metadata > 7)
        {
            metadata = 7;
        }

        world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
	}
	
	protected Item func_149866_i()
    {
        return ItemTeaSeeds.teaSeeds;
    }

    protected Item func_149865_P()
    {
    	return null;
    }
    
    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return this.func_149866_i();
    }
    
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }
    
	/**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
	//TODO: Don't know if this needs to be only client side or not
    @SideOnly(Side.CLIENT)
    public Item getItemDropped(int p_149650_1_, Random rnd, int p_149650_3_)
    {
        return null;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_)
    {
        this.setBlockBoundsBasedOnState(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
        return super.getSelectedBoundingBoxFromPool(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        this.setBlockBoundsBasedOnState(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
        return super.getCollisionBoundingBoxFromPool(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(World world, int x, int y, int z)
    {
        if(world.getBlockMetadata(x, y, z) == 0)
        {
        	this.setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 0.25F, 1F);
        }
        else if(world.getBlockMetadata(x, y, z) == 1)
        {
        	this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.25F, 0.8F);
        }
        else if(world.getBlockMetadata(x, y, z) == 2)
        {
        	this.setBlockBounds(0.17F, 0.0F, 0.17F, 0.83F, 0.36F, 0.83F);
        }
        else if(world.getBlockMetadata(x, y, z) == 3)
        {
        	this.setBlockBounds(0.13F, 0.0F, 0.13F, 0.86F, 0.50F, 0.86F);
        }
        else if(world.getBlockMetadata(x, y, z) == 4)
        {
        	this.setBlockBounds(0.115F, 0.0F, 0.115F, 0.88F, 0.62F, 0.88F);
        }
        else if(world.getBlockMetadata(x, y, z) == 5)
        {
        	this.setBlockBounds(0.085F, 0.0F, 0.085F, 0.91F, 0.74F, 0.91F);
        }
        else if(world.getBlockMetadata(x, y, z) == 6)
        {
        	this.setBlockBounds(0.055F, 0.0F, 0.050F, 0.925F, 0.86F, 0.925F);
        }
        else if(world.getBlockMetadata(x, y, z) == 7)
        {
        	this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
        }
    }
    
}