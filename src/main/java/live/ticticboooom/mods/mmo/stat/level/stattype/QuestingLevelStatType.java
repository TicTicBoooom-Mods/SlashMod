package live.ticticboooom.mods.mmo.stat.level.stattype;

import live.ticticboooom.mods.mmo.api.stat.level.PlayerLevelStatType;
import live.ticticboooom.mods.mmo.api.stat.level.PlayerLevelStatValue;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class QuestingLevelStatType extends PlayerLevelStatType {
    @Override
    public ITextComponent getName() {
        return new StringTextComponent("Questing");
    }

    @Override
    public PlayerLevelStatValue create() {
        return new PlayerLevelStatValue(this);
    }

    @Override
    public double getTotalLevelEffect() {
        return 0.2;
    }
}
