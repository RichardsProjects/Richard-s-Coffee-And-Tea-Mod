package net.richardsprojects.teamod.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class BlockTeaBush extends CropBlock {

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {
            Block.box(0.0D, -1.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(5D, -1.0D, 5D, 11D, 3D, 11D),
            Block.box(4.5D, -1.0D, 4.5D, 11.5D, 4.0D, 11.5D),
            Block.box(4.0D, -1.0D, 4.0D, 12.0D, 6.0D, 12.0D),
            Block.box(3.5D, -1.0D, 3.5D, 12.4D, 8.0D, 12.5D),
            Block.box(2.5D, -1.0D, 2.5D, 13.5D, 10.0D, 13.5D),
            Block.box(1.5D, -1.0D, 1.5D, 14.5D, 13D, 14.5D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
    };

    public BlockTeaBush() {
        super(Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE_BY_AGE[pState.getValue(this.getAgeProperty())];
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return CoffeeAndTeaMod.TEA_SEED.get();
    }
}
