package net.richardsprojects.teamod.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.richardsprojects.teamod.entity.MortarAndPestleEntity;

public class ItemMortarAndPestle extends Item
{
	public static Item mortarAndPestle;
	
	public ItemMortarAndPestle()
	{
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(64);
		
	}
	
	//Item Registration Code
	public static void mainRegistry()	
	{
		initializeItem();
		registerItem();
	}

	private static void initializeItem()
	{
		mortarAndPestle = new ItemMortarAndPestle().setTextureName("teamod:mortarandpestle").setUnlocalizedName("mortar").setCreativeTab(TeaMod.teaModTab);
	}
	
	private static void registerItem()
	{
		GameRegistry.registerItem(mortarAndPestle, mortarAndPestle.getUnlocalizedName());
	}
	
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		if(itemStack.getItem() == mortarAndPestle)
		{
			if((world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) != Blocks.crafting_table) || (world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == Blocks.crafting_table && player.isSneaking()) && itemStack.getItemDamage() != itemStack.getMaxDamage() - 1)
			{
				if(player.getRotationYawHead() >= 0 && player.getRotationYawHead() < 90)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockMortarAndPestle.mortarAndPestle);
					if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockMortarAndPestle.mortarAndPestle){
						MortarAndPestleEntity t = (MortarAndPestleEntity) world.getTileEntity(p_77648_4_, p_77648_5_ + 1, p_77648_6_);
						int durability = 64 - itemStack.getItemDamage();
						t.setDurability(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_), world, durability);
						int metadataValue = 0;
						if(durability > 49) {
							metadataValue = 0;
						}
						if(durability < 49 && durability > 32) {
							metadataValue = 4;
						}
						if(durability < 33 && durability > 16) {
							metadataValue = 8;
						}
						if(durability < 17 && durability > 0) {
							metadataValue = 12;
						}					
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, metadataValue, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				if(player.getRotationYawHead() >= 90 && player.getRotationYawHead() < 180)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockMortarAndPestle.mortarAndPestle);
					if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockMortarAndPestle.mortarAndPestle){
						MortarAndPestleEntity t = (MortarAndPestleEntity) world.getTileEntity(p_77648_4_, p_77648_5_ + 1, p_77648_6_);
						int durability = 64 - itemStack.getItemDamage();
						t.setDurability(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_), world, durability);
						int metadataValue = 0;
						if(durability > 49) {
							metadataValue = 1;
						}
						if(durability < 49 && durability > 32) {
							metadataValue = 5;
						}
						if(durability < 33 && durability > 16) {
							metadataValue = 9;
						}
						if(durability < 17 && durability > 0) {
							metadataValue = 13;
						}					
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, metadataValue, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				if(player.getRotationYawHead() >= 180 && player.getRotationYawHead() < 270)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockMortarAndPestle.mortarAndPestle);
					if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockMortarAndPestle.mortarAndPestle){
						MortarAndPestleEntity t = (MortarAndPestleEntity) world.getTileEntity(p_77648_4_, p_77648_5_ + 1, p_77648_6_);
						int durability = 64 - itemStack.getItemDamage();
						t.setDurability(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_), world, durability);
						int metadataValue = 0;
						if(durability > 49) {
							metadataValue = 2;
						}
						if(durability < 49 && durability > 32) {
							metadataValue = 6;
						}
						if(durability < 33 && durability > 16) {
							metadataValue = 10;
						}
						if(durability < 17 && durability > 0) {
							metadataValue = 14;
						}					
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, metadataValue, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
				if(player.getRotationYawHead() >= 270 && player.getRotationYawHead() <= 360)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockMortarAndPestle.mortarAndPestle);
					if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) == BlockMortarAndPestle.mortarAndPestle){
						MortarAndPestleEntity t = (MortarAndPestleEntity) world.getTileEntity(p_77648_4_, p_77648_5_ + 1, p_77648_6_);
						int durability = 64 - itemStack.getItemDamage();
						t.setDurability(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_), world, durability);
						int metadataValue = 0;
						if(durability > 49) {
							metadataValue = 3;
						}
						if(durability < 49 && durability > 32) {
							metadataValue = 7;
						}
						if(durability < 33 && durability > 16) {
							metadataValue = 11;
						}
						if(durability < 17 && durability > 0) {
							metadataValue = 15;
						}					
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, metadataValue, 1);
						if(!player.capabilities.isCreativeMode) itemStack.stackSize--;
					}
				}
			return true;
			}
		}
		return false;
	}
	
}
