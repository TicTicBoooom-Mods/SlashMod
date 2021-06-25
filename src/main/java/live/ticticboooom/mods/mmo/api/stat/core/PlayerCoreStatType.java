package live.ticticboooom.mods.mmo.api.stat.core;

import live.ticticboooom.mods.mmo.api.registry.BaseRegistryEntry;
import net.minecraft.util.text.ITextComponent;

public abstract class PlayerCoreStatType extends BaseRegistryEntry<PlayerCoreStatType> {

    public abstract ITextComponent getName();
    public abstract int getBaseValue();
    public abstract PlayerCoreStatValue create();

    @Override
    public Class<PlayerCoreStatType> getRegistryType() {
        return PlayerCoreStatType.class;
    }
}
