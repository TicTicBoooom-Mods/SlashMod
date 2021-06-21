package live.ticticboooom.mods.mmo.cap;

import live.ticticboooom.mods.mmo.ModIds;
import live.ticticboooom.mods.mmo.playerdata.PlayerAttributeProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CapabilityEventListener {
    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (!(event.getObject() instanceof PlayerEntity))  return;

        event.addCapability(ModIds.PLAYER_PROGRESS_CAPABILITY_ID, new PlayerAttributeProvider());
    }
}
