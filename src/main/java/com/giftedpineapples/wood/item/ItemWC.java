package com.giftedpineapples.wood.item;

import com.giftedpineapples.wood.creativetab.CreativeTabWC;
import com.giftedpineapples.wood.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemWC extends Item {

	public ItemWC()
	{
		super();
		this.setNoRepair();
		this.setCreativeTab(CreativeTabWC.WC_TAB);
	}

	@Override
	public String getUnlocalizedName()
	{
		return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon(this.getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

}
