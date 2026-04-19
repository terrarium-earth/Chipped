package earth.terrarium.chipped.client.preview;

import earth.terrarium.chipped.common.lib.PlatformService;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

@PlatformService
public interface FakeLevelModelResolver {

    BlockModelRenderState resolve(BlockAndTintGetter level, BlockPos pos, BlockState state);

    static FakeLevelModelResolver create() {
        throw new AssertionError("Platform service not implemented");
    }
}
