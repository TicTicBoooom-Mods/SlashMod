package live.ticticboooom.mods.mmo.stat.core.classes;

import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class NecromancerPlayerClass extends PlayerClass {
    @Override
    public ITextComponent getDescription() {
        return new StringTextComponent("Possess and power through, With he power of necromancy you will arm yourself with the dead.");
    }

    @Override
    public ITextComponent getName() {
        return new StringTextComponent("Necromancer");
    }
}
