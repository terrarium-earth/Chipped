package earth.terrarium.chipped.client.preview;

import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.state.gui.pip.PictureInPictureRenderState;
import net.minecraft.core.BlockPos;
import org.joml.Matrix4f;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public record FakeLevelPreviewState(
    List<BlockPos> positions,
    List<BlockModelRenderState> states,
    Matrix4f transform,
    int x0,
    int y0,
    int x1,
    int y1,
    float scale,
    @Nullable ScreenRectangle scissorArea,
    @Nullable ScreenRectangle bounds
) implements PictureInPictureRenderState {

    private static final FakeLevelModelResolver RESOLVER = FakeLevelModelResolver.create();

    public static FakeLevelPreviewState of(FakeClientLevel level, Matrix4f transform, int x0, int y0, int x1, int y1, float scale, @Nullable ScreenRectangle scissor) {
        var positions = new ArrayList<BlockPos>();
        var states = new ArrayList<BlockModelRenderState>();
        for (var pos : level.getModifiedBlocks()) {
            var state = level.getBlockState(pos);
            if (!state.isAir()) {
                positions.add(pos);
                states.add(RESOLVER.resolve(level, pos, state));
            }
        }

        return new FakeLevelPreviewState(
            positions,
            states,
            transform,
            x0, y0, x1, y1,
            scale,
            scissor,
            PictureInPictureRenderState.getBounds(x0, y0, x1, y1, scissor)
        );
    }

    public void forEachBlock(BiConsumer<BlockPos, BlockModelRenderState> consumer) {
        for (int i = 0; i < this.positions.size(); i++) {
            consumer.accept(this.positions.get(i), this.states.get(i));
        }
    }
}
