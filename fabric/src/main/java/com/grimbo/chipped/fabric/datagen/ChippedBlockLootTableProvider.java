package com.grimbo.chipped.fabric.datagen;

import com.grimbo.chipped.registry.ChippedBlocks;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.Registry;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.Supplier;

public class ChippedBlockLootTableProvider extends FabricBlockLootTableProvider {

    ChippedBlockLootTableProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateBlockLootTables() {
        ChippedBlocks.REGISTERED_BLOCKS.stream().map(Pair::getFirst).map(Supplier::get).forEach(block -> {

            if (Registry.BLOCK.getKey(block).getPath().contains("clay")) {
                createSingleItemTableWithSilkTouch(block, Items.CLAY_BALL, ConstantValue.exactly(4.0F));
            } else if (block instanceof MelonBlock) {
                createSilkTouchDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(Items.MELON_SLICE).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 7.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)).apply(LimitCount.limitCount(IntRange.upperBound(9)))));
            } else if (block instanceof DoorBlock) {
                this.add(block, BlockLoot::createDoorTable);
            } else if (block instanceof VineBlock) {
                this.add(block, BlockLoot::createShearsOnlyDrop);
            } else if (block instanceof NetherSproutsBlock) {
                this.add(block, BlockLoot::createShearsOnlyDrop);
            } else if (block instanceof WebBlock) {
                createSilkTouchOrShearsDispatchTable(block, applyExplosionCondition(block, LootItem.lootTableItem(Items.STRING)));
            } else if (block instanceof GlassBlock || (block instanceof IronBarsBlock && !Registry.BLOCK.getKey(block).getPath().contains("iron_bar"))) {
                dropWhenSilkTouch(block);
            } else {
                dropSelf(block);
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
