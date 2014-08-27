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
	
	//Set the TileEntity
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new TeaBushEntity();
	}

	//Can be grown on farmland, dirt, or grass
	protected boolean canPlaceBlockOn(Block block)
    {
        return block == Blocks.farmland;
    }
	
	//Not a normal renderType
    @Override
    public int getRenderType() {
            return -1;
    }
   
    //It's not an opaque cube
    @Override
    public boolean isOpaqueCube() {
            return false;
    }
   
    //It's not a normal block
    public boolean renderAsNormalBlock() {
            return false;
    }
	
	//Returns whether its fully grown?
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
    
    
}