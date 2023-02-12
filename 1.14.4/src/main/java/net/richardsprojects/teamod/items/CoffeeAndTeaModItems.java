package net.richardsprojects.teamod.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class CoffeeAndTeaModItems {

	private static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, CoffeeAndTeaMod.MOD_ID);
	 
	public static void register() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	public static final RegistryObject<ItemBoilingCup> BOILING_CUP = ITEMS.register("boiling_cup", ItemBoilingCup::new);
	public static final RegistryObject<ItemClayCup> CLAY_CUP = ITEMS.register("clay_cup", ItemClayCup::new);
	public static final RegistryObject<ItemCoffeeGrounds> COFFEE_GROUNDS = ITEMS.register("coffee_grounds", ItemCoffeeGrounds::new);
	public static final RegistryObject<ItemGroundTeaLeaves> GROUND_TEA_LEAVES = ITEMS.register("ground_tea_leaves", ItemGroundTeaLeaves::new);
	public static final RegistryObject<ItemRoastedCoffeeBean> ROASTED_COFFEE_BEAN = ITEMS.register("roasted_coffee_bean", ItemRoastedCoffeeBean::new);
	public static final RegistryObject<ItemTeaLeaves> TEA_LEAVES = ITEMS.register("tea_leaves", ItemTeaLeaves::new);
	public static final RegistryObject<ItemTeaSeed> TEA_SEED = ITEMS.register("tea_seed", ItemTeaSeed::new);
	public static final RegistryObject<ItemUnroastedCoffeeBean> UNROASTED_COFFEE_BEAN = ITEMS.register("unroasted_coffee_bean", ItemUnroastedCoffeeBean::new);
	public static final RegistryObject<ItemBlockEmptyCup> ITEM_BLOCK_EMPTY_CUP = ITEMS.register("empty_cup", ItemBlockEmptyCup::new);
	public static final RegistryObject<ItemBlockFullCoffeeCup> ITEM_BLOCK_FULL_COFFEE_CUP = ITEMS.register("full_coffee_cup", ItemBlockFullCoffeeCup::new);
	public static final RegistryObject<ItemBlockHalfCoffeeCup> ITEM_BLOCK_HALF_COFFEE_CUP = ITEMS.register("half_coffee_cup", ItemBlockHalfCoffeeCup::new);
	public static final RegistryObject<ItemBlockFullTeaCup> ITEM_BLOCK_FULL_TEA_CUP = ITEMS.register("full_tea_cup", ItemBlockFullTeaCup::new);
	public static final RegistryObject<ItemBlockHalfTeaCup> ITEM_BLOCK_HALF_TEA_CUP = ITEMS.register("half_tea_cup", ItemBlockHalfTeaCup::new);
	public static final RegistryObject<ItemWaterCup> WATER_CUP = ITEMS.register("water_cup", ItemWaterCup::new);

	public static final RegistryObject<ItemBlockMortarAndPestle> ITEM_BLOCK_MORTAR_AND_PESTLE = ITEMS.register("mortar_and_pestle", ItemBlockMortarAndPestle::new);

	
}
