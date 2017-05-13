package net.richardsprojects.teamod.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.richardsprojects.teamod.References;
import net.richardsprojects.teamod.itemblocks.ItemBlockEmptyCup;
import net.richardsprojects.teamod.itemblocks.ItemBlockFullCoffeeCup;
import net.richardsprojects.teamod.itemblocks.ItemBlockFullCoffeeSugarCup;
import net.richardsprojects.teamod.itemblocks.ItemBlockFullTeaCup;
import net.richardsprojects.teamod.itemblocks.ItemBlockHalfCoffeeCup;
import net.richardsprojects.teamod.itemblocks.ItemBlockHalfCoffeeSugarCup;
import net.richardsprojects.teamod.itemblocks.ItemBlockHalfTeaCup;
import net.richardsprojects.teamod.itemblocks.ItemBlockMortarAndPestle;

public class CoffeeAndTeaModBlocks {

	public static Block emptyCup;
	public static Block fullCoffeeCup;
	public static Block halfCoffeeCup;
	public static Block fullCoffeeSugarCup;
	public static Block halfCoffeeSugarCup;
	public static Block fullTeaCup;
	public static Block halfTeaCup;
	public static Block coffeeBush;
	public static Block teaBush;
	public static Block mortarAndPestle;

	public static void init() {
		emptyCup = new BlockEmptyCup().setUnlocalizedName("emptyCup");
		fullCoffeeCup = new BlockFullCoffeeCup().setUnlocalizedName("fullCoffeeCup");
		halfCoffeeCup = new BlockHalfCoffeeCup().setUnlocalizedName("halfCoffeeCup");
		fullCoffeeSugarCup = new BlockFullCoffeeSugarCup().setUnlocalizedName("fullCoffeeSugarCup");
		halfCoffeeSugarCup = new BlockHalfCoffeeSugarCup().setUnlocalizedName("halfCoffeeSugarCup");
		fullTeaCup = new BlockFullTeaCup().setUnlocalizedName("fullTeaCup");
		halfTeaCup = new BlockHalfTeaCup().setUnlocalizedName("halfTeaCup");
		coffeeBush = new BlockCoffeeBush().setUnlocalizedName("coffeeBush");
		teaBush = new BlockTeaBush().setUnlocalizedName("teaBush");
		mortarAndPestle = new BlockMortarAndPestle().setUnlocalizedName("mortarAndPestle");
	}

	public static void register() {
		// standard blocks		
		GameRegistry.registerBlock(coffeeBush, coffeeBush.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(teaBush, teaBush.getUnlocalizedName()
				.substring(5));
		
		// item blocks
		GameRegistry.registerBlock(mortarAndPestle, ItemBlockMortarAndPestle.class, "mortarAndPestle");
		GameRegistry.registerBlock(emptyCup, ItemBlockEmptyCup.class, "emptyCup");
		GameRegistry.registerBlock(fullCoffeeCup, ItemBlockFullCoffeeCup.class, "fullCoffeeCup");
		GameRegistry.registerBlock(halfCoffeeCup, ItemBlockHalfCoffeeCup.class, "halfCoffeeCup");
		GameRegistry.registerBlock(fullCoffeeSugarCup, ItemBlockFullCoffeeSugarCup.class, "fullCoffeeSugarCup");
		GameRegistry.registerBlock(halfCoffeeSugarCup, ItemBlockHalfCoffeeSugarCup.class, "halfCoffeeSugarCup");
		GameRegistry.registerBlock(fullTeaCup, ItemBlockFullTeaCup.class, "fullTeaCup");
		GameRegistry.registerBlock(halfTeaCup, ItemBlockHalfTeaCup.class, "halfTeaCup");
	}

	public static void registerRenders() {
		// regular blocks
		registerRender(coffeeBush);
		registerRender(teaBush);
		
		// item blocks
		registerRender(mortarAndPestle);
		registerRender(emptyCup);
		registerRender(fullCoffeeCup);
		registerRender(halfCoffeeCup);
		registerRender(fullCoffeeSugarCup);
		registerRender(halfCoffeeSugarCup);
		registerRender(fullTeaCup);
		registerRender(halfTeaCup);
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
