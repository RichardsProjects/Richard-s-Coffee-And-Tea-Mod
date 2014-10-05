package net.richardsprojects.teamod.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCoffeeTable extends Item
{
	public static Item coffeeTable;
	
	public ItemCoffeeTable()
	{
		super();
		this.maxStackSize = 1;
		
	}
	
	//Item Registration Code
	public static void mainRegistry()	
	{
		initializeItem();
		registerItem();
	}

	private static void initializeItem()
	{
		coffeeTable = new ItemCoffeeTable().setTextureName("teamod:coffeeTable").setUnlocalizedName("coffeeTable").setCreativeTab(TeaMod.teaModTab);
	}
	
	private static void registerItem()
	{
		GameRegistry.registerItem(coffeeTable, coffeeTable.getUnlocalizedName());
	}
	
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		if(itemStack.getItem() == coffeeTable)
		{
			if((world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) != Blocks.crafting_table) || (world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == Blocks.crafting_table && player.isSneaking()))
			{
				//if(player.getRotationYawHead() >= 0 && player.getRotationYawHead() < 90)
				//{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockTableLeft.tableLeft);
					world.setBlock(p_77648_4_ + 1, p_77648_5_ + 1, p_77648_6_, BlockTableRight.tableRight);
					if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockTableLeft.tableLeft) {
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
						
				//}
				/*if(player.getRotationYawHead() >= 90 && player.getRotationYawHead() < 180)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockFullCoffeeCup.fullCoffeeCup);
					if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockFullCoffeeCup.fullCoffeeCup){
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 2, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				if(player.getRotationYawHead() >= 180 && player.getRotationYawHead() < 270)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockFullCoffeeCup.fullCoffeeCup);
					if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockFullCoffeeCup.fullCoffeeCup){
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 3, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				if(player.getRotationYawHead() >= 270 && player.getRotationYawHead() <= 360)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockFullCoffeeCup.fullCoffeeCup);
					if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockFullCoffeeCup.fullCoffeeCup) {
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 4, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}*/
				return true;
			}
		}
		return false;
	}
}
