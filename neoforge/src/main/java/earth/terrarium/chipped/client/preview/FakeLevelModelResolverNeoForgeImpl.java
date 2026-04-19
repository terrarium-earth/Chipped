package earth.terrarium.chipped.client.preview;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.extensions.common.IClientBlockExtensions;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class FakeLevelModelResolverNeoForgeImpl implements FakeLevelModelResolver {

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
        var parts = output.setupModel(
            IDENTITY,
            model.hasMaterialFlag(
                level,
                pos,
                state,
                BakedQuad.FLAG_TRANSLUCENT
            )
        );
        model.collectParts(level, pos, state, output.scratchRandomSource(state.getSeed(pos)), parts);
    }

    private void resolveTints(BlockModelRenderState output, BlockState state, BlockAndTintGetter level, BlockPos pos) {
        var sources = Minecraft.getInstance().getBlockColors().getTintSources(state);
        if (sources.isEmpty()) {
            IClientBlockExtensions.of(state).collectDynamicTintValues(state, level, pos, output.tintLayers());
        } else {
            var layers = output.tintLayers();
            for (var source : sources) {
                layers.add(source.colorInWorld(state, level, pos));
            }
        }
    }
}
