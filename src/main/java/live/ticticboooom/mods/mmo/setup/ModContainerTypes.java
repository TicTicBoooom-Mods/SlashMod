package live.ticticboooom.mods.mmo.setup;

import live.ticticboooom.mods.mmo.MMOMod;
import live.ticticboooom.mods.mmo.screen.player.startscreen.PlayerStartSelectorContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MMOMod.ID);

    public static final RegistryObject<ContainerType<PlayerStartSelectorContainer>> START_SELECTOR = CONTAINERS.register("player_start_selector", () -> IForgeContainerType.create(PlayerStartSelectorContainer::new));
}
