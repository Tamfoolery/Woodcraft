package com.giftedpineapples.wood.reference;

import com.giftedpineapples.wood.utility.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;

public class Models {

	public static final String MODEL_LOCATION = "models/";

	public static final ResourceLocation MECHANICAL_ROOT = ResourceLocationHelper.getResourceLocation(MODEL_LOCATION + Names.Blocks.MECHANICAL_ROOT + ".obj");
	public static final ResourceLocation ROTARY_SHAFT = ResourceLocationHelper.getResourceLocation(MODEL_LOCATION + Names.Blocks.ROTARY_SHAFT + ".obj");
	public static final ResourceLocation WIND_TURBINE = ResourceLocationHelper.getResourceLocation(MODEL_LOCATION + Names.Blocks.WIND_TURBINE + ".obj");

}
