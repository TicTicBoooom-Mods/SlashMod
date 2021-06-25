package live.ticticboooom.mods.mmo.api.stat.core;

import lombok.Getter;
import lombok.Setter;

public class PlayerCoreStatValue {
    public PlayerCoreStatValue(PlayerCoreStatType type) {

        this.type = type;
    }

    @Getter
    @Setter
    private int value;
    @Getter
    private PlayerCoreStatType type;
}
