package live.ticticboooom.mods.mmo.cap;

import live.ticticboooom.mods.mmo.api.cap.Capabilities;
import live.ticticboooom.mods.mmo.api.cap.IPlayerAttributes;
import live.ticticboooom.mods.mmo.api.cap.IPlayerLevel;
import live.ticticboooom.mods.mmo.stat.core.DefaultPlayerAttributes;
import live.ticticboooom.mods.mmo.stat.core.PlayerAttributeStorage;
import live.ticticboooom.mods.mmo.stat.level.DefaultPlayerLevel;
import live.ticticboooom.mods.mmo.stat.level.PlayerLevelStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ModCapabilityEventListener {
    @SubscribeEvent
    public void registerCapabilities(FMLCommonSetupEvent event) {
        CapabilityManager.INSTANCE.register(IPlayerAttributes.class, new PlayerAttributeStorage(), DefaultPlayerAttributes::new);
        CapabilityManager.INSTANCE.register(IPlayerLevel.class, new PlayerLevelStorage(), DefaultPlayerLevel::new);
    }


}
