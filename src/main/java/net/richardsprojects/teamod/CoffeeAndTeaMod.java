package net.richardsprojects.teamod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.richardsprojects.teamod.common.blocks.*;
import net.richardsprojects.teamod.common.blocks.entities.CoffeeAndTeaModBlockEntities;
import net.richardsprojects.teamod.common.items.*;
import net.richardsprojects.teamod.common.loot.CoffeeAndTeaModLootModifiers;
import net.richardsprojects.teamod.events.MortarAndPestlePlaceEvent;
import org.slf4j.Logger;

@Mod(CoffeeAndTeaMod.MODID)
public class CoffeeAndTeaMod
{

    public static final String MODID = "teamod";

    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Block> TEA_BUSH = BLOCKS.register("tea_bush", () -> new BlockTeaBush());
    public static final RegistryObject<Block> COFFEE_BUSH = BLOCKS.register("coffee_bush", () -> new BlockCoffeeBush());
    public static final RegistryObject<Item> TEA_SEED = ITEMS.register("tea_seed", () -> new ItemTeaSeed());
    public static final RegistryObject<Item> TEA_LEAVES = ITEMS.register("tea_leaves", () -> new ItemTeaLeaves());
    public static final RegistryObject<Item> UNROASTED_COFFEE_BEAN = ITEMS.register("unroasted_coffee_bean", () -> new ItemUnroastedCoffeeBean());
    public static final RegistryObject<Item> ROASTED_COFFEE_BEAN = ITEMS.register("roasted_coffee_bean", () -> new ItemRoastedCoffeeBean());
    public static final RegistryObject<Item> CLAY_CUP = ITEMS.register("clay_cup", () -> new ItemClayCup());
    public static final RegistryObject<Block> EMPTY_CUP = BLOCKS.register("empty_cup", () -> new BlockEmptyCup());
    public static final RegistryObject<Item> COFFEE_GROUNDS = ITEMS.register("coffee_grounds", () -> new ItemCoffeeGrounds());
    public static final RegistryObject<Block> FULL_COFFEE_CUP = BLOCKS.register("full_coffee_cup", () -> new BlockFullCoffeeCup());
    public static final RegistryObject<Block> FULL_TEA_CUP = BLOCKS.register("full_tea_cup", () -> new BlockFullTeaCup());
    public static final RegistryObject<Block> FULL_COFFEE_SUGAR_CUP = BLOCKS.register("full_coffee_sugar_cup", () -> new BlockFullCoffeeSugarCup());
    public static final RegistryObject<Block> HALF_COFFEE_CUP = BLOCKS.register("half_coffee_cup", () -> new BlockHalfCoffeeCup());
    public static final RegistryObject<Block> HALF_TEA_CUP = BLOCKS.register("half_tea_cup", () -> new BlockHalfTeaCup());
    public static final RegistryObject<Block> HALF_COFFEE_SUGAR_CUP = BLOCKS.register("half_coffee_sugar_cup", () -> new BlockHalfCoffeeSugarCup());
    public static final RegistryObject<Item> BOILING_CUP = ITEMS.register("boiling_cup", () -> new ItemBoilingCup());
    public static final RegistryObject<Block> MORTAR_AND_PESTLE = BLOCKS.register("mortar_and_pestle", () -> new BlockMortarAndPestle());
    public static final RegistryObject<Item> WATER_CUP = ITEMS.register("water_cup", () -> new ItemWaterCup());
    public static final RegistryObject<Item> ITEM_BLOCK_EMPTY_CUP = ITEMS.register("empty_cup", () -> new ItemBlockEmptyCup());
    public static final RegistryObject<Item> ITEM_BLOCK_HALF_COFFEE_CUP = ITEMS.register("half_coffee_cup", () -> new ItemBlockHalfCoffeeCup());
    public static final RegistryObject<Item> ITEM_BLOCK_FULL_COFFEE_CUP = ITEMS.register("full_coffee_cup", () -> new ItemBlockFullCoffeeCup());
    public static final RegistryObject<Item> ITEM_BLOCK_FULL_COFFEE_SUGAR_CUP = ITEMS.register("full_coffee_sugar_cup", () -> new ItemBlockFullCoffeeSugarCup());
    public static final RegistryObject<Item> ITEM_BLOCK_HALF_COFFEE_SUGAR_CUP = ITEMS.register("half_coffee_sugar_cup", () -> new ItemBlockHalfCoffeeSugarCup());
    public static final RegistryObject<Item> ITEM_BLOCK_MORTAR_AND_PESTLE = ITEMS.register("mortar_and_pestle", () -> new ItemBlockMortarAndPestle());
    public static final RegistryObject<Item> ITEM_BLOCK_FULL_TEA_CUP = ITEMS.register("full_tea_cup", () -> new ItemBlockFullTeaCup());
    public static final RegistryObject<Item> ITEM_BLOCK_HALF_TEA_CUP = ITEMS.register("half_tea_cup", () -> new ItemBlockHalfTeaCup());
    public static final RegistryObject<Item> GROUND_TEA_LEAVES = ITEMS.register("ground_tea_leaves", () -> new ItemGroundTeaLeaves());
    public static CreativeModeTab COFFEE_AND_TEA_MOD_TAB = null;

    public static boolean surviveEnabled = false;

    public CoffeeAndTeaMod()
    {
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::clientInit);

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CoffeeAndTeaModLootModifiers.register(modEventBus);
        CoffeeAndTeaModBlockEntities.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(new MortarAndPestlePlaceEvent());
    }

    private void clientInit(final FMLClientSetupEvent event) {
        LOGGER.info("CoffeeAndTeaMod Mod List: " + ModList.get().getMods());
        if (ModList.get().isLoaded("survive")) {
            LOGGER.info("Survive has been loaded");
            surviveEnabled = true;
        }
    }

}
