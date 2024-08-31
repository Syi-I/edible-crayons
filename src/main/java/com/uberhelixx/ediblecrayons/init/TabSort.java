package com.uberhelixx.ediblecrayons.init;

import com.google.common.collect.Ordering;
import com.uberhelixx.ediblecrayons.EdibleCrayons;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
@Mod.EventBusSubscriber(modid = EdibleCrayons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class TabSort {
    public static Comparator<ItemStack> tabSort;
    
    @SubscribeEvent
    public static void tabSort(final FMLCommonSetupEvent event) {
        //list of all items for sorting creative inventory tab
        List<Item> itemOrder = Arrays.asList(
                ModItems.CRAYON_MOLD.get(),
                ModItems.RED_CRAYON.get(),
                ModItems.ORANGE_CRAYON.get(),
                ModItems.YELLOW_CRAYON.get(),
                ModItems.GREEN_CRAYON.get(),
                ModItems.BLUE_CRAYON.get(),
                ModItems.PURPLE_CRAYON.get(),
                ModItems.PINK_CRAYON.get()
        );
        tabSort = Ordering.explicit(itemOrder).onResultOf(ItemStack::getItem);
    }
}
