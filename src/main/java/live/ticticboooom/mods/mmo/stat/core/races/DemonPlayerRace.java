package live.ticticboooom.mods.mmo.stat.core.races;

import live.ticticboooom.mods.mmo.api.race.PlayerRace;
import live.ticticboooom.mods.mmo.api.stat.core.PlayerCoreStatValue;
import live.ticticboooom.mods.mmo.stat.core.stattype.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import java.util.List;

public class DemonPlayerRace extends PlayerRace {
    @Override
    public ITextComponent getDescription() {
        return new StringTextComponent("ScaRY BOI");
    }

    @Override
    public ITextComponent getName() {
        return new StringTextComponent("Demon");
    }


    @Override
    public List<PlayerCoreStatValue> getStartingValues() {
        List<PlayerCoreStatValue> startingValues = super.getStartingValues();
        for (PlayerCoreStatValue startingValue : startingValues) {
            if (startingValue.getType() instanceof DefaultWillPowerCoreStatType) {
                startingValue.setValue(startingValue.getValue() + 1);
            }
            if (startingValue.getType() instanceof DefaultWillPowerCoreStatType) {
                startingValue.setValue(startingValue.getValue() + 1);
            }
            if (startingValue.getType() instanceof DefaultElementalResistanceCoreStatType) {
                startingValue.setValue(startingValue.getValue() - 1);
            }
            if (startingValue.getType() instanceof DefaultEnduranceCoreStatType) {
                startingValue.setValue(startingValue.getValue() - 1);
            }
        }
        return startingValues;
    }
}
