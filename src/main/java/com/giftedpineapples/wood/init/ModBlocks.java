package com.giftedpineapples.wood.init;

import com.giftedpineapples.wood.block.BlockMechanicalRoot;
import com.giftedpineapples.wood.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

	public static final BlockMechanicalRoot mechanicalRoot = new BlockMechanicalRoot();

	public static void init()
	{
		GameRegistry.registerBlock(mechanicalRoot, "mechanicalRoot");
	}

}
