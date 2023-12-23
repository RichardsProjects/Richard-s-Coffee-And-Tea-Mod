package net.richardsprojects.teamod.common.loot;

import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class CoffeeAndTeaModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(
            ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, CoffeeAndTeaMod.MODID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> SEED_DROPS = LOOT_MODIFIER_SERIALIZERS.register(
            "seed_drops", SeedDropLootModifier.CODEC
    );

    public static void register(IEventBus bus) {
        LOOT_MODIFIER_SERIALIZERS.register(bus);
    }


}
