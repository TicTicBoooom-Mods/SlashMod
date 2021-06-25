package live.ticticboooom.mods.mmo.api.cap;

import live.ticticboooom.mods.mmo.api.cap.IPlayerAttributes;
import live.ticticboooom.mods.mmo.api.cap.IPlayerLevel;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class Capabilities {
    @CapabilityInject(IPlayerAttributes.class)
    public static final Capability<IPlayerAttributes> PLAYER_ATTRIBUTES_CAPABILITY = null;
    @CapabilityInject(IPlayerLevel.class)
    public static final Capability<IPlayerLevel> PLAYER_LEVEL_CAPABILITY = null;
}
