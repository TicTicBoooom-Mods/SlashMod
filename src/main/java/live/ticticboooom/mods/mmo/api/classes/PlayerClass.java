package live.ticticboooom.mods.mmo.api.classes;

import live.ticticboooom.mods.mmo.api.registry.BaseRegistryEntry;
import live.ticticboooom.mods.mmo.api.registry.MMORegistries;
import live.ticticboooom.mods.mmo.api.stat.core.IPlayerClassCoreStatMutator;
import live.ticticboooom.mods.mmo.api.stat.core.PlayerCoreStatType;
import live.ticticboooom.mods.mmo.stat.core.classes.statmutators.NeutralStatMutator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import java.util.HashMap;
import java.util.Map;

public abstract class PlayerClass extends BaseRegistryEntry<PlayerClass> {

    public abstract ITextComponent getDescription();
    public abstract ITextComponent getName();
    public Map<ResourceLocation, IPlayerClassCoreStatMutator> getMutators() {
        Map<ResourceLocation, IPlayerClassCoreStatMutator> result = new HashMap<>();
        for (PlayerCoreStatType stat : MMORegistries.PLAYER_CORE_STAT) {
            result.put(stat.getRegistryName(), new NeutralStatMutator());
        }
        return result;
    }
    

    @Override
    public Class<PlayerClass> getRegistryType() {
        return PlayerClass.class;
    }
}
