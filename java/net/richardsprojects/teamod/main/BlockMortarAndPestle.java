package net.richardsprojects.teamod.main;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.richardsprojects.teamod.entity.FullTeaCupEntity;
import net.richardsprojects.teamod.entity.MortarAndPestleEntity;

public class BlockMortarAndPestle extends BlockContainer {

	protected BlockMortarAndPestle(Material mat){
		super(mat);
		
		//Set Block Bounds
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.85F, 0.65F, 0.85F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return new MortarAndPestleEntity();
	}

	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player)
	{
		//This event only occurs if the item already has durability
		if(!world.isRemote)
		{
			MortarAndPestleEntity t = (MortarAndPestleEntity) world.getTileEntity(x, y, z);
			int durability = t.getDurability();
			
			//Use the below code to spawn in the damaged item
			EntityItem entityitem = new EntityItem(world, x, y + 2, z, new ItemStack(ItemMortarAndPestle.mortarAndPestle, 1, 64 - durability));
			entityitem.delayBeforeCanPickup = 10;
			
			world.spawnEntityInWorld(entityitem);			
		}
	}
	
	public static Block mortarAndPestle;
	
	public static void initializeBlock()
	{
		mortarAndPestle = new BlockMortarAndPestle(Material.rock).setBlockName("mortarAndPestle").setBlockTextureName("stone").setHardness(1F).setCreativeTab(null);
	}
	
	public static void registerBlock()
	{
		GameRegistry.registerBlock(mortarAndPestle, mortarAndPestle.getUnlocalizedName());
	}
	
	public static void mainRegistry()
	{
		initializeBlock();
		registerBlock();
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
    
    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int idk1, float idk2, float idk3, float idk4)
    {
   		//Check to make sure it's not null so there is no NPE
   		if(player.inventory.getCurrentItem() != null)
   		{
   			//Handles Coffee Beans
   			if(player.inventory.getCurrentItem().getItem() == ItemCoffeeBeans.roastedBean)
   			{
   				//Reduce Durability of Block
   				if(!world.isRemote)
   				{
   					MortarAndPestleEntity t = (MortarAndPestleEntity) world.getTileEntity(x, y, z);
   					t.reduceDurability(world.getBlock(x, y, z), player, world, "c");
   					if(t.getDurability() < 1)
   					{
   						world.setBlockToAir(x, y, z);
	   					world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(Blocks.stone) + (0 << 12));
   					}
   				}
   								
   				
   	            //Decrease Stack size
   	            player.inventory.getCurrentItem().stackSize--;
   	            
   	            //Add Coffee Grounds to the player's inventory

   	            
   	            if(!world.isRemote)
   	            {
					EntityItem entityItem;
					entityItem = new EntityItem(world, player.lastTickPosX, player.lastTickPosY + 2, player.lastTickPosZ, new ItemStack(ItemCoffeeGrounds.coffeeGrounds, 1));
					world.spawnEntityInWorld(entityItem);
   	            }
   	        }
   			//Handles Tea Leaves
   			if(player.inventory.getCurrentItem().getItem() == ItemTeaLeaves.teaLeaves)
   			{
   				//Reduce Durability of Block
   				if(!world.isRemote)
   				{
   					MortarAndPestleEntity t = (MortarAndPestleEntity) world.getTileEntity(x, y, z);
   					t.reduceDurability(world.getBlock(x, y, z), player, world, "t");
   					if(t.getDurability() < 1)
   					{
   						world.setBlockToAir(x, y, z);
	   					world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(Blocks.stone) + (0 << 12));
   					}
   				}
   								
   				
   	            //Decrease Stack size
   	            player.inventory.getCurrentItem().stackSize--;
   	            
   	            //Add Coffee Grounds to the player's inventory

   	            
   	            if(!world.isRemote)
   	            {
					EntityItem entityItem;
					double pX, pY, pZ;
					pX = player.lastTickPosX;
					pY = player.lastTickPosY;
					pZ = player.lastTickPosZ;
					entityItem = new EntityItem(world, pX, pY + 2, pZ, new ItemStack(ItemGroundTeaLeaves.groundTeaLeaves, 1));
					world.spawnEntityInWorld(entityItem);
   	            }
   	        }
   		}          
   		return true;
    }
   
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
	{
		return null;
	}
    
	//TODO: Don't know if this needs to be only client side or not
    @SideOnly(Side.CLIENT)
    public Item getItemDropped(int p_149650_1_, Random rnd, int p_149650_3_)
    {
        return null;
    }
}