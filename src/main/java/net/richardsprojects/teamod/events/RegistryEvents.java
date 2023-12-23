package net.richardsprojects.teamod.events;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

import java.util.Comparator;

import static net.minecraftforge.versions.forge.ForgeVersion.MOD_ID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {

    @SubscribeEvent
    public static void onRegister(RegisterEvent event) {
        if (event.getRegistryKey().equals(ForgeRegistries.Keys.ITEMS)) {
            CoffeeAndTeaMod.COFFEE_AND_TEA_MOD_TAB = CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.teamod"))
                    .displayItems((featureFlagSet, output) ->
                            BuiltInRegistries.ITEM.entrySet().stream()
                                    .filter(entry -> entry.getKey().location().getNamespace().equals(MOD_ID))
                                    .sorted(Comparator.comparing(entry -> BuiltInRegistries.ITEM.getId(entry.getValue())))
                                    .forEach(entry -> output.accept(entry.getValue())))
                    .icon(() -> new ItemStack(CoffeeAndTeaMod.TEA_SEED.get())).build();

            Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(MOD_ID, "teamod"), CoffeeAndTeaMod.COFFEE_AND_TEA_MOD_TAB);
        }
    }

    @SubscribeEvent
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == CoffeeAndTeaMod.COFFEE_AND_TEA_MOD_TAB) {
            event.accept(CoffeeAndTeaMod.ITEM_BLOCK_FULL_COFFEE_CUP);
            event.accept(CoffeeAndTeaMod.ITEM_BLOCK_FULL_COFFEE_SUGAR_CUP);
            event.accept(CoffeeAndTeaMod.ITEM_BLOCK_HALF_COFFEE_CUP);
            event.accept(CoffeeAndTeaMod.ITEM_BLOCK_HALF_COFFEE_SUGAR_CUP);
            event.accept(CoffeeAndTeaMod.ITEM_BLOCK_FULL_TEA_CUP);
            event.accept(CoffeeAndTeaMod.ITEM_BLOCK_HALF_TEA_CUP);
            event.accept(CoffeeAndTeaMod.WATER_CUP);
            event.accept(CoffeeAndTeaMod.BOILING_CUP);
            event.accept(CoffeeAndTeaMod.ITEM_BLOCK_EMPTY_CUP);
            event.accept(CoffeeAndTeaMod.CLAY_CUP);
            event.accept(CoffeeAndTeaMod.ITEM_BLOCK_MORTAR_AND_PESTLE);
            event.accept(CoffeeAndTeaMod.COFFEE_GROUNDS);
            event.accept(CoffeeAndTeaMod.UNROASTED_COFFEE_BEAN);
            event.accept(CoffeeAndTeaMod.ROASTED_COFFEE_BEAN);
            event.accept(CoffeeAndTeaMod.TEA_SEED);
            event.accept(CoffeeAndTeaMod.TEA_LEAVES);
            event.accept(CoffeeAndTeaMod.GROUND_TEA_LEAVES);
        }
    }

}
