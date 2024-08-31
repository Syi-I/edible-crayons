package com.uberhelixx.ediblecrayons.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BaseCrayon extends Item {
    public BaseCrayon(Properties properties, Effect effectIn) {
        super(properties);
        thisEffect = effectIn;
    }
    
    //the effect that eating this crayon gives
    Effect thisEffect;
    
    
    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, World world, LivingEntity livingEntity) {
        livingEntity.addEffect(new EffectInstance(thisEffect, 600));
        return super.finishUsingItem(itemStack, world, livingEntity);
    }
    
    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        String effectName = TextFormatting.GOLD + thisEffect.getDisplayName().getString();
        tooltip.add(new TranslationTextComponent("tooltip.ediblecrayons.desc").withStyle(TextFormatting.GRAY).append(effectName));
        super.appendHoverText(stack, world, tooltip, flagIn);
    }
    
}
