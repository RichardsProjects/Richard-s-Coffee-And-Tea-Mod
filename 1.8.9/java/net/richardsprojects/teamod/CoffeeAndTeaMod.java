package net.richardsprojects.teamod;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
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

@Mod(modid = References.MODID, name = References.MOD_NAME, version = References.VERSION)
public class CoffeeAndTeaMod {
	
	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final CoffeeAndTeaTab teaTab = new CoffeeAndTeaTab();
	
	/*
	 * ToDo List:
	 * [X] Implement empty cup
	 * [X] Implement clay cup and way to create empty cups
	 * [X] Implement coffee beans and tea seeds
	 * [X] Make seeds drop from tall grass
	 * [ ] Create ItemBlock class for all the blocks to set max stack size
	 *     and because it will be needed when I update to 1.8
	 * [X] Implement facing direction on empty cup
	 * [X] Add coffee plant
	 * [X] Add tea plant
	 * [X] Make tea seeds and coffee beans plant their plants
	 * [X] Add breaking texture for coffee and tea plants
	 * [X] Make the bounding box different for each state of plants 
	 * [ ] Add mortar and pestle
	 * 		- [ ] Fix bug where no picture shows for the mortar and pestle item
	 * 		- [ ] Implement recipe for mortar and pestle item
	 * 		- [ ] Implement NBT saving so that the mortar and pestle will gradually ware out
	 * 		- [X] Make it work and crush tea leaves
	 * [ ] Implement way to craft mortar and pestle
	 * [X] Make coffee and tea plants spawn naturally
	 * [ ] Make it possible to fill an empty cup with water and then boil it in the furnace
	 * [ ] Make coffee and tea drinkable
	 * [ ] Add coffee with sugar
	 * [ ] Add coffee beans and tea seeds to Dungeon drop lists
	 * [ ] Add trades with villagers like 1.7 version has
	 * 		- Use this link for reference: https://gist.github.com/Thutmose/1b11be61a4d340fa45ae
	 * [X] Add mineshafts loot like 1.7 version
	 */
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// register items & blocks
		CoffeeAndTeaModBlocks.init();
		CoffeeAndTeaModBlocks.register();
		CoffeeAndTeaModItems.init();
		CoffeeAndTeaModItems.register();
		
	    // add loot to chests in mineshafts
	    ItemStack coffeeSeed = new ItemStack(CoffeeAndTeaModItems.unroastedCoffeeBean);
	    WeightedRandomChestContent chest1;
	    chest1 = new WeightedRandomChestContent(coffeeSeed, 2, 5, 065);
	    ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(chest1);
	    WeightedRandomChestContent chest2;
	    ItemStack teaSeeds = new ItemStack(CoffeeAndTeaModItems.teaSeed);
	    chest2 = new WeightedRandomChestContent(teaSeeds, 2, 5, 065);
	    ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(chest2);
	
		Recipes.register(); // add recipes
		
    	// Register Event Handlers
    	//MinecraftForge.EVENT_BUS.register(new MCForgeModEvents());
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