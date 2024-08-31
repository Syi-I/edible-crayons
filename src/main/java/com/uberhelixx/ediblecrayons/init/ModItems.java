package com.uberhelixx.ediblecrayons.init;

import com.uberhelixx.ediblecrayons.EdibleCrayons;
import com.uberhelixx.ediblecrayons.item.BaseCrayon;
import com.uberhelixx.ediblecrayons.item.ReusableItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EdibleCrayons.MOD_ID);
    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    
    public static final RegistryObject<Item> CRAYON_MOLD = ITEMS.register("crayon_mold", () -> new ReusableItem(new Item.Properties().tab(ModItemGroup.EDIBLE_CRAYONS).stacksTo(1)));
    
    public static final RegistryObject<Item> RED_CRAYON = crayonBuilder("red", Effects.DAMAGE_BOOST);
    public static final RegistryObject<Item> ORANGE_CRAYON = crayonBuilder("orange", Effects.FIRE_RESISTANCE);
    public static final RegistryObject<Item> YELLOW_CRAYON = crayonBuilder("yellow", Effects.ABSORPTION);
    public static final RegistryObject<Item> GREEN_CRAYON = crayonBuilder("green", Effects.NIGHT_VISION);
    public static final RegistryObject<Item> BLUE_CRAYON = crayonBuilder("blue", Effects.MOVEMENT_SPEED);
    public static final RegistryObject<Item> PURPLE_CRAYON = crayonBuilder("purple", Effects.WATER_BREATHING);
    public static final RegistryObject<Item> PINK_CRAYON = crayonBuilder("pink", Effects.REGENERATION);
    
    private static RegistryObject<Item> crayonBuilder(String colorIn, Effect effectIn) {
        String nameIn = colorIn + "_crayon";
        return ITEMS.register(nameIn, () -> new BaseCrayon(new Item.Properties().tab(ModItemGroup.EDIBLE_CRAYONS).food(new Food.Builder().nutrition(1).saturationMod(1).alwaysEat().build()), effectIn));
    }
}
