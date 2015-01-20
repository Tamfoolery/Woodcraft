package com.giftedpineapples.wood.init;

import com.giftedpineapples.wood.item.ItemWC;
import com.giftedpineapples.wood.item.ItemWoodenGear;
import com.giftedpineapples.wood.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {

	public static final ItemWC woodenGear = new ItemWoodenGear();

	public static void init()
	{
		GameRegistry.registerItem(woodenGear, "woodenGear");
		OreDictionary.registerOre("gearWood", new ItemStack(woodenGear));
	}

}
