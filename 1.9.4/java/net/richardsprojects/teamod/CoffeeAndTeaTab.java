package net.richardsprojects.teamod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.richardsprojects.teamod.items.CoffeeAndTeaModItems;

public class CoffeeAndTeaTab extends CreativeTabs {

	public CoffeeAndTeaTab() {
		super("tabCoffeeAndTea");
		//this.setBackgroundImageName("recipeExpansionPack.png");		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return CoffeeAndTeaModItems.unroastedCoffeeBean;
	}

}