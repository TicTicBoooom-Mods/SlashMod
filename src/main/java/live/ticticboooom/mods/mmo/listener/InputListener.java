package live.ticticboooom.mods.mmo.listener;

import live.ticticboooom.mods.mmo.MMOMod;
import live.ticticboooom.mods.mmo.setup.ModContainerTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class InputListener {
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (MMOMod.TEMP_GUI_KEY.isKeyDown()) {
            ScreenManager.openScreen(ModContainerTypes.START_SELECTOR.get(), Minecraft.getInstance(), (int)Minecraft.getInstance().getMainWindow().getHandle(), new StringTextComponent(""));
        }
    }
}
