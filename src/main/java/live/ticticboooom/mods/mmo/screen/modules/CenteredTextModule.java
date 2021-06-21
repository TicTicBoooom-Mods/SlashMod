package live.ticticboooom.mods.mmo.screen.modules;

import com.mojang.blaze3d.matrix.MatrixStack;
import live.ticticboooom.mods.mmo.api.client.gui.AbstractGuiModule;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;

import java.util.function.Supplier;

public class CenteredTextModule extends AbstractGuiModule {

    private String text;

    public CenteredTextModule(Supplier<Integer> x, Supplier<Integer> y, ContainerScreen<?> screen, String text) {
        super(x, y, screen);
        this.text = text;
    }

    @Override
    public void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        FontRenderer font = Minecraft.getInstance().fontRenderer;
        font.drawString(matrixStack, text, getX().get() - (font.getStringWidth(text) / 2), getY().get(), 0x404040);
    }
}
