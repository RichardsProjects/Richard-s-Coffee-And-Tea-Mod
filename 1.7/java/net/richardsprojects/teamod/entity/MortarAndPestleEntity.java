package net.richardsprojects.teamod.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class MortarAndPestleEntity extends TileEntity {

	private int durability;
	
	public void reduceDurability(Block block, EntityPlayer player, World world, String type)
	{
		//Reduce Durability in the NBT data
		durability--;
		
		//Send Message to Player
		if(type.equals("c"))
		{
			if(durability == 1) {
				player.addChatComponentMessage(new ChatComponentText("\u00a77You grind the Coffee Bean into coffee grounds. \u00a7f(" + durability + " use left)"));
			}
			else
			{
				player.addChatComponentMessage(new ChatComponentText("\u00a77You grind the Coffee Bean into coffee grounds. \u00a7f(" + durability + " uses left)"));
			}
		}
		if(type.equals("t"))
		{
			if(durability == 1) {
				player.addChatComponentMessage(new ChatComponentText("\u00a77You grind the Tea Leaf into ground tea leaves. \u00a7f(" + durability + " use left)"));
			}
			else
			{
				player.addChatComponentMessage(new ChatComponentText("\u00a77You grind the Tea Leaf into ground tea leaves. \u00a7f(" + durability + " uses left)"));
			}
		}
		
		//Update the Block's metadata value based on durability
		int m = world.getTileEntity(xCoord, yCoord, zCoord).blockMetadata;
		if(durability < 49 && durability > 32 && m < 4)
		{
			world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, m + 4, 1);
		}
		if(durability < 33 && durability > 16 && m < 8 && m > 3)
		{
			world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, m + 4, 1);
		}
		if(durability < 17 && durability > 0 && m < 12 && m > 7)
		{
			world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, m + 4, 1);
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
