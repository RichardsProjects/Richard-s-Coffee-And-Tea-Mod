package net.richardsprojects.teamod;

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
    // [ ] Add boiling water cup furnace recipe
    // [X] Add Full Coffee cups to the mod
    //    [X] Make sure recipe works
    //    [X] Allow full coffee cups to be drank from
    // [X] Add Half Coffee cups to the mod
    //    [X] Allow half coffee cups to be drank from
    // [ ] Add Sugar Coffee Cups to mod

    // [ ] Add Tea Bushes to the mod (just copy the coffee bushes for this)
    // [ ] Add Tea Cups to the mod

	// [ ] Add Mortar and Pestle Block to the mod
	// [ ] Get Mortar and Pestle Recipes working

	// [ ] Get terrain generation working
    // [ ] Verify that coffee and tea seeds appear in dungeons and mineshafts

    // [ ] Update Korean and German language files to use JSON
	
    public CoffeeAndTeaMod() {
        CoffeeAndTeaModBlocks.register(); // register blocks
        CoffeeAndTeaModItems.register(); // register items
        
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
    }
    

    public static final ItemGroup ITEM_GROUP = new ItemGroup("teamod") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(CoffeeAndTeaModItems.COFFEE_GROUNDS.get());
        }
    };

	
}
