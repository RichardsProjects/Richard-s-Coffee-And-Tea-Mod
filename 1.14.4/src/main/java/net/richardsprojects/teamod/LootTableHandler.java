package net.richardsprojects.teamod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTables;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LootTableHandler {

	private static ResourceLocation grass = new ResourceLocation("minecraft", "blocks/grass");
	private static ResourceLocation tallGrass = new ResourceLocation("minecraft", "blocks/tall_grass");
	
	@SubscribeEvent
	public void loadLootTable(LootTableLoadEvent event) {
		
		// add tall grass drops
		if (event.getName().equals(tallGrass) || event.getName().equals(grass))
			event.getTable().addPool(LootPool.builder()
					.addEntry(TableLootEntry.builder(new ResourceLocation(CoffeeAndTeaMod.MOD_ID, "blocks/tall_grass")))
					.name("teamod_grass_drops").build());
		
		// add dungeons
		if (event.getName().equals(LootTables.CHESTS_SIMPLE_DUNGEON))
			event.getTable().addPool(LootPool.builder()
					.addEntry(TableLootEntry.builder(new ResourceLocation(CoffeeAndTeaMod.MOD_ID, "chests/simple_dungeon")))
					.name("teamod_simple_dungeon").build());
		
		// add abandoned mineshafts
		if (event.getName().equals(LootTables.CHESTS_ABANDONED_MINESHAFT))
			event.getTable().addPool(LootPool.builder()
					.addEntry(TableLootEntry.builder(new ResourceLocation(CoffeeAndTeaMod.MOD_ID, "chests/abandoned_mineshaft")))
					.name("teamod_abandoned_mineshaft").build());
		
	}
	
}
