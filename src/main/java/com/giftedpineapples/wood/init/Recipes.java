package com.giftedpineapples.wood.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes {

	public static void init()
	{
		// Item Recipes
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.woodenGear), " s ", "s s", " s ", 's', "stickWood"));

		// Block Recipes
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.mechanicalRoot), "glg", "l l", "glg", 'g', "gearWood", 'l', "logWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.rotaryShaft, 2), "s", "p", "s", 's', "stickWood", 'p', "plankWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.windTurbine), " p ", "psp", " p ", 's', "rotaryShaft", 'p', "plankWood"));
	}

}