package com.giftedpineapples.wood.client.renderer.model;

import com.giftedpineapples.wood.reference.Models;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

@SideOnly(Side.CLIENT)
public class ModelMechanicalRoot {

	private IModelCustom modelMechanicalRoot;

	public ModelMechanicalRoot()
	{
		modelMechanicalRoot = AdvancedModelLoader.loadModel(Models.MECHANICAL_ROOT);
	}

	public void render()
	{
		modelMechanicalRoot.renderAll();
	}

}
