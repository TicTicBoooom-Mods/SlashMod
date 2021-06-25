package live.ticticboooom.mods.mmo.stat.core.classes.statmutators;

import live.ticticboooom.mods.mmo.api.race.origin.PlayerRacialOrigin;
import live.ticticboooom.mods.mmo.api.stat.core.IPlayerClassCoreStatMutator;
import live.ticticboooom.mods.mmo.api.stat.core.PlayerCoreStatValue;

public class NeutralStatMutator implements IPlayerClassCoreStatMutator {
    @Override
    public PlayerCoreStatValue mutate(PlayerCoreStatValue stat, PlayerRacialOrigin playerRace) {
        return stat;
    }
}
