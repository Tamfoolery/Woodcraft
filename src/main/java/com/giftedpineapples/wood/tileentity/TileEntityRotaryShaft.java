package com.giftedpineapples.wood.tileentity;

import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityRotaryShaft extends TileEntityWC {

	public ForgeDirection[] connectDirection = new ForgeDirection[6];

	public TileEntityRotaryShaft()
	{
		//
	}

	@Override
	public void updateEntity()
	{
		this.updateConnections();
	}

	public void updateConnections()
	{
		if (this.worldObj.getTileEntity(xCoord, yCoord+1, zCoord) instanceof TileEntityRotaryShaft) connectDirection[0] = ForgeDirection.UP;
		else connectDirection[0] = null;
		if (this.worldObj.getTileEntity(xCoord, yCoord-1, zCoord) instanceof TileEntityRotaryShaft) connectDirection[1] = ForgeDirection.DOWN;
		else connectDirection[1] = null;
		if (this.worldObj.getTileEntity(xCoord, yCoord, zCoord+1) instanceof TileEntityRotaryShaft) connectDirection[2] = ForgeDirection.NORTH;
		else connectDirection[2] = null;
		if (this.worldObj.getTileEntity(xCoord, yCoord, zCoord-1) instanceof TileEntityRotaryShaft) connectDirection[3] = ForgeDirection.SOUTH;
		else connectDirection[3] = null;
		if (this.worldObj.getTileEntity(xCoord+1, yCoord, zCoord) instanceof TileEntityRotaryShaft) connectDirection[4] = ForgeDirection.EAST;
		else connectDirection[4] = null;
		if (this.worldObj.getTileEntity(xCoord-1, yCoord, zCoord) instanceof TileEntityRotaryShaft) connectDirection[5] = ForgeDirection.WEST;
		else connectDirection[5] = null;
	}

}
