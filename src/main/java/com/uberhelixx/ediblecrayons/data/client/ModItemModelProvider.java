package com.uberhelixx.ediblecrayons.data.client;

import com.uberhelixx.ediblecrayons.EdibleCrayons;
import com.uberhelixx.ediblecrayons.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, EdibleCrayons.MOD_ID, existingFileHelper);
    }
    
    @Override
    protected void registerModels() {
        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        EdibleCrayons.LOGGER.info("[ModItemModelProvider] Generating generic item models...");
        generateRegularItems(itemGenerated);
    }
    
    private void builder(ModelFile itemGenerated, String name) {
        getBuilder(name).parent(itemGenerated).texture("layer0", name);
    }
    
    //generates item models for regular items (no tools, no items with custom models)
    private void generateRegularItems(ModelFile itemGenerated) {
        for (RegistryObject<Item> entry : ModItems.ITEMS.getEntries()) {
            String itemName = entry.getId().toString();
            String trimmedName = itemName.replace(EdibleCrayons.MOD_ID + ":", "");
            EdibleCrayons.LOGGER.info("Generated " + trimmedName);
            builder(itemGenerated, "item/" + trimmedName);
        }
    }
}
