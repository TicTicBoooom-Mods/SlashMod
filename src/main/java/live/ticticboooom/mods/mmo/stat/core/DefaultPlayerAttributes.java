package live.ticticboooom.mods.mmo.stat.core;

import live.ticticboooom.mods.mmo.api.cap.IPlayerAttributes;
import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import live.ticticboooom.mods.mmo.api.race.PlayerRace;
import live.ticticboooom.mods.mmo.api.race.origin.PlayerRacialOrigin;
import live.ticticboooom.mods.mmo.api.stat.core.IPlayerClassCoreStatMutator;
import live.ticticboooom.mods.mmo.api.stat.core.PlayerCoreStatValue;
import net.minecraft.util.ResourceLocation;

import java.util.*;

public class DefaultPlayerAttributes implements IPlayerAttributes {

    private Map<ResourceLocation, PlayerCoreStatValue> stats = new HashMap<>();
    private PlayerRacialOrigin origin;
    private PlayerClass playerClass;

    @Override
    public float getOverallLevel() {
        return 0;
    }

    @Override
    public PlayerCoreStatValue getCoreStat(ResourceLocation id) {
        return stats.get(id);
    }

    @Override
    public IPlayerAttributes putCoreStat(PlayerCoreStatValue stat) {
        stats.put(stat.getType().getRegistryName(), stat);
        return this;
    }

    @Override
    public void clearStats() {
        stats.clear();
    }

    @Override
    public List<PlayerCoreStatValue> getCoreStats() {
        List<PlayerCoreStatValue> result = new ArrayList<>();
        for (Map.Entry<ResourceLocation, PlayerCoreStatValue> entry : stats.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    @Override
    public IPlayerAttributes setPlayerOrigin(PlayerRacialOrigin origin) {
        this.origin = origin;
        if (playerClass != null && origin != null){
            this.apply();
        }
        return this;
    }

    @Override
    public IPlayerAttributes setPlayerClass(PlayerClass playerClass) {
        this.playerClass = playerClass;
        if (playerClass != null && origin != null){
            this.apply();
        }
        return this;
    }

    @Override
    public PlayerRacialOrigin getPlayerOrigin() {
        return origin;
    }

    @Override
    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    @Override
    public void apply() {
        if (playerClass == null || origin == null){
            return;
        }

        PlayerRace value = origin.getDominant();
        List<PlayerCoreStatValue> startingValues = value.getStartingValues();

        List<PlayerCoreStatValue> result = new ArrayList<>();
        for (Map.Entry<ResourceLocation, IPlayerClassCoreStatMutator> entry : playerClass.getMutators().entrySet()) {
            for (PlayerCoreStatValue startingValue : startingValues) {
                if (!startingValue.getType().getRegistryName().equals(entry.getKey())){
                    continue;
                }

                PlayerCoreStatValue mutated = entry.getValue().mutate(startingValue, origin);
                result.add(mutated);
            }
        }
        stats.clear();
        for (PlayerCoreStatValue val : result) {
            stats.put(val.getType().getRegistryName(), val);
        }
    }
}
