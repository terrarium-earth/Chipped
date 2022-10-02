package com.grimbo.chipped.fabric.datagen;

import java.util.function.Predicate;

import com.grimbo.chipped.registry.ChippedBlocks;

import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.Registry;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.MelonBlock;
import net.minecraft.world.level.block.NetherSproutsBlock;
import net.minecraft.world.level.block.RedstoneWallTorchBlock;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.WebBlock;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ChippedBlockLootTableProvider extends FabricBlockLootTableProvider {

    ChippedBlockLootTableProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateBlockLootTables() {
        // Blocks that always drop themselves
        ChippedBlocks.REGISTERED_BLOCKS.stream().filter(Predicate.not(ChippedBlocks.SKIPPED_MODELS::contains)).map(RegistrySupplier::get).forEach(block -> {
            this.dropSelf(block);
        });

        // Blocks with custom dropping behaviour
        ChippedBlocks.REGISTERED_BLOCKS.stream().filter(ChippedBlocks.SKIPPED_MODELS::contains).map(RegistrySupplier::get).forEach(block -> {

            if (Registry.BLOCK.getKey(block).getPath().contains("clay")) {
                createSingleItemTableWithSilkTouch(block, Items.CLAY_BALL, ConstantValue.exactly(4.0F));
            } else if (block instanceof MelonBlock) {
                createSilkTouchDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(Items.MELON_SLICE).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 7.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)).apply(LimitCount.limitCount(IntRange.upperBound(9)))));
            } else if (block instanceof VineBlock) {
                this.add(block, BlockLoot::createShearsOnlyDrop);
            } else if (block instanceof NetherSproutsBlock) {
                this.add(block, BlockLoot::createShearsOnlyDrop);
            } else if (block instanceof WebBlock) {
                createSilkTouchOrShearsDispatchTable(block, applyExplosionCondition(block, LootItem.lootTableItem(Items.STRING)));
            } else if (block instanceof GlassBlock || block instanceof IronBarsBlock) {
                dropWhenSilkTouch(block);
            }
        });

        ChippedBlocks.BLOCK_PAIRS.forEach(pair -> {
            Block block1 = pair.getLeft().get();
            Block block2 = pair.getRight().get();

            if (ChippedBlocks.SKIPPED_MODELS.contains(pair.getRight())) {
                if (block2 instanceof WallTorchBlock || block2 instanceof RedstoneWallTorchBlock) {
                    this.dropOther(block2, block1);
                }
            }
        });
    }
}
