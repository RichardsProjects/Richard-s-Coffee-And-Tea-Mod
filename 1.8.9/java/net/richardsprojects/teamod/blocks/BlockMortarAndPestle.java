package net.richardsprojects.teamod.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.items.CoffeeAndTeaModItems;
import net.richardsprojects.teamod.tileentity.TileEntityMortarAndPestle;

public class BlockMortarAndPestle extends Block implements ITileEntityProvider {

	public static final IProperty<EnumFacing> DIRECTION = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL); 
	
	public BlockMortarAndPestle() {
		super(Material.rock);
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.495F, 0.8F);
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
		this.setDefaultState(blockState.getBaseState().withProperty(DIRECTION, EnumFacing.NORTH));
		this.setHardness(4.0F);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean isFullCube() {
		return false;
	}
	
	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}
	
	@Override
	public BlockState createBlockState() {
		return new BlockState(this, DIRECTION);
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
    {
		return ((EnumFacing)state.getValue(DIRECTION)).getIndex();
    }

	@Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(DIRECTION, enumfacing);
    }
	
	@Override
	/**
	 * Called when a player places the block and is what is used to set direction
	 */
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(DIRECTION, placer.getHorizontalFacing().getOpposite());
    }
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		ItemStack itemInUse = player.inventory.getCurrentItem();
		boolean reduceDurability = false;
		
		if (itemInUse != null && itemInUse.getItem() == CoffeeAndTeaModItems.teaLeaves) {
			reduceDurability = true;
			if (world.isRemote) {
				world.playAuxSFX(1020, pos, 0);
			}
			
			if (!world.isRemote) {
				if (itemInUse.stackSize > 1) {
					itemInUse.stackSize--;
				} else {
					player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				}
				EntityItem item = new EntityItem(player.worldObj, pos.getX(), pos.getY() + 1, pos.getZ(), 
						new ItemStack(CoffeeAndTeaModItems.groundTeaLeaves, 1));
				world.spawnEntityInWorld(item);
			}
		}
		
		if (itemInUse != null && itemInUse.getItem() == CoffeeAndTeaModItems.roastedCoffeeBean) {
			reduceDurability = true;
			if (world.isRemote) {
				world.playAuxSFX(1020, pos, 0);
			}
			
			if (!world.isRemote) {
				if (itemInUse.stackSize > 1) {
					itemInUse.stackSize--;
				} else {
					player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				}
				EntityItem item = new EntityItem(player.worldObj, pos.getX(), pos.getY() + 1, pos.getZ(), 
						new ItemStack(CoffeeAndTeaModItems.coffeeGrounds, 1));
				world.spawnEntityInWorld(item);
			}
		}
		
		if (reduceDurability) {
			TileEntityMortarAndPestle tile = (TileEntityMortarAndPestle) world.getTileEntity(pos);
			tile.setDurability(tile.getDurability() - 1);
			if (tile.getDurability() == 0) {
				world.setBlockToAir(pos);
			}
		}
		
		return true;
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityMortarAndPestle();
	}
	
	@Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		int durability = stack.getItemDamage();
		TileEntityMortarAndPestle tile = (TileEntityMortarAndPestle) worldIn.getTileEntity(pos);
		durability = 64 - durability;
		tile.setDurability(durability);
    }
	
	@Override
	/**
	 * Used to drop a "Mortar and Pestle" item with the corresponding durability damage.
	 */
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TileEntityMortarAndPestle tile = (TileEntityMortarAndPestle) worldIn.getTileEntity(pos);
       	int itemDamage = 64 - tile.getDurability();
       	ItemStack pestle = new ItemStack(CoffeeAndTeaModBlocks.mortarAndPestle, 1);
       	pestle.setItemDamage(itemDamage);
       	EntityItem item = new EntityItem(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(), pestle);
        worldIn.spawnEntityInWorld(item);
        
        super.breakBlock(worldIn, pos, state);
    }
}
