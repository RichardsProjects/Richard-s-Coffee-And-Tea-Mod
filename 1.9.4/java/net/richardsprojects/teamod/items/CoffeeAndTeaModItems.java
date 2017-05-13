package net.richardsprojects.teamod.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.richardsprojects.teamod.References;

public class CoffeeAndTeaModItems {

	public static Item unroastedCoffeeBean;
	public static Item roastedCoffeeBean;
	public static Item teaSeed;
	public static Item teaLeaves;
	public static Item clayCup;
	public static Item waterCup;
	public static Item boilingCup;
	public static Item groundTeaLeaves;
	public static Item coffeeGrounds;
	
	public static void init() {
		unroastedCoffeeBean = new ItemUnroastedCoffeeBean();
		roastedCoffeeBean = new ItemRoastedCoffeeBean();
		teaSeed = new ItemTeaSeed();
		clayCup = new ItemClayCup();
		waterCup = new ItemWaterCup();
		boilingCup = new ItemBoilingCup();
		teaLeaves = new ItemTeaLeaves();
		groundTeaLeaves = new ItemGroundTeaLeaves();
		coffeeGrounds = new ItemCoffeeGrounds();
	}
	
	public static void register() {
		GameRegistry.register(unroastedCoffeeBean);
		GameRegistry.register(roastedCoffeeBean);
		GameRegistry.register(teaSeed);
		GameRegistry.register(teaLeaves);
		GameRegistry.register(clayCup);
		GameRegistry.register(waterCup);
		GameRegistry.register(boilingCup);
		GameRegistry.register(groundTeaLeaves);
		GameRegistry.register(coffeeGrounds);
	}
	
	public static void registerRenders() {
		registerRender(unroastedCoffeeBean);
		registerRender(roastedCoffeeBean);
		registerRender(groundTeaLeaves);
		registerRender(boilingCup);
		registerRender(teaLeaves);
		registerRender(teaSeed);
		registerRender(clayCup);
		registerRender(waterCup);
		registerRender(coffeeGrounds);
	}
	
	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,
				0, new ModelResourceLocation(References.MODID + ":" + item.getUnlocalizedName().substring(5),
				"inventory"));
	}
}
