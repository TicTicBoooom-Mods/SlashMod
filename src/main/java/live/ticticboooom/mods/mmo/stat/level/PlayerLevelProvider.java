package live.ticticboooom.mods.mmo.stat.level;

import live.ticticboooom.mods.mmo.api.cap.Capabilities;
import live.ticticboooom.mods.mmo.api.cap.IPlayerLevel;
import live.ticticboooom.mods.mmo.api.stat.level.PlayerLevelStatType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PlayerLevelProvider implements ICapabilitySerializable<CompoundNBT> {
    private DefaultPlayerLevel  instance = new DefaultPlayerLevel();
    public LazyOptional<DefaultPlayerLevel> instanceLO = LazyOptional.of(() -> instance);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return instanceLO.cast();
    }

    @Override
    public CompoundNBT serializeNBT() {
        Capability<IPlayerLevel> cap = Capabilities.PLAYER_LEVEL_CAPABILITY;
        return (CompoundNBT) cap.getStorage().writeNBT(cap, instanceLO.orElse(null), null);
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        Capability<IPlayerLevel> cap = Capabilities.PLAYER_LEVEL_CAPABILITY;
        cap.getStorage().readNBT(cap, instanceLO.orElse(null), null, nbt);
    }
}
