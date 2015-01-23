package com.giftedpineapples.wood.init;

import codechicken.lib.vec.BlockCoord;
import codechicken.multipart.MultiPartRegistry;
import codechicken.multipart.TMultiPart;
import com.giftedpineapples.wood.part.PartRotaryShaft;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import scala.actors.threadpool.Arrays;

public class ModParts implements MultiPartRegistry.IPartFactory, MultiPartRegistry.IPartConverter {

	public void init()
	{
		MultiPartRegistry.registerConverter(this);
		MultiPartRegistry.registerParts(new ModParts(), new String[] {
				PartRotaryShaft.type
		});
	}

	@Override
	public TMultiPart createPart(String name, boolean client)
	{
		if (name.equals(PartRotaryShaft.type)) return new PartRotaryShaft();

		return null;
	}

	@Override
	public Iterable<Block> blockTypes()
	{
		return Arrays.asList(new Block[]{
				ModBlocks.rotaryShaft
		});
	}

	@Override
	public TMultiPart convert(World world, BlockCoord pos)
	{
		Block b = world.getBlock(pos.x, pos.y, pos.z);

		if (b == ModBlocks.rotaryShaft) return new PartRotaryShaft();

		return null;
	}
}
