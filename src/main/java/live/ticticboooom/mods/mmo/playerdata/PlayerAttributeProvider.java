package live.ticticboooom.mods.mmo.playerdata;

import live.ticticboooom.mods.mmo.api.cap.IPlayerAttributes;
import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import live.ticticboooom.mods.mmo.api.race.origin.PlayerRacialOrigin;
import live.ticticboooom.mods.mmo.api.registry.MMORegistries;
import live.ticticboooom.mods.mmo.api.stat.PlayerCoreStatType;
import live.ticticboooom.mods.mmo.api.stat.PlayerCoreStatValue;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

public class PlayerAttributeProvider implements ICapabilitySerializable<CompoundNBT> {

    private LazyOptional<IPlayerAttributes> instance = LazyOptional.of(DefaultPlayerAttributes::new);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return instance.cast();
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compound = new CompoundNBT();
        IPlayerAttributes progress = instance.orElse(null);
        if (progress.getPlayerClass() == null || progress.getPlayerOrigin() == null || progress.getStats().size() == 0){
            return new CompoundNBT();
        }
        compound.putString("class", progress.getPlayerClass().getRegistryName().toString());
        CompoundNBT originNBT = new CompoundNBT();
        originNBT.putString("dominant", progress.getPlayerOrigin().getDominant().getRegistryName().toString());
        originNBT.putString("subDominant", progress.getPlayerOrigin().getSubDominant().getRegistryName().toString());
        originNBT.putString("recessive", progress.getPlayerOrigin().getRecessive().getRegistryName().toString());
        compound.put("origin", originNBT);
        compound.putInt("countStat", progress.getStats().size());
        int counter = 0;
        CompoundNBT statsNBT = new CompoundNBT();
        for (PlayerCoreStatValue stat : progress.getStats()) {
            CompoundNBT inner = new CompoundNBT();
            inner.putInt("value", stat.getValue());
            inner.putString("registryName", stat.getType().getRegistryName().toString());
            statsNBT.put(Integer.toString(counter), inner);
            counter ++;
        }
        compound.put("stats", statsNBT);
        return compound;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        if (!nbt.contains("countOrigin")){
            return;
        }
        int count = nbt.getInt("countOrigin");
        DefaultPlayerAttributes defaultPlayerProgress = new DefaultPlayerAttributes();
        PlayerRacialOrigin origin = new PlayerRacialOrigin();
        CompoundNBT originNBT = nbt.getCompound("origin");
        origin.setDominant(MMORegistries.PLAYER_RACE.getValue(ResourceLocation.tryCreate(originNBT.getString("dominant"))));
        origin.setSubDominant(MMORegistries.PLAYER_RACE.getValue(ResourceLocation.tryCreate(originNBT.getString("subDominant"))));
        origin.setRecessive(MMORegistries.PLAYER_RACE.getValue(ResourceLocation.tryCreate(originNBT.getString("recessive"))));
        defaultPlayerProgress.setPlayerOrigin(origin);
        PlayerClass playerClass = MMORegistries.PLAYER_CLASS.getValue(ResourceLocation.tryCreate(nbt.getString("class")));
        defaultPlayerProgress.setPlayerClass(playerClass);
        int countStat = nbt.getInt("countStat");
        CompoundNBT statsNBT = nbt.getCompound("stats");
        for (int i = 0; i < countStat; i++) {
            CompoundNBT compound = statsNBT.getCompound(Integer.toString(i));
            int value = compound.getInt("value");
            ResourceLocation registryName = ResourceLocation.tryCreate(compound.getString("registryName"));
            PlayerCoreStatType stat = MMORegistries.PLAYER_CORE_STAT.getValue(registryName);
            PlayerCoreStatValue statValue = stat.create();
            statValue.setValue(value);
            defaultPlayerProgress.putStat(statValue);
        }

        instance = LazyOptional.of(() -> defaultPlayerProgress);
    }

}