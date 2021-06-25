package live.ticticboooom.mods.mmo.stat.core.classes;

import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class ArcherPlayerClass extends PlayerClass {
    @Override
    public ITextComponent getDescription() {
        return new StringTextComponent("Power, from a distance. With the power of bowstrings, the Archer will power through many battles!");
    }

    @Override
    public ITextComponent getName() {
        return new StringTextComponent("Archer");
    }
}
