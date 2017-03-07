package net.richardsprojects.teamod.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
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
	
	public static void init() {
		unroastedCoffeeBean = new ItemUnroastedCoffeeBean();
		roastedCoffeeBean = new ItemRoastedCoffeeBean();
		teaSeed = new ItemTeaSeed();
		clayCup = new ItemClayCup();
		waterCup = new ItemWaterCup();
		boilingCup = new ItemBoilingCup();
		teaLeaves = new ItemTeaLeaves();
		groundTeaLeaves = new ItemGroundTeaLeaves();
	}
	
	public static void register() {
		GameRegistry.registerItem(unroastedCoffeeBean, unroastedCoffeeBean.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(roastedCoffeeBean, roastedCoffeeBean.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(teaSeed, teaSeed.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(teaLeaves, teaLeaves.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(clayCup, clayCup.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(waterCup, waterCup.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(boilingCup, boilingCup.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(groundTeaLeaves, groundTeaLeaves.getUnlocalizedName()
				.substring(5));
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
	}
	
	public static void registerRender(Item item) {
		Minecraft
				.getMinecraft()
				.getRenderItem()
				.getItemModelMesher()
				.register(
						item,
						0,
						new ModelResourceLocation(References.MODID + ":"
								+ item.getUnlocalizedName().substring(5),
								"inventory"));
	}
	
	public static void registerItemBlock(Item item) {
		Minecraft
		.getMinecraft()
		.getRenderItem()
		.getItemModelMesher()
		.register(
				item,
				0,
				new ModelResourceLocation(References.MODID + ":"
						+ item.getUnlocalizedName().substring(5),
						"inventory"));
	}
}
