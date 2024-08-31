package com.uberhelixx.ediblecrayons.event;

import com.uberhelixx.ediblecrayons.EdibleCrayons;
import com.uberhelixx.ediblecrayons.init.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = EdibleCrayons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    
    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity playerIn = event.getPlayer();
        if(uuidCheck(playerIn.getUUID())) {
            ItemStack bonusCrayon = new ItemStack(ModItems.PURPLE_CRAYON.get());
            bonusCrayon.setHoverName(ITextComponent.nullToEmpty("To the local crayon sniffer <3"));
            playerIn.inventory.add(bonusCrayon);
        }
    }
    
    private static boolean uuidCheck(UUID targetUuid) {
        //380df991-f603-344c-a090-369bad2a924a is dev1 uuid
        if (0 == targetUuid.compareTo(UUID.fromString("380df991-f603-344c-a090-369bad2a924a"))) {
            return true;
        }
        //fabd0a49-3695-401c-9990-d95464632a6a is mach uuid
        if (0 == targetUuid.compareTo(UUID.fromString("00bca921-e648-413d-8ec7-b370e422db60"))) {
            return true;
        }
        
        return false;
    }
    
}
