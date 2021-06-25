package live.ticticboooom.mods.mmo.stat.core;

import live.ticticboooom.mods.mmo.api.stat.core.ICoreStatValueIncrementor;

public class DefaultCoreStatValueIncrementor implements ICoreStatValueIncrementor {

    @Override
    public int getNext(int prev) {
        return prev + 1;
    }
}
