package live.ticticboooom.mods.mmo.stat.core;

import live.ticticboooom.mods.mmo.api.cap.IPlayerAttributes;
import live.ticticboooom.mods.mmo.api.cap.IPlayerLevel;
import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import live.ticticboooom.mods.mmo.api.race.origin.PlayerRacialOrigin;
import live.ticticboooom.mods.mmo.api.registry.MMORegistries;
import live.ticticboooom.mods.mmo.api.stat.core.PlayerCoreStatType;
import live.ticticboooom.mods.mmo.api.stat.core.PlayerCoreStatValue;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nullable;

public class PlayerAttributeStorage implements Capability.IStorage<IPlayerAttributes> {
    @Nullable
    @Override
    public INBT writeNBT(Capability<IPlayerAttributes> capability, IPlayerAttributes instance, Direction side) {
        CompoundNBT compound = new CompoundNBT();
        if (instance.getPlayerClass() == null || instance.getPlayerOrigin() == null || instance.getCoreStats().size() == 0) {
            return new CompoundNBT();
        }
        compound.putString("class", instance.getPlayerClass().getRegistryName().toString());
        CompoundNBT originNBT = new CompoundNBT();
        originNBT.putString("dominant", instance.getPlayerOrigin().getDominant().getRegistryName().toString());
        originNBT.putString("subDominant", instance.getPlayerOrigin().getSubDominant().getRegistryName().toString());
        originNBT.putString("recessive", instance.getPlayerOrigin().getRecessive().getRegistryName().toString());
        compound.put("origin", originNBT);
        compound.putInt("countStat", instance.getCoreStats().size());
        int counter = 0;
        CompoundNBT statsNBT = new CompoundNBT();
        for (PlayerCoreStatValue stat : instance.getCoreStats()) {
            CompoundNBT inner = new CompoundNBT();
            inner.putInt("value", stat.getValue());
            inner.putString("registryName", stat.getType().getRegistryName().toString());
            statsNBT.put(Integer.toString(counter), inner);
            counter++;
        }
        compound.put("stats", statsNBT);
        return compound;
    }

    @Override
    public void readNBT(Capability<IPlayerAttributes> capability, IPlayerAttributes instance, Direction side, INBT inbt) {
        CompoundNBT nbt = ((CompoundNBT) inbt);
        if (!nbt.contains("countOrigin")) {
            return;
        }
        PlayerRacialOrigin origin = new PlayerRacialOrigin();
        CompoundNBT originNBT = nbt.getCompound("origin");
        origin.setDominant(MMORegistries.PLAYER_RACE.getValue(ResourceLocation.tryCreate(originNBT.getString("dominant"))));
        origin.setSubDominant(MMORegistries.PLAYER_RACE.getValue(ResourceLocation.tryCreate(originNBT.getString("subDominant"))));
        origin.setRecessive(MMORegistries.PLAYER_RACE.getValue(ResourceLocation.tryCreate(originNBT.getString("recessive"))));
        PlayerClass playerClass = MMORegistries.PLAYER_CLASS.getValue(ResourceLocation.tryCreate(nbt.getString("class")));
        int countStat = nbt.getInt("countStat");
        instance.clearStats();
        CompoundNBT statsNBT = nbt.getCompound("stats");
        for (int i = 0; i < countStat; i++) {
            CompoundNBT compound = statsNBT.getCompound(Integer.toString(i));
            int value = compound.getInt("value");
            ResourceLocation registryName = ResourceLocation.tryCreate(compound.getString("registryName"));
            PlayerCoreStatType stat = MMORegistries.PLAYER_CORE_STAT.getValue(registryName);
            PlayerCoreStatValue statValue = stat.create();
            statValue.setValue(value);
            instance.putCoreStat(statValue);
        }

        instance.setPlayerClass(playerClass);
        instance.setPlayerOrigin(origin);
    }
}
