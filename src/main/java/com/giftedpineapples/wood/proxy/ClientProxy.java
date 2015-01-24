package com.giftedpineapples.wood.proxy;

import com.giftedpineapples.wood.client.renderer.item.ItemRendererMechanicalRoot;
import com.giftedpineapples.wood.client.renderer.item.ItemRendererRotaryShaft;
import com.giftedpineapples.wood.client.renderer.item.ItemRendererWindTurbine;
import com.giftedpineapples.wood.client.renderer.tileentity.TileEntityRendererMechanicalRoot;
import com.giftedpineapples.wood.client.renderer.tileentity.TileEntityRendererRotaryShaft;
import com.giftedpineapples.wood.client.renderer.tileentity.TileEntityRendererWindTurbine;
import com.giftedpineapples.wood.handler.ClientTickHandler;
import com.giftedpineapples.wood.init.ModBlocks;
import com.giftedpineapples.wood.reference.RenderIds;
import com.giftedpineapples.wood.tileentity.TileEntityMechanicalRoot;
import com.giftedpineapples.wood.tileentity.TileEntityRotaryShaft;
import com.giftedpineapples.wood.tileentity.TileEntityWindTurbine;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

	@Override
	public void initRenderingAndTextures()
	{
		FMLCommonHandler.instance().bus().register(new ClientTickHandler());

		RenderIds.mechanicalRoot = RenderingRegistry.getNextAvailableRenderId();
		RenderIds.rotaryShaft = RenderingRegistry.getNextAvailableRenderId();
		RenderIds.windTurbine = RenderingRegistry.getNextAvailableRenderId();

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.mechanicalRoot), new ItemRendererMechanicalRoot());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.rotaryShaft), new ItemRendererRotaryShaft());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.windTurbine), new ItemRendererWindTurbine());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMechanicalRoot.class, new TileEntityRendererMechanicalRoot());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRotaryShaft.class, new TileEntityRendererRotaryShaft());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindTurbine.class, new TileEntityRendererWindTurbine());
	}

}
