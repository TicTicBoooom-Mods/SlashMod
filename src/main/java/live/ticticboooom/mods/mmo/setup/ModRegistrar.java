package live.ticticboooom.mods.mmo.setup;

import live.ticticboooom.mods.mmo.MMOMod;
import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import live.ticticboooom.mods.mmo.api.race.PlayerRace;
import live.ticticboooom.mods.mmo.api.stat.PlayerCoreStatType;
import live.ticticboooom.mods.mmo.playerdata.classes.*;
import live.ticticboooom.mods.mmo.playerdata.races.*;
import live.ticticboooom.mods.mmo.playerdata.stattype.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModRegistrar {

    @SubscribeEvent
    public void registerCoreStats(RegistryEvent.Register<PlayerCoreStatType> event) {
        event.getRegistry().register(new DefaultConstitutionCoreStatType().setRegistryName(new ResourceLocation(MMOMod.ID, "constitution")));
        event.getRegistry().register(new DefaultAgilityCoreStatType().setRegistryName(new ResourceLocation(MMOMod.ID, "agility")));
        event.getRegistry().register(new DefaultDexterityCoreStatType().setRegistryName(new ResourceLocation(MMOMod.ID, "dexterity")));
        event.getRegistry().register(new DefaultElementalResistanceCoreStatType().setRegistryName(new ResourceLocation(MMOMod.ID, "elemental_resistance")));
        event.getRegistry().register(new DefaultEnduranceCoreStatType().setRegistryName(new ResourceLocation(MMOMod.ID, "endurance")));
        event.getRegistry().register(new DefaultFinesseCoreStatType().setRegistryName(new ResourceLocation(MMOMod.ID, "finesse")));
        event.getRegistry().register(new DefaultIntelligenceCoreStatType().setRegistryName(new ResourceLocation(MMOMod.ID, "intelligence")));
        event.getRegistry().register(new DefaultPowerCoreStatType().setRegistryName(new ResourceLocation(MMOMod.ID, "power")));
        event.getRegistry().register(new DefaultStaminaCoreStatType().setRegistryName(new ResourceLocation(MMOMod.ID, "stamina")));
        event.getRegistry().register(new DefaultWillPowerCoreStatType().setRegistryName(new ResourceLocation(MMOMod.ID, "will_power")));
    }

    @SubscribeEvent
    public void registerRaces(RegistryEvent.Register<PlayerRace> event) {
        event.getRegistry().register(new HumanPlayerRace().setRegistryName(new ResourceLocation(MMOMod.ID, "human")));
        event.getRegistry().register(new DwarfPlayerRace().setRegistryName(new ResourceLocation(MMOMod.ID, "dwarf")));
        event.getRegistry().register(new ElfPlayerRace().setRegistryName(new ResourceLocation(MMOMod.ID, "elf")));
        event.getRegistry().register(new DemonPlayerRace().setRegistryName(new ResourceLocation(MMOMod.ID, "demon")));
        event.getRegistry().register(new AngelPlayerRace().setRegistryName(new ResourceLocation(MMOMod.ID, "angel")));
        event.getRegistry().register(new FelinPlayerRace().setRegistryName(new ResourceLocation(MMOMod.ID, "felin")));
    }

    @SubscribeEvent
    public void registerClasses(RegistryEvent.Register<PlayerClass> event) {
        event.getRegistry().register(new BarbarianPlayerClass().setRegistryName(new ResourceLocation(MMOMod.ID, "barbarian")));
        event.getRegistry().register(new RoguePlayerClass().setRegistryName(new ResourceLocation(MMOMod.ID, "rogue")));
        event.getRegistry().register(new ArcherPlayerClass().setRegistryName(new ResourceLocation(MMOMod.ID, "archer")));
        event.getRegistry().register(new MagePlayerClass().setRegistryName(new ResourceLocation(MMOMod.ID, "mage")));
        event.getRegistry().register(new PriestPlayerClass().setRegistryName(new ResourceLocation(MMOMod.ID, "priest")));
        event.getRegistry().register(new NecromancerPlayerClass().setRegistryName(new ResourceLocation(MMOMod.ID, "necromancer")));
    }
}
