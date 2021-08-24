package net.richardsprojects.teamod.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemTeaLeaves extends Item
{
	public static Item teaLeaves;
	
	public ItemTeaLeaves()
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
		teaLeaves = new ItemTeaLeaves().setTextureName("teamod:teaLeaves").setUnlocalizedName("teaLeaves").setCreativeTab(TeaMod.teaModTab);
	}
	
	private static void registerItem()
	{
		GameRegistry.registerItem(teaLeaves, teaLeaves.getUnlocalizedName());
	}
	
}
