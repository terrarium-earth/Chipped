package earth.terrarium.chipped.neoforge.data.provider.client;

import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;

import java.util.concurrent.CompletableFuture;

public class ChippedModelProvider extends ModelProvider {
    public ChippedModelProvider(PackOutput output) {
        super(output);
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        return super.run(cache);
    }
}
