package live.ticticboooom.mods.mmo.playerdata.classes.statmutators;

import live.ticticboooom.mods.mmo.api.race.origin.PlayerRacialOrigin;
import live.ticticboooom.mods.mmo.api.stat.IPlayerClassCoreStatMutator;
import live.ticticboooom.mods.mmo.api.stat.PlayerCoreStatValue;

public class NeutralStatMutator implements IPlayerClassCoreStatMutator {
    @Override
    public PlayerCoreStatValue mutate(PlayerCoreStatValue stat, PlayerRacialOrigin playerRace) {
        return stat;
    }
}
