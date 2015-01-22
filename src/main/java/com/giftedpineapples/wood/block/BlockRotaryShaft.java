package com.giftedpineapples.wood.block;

import com.giftedpineapples.wood.reference.Names;
import com.giftedpineapples.wood.reference.RenderIds;
import com.giftedpineapples.wood.tileentity.TileEntityRotaryShaft;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockRotaryShaft extends BlockWC implements ITileEntityProvider {

	public BlockRotaryShaft()
	{
		super();

		float pixel = 1F/16F;

		this.setBlockName(Names.Blocks.ROTARY_SHAFT);
		this.setBlockTextureName(Names.Blocks.ROTARY_SHAFT);

		this.setBlockBounds(12*pixel/2, 12*pixel/2, 12*pixel/2, 1-12*pixel/2, 1-12*pixel/2, 1-12*pixel/2);
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
