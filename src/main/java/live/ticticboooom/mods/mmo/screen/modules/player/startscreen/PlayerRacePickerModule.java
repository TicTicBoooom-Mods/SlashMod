package live.ticticboooom.mods.mmo.screen.modules.player.startscreen;

import com.mojang.blaze3d.matrix.MatrixStack;
import live.ticticboooom.mods.mmo.api.client.gui.AbstractGuiModule;
import live.ticticboooom.mods.mmo.api.client.util.ClientUtils;
import live.ticticboooom.mods.mmo.api.race.PlayerRace;
import live.ticticboooom.mods.mmo.api.registry.MMORegistries;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.util.RegistryKey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PlayerRacePickerModule extends AbstractGuiModule {
    private List<PlayerRace> races = new ArrayList<>();
    private int index;
    private Consumer<Integer> indexListener;

    public PlayerRacePickerModule(Supplier<Integer> x, Supplier<Integer> y, ContainerScreen screen, Consumer<Integer> indexListener) {
        super(x, y, screen);
        this.indexListener = indexListener;
        for (Map.Entry<RegistryKey<PlayerRace>, PlayerRace> entry : MMORegistries.PLAYER_RACE.getEntries()) {
            races.add(entry.getValue());
        }
    }

    @Override
    public void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        PlayerRace playerRace = races.get(index);
        FontRenderer font = Minecraft.getInstance().fontRenderer;
        font.drawText(matrixStack, playerRace.getName(), getX().get() + 53 - font.getStringPropertyWidth(playerRace.getName()) / 2, getY().get(), 0x767676);
        font.drawString(matrixStack, ">", getX().get() + 80, getY().get(), 0x404040);
        font.drawString(matrixStack, "<", getX().get() + 20, getY().get(), 0x404040);
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (ClientUtils.isPointWithinBB(getX().get() + 75, y.get(), 20, 15, mouseX, mouseY)) {
            index++;
            if (index > races.size() - 1) {
                index = 0;
            }
            indexListener.accept(index);
        } else if (ClientUtils.isPointWithinBB(getX().get() + 15, y.get(), 20, 15, mouseX, mouseY)) {
            index--;
            if (index < 0) {
                index = races.size() - 1;
            }
            indexListener.accept(index);
        }
    }

}