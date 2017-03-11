package net.richardsprojects.teamod;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;
import net.richardsprojects.teamod.items.CoffeeAndTeaModItems;
import net.richardsprojects.teamod.proxy.CommonProxy;
import net.richardsprojects.teamod.tileentity.CoffeeAndTeaModTileEntities;

@Mod(modid = References.MODID, name = References.MOD_NAME, version = References.VERSION)
public class CoffeeAndTeaMod {
	
	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final CoffeeAndTeaTab teaTab = new CoffeeAndTeaTab();
	
	/*
	 * Future updates:
	 * [ ] Make coffee and tea bushes solid
	 * [ ] Add a drink sound when you drink from a coffee or tea cup
	 * [ ] Add the anvil break sound when a mortar and pestle breaks
	 * [ ] Add different textures for damage to the mortar and pestle like the anvil 
	 * [ ] Add trades with villagers in 1.8:
	 * 		- Use this link for reference: https://gist.github.com/Thutmose/1b11be61a4d340fa45ae
	 */
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// register items & blocks
		CoffeeAndTeaModBlocks.init();
		CoffeeAndTeaModBlocks.register();
		CoffeeAndTeaModItems.init();
		CoffeeAndTeaModItems.register();
		CoffeeAndTeaModTileEntities.register();
		
	    // add loot to chests in mineshafts
	    ItemStack coffeeSeed = new ItemStack(CoffeeAndTeaModItems.unroastedCoffeeBean);
	    WeightedRandomChestContent chest1;
	    chest1 = new WeightedRandomChestContent(coffeeSeed, 2, 5, 065);
	    ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(chest1);
	    WeightedRandomChestContent chest2;
	    ItemStack teaSeeds = new ItemStack(CoffeeAndTeaModItems.teaSeed);
	    chest2 = new WeightedRandomChestContent(teaSeeds, 2, 5, 065);
	    ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(chest2);
	
	    // add loot to chests in dungeons
    	WeightedRandomChestContent chestContent1;
    	ItemStack coffee = new ItemStack(CoffeeAndTeaModItems.roastedCoffeeBean);
    	chestContent1 = new WeightedRandomChestContent(coffee, 5, 24, 065);
	    ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(chestContent1);
    	WeightedRandomChestContent chestContent2;
    	ItemStack teaLeaves = new ItemStack(CoffeeAndTeaModItems.teaLeaves);
    	chestContent2 = new WeightedRandomChestContent(teaLeaves, 5, 24, 065);
	    ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(chestContent2);
	    
		Recipes.register(); // add recipes
		
		MinecraftForge.EVENT_BUS.register(new ModEvents());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenders();
		MinecraftForge.addGrassSeed(new ItemStack(CoffeeAndTeaModItems.teaSeed), 1);
		MinecraftForge.addGrassSeed(new ItemStack(CoffeeAndTeaModItems.unroastedCoffeeBean), 1);
		GameRegistry.registerWorldGenerator(new BushWorldGenerator(), 0);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}