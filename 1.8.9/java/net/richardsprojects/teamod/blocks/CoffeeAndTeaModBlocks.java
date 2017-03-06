package net.richardsprojects.teamod.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.richardsprojects.teamod.References;
import net.richardsprojects.teamod.itemblocks.ItemBlockMortarAndPestle;

public class CoffeeAndTeaModBlocks {

	public static Block emptyCup;
	public static Block coffeeBush;
	public static Block teaBush;
	public static Block mortarAndPestle;

	public static void init() {
		emptyCup = new BlockEmptyCup().setUnlocalizedName("emptyCup");
		coffeeBush = new BlockCoffeeBush().setUnlocalizedName("coffeeBush");
		teaBush = new BlockTeaBush().setUnlocalizedName("teaBush");
		mortarAndPestle = new BlockMortarAndPestle().setUnlocalizedName("mortarAndPestle");
	}

	public static void register() {
		GameRegistry.registerBlock(emptyCup, emptyCup.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(coffeeBush, coffeeBush.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(teaBush, teaBush.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(mortarAndPestle, ItemBlockMortarAndPestle.class, "mortarAndPestle");
	}

	public static void registerRenders() {
		registerRender(emptyCup);
		registerRender(coffeeBush);
		registerRender(teaBush);
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
