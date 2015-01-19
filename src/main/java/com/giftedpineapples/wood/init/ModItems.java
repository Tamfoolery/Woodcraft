package com.giftedpineapples.wood.init;

import com.giftedpineapples.wood.item.ItemWC;
import com.giftedpineapples.wood.item.ItemWoodenGear;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

	public static final ItemWC woodenGear = new ItemWoodenGear();

	public static void init()
	{
		GameRegistry.registerItem(woodenGear, "woodenGear");
	}

}
