package net.richardsprojects.teamod.main;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;

import net.richardsprojects.teamod.entity.CoffeeBushEntity;
import net.richardsprojects.teamod.entity.EmptyCupEntity;
import net.richardsprojects.teamod.entity.FullCoffeeCupEntity;
import net.richardsprojects.teamod.entity.FullTeaCupEntity;
import net.richardsprojects.teamod.entity.HalfCoffeeCupEntity;
import net.richardsprojects.teamod.entity.HalfTeaCupEntity;
import net.richardsprojects.teamod.entity.MortarAndPestleEntity;
import net.richardsprojects.teamod.entity.TeaBushEntity;
import net.richardsprojects.teamod.lib.Strings;
import net.richardsprojects.teamod.render.CoffeeBushRenderer;
import net.richardsprojects.teamod.render.EmptyCupRenderer;
import net.richardsprojects.teamod.render.FullCoffeeCupRenderer;
import net.richardsprojects.teamod.render.FullTeaCupRenderer;
import net.richardsprojects.teamod.render.HalfCoffeeCupRenderer;
import net.richardsprojects.teamod.render.HalfTeaCupRenderer;
import net.richardsprojects.teamod.render.MortarAndPestleRenderer;
import net.richardsprojects.teamod.render.TeaBushRenderer;

@Mod(modid=Strings.MODID, name=Strings.MOD_NAME, version=Strings.VERSION)

public class TeaMod {
	
	public static CreativeTabs teaModTab = new CreativeTabs("mainTab") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return ItemCoffeeBeans.roastedBean;
		}
	};
	
    // The instance of your mod that Forge uses.
    @Instance("TeaMod")
    public static TeaMod instance;
	
	 @EventHandler 
	 public void preInit(FMLPreInitializationEvent event) {
		 
		 	registerBlocksAndItems();
	    	registerTileEntities();
    	
		    //Add Spawns to Chests
		    ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ItemCoffeeBeans.roastedBean), 5, 24, 065));
		    ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ItemTeaLeaves.teaLeaves), 5, 24, 065));
		    
		    //Mineshafts
		    ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ItemCoffeeBeans.unroastedBean), 2, 5, 065));
		    ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ItemTeaSeeds.teaSeeds), 2, 5, 065));
	    	
		    //Add Custom Trades for farmer
		    VillagerRegistry.instance().registerVillageTradeHandler(0, new TradeHandler());
		    
	    	//Setup Events
	    	MinecraftForge.EVENT_BUS.register(new MCForgeModEvents());
	    	FMLCommonHandler.instance().bus().register(new FMLModEvents());    	
	    	
	    	addRecipes();
	 }
	
	 @EventHandler
	 @SideOnly(Side.CLIENT)
	 public void loadClient(FMLInitializationEvent event) {
		//Setup Renderers - Client side only
        ClientRegistry.bindTileEntitySpecialRenderer(FullCoffeeCupEntity.class, new FullCoffeeCupRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(HalfCoffeeCupEntity.class, new HalfCoffeeCupRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(EmptyCupEntity.class, new EmptyCupRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(CoffeeBushEntity.class, new CoffeeBushRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(HalfTeaCupEntity.class, new HalfTeaCupRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(FullTeaCupEntity.class, new FullTeaCupRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TeaBushEntity.class, new TeaBushRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(MortarAndPestleEntity.class, new MortarAndPestleRenderer());
    }
	
 
	private void registerBlocksAndItems()
	{
		BlockFullCoffeeCup.mainRegistry();
    	BlockHalfCoffeeCup.mainRegistry();
    	BlockEmptyCup.mainRegistry();
    	BlockCoffeeBush.mainRegistry();
    	BlockFullTeaCup.mainRegistry();
    	BlockHalfTeaCup.mainRegistry();
    	BlockHalfCoffeeCupSugar.mainRegistry();
    	BlockFullCoffeeCupSugar.mainRegistry();
    	BlockTeaBush.mainRegistry();
    	BlockMortarAndPestle.mainRegistry();
    	ItemCoffeeCup.mainRegistry();
    	ItemCoffeeCupSugar.mainRegistry();
    	ItemTeaCup.mainRegistry();
    	ItemWaterCup.mainRegistry();
    	ItemBoilingWaterCup.mainRegistry();
    	ItemEmptyCup.mainRegistry();
    	ItemClayCup.mainRegistry();
    	ItemCoffeeBeans.mainRegistry();
    	ItemCoffeeGrounds.mainRegistry();
    	ItemMortarAndPestle.mainRegistry();
    	ItemTeaSeeds.mainRegistry();
    	ItemTeaLeaves.mainRegistry();
    	
    	//Add Seeds
    	MinecraftForge.addGrassSeed(new ItemStack(ItemCoffeeBeans.unroastedBean, 1), 5);
    	MinecraftForge.addGrassSeed(new ItemStack(ItemTeaSeeds.teaSeeds, 1), 5);
	}
	
	private void registerTileEntities()
	{
    	GameRegistry.registerTileEntity(FullCoffeeCupEntity.class, "fullCoffeeCup");
    	GameRegistry.registerTileEntity(HalfCoffeeCupEntity.class, "halfCoffeeCup");
    	GameRegistry.registerTileEntity(EmptyCupEntity.class, "emptyCup");
    	GameRegistry.registerTileEntity(CoffeeBushEntity.class, "coffeeBush");
    	GameRegistry.registerTileEntity(HalfTeaCupEntity.class, "halfTeaCup");
    	GameRegistry.registerTileEntity(FullTeaCupEntity.class, "fullTeaCup");
    	GameRegistry.registerTileEntity(TeaBushEntity.class, "teaBush");
    	GameRegistry.registerTileEntity(MortarAndPestleEntity.class, "mortarAndPestleEntity");
	}
	
	private void addRecipes()
	{
		//Smelting Recipe(s)
    	GameRegistry.addSmelting(ItemCoffeeBeans.unroastedBean, new ItemStack(ItemCoffeeBeans.roastedBean, 1), 0.5f);
    	GameRegistry.addSmelting(ItemClayCup.clayCup, new ItemStack(ItemEmptyCup.emptyCup, 1), 0.0f);
    	GameRegistry.addSmelting(ItemWaterCup.waterCup, new ItemStack(ItemBoilingWaterCup.boilingWaterCup, 1), 0.99f);
    	
    	//Coffee Grounds Recipe
    	final int WILDCARD_VALUE = Short.MAX_VALUE;
        GameRegistry.addShapelessRecipe(new ItemStack(ItemCoffeeGrounds.coffeeGrounds),
        		new ItemStack(ItemCoffeeBeans.roastedBean), new ItemStack(ItemMortarAndPestle.mortarAndPestle, 1, WILDCARD_VALUE));
        
        //Add Coffee Recipe
    	GameRegistry.addRecipe(new ItemStack(ItemCoffeeCup.fullCoffeeCup), "xxx", "xyx", "xxx",
    			'x', new ItemStack(ItemCoffeeGrounds.coffeeGrounds, 1), 'y', new ItemStack(ItemBoilingWaterCup.boilingWaterCup, 1));
        
        //Add Mortar And Pestle Recipe
    	GameRegistry.addRecipe(new ItemStack(ItemMortarAndPestle.mortarAndPestle), "  x", "yxy", " y ",
    			'x', new ItemStack(Items.iron_ingot, 1), 'y', new ItemStack(Blocks.stone, 1));
    	
        //Empty Cup Recipe
    	GameRegistry.addRecipe(new ItemStack(ItemClayCup.clayCup), "   ", "x x", " x ",
    			'x', new ItemStack(Items.clay_ball, 1));
    	
        //Add Tea Recipe
    	GameRegistry.addRecipe(new ItemStack(ItemTeaCup.fullTeaCup), "xxx", "xyx", "xxx",
    			'x', new ItemStack(ItemTeaLeaves.teaLeaves, 1), 'y', new ItemStack(ItemBoilingWaterCup.boilingWaterCup, 1));
    	
        //Coffee with Sugar
    	GameRegistry.addRecipe(new ItemStack(ItemCoffeeCupSugar.fullCoffeeCupSugar), "xxx", "xyx", "xxx",
    			'x', new ItemStack(Items.sugar, 1), 'y', new ItemStack(ItemCoffeeCup.fullCoffeeCup, 1));
	}

}
