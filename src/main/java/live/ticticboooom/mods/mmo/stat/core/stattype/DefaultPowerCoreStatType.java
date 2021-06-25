package live.ticticboooom.mods.mmo.stat.core.stattype;

import live.ticticboooom.mods.mmo.api.stat.core.PlayerCoreStatType;
import live.ticticboooom.mods.mmo.api.stat.core.PlayerCoreStatValue;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class DefaultPowerCoreStatType extends PlayerCoreStatType {

    @Override
    public ITextComponent getName() {
        return new StringTextComponent("Power");
    }

    @Override
    public int getBaseValue() {
        return 5;
    }

    @Override
    public PlayerCoreStatValue create() {
        PlayerCoreStatValue statValue = new PlayerCoreStatValue(this);
        statValue.setValue(getBaseValue());
        return statValue;
    }
}
