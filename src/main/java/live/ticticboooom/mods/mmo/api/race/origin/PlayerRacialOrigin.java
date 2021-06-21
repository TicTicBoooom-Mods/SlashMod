package live.ticticboooom.mods.mmo.api.race.origin;

import live.ticticboooom.mods.mmo.api.race.PlayerRace;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerRacialOrigin {
    private PlayerRace dominant;
    private PlayerRace subDominant;
    private PlayerRace recessive;
}
