package com.giftedpineapples.wood.client.renderer.model;

import net.minecraftforge.client.model.IModelCustom;

public class ModelWC {

	public IModelCustom modelCustom;

	public void render()
	{
		modelCustom.renderAll();
	}

	public void render(String ... renderGroup)
	{
		for (String s : renderGroup)
		{
			modelCustom.renderPart(s);
		}
	}

}
