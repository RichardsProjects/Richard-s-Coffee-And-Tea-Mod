package net.richardsprojects.teamod.itemblocks;

import net.minecraft.item.ItemBlock;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;
import net.richardsprojects.teamod.itemblocks.*;

public class CoffeeAndTeaModItemBlocks {

    public static ItemBlock mortarAndPestle;
    public static ItemBlock emptyCup;
    public static ItemBlock fullCoffeeCup;
    public static ItemBlock halfCoffeeCup;
    public static ItemBlock fullCoffeeCupSugar;
    public static ItemBlock halfCoffeeCupSugar;
    public static ItemBlock fullTeaCup;
    public static ItemBlock halfTeaCup;

	public static void init() {
	    mortarAndPestle = new ItemBlockMortarAndPestle(CoffeeAndTeaModBlocks.mortarAndPestle);
        mortarAndPestle.setRegistryName(CoffeeAndTeaModBlocks.mortarAndPestle.getRegistryName() + "_item");
	    emptyCup = new ItemBlockEmptyCup(CoffeeAndTeaModBlocks.emptyCup);
        emptyCup.setRegistryName(CoffeeAndTeaModBlocks.emptyCup.getRegistryName());
	    fullCoffeeCup = new ItemBlockFullCoffeeCup(CoffeeAndTeaModBlocks.fullCoffeeCup);
        fullCoffeeCup.setRegistryName(CoffeeAndTeaModBlocks.fullCoffeeCup.getRegistryName());
	    halfCoffeeCup = new ItemBlockHalfCoffeeCup(CoffeeAndTeaModBlocks.halfCoffeeCup);
        halfCoffeeCup.setRegistryName(CoffeeAndTeaModBlocks.halfCoffeeCup.getRegistryName());
	    fullCoffeeCupSugar = new ItemBlockFullCoffeeSugarCup(CoffeeAndTeaModBlocks.fullCoffeeSugarCup);
        fullCoffeeCupSugar.setRegistryName(CoffeeAndTeaModBlocks.fullCoffeeSugarCup.getRegistryName());
	    halfCoffeeCupSugar = new ItemBlockHalfCoffeeSugarCup(CoffeeAndTeaModBlocks.halfCoffeeSugarCup);
        halfCoffeeCupSugar.setRegistryName(CoffeeAndTeaModBlocks.halfCoffeeSugarCup.getRegistryName());
	    fullTeaCup = new ItemBlockFullTeaCup(CoffeeAndTeaModBlocks.fullTeaCup);
        fullTeaCup.setRegistryName(CoffeeAndTeaModBlocks.fullTeaCup.getRegistryName());
	    halfTeaCup = new ItemBlockHalfTeaCup(CoffeeAndTeaModBlocks.halfTeaCup);
        halfTeaCup.setRegistryName(CoffeeAndTeaModBlocks.halfTeaCup.getRegistryName());
    }

}
