package com.giftedpineapples.wood.tileentity;

import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;

public class TileEntityRotaryShaft extends TileEntityWC {

	private ArrayList<Integer> energySourcesConnectedNetwork = new ArrayList<Integer>();
	private ArrayList<Integer> energySourcesConnectedLocal = new ArrayList<Integer>();

	// 0:up, 1:down, 2:north, 3:south, 4:east, 5:west
	public boolean[] sidesConnected = new boolean[6];

	private TileEntity up, down, north, south, east, west;

	public TileEntityRotaryShaft()
	{
		power = 0;
//		this.updatePower();
	}

	@Override
	public void updateEntity()
	{
		up = this.worldObj.getTileEntity(xCoord, yCoord + 1, zCoord);
		down = this.worldObj.getTileEntity(xCoord, yCoord - 1, zCoord);
		north = this.worldObj.getTileEntity(xCoord, yCoord, zCoord + 1);
		south = this.worldObj.getTileEntity(xCoord, yCoord, zCoord - 1);
		east = this.worldObj.getTileEntity(xCoord + 1, yCoord, zCoord);
		west = this.worldObj.getTileEntity(xCoord - 1, yCoord, zCoord);

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

	private void updatePower()
	{
		power = 0;
		ArrayList<Integer> energySourcesConnectedThisPass = new ArrayList<Integer>();
		ArrayList<Integer> energySourcesConnectedLastPass = energySourcesConnectedLocal;

		for (int i = 0; i < sidesConnected.length; i++)
		{
			TileEntityWC tileEntity;
			switch (i)
			{
				case 0:
					tileEntity = (up instanceof TileEntityWC) ? (TileEntityWC) up : null;
					break;
				case 1:
					tileEntity = (down instanceof TileEntityWC) ? (TileEntityWC) down : null;
					break;
				case 2:
					tileEntity = (north instanceof TileEntityWC) ? (TileEntityWC) north : null;
					break;
				case 3:
					tileEntity = (south instanceof TileEntityWC) ? (TileEntityWC) south : null;
					break;
				case 4:
					tileEntity = (east instanceof TileEntityWC) ? (TileEntityWC) east : null;
					break;
				case 5:
					tileEntity = (west instanceof TileEntityWC) ? (TileEntityWC) west : null;
					break;
				default:
					tileEntity = null;
			}

			if (tileEntity != null)
			{
				if (tileEntity.emitsKP)
				{
					if (!energySourcesConnectedNetwork.contains(tileEntity.tileEntityID))
					{
						power += tileEntity.power;
						energySourcesConnectedThisPass.add(tileEntity.tileEntityID);
					}
				}

				// TODO: After we've looped through every side for non-shaft tiles, loop again for shafts...
				// TODO: ...or loop once, gather all tiles then loop through that looking at non-shaft tiles first..?
			}
		}

		// Remove all the energy sources from our array that are still connected since the last time we checked,
		// so we're only left with the sources that have been removed since the last check
		for (int i : energySourcesConnectedThisPass) energySourcesConnectedLastPass.remove(i);

		// Remember this checks connected sources for next time
		energySourcesConnectedLocal = energySourcesConnectedThisPass;

		// Remove all removed sources from the sources connected in this network
		for (int i : energySourcesConnectedLastPass) energySourcesConnectedNetwork.remove(i);

		isPowered = (power > 0);
	}

	public boolean onlyOneOpposite(boolean[] directions)
	{
		boolean ud = (directions[0] && directions[1]) && !(directions[2] || directions[3] || directions[4] || directions[5]);
		boolean ns = (directions[2] && directions[3]) && !(directions[0] || directions[1] || directions[4] || directions[5]);
		boolean ew = (directions[4] && directions[5]) && !(directions[2] || directions[3] || directions[0] || directions[1]);

		return ud || ns || ew;
	}

}
