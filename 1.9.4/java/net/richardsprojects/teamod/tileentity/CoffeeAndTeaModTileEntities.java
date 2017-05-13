package net.richardsprojects.teamod.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class CoffeeAndTeaModTileEntities {

	public static void register() {
		GameRegistry.registerTileEntity(TileEntityMortarAndPestle.class, "teamodMortarAndPestle");
	}
	
}
