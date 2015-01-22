package com.giftedpineapples.wood.client.renderer.tileentity;

import com.giftedpineapples.wood.client.renderer.model.ModelMechanicalRoot;
import com.giftedpineapples.wood.reference.Textures;
import com.giftedpineapples.wood.tileentity.TileEntityMechanicalRoot;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityRendererMechanicalRoot extends TileEntitySpecialRenderer {

	private final ModelMechanicalRoot modelMechanicalRoot = new ModelMechanicalRoot();

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
	{
		if (tileEntity instanceof TileEntityMechanicalRoot)
		{
			TileEntityMechanicalRoot tileEntityMechanicalRoot = (TileEntityMechanicalRoot) tileEntity;

			ForgeDirection orientation = tileEntityMechanicalRoot.getOrientation();
			Float rotation = 0F;

			if (orientation == ForgeDirection.NORTH)
			{
				rotation = 180F;
			}
			else if (orientation == ForgeDirection.EAST)
			{
				rotation = 90F;
			}
			else if (orientation == ForgeDirection.SOUTH)
			{
				rotation = 0F;
			}
			else if (orientation == ForgeDirection.WEST)
			{
				rotation = -90F;
			}

			GL11.glPushMatrix();

			// Scale, Translate, Rotate
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
			GL11.glRotatef(rotation, 0F, 0F, 0F);
			GL11.glRotatef(0F, 1F, 0F, 0F);

			// Bind Texture
			this.bindTexture(Textures.Model.MECHANICAL_ROOT);

			// Render
			modelMechanicalRoot.render();

			GL11.glPopMatrix();
		}
	}

}
