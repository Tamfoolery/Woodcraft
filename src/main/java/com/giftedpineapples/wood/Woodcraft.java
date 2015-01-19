package com.giftedpineapples.wood;

import com.giftedpineapples.wood.handler.ConfigHandler;
import com.giftedpineapples.wood.proxy.IProxy;
import com.giftedpineapples.wood.reference.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
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
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		//
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		//
	}

}