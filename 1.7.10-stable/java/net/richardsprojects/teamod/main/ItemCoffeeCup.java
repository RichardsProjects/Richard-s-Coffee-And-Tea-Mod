package net.richardsprojects.teamod.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCoffeeCup extends Item
{
	public static Item fullCoffeeCup;
	public static Item halfCoffeeCup;
	
	public ItemCoffeeCup()
	{
		super();
		this.maxStackSize = 8;
		
	}
	
	// item registration code
	public static void mainRegistry()	
	{
		initializeItem();
		registerItem();
	}

	private static void initializeItem()
	{
		fullCoffeeCup = new ItemCoffeeCup().setTextureName("teamod:CoffeeCup").setUnlocalizedName("fullCoffeeCup").setCreativeTab(TeaMod.teaModTab);
		halfCoffeeCup = new ItemCoffeeCup().setTextureName("teamod:CoffeeCup").setUnlocalizedName("halfCoffeeCup").setCreativeTab(TeaMod.teaModTab);
	}
	
	private static void registerItem()
	{
		GameRegistry.registerItem(fullCoffeeCup, fullCoffeeCup.getUnlocalizedName());
		GameRegistry.registerItem(halfCoffeeCup, halfCoffeeCup.getUnlocalizedName());
	}
	
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		if(itemStack.getItem() == fullCoffeeCup)
		{
			if((world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) != Blocks.crafting_table) || (world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == Blocks.crafting_table && player.isSneaking()))
			{
				if(player.getRotationYawHead() >= 0 && player.getRotationYawHead() < 90)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockFullCoffeeCup.fullCoffeeCup);
					if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockFullCoffeeCup.fullCoffeeCup) {
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 1, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
						
				}
				if(player.getRotationYawHead() >= 90 && player.getRotationYawHead() < 180)
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
				}
				return true;
			}
			else if(itemStack.getItem() == halfCoffeeCup)
			{
				if((world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) != Blocks.crafting_table) || (world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == Blocks.crafting_table && player.isSneaking()))
				{
					if(player.getRotationYawHead() >= 0 && player.getRotationYawHead() < 90)
					{
						world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockHalfCoffeeCup.halfCoffeeCup);
						if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockHalfCoffeeCup.halfCoffeeCup) {
							world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 1, 1);
							if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
						}
					}
					if(player.getRotationYawHead() >= 90 && player.getRotationYawHead() < 180)
					{
						world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockHalfCoffeeCup.halfCoffeeCup);
						if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockHalfCoffeeCup.halfCoffeeCup){
							world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 2, 1);
							if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
						}
					}
					if(player.getRotationYawHead() >= 180 && player.getRotationYawHead() < 270)
					{
						world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockHalfCoffeeCup.halfCoffeeCup);
						if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockHalfCoffeeCup.halfCoffeeCup){
							world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 3, 1);
							if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
						}
					}
					if(player.getRotationYawHead() >= 270 && player.getRotationYawHead() <= 360)
					{
						world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockHalfCoffeeCup.halfCoffeeCup);
						if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockHalfCoffeeCup.halfCoffeeCup){
							world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 4, 1);
							if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
						}
					}
					return true;
				}
			}
				
			return false;
		}
		return false;
	}
}
