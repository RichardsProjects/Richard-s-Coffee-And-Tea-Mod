package net.richardsprojects.teamod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;

public class ModEvents {

	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent e) 
	{
		IInventory inv = e.craftMatrix;
		
	    for(int i=0; i < inv.getSizeInventory(); i++)
	    {
	        if(inv.getStackInSlot(i) != null)
	        {
	            ItemStack j = inv.getStackInSlot(i);
	            Item mortarAndPestle = Item.getItemFromBlock(CoffeeAndTeaModBlocks.mortarAndPestle);
	            if(j.getItem() != null && j.getItem() == mortarAndPestle)
	            {
	            	ItemStack k = null;
	            	if(j.getItemDamage() == j.getMaxDamage() - 1)
	            	{
	            		k = new ItemStack(mortarAndPestle, 1, j.getItemDamage() + 1);
	            	}
	            	else
	            	{
	            		k = new ItemStack(mortarAndPestle, 2, j.getItemDamage() + 1);
	            	}
	                inv.setInventorySlotContents(i, k);
	            }
	        }
	    }
	}
	
	@SubscribeEvent
	public void entityJoin(EntityJoinWorldEvent event)
	{
		// check to make sure that the entity is a player
		if(event.entity instanceof EntityPlayer && event.entity.worldObj.isRemote)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			ThreadCheckForUpdates checkForUpdates = new ThreadCheckForUpdates(player);
			checkForUpdates.run();
			
		}
	}
	
}
