package live.ticticboooom.mods.mmo.screen.player.startscreen;

import com.mojang.blaze3d.matrix.MatrixStack;
import live.ticticboooom.mods.mmo.MMOMod;
import live.ticticboooom.mods.mmo.api.client.gui.ModularContainerScreen;
import live.ticticboooom.mods.mmo.screen.modules.CenteredTextModule;
import live.ticticboooom.mods.mmo.screen.modules.player.startscreen.PlayerClassSelector;
import live.ticticboooom.mods.mmo.screen.modules.player.startscreen.PlayerCoreStatDisplay;
import live.ticticboooom.mods.mmo.screen.modules.player.startscreen.PlayerEntityRenderModule;
import live.ticticboooom.mods.mmo.screen.modules.player.startscreen.PlayerRacePickerModule;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class PlayerStartSelectorScreen extends ModularContainerScreen<PlayerStartSelectorContainer> {
    private final PlayerStartSelectorContainer cont;
    private final PlayerInventory inv;

    public PlayerStartSelectorScreen(PlayerStartSelectorContainer cont, PlayerInventory inv, ITextComponent titleIn) {
        super(cont, inv, titleIn);
        this.cont = cont;
        this.inv = inv;
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
    }

    public static final ResourceLocation GUI_PARTS = new ResourceLocation(MMOMod.ID, "textures/gui/guiparts_1.png");


    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }


    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        this.renderBackground(matrixStack);
        renderSidePanels(matrixStack);
        super.drawGuiContainerBackgroundLayer(matrixStack, partialTicks, x, y);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
    }

    private void renderSidePanels(MatrixStack stack) {
        Minecraft.getInstance().textureManager.bindTexture(GUI_PARTS);
        this.blit(stack, this.guiLeft + 210, 15, 0, 0, 103, 223);
        this.blit(stack, this.guiLeft - 130, 15, 0, 0, 103, 223);
    }
}
