package net.richardsprojects.teamod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.richardsprojects.teamod.client.ClientEvents;
import net.richardsprojects.teamod.common.blocks.BlockCoffeeBush;
import net.richardsprojects.teamod.common.blocks.BlockEmptyCup;
import net.richardsprojects.teamod.common.blocks.BlockTeaBush;
import net.richardsprojects.teamod.common.items.*;
import org.slf4j.Logger;

import net.richardsprojects.teamod.common.loot.CoffeeAndTeaModLootModifiers;

@Mod(CoffeeAndTeaMod.MODID)
public class CoffeeAndTeaMod
{

    public static final String MODID = "teamod";

    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Block> TEA_BUSH = BLOCKS.register("tea_bush", () -> new BlockTeaBush());
    public static final RegistryObject<Block> COFFEE_BUSH = BLOCKS.register("coffee_bush", () -> new BlockCoffeeBush());
    public static final RegistryObject<Block> EMPTY_CUP = BLOCKS.register("empty_cup", () -> new BlockEmptyCup());
    public static final RegistryObject<Item> TEA_SEED = ITEMS.register("tea_seed", () -> new ItemTeaSeed());
    public static final RegistryObject<Item> TEA_LEAVES  = ITEMS.register("tea_leaves", () -> new ItemTeaLeaves());
    public static final RegistryObject<Item> ROASTED_COFFEE_BEAN = ITEMS.register("roasted_coffee_bean", () -> new ItemRoastedCoffeeBean());
    public static final RegistryObject<Item> UNROASTED_COFFEE_BEAN  = ITEMS.register("unroasted_coffee_bean", () -> new ItemUnroastedCoffeeBean());
    public static final RegistryObject<Item> EMPTY_CUP_ITEM_BLOCK = ITEMS.register("empty_cup", () -> new ItemBlockEmptyCup());


    public static final CreativeModeTab TAB = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(TEA_SEED.get());
        }
    };

    public CoffeeAndTeaMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);

        CoffeeAndTeaModLootModifiers.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new ClientEvents());
    }

}
