package com.giftedpineapples.wood.tileentity;

import com.giftedpineapples.wood.reference.MiscVariables;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityRotaryShaft extends TileEntityWC {

	public boolean isPowered = true;
	public float rotation = 0F;

	public ForgeDirection[] connectDirection = new ForgeDirection[6];

	public Boolean upConnected = false, downConnected = false, northConnected = false, southConnected = false, eastConnected = false, westConnected = false;

	public TileEntityRotaryShaft()
	{
		//
	}

	@Override
	public void updateEntity()
	{
		this.updateConnectionsToRotaryShafts();

		if (rotation >= 360F) rotation = MiscVariables.baseShaftAnimationSpeed;
		else rotation += MiscVariables.baseShaftAnimationSpeed;
	}

	public void updateConnectionsToRotaryShafts()
	{
		TileEntity up = this.worldObj.getTileEntity(xCoord, yCoord + 1, zCoord);
		TileEntity down = this.worldObj.getTileEntity(xCoord, yCoord-1, zCoord);
		TileEntity north = this.worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
		TileEntity south = this.worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
		TileEntity east = this.worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
		TileEntity west = this.worldObj.getTileEntity(xCoord-1, yCoord, zCoord);

		upConnected = (
				up instanceof TileEntityRotaryShaft
				|| up instanceof TileEntityMechanicalRoot
				|| up instanceof TileEntityWindTurbine
		);

		downConnected = (
				down instanceof TileEntityRotaryShaft
				|| down instanceof TileEntityMechanicalRoot
		);

		northConnected = (
				north instanceof TileEntityRotaryShaft
				|| north instanceof TileEntityMechanicalRoot
		);

		southConnected = (
				south instanceof TileEntityRotaryShaft
				|| south instanceof TileEntityMechanicalRoot
		);

		eastConnected = (
				east instanceof TileEntityRotaryShaft
				|| east instanceof TileEntityMechanicalRoot
		);

		westConnected = (
				west instanceof TileEntityRotaryShaft
				|| west instanceof TileEntityMechanicalRoot
		);

		if (upConnected) connectDirection[0] = ForgeDirection.UP;
		else connectDirection[0] = null;
		if (downConnected) connectDirection[1] = ForgeDirection.DOWN;
		else connectDirection[1] = null;
		if (northConnected) connectDirection[2] = ForgeDirection.NORTH;
		else connectDirection[2] = null;
		if (southConnected) connectDirection[3] = ForgeDirection.SOUTH;
		else connectDirection[3] = null;
		if (eastConnected) connectDirection[4] = ForgeDirection.EAST;
		else connectDirection[4] = null;
		if (westConnected) connectDirection[5] = ForgeDirection.WEST;
		else connectDirection[5] = null;
	}

	public boolean onlyOneOpposite(ForgeDirection[] directions)
	{
		ForgeDirection mainDirection = null;
		boolean isOpposite = false;

		for (ForgeDirection direction : directions)
		{
			if (mainDirection == null && direction != null) mainDirection = direction;

			if (direction != null && mainDirection != direction)
			{
				isOpposite = isOpposite(mainDirection, direction);
			}
		}

		return isOpposite;
	}

	public boolean isOpposite(ForgeDirection a, ForgeDirection b)
	{
		if ( (a.equals(ForgeDirection.NORTH) && b.equals(ForgeDirection.SOUTH)) || (a.equals(ForgeDirection.SOUTH) && b.equals(ForgeDirection.NORTH)) ) return true;
		if ( (a.equals(ForgeDirection.EAST) && b.equals(ForgeDirection.WEST)) || (a.equals(ForgeDirection.WEST) && b.equals(ForgeDirection.EAST)) ) return true;
		if ( (a.equals(ForgeDirection.UP) && b.equals(ForgeDirection.DOWN)) || (a.equals(ForgeDirection.DOWN) && b.equals(ForgeDirection.UP)) ) return true;

		return false;
	}

}
