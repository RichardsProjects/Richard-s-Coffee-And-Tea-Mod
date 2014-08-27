package net.richardsprojects.teamod.main;

import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.richardsprojects.teamod.entity.MortarAndPestleEntity;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MCForgeModEvents {
	
	//Empty Cup Fill Event
	@SubscribeEvent
	public void CupFillEvent(PlayerInteractEvent e)
	{
		//Check to see if the player right clicked
		if(e.action.equals(e.action.RIGHT_CLICK_BLOCK))
		{
			//Check if the player has an item in their hand
			if(e.entityPlayer.inventory.getCurrentItem() != null)
			{
				//Check if the player has an empty cup in their inventory
				if(e.entityPlayer.inventory.getCurrentItem().getItem() == ItemEmptyCup.emptyCup)
				{
					int blocksChanged = 0;
														
					if(e.world.getBlock(e.x, e.y + 1, e.z) == Blocks.water)
					{
						int currentItem = e.entityPlayer.inventory.currentItem;
						ItemStack newCup = new ItemStack(ItemWaterCup.waterCup, 1);
						e.entityPlayer.inventory.setInventorySlotContents(currentItem, newCup);
					}
				}
			}
		}
	}
	
	//Coffee Bush Break Event
	@SubscribeEvent
	public void coffeeBushBreakEvent(BreakEvent e)
	{
		if(e.block != null)
		{
			if(e.block == BlockCoffeeBush.coffeeBush)
			{
				//Check the metadata
				int metadata = e.world.getBlockMetadata(e.x, e.y, e.z);
				//Check if plant is 
				if(metadata == 7)
				{
					if(e.getPlayer() != null)
					{
						EntityItem entityItem;
						entityItem = new EntityItem(e.world, e.x, e.y + 2, e.z, new ItemStack(ItemCoffeeBeans.unroastedBean, 5));
						
						//Place Items in World
						e.world.spawnEntityInWorld(entityItem);
					}
				}
				else
				{
					if(e.getPlayer() != null)
					{
						EntityItem entityItem;
						entityItem = new EntityItem(e.world, e.x, e.y + 2, e.z, new ItemStack(ItemCoffeeBeans.unroastedBean, 1));
						
						//Place Items in World
						e.world.spawnEntityInWorld(entityItem);
					}					
				}			
			}
		}
	}
	
	//Tea Bush Break Event
	@SubscribeEvent
	public void teaBushBreakEvent(BreakEvent e)
	{
		if(e.block != null)
		{
			if(e.block == BlockTeaBush.teaBush)
			{
				//Check the metadata
				int metadata = e.world.getBlockMetadata(e.x, e.y, e.z);
				//Check if plant is 
				if(metadata == 7)
				{
					if(e.getPlayer() != null)
					{
						EntityItem entityItem;
						entityItem = new EntityItem(e.world, e.x, e.y + 2, e.z, new ItemStack(ItemTeaLeaves.teaLeaves, 5));
						EntityItem entityItem2;
						entityItem2 = new EntityItem(e.world, e.x, e.y + 2, e.z, new ItemStack(ItemTeaSeeds.teaSeeds, 1));
						
						//Place Items in World
						e.world.spawnEntityInWorld(entityItem);
						e.world.spawnEntityInWorld(entityItem2);
					}
				}
				else
				{
					if(e.getPlayer() != null)
					{
						EntityItem entityItem;
						entityItem = new EntityItem(e.world, e.x, e.y + 2, e.z, new ItemStack(ItemTeaSeeds.teaSeeds, 1));
						
						//Place Items in World
						e.world.spawnEntityInWorld(entityItem);
					}					
				}			
			}
		}
	}
	
	@SubscribeEvent
	public void entityJoin(EntityJoinWorldEvent event)
	{
		//Check to make sure that the entity is a player
		if(event.entity instanceof EntityPlayer && event.entity.worldObj.isRemote)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			ThreadCheckForUpdates checkForUpdates = new ThreadCheckForUpdates(player);
			checkForUpdates.run();
			
		}
	}

}
