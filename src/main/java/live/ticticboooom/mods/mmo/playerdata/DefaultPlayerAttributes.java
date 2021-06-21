package live.ticticboooom.mods.mmo.playerdata;

import live.ticticboooom.mods.mmo.api.cap.IPlayerAttributes;
import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import live.ticticboooom.mods.mmo.api.race.PlayerRace;
import live.ticticboooom.mods.mmo.api.race.origin.PlayerRacialOrigin;
import live.ticticboooom.mods.mmo.api.registry.MMORegistries;
import live.ticticboooom.mods.mmo.api.stat.IPlayerClassCoreStatMutator;
import live.ticticboooom.mods.mmo.api.stat.PlayerCoreStatType;
import live.ticticboooom.mods.mmo.api.stat.PlayerCoreStatValue;
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
    public PlayerCoreStatValue getStat(ResourceLocation id) {
        return stats.get(id);
    }

    @Override
    public IPlayerAttributes putStat(PlayerCoreStatValue stat) {
        stats.put(stat.getType().getRegistryName(), stat);
        return this;
    }

    @Override
    public List<PlayerCoreStatValue> getStats() {
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
