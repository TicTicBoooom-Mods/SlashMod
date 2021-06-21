package live.ticticboooom.mods.mmo.playerdata.classes;

import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import live.ticticboooom.mods.mmo.api.registry.MMORegistries;
import live.ticticboooom.mods.mmo.api.stat.IPlayerClassCoreStatMutator;
import live.ticticboooom.mods.mmo.api.stat.PlayerCoreStatType;
import live.ticticboooom.mods.mmo.playerdata.classes.statmutators.NeutralStatMutator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import java.util.HashMap;
import java.util.Map;

public class BarbarianPlayerClass extends PlayerClass {
    @Override
    public ITextComponent getName() {
        return new StringTextComponent("Barbarian");
    }
}
