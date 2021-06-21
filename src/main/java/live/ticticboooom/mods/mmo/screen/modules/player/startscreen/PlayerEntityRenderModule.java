package live.ticticboooom.mods.mmo.screen.modules.player.startscreen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import live.ticticboooom.mods.mmo.api.client.gui.AbstractGuiModule;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

import java.util.function.Supplier;

public class PlayerEntityRenderModule extends AbstractGuiModule {
    public PlayerEntityRenderModule(Supplier<Integer> x, Supplier<Integer> y, ContainerScreen<?> screen) {
        super(x, y, screen);
    }

    @Override
    public void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        drawEntityOnScreen(getX().get(), getY().get(), 50, -(-getX().get() + x), -(-getY().get() + 80 + y), Minecraft.getInstance().player);
    }

    private static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, LivingEntity livingEntity) {
        float f = (float) Math.atan((double) (mouseX / 40.0F));
        float f1 = (float) Math.atan((double) (mouseY / 40.0F));
        RenderSystem.pushMatrix();
        RenderSystem.translatef((float) posX, (float) posY, 1050.0F);
        RenderSystem.scalef(1.0F, 1.0F, -1.0F);
        MatrixStack matrixstack = new MatrixStack();
        matrixstack.translate(0.0D, 0.0D, 1000.0D);
        matrixstack.scale((float) scale, (float) scale, (float) scale);
        Quaternion quaternion = Vector3f.ZP.rotationDegrees(180.0F);
        Quaternion quaternion1 = Vector3f.XP.rotationDegrees(f1 * 20.0F);
//      quaternion.multiply(quaternion1);
        matrixstack.rotate(quaternion);
        float f2 = livingEntity.renderYawOffset;
        float f3 = livingEntity.rotationYaw;
        float f4 = livingEntity.rotationPitch;
        float f5 = livingEntity.prevRotationYawHead;
        float f6 = livingEntity.rotationYawHead;
        livingEntity.renderYawOffset = 180.0F;
        livingEntity.rotationYaw = f * 40.f;
        livingEntity.rotationPitch = -f1 * 40.f;
        livingEntity.rotationYawHead = 180.F + f * 40.f;
        livingEntity.prevRotationYawHead = 180.F + f1 * 40.f;
        EntityRendererManager entityrenderermanager = Minecraft.getInstance().getRenderManager();
        quaternion1.conjugate();
        entityrenderermanager.setCameraOrientation(quaternion1);
        IRenderTypeBuffer.Impl irendertypebuffer$impl = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();
        RenderSystem.runAsFancy(() -> entityrenderermanager.renderEntityStatic(livingEntity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, matrixstack, irendertypebuffer$impl, 15728880));
        irendertypebuffer$impl.finish();
        livingEntity.renderYawOffset = f2;
        livingEntity.rotationYaw = f3;
        livingEntity.rotationPitch = f4;
        livingEntity.prevRotationYawHead = f5;
        livingEntity.rotationYawHead = f6;
        RenderSystem.popMatrix();
    }
}
