package live.ticticboooom.mods.mmo;

import live.ticticboooom.mods.mmo.cap.CapabilityEventListener;
import live.ticticboooom.mods.mmo.cap.ModCapabilityEventListener;
import live.ticticboooom.mods.mmo.command.CommandRegistryListener;
import live.ticticboooom.mods.mmo.listener.InputListener;
import live.ticticboooom.mods.mmo.listener.stat.level.HuntingLevelStatListener;
import live.ticticboooom.mods.mmo.registry.MMORegistryEvent;
import live.ticticboooom.mods.mmo.screen.player.startscreen.PlayerStartSelectorScreen;
import live.ticticboooom.mods.mmo.setup.ModContainerTypes;
import live.ticticboooom.mods.mmo.setup.ModRegistrar;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lwjgl.glfw.GLFW;

@Mod(MMOMod.ID)
public class MMOMod {
    public static final String ID = "mmocraft";
    public static KeyBinding TEMP_GUI_KEY = new KeyBinding("SOMMET", GLFW.GLFW_KEY_V, "MMOCraft");


    public MMOMod() {
        MinecraftForge.EVENT_BUS.register(new CommandRegistryListener());
        MinecraftForge.EVENT_BUS.register(new CapabilityEventListener());
        MinecraftForge.EVENT_BUS.register(new HuntingLevelStatListener());
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.register(new MMORegistryEvent());
        modEventBus.register(new ModRegistrar());
        modEventBus.addListener(MMOMod::onClientSetup);
        modEventBus.register(new ModCapabilityEventListener());
        MinecraftForge.EVENT_BUS.register(new InputListener());
        ModContainerTypes.CONTAINERS.register(modEventBus);
    }

    private static void onClientSetup(FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(TEMP_GUI_KEY);
        ScreenManager.registerFactory(ModContainerTypes.START_SELECTOR.get(), PlayerStartSelectorScreen::new);
    }
}
