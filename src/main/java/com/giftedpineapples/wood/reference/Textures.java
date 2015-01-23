package com.giftedpineapples.wood.reference;

import com.giftedpineapples.wood.utility.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;

public final class Textures {

	public static final String RESOURCE_PREFIX = Reference.MOD_ID.toLowerCase() + ":";

	public static final class Model
	{
		private static final String MODEL_TEXTURE_LOCATION = "textures/models/";

		public static final ResourceLocation MECHANICAL_ROOT = ResourceLocationHelper.getResourceLocation(MODEL_TEXTURE_LOCATION + Names.Blocks.MECHANICAL_ROOT + ".png");
		public static final ResourceLocation ROTARY_SHAFT = ResourceLocationHelper.getResourceLocation(MODEL_TEXTURE_LOCATION + Names.Blocks.ROTARY_SHAFT + ".png");
		public static final ResourceLocation WIND_TURBINE = ResourceLocationHelper.getResourceLocation(MODEL_TEXTURE_LOCATION + Names.Blocks.WIND_TURBINE + ".png");
	}

}
