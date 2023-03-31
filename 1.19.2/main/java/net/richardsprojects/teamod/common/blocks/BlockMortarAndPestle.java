package net.richardsprojects.teamod.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.common.blocks.entities.BlockEntityMortarAndPestle;
import org.jetbrains.annotations.Nullable;

public class BlockMortarAndPestle extends BaseEntityBlock {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public BlockMortarAndPestle() {
        super(BlockBehaviour.Properties.of(Material.STONE).explosionResistance(4.0F));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_48689_) {
        return this.defaultBlockState().setValue(FACING, p_48689_.getHorizontalDirection().getOpposite());
    }

    public boolean propagatesSkylightDown(BlockState p_49928_, BlockGetter p_49929_, BlockPos p_49930_) {
        return true;
    }

    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult result) {
        // TODO: implement grinding coffee beans

        ItemStack itemInUse = player.getInventory().getSelected();
        boolean reduceDurability = false;

        if (itemInUse != null && itemInUse.getItem() == CoffeeAndTeaMod.ROASTED_COFFEE_BEAN.get()) {
            reduceDurability = true;
            if (level.isClientSide) {
                level.levelEvent(1030, blockPos, 0);
            }

            if (!level.isClientSide) {
                if (itemInUse.getCount() > 0) {
                    itemInUse.shrink(1);
                } else {
                    player.getInventory().setItem(player.getInventory().selected, null);
                }
                ItemEntity item = new ItemEntity(player.level, blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(),
                        new ItemStack(CoffeeAndTeaMod.COFFEE_GROUNDS.get(), 1));
                level.addFreshEntity(item);
            }
        }

        if (itemInUse != null && itemInUse.getItem() == CoffeeAndTeaMod.TEA_LEAVES.get()) {
            reduceDurability = true;
            if (level.isClientSide) {
                level.levelEvent(1030, blockPos, 0);
            }

            if (!level.isClientSide) {
                if (itemInUse.getCount() > 0) {
                    itemInUse.shrink(1);
                } else {
                    player.getInventory().setItem(player.getInventory().selected, null);
                }
                ItemEntity item = new ItemEntity(player.level, blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(),
                        new ItemStack(CoffeeAndTeaMod.GROUND_TEA_LEAVES.get(), 1));
                level.addFreshEntity(item);
            }
        }

        if (reduceDurability) reduceDurability(player, level, blockPos);

        return InteractionResult.SUCCESS;
    }

    private void reduceDurability(Player player, Level level, BlockPos pos) {
        BlockEntityMortarAndPestle entity = (BlockEntityMortarAndPestle) level.getBlockEntity(pos);
        if (entity == null) return;

        // notify the player
        int newDurability = entity.getDurability() - 1;
        if (newDurability <= 10 && newDurability > 0 && !level.isClientSide) {
            player.sendSystemMessage(Component.literal("The mortar and pestle has " + newDurability + " uses left."));
        }

        // update durability
        entity.setDurability(newDurability);
        if (entity.getDurability() == 0) {
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        }

        if (newDurability == 0 && level.isClientSide) {
            level.levelEvent(1029, pos, 0);
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState pNewState, boolean pIsMoving) {
        if (state.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof BlockEntityMortarAndPestle mortarAndPestle) {
                if (mortarAndPestle.getDurability() > 0) {
                    ItemStack pestle = new ItemStack(CoffeeAndTeaMod.ITEM_BLOCK_MORTAR_AND_PESLTE.get(), 1);

                    int itemDamage = 64 - mortarAndPestle.getDurability();
                    pestle.setDamageValue(itemDamage);
                    ItemEntity item = new ItemEntity(level, pos.getX(), pos.getY() + 1, pos.getZ(), pestle);
                    level.addFreshEntity(item);
                }

                mortarAndPestle.setRemoved();
           }
        }

        super.onRemove(state, level, pos, pNewState, pIsMoving);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BlockEntityMortarAndPestle(pos, state);
    }
}
