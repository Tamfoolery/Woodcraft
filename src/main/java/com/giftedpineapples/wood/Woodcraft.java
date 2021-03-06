package com.giftedpineapples.wood;

import com.giftedpineapples.wood.handler.ConfigHandler;
import com.giftedpineapples.wood.init.*;
import com.giftedpineapples.wood.proxy.IProxy;
import com.giftedpineapples.wood.reference.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS, dependencies = "after:ForgeMultipart;after:ForgeMicroblocks")
public class Woodcraft {

	@Mod.Instance(Reference.MOD_ID)
	public static Woodcraft instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// Load handler file
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigHandler());

		// Register Items & Blocks
		ModItems.init();
		ModBlocks.init();
//		new ModParts().init(); // this should help https://github.com/MineMaarten/PneumaticCraft/blob/master/src/pneumaticCraft/common/block/tubes/TubeModule.java
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		// Init Tile Entities
		ModTileEntities.init();

		// Initialize custom rendering and pre-load textures (Client only)
		proxy.initRenderingAndTextures();

		Recipes.init();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		//
	}

}