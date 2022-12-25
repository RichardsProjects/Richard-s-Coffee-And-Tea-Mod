package net.richardsprojects.teamod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockReader;
import net.richardsprojects.teamod.tile.MortarAndPestleTile;


public class BlockMortarAndPestle extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public BlockMortarAndPestle() {
        super(Block.Properties.create(Material.ROCK).hardnessAndResistance(4.0F));
        this.setDefaultState(this.stateContainer.getBaseState().with(this.FACING, Direction.NORTH));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new MortarAndPestleTile();
    }


}
