package net.richardsprojects.teamod.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class MortarAndPestleEntity extends TileEntity {

	private int durability;
	
	public void reduceDurability(Block block, EntityPlayer player, World world)
	{
		//Reduce Durability in the NBT data
		durability--;
		
		//Send Message to Player
		if(durability == 1) {
			player.addChatComponentMessage(new ChatComponentText("\u00a77You grind the Coffee Bean into coffee grounds. \u00a7f(" + durability + " use left)"));
		}
		else
		{
			player.addChatComponentMessage(new ChatComponentText("\u00a77You grind the Coffee Bean into coffee grounds. \u00a7f(" + durability + " uses left)"));
		}
		//Refreshes the block causing the nbt data to be saved
		world.notifyBlockChange(xCoord, yCoord, zCoord, block);
	}
	
	public void setDurability(Block block, World world, int value)
	{
		//Set the durability
		durability = value;
		
		//Refreshes the block causing the nbt data to be saved
		world.notifyBlockChange(xCoord, yCoord, zCoord, block);
	}
	
    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
    	super.readFromNBT(nbt);
    	this.durability = nbt.getInteger("MortarAndPestleDurability");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
    	super.writeToNBT(nbt);
    	nbt.setInteger("MortarAndPestleDurability", durability);
    }
    
    public int getDurability()
    {
    	return durability;
    }
}
