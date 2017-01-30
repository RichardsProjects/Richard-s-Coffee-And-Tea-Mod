package net.richardsprojects.teamod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CoffeeAndTeaTab extends CreativeTabs {

	public CoffeeAndTeaTab() {
		super("tabCoffeeAndTea");
		//this.setBackgroundImageName("recipeExpansionPack.png");		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Items.acacia_door;
	}

}