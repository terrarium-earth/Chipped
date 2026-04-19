package earth.terrarium.chipped.client.preview;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Brightness;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.CardinalLighting;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LevelLightEngine;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@NullMarked
public class FakeClientLevel implements BlockAndTintGetter, LevelWriter {

    private static final BlockState EMPTY_BLOCK = Blocks.AIR.defaultBlockState();
    private static final FluidState EMPTY_FLUID = Fluids.EMPTY.defaultFluidState();

    private final ClientLevel level = Objects.requireNonNull(
        Minecraft.getInstance().level,
        "A fake level preview cannot be created without a level"
    );

    private final Map<BlockPos, BlockState> states = new HashMap<>();

    // LevelWriter

    @Override
    public boolean setBlock(BlockPos pos, BlockState blockState, @Block.UpdateFlags int updateFlags, int updateLimit) {
        return this.states.put(pos, blockState) != null;
    }

    @Override
    public boolean removeBlock(BlockPos pos, boolean movedByPiston) {
        return this.states.remove(pos) != null;
    }

    @Override
    public boolean destroyBlock(BlockPos pos, boolean dropResources, @Nullable Entity breaker, int updateLimit) {
        return this.states.remove(pos) != null;
    }

    // BlockAndLightGetter

    @Override
    public LevelLightEngine getLightEngine() {
        return LevelLightEngine.EMPTY;
    }

    @Override
    public int getBrightness(LightLayer layer, BlockPos pos) {
        return Brightness.FULL_BRIGHT.block();
    }

    @Override
    public int getLightEmission(BlockPos pos) {
        return Brightness.FULL_BRIGHT.block();
    }

    @Override
    public int getRawBrightness(BlockPos pos, int darkening) {
        return Brightness.FULL_BRIGHT.block();
    }

    // BlockAndTintGetter

    @Override
    public CardinalLighting cardinalLighting() {
        return CardinalLighting.DEFAULT;
    }

    @Override
    public int getBlockTint(BlockPos pos, ColorResolver resolver) {
        return this.level.getBlockTint(pos, resolver);
    }

    // BlockGetter

    @Override
    public @Nullable BlockEntity getBlockEntity(BlockPos pos) {
        return null;
    }

    @Override
    public BlockState getBlockState(BlockPos blockPos) {
        return this.states.getOrDefault(blockPos, EMPTY_BLOCK);
    }

    @Override
    public FluidState getFluidState(BlockPos blockPos) {
        return EMPTY_FLUID;
    }

    // LevelHeightAccessor

    @Override
    public int getHeight() {
        return 256;
    }

    @Override
    public int getMinY() {
        return -64;
    }

    // FakeClientLevel

    public void clear() {
        this.states.clear();
    }

    public Collection<BlockPos> getModifiedBlocks() {
        return this.states.keySet();
    }

    public boolean setBlock(BlockPos pos, BlockState blockState) {
        return this.setBlock(pos, blockState, Block.UPDATE_ALL);
    }

}
