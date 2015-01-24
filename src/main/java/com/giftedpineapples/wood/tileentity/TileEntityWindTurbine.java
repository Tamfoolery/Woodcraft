package com.giftedpineapples.wood.tileentity;

import com.giftedpineapples.wood.reference.MiscVariables;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityWindTurbine extends TileEntityWC {

	public int powerOutput = 1000;
	public float rotation = 0F;

	public TileEntityWindTurbine()
	{
		//
	}

	@Override
	public void updateEntity()
	{
		if (rotation >= 360F) rotation = MiscVariables.baseShaftAnimationSpeed;
		else rotation += MiscVariables.baseShaftAnimationSpeed;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		return AxisAlignedBB.getBoundingBox(xCoord - 2, yCoord, zCoord - 2, xCoord + 3, yCoord + 1, zCoord + 3);
	}

}
