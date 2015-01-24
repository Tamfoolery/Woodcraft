package com.giftedpineapples.wood.handler;

import com.giftedpineapples.wood.reference.MiscVariables;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class ClientTickHandler {

	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event)
	{
		if (MiscVariables.shaftRotation >= 360F) MiscVariables.shaftRotation = MiscVariables.baseShaftAnimationSpeed;
		else MiscVariables.shaftRotation += MiscVariables.baseShaftAnimationSpeed;
	}

}
