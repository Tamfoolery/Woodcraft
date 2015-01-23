package com.giftedpineapples.wood.client.renderer.tileentity;

import com.giftedpineapples.wood.client.renderer.model.ModelWindTurbine;
import com.giftedpineapples.wood.reference.Textures;
import com.giftedpineapples.wood.tileentity.TileEntityWindTurbine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityRendererWindTurbine extends TileEntitySpecialRenderer {

	private final ModelWindTurbine modelWindTurbine = new ModelWindTurbine();

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
	{
		if (tileEntity instanceof TileEntityWindTurbine)
		{
//			TileEntityWindTurbine tileEntityRotaryShaft = (TileEntityWindTurbine) tileEntity;

			GL11.glPushMatrix();

			// Scale, Translate, Rotate
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
			GL11.glRotatef(0F, 0F, 0F, 0F);
			GL11.glRotatef(0F, 1F, 0F, 0F);

			// Bind Texture
			this.bindTexture(Textures.Model.WIND_TURBINE);

			// Render
			modelWindTurbine.render();

			GL11.glPopMatrix();
		}
	}

}
