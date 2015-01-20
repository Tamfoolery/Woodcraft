package com.giftedpineapples.wood.creativetab;

import com.giftedpineapples.wood.init.ModItems;
import com.giftedpineapples.wood.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabWC {

	public static final CreativeTabs WC_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.woodenGear;
		}
	};

}
