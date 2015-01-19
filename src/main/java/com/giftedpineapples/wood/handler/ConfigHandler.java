package com.giftedpineapples.wood.handler;

import com.giftedpineapples.wood.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

	public static Configuration configuration;
	public static boolean configValue = false;

	public static void init(File configFile)
	{
		if (configuration == null)
		{
			configuration = new Configuration(configFile);
			loadConfig();
		}
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
		{
			loadConfig();
		}
	}

	private static void loadConfig()
	{
		configValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, true, "An example config value");

		if (configuration.hasChanged()) configuration.save();
	}

}
