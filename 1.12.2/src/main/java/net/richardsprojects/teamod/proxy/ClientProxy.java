package net.richardsprojects.teamod.proxy;

import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;
import net.richardsprojects.teamod.items.CoffeeAndTeaModItems;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenders() {
		CoffeeAndTeaModBlocks.registerRenders();
		CoffeeAndTeaModItems.registerRenders();
	}
}