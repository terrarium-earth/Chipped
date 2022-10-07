package earth.terrarium.chipped.fabric.datagen;

import earth.terrarium.chipped.registry.ChippedBlocks;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.*;

import java.util.function.Supplier;

public class ChippedBlockLootTableProvider extends FabricBlockLootTableProvider {

    ChippedBlockLootTableProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateBlockLootTables() {
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
