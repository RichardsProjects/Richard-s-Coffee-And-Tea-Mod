package net.richardsprojects.teamod.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMortarAndPestle extends TileEntity {

	private int durability = 64;
	
	public void setDurability(int durability) {
		this.durability = durability;
	}
	
	public int getDurability() {
		return this.durability;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		durability = compound.getInteger("durability");		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("durability", this.durability);
	}
}
