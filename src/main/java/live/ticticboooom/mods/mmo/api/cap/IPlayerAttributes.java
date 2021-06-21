package live.ticticboooom.mods.mmo.api.cap;

import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import live.ticticboooom.mods.mmo.api.race.origin.PlayerRacialOrigin;
import live.ticticboooom.mods.mmo.api.stat.PlayerCoreStatValue;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public interface IPlayerAttributes {
    float getOverallLevel();
    PlayerCoreStatValue getStat(ResourceLocation id);
    IPlayerAttributes putStat(PlayerCoreStatValue stat);
    List<PlayerCoreStatValue> getStats();
    IPlayerAttributes setPlayerOrigin(PlayerRacialOrigin origin);
    IPlayerAttributes setPlayerClass(PlayerClass playerClass);
    PlayerRacialOrigin getPlayerOrigin();
    PlayerClass getPlayerClass();
    void apply();
}
