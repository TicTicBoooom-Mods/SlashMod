package live.ticticboooom.mods.mmo.cap;

import live.ticticboooom.mods.mmo.api.cap.Capabilities;
import live.ticticboooom.mods.mmo.stat.core.PlayerAttributeProvider;
import live.ticticboooom.mods.mmo.stat.level.PlayerLevelProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class PlayerCapabilityProvider implements ICapabilitySerializable<CompoundNBT> {
    private final Map<Capability<?>, ICapabilitySerializable<CompoundNBT>> providers = new HashMap<>();

    public PlayerCapabilityProvider() {
        providers.put(Capabilities.PLAYER_LEVEL_CAPABILITY, new PlayerLevelProvider());
        providers.put(Capabilities.PLAYER_ATTRIBUTES_CAPABILITY, new PlayerAttributeProvider());
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (providers.containsKey(cap)) {
            return providers.get(cap).getCapability(cap);
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT result = new CompoundNBT();
        for (Map.Entry<Capability<?>, ICapabilitySerializable<CompoundNBT>> entry : providers.entrySet()) {
            CompoundNBT compoundNBT = entry.getValue().serializeNBT();
            result.put(entry.getKey().getName(), compoundNBT);
        }
        return result;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        for (Map.Entry<Capability<?>, ICapabilitySerializable<CompoundNBT>> entry : providers.entrySet()) {
            CompoundNBT compound = nbt.getCompound(entry.getKey().getName());
            entry.getValue().deserializeNBT(compound);
        }
    }
}
