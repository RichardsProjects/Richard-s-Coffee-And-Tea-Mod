package net.richardsprojects.teamod.common.blocks.entities;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class CoffeeAndTeaModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CoffeeAndTeaMod.MODID);

    public static final RegistryObject<BlockEntityType<BlockEntityMortarAndPestle>> MORTAR_AND_PESTLE =
            BLOCK_ENTITIES.register("mortar_and_pestle", () ->
                    BlockEntityType.Builder.of(BlockEntityMortarAndPestle::new,
                            CoffeeAndTeaMod.MORTAR_AND_PESTLE.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
