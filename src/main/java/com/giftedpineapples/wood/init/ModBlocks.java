package com.giftedpineapples.wood.init;

import com.giftedpineapples.wood.block.BlockMechanicalRoot;
import com.giftedpineapples.wood.block.BlockRotaryShaft;
import com.giftedpineapples.wood.block.BlockWindTurbine;
import com.giftedpineapples.wood.reference.Names;
import com.giftedpineapples.wood.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

	public static final BlockMechanicalRoot mechanicalRoot = new BlockMechanicalRoot();
	public static final BlockRotaryShaft rotaryShaft = new BlockRotaryShaft();
	public static final BlockWindTurbine windTurbine = new BlockWindTurbine();

	public static void init()
	{
		GameRegistry.registerBlock(mechanicalRoot, Names.Blocks.MECHANICAL_ROOT);
		GameRegistry.registerBlock(rotaryShaft, Names.Blocks.ROTARY_SHAFT);
		OreDictionary.registerOre("rotaryShaft", new ItemStack(rotaryShaft));
		GameRegistry.registerBlock(windTurbine, Names.Blocks.WIND_TURBINE);
	}

}
