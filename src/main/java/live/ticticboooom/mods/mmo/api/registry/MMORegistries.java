package live.ticticboooom.mods.mmo.api.registry;

import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import live.ticticboooom.mods.mmo.api.race.PlayerRace;
import live.ticticboooom.mods.mmo.api.stat.PlayerCoreStatType;
import net.minecraftforge.registries.IForgeRegistry;

public class MMORegistries {
    public static IForgeRegistry<PlayerClass> PLAYER_CLASS;
    public static IForgeRegistry<PlayerRace> PLAYER_RACE;
    public static IForgeRegistry<PlayerCoreStatType> PLAYER_CORE_STAT;
}
