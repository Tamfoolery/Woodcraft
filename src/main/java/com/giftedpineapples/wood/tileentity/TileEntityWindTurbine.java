package com.giftedpineapples.wood.tileentity;

import net.minecraft.util.AxisAlignedBB;

public class TileEntityWindTurbine extends TileEntityWC {

	public TileEntityWindTurbine()
	{
		//
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox()
	{
		return AxisAlignedBB.getBoundingBox(xCoord - 2, yCoord, zCoord - 2, xCoord + 3, yCoord + 1, zCoord + 3);
	}

}
