package com.uberhelixx.ediblecrayons.data.server;

import com.uberhelixx.ediblecrayons.EdibleCrayons;
import com.uberhelixx.ediblecrayons.init.ModItems;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }
    
    static Map<Item, Tags.IOptionalNamedTag<Item>> crayonToDyes = new HashMap<>();
    
    private static void crayonDyePairs() {
        crayonToDyes.put(ModItems.RED_CRAYON.get(), Tags.Items.DYES_RED);
        crayonToDyes.put(ModItems.ORANGE_CRAYON.get(), Tags.Items.DYES_ORANGE);
        crayonToDyes.put(ModItems.YELLOW_CRAYON.get(), Tags.Items.DYES_YELLOW);
        crayonToDyes.put(ModItems.GREEN_CRAYON.get(), Tags.Items.DYES_GREEN);
        crayonToDyes.put(ModItems.BLUE_CRAYON.get(), Tags.Items.DYES_BLUE);
        crayonToDyes.put(ModItems.PURPLE_CRAYON.get(), Tags.Items.DYES_PURPLE);
        crayonToDyes.put(ModItems.PINK_CRAYON.get(), Tags.Items.DYES_PINK);
    }
    
    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        //set up crayon colors with associated dye colors
        crayonDyePairs();
        
        //set up recipes for each of the crayon colors
        for(Map.Entry<Item, Tags.IOptionalNamedTag<Item>> entry : crayonToDyes.entrySet()) {
            Item recipeItem = entry.getKey();
            ShapelessRecipeBuilder.shapeless(recipeItem)
                    .requires(Ingredient.of(entry.getValue()))
                    .requires(Items.CLAY_BALL)
                    .requires(ModItems.CRAYON_MOLD.get())
                    .unlockedBy("has_item", has(entry.getValue()))
                    .save(consumer);
        }
        
        //recipe for crayon mold item
        ShapedRecipeBuilder.shaped(ModItems.CRAYON_MOLD.get())
                .define('n', Tags.Items.NUGGETS_IRON)
                .define('s', Items.STICK)
                .pattern("nnn")
                .pattern("nsn")
                .pattern("nnn")
                .unlockedBy("has_item", has(Tags.Items.NUGGETS_IRON))
                .save(consumer);
    }
    
    private static ResourceLocation modId(String path) {
        return new ResourceLocation(EdibleCrayons.MOD_ID, path);
    }
}
