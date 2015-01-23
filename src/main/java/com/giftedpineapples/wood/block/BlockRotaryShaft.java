package com.giftedpineapples.wood.block;

import com.giftedpineapples.wood.reference.Names;
import com.giftedpineapples.wood.reference.RenderIds;
import com.giftedpineapples.wood.tileentity.TileEntityRotaryShaft;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRotaryShaft extends BlockWC implements ITileEntityProvider {

	float pixel = 1F/16F;

	public BlockRotaryShaft()
	{
		super();

		this.setBlockName(Names.Blocks.ROTARY_SHAFT);
		this.setBlockTextureName(Names.Blocks.ROTARY_SHAFT);

		this.setBlockBounds(12*pixel/2, 12*pixel/2, 12*pixel/2, 1-12*pixel/2, 1-12*pixel/2, 1-12*pixel/2);
	}

	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		TileEntityRotaryShaft tileEntityRotaryShaft = (TileEntityRotaryShaft) world.getTileEntity(x, y, z);

		if (tileEntityRotaryShaft != null)
		{
			float minX = 12 * pixel / 2 - (tileEntityRotaryShaft.westConnected ? (12 * pixel / 2):0);
			float minY = 12 * pixel / 2 - (tileEntityRotaryShaft.downConnected ? (12 * pixel / 2):0);
			float minZ = 12 * pixel / 2 - (tileEntityRotaryShaft.southConnected ? (12 * pixel / 2):0);
			float maxX = 1 - 12 * pixel / 2 + (tileEntityRotaryShaft.eastConnected ? (12 * pixel / 2):0);
			float maxY = 1 - 12 * pixel / 2 + (tileEntityRotaryShaft.upConnected ? (12 * pixel / 2):0);
			float maxZ = 1 - 12 * pixel / 2 + (tileEntityRotaryShaft.northConnected ? (12 * pixel / 2):0);

			this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return AxisAlignedBB.getBoundingBox((double)x + this.minX, (double)y + this.minY, (double)z + this.minZ, (double)x + this.maxX, (double)y + this.maxY, (double)z + this.maxZ);
	}

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
