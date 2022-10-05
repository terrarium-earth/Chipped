package com.grimbo.chipped.fabric.datagen;

import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.registry.ChippedBlocks;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.*;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import org.apache.commons.lang3.StringUtils;

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
            } else if (block instanceof DoorBlock) {
                blockModelGenerator.createDoor(block);
            } else if (block instanceof TrapDoorBlock) {
                blockModelGenerator.createTrapdoor(block);
            } else if (Registry.BLOCK.getKey(block).getPath().contains("bookshelf")) {
                TextureMapping textureMapping = TextureMapping.column(TextureMapping.getBlockTexture(block), TextureMapping.getBlockTexture(Blocks.OAK_PLANKS));
                ResourceLocation resourceLocation = ModelTemplates.CUBE_COLUMN.create(block, textureMapping, blockModelGenerator.modelOutput);
                blockModelGenerator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, resourceLocation));
            } else if (block instanceof BarrelBlock) {
                ResourceLocation resourceLocation = TextureMapping.getBlockTexture(block, "_top_open");
                blockModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(blockModelGenerator.createColumnWithFacing()).with(PropertyDispatch.property(BlockStateProperties.OPEN).select(false, Variant.variant().with(VariantProperties.MODEL, TexturedModel.CUBE_TOP_BOTTOM.create(block, blockModelGenerator.modelOutput))).select(true, Variant.variant().with(VariantProperties.MODEL, TexturedModel.CUBE_TOP_BOTTOM.get(block).updateTextures((textureMapping) -> textureMapping.put(TextureSlot.TOP, resourceLocation)).createWithSuffix(block, "_open", blockModelGenerator.modelOutput)))));
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
            } else if (block instanceof PumpkinBlock) {
                createPumpkin(blockModelGenerator, block);
            } else if (block instanceof IronBarsBlock && Registry.BLOCK.getKey(block).getPath().contains("iron_bar")) {
                createIronBars(blockModelGenerator, block);
            } else if (block instanceof CarvedPumpkinBlock) {
                int id = Integer.parseInt(StringUtils.substringAfterLast(Registry.BLOCK.getKey(block).getPath(), "_"));
                if (id == 20) {
                    createCarvedPumpkin(blockModelGenerator, block, Registry.BLOCK.get(new ResourceLocation(Chipped.MOD_ID, "pumpkin_14")));
                } else if (id == 21) {
                    createCarvedPumpkin(blockModelGenerator, block, Registry.BLOCK.get(new ResourceLocation(Chipped.MOD_ID, "pumpkin_15")));
                } else if (id == 22) {
                    createCarvedPumpkin(blockModelGenerator, block, Registry.BLOCK.get(new ResourceLocation(Chipped.MOD_ID, "pumpkin_16")));
                } else {
                    createCarvedPumpkin(blockModelGenerator, block, Blocks.PUMPKIN);
                }
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
            } else if (block2 instanceof WallTorchBlock) {
                blockModelGenerator.createNormalTorch(block1, block2);
            } else if (block2 instanceof RedstoneWallTorchBlock) {
                createRedstoneTorch(blockModelGenerator, block1, block2);
            } else {
                blockModelGenerator.createTrivialCube(block1);
                blockModelGenerator.delegateItemModel(block1, ModelLocationUtils.getModelLocation(block1));
            }
        });
    }

    private void createPumpkin(BlockModelGenerators blockModelGenerator, Block pumpkin) {
        blockModelGenerator.createCraftingTableLike(pumpkin, pumpkin, (block1, block2) -> ChippedModelProvider.pumpkin(block1));
    }

    private void createCarvedPumpkin(BlockModelGenerators blockModelGenerator, Block carved, Block pumpkin) {
        createCarvedPumpkinLike(blockModelGenerator, carved, pumpkin, ChippedModelProvider::carvedPumpkin);
    }

    public static TextureMapping pumpkin(Block pumpkin) {
        return (new TextureMapping()).put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(pumpkin, "_side")).put(TextureSlot.DOWN, TextureMapping.getBlockTexture(pumpkin, "_bottom")).put(TextureSlot.UP, TextureMapping.getBlockTexture(pumpkin, "_top")).put(TextureSlot.NORTH, TextureMapping.getBlockTexture(pumpkin, "_side")).put(TextureSlot.EAST, TextureMapping.getBlockTexture(pumpkin, "_side")).put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(pumpkin, "_side")).put(TextureSlot.WEST, TextureMapping.getBlockTexture(pumpkin, "_side"));
    }

    public static TextureMapping carvedPumpkin(Block carved, Block pumpkin) {
        return (new TextureMapping()).put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(carved)).put(TextureSlot.DOWN, TextureMapping.getBlockTexture(pumpkin, pumpkin == Blocks.PUMPKIN ? "_side" : "_bottom")).put(TextureSlot.UP, TextureMapping.getBlockTexture(pumpkin, "_top")).put(TextureSlot.NORTH, TextureMapping.getBlockTexture(carved)).put(TextureSlot.EAST, TextureMapping.getBlockTexture(pumpkin, "_side")).put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(pumpkin, "_side")).put(TextureSlot.WEST, TextureMapping.getBlockTexture(pumpkin, "_side"));
    }

    public final void createCarvedPumpkinLike(BlockModelGenerators blockModelGenerator, Block pumpkinBlock, Block materialBlock, BiFunction<Block, Block, TextureMapping> textureMappingGetter) {
        TextureMapping textureMapping = textureMappingGetter.apply(pumpkinBlock, materialBlock);
        blockModelGenerator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(pumpkinBlock, ModelTemplates.CUBE.create(pumpkinBlock, textureMapping, blockModelGenerator.modelOutput)).with(BlockModelGenerators.createHorizontalFacingDispatch()));
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
        String name = direction.getSerializedName();
        String string = "_" + name + "_" + dripstoneThickness.getSerializedName();
        TextureMapping textureMapping = TextureMapping.cross(TextureMapping.getBlockTexture(block, string));
        return Variant.variant().with(VariantProperties.MODEL, ModelTemplates.POINTED_DRIPSTONE.createWithSuffix(block, string, textureMapping, blockModelGenerator.modelOutput));
    }

    private void createRedstoneTorch(BlockModelGenerators blockModelGenerator, Block block1, Block block2) {
        TextureMapping textureMapping = TextureMapping.torch(block1);
        TextureMapping textureMapping2 = TextureMapping.torch(TextureMapping.getBlockTexture(block1, "_off"));
        ResourceLocation resourceLocation = ModelTemplates.TORCH.create(block1, textureMapping, blockModelGenerator.modelOutput);
        ResourceLocation resourceLocation2 = ModelTemplates.TORCH.createWithSuffix(block1, "_off", textureMapping2, blockModelGenerator.modelOutput);
        blockModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block1).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, resourceLocation, resourceLocation2)));
        ResourceLocation resourceLocation3 = ModelTemplates.WALL_TORCH.create(block2, textureMapping, blockModelGenerator.modelOutput);
        ResourceLocation resourceLocation4 = ModelTemplates.WALL_TORCH.createWithSuffix(block2, "_off", textureMapping2, blockModelGenerator.modelOutput);
        blockModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block2).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, resourceLocation3, resourceLocation4)).with(BlockModelGenerators.createTorchHorizontalDispatch()));
        blockModelGenerator.createSimpleFlatItemModel(block1);
        blockModelGenerator.skipAutoItemBlock(block2);
    }

    private void createIronBars(BlockModelGenerators blockModelGenerator, Block block) {
        ResourceLocation resourceLocation = ModelLocationUtils.getModelLocation(block, "_post_ends");
        ResourceLocation resourceLocation2 = ModelLocationUtils.getModelLocation(block, "_post");
        ResourceLocation resourceLocation3 = ModelLocationUtils.getModelLocation(block, "_cap");
        ResourceLocation resourceLocation4 = ModelLocationUtils.getModelLocation(block, "_cap_alt");
        ResourceLocation resourceLocation5 = ModelLocationUtils.getModelLocation(block, "_side");
        ResourceLocation resourceLocation6 = ModelLocationUtils.getModelLocation(block, "_side_alt");
        blockModelGenerator.blockStateOutput.accept(MultiPartGenerator.multiPart(block).with(Variant.variant().with(VariantProperties.MODEL, resourceLocation)).with(Condition.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, false).term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, false), Variant.variant().with(VariantProperties.MODEL, resourceLocation2)).with(Condition.condition().term(BlockStateProperties.NORTH, true).term(BlockStateProperties.EAST, false).term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, false), Variant.variant().with(VariantProperties.MODEL, resourceLocation3)).with(Condition.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, true).term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, false), Variant.variant().with(VariantProperties.MODEL, resourceLocation3).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, false).term(BlockStateProperties.SOUTH, true).term(BlockStateProperties.WEST, false), Variant.variant().with(VariantProperties.MODEL, resourceLocation4)).with(Condition.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, false).term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, true), Variant.variant().with(VariantProperties.MODEL, resourceLocation4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(BlockStateProperties.NORTH, true), Variant.variant().with(VariantProperties.MODEL, resourceLocation5)).with(Condition.condition().term(BlockStateProperties.EAST, true), Variant.variant().with(VariantProperties.MODEL, resourceLocation5).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(BlockStateProperties.SOUTH, true), Variant.variant().with(VariantProperties.MODEL, resourceLocation6)).with(Condition.condition().term(BlockStateProperties.WEST, true), Variant.variant().with(VariantProperties.MODEL, resourceLocation6).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)));
        blockModelGenerator.createSimpleFlatItemModel(block);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
    }
}
