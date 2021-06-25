package live.ticticboooom.mods.mmo.screen.player.startscreen;

import com.mojang.blaze3d.matrix.MatrixStack;
import live.ticticboooom.mods.mmo.api.client.gui.ModularContainerScreen;
import live.ticticboooom.mods.mmo.screen.modules.CenteredTextModule;
import live.ticticboooom.mods.mmo.screen.modules.player.startscreen.*;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public class PlayerStartSelectorScreen extends ModularContainerScreen<PlayerStartSelectorContainer> {
    private final PlayerStartSelectorContainer cont;
    private final PlayerInventory inv;

    public PlayerStartSelectorScreen(PlayerStartSelectorContainer cont, PlayerInventory inv, ITextComponent titleIn) {
        super(cont, inv, titleIn);
        this.cont = cont;
        this.inv = inv;
        this.getModules().add(new SidePanelModule(() -> this.guiLeft + 210, () -> 15, this));
        this.getModules().add(new SidePanelModule(() -> this.guiLeft - 130, () -> 15, this));
        this.getModules().add(new CenteredTextModule(() -> this.guiLeft - 130 + 50, () -> 25, this, "Racial Origin"));
        this.getModules().add(new CenteredTextModule(() -> this.guiLeft - 130 + 50, () -> 50, this, "Dominant"));
        this.getModules().add(new CenteredTextModule(() -> this.guiLeft - 130 + 50, () -> 100, this, "Sub Dominant"));
        this.getModules().add(new CenteredTextModule(() -> this.guiLeft - 130 + 50, () -> 150, this, "Recessive"));
        this.getModules().add(new PlayerEntityRenderModule(() -> this.guiLeft + 87, () -> this.guiTop + 130, this));
        this.getModules().add(new PlayerRacePickerModule(() -> this.guiLeft - 130, () -> 75, this, cont::setDominantRace));
        this.getModules().add(new PlayerRacePickerModule(() -> this.guiLeft - 130, () -> 125, this, cont::setSubDominantRace));
        this.getModules().add(new PlayerRacePickerModule(() -> this.guiLeft - 130, () -> 175, this, cont::setRecessiveRace));

        this.getModules().add(new CenteredTextModule(() -> this.guiLeft + 260, () -> 25, this, "Class"));
        this.getModules().add(new PlayerClassSelector(() -> this.guiLeft + 210, () -> 50, this, cont::setClassIndex));

        this.getModules().add(new CenteredTextModule(() -> this.guiLeft + 260, () -> 75, this, "Starting Stats"));
        this.getModules().add(new PlayerCoreStatDisplay(() -> this.guiLeft + 210, () -> 100, this, cont::getAttr));
        this.getModules().add(new CompleteSelectionButton(() -> this.guiLeft + 13, () -> 210, this));
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
    }
}
