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
		if (p_77648_7_ != 1)
		{
			return false;
		}
		else if(itemStack.getItem() == mortarAndPestle)
		{
			if((world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) != Blocks.crafting_table) || (world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == Blocks.crafting_table && player.isSneaking()) && itemStack.getItemDamage() != itemStack.getMaxDamage() - 1)
			{
				if(player.getRotationYawHead() >= 0 && player.getRotationYawHead() < 90)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockMortarAndPestle.mortarAndPestle);
					world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 0, 1);
					MortarAndPestleEntity t = (MortarAndPestleEntity) world.getTileEntity(p_77648_4_, p_77648_5_ + 1, p_77648_6_);
					t.setDurability(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_), world, 64);
				}
				if(player.getRotationYawHead() >= 90 && player.getRotationYawHead() < 180)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockMortarAndPestle.mortarAndPestle);
					world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 1, 1);
					MortarAndPestleEntity t = (MortarAndPestleEntity) world.getTileEntity(p_77648_4_, p_77648_5_ + 1, p_77648_6_);
					t.setDurability(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_), world, 64);
					}
				if(player.getRotationYawHead() >= 180 && player.getRotationYawHead() < 270)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockMortarAndPestle.mortarAndPestle);
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 2, 1);
					MortarAndPestleEntity t = (MortarAndPestleEntity) world.getTileEntity(p_77648_4_, p_77648_5_ + 1, p_77648_6_);
					t.setDurability(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_), world, 64);
				}
				if(player.getRotationYawHead() >= 270 && player.getRotationYawHead() <= 360)
				{
					world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockMortarAndPestle.mortarAndPestle);
					world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 3, 1);
					MortarAndPestleEntity t = (MortarAndPestleEntity) world.getTileEntity(p_77648_4_, p_77648_5_ + 1, p_77648_6_);
					t.setDurability(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_), world, 64);
				}
			itemStack.stackSize--;
			return true;
			}
		}
		return false;
	}
	
}
