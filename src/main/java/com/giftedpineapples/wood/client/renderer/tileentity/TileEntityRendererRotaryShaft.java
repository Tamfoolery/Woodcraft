package com.giftedpineapples.wood.client.renderer.tileentity;

import com.giftedpineapples.wood.client.renderer.model.ModelRotaryShaft;
import com.giftedpineapples.wood.reference.Textures;
import com.giftedpineapples.wood.tileentity.TileEntityRotaryShaft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityRendererRotaryShaft extends TileEntitySpecialRenderer {

	private final ModelRotaryShaft modelRotaryShaft = new ModelRotaryShaft();

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
	{
		if (tileEntity instanceof TileEntityRotaryShaft)
		{
			TileEntityRotaryShaft tileEntityRotaryShaft = (TileEntityRotaryShaft) tileEntity;

			GL11.glPushMatrix();

			// Scale, Translate, Rotate
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
			GL11.glRotatef(0F, 0F, 0F, 0F);
			GL11.glRotatef(0F, 1F, 0F, 0F);

			// Bind Texture
			this.bindTexture(Textures.Model.ROTARY_SHAFT);

			// Render
			if (!tileEntityRotaryShaft.onlyOneOpposite(tileEntityRotaryShaft.connectDirection)) modelRotaryShaft.render("GearBox");

			if (tileEntityRotaryShaft.connectDirection[0] == ForgeDirection.UP)
			{
				modelRotaryShaft.render("VerticalHalfTop");
			}
			if (tileEntityRotaryShaft.connectDirection[1] == ForgeDirection.DOWN)
			{
				modelRotaryShaft.render("VerticalHalfBottom");
			}
			if (tileEntityRotaryShaft.connectDirection[2] == ForgeDirection.NORTH)
			{
				modelRotaryShaft.render("HorizontalHalfFront");
			}
			if (tileEntityRotaryShaft.connectDirection[3] == ForgeDirection.SOUTH)
			{
				modelRotaryShaft.render("HorizontalHalfBack");
			}
			if (tileEntityRotaryShaft.connectDirection[4] == ForgeDirection.EAST)
			{
				modelRotaryShaft.render("HorizontalHalfRight");
			}
			if (tileEntityRotaryShaft.connectDirection[5] == ForgeDirection.WEST)
			{
				modelRotaryShaft.render("HorizontalHalfLeft");
			}

			GL11.glPopMatrix();
		}
	}

}
