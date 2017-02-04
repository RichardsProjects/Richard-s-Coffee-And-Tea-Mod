package net.richardsprojects.teamod;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;
import net.richardsprojects.teamod.items.CoffeeAndTeaModItems;

public class Recipes {

	public static void register() {
		// empty Cup Recipe
		GameRegistry.addRecipe(new ItemStack(CoffeeAndTeaModItems.clayCup),
				"   ", "x x", " x ", 'x', new ItemStack(Items.clay_ball, 1));

		// smelt clay cup into empty cup
		GameRegistry.addSmelting(CoffeeAndTeaModItems.clayCup, new ItemStack(
				CoffeeAndTeaModBlocks.emptyCup, 1), 0.0f);
		// smelt roasted coffee beans
		GameRegistry.addSmelting(CoffeeAndTeaModItems.unroastedCoffeeBean,
				new ItemStack(CoffeeAndTeaModItems.roastedCoffeeBean, 1), 0.0f);
	}

}
