package net.richardsprojects.teamod.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGroundTeaLeaves extends Item
{
	public static Item groundTeaLeaves;
	
	public ItemGroundTeaLeaves()
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
		groundTeaLeaves = new ItemGroundTeaLeaves().setTextureName("teamod:GroundTeaLeaves").setUnlocalizedName("groundTeaLeaves").setCreativeTab(TeaMod.teaModTab);
	}
	
	private static void registerItem()
	{
		GameRegistry.registerItem(groundTeaLeaves, groundTeaLeaves.getUnlocalizedName());
	}
}
