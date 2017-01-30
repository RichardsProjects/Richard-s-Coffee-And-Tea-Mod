package net.richardsprojects.teamod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumWorldBlockLayer;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class BlockEmptyCup extends Block {

	public BlockEmptyCup() {
		super(Material.wood);
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.495F, 0.8F);
		this.setCreativeTab(CoffeeAndTeaMod.teaTab);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}
}
