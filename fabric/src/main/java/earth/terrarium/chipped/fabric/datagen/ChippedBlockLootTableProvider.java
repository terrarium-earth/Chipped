package earth.terrarium.chipped.fabric.datagen;

import com.mojang.datafixers.util.Pair;
import earth.terrarium.chipped.registry.ChippedBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.RedstoneWallTorchBlock;
import net.minecraft.world.level.block.WallTorchBlock;

import java.util.function.Supplier;

public class ChippedBlockLootTableProvider extends FabricBlockLootTableProvider {

    ChippedBlockLootTableProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateBlockLootTables() {
        this.dropSelf(ChippedBlocks.BOTANIST_WORKBENCH.get());
        this.dropSelf(ChippedBlocks.GLASSBLOWER.get());
        this.dropSelf(ChippedBlocks.CARPENTERS_TABLE.get());
        this.dropSelf(ChippedBlocks.LOOM_TABLE.get());
        this.dropSelf(ChippedBlocks.MASON_TABLE.get());
        this.dropSelf(ChippedBlocks.ALCHEMY_BENCH.get());
        this.dropSelf(ChippedBlocks.MECHANIST_WORKBENCH.get());

        ChippedBlocks.REGISTERED_BLOCKS.stream().map(Pair::getFirst).map(Supplier::get).forEach(block -> {
            if (block instanceof DoorBlock) {
                this.add(block, BlockLoot::createDoorTable);
            } else {
                this.dropSelf(block);
            }
        });


        ChippedBlocks.BLOCK_PAIRS.forEach(pair -> {
            Block block1 = pair.getFirst().get();
            Block block2 = pair.getSecond().get();

            if (ChippedBlocks.SKIPPED_MODELS.contains(pair.getSecond())) {
                if (block2 instanceof WallTorchBlock || block2 instanceof RedstoneWallTorchBlock) {
                    this.dropOther(block2, block1);
                }
            }
        });
    }
}
