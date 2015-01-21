package com.giftedpineapples.wood.block;

import com.giftedpineapples.wood.reference.Names;
import com.giftedpineapples.wood.reference.RenderIds;
import com.giftedpineapples.wood.tileentity.TileEntityMechanicalRoot;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMechanicalRoot extends BlockWC implements ITileEntityProvider {

	public BlockMechanicalRoot()
	{
		super();
		this.setBlockName(Names.Blocks.MECHANICAL_ROOT);
		this.setBlockTextureName(Names.Blocks.MECHANICAL_ROOT);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData)
	{
		return new TileEntityMechanicalRoot();
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return RenderIds.mechanicalRoot;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

}
