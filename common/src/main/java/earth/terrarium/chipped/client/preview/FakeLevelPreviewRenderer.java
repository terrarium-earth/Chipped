package earth.terrarium.chipped.client.preview;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.render.pip.PictureInPictureRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.LightCoordsUtil;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class FakeLevelPreviewRenderer extends PictureInPictureRenderer<FakeLevelPreviewState> {

    private @Nullable FakeLevelPreviewState lastState;

    public FakeLevelPreviewRenderer(MultiBufferSource.BufferSource source) {
        super(source);
    }

    @Override
    public Class<FakeLevelPreviewState> getRenderStateClass() {
        return FakeLevelPreviewState.class;
    }

    @Override
    protected float getTranslateY(int height, int scale) {
        return height / 2.0f;
    }

    @Override
    protected boolean textureIsReadyToBlit(FakeLevelPreviewState state) {
        return state.equals(this.lastState);
    }

    @Override
    protected void renderToTexture(FakeLevelPreviewState state, PoseStack stack) {
        this.lastState = state;

        var renderer = Minecraft.getInstance().gameRenderer;
        var dispatcher = renderer.getFeatureRenderDispatcher();
        var storage = dispatcher.getSubmitNodeStorage();

        renderer.getLighting().setupFor(Lighting.Entry.ITEMS_3D);

        stack.pushPose();
        stack.mulPose(state.transform());

        state.forEachBlock((pos, model) -> {
            stack.pushPose();
            stack.translate(pos.getX(), pos.getY(), pos.getZ());
            model.submit(stack, storage, LightCoordsUtil.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, 0);
            stack.popPose();
        });

        stack.popPose();

        dispatcher.renderAllFeatures();
    }

    @Override
    protected String getTextureLabel() {
        return "chipped_level_preview";
    }
}
