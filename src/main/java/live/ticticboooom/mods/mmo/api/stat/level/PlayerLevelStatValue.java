package live.ticticboooom.mods.mmo.api.stat.level;

import lombok.Getter;
import lombok.Setter;

public class PlayerLevelStatValue {
    @Getter
    private final PlayerLevelStatType type;


    @Getter
    @Setter
    private double value;


    public PlayerLevelStatValue(PlayerLevelStatType type) {
        this.type = type;
    }

    public double getTotalLevelPart() {
        return value * type.getTotalLevelEffect();
    }
}
