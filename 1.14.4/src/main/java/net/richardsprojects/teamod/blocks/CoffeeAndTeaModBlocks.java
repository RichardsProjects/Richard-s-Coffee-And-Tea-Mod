package net.richardsprojects.teamod.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class CoffeeAndTeaModBlocks {
	
	private static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, CoffeeAndTeaMod.MOD_ID);
	 
	public static void register() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	public static final RegistryObject<BlockCoffeeBush> COFFEE_BUSH = BLOCKS.register("coffee_bush", BlockCoffeeBush::new);

	public static final RegistryObject<BlockEmptyCup> EMPTY_CUP = BLOCKS.register("empty_cup", BlockEmptyCup::new);
	public static final RegistryObject<BlockFullCoffeeCup> FULL_COFFEE_CUP = BLOCKS.register("full_coffee_cup", BlockFullCoffeeCup::new);
	public static final RegistryObject<BlockHalfCoffeeCup> HALF_COFFEE_CUP = BLOCKS.register("half_coffee_cup", BlockHalfCoffeeCup::new);

	public static final RegistryObject<BlockMortarAndPestle> MORTAR_AND_PESTLE = BLOCKS.register("mortar_and_pestle", BlockMortarAndPestle::new);

}
