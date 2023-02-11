package net.richardsprojects.teamod;

import net.richardsprojects.teamod.tile.CoffeeAndTeaModTileEntities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.richardsprojects.teamod.blocks.CoffeeAndTeaModBlocks;
import net.richardsprojects.teamod.items.CoffeeAndTeaModItems;
import net.richardsprojects.teamod.proxy.ClientProxy;
import net.richardsprojects.teamod.proxy.IProxy;
import net.richardsprojects.teamod.proxy.ServerProxy;

@Mod("teamod")
public class CoffeeAndTeaMod {

	private static final Logger LOGGER = LogManager.getLogger();
	
	public static final IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
	
	public static final String MOD_ID = "teamod";
	

	// [X] Add Coffee Bushes to the mod
    //     [X] Fix issues with bonemeal not working on Coffee Bushes
    //     [X] Fix issues with boxes not appearing around Coffee Bushes
	//     [X] Make sure the model shows for later stages
    //     [X] Get drop table working for Coffee Bushes
    // [X] Add Empty Cup Block
    //     [X] Fix issue with block lighting
    //     [X] Make sure model is working
    //     [X] Update bounding box to match model
    //     [X] Fix slight issue with leaf texture on bottom of one side of plate
    //     [X] Get Empty Cup furnace recipe working
    // [X] Allow empty cup be able to be filled with water
    // [X] Add boiling water cup furnace recipe
    // [X] Add Full Coffee cups to the mod
    //    [X] Make sure recipe works
    //    [X] Allow full coffee cups to be drank from
    // [X] Add Half Coffee cups to the mod
    //    [X] Allow half coffee cups to be drank from

    // [X] Add Mortar and Pestle Block to the mod
    //      [X] ItemBlock
    //      [X] Block and Tile Entity
    //      [X] PlayEvent when Mortar and Pestle breaks (use anvil break)
    //      [X] Give warnings durability less than or equal to 10
    //      [X] Make use lower NBT durability data
    //      [X] Make sure durability gets preserved between logins
    //      [X] Allow it to be used to grind coffee beans
    //      [X] Add crafting recipe
    //      [X] Get it to drop a damaged version of it when broken
    //      [X] Get it to place with the correct amount of durability left

    // [ ] Remaining for first version
    //      [ ] Add Tea Bushes to the mod
    //      [ ] Add support for tea leaves to mortar and pestle
    //      [ ] Add Tea Cups to the mod
    //      [ ] Add Sugar Coffee Cups to mod

    // [ ] Possible following updates:
	//      [ ] Get terrain generation working
    //      [ ] Verify that coffee and tea seeds appear in dungeons and mineshafts
    //      [ ] Update Korean and German language files to use JSON
    //      [ ] Add AppleSkin support
	
    public CoffeeAndTeaMod() {
        // register blocks, items and tile entities
        CoffeeAndTeaModBlocks.register();
        CoffeeAndTeaModItems.register();
        CoffeeAndTeaModTileEntities.register();

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
    }
    
    public static final ItemGroup ITEM_GROUP = new ItemGroup("teamod") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(CoffeeAndTeaModItems.ROASTED_COFFEE_BEAN.get());
        }
    };

	
}
