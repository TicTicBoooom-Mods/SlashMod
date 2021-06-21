package live.ticticboooom.mods.mmo.api.registry;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;

public abstract class BaseRegistryEntry<T extends BaseRegistryEntry<T>> implements IForgeRegistryEntry<T> {
    protected ResourceLocation id;

    @Override
    public T setRegistryName(ResourceLocation name) {
        id = name;
        return (T)this;
    }

    @Nullable
    @Override
    public ResourceLocation getRegistryName() {
        return id;
    }
}
