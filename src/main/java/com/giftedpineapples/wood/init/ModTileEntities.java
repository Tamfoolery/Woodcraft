package com.giftedpineapples.wood.init;

import com.giftedpineapples.wood.reference.Names;
import com.giftedpineapples.wood.tileentity.TileEntityMechanicalRoot;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities {

	public static void init()
	{
		GameRegistry.registerTileEntity(TileEntityMechanicalRoot.class, Names.Blocks.MECHANICAL_ROOT);
	}

}