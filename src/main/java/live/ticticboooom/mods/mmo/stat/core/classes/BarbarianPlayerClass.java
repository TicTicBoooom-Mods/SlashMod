package live.ticticboooom.mods.mmo.stat.core.classes;

import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class BarbarianPlayerClass extends PlayerClass {
    @Override
    public ITextComponent getDescription() {
        return new StringTextComponent("Strength and Brutality takes all with the Barbarian, tanking through enemies with ease. However, Fiddly tasks are not quite this guys forte.");
    }

    @Override
    public ITextComponent getName() {
        return new StringTextComponent("Barbarian");
    }
}
