package net.richardsprojects.teamod.common.items;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

@Mod.EventBusSubscriber(modid = CoffeeAndTeaMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CoffeeAndTeaModTab {

    public static CreativeModeTab TAB;

    @SubscribeEvent
    public static void registerCreateModTab(CreativeModeTabEvent.Register event) {
        TAB = event.registerCreativeModeTab(new ResourceLocation(CoffeeAndTeaMod.MODID, "tutorial_tab"),
                builder -> builder.icon(() -> new ItemStack(CoffeeAndTeaMod.ROASTED_COFFEE_BEAN.get())).title(Component.translatable("itemGroup.teamod")).build());
    }

}
