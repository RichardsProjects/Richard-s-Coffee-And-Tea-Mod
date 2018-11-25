package net.richardsprojects.teamod.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.richardsprojects.teamod.CoffeeAndTeaMod;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;
import net.richardsprojects.teamod.tileentity.TileEntityMortarAndPestle;

public class ItemBlockMortarAndPestle extends ItemBlock {

	public ItemBlockMortarAndPestle(Block block) {
		super(block);
		this.maxStackSize = 1;
		this.setUnlocalizedName("mortarAndPestle");
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
		this.setMaxDamage(64);
	}
}
