package live.ticticboooom.mods.mmo.cap;

import live.ticticboooom.mods.mmo.ModIds;
import live.ticticboooom.mods.mmo.api.cap.Capabilities;
import live.ticticboooom.mods.mmo.api.cap.IPlayerAttributes;
import live.ticticboooom.mods.mmo.api.cap.IPlayerLevel;
import live.ticticboooom.mods.mmo.api.stat.core.PlayerCoreStatValue;
import live.ticticboooom.mods.mmo.stat.core.DefaultPlayerAttributes;
import live.ticticboooom.mods.mmo.stat.core.PlayerAttributeProvider;
import live.ticticboooom.mods.mmo.stat.core.PlayerAttributeStorage;
import live.ticticboooom.mods.mmo.stat.level.DefaultPlayerLevel;
import live.ticticboooom.mods.mmo.stat.level.PlayerLevelProvider;
import live.ticticboooom.mods.mmo.stat.level.PlayerLevelStorage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.List;

public class CapabilityEventListener {
    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (!(event.getObject() instanceof PlayerEntity)) return;

        event.addCapability(ModIds.PLAYER_CAPABILITY_ID, new PlayerCapabilityProvider());
    }

    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        if (!event.isWasDeath()) {
            return;
        }

        {
            LazyOptional<IPlayerLevel> capability = event.getOriginal().getCapability(Capabilities.PLAYER_LEVEL_CAPABILITY);
            LazyOptional<IPlayerLevel> result = event.getEntityLiving().getCapability(Capabilities.PLAYER_LEVEL_CAPABILITY);
            IPlayerLevel level = result.orElse(null);
            level.setLevelStats(capability.orElse(null).getLevelStats());
        }

        {
            IPlayerAttributes iPlayerAttributes = event.getOriginal().getCapability(Capabilities.PLAYER_ATTRIBUTES_CAPABILITY).orElse(null);
            IPlayerAttributes result = event.getEntityLiving().getCapability(Capabilities.PLAYER_ATTRIBUTES_CAPABILITY).orElse(null);
            result.setPlayerOrigin(iPlayerAttributes.getPlayerOrigin());
            result.setPlayerClass(iPlayerAttributes.getPlayerClass());
            result.clearStats();
            List<PlayerCoreStatValue> coreStats = iPlayerAttributes.getCoreStats();
            for (PlayerCoreStatValue coreStat : coreStats) {
                result.putCoreStat(coreStat);
            }
        }
    }
}
