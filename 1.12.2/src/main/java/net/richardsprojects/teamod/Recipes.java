package net.richardsprojects.teamod;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.richardsprojects.teamod.itemblocks.CoffeeAndTeaModItemBlocks;
import net.richardsprojects.teamod.items.CoffeeAndTeaModItems;

public class Recipes {

	public static void registerSmelting() {
		// smelt clay cup into empty cup
		GameRegistry.addSmelting(CoffeeAndTeaModItems.clayCup, new ItemStack(
				CoffeeAndTeaModItemBlocks.emptyCup, 1), 0.0f);

		// smelt water cup into boiling water cup
		GameRegistry.addSmelting(CoffeeAndTeaModItems.waterCup, new ItemStack(
				CoffeeAndTeaModItems.boilingCup, 1), 0.0f);

		// smelt roasted coffee beans
		GameRegistry.addSmelting(CoffeeAndTeaModItems.unroastedCoffeeBean,
				new ItemStack(CoffeeAndTeaModItems.roastedCoffeeBean, 1), 0.0f);
	}

}
