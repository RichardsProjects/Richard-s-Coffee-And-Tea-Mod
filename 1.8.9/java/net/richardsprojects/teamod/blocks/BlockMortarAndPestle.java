package net.richardsprojects.teamod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.items.CoffeeAndTeaModItems;

public class BlockMortarAndPestle extends Block {

	public static final IProperty<EnumFacing> DIRECTION = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL); 
	
	public BlockMortarAndPestle() {
		super(Material.rock);
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.495F, 0.8F);
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
		this.setDefaultState(blockState.getBaseState().withProperty(DIRECTION, EnumFacing.NORTH));
		this.setHardness(4.0F);
		this.setHarvestLevel("pickaxe", 0);
	}

	@Override
	public boolean isOpaqueCube() {
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
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
    {
		ItemStack itemInUse = playerIn.inventory.getCurrentItem();
		
		
		if (itemInUse != null && itemInUse.getItem() == CoffeeAndTeaModItems.teaLeaves) {
			if (worldIn.isRemote) {
				worldIn.playAuxSFX(1020, pos, 0);
			}
			
			if (!worldIn.isRemote) {
				if (itemInUse.stackSize > 1) {
					itemInUse.stackSize--;
				} else {
					playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, null);
				}
				EntityItem item = new EntityItem(playerIn.worldObj, pos.getX(), pos.getY() + 1, pos.getZ(), 
						new ItemStack(CoffeeAndTeaModItems.groundTeaLeaves, 1));
				worldIn.spawnEntityInWorld(item);
			}
		}
    }

}
