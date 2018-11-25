package net.richardsprojects.teamod.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
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
		emptyCup = new BlockEmptyCup().setUnlocalizedName("emptyCup").setRegistryName("empty_cup");
		fullCoffeeCup = new BlockFullCoffeeCup().setUnlocalizedName("fullCoffeeCup").setRegistryName("full_coffee_cup");
		halfCoffeeCup = new BlockHalfCoffeeCup().setUnlocalizedName("halfCoffeeCup").setRegistryName("half_coffee_cup");
		fullCoffeeSugarCup = new BlockFullCoffeeSugarCup().setUnlocalizedName("fullCoffeeSugarCup").setRegistryName("full_coffee_sugar_cup");
		halfCoffeeSugarCup = new BlockHalfCoffeeSugarCup().setUnlocalizedName("halfCoffeeSugarCup").setRegistryName("half_coffee_sugar_cup");
		fullTeaCup = new BlockFullTeaCup().setUnlocalizedName("fullTeaCup").setRegistryName("full_tea_cup");
		halfTeaCup = new BlockHalfTeaCup().setUnlocalizedName("halfTeaCup").setRegistryName("half_tea_cup");
		coffeeBush = new BlockCoffeeBush().setUnlocalizedName("coffeeBush").setRegistryName("coffee_bush");
		teaBush = new BlockTeaBush().setUnlocalizedName("teaBush").setRegistryName("tea_bush");
		mortarAndPestle = new BlockMortarAndPestle().setUnlocalizedName("mortarAndPestle").setRegistryName("mortar_and_pestle");
	}

	public static void register() {
		GameRegistry.register(CoffeeAndTeaModBlocks.mortarAndPestle);
		GameRegistry.register(new ItemBlockMortarAndPestle(CoffeeAndTeaModBlocks.mortarAndPestle), CoffeeAndTeaModBlocks.mortarAndPestle.getRegistryName());
		GameRegistry.register(CoffeeAndTeaModBlocks.emptyCup);
		GameRegistry.register(new ItemBlockEmptyCup(CoffeeAndTeaModBlocks.emptyCup), CoffeeAndTeaModBlocks.emptyCup.getRegistryName());
		GameRegistry.register(CoffeeAndTeaModBlocks.fullCoffeeCup);
		GameRegistry.register(new ItemBlockFullCoffeeCup(CoffeeAndTeaModBlocks.fullCoffeeCup), CoffeeAndTeaModBlocks.fullCoffeeCup.getRegistryName());
		GameRegistry.register(CoffeeAndTeaModBlocks.halfCoffeeCup);
		GameRegistry.register(new ItemBlockHalfCoffeeCup(CoffeeAndTeaModBlocks.halfCoffeeCup), CoffeeAndTeaModBlocks.halfCoffeeCup.getRegistryName());
		GameRegistry.register(CoffeeAndTeaModBlocks.fullCoffeeSugarCup);
		GameRegistry.register(new ItemBlockFullCoffeeSugarCup(CoffeeAndTeaModBlocks.fullCoffeeSugarCup), CoffeeAndTeaModBlocks.fullCoffeeSugarCup.getRegistryName());
		GameRegistry.register(CoffeeAndTeaModBlocks.halfCoffeeSugarCup);
		GameRegistry.register(new ItemBlockHalfCoffeeSugarCup(CoffeeAndTeaModBlocks.halfCoffeeSugarCup), CoffeeAndTeaModBlocks.halfCoffeeSugarCup.getRegistryName());
		GameRegistry.register(CoffeeAndTeaModBlocks.fullTeaCup);
		GameRegistry.register(new ItemBlockFullTeaCup(CoffeeAndTeaModBlocks.fullTeaCup), CoffeeAndTeaModBlocks.fullTeaCup.getRegistryName());
		GameRegistry.register(CoffeeAndTeaModBlocks.halfTeaCup);
		GameRegistry.register(new ItemBlockHalfTeaCup(CoffeeAndTeaModBlocks.halfTeaCup), CoffeeAndTeaModBlocks.halfTeaCup.getRegistryName());

		// register crops
		GameRegistry.register(CoffeeAndTeaModBlocks.coffeeBush);
	    GameRegistry.register(CoffeeAndTeaModBlocks.teaBush);
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
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
