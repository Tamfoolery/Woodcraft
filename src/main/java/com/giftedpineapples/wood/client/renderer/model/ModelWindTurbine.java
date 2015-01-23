package com.giftedpineapples.wood.client.renderer.model;

import com.giftedpineapples.wood.reference.Models;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

@SideOnly(Side.CLIENT)
public class ModelWindTurbine {

	private IModelCustom modelWindTurbine;

	public ModelWindTurbine()
	{
		modelWindTurbine = AdvancedModelLoader.loadModel(Models.WIND_TURBINE);
	}

	public void render()
	{
		modelWindTurbine.renderAll();
	}

	public void render(String ... renderGroup)
	{
		for (String s : renderGroup)
		{
			modelWindTurbine.renderPart(s);
		}
	}
}
