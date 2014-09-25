package net.richardsprojects.teamod.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTeaCup extends Item
{
	public static Item fullTeaCup;
	public static Item halfTeaCup;
	
	public ItemTeaCup()
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
		fullTeaCup = new ItemTeaCup().setTextureName("teamod:TeaCup").setUnlocalizedName("fullTeaCup").setCreativeTab(TeaMod.teaModTab);
		halfTeaCup = new ItemTeaCup().setTextureName("teamod:TeaCup").setUnlocalizedName("halfTeaCup").setCreativeTab(TeaMod.teaModTab);
	}
	
	private static void registerItem()
	{
		GameRegistry.registerItem(fullTeaCup, fullTeaCup.getUnlocalizedName());
		GameRegistry.registerItem(halfTeaCup, halfTeaCup.getUnlocalizedName());
	}
	
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		if(itemStack.getItem() == fullTeaCup) {
			if((world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) != Blocks.crafting_table) || (world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == Blocks.crafting_table && player.isSneaking()))
			{
				if(player.getRotationYawHead() >= 0 && player.getRotationYawHead() < 90)
				{
					if(world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockFullTeaCup.fullTeaCup)) {
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 1, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				if(player.getRotationYawHead() >= 90 && player.getRotationYawHead() < 180)
				{
					if(world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockFullTeaCup.fullTeaCup)) {
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 2, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				if(player.getRotationYawHead() >= 180 && player.getRotationYawHead() < 270)
				{
					if(world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockFullTeaCup.fullTeaCup)) {
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 3, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				if(player.getRotationYawHead() >= 270 && player.getRotationYawHead() <= 360)
				{
					if(world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockFullTeaCup.fullTeaCup)) {
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 4, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				return true;
			}
		}
		else if(itemStack.getItem() == halfTeaCup) {
			if((world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) != Blocks.crafting_table) || (world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == Blocks.crafting_table && player.isSneaking()))
			{
				if(player.getRotationYawHead() >= 0 && player.getRotationYawHead() < 90)
				{
					if(world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockHalfTeaCup.halfTeaCup)) {
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 1, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				if(player.getRotationYawHead() >= 90 && player.getRotationYawHead() < 180)
				{
					if(world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockHalfTeaCup.halfTeaCup)) {
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 2, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				if(player.getRotationYawHead() >= 180 && player.getRotationYawHead() < 270)
				{
					if(world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockHalfTeaCup.halfTeaCup)) {
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 3, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				if(player.getRotationYawHead() >= 270 && player.getRotationYawHead() <= 360)
				{
					if(world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockHalfTeaCup.halfTeaCup)) {
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 4, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				return true;
			}
		}
		return false;
	}	
}