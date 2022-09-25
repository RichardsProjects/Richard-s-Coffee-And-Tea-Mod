package net.richardsprojects.teamod.items;

import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

public class ItemTeaSeed extends Item implements IPlantable {

	public ItemTeaSeed() {
		super(new Item.Properties()
			.group(CoffeeAndTeaMod.ITEM_GROUP)
		);
	}
	
	@Override
	public BlockState getPlant(IBlockReader world, BlockPos pos) {
		// TODO Make tea seed plantable
		return null;
	}
}
