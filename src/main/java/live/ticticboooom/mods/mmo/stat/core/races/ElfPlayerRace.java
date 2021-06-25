package live.ticticboooom.mods.mmo.stat.core.races;

import live.ticticboooom.mods.mmo.api.race.PlayerRace;
import live.ticticboooom.mods.mmo.api.stat.core.PlayerCoreStatValue;
import live.ticticboooom.mods.mmo.stat.core.stattype.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import java.util.List;

public class ElfPlayerRace extends PlayerRace {
    @Override
    public ITextComponent getDescription() {
        return new StringTextComponent("Pointy listener Boi");
    }

    @Override
    public ITextComponent getName() {
        return new StringTextComponent("Elf");
    }

    @Override
    public List<PlayerCoreStatValue> getStartingValues() {
        List<PlayerCoreStatValue> startingValues = super.getStartingValues();
        for (PlayerCoreStatValue startingValue : startingValues) {
            if (startingValue.getType() instanceof DefaultIntelligenceCoreStatType) {
                startingValue.setValue(startingValue.getValue() + 1);
            }
            if (startingValue.getType() instanceof DefaultWillPowerCoreStatType) {
                startingValue.setValue(startingValue.getValue() + 1);
            }
            if (startingValue.getType() instanceof DefaultEnduranceCoreStatType) {
                startingValue.setValue(startingValue.getValue() - 1);
            }
            if (startingValue.getType() instanceof DefaultStaminaCoreStatType) {
                startingValue.setValue(startingValue.getValue() - 1);
            }
        }
        return startingValues;
    }
}
