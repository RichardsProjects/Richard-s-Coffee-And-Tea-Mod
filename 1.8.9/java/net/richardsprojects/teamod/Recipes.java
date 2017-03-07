package net.richardsprojects.teamod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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
		
		// smelt water cup into boiling water cup
		GameRegistry.addSmelting(CoffeeAndTeaModItems.waterCup, new ItemStack(
				CoffeeAndTeaModItems.boilingCup, 1), 0.0f);		
		
		// smelt roasted coffee beans
		GameRegistry.addSmelting(CoffeeAndTeaModItems.unroastedCoffeeBean,
				new ItemStack(CoffeeAndTeaModItems.roastedCoffeeBean, 1), 0.0f);
		
		// ground tea leaves
		Item mortarAndPestle = Item.getItemFromBlock(CoffeeAndTeaModBlocks.mortarAndPestle);
        GameRegistry.addShapelessRecipe(new ItemStack(CoffeeAndTeaModItems.groundTeaLeaves),
        		new ItemStack(CoffeeAndTeaModItems.teaLeaves), new ItemStack(mortarAndPestle,
        		1, Short.MAX_VALUE));
        
        // mortar and pestle recipe
        GameRegistry.addRecipe(new ItemStack(mortarAndPestle), "  x", "yxy", " y ",
    			'x', new ItemStack(Items.iron_ingot, 1), 'y', new ItemStack(Blocks.stone, 1));
	}

}
