package net.richardsprojects.teamod.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemCoffeeBeans extends Item
{
	public static Item unroastedBean;
	public static Item roastedBean;
	
	protected ItemCoffeeBeans()
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
		unroastedBean = new ItemUnroastedCoffeeBeans().setTextureName("teamod:unroastedcoffeebean").setUnlocalizedName("unroastedBean").setCreativeTab(TeaMod.teaModTab);
		roastedBean = new ItemCoffeeBeans().setTextureName("teamod:roastedcoffeebean").setUnlocalizedName("roastedBean").setCreativeTab(TeaMod.teaModTab);
	}
	
	private static void registerItem()
	{
		GameRegistry.registerItem(roastedBean, roastedBean.getUnlocalizedName());
		GameRegistry.registerItem(unroastedBean, unroastedBean.getUnlocalizedName());
	}
	
}
