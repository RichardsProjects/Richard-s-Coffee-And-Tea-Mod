package net.richardsprojects.teamod.main;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class TradeHandler implements IVillageTradeHandler {

	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
		
		//This is only called for Farmers so we don't have to worry about checking the profession
		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ItemCoffeeBeans.roastedBean, 10)));
		recipeList.add(new MerchantRecipe(new ItemStack(ItemCoffeeBeans.roastedBean, 20), new ItemStack(Items.emerald, 1)));
		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ItemTeaLeaves.teaLeaves, 10)));
		recipeList.add(new MerchantRecipe(new ItemStack(ItemTeaLeaves.teaLeaves, 20), new ItemStack(Items.emerald, 1)));
		recipeList.add(new MerchantRecipe(new ItemStack(ItemTeaSeeds.teaSeeds, 15), new ItemStack(Items.emerald, 1)));
		recipeList.add(new MerchantRecipe(new ItemStack(ItemCoffeeBeans.unroastedBean, 15), new ItemStack(Items.emerald, 1)));
	}

}
