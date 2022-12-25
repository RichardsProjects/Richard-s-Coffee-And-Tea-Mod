package net.richardsprojects.teamod.tile;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ForgeRegistries;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;

public class CoffeeAndTeaModTileEntities {
    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
                new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, CoffeeAndTeaMod.MOD_ID);

    public static void register() {
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<TileEntityType<MortarAndPestleTile>> MORTAR_AND_PESTLE =
            TILE_ENTITIES.register("mortar_and_pestle_tile",
                    () -> TileEntityType.Builder.create(MortarAndPestleTile::new, CoffeeAndTeaModBlocks.MORTAR_AND_PESTLE.get()).build(null));

}
