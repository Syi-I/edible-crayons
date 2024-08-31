package com.uberhelixx.ediblecrayons.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ModItemGroup {
    public static final ItemGroup EDIBLE_CRAYONS = new ItemGroup("ediblecrayons") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.PURPLE_CRAYON.get());
        }
        @Override
        public void fillItemList(NonNullList<ItemStack> items)
        {
            super.fillItemList(items);
            items.sort(TabSort.tabSort);
        }
    };
}
