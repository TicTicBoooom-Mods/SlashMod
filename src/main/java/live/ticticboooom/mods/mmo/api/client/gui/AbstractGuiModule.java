package live.ticticboooom.mods.mmo.api.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;

import java.util.function.Supplier;

@AllArgsConstructor
public abstract class AbstractGuiModule {

    @Getter
    protected Supplier<Integer> x;
    @Getter
    protected Supplier<Integer> y;

    protected ContainerScreen<?> screen;
    public void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {};
    public void mouseClicked(double mouseX, double mouseY, int button) {};
}
