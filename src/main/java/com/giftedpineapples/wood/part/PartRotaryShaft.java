package com.giftedpineapples.wood.part;

import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Vector3;
import com.giftedpineapples.wood.client.renderer.tileentity.TileEntityRendererRotaryShaft;
import com.giftedpineapples.wood.init.ModBlocks;
import com.giftedpineapples.wood.reference.Names;
import com.giftedpineapples.wood.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class PartRotaryShaft extends PartWC {

	public static final String type = Reference.MOD_ID + ":" + Names.Blocks.ROTARY_SHAFT;

	private TileEntitySpecialRenderer tileEntityRendererRotaryShaft;

	public PartRotaryShaft()
	{
		//
	}

	@Override
	public Block getBlock()
	{
		return ModBlocks.rotaryShaft;
	}

	@Override
	public Cuboid6 getBounds()
	{
		return new Cuboid6(0.4D, 0.4D, 0.4D, 0.6D, 0.6D, 0.6D);
	}

	@Override
	public String getType()
	{
		return type;
	}

	@Override
	public void onWorldJoin()
	{
		tileEntityRendererRotaryShaft = new TileEntityRendererRotaryShaft();

		tileEntityRendererRotaryShaft.func_147497_a(TileEntityRendererDispatcher.instance);
	}

	@Override
	public void renderDynamic(Vector3 pos, float frame, int pass)
	{
		tileEntityRendererRotaryShaft.renderTileEntityAt(tile(), pos.x, pos.y, pos.z, 0);
	}

}
