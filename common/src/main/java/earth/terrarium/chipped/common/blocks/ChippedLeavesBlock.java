package earth.terrarium.chipped.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TintedParticleLeavesBlock;

public class ChippedLeavesBlock extends TintedParticleLeavesBlock {

    // 2.0f is greater than tha range of 0-1 that the vanilla code uses, so that no particles will spawn
    public ChippedLeavesBlock(Properties properties) {
        super(2.0f, properties);
    }

    @Override
    protected void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random) {
        // Do not spawn any leaves
    }
}
