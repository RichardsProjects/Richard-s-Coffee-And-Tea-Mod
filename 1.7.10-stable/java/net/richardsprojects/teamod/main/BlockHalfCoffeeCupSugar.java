package net.richardsprojects.teamod.main;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.richardsprojects.teamod.entity.HalfCoffeeCupEntity;

public class BlockHalfCoffeeCupSugar extends BlockContainer {
	
	protected BlockHalfCoffeeCupSugar(Material mat)
	{
		super(mat);
		
		//Set Block Bounds
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.495F, 0.8F);
	}

	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return new HalfCoffeeCupEntity();
	}
	
    //You don't want the normal render type, or it wont render properly.
    @Override
    public int getRenderType() {
            return -1;
    }
   
    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube() {
            return false;
    }
   
    //It's not a normal block, so you need this too.
    public boolean renderAsNormalBlock() {
            return false;
    }
    
    public static void mainRegistry()
	{
		initializeBlock();
		registerBlock();
	}
	
	public static Block halfCoffeeCup;
	
	public static void initializeBlock()
	{
		halfCoffeeCup = new BlockHalfCoffeeCupSugar(Material.wood).setBlockName("halfCoffeeCupSugar").setBlockTextureName("iron_block").setHardness(1F).setCreativeTab(null);
	}
	
	public static void registerBlock()
	{
		GameRegistry.registerBlock(halfCoffeeCup, halfCoffeeCup.getUnlocalizedName());
	}
	
	/**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
	//TODO: Don't know if this needs to be only client side or not
    @SideOnly(Side.CLIENT)
    public Item getItemDropped(int p_149650_1_, Random rnd, int p_149650_3_)
    {
        return ItemCoffeeCupSugar.halfCoffeeCupSugar;
    }
    
    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int idk1, float idk2, float idk3, float idk4)
    {
    	//Check if the player is in creative mode
    	if(player.capabilities.isCreativeMode)
		{
			if(!world.isRemote)
			{
				//Add Potion Effect
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 1200, 1));
				
				//Fill Up Hunger
				player.getFoodStats().addStats(4, 2.4F);
			}
		}
		else
		{
			if(!world.isRemote)
			{
				//Add Potion Effect
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 9600, 1));
				
				//Current Cup metadata
				int metadata = world.getBlockMetadata(x, y, z);
				world.setBlock(x, y, z, BlockEmptyCup.emptyCup, metadata, 3);
				
				//Fill Up Hunger
				player.getFoodStats().addStats(4, 2.4F);
			}
		}
        return true;
    }
    
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
	{
		return new ItemStack(ItemCoffeeCupSugar.halfCoffeeCupSugar, 1);
	}
	
	protected Item func_149866_i()
    {
		return ItemCoffeeCupSugar.halfCoffeeCupSugar;
    }
}