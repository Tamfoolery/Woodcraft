package com.giftedpineapples.wood.tileentity;

import net.minecraft.tileentity.TileEntity;

public class TileEntityRotaryShaft extends TileEntityWC {

	public boolean isPowered = true;

	// 0:up, 1:down, 2:north, 3:south, 4:east, 5:west
	public boolean[] sidesConnected = new boolean[6];

	public TileEntityRotaryShaft()
	{
		//
	}

	@Override
	public void updateEntity()
	{
		this.updateConnectionsToRotaryShafts();
	}

	public void updateConnectionsToRotaryShafts()
	{
		TileEntity up = this.worldObj.getTileEntity(xCoord, yCoord + 1, zCoord);
		TileEntity down = this.worldObj.getTileEntity(xCoord, yCoord-1, zCoord);
		TileEntity north = this.worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
		TileEntity south = this.worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
		TileEntity east = this.worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
		TileEntity west = this.worldObj.getTileEntity(xCoord-1, yCoord, zCoord);

		sidesConnected[0] = (
				up instanceof TileEntityRotaryShaft
				|| up instanceof TileEntityMechanicalRoot
				|| up instanceof TileEntityWindTurbine
		);

		sidesConnected[1] = (
				down instanceof TileEntityRotaryShaft
				|| down instanceof TileEntityMechanicalRoot
		);

		sidesConnected[2] = (
				north instanceof TileEntityRotaryShaft
				|| north instanceof TileEntityMechanicalRoot
		);

		sidesConnected[3] = (
				south instanceof TileEntityRotaryShaft
				|| south instanceof TileEntityMechanicalRoot
		);

		sidesConnected[4] = (
				east instanceof TileEntityRotaryShaft
				|| east instanceof TileEntityMechanicalRoot
		);

		sidesConnected[5] = (
				west instanceof TileEntityRotaryShaft
				|| west instanceof TileEntityMechanicalRoot
		);
	}

	public boolean onlyOneOpposite(boolean[] directions)
	{
		boolean ud = (directions[0] && directions[1]) && !(directions[2] || directions[3] || directions[4] || directions[5]);
		boolean ns = (directions[2] && directions[3]) && !(directions[0] || directions[1] || directions[4] || directions[5]);
		boolean ew = (directions[4] && directions[5]) && !(directions[2] || directions[3] || directions[0] || directions[1]);

		return ud || ns || ew;
	}

}
