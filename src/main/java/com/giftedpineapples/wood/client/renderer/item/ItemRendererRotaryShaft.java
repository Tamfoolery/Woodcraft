package com.giftedpineapples.wood.client.renderer.item;

import com.giftedpineapples.wood.client.renderer.model.ModelRotaryShaft;
import com.giftedpineapples.wood.reference.Textures;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ItemRendererRotaryShaft implements IItemRenderer {

	private final ModelRotaryShaft modelRotaryShaft;

	public ItemRendererRotaryShaft()
	{
		modelRotaryShaft = new ModelRotaryShaft();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch (type)
		{
			case ENTITY:
			{
				renderMechanicalRoot(-0.5F, -0.38F, 0.5F);
				return;
			}
			case EQUIPPED:
			{
				renderMechanicalRoot(-0.3F, 0.0F, 0.6F, 2F, 2F, 2F);
				return;
			}
			case EQUIPPED_FIRST_PERSON:
			{
				renderMechanicalRoot(0.0F, -0.0F, -0.5F);
				return;
			}
			case INVENTORY:
			{
				renderMechanicalRoot(0.0F, -0.6F, 0.0F, 2F, 2F, 2F);
				return;
			}
			default:
		}
	}

	private void renderMechanicalRoot(float x, float y, float z)
	{
		renderMechanicalRoot(x, y, z, 1F, 1F, 1F);
	}

	private void renderMechanicalRoot(float x, float y, float z, float sx, float sy, float sz)
	{
		GL11.glPushMatrix();

		GL11.glScalef(sx, sy, sz);
		GL11.glTranslatef(x, y, z);
		GL11.glRotatef(0, 1F, 0, 0);

		// Bind texture
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.Model.ROTARY_SHAFT);

		// Render
		modelRotaryShaft.render("GearBox");

		GL11.glPopMatrix();
	}
}
