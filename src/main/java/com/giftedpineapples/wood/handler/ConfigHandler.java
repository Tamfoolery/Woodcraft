package com.giftedpineapples.wood.handler;

import com.giftedpineapples.wood.reference.Reference;
import com.giftedpineapples.wood.utility.LogHelper;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigHandler {

	public static Configuration configuration;
	public static boolean configValue = false;

	public static void init(File configFile)
	{
		// Create configuration object from config file
		if (configuration == null) configuration = new Configuration(configFile);
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
		{
			loadConfig();
		}
	}

	public void loadConfig()
	{
		configValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, true, "An example config value");

		if (configuration.hasChanged()) configuration.save();
	}

}
