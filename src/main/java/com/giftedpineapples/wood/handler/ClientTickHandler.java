package com.giftedpineapples.wood.handler;

import com.giftedpineapples.wood.reference.MiscVariables;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;

public class ClientTickHandler {

	// Called when the client ticks. (20 ticks/sec)
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onClientTick(TickEvent.ClientTickEvent event)
	{
		if (!Minecraft.getMinecraft().isGamePaused())
		{
			if (MiscVariables.shaftRotation >= 360F) MiscVariables.shaftRotation = MiscVariables.baseShaftAnimationSpeed;
			else MiscVariables.shaftRotation += MiscVariables.baseShaftAnimationSpeed;
		}
	}

//	// Called when a new frame is displayed (FPS)
//	@SubscribeEvent
//	public void onRenderTick(TickEvent.RenderTickEvent event) {
//		LogHelper.info(event.renderTickTime); // TODO: Find out if this can be used for 60fps animation
//	}

//	// Called whenever the player is updated or ticked.
//	@SubscribeEvent
//	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
//      //
//	}
//
//	// Called when the server ticks. (20 ticks/sec)
//	@SubscribeEvent
//	public void onServerTick(TickEvent.ServerTickEvent event) {
//      //
//	}
//
//	// Called when the world ticks
//	@SubscribeEvent
//	public void onWorldTick(TickEvent.WorldTickEvent event) {
//		//
//	}

}
