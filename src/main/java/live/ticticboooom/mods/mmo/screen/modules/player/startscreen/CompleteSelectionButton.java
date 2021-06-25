package live.ticticboooom.mods.mmo.screen.modules.player.startscreen;

import com.mojang.blaze3d.matrix.MatrixStack;
import live.ticticboooom.mods.mmo.ModIds;
import live.ticticboooom.mods.mmo.api.client.gui.AbstractGuiModule;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;

import java.util.function.Supplier;

public class CompleteSelectionButton extends AbstractGuiModule {

    public CompleteSelectionButton(Supplier<Integer> x, Supplier<Integer> y, ContainerScreen<?> screen) {
        super(x, y, screen);
    }

    @Override
    public void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        Minecraft.getInstance().textureManager.bindTexture(ModIds.GUI_PARTS_TEXTURE_ID);
        this.screen.blit(matrixStack, x.get(), y.get(), 103, 0, 153, 26);
        FontRenderer font = Minecraft.getInstance().fontRenderer;
        font.drawString(matrixStack, "Continue  >", x.get() + 50, y.get() + 9, 0x404040);
    }
}
