package live.ticticboooom.mods.mmo.stat.core.classes;

import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class MagePlayerClass extends PlayerClass {
    @Override
    public ITextComponent getDescription() {
        return new StringTextComponent("Magic Boi");
    }

    @Override
    public ITextComponent getName() {
        return new StringTextComponent("Mage");
    }
}
