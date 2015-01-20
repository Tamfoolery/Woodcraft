package com.giftedpineapples.wood.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityWC extends TileEntity {

	protected ForgeDirection orientation;
	protected byte state;

	public TileEntityWC()
	{
		orientation = ForgeDirection.SOUTH;
		state = 0;
	}

	public ForgeDirection getOrientation()
	{
		return orientation;
	}

	public void setOrientation(ForgeDirection orientation)
	{
		this.orientation = orientation;
	}

	public void setOrientation(int orientation)
	{
		this.orientation = ForgeDirection.getOrientation(orientation);
	}

	public short getState()
	{
		return state;
	}

	public void setState(byte state)
	{
		this.state = state;
	}

}
