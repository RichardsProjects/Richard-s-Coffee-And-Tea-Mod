package net.richardsprojects.teamod.common.blocks.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityMortarAndPestle extends BlockEntity {

    private int durability = 64;

    public BlockEntityMortarAndPestle(BlockPos pos, BlockState state) {
        super(CoffeeAndTeaModBlockEntities.MORTAR_AND_PESTLE.get(), pos, state);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        durability = nbt.getInt("durability");
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.putInt("durability", this.durability);
        super.saveAdditional(nbt);
    }

    public void setDurability(int durability) {
        this.durability = durability;
        this.setChanged();
    }

    public int getDurability() {
        return this.durability;
    }
}
