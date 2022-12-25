package net.richardsprojects.teamod.tile;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;

public class MortarAndPestleTile extends TileEntity {

    private int durability = 64;

    public MortarAndPestleTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public MortarAndPestleTile() {
        this(CoffeeAndTeaModTileEntities.MORTAR_AND_PESTLE.get());
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getDurability() {
        return this.durability;
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        durability = compound.getInt("durability");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        compound.putInt("durability", this.durability);
        return compound;
    }
}
