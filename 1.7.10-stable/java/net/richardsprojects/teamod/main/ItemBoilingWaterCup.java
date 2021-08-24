package net.richardsprojects.teamod.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBoilingWaterCup extends Item
{
	public static Item boilingWaterCup;
	
	public ItemBoilingWaterCup()
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
		boilingWaterCup = new ItemBoilingWaterCup().setTextureName("teamod:BoilingWaterCup").setUnlocalizedName("boilingWaterCup").setCreativeTab(TeaMod.teaModTab);
	}
	
	private static void registerItem()
	{
		GameRegistry.registerItem(boilingWaterCup, boilingWaterCup.getUnlocalizedName());
	}
}