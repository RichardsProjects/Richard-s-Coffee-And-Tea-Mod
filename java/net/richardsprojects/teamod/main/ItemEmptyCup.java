package net.richardsprojects.teamod.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEmptyCup extends Item
{
	public static Item emptyCup;
	
	public ItemEmptyCup()
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
		emptyCup = new ItemEmptyCup().setTextureName("teamod:EmptyCup").setUnlocalizedName("emptyCup").setCreativeTab(TeaMod.teaModTab);
	}
	
	private static void registerItem()
	{
		GameRegistry.registerItem(emptyCup, emptyCup.getUnlocalizedName());
	}
	
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		if (p_77648_7_ != 1)
		{
			return false;
		}
		else if(itemStack.getItem() == emptyCup)
		{
			if((world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) != Blocks.crafting_table) || (world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == Blocks.crafting_table && player.isSneaking()))
			{
				//Make sure the blocks aren't in water
				if(world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_) != Blocks.water && world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) != Blocks.water) {
					if(player.getRotationYawHead() >= 0 && player.getRotationYawHead() < 90)
					{
						world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockEmptyCup.emptyCup);
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 1, 1);
					}
					if(player.getRotationYawHead() > 90 && player.getRotationYawHead() < 180)
					{
						world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockEmptyCup.emptyCup);
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 2, 1);
					}
					if(player.getRotationYawHead() > 180 && player.getRotationYawHead() < 270)
					{
						world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockEmptyCup.emptyCup);
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 3, 1);
					}
					if(player.getRotationYawHead() > 270 && player.getRotationYawHead() <= 360)
					{
						world.setBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_, BlockEmptyCup.emptyCup);
						world.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_ + 1, p_77648_6_, 4, 1);
					}
					itemStack.stackSize--;
				}
			}
		}
		return true;
	}
}	
