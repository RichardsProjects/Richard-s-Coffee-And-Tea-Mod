package net.richardsprojects.teamod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.*;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.richardsprojects.teamod.items.CoffeeAndTeaModItems;
import net.richardsprojects.teamod.tile.TileMortarAndPestle;

import javax.annotation.Nullable;

public class BlockMortarAndPestle extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public BlockMortarAndPestle() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(4.0F));
        this.setDefaultState(this.stateContainer.getBaseState().with(this.FACING, Direction.NORTH));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileMortarAndPestle();
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    }

    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> stateContainer) {
        stateContainer.add(new IProperty[]{FACING});
    }

    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return (BlockState)this.getDefaultState().with(FACING, p_196258_1_.getPlacementHorizontalFacing().getOpposite());
    }

    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }

    @Override
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack itemInUse = player.inventory.getCurrentItem();
        boolean reduceDurability = false;

        if (itemInUse != null && itemInUse.getItem() == CoffeeAndTeaModItems.ROASTED_COFFEE_BEAN.get()) {
            reduceDurability = true;
            if (world.isRemote) {
                world.playEvent(1030, pos, 0);
            }

            if (!world.isRemote) {
                if (itemInUse.getCount() > 0) {
                    itemInUse.shrink(1);
                } else {
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                }
                ItemEntity item = new ItemEntity(player.world, pos.getX(), pos.getY() + 1, pos.getZ(),
                        new ItemStack(CoffeeAndTeaModItems.COFFEE_GROUNDS.get(), 1));
                world.addEntity(item);
            }
        }

        if (itemInUse != null && itemInUse.getItem() == CoffeeAndTeaModItems.TEA_LEAVES.get()) {
            reduceDurability = true;
            if (world.isRemote) {
                world.playEvent(1030, pos, 0);
            }

            if (!world.isRemote) {
                if (itemInUse.getCount() > 0) {
                    itemInUse.shrink(1);
                } else {
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                }
                ItemEntity item = new ItemEntity(player.world, pos.getX(), pos.getY() + 1, pos.getZ(),
                        new ItemStack(CoffeeAndTeaModItems.GROUND_TEA_LEAVES.get(), 1));
                world.addEntity(item);
            }
        }

        if (reduceDurability) {
            TileMortarAndPestle tile = (TileMortarAndPestle) world.getTileEntity(pos);

            // notify the player
            int newDurability = tile.getDurability() - 1;
            if (newDurability <= 10 && newDurability > 0 && world.isRemote) {
                player.sendMessage(new StringTextComponent("The mortar and pestle has " + newDurability + " uses left."));
            }

            // update durability
            tile.setDurability(newDurability);
            if (tile.getDurability() == 0) {
                world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }

            // make sound on break
            if (newDurability == 0 && world.isRemote) {
                world.playEvent(1029, pos, 0);
            }
        }

        return true;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        TileEntity tile = worldIn.getTileEntity(pos);
        if (tile != null && tile instanceof TileMortarAndPestle) {
            TileMortarAndPestle mortarAndPestle = (TileMortarAndPestle) tile;
            mortarAndPestle.setDurability(64 - stack.getDamage());
        }
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            TileEntity tile = worldIn.getTileEntity(pos);
            if (tile != null && tile instanceof TileMortarAndPestle) {
                TileMortarAndPestle mortarAndPestle = (TileMortarAndPestle) tile;

                if (mortarAndPestle.getDurability() > 0) {
                    ItemStack pestle = new ItemStack(CoffeeAndTeaModItems.ITEM_BLOCK_MORTAR_AND_PESTLE.get(), 1);

                    int itemDamage = 64 - mortarAndPestle.getDurability();
                    pestle.setDamage(itemDamage);

                    ItemEntity item = new ItemEntity(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(), pestle);
                    worldIn.addEntity(item);
                }

            }

            super.onReplaced(state, worldIn, pos, newState, isMoving);
        }
    }

}
