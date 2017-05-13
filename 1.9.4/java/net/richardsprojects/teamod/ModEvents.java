package net.richardsprojects.teamod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.LootConditionManager;
import net.minecraftforge.event.LootTableLoadEvent;
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
	public void entityJoin(EntityJoinWorldEvent e)
	{
		// check to make sure that the entity is a player
		if(e.getEntity() instanceof EntityPlayer && e.getEntity().worldObj.isRemote)
		{
			EntityPlayer player = (EntityPlayer) e.getEntity();
			ThreadCheckForUpdates checkForUpdates = new ThreadCheckForUpdates(player);
			checkForUpdates.run();
			
		}
	}
	
	@SubscribeEvent
	public void lootLoad(LootTableLoadEvent e) {
		if (e.getName().toString().equals("minecraft:chests/simple_dungeon")) {
			// add custom pool for the Coffee and Tea Mod
			LootEntry entry = new LootEntryTable(new ResourceLocation("teamod:inject/simple_dungeon"), 1, 0, new LootCondition[0], "ModDungeonChest1");
			LootPool pool = new LootPool(new LootEntry[] {entry}, new LootCondition[0], new RandomValueRange(1, 3), new RandomValueRange(0, 0), "CoffeeAndTeaMod");
			e.getTable().addPool(pool);
		} else if (e.getName().toString().equals("minecraft:chests/abandoned_mineshaft")) {
			LootEntry entry = new LootEntryTable(new ResourceLocation("teamod:inject/abandoned_mineshaft"), 1, 0, new LootCondition[0], "ModMineshaft1");
			LootPool pool = new LootPool(new LootEntry[] {entry}, new LootCondition[0], new RandomValueRange(1, 3), new RandomValueRange(0, 0), "CoffeeAndTeaMod");
			e.getTable().addPool(pool);
		}
	}
}
