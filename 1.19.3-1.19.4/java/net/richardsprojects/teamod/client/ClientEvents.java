package net.richardsprojects.teamod.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

@Mod.EventBusSubscriber(modid = CoffeeAndTeaMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        ItemBlockRenderTypes.setRenderLayer(CoffeeAndTeaMod.TEA_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CoffeeAndTeaMod.COFFEE_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CoffeeAndTeaMod.EMPTY_CUP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CoffeeAndTeaMod.FULL_COFFEE_CUP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CoffeeAndTeaMod.HALF_COFFEE_CUP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CoffeeAndTeaMod.FULL_TEA_CUP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CoffeeAndTeaMod.FULL_TEA_CUP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CoffeeAndTeaMod.FULL_COFFEE_SUGAR_CUP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CoffeeAndTeaMod.HALF_COFFEE_SUGAR_CUP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CoffeeAndTeaMod.MORTAR_AND_PESTLE.get(), RenderType.cutout());
    }

}
