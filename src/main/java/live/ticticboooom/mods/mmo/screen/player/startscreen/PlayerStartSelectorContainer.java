package live.ticticboooom.mods.mmo.screen.player.startscreen;

import live.ticticboooom.mods.mmo.api.classes.PlayerClass;
import live.ticticboooom.mods.mmo.api.race.PlayerRace;
import live.ticticboooom.mods.mmo.api.race.origin.PlayerRacialOrigin;
import live.ticticboooom.mods.mmo.api.registry.MMORegistries;
import live.ticticboooom.mods.mmo.stat.core.DefaultPlayerAttributes;
import live.ticticboooom.mods.mmo.setup.ModContainerTypes;
import lombok.Getter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;

import java.util.ArrayList;
import java.util.List;

public class PlayerStartSelectorContainer extends Container {

    @Getter
    private PlayerInventory inv;

    @Getter
    private DefaultPlayerAttributes attr = new DefaultPlayerAttributes();

    @Getter
    private int dominantRace = 0;
    @Getter
    private int subDominantRace = 0;
    @Getter
    private int recessiveRace = 0;

    private PlayerRacialOrigin origin = new PlayerRacialOrigin();

    public void setDominantRace(int val) {
        this.dominantRace = val;
        origin.setDominant(races.get(dominantRace));
        attr.setPlayerOrigin(origin);
    }

    public void setSubDominantRace(int val) {
        this.subDominantRace = val;
        origin.setSubDominant(races.get(subDominantRace));
        attr.setPlayerOrigin(origin);
    }

    public void setRecessiveRace(int val) {
        this.recessiveRace = val;
        origin.setRecessive(races.get(recessiveRace));
        attr.setPlayerOrigin(origin);
    }

    @Getter
    private int classIndex;
    public void setClassIndex(int val) {
        this.classIndex = val;
        this.attr.setPlayerClass(classes.get(classIndex));
    }

    private List<PlayerClass> classes = new ArrayList<>();
    private List<PlayerRace> races = new ArrayList<>();

    protected PlayerStartSelectorContainer(int id, PlayerInventory inv) {
        super(ModContainerTypes.START_SELECTOR.get(), id);
        this.inv = inv;
        for (PlayerClass playerClass : MMORegistries.PLAYER_CLASS) {
            classes.add(playerClass);
        }
        for (PlayerRace playerRace : MMORegistries.PLAYER_RACE) {
            races.add(playerRace);
        }
        setDominantRace(0);
        setSubDominantRace(0);
        setRecessiveRace(0);
        setClassIndex(0);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }

    public PlayerStartSelectorContainer(int windowId, PlayerInventory inv, PacketBuffer data) {
        this(windowId, inv);
    }

}