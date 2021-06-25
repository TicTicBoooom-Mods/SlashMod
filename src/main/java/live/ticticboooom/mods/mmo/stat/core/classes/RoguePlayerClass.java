package live.ticticboooom.mods.mmo.stat.core.classes;

import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class RoguePlayerClass extends PlayerClass {
    @Override
    public ITextComponent getDescription() {
        return new StringTextComponent("Back and forth, no home in sight battle through all odds for a chance of life.");
    }

    @Override
    public ITextComponent getName() {
        return new StringTextComponent("Rogue");
    }
}
