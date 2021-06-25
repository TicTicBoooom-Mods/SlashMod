package live.ticticboooom.mods.mmo.api.race;

import live.ticticboooom.mods.mmo.api.registry.BaseRegistryEntry;
import live.ticticboooom.mods.mmo.api.registry.MMORegistries;
import live.ticticboooom.mods.mmo.api.stat.core.PlayerCoreStatType;
import live.ticticboooom.mods.mmo.api.stat.core.PlayerCoreStatValue;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.text.ITextComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class PlayerRace extends BaseRegistryEntry<PlayerRace> {

    public abstract ITextComponent getDescription();
    public abstract ITextComponent getName();
    public List<PlayerCoreStatValue> getStartingValues() {
        List<PlayerCoreStatValue> result = new ArrayList<>();
        for (Map.Entry<RegistryKey<PlayerCoreStatType>, PlayerCoreStatType> entry : MMORegistries.PLAYER_CORE_STAT.getEntries()) {
            result.add(entry.getValue().create());
        }
        return result;
    }

    @Override
    public Class<PlayerRace> getRegistryType() {
        return PlayerRace.class;
    }
}
