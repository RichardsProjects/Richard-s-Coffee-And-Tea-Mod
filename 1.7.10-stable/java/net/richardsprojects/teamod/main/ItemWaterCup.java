package net.richardsprojects.teamod.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemWaterCup extends Item
{
	public static Item waterCup;
	
	public ItemWaterCup()
	{
		super();
		this.maxStackSize = 8;
		
	}
	
	//Item Registration Code
	public static void mainRegistry()	
	{
		initializeItem();
		registerItem();
	}

	private static void initializeItem()
	{
		waterCup = new ItemWaterCup().setTextureName("teamod:WaterCup").setUnlocalizedName("waterCup").setCreativeTab(TeaMod.teaModTab);
	}
	
	private static void registerItem()
	{
		GameRegistry.registerItem(waterCup, waterCup.getUnlocalizedName());
	}
	
}
