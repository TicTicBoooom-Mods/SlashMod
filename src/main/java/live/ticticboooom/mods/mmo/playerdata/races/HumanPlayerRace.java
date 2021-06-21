package live.ticticboooom.mods.mmo.playerdata.races;

import com.google.common.collect.Lists;
import live.ticticboooom.mods.mmo.api.race.PlayerRace;
import live.ticticboooom.mods.mmo.api.registry.MMORegistries;
import live.ticticboooom.mods.mmo.api.stat.PlayerCoreStatType;
import live.ticticboooom.mods.mmo.api.stat.PlayerCoreStatValue;
import live.ticticboooom.mods.mmo.playerdata.stattype.DefaultAgilityCoreStatType;
import live.ticticboooom.mods.mmo.playerdata.stattype.DefaultConstitutionCoreStatType;
import live.ticticboooom.mods.mmo.playerdata.stattype.DefaultElementalResistanceCoreStatType;
import live.ticticboooom.mods.mmo.playerdata.stattype.DefaultFinesseCoreStatType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HumanPlayerRace extends PlayerRace {
    @Override
    public ITextComponent getName() {
        return new StringTextComponent("Human");
    }

    @Override
    public List<PlayerCoreStatValue> getStartingValues() {
        List<PlayerCoreStatValue> startingValues = super.getStartingValues();
        for (PlayerCoreStatValue startingValue : startingValues) {
            if (startingValue.getType() instanceof DefaultConstitutionCoreStatType) {
                startingValue.setValue(startingValue.getValue() - 1);
            }
            if (startingValue.getType() instanceof DefaultElementalResistanceCoreStatType) {
                startingValue.setValue(startingValue.getValue() - 1);
            }
            if (startingValue.getType() instanceof DefaultFinesseCoreStatType) {
                startingValue.setValue(startingValue.getValue() + 1);
            }
            if (startingValue.getType() instanceof DefaultAgilityCoreStatType) {
                startingValue.setValue(startingValue.getValue() + 1);
            }
        }
        return startingValues;
    }
}
