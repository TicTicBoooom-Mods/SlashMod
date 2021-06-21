package live.ticticboooom.mods.mmo.playerdata;

import live.ticticboooom.mods.mmo.api.stat.ICoreStatValueIncrementor;

public class DefaultCoreStatValueIncrementor implements ICoreStatValueIncrementor {

    @Override
    public int getNext(int prev) {
        return prev + 1;
    }
}
