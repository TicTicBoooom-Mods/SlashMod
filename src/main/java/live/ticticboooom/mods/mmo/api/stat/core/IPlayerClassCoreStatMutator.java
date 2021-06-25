package live.ticticboooom.mods.mmo.api.stat.core;

import live.ticticboooom.mods.mmo.api.race.origin.PlayerRacialOrigin;

public interface IPlayerClassCoreStatMutator {
    PlayerCoreStatValue mutate(PlayerCoreStatValue stat, PlayerRacialOrigin playerRace);
}
