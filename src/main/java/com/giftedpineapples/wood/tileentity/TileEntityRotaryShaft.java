package com.giftedpineapples.wood.tileentity;

import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;

public class TileEntityRotaryShaft extends TileEntityWC {

	public int power = 0;
	public boolean isPowered = false;

	private ArrayList energySourcesConnected = new ArrayList();

	// 0:up, 1:down, 2:north, 3:south, 4:east, 5:west
	public boolean[] sidesConnected = new boolean[6];
	private boolean[] sidesInputtingPower = new boolean[6];

	private TileEntity up, down, north, south, east, west;

	public TileEntityRotaryShaft()
	{
		//
	}

	@Override
	public void updateEntity()
	{
		up = this.worldObj.getTileEntity(xCoord, yCoord + 1, zCoord);
		down = this.worldObj.getTileEntity(xCoord, yCoord-1, zCoord);
		north = this.worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
		south = this.worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
		east = this.worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
		west = this.worldObj.getTileEntity(xCoord-1, yCoord, zCoord);

		this.updateConnectionsToRotaryShafts();
		this.updatePower();
	}

	private void updateConnectionsToRotaryShafts()
	{
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

	public void onNeighborBlockChange()
	{
		power = 0;
		isPowered = false;
		sidesInputtingPower = new boolean[6];
	}

	private void updatePower()
	{
		for (int i = 0; i < sidesConnected.length; i++)
		{
			TileEntityWC tileEntity;
			switch (i)
			{
				case 0:
					tileEntity = (TileEntityWC) up;
					break;
				case 1:
					tileEntity = (TileEntityWC) down;
					break;
				case 2:
					tileEntity = (TileEntityWC) north;
					break;
				case 3:
					tileEntity = (TileEntityWC) south;
					break;
				case 4:
					tileEntity = (TileEntityWC) east;
					break;
				case 5:
					tileEntity = (TileEntityWC) west;
					break;
				default:
					tileEntity = null;
			}

			if (tileEntity != null)
			{
				if (tileEntity.emitsKP)
				{
					if (!sidesInputtingPower[i])
					{
						power += tileEntity.power;
						isPowered = true;
						sidesInputtingPower[i] = true;
					}
				}
				else
				{
					sidesInputtingPower[i] = false;
				}
			}
			else
			{
				sidesInputtingPower[i] = false;
			}
		}
	}

	public boolean onlyOneOpposite(boolean[] directions)
	{
		boolean ud = (directions[0] && directions[1]) && !(directions[2] || directions[3] || directions[4] || directions[5]);
		boolean ns = (directions[2] && directions[3]) && !(directions[0] || directions[1] || directions[4] || directions[5]);
		boolean ew = (directions[4] && directions[5]) && !(directions[2] || directions[3] || directions[0] || directions[1]);

		return ud || ns || ew;
	}

}
