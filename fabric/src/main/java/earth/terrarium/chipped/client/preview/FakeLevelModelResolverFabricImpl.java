package earth.terrarium.chipped.client.preview;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class FakeLevelModelResolverFabricImpl implements FakeLevelModelResolver {

    private static final Matrix4fc IDENTITY = new Matrix4f();

    @Override
    public BlockModelRenderState resolve(BlockAndTintGetter level, BlockPos pos, BlockState state) {
        var output = new BlockModelRenderState();

        resolveQuads(output, state, level, pos);
        resolveTints(output, state, level, pos);

        return output;
    }

    private void resolveQuads(BlockModelRenderState output, BlockState state, BlockAndTintGetter level, BlockPos pos) {
        var model = Minecraft.getInstance().getModelManager().getBlockStateModelSet().get(state);
        var emitter = output.setupMesh(
            IDENTITY,
            model.hasMaterialFlag(
                level,
                pos,
                state,
                output.scratchRandomSource(state.getSeed(pos)),
                BakedQuad.FLAG_TRANSLUCENT
            )
        );

        model.emitQuads(emitter, level, pos, state, output.scratchRandomSource(state.getSeed(pos)), _ -> false);
    }

    private void resolveTints(BlockModelRenderState output, BlockState state, BlockAndTintGetter level, BlockPos pos) {
        var sources = Minecraft.getInstance().getBlockColors().getTintSources(state);
        if (sources.isEmpty()) return;

        var layers = output.tintLayers();
        for (var source : sources) {
            layers.add(source.colorInWorld(state, level, pos));
        }
    }
}
