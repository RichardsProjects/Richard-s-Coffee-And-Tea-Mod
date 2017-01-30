package net.richardsprojects.teamod.main;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.richardsprojects.teamod.entity.EmptyCupEntity;

public class BlockEmptyCup extends BlockContainer {
	
	protected BlockEmptyCup(Material mat)
	{
		super(mat);
		
		//Set Block Bounds
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.495F, 0.8F);
	}

	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return new EmptyCupEntity();
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
	
	public static Block emptyCup;
	
	public static void initializeBlock()
	{
		emptyCup = new BlockEmptyCup(Material.wood).setBlockName("emptyCup").setBlockTextureName("iron_block").setHardness(1F).setCreativeTab(null);
	}
	
	public static void registerBlock()
	{
		GameRegistry.registerBlock(emptyCup, emptyCup.getUnlocalizedName());
	}
	
	/**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
	//TODO: Don't know if this needs to be only client side or not
    @SideOnly(Side.CLIENT)
    public Item getItemDropped(int p_149650_1_, Random rnd, int p_149650_3_)
    {
        return ItemEmptyCup.emptyCup;
    }
    
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
	{
		return new ItemStack(ItemEmptyCup.emptyCup, 1);
	}
}
