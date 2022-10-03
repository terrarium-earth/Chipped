package com.grimbo.chipped.fabric.datagen;

import java.util.function.Predicate;
import java.util.function.Supplier;

import com.grimbo.chipped.registry.ChippedBlocks;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;

public class ChippedModelProvider extends FabricModelProvider {

    public ChippedModelProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerator) {

        ChippedBlocks.REGISTERED_BLOCKS.stream().map(Pair::getFirst).filter(Predicate.not(ChippedBlocks.SKIPPED_MODELS::contains)).map(Supplier::get).forEach(block -> {

            if (block instanceof MelonBlock) {
                blockModelGenerator.createTrivialBlock(block, TexturedModel.COLUMN);
            } else if (block instanceof LadderBlock) {
                blockModelGenerator.createNonTemplateHorizontalBlock(block);
                blockModelGenerator.createSimpleFlatItemModel(block);
            } else if (block instanceof BarrelBlock) {
                ResourceLocation resourceLocation = TextureMapping.getBlockTexture(block, "_top_open");
                blockModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(blockModelGenerator.createColumnWithFacing()).with(PropertyDispatch.property(BlockStateProperties.OPEN).select(false, Variant.variant().with(VariantProperties.MODEL, TexturedModel.CUBE_TOP_BOTTOM.create(block, blockModelGenerator.modelOutput))).select(true, Variant.variant().with(VariantProperties.MODEL, TexturedModel.CUBE_TOP_BOTTOM.get(block).updateTextures((textureMapping) -> {
                    textureMapping.put(TextureSlot.TOP, resourceLocation);
                }).createWithSuffix(block, "_open", blockModelGenerator.modelOutput)))));
            } else if (block instanceof PointedDripstoneBlock) {
                createPointedDripstone(blockModelGenerator, block);
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

    private void createPointedDripstone(BlockModelGenerators blockModelGenerator, Block block) {
        blockModelGenerator.skipAutoItemBlock(block);
        PropertyDispatch.C2<Direction, DripstoneThickness> c2 = PropertyDispatch.properties(BlockStateProperties.VERTICAL_DIRECTION, BlockStateProperties.DRIPSTONE_THICKNESS);
        DripstoneThickness[] var2 = DripstoneThickness.values();
        int var3 = var2.length;

        int var4;
        DripstoneThickness dripstoneThickness;
        for(var4 = 0; var4 < var3; ++var4) {
            dripstoneThickness = var2[var4];
            c2.select(Direction.UP, dripstoneThickness, createPointedDripstoneVariant(blockModelGenerator, block, Direction.UP, dripstoneThickness));
        }

        var2 = DripstoneThickness.values();
        var3 = var2.length;

        for(var4 = 0; var4 < var3; ++var4) {
            dripstoneThickness = var2[var4];
            c2.select(Direction.DOWN, dripstoneThickness, createPointedDripstoneVariant(blockModelGenerator, block, Direction.DOWN, dripstoneThickness));
        }

        blockModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(c2));
    }

    public final Variant createPointedDripstoneVariant(BlockModelGenerators blockModelGenerator, Block block, Direction direction, DripstoneThickness dripstoneThickness) {
        String var10000 = direction.getSerializedName();
        String string = "_" + var10000 + "_" + dripstoneThickness.getSerializedName();
        TextureMapping textureMapping = TextureMapping.cross(TextureMapping.getBlockTexture(block, string));
        return Variant.variant().with(VariantProperties.MODEL, ModelTemplates.POINTED_DRIPSTONE.createWithSuffix(block, string, textureMapping, blockModelGenerator.modelOutput));
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
    }
}
