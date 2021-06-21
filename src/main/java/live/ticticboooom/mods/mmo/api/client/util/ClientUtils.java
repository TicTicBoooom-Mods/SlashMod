package live.ticticboooom.mods.mmo.api.client.util;

import net.minecraft.client.renderer.Rectangle2d;

public class ClientUtils {
    public static boolean isPointWithinBB(int x, int y, int width, int height, double mouseX, double mouseY) {
        return new Rectangle2d(x, y, width, height).contains((int)mouseX, (int)mouseY);
    }
}
