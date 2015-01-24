package com.giftedpineapples.wood.block;

import com.giftedpineapples.wood.init.ModBlocks;
import com.giftedpineapples.wood.reference.Names;
import com.giftedpineapples.wood.reference.RenderIds;
import com.giftedpineapples.wood.tileentity.TileEntityMechanicalRoot;
import com.giftedpineapples.wood.tileentity.TileEntityRotaryShaft;
import com.giftedpineapples.wood.tileentity.TileEntityWindTurbine;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWindTurbine extends BlockWC implements ITileEntityProvider {

	public BlockWindTurbine()
	{
		super();

		this.setBlockName(Names.Blocks.WIND_TURBINE);
		this.setBlockTextureName(Names.Blocks.WIND_TURBINE);

		float pixel = 1F/16F;

		this.setBlockBounds(12*pixel/2, 0*pixel/2, 12*pixel/2, 1-12*pixel/2, 1-0*pixel/2, 1-12*pixel/2);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData)
	{
		return new TileEntityWindTurbine();
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

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return isBlockBelowValid(world, x, y, z);
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		if (!isBlockBelowValid(world, x, y, z))
		{
			world.setBlockToAir(x, y, z);
			if (!world.isRemote) this.dropBlockAsItem(world, x, y, z, new ItemStack(Item.getItemFromBlock(ModBlocks.windTurbine)));
		}
	}

	private boolean isBlockBelowValid(World world, int x, int y, int z)
	{
		TileEntity blockBelow = world.getTileEntity(x, y - 1, z);
		return (blockBelow instanceof TileEntityRotaryShaft || blockBelow instanceof TileEntityMechanicalRoot);
	}

}
