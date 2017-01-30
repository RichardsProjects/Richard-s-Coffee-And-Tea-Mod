package net.richardsprojects.teamod;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
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
	 * [ ] Implement clay cup and way to create empty cups
	 * [X] Implement coffee beans and tea seeds
	 * [X] Make seeds drop from tall grass
	 * [ ] Add coffee and tea plants
	 * [ ] Make tea seeds and coffee beans plant their plants
	 * [ ] Add mortar and pestle
	 * [ ] Implement way to craft mortar and pestle
	 * [ ] Make coffee and tea plants spawn naturally
	 * [ ] Make coffee and tea drinkable
	 * [ ] Add coffee with sugar
	 * [ ] Add coffee beans and tea seeds to Dungeon drop lists
	 */
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// register items & blocks
		CoffeeAndTeaModBlocks.init();
		CoffeeAndTeaModBlocks.register();
		CoffeeAndTeaModItems.init();
		CoffeeAndTeaModItems.register();
		
		// Register Recipes
		//Recipes.register();
		
    	// Register Event Handlers
    	//MinecraftForge.EVENT_BUS.register(new MCForgeModEvents());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenders();
		MinecraftForge.addGrassSeed(new ItemStack(CoffeeAndTeaModItems.teaSeed), 1);
		MinecraftForge.addGrassSeed(new ItemStack(CoffeeAndTeaModItems.unroastedCoffeeBean), 1);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}