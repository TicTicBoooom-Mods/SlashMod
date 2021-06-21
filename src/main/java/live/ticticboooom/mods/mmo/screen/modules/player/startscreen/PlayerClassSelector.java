package live.ticticboooom.mods.mmo.screen.modules.player.startscreen;

import com.mojang.blaze3d.matrix.MatrixStack;
import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import live.ticticboooom.mods.mmo.api.client.gui.AbstractGuiModule;
import live.ticticboooom.mods.mmo.api.client.util.ClientUtils;
import live.ticticboooom.mods.mmo.api.race.PlayerRace;
import live.ticticboooom.mods.mmo.api.registry.MMORegistries;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PlayerClassSelector extends AbstractGuiModule {

    private int index;
    private final List<PlayerClass> classes = new ArrayList<>();
    private Consumer<Integer> indexListener;

    public PlayerClassSelector(Supplier<Integer> x, Supplier<Integer> y, ContainerScreen<?> screen, Consumer<Integer> indexListener) {
        super(x, y, screen);
        this.indexListener = indexListener;
        for (PlayerClass playerClass : MMORegistries.PLAYER_CLASS) {
            classes.add(playerClass);
        }
    }

    @Override
    public void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        super.drawGuiContainerBackgroundLayer(matrixStack, partialTicks, x, y);
        FontRenderer font = Minecraft.getInstance().fontRenderer;
        PlayerClass playerClass = classes.get(index);
        font.drawText(matrixStack, playerClass.getName(), getX().get() + 53 - font.getStringPropertyWidth(playerClass.getName()) / 2, getY().get(), 0x767676);
        font.drawString(matrixStack, ">", getX().get() + 90, getY().get(), 0x404040);
        font.drawString(matrixStack, "<", getX().get()+ 10, getY().get(), 0x404040);
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (ClientUtils.isPointWithinBB(getX().get() + 85, y.get(), 20, 15, mouseX, mouseY)) {
            index++;
            if (index > classes.size() - 1) {
                index = 0;
            }
            indexListener.accept(index);
        } else if (ClientUtils.isPointWithinBB(getX().get() + 5, y.get(), 20, 15, mouseX, mouseY)) {
            index--;
            if (index < 0) {
                index = classes.size() - 1;
            }
            indexListener.accept(index);
        }
    }
}
