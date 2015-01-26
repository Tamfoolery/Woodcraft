package com.giftedpineapples.wood.block;

import com.giftedpineapples.wood.reference.Names;
import com.giftedpineapples.wood.reference.RenderIds;
import com.giftedpineapples.wood.tileentity.TileEntityRotaryShaft;
import com.giftedpineapples.wood.utility.Log;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRotaryShaft extends BlockWC implements ITileEntityProvider {

	float pixel = 1F/16F;

	public BlockRotaryShaft()
	{
		super();

		this.setBlockName(Names.Blocks.ROTARY_SHAFT);
		this.setBlockTextureName(Names.Blocks.ROTARY_SHAFT);

		// Default blocks bounds match gearbox size
		this.setBlockBounds(12*pixel/2, 12*pixel/2, 12*pixel/2, 1-12*pixel/2, 1-12*pixel/2, 1-12*pixel/2);
	}

	// Update block bounds depending on what sides of the shaft are connected to things
	// TODO: Replace with multi/micro/whateveritis-part
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		TileEntityRotaryShaft tileEntityRotaryShaft = (TileEntityRotaryShaft) world.getTileEntity(x, y, z);

		if (tileEntityRotaryShaft != null)
		{
			float minX = 12 * pixel / 2 - (tileEntityRotaryShaft.sidesConnected[5] ? (12 * pixel / 2):0);
			float minY = 12 * pixel / 2 - (tileEntityRotaryShaft.sidesConnected[1] ? (12 * pixel / 2):0);
			float minZ = 12 * pixel / 2 - (tileEntityRotaryShaft.sidesConnected[3] ? (12 * pixel / 2):0);
			float maxX = 1 - 12 * pixel / 2 + (tileEntityRotaryShaft.sidesConnected[4] ? (12 * pixel / 2):0);
			float maxY = 1 - 12 * pixel / 2 + (tileEntityRotaryShaft.sidesConnected[0] ? (12 * pixel / 2):0);
			float maxZ = 1 - 12 * pixel / 2 + (tileEntityRotaryShaft.sidesConnected[2] ? (12 * pixel / 2):0);

			this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
		}
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		TileEntityRotaryShaft tileEntity = (TileEntityRotaryShaft) world.getTileEntity(x, y, z);
		tileEntity.onNeighborBlockChange();
	}

//	@Override
//	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
//	{
//		return AxisAlignedBB.getBoundingBox((double)x + this.minX, (double)y + this.minY, (double)z + this.minZ, (double)x + this.maxX, (double)y + this.maxY, (double)z + this.maxZ);
//	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData)
	{
		return new TileEntityRotaryShaft();
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return RenderIds.rotaryShaft;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

}
