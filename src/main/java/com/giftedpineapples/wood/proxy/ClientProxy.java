package com.giftedpineapples.wood.proxy;

import com.giftedpineapples.wood.client.renderer.item.ItemRendererMechanicalRoot;
import com.giftedpineapples.wood.init.ModBlocks;
import com.giftedpineapples.wood.reference.RenderIds;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

	@Override
	public void initRenderingAndTextures()
	{
		RenderIds.mechanicalRoot = RenderingRegistry.getNextAvailableRenderId();

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.mechanicalRoot), new ItemRendererMechanicalRoot());
	}

}
