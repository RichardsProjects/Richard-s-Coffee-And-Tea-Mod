package net.richardsprojects.teamod.main;

import org.apache.logging.log4j.Logger;

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
	
	public static Logger logger;
	
    // The instance of your mod that Forge uses.
    @Instance("TeaMod")
    public static TeaMod instance;
	
    
    
	@EventHandler 
	public void preInit(FMLPreInitializationEvent event) {
		 
			logger = event.getModLog();
		
		 	registerBlocksAndItems();
	    	registerTileEntities();
    	
		    //Add Spawns to Chests - trying to keep lines under 80 characters.
	    	WeightedRandomChestContent chestContent1;
	    	ItemStack coffee = new ItemStack(ItemCoffeeBeans.roastedBean);
	    	chestContent1 = new WeightedRandomChestContent(coffee, 5, 24, 065);
		    ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(chestContent1);
	    	WeightedRandomChestContent chestContent2;
	    	ItemStack teaLeaves = new ItemStack(ItemTeaLeaves.teaLeaves);
	    	chestContent2 = new WeightedRandomChestContent(teaLeaves, 5, 24, 065);
		    ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(chestContent2);
		    
		    //Mineshafts
		    ItemStack coffeeSeed = new ItemStack(ItemCoffeeBeans.unroastedBean);
		    WeightedRandomChestContent chest1;
		    chest1 = new WeightedRandomChestContent(coffeeSeed, 2, 5, 065);
		    ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(chest1);
		    WeightedRandomChestContent chest2;
		    ItemStack teaSeeds = new ItemStack(ItemTeaSeeds.teaSeeds);
		    chest2 = new WeightedRandomChestContent(teaSeeds, 2, 5, 065);
		    ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(chest2);
	    	
		    //Add Custom Trades for farmer
		    TradeHandler th = new TradeHandler();
		    VillagerRegistry.instance().registerVillageTradeHandler(0, th);
		    
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
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//Register World Generator
		GameRegistry.registerWorldGenerator(new BushWorldGenerator(), 0);
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
    	ItemGroundTeaLeaves.mainRegistry();
    	
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
        
    	//Ground Tea Leaves
        GameRegistry.addShapelessRecipe(new ItemStack(ItemGroundTeaLeaves.groundTeaLeaves),
        		new ItemStack(ItemTeaLeaves.teaLeaves), new ItemStack(ItemMortarAndPestle.mortarAndPestle, 1, WILDCARD_VALUE));
        
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
    			'x', new ItemStack(ItemGroundTeaLeaves.groundTeaLeaves, 1), 'y', new ItemStack(ItemBoilingWaterCup.boilingWaterCup, 1));
    	
        //Coffee with Sugar
    	GameRegistry.addRecipe(new ItemStack(ItemCoffeeCupSugar.fullCoffeeCupSugar), "xxx", "xyx", "xxx",
    			'x', new ItemStack(Items.sugar, 1), 'y', new ItemStack(ItemCoffeeCup.fullCoffeeCup, 1));
	}

}
