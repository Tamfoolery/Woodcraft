package com.giftedpineapples.wood.init;

import com.giftedpineapples.wood.reference.Names;
import com.giftedpineapples.wood.tileentity.TileEntityMechanicalRoot;
import com.giftedpineapples.wood.tileentity.TileEntityRotaryShaft;
import com.giftedpineapples.wood.tileentity.TileEntityWindTurbine;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities {

	public static void init()
	{
		GameRegistry.registerTileEntity(TileEntityMechanicalRoot.class, Names.Blocks.MECHANICAL_ROOT);
		GameRegistry.registerTileEntity(TileEntityRotaryShaft.class, Names.Blocks.ROTARY_SHAFT);
		GameRegistry.registerTileEntity(TileEntityWindTurbine.class, Names.Blocks.WIND_TURBINE);
	}

}
