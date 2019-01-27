package net.richardsprojects.teamod;

import net.minecraft.block.Block;
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
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;
import net.richardsprojects.teamod.itemblocks.CoffeeAndTeaModItemBlocks;
import net.richardsprojects.teamod.items.CoffeeAndTeaModItems;

import squeek.applecore.api.AppleCoreAPI;
import squeek.applecore.api.food.FoodValues;

import java.text.DecimalFormat;

public class ModEvents {

	//public static final DecimalFormat DF = new DecimalFormat("##.##");

	/*@Optional.Method(modid = "AppleCore")
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onItemTooltip(ItemTooltipEvent event)
	{
		if (AppleCoreAPI.accessor.isFood(event.getItemStack()))
		{
			FoodValues unmodifiedValues = AppleCoreAPI.accessor.getUnmodifiedFoodValues(event.getItemStack());
			FoodValues modifiedValues = AppleCoreAPI.accessor.getFoodValues(event.getItemStack());
			FoodValues playerValues = AppleCoreAPI.accessor.getFoodValuesForPlayer(event.getItemStack(), event.getEntityPlayer());

			event.getToolTip().add("Food Values [hunger : satMod (+sat)]");
			event.getToolTip().add("- Saturation: 2");
			event.getToolTip().add("- Player-agnostic: " + modifiedValues.hunger + " : " + modifiedValues.saturationModifier + " (+" + DF.format(modifiedValues.getSaturationIncrement()) + ")");
			event.getToolTip().add("- Unmodified: " + unmodifiedValues.hunger + " : " + unmodifiedValues.saturationModifier + " (+" + DF.format(unmodifiedValues.getSaturationIncrement()) + ")");
		}
	}*/

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		// register items
		event.getRegistry().register(CoffeeAndTeaModItems.unroastedCoffeeBean);
		event.getRegistry().register(CoffeeAndTeaModItems.roastedCoffeeBean);
		event.getRegistry().register(CoffeeAndTeaModItems.teaSeed);
		event.getRegistry().register(CoffeeAndTeaModItems.teaLeaves);
		event.getRegistry().register(CoffeeAndTeaModItems.clayCup);
		event.getRegistry().register(CoffeeAndTeaModItems.waterCup);
		event.getRegistry().register(CoffeeAndTeaModItems.boilingCup);
		event.getRegistry().register(CoffeeAndTeaModItems.groundTeaLeaves);
		event.getRegistry().register(CoffeeAndTeaModItems.coffeeGrounds);

		// item blocks
		event.getRegistry().register(CoffeeAndTeaModItemBlocks.mortarAndPestle);
		event.getRegistry().register(CoffeeAndTeaModItemBlocks.emptyCup);
		event.getRegistry().register(CoffeeAndTeaModItemBlocks.fullCoffeeCup);
		event.getRegistry().register(CoffeeAndTeaModItemBlocks.halfCoffeeCup);
		event.getRegistry().register(CoffeeAndTeaModItemBlocks.fullCoffeeCupSugar);
		event.getRegistry().register(CoffeeAndTeaModItemBlocks.halfCoffeeCupSugar);
		event.getRegistry().register(CoffeeAndTeaModItemBlocks.fullTeaCup);
		event.getRegistry().register(CoffeeAndTeaModItemBlocks.halfTeaCup);
	}

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		// register items
		event.getRegistry().register(CoffeeAndTeaModBlocks.mortarAndPestle);
		event.getRegistry().register(CoffeeAndTeaModBlocks.emptyCup);
		event.getRegistry().register(CoffeeAndTeaModBlocks.fullCoffeeCup);
		event.getRegistry().register(CoffeeAndTeaModBlocks.halfCoffeeCup);
		event.getRegistry().register(CoffeeAndTeaModBlocks.fullCoffeeSugarCup);
		event.getRegistry().register(CoffeeAndTeaModBlocks.halfCoffeeSugarCup);
		event.getRegistry().register(CoffeeAndTeaModBlocks.fullTeaCup);
		event.getRegistry().register(CoffeeAndTeaModBlocks.halfTeaCup);

		if (Loader.isModLoaded("applecore")) {
			System.out.println("Registering Coffee Cups as Edible Blocks");
			AppleCoreAPI.registry.registerEdibleBlock(CoffeeAndTeaModBlocks.fullCoffeeCup,
					CoffeeAndTeaModItemBlocks.fullCoffeeCup);
			AppleCoreAPI.registry.registerEdibleBlock(CoffeeAndTeaModBlocks.fullCoffeeSugarCup,
					CoffeeAndTeaModItemBlocks.fullCoffeeCupSugar);
			AppleCoreAPI.registry.registerEdibleBlock(CoffeeAndTeaModBlocks.fullTeaCup,
					CoffeeAndTeaModItemBlocks.fullTeaCup);
			AppleCoreAPI.registry.registerEdibleBlock(CoffeeAndTeaModBlocks.halfCoffeeCup,
					CoffeeAndTeaModItemBlocks.halfCoffeeCup);
			AppleCoreAPI.registry.registerEdibleBlock(CoffeeAndTeaModBlocks.halfTeaCup,
					CoffeeAndTeaModItemBlocks.halfTeaCup);
			AppleCoreAPI.registry.registerEdibleBlock(CoffeeAndTeaModBlocks.halfCoffeeSugarCup,
					CoffeeAndTeaModItemBlocks.halfCoffeeCupSugar);
		}

		// register crops
		event.getRegistry().register(CoffeeAndTeaModBlocks.coffeeBush);
		event.getRegistry().register(CoffeeAndTeaModBlocks.teaBush);
	}

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
	            		k = new ItemStack(mortarAndPestle, 0, j.getItemDamage() + 1);
	            	}
	            	else
	            	{
	            		k = new ItemStack(mortarAndPestle, 1, j.getItemDamage() + 1);
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
		if(e.getEntity() instanceof EntityPlayer && e.getEntity().world.isRemote)
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
