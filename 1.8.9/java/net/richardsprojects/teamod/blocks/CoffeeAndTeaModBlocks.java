package net.richardsprojects.teamod.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.richardsprojects.teamod.References;

public class CoffeeAndTeaModBlocks {

	public static Block emptyCup;

	public static void init() {
		emptyCup = new BlockEmptyCup()
				.setUnlocalizedName("emptyCup");
	}

	public static void register() {
		GameRegistry.registerBlock(emptyCup, emptyCup
				.getUnlocalizedName().substring(5));
	}

	public static void registerRenders() {
		registerRender(emptyCup);
	}

	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
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
