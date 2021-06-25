package live.ticticboooom.mods.mmo.stat.core.races;

import live.ticticboooom.mods.mmo.api.race.PlayerRace;
import live.ticticboooom.mods.mmo.api.stat.core.PlayerCoreStatValue;
import live.ticticboooom.mods.mmo.stat.core.stattype.DefaultAgilityCoreStatType;
import live.ticticboooom.mods.mmo.stat.core.stattype.DefaultConstitutionCoreStatType;
import live.ticticboooom.mods.mmo.stat.core.stattype.DefaultElementalResistanceCoreStatType;
import live.ticticboooom.mods.mmo.stat.core.stattype.DefaultFinesseCoreStatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import java.util.List;

public class HumanPlayerRace extends PlayerRace {
    @Override
    public ITextComponent getDescription() {
        return new StringTextComponent("Boring am i right");
    }

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
