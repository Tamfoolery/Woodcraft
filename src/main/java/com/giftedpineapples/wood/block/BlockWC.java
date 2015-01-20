package com.giftedpineapples.wood.block;

import com.giftedpineapples.wood.creativetab.CreativeTabWC;
import com.giftedpineapples.wood.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockWC extends Block {

	public BlockWC(Material material)
	{
		super(material);
		this.blockHardness = 2.0f;
		this.setCreativeTab(CreativeTabWC.WC_TAB);
	}

	public BlockWC()
	{
		this(Material.wood);
	}

	@Override
	public String getUnlocalizedName()
	{
		return String.format("tile.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

}
