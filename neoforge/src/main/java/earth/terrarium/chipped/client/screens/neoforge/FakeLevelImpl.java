package earth.terrarium.chipped.client.screens.neoforge;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import earth.terrarium.athena.api.client.neoforge.AthenaBakedModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;

public class FakeLevelImpl {

    public static void renderBatched(BlockRenderDispatcher dispatcher, BlockState state, BlockPos pos, BlockAndTintGetter level, PoseStack poseStack, VertexConsumer consumer, boolean checkSides, RandomSource random, RenderType type) {
        ModelData data = ModelData.EMPTY;
        if (dispatcher.getBlockModel(state) instanceof AthenaBakedModel model) {
            data = model.getModelData(level, pos, state, data);
        }
        dispatcher.renderBatched(state, pos, level, poseStack, consumer, checkSides, random, data, type);
    }
}
