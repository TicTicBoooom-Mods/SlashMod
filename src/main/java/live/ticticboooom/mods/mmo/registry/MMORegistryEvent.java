package live.ticticboooom.mods.mmo.registry;

import live.ticticboooom.mods.mmo.MMOMod;
import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import live.ticticboooom.mods.mmo.api.race.PlayerRace;
import live.ticticboooom.mods.mmo.api.registry.MMORegistries;
import live.ticticboooom.mods.mmo.api.stat.PlayerCoreStatType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegistryBuilder;

public class MMORegistryEvent {
    @SubscribeEvent
    public void onNewRegistry(RegistryEvent.NewRegistry event) {
        MMORegistries.PLAYER_CLASS = new RegistryBuilder<PlayerClass>().setName(new ResourceLocation(MMOMod.ID, "player_class")).setType(PlayerClass.class).create();
        MMORegistries.PLAYER_RACE = new RegistryBuilder<PlayerRace>().setName(new ResourceLocation(MMOMod.ID, "player_race")).setType(PlayerRace.class).create();
        MMORegistries.PLAYER_CORE_STAT = new RegistryBuilder<PlayerCoreStatType>().setName(new ResourceLocation(MMOMod.ID, "player_core_stat_type")).setType(PlayerCoreStatType.class).create();
    }
}
