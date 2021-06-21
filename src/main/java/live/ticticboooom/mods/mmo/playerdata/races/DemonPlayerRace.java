package live.ticticboooom.mods.mmo.playerdata.races;

import live.ticticboooom.mods.mmo.api.race.PlayerRace;
import live.ticticboooom.mods.mmo.api.stat.PlayerCoreStatValue;
import live.ticticboooom.mods.mmo.playerdata.stattype.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import java.util.List;

public class DemonPlayerRace extends PlayerRace {
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
