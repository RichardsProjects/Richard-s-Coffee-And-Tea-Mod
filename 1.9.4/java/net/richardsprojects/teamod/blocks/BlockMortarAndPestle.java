package net.richardsprojects.teamod.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.items.CoffeeAndTeaModItems;
import net.richardsprojects.teamod.tileentity.TileEntityMortarAndPestle;

public class BlockMortarAndPestle extends Block implements ITileEntityProvider {

	public static final IProperty<EnumFacing> DIRECTION = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL); 
	
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.2F, 0.0F, 0.2F, 0.8F, 0.495F, 0.8F);
	
	public BlockMortarAndPestle() {
		super(Material.ROCK);
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
		this.setDefaultState(blockState.getBaseState().withProperty(DIRECTION, EnumFacing.NORTH));
		this.setHardness(4.0F);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, DIRECTION);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BOUNDING_BOX;
	}
	
	@Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn)
    {
        super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
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
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, 
			EnumFacing side, float hitX, float hitY, float hitZ) {
		
		ItemStack itemInUse = player.inventory.getCurrentItem();
		boolean reduceDurability = false;
		
		if (itemInUse != null && itemInUse.getItem() == CoffeeAndTeaModItems.teaLeaves) {
			reduceDurability = true;
			if (world.isRemote) {
				world.playEvent(1030, pos, 0);
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
				world.playEvent(1030, pos, 0);
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
				world.setBlockState(pos, Blocks.AIR.getBlockState().getBaseState());
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
	
	/**
	 * Used to drop a "Mortar and Pestle" item with the corresponding durability damage.
	 */
	@Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TileEntityMortarAndPestle tile = (TileEntityMortarAndPestle) worldIn.getTileEntity(pos);
       	int itemDamage = 64 - tile.getDurability();
       	
       	if (itemDamage < 64) {
       		ItemStack pestle = new ItemStack(CoffeeAndTeaModBlocks.mortarAndPestle, 1);
       		pestle.setItemDamage(itemDamage);
       		EntityItem item = new EntityItem(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(), pestle);
       		worldIn.spawnEntityInWorld(item);
       	}	
        
        super.breakBlock(worldIn, pos, state);
    }
}
