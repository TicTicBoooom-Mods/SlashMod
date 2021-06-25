package live.ticticboooom.mods.mmo.stat.level;

import live.ticticboooom.mods.mmo.api.cap.IPlayerLevel;
import live.ticticboooom.mods.mmo.api.registry.MMORegistries;
import live.ticticboooom.mods.mmo.api.stat.level.PlayerLevelStatType;
import live.ticticboooom.mods.mmo.api.stat.level.PlayerLevelStatValue;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class PlayerLevelStorage implements Capability.IStorage<IPlayerLevel> {
    @Nullable
    @Override
    public INBT writeNBT(Capability<IPlayerLevel> capability, IPlayerLevel instance, Direction side) {
        CompoundNBT result = new CompoundNBT();
        CompoundNBT stats = new CompoundNBT();
        int counter = 0;
        for (PlayerLevelStatValue stat : instance.getLevelStats()) {
            CompoundNBT statNBT = new CompoundNBT();
            statNBT.putDouble("value", stat.getValue());
            statNBT.putString("registryName", stat.getType().getRegistryName().toString());
            stats.put(Integer.toString(counter), statNBT);
            counter ++;
        }
        stats.putInt("count", counter);
        result.put("stats", stats);
        return result;
    }

    @Override
    public void readNBT(Capability<IPlayerLevel> capability, IPlayerLevel instance, Direction side, INBT inbt) {
        CompoundNBT nbt = (CompoundNBT) inbt;
        CompoundNBT statsNBT = nbt.getCompound("stats");
        int count = statsNBT.getInt("count");
        ArrayList<PlayerLevelStatValue> stats = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            CompoundNBT compound = statsNBT.getCompound(Integer.toString(i));
            double value = compound.getDouble("value");
            String registryName = compound.getString("registryName");
            PlayerLevelStatType value1 = MMORegistries.PLAYER_LEVEL_STAT.getValue(ResourceLocation.tryCreate(registryName));
            PlayerLevelStatValue playerLevelStatValue = value1.create();
            playerLevelStatValue.setValue(value);
            stats.add(playerLevelStatValue);
        }
        if (stats.isEmpty()){
            for (PlayerLevelStatType entry : MMORegistries.PLAYER_LEVEL_STAT) {
                stats.add(entry.create());
            }
        }
        instance.setLevelStats(stats);
    }
}
