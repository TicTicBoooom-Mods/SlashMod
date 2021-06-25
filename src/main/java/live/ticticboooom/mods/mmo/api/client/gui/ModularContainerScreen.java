package live.ticticboooom.mods.mmo.api.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import lombok.Getter;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.text.ITextComponent;

import java.util.ArrayList;
import java.util.List;

public class ModularContainerScreen<T extends Container> extends ContainerScreen<T> {

    @Getter
    private final List<AbstractGuiModule> modules = new ArrayList<>();

    public ModularContainerScreen(T screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        this.renderBackground(matrixStack);
        for (AbstractGuiModule module : modules) {
            module.drawGuiContainerBackgroundLayer(matrixStack, partialTicks, x, y);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (AbstractGuiModule module : modules) {
            module.mouseClicked(mouseX, mouseY, button);
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}
