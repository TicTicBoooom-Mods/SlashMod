package live.ticticboooom.mods.mmo.listener.stat.level;

import live.ticticboooom.mods.mmo.api.cap.IPlayerLevel;
import live.ticticboooom.mods.mmo.api.stat.level.PlayerLevelStatValue;
import live.ticticboooom.mods.mmo.api.cap.Capabilities;
import live.ticticboooom.mods.mmo.stat.level.stattype.HuntingLevelStatType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class HuntingLevelStatListener {
    @SubscribeEvent
    public void onEntityDeath(LivingDeathEvent event) {
        Entity trueSource = event.getSource().getTrueSource();
        if (trueSource instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) trueSource;
            LazyOptional<IPlayerLevel> capability = player.getCapability(Capabilities.PLAYER_LEVEL_CAPABILITY);
            if (!capability.isPresent()) {
                return;
            }

            IPlayerLevel level = capability.orElse(null);
            List<PlayerLevelStatValue> levelStats = level.getLevelStats();
            for (PlayerLevelStatValue levelStat : levelStats) {
                if (levelStat.getType() instanceof HuntingLevelStatType) {
                    levelStat.setValue(levelStat.getValue() + (event.getEntityLiving().getMaxHealth() / (100 - level.getTotalLevel())));
                }
            }
        }
    }
}
