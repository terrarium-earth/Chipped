package earth.terrarium.chipped.client.screens;

import com.mojang.math.Axis;
import com.teamresourceful.resourcefullib.client.closables.CloseablePose;
import earth.terrarium.chipped.client.preview.FakeClientLevel;
import earth.terrarium.chipped.client.preview.FakeLevelPreviewState;
import earth.terrarium.chipped.mixins.GuiGraphicsExtratorAccessor;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.jspecify.annotations.NonNull;

import java.util.Set;
import java.util.function.Supplier;

public class RenderWindowWidget extends AbstractWidget {
    public static final BlockPos ORIGIN = BlockPos.ZERO;
    public static final BlockPos NORTH = BlockPos.ZERO.north();
    public static final BlockPos NORTH_UP = BlockPos.ZERO.north().above();
    public static final BlockPos SOUTH = BlockPos.ZERO.south();
    public static final BlockPos UP = BlockPos.ZERO.above();
    public static final BlockPos DOWN = BlockPos.ZERO.below();

    private final Supplier<Mode> mode;
    private final Supplier<@Nullable BlockState> state;

    public RenderWindowWidget(int x, int y, int width, int height, Supplier<Mode> mode, Supplier<BlockState> state) {
        super(x, y, width, height, CommonComponents.EMPTY);
        this.mode = mode;
        this.state = state;
    }

    @Override
    protected void extractWidgetRenderState(@NonNull GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        Mode mode = this.mode.get();
        BlockState state = this.state.get();
        if (state == null) return;
        boolean isDoor = state.getBlock() instanceof DoorBlock;

        try (var _ = new CloseablePose(graphics)) {
            var level = new FakeClientLevel();
            var transform = mode.transform();

            if (isDoor) {
                transform = Mode.VERTICAL_BLOCK.transform();
                transform = transform.translate(1, 0, -1, new Matrix4f());

                level.setBlock(ORIGIN, state.setValue(DoorBlock.HALF, DoubleBlockHalf.LOWER));
                level.setBlock(UP, state.setValue(DoorBlock.HALF, DoubleBlockHalf.UPPER));
            } else {
                for (var position : mode.positions) {
                    level.setBlock(position, state);
                }
            }

            var accessor = (GuiGraphicsExtratorAccessor) graphics;
            accessor.getGuiRenderState().addPicturesInPictureState(FakeLevelPreviewState.of(
                level,
                transform,
                this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight(),
                1f,
                null
            ));
        }
    }

    @Override
    protected void updateWidgetNarration(@NonNull NarrationElementOutput output) {
    }


    public enum Mode {
        SINGLE_BLOCK(15, 10, ORIGIN),
        HORIZONTAL_BLOCK(15, 10, ORIGIN, NORTH, SOUTH),
        VERTICAL_BLOCK(15, 10, ORIGIN, UP, DOWN),
        TWO_BY_TWO(6, 15, ORIGIN, NORTH, UP, NORTH_UP);

        private final Set<BlockPos> positions;
        private final Matrix4f transform;

        Mode(int xOffset, int yOffset, BlockPos... positions) {
            this.positions = Set.of(positions);

            this.transform = new Matrix4f();
            this.transform.translate(
                xOffset,
                yOffset,
                0
            );
            this.transform.scale(20);
            this.transform.rotate(Axis.ZP.rotation((float) Math.PI)
                .mul(Axis.XN.rotationDegrees(15))
                .mul(Axis.YP.rotationDegrees(45))
            );
        }

        public Matrix4f transform() {
            return this.transform;
        }
    }
}
