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
import net.richardsprojects.teamod.entity.TableRightEntity;

public class BlockTableRight extends BlockContainer {
	
	protected BlockTableRight(Material mat)
	{
		super(mat);
		
		//Set Block Bounds
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, .75F, 1.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return new TableRightEntity();
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
	
	public static Block tableRight;
	
	public static void initializeBlock()
	{
		tableRight = new BlockTableRight(Material.wood).setBlockName("tableRight").setBlockTextureName("iron_block").setHardness(1F).setCreativeTab(TeaMod.teaModTab);
	}
	
	public static void registerBlock()
	{
		GameRegistry.registerBlock(tableRight, tableRight.getUnlocalizedName());
	}
	
	/**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
	//TODO: Change this to the item when it added
    @SideOnly(Side.CLIENT)
    public Item getItemDropped(int p_149650_1_, Random rnd, int p_149650_3_)
    {
        return ItemEmptyCup.emptyCup;
    }
    
    //TODO: Change this to the item when it added
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
	{
		return new ItemStack(ItemEmptyCup.emptyCup, 1);
	}
}
