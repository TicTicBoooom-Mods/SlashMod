package live.ticticboooom.mods.mmo.screen.player.startscreen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import javax.annotation.Nullable;

public class PlayerStartSelectorContainerNamedProvider implements INamedContainerProvider {
    @Override
    public ITextComponent getDisplayName() {
        return new StringTextComponent("Beans");
    }

    @Nullable
    @Override
    public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
        return new PlayerStartSelectorContainer(p_createMenu_1_, p_createMenu_2_);
    }
}
