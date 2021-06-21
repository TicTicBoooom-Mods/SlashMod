package live.ticticboooom.mods.mmo.api.stat;

import live.ticticboooom.mods.mmo.api.race.PlayerRace;
import live.ticticboooom.mods.mmo.api.race.origin.PlayerRacialOrigin;

public interface IPlayerClassCoreStatMutator {
    PlayerCoreStatValue mutate(PlayerCoreStatValue stat, PlayerRacialOrigin playerRace);
}
