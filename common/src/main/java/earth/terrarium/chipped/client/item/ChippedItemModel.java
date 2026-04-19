package earth.terrarium.chipped.client.item;

import com.mojang.serialization.MapCodec;
import earth.terrarium.chipped.Chipped;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.resources.model.cuboid.ItemTransforms;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.joml.Matrix4fc;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;

@NullMarked
public record ChippedItemModel(ItemTransforms transforms) implements ItemModel {

    public static final Identifier ID = Chipped.id("model");

    private static final Direction[] DIRECTIONS = Direction.values();

    @Override
    public void update(
        ItemStackRenderState output,
        ItemStack stack,
        ItemModelResolver resolver,
        ItemDisplayContext displayContext,
        @Nullable ClientLevel level,
        @Nullable ItemOwner owner,
        int seed
    ) {
        output.appendModelIdentityElement(this);

        if (stack.getItem() instanceof BlockItem item) {
            output.appendModelIdentityElement(item.getBlock());

            var model = Minecraft.getInstance().getModelManager().getBlockStateModelSet().get(item.getBlock().defaultBlockState());
            var parts = new ArrayList<BlockStateModelPart>(1);
            model.collectParts(RandomSource.create(seed), parts);

            for (var part : parts) {
                var layer = output.newLayer();

                if (stack.hasFoil()) {
                    layer.setFoilType(ItemStackRenderState.FoilType.STANDARD);
                    output.setAnimated();
                    output.appendModelIdentityElement(ItemStackRenderState.FoilType.STANDARD);
                } else if ((part.materialFlags() & BakedQuad.FLAG_ANIMATED) != 0) {
                    output.setAnimated();
                }

                layer.setParticleMaterial(part.particleMaterial());
                layer.setItemTransform(this.transforms.getTransform(displayContext));

                layer.prepareQuadList().addAll(part.getQuads(null));
                for (var direction : DIRECTIONS) {
                    layer.prepareQuadList().addAll(part.getQuads(direction));
                }
            }
        }
    }

    public static class Unbaked implements ItemModel.Unbaked {

        public static final Unbaked INSTANCE = new Unbaked();
        public static final MapCodec<Unbaked> CODEC = MapCodec.unit(INSTANCE);

        @Override
        public MapCodec<? extends ItemModel.Unbaked> type() {
            return CODEC;
        }

        @Override
        public ItemModel bake(BakingContext context, Matrix4fc transformation) {
            var model = context.blockModelBaker().getModel(Identifier.withDefaultNamespace("block/block"));
            return new ChippedItemModel(model.getTopTransforms());
        }

        @Override
        public void resolveDependencies(Resolver resolver) {

        }
    }
}
