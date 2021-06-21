package live.ticticboooom.mods.mmo.command;

import live.ticticboooom.mods.mmo.MMOMod;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class CommandRegistryListener {
    @SubscribeEvent
    public void onCommandRegister(RegisterCommandsEvent event) {
        PlayerStatCommand.register(event.getDispatcher());
    }
}
