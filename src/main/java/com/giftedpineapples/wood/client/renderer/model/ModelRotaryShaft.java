package com.giftedpineapples.wood.client.renderer.model;

import com.giftedpineapples.wood.reference.Models;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

@SideOnly(Side.CLIENT)
public class ModelRotaryShaft {

	private IModelCustom modelRotaryShaft;

	public ModelRotaryShaft()
	{
		modelRotaryShaft = AdvancedModelLoader.loadModel(Models.ROTARY_SHAFT);
	}

	public void render(String ... renderGroup)
	{
		for (String s : renderGroup)
		{
			modelRotaryShaft.renderPart(s);
		}
	}

}
