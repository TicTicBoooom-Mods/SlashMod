package live.ticticboooom.mods.mmo.playerdata.stattype;

import live.ticticboooom.mods.mmo.api.stat.PlayerCoreStatType;
import live.ticticboooom.mods.mmo.api.stat.PlayerCoreStatValue;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class DefaultElementalResistanceCoreStatType extends PlayerCoreStatType {

    @Override
    public ITextComponent getName() {
        return new StringTextComponent("Magic Shielding");
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
