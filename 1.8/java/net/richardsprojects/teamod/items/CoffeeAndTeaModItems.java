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
	
	public static void init() {
		unroastedCoffeeBean = new ItemUnroastedCoffeeBean();
		roastedCoffeeBean = new ItemRoastedCoffeeBean();
		teaSeed = new ItemTeaSeed();
	}
	
	public static void register() {
		GameRegistry.registerItem(unroastedCoffeeBean, unroastedCoffeeBean.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(roastedCoffeeBean, roastedCoffeeBean.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(teaSeed, teaSeed.getUnlocalizedName()
				.substring(5));
		
	}
	
	public static void registerRenders() {
		registerRender(unroastedCoffeeBean);
		registerRender(roastedCoffeeBean);
		registerRender(teaSeed);
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
}