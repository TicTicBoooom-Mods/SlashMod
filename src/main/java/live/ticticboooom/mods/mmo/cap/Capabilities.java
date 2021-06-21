package live.ticticboooom.mods.mmo.cap;

import live.ticticboooom.mods.mmo.api.cap.IPlayerAttributes;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class Capabilities {
    @CapabilityInject(IPlayerAttributes.class)
    public static final Capability<IPlayerAttributes> PLAYER_PROGRESS_CAPABILITY = null;

}
