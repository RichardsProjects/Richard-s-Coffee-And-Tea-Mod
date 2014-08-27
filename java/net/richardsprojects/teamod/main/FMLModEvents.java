package net.richardsprojects.teamod.main;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class FMLModEvents {
	
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent e) 
	{
		IInventory inv = e.craftMatrix;
		
	    for(int i=0; i < inv.getSizeInventory(); i++)
	    {
	        if(inv.getStackInSlot(i) != null)
	        {
	            ItemStack j = inv.getStackInSlot(i);
	            if(j.getItem() != null && j.getItem() == ItemMortarAndPestle.mortarAndPestle)
	            {
	            	ItemStack k = null;
	            	if(j.getItemDamage() == j.getMaxDamage() - 1)
	            	{
	            		k = new ItemStack(ItemMortarAndPestle.mortarAndPestle, 1, j.getItemDamage() + 1);
	            	}
	            	else
	            	{
	            		k = new ItemStack(ItemMortarAndPestle.mortarAndPestle, 2, j.getItemDamage() + 1);
	            	}
	                inv.setInventorySlotContents(i, k);
	            }
	        }
	    }
	}

}
