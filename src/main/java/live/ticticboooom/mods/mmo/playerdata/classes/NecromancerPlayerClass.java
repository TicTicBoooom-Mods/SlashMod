package live.ticticboooom.mods.mmo.playerdata.classes;

import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class NecromancerPlayerClass extends PlayerClass {
    @Override
    public ITextComponent getName() {
        return new StringTextComponent("Necromancer");
    }
}
