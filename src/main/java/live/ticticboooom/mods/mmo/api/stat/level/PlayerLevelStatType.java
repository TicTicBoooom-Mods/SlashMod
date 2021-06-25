package live.ticticboooom.mods.mmo.api.stat.level;

import live.ticticboooom.mods.mmo.api.registry.BaseRegistryEntry;
import net.minecraft.util.text.ITextComponent;

public abstract class PlayerLevelStatType extends BaseRegistryEntry<PlayerLevelStatType> {
    @Override
    public Class<PlayerLevelStatType> getRegistryType() {
        return PlayerLevelStatType.class;
    }

    public abstract ITextComponent getName();
    public abstract PlayerLevelStatValue create();
    public abstract double getTotalLevelEffect();
}