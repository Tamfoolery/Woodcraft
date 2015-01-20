package com.giftedpineapples.wood.init;

import com.giftedpineapples.wood.block.BlockRoot;
import com.giftedpineapples.wood.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

	public static final BlockRoot root = new BlockRoot();

	public static void init()
	{
		GameRegistry.registerBlock(root, "root");
	}

}
