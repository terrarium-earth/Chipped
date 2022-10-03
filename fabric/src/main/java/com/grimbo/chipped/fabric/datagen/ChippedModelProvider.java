package com.grimbo.chipped.fabric.datagen;

import java.util.function.Predicate;
import java.util.function.Supplier;

import com.grimbo.chipped.registry.ChippedBlocks;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.Registry;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ChippedModelProvider extends FabricModelProvider {

    public ChippedModelProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerator) {

        ChippedBlocks.REGISTERED_BLOCKS.stream().map(Pair::getFirst).filter(Predicate.not(ChippedBlocks.SKIPPED_MODELS::contains)).map(Supplier::get).forEach(block -> {

            if (block instanceof MelonBlock) {
                blockModelGenerator.createTrivialBlock(block, TexturedModel.COLUMN);
            } else if (block instanceof RedstoneLampBlock) {
                ResourceLocation resourceLocation = TexturedModel.CUBE.create(block, blockModelGenerator.modelOutput);
                ResourceLocation resourceLocation2 = blockModelGenerator.createSuffixedVariant(block, "_on", ModelTemplates.CUBE_ALL, TextureMapping::cube);
                blockModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, resourceLocation2, resourceLocation)));
            } else if (block instanceof RotatedPillarBlock) {
                blockModelGenerator.createRotatedPillarWithHorizontalVariant(block, TexturedModel.COLUMN, TexturedModel.COLUMN_HORIZONTAL);
            } else if (block instanceof WebBlock || block instanceof MushroomBlock || block instanceof NetherSproutsBlock || block instanceof RootsBlock || block instanceof FungusBlock) {
                blockModelGenerator.createCrossBlockWithDefaultItem(block, BlockModelGenerators.TintState.NOT_TINTED);
            } else if (block instanceof VineBlock) {
                blockModelGenerator.createMultiface(block);
            } else if (block instanceof WaterlilyBlock) {
                blockModelGenerator.createSimpleFlatItemModel(block);
                blockModelGenerator.blockStateOutput.accept(BlockModelGenerators.createRotatedVariant(block, ModelLocationUtils.getModelLocation(block)));
            } else if (Registry.BLOCK.getKey(block).getPath().contains("dried_kelp_block")) {
                blockModelGenerator.createNonTemplateModelBlock(block);
            } else {
                blockModelGenerator.createTrivialCube(block);
                blockModelGenerator.delegateItemModel(block, ModelLocationUtils.getModelLocation(block));
            }
        });

        ChippedBlocks.BLOCK_PAIRS.forEach(pair -> {
            Block block1 = pair.getFirst().get();
            Block block2 = pair.getSecond().get();

            if (block2 instanceof CarpetBlock) {
                blockModelGenerator.createFullAndCarpetBlocks(block1, block2);
            } else if (block2 instanceof IronBarsBlock) {
                blockModelGenerator.createGlassBlocks(block1, block2);
            } else if (block2 instanceof WallTorchBlock || block2 instanceof RedstoneWallTorchBlock) {
                blockModelGenerator.createNormalTorch(block1, block2);
            } else {
                blockModelGenerator.createTrivialCube(block1);
                blockModelGenerator.delegateItemModel(block1, ModelLocationUtils.getModelLocation(block1));
            }
        });
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
    }
}
