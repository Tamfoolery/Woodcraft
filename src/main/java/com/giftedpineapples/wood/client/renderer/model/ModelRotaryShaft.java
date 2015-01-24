package com.giftedpineapples.wood.client.renderer.model;

import com.giftedpineapples.wood.reference.Models;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelRotaryShaft extends ModelWC {

	public ModelRotaryShaft()
	{
		modelCustom = AdvancedModelLoader.loadModel(Models.ROTARY_SHAFT);
	}

}
