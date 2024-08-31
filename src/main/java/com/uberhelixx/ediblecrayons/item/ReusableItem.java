package com.uberhelixx.ediblecrayons.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ReusableItem extends Item {
    
    public ReusableItem(Properties properties) {
        super(properties);
    }
    
    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return itemStack.copy();
    }
    
    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
}
