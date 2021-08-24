package net.richardsprojects.teamod.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemCoffeeGrounds extends Item
{
	public static Item coffeeGrounds;
	
	public ItemCoffeeGrounds()
	{
		super();
		this.maxStackSize = 64;
	}
	
	//Item Registration Code
	public static void mainRegistry()	
	{
		initializeItem();
		registerItem();
	}

	private static void initializeItem()
	{
		coffeeGrounds = new ItemCoffeeGrounds().setTextureName("teamod:coffeegrounds").setUnlocalizedName("coffeeGrounds").setCreativeTab(TeaMod.teaModTab);
	}
	
	private static void registerItem()
	{
		GameRegistry.registerItem(coffeeGrounds, coffeeGrounds.getUnlocalizedName());
	}
	
}
