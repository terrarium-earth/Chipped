package earth.terrarium.chipped.fabric.datagen;

import com.mojang.datafixers.util.Pair;
import earth.terrarium.chipped.registry.ModBlocks;
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
        this.dropSelf(ModBlocks.BOTANIST_WORKBENCH.get());
        this.dropSelf(ModBlocks.GLASSBLOWER.get());
        this.dropSelf(ModBlocks.CARPENTERS_TABLE.get());
        this.dropSelf(ModBlocks.LOOM_TABLE.get());
        this.dropSelf(ModBlocks.MASON_TABLE.get());
        this.dropSelf(ModBlocks.ALCHEMY_BENCH.get());
        this.dropSelf(ModBlocks.MECHANIST_WORKBENCH.get());

        ModBlocks.REGISTERED_BLOCKS.stream().map(Pair::getFirst).map(Supplier::get).forEach(block -> {
            if (block instanceof DoorBlock) {
                this.add(block, BlockLoot::createDoorTable);
            } else {
                this.dropSelf(block);
            }
        });


        ModBlocks.BLOCK_PAIRS.forEach(pair -> {
            Block block1 = pair.getFirst().get();
            Block block2 = pair.getSecond().get();

            if (ModBlocks.SKIPPED_MODELS.contains(pair.getSecond())) {
                if (block2 instanceof WallTorchBlock || block2 instanceof RedstoneWallTorchBlock) {
                    this.dropOther(block2, block1);
                }
            }
        });
    }
}
