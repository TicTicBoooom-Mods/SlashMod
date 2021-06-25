package live.ticticboooom.mods.mmo.stat.level;

import live.ticticboooom.mods.mmo.api.cap.IPlayerLevel;
import live.ticticboooom.mods.mmo.api.registry.MMORegistries;
import live.ticticboooom.mods.mmo.api.stat.level.PlayerLevelStatType;
import live.ticticboooom.mods.mmo.api.stat.level.PlayerLevelStatValue;
import net.minecraft.util.RegistryKey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefaultPlayerLevel implements IPlayerLevel {

    private List<PlayerLevelStatValue> stats = new ArrayList<>();

    public DefaultPlayerLevel() {
        for (Map.Entry<RegistryKey<PlayerLevelStatType>, PlayerLevelStatType> entry : MMORegistries.PLAYER_LEVEL_STAT.getEntries()) {
            this.stats.add(entry.getValue().create());
        }
    }

    @Override
    public double getTotalLevel() {
        double result = 0;
        for (PlayerLevelStatValue stat : stats) {
            result += stat.getTotalLevelPart();
        }
        return result;
    }

    @Override
    public List<PlayerLevelStatValue> getLevelStats() {
        return stats;
    }

    @Override
    public void setLevelStats(List<PlayerLevelStatValue> stats) {
        this.stats = stats;
    }
}
