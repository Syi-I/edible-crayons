package com.uberhelixx.ediblecrayons.data;

import com.uberhelixx.ediblecrayons.EdibleCrayons;
import com.uberhelixx.ediblecrayons.data.client.ModItemModelProvider;
import com.uberhelixx.ediblecrayons.data.server.ModRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = EdibleCrayons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        
        generator.addProvider(new ModItemModelProvider(generator, existingFileHelper));
        
        EdibleCrayons.LOGGER.info("Generating recipes...");
        generator.addProvider(new ModRecipeProvider(generator));
        EdibleCrayons.LOGGER.info("Finished generating recipes.");
    }
}
