package com.giftedpineapples.wood.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityWindTurbine extends TileEntityWC {

	public int powerOutput = 1000;

	public TileEntityWindTurbine()
	{
		//
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		return AxisAlignedBB.getBoundingBox(xCoord - 2, yCoord, zCoord - 2, xCoord + 3, yCoord + 1, zCoord + 3);
	}

}
