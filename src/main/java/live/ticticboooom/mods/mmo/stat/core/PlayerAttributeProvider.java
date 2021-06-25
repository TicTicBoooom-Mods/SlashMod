package live.ticticboooom.mods.mmo.stat.core;

import live.ticticboooom.mods.mmo.api.cap.Capabilities;
import live.ticticboooom.mods.mmo.api.cap.IPlayerAttributes;
import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import live.ticticboooom.mods.mmo.api.race.origin.PlayerRacialOrigin;
import live.ticticboooom.mods.mmo.api.registry.MMORegistries;
import live.ticticboooom.mods.mmo.api.stat.core.PlayerCoreStatType;
import live.ticticboooom.mods.mmo.api.stat.core.PlayerCoreStatValue;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PlayerAttributeProvider implements ICapabilitySerializable<CompoundNBT> {

    private LazyOptional<IPlayerAttributes> instance = LazyOptional.of(DefaultPlayerAttributes::new);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return instance.cast();
    }

    @Override
    public CompoundNBT serializeNBT() {
        Capability<IPlayerAttributes> cap = Capabilities.PLAYER_ATTRIBUTES_CAPABILITY;
        return (CompoundNBT) cap.getStorage().writeNBT(cap, instance.orElse(null), null);
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        Capability<IPlayerAttributes> cap = Capabilities.PLAYER_ATTRIBUTES_CAPABILITY;
        cap.getStorage().readNBT(cap, instance.orElse(null), null, nbt);
    }

}