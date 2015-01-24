package com.giftedpineapples.wood.client.renderer.model;

import com.giftedpineapples.wood.reference.Models;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

@SideOnly(Side.CLIENT)
public class ModelWindTurbine extends ModelWC {

	public ModelWindTurbine()
	{
		modelCustom = AdvancedModelLoader.loadModel(Models.WIND_TURBINE);
	}

}
