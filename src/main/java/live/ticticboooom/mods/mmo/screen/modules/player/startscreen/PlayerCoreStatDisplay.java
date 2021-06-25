package live.ticticboooom.mods.mmo.screen.modules.player.startscreen;

import com.mojang.blaze3d.matrix.MatrixStack;
import live.ticticboooom.mods.mmo.api.client.gui.AbstractGuiModule;
import live.ticticboooom.mods.mmo.api.stat.core.PlayerCoreStatValue;
import live.ticticboooom.mods.mmo.stat.core.DefaultPlayerAttributes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;

import java.util.function.Supplier;

public class PlayerCoreStatDisplay extends AbstractGuiModule {
    private final Supplier<DefaultPlayerAttributes> attributes;

    public PlayerCoreStatDisplay(Supplier<Integer> x, Supplier<Integer> y, ContainerScreen<?> screen, Supplier<DefaultPlayerAttributes> attributes) {
        super(x, y, screen);
        this.attributes = attributes;
    }

    @Override
    public void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        super.drawGuiContainerBackgroundLayer(matrixStack, partialTicks, x, y);
        int counter = 0;
        for (PlayerCoreStatValue stat : attributes.get().getCoreStats()) {
            FontRenderer font = Minecraft.getInstance().fontRenderer;
            font.drawText(matrixStack, stat.getType().getName(), getX().get() + 20, getY().get() + (counter * 10), 0x767676);
            font.drawString(matrixStack, Integer.toString(stat.getValue()), getX().get() + 12, getY().get() + (counter * 10), 0x404040);
            counter++;
        }

    }
}
