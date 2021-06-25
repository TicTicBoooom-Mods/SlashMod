package live.ticticboooom.mods.mmo.api.cap;

import live.ticticboooom.mods.mmo.api.stat.level.PlayerLevelStatValue;

import java.util.List;

public interface IPlayerLevel {
    double getTotalLevel();
    List<PlayerLevelStatValue> getLevelStats();
    void setLevelStats(List<PlayerLevelStatValue> stats);
}
