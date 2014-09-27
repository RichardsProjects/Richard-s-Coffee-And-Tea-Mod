package net.richardsprojects.teamod.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemCoffeeCupSugar extends Item
{
	public static Item fullCoffeeCupSugar;
	public static Item halfCoffeeCupSugar;
	
	public ItemCoffeeCupSugar()
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
		fullCoffeeCupSugar = new ItemCoffeeCupSugar().setTextureName("teamod:CoffeeWithSugar").setUnlocalizedName("fullCoffeeCupSugar").setCreativeTab(TeaMod.teaModTab);
		halfCoffeeCupSugar = new ItemCoffeeCupSugar().setTextureName("teamod:CoffeeWithSugar").setUnlocalizedName("halfCoffeeCupSugar").setCreativeTab(TeaMod.teaModTab);
	}
	
	private static void registerItem()
	{
		GameRegistry.registerItem(fullCoffeeCupSugar, fullCoffeeCupSugar.getUnlocalizedName());
		GameRegistry.registerItem(halfCoffeeCupSugar, halfCoffeeCupSugar.getUnlocalizedName());
	}
	
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		if(itemStack.getItem() == fullCoffeeCupSugar) {
			if((world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) != Blocks.crafting_table) || (world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == Blocks.crafting_table && player.isSneaking()))
			{
				if(player.getRotationYawHead() >= 0 && player.getRotationYawHead() <= 90)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockFullCoffeeCupSugar.fullCoffeeCupSugar);
					if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockFullCoffeeCupSugar.fullCoffeeCupSugar){
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 1, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				if(player.getRotationYawHead() >= 90 && player.getRotationYawHead() <= 180)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockFullCoffeeCupSugar.fullCoffeeCupSugar);
					if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockFullCoffeeCupSugar.fullCoffeeCupSugar){
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 2, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				if(player.getRotationYawHead() >= 180 && player.getRotationYawHead() <= 270)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockFullCoffeeCupSugar.fullCoffeeCupSugar);
					if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockFullCoffeeCupSugar.fullCoffeeCupSugar){
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 3, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				if(player.getRotationYawHead() >= 270 && player.getRotationYawHead() <= 360)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockFullCoffeeCupSugar.fullCoffeeCupSugar);
					if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockFullCoffeeCupSugar.fullCoffeeCupSugar){
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 1, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				return true;
			}
		} else if(itemStack.getItem() == halfCoffeeCupSugar)
		{
			if((world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) != Blocks.crafting_table) || (world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == Blocks.crafting_table && player.isSneaking()))
			{
				if(player.getRotationYawHead() >= 0 && player.getRotationYawHead() <= 90)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockHalfCoffeeCupSugar.halfCoffeeCup);
					if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockHalfCoffeeCupSugar.halfCoffeeCup){
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 1, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				if(player.getRotationYawHead() >= 90 && player.getRotationYawHead() <= 180)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockHalfCoffeeCupSugar.halfCoffeeCup);
					if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockHalfCoffeeCupSugar.halfCoffeeCup){
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 2, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				if(player.getRotationYawHead() >= 180 && player.getRotationYawHead() <= 270)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockHalfCoffeeCupSugar.halfCoffeeCup);
					if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockHalfCoffeeCupSugar.halfCoffeeCup){
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 3, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				if(player.getRotationYawHead() >= 270 && player.getRotationYawHead() <= 360)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockHalfCoffeeCupSugar.halfCoffeeCup);
					if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockHalfCoffeeCupSugar.halfCoffeeCup){
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 1, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				return true;
			}
		} else {
			return false;
	    }
		return false;
	}
}