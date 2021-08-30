package com.grimbo.chipped.data.client;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.api.ChippedBlockType;
import com.grimbo.chipped.api.ChippedWoodType;
import com.grimbo.chipped.block.ChippedBlockTypes;
import com.grimbo.chipped.block.ChippedBlocks;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.DyeColor;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

import java.util.List;
import java.util.stream.Collectors;

public class ChippedBlockStateProvider extends BlockStateProvider {
    public ChippedBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Chipped.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (ChippedBlockType<Block> type : ChippedBlocks.stones18) {
            createCubeFromList(type.getBlocks());
        }

        createCubeFromList(ChippedBlockTypes.STONE.getBlocks());
        createCubeFromList(ChippedBlockTypes.COBBLESTONE.getBlocks());
        createCubeFromList(ChippedBlockTypes.END_STONE.getBlocks());
        createCubeFromList(ChippedBlockTypes.NETHERRACK.getBlocks());

        createCubeFromList(ChippedBlockTypes.GILDED_BLACKSTONES.getBlocks());
        createCubeFromList(ChippedBlockTypes.BLACKSTONES.getBlocks());
        createCubeFromList(ChippedBlockTypes.BASALTS.getBlocks());
        createCubeFromList(ChippedBlockTypes.OBSIDIAN.getBlocks());
        createCubeFromList(ChippedBlockTypes.CRYING_OBSIDIAN.getBlocks());
        createCubeFromList(ChippedBlockTypes.CLAYS.getBlocks());
        createCubeFromList(ChippedBlockTypes.GLASSES.getBlocks());
        createCubeFromList(ChippedBlockTypes.GLOWSTONES.getBlocks());
        createCubeFromList(ChippedBlockTypes.SEA_LANTERNS.getBlocks());
        createCubeFromList(ChippedBlockTypes.SHROOMLIGHTS.getBlocks());
        createCubeFromList(ChippedBlockTypes.BROWN_MUSHROOMS.getBlocks());

        registerGlassPanes(ChippedBlockTypes.GLASS_PANES, "glass", "glass_pane_1_top", 1, 6);
        registerGlassPanes(ChippedBlockTypes.GLASS_PANES, "glass", "glass_pane_2_top", 7, 14);

        for (int id = 0; id < 16; id++) {
            DyeColor color = DyeColor.byId(id);
            createCubeFromList(ChippedBlockTypes.TERRACOTTAS.get(color).getBlocks());
            createCubeFromList(ChippedBlockTypes.CONCRETES.get(color).getBlocks());
            createCubeFromList(ChippedBlockTypes.WOOL.get(color).getBlocks());
            createCubeFromList(ChippedBlockTypes.STAINED_GLASSES.get(color).getBlocks());

            List<RegistryObject<CarpetBlock>> blocks = ChippedBlockTypes.CARPETS.get(color).getBlocks();
            for (int i = 0; i < blocks.size(); ++i) {
                int n = i + 1;
                simpleBlock(blocks.get(i).get(), models().carpet(color + "_carpet_" + n, modLoc("block/" + color + "_wool_" + n)));
            }

            ChippedBlockType<StainedGlassPaneBlock> stainedGlassPanes = ChippedBlockTypes.STAINED_GLASS_PANES.get(color);
            registerGlassPanes(
                    stainedGlassPanes,
                    color + "_stained_glass",
                    "glass_pane_2_top",
                    1,
                    stainedGlassPanes.getBlocks().size()
            );
        }

        for (ChippedWoodType wood : ChippedWoodType.VALUES) {
            createCubeFromList(ChippedBlockTypes.PLANKS.get(wood).getBlocks());

            registerGlassPanes(ChippedBlockTypes.GLASS_PANES, wood + "_wood_glass_pane", wood + "_wood_glass", wood + "_wood_glass_pane_top", 1, 6);
        }

        for (RegistryObject<HayBlock> block : ChippedBlockTypes.HAY_BLOCKS.getBlocks()) {
            axisBlock(block.get());
        }

        for (RegistryObject<MelonBlock> block : ChippedBlockTypes.MELONS.getBlocks()) {
            String name = block.getId().getPath();
            simpleBlock(block.get(), models().cubeColumn(name, modLoc("block/" + name + "_side"), modLoc("block/" + name + "_top")));
        }
        for (RegistryObject<PumpkinBlock> block : ChippedBlockTypes.PUMPKINS.getBlocks()) {
            String name = block.getId().getPath();
            simpleBlock(block.get(), models().cubeColumn(name, modLoc("block/" + name + "_side"), modLoc("block/" + name + "_top")));
        }

        for (RegistryObject<Block> block : ChippedBlockTypes.LANTERNS) {
            if (block.get() instanceof LanternBlock) {
                getVariantBuilder(block.get())
                        .partialState()
                        .with(LanternBlock.HANGING, false)
                        .modelForState()
                        .modelFile(models().getExistingFile(new ResourceLocation(Chipped.MOD_ID, "block/lanterns/" + block.getId().getPath())))
                        .addModel();
                getVariantBuilder(block.get())
                        .partialState()
                        .with(LanternBlock.HANGING, true)
                        .modelForState()
                        .modelFile(models().getExistingFile(new ResourceLocation(Chipped.MOD_ID, "block/lanterns/" + block.getId().getPath() + "_hanging")))
                        .addModel();
            }
        }

        for (RegistryObject<Block> block : ChippedBlockTypes.SOUL_LANTERNS) {
            if (block.get() instanceof LanternBlock) {
                String name = block.getId().getPath();
                getVariantBuilder(block.get())
                        .partialState()
                        .with(LanternBlock.HANGING, false)
                        .modelForState()
                        .modelFile(models().getExistingFile(new ResourceLocation(Chipped.MOD_ID, "block/lanterns/" + name)))
                        .addModel();
                getVariantBuilder(block.get())
                        .partialState()
                        .with(LanternBlock.HANGING, true)
                        .modelForState()
                        .modelFile(models().getExistingFile(new ResourceLocation(Chipped.MOD_ID, "block/lanterns/" + name + "_hanging")))
                        .addModel();
            }
        }
        List<RegistryObject<RedstoneLampBlock>> redstoneLampBlocks = ChippedBlockTypes.REDSTONE_LAMPS.getBlocks();
        for (int i = 1; i <= 18; i++) {
            Block lamp = redstoneLampBlocks.get(i - 1).get();
            getVariantBuilder(lamp)
                    .partialState()
                    .with(RedstoneLampBlock.LIT, false)
                    .modelForState()
                    .modelFile(models().cubeAll("redstone_lamp_" + i, modLoc("block/redstone_lamp_off_" + i)))
                    .addModel();
            getVariantBuilder(lamp)
                    .partialState()
                    .with(RedstoneLampBlock.LIT, true)
                    .modelForState()
                    .modelFile(models().cubeAll("redstone_lamp_on_" + i, modLoc("block/redstone_lamp_on_" + i)))
                    .addModel();
        }

        List<RegistryObject<TorchBlock>> torches = ChippedBlockTypes.TORCHES.getBlocks();
        List<RegistryObject<WallTorchBlock>> wallTorches = ChippedBlocks.WALL_TORCHES;

        for (int i = 1; i <= 9; i++) {
            RegistryObject<TorchBlock> torchBlock = torches.get(i - 1);
            simpleBlock(torchBlock.get(), models().torch(torchBlock.getId().getPath(), modLoc("block/torch_" + i)));
            Block wallTorchBlock = wallTorches.get(i - 1).get();
            for (Direction dir : RedstoneWallTorchBlock.FACING.getPossibleValues()) {
                int angle = Chipped.getTorchAngleFromDir(dir);
                getVariantBuilder(wallTorchBlock)
                        .partialState()
                        .with(RedstoneWallTorchBlock.FACING, dir)
                        .modelForState()
                        .modelFile(models().torchWall("wall_torch_" + i, modLoc("block/torch_" + i)))
                        .rotationY(angle)
                        .addModel();
            }
        }

        List<RegistryObject<CarvedPumpkinBlock>> vanillaCarved = ChippedBlocks.VANILLA_CARVED_PUMPKINS;
        for (int i = 0; i < ChippedBlocks.carvedPumpkinList.length * 2; i++) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                String carvedBlockName = vanillaCarved.get(i).getId().getPath();
                String carvedSubstring = carvedBlockName.substring(0, carvedBlockName.length() - (1 + (i / 2) >= 10 ? 2 : 1));
                String blockPath = "block/" + carvedSubstring + ChippedBlocks.carvedPumpkinList[(i / 2) % ChippedBlocks.carvedPumpkinList.length];
                getVariantBuilder(vanillaCarved.get(i).get())
                        .partialState()
                        .with(CarvedPumpkinBlock.FACING, direction)
                        .modelForState()
                        .modelFile(models().orientable(carvedBlockName, mcLoc("block/pumpkin_side"), modLoc(blockPath), mcLoc("block/pumpkin_top")))
                        .rotationY(Chipped.getAngleFromDir(direction))
                        .addModel();
            }
        }

        List<RegistryObject<CarvedPumpkinBlock>> specialCarved = ChippedBlocks.SPECIAL_CARVED_PUMPKINS;
        List<RegistryObject<PumpkinBlock>> specialPumpkins = ChippedBlockTypes.PUMPKINS.getBlocks();

        for (int i = 0; i < ChippedBlocks.specialPumpkinList.length * 2; i += 2) {
            registerSpecialPumpkins(specialCarved, specialPumpkins, i);
        }

        for (int i = 1; i < ChippedBlocks.specialPumpkinList.length * 2; i += 2) {
            registerSpecialPumpkins(specialCarved, specialPumpkins, i);
        }

        registerRedstoneTorches();
        registerRedstoneTorchWall();
    }

    private <T extends Block> void createCubeFromList(List<RegistryObject<T>> list) {
        for (RegistryObject<T> block : list) {
            simpleBlock(block.get());
        }
    }

    private <T extends Block> void registerGlassPanes(ChippedBlockType<T> type, String originalType, String topName, int start, int end) {
        registerGlassPanes(type, type.getId(), originalType, topName, start, end);
    }

    private <T extends Block> void registerGlassPanes(ChippedBlockType<T> type, String glassPaneName, String originalType, String topName, int start, int end) {
        List<RegistryObject<T>> blocks = type.getBlocks().stream().filter(t -> t.getId().getPath().startsWith(glassPaneName)).collect(Collectors.toList());
        for (int i = start; i <= end; i++) {
            String block = glassPaneName + "_" + i;
            String originalBlock = originalType + "_" + i;
            getMultipartBuilder(blocks.get(i - 1).get())
                    .part()
                    .modelFile(models().panePost(block + "_post", modLoc("block/" + originalBlock), modLoc("block/" + topName)))
                    .addModel();
            getMultipartBuilder(blocks.get(i - 1).get())
                    .part()
                    .modelFile(models().paneSide(block + "_side", modLoc("block/" + originalBlock), modLoc("block/" + topName)))
                    .addModel()
                    .condition(FourWayBlock.NORTH, true);
            getMultipartBuilder(blocks.get(i - 1).get())
                    .part()
                    .modelFile(models().paneSide(block + "_side", modLoc("block/" + originalBlock), modLoc("block/" + topName)))
                    .rotationY(90)
                    .addModel()
                    .condition(FourWayBlock.EAST, true);
            getMultipartBuilder(blocks.get(i - 1).get())
                    .part()
                    .modelFile(models().paneSideAlt(block + "_side_alt", modLoc("block/" + originalBlock), modLoc("block/" + topName)))
                    .addModel()
                    .condition(FourWayBlock.SOUTH, true);
            getMultipartBuilder(blocks.get(i - 1).get())
                    .part()
                    .modelFile(models().paneSideAlt(block + "_side_alt", modLoc("block/" + originalBlock), modLoc("block/" + originalBlock)))
                    .rotationY(90)
                    .addModel()
                    .condition(FourWayBlock.WEST, true);
            getMultipartBuilder(blocks.get(i - 1).get())
                    .part()
                    .modelFile(models().paneNoSide(block + "_noside", modLoc("block/" + originalBlock)))
                    .addModel()
                    .condition(FourWayBlock.NORTH, false);
            getMultipartBuilder(blocks.get(i - 1).get())
                    .part()
                    .modelFile(models().paneNoSideAlt(block + "_noside_alt", modLoc("block/" + originalBlock)))
                    .addModel()
                    .condition(FourWayBlock.EAST, false);
            getMultipartBuilder(blocks.get(i - 1).get())
                    .part()
                    .modelFile(models().paneNoSideAlt(block + "_noside_alt", modLoc("block/" + originalBlock)))
                    .rotationY(90)
                    .addModel()
                    .condition(FourWayBlock.SOUTH, false);
            getMultipartBuilder(blocks.get(i - 1).get())
                    .part()
                    .modelFile(models().paneNoSide(block + "_noside", modLoc("block/" + originalBlock)))
                    .rotationY(270)
                    .addModel()
                    .condition(FourWayBlock.WEST, false);
        }
    }

    private void registerRedstoneTorches() {
        List<RegistryObject<RedstoneTorchBlock>> torches = ChippedBlockTypes.REDSTONE_TORCHES.getBlocks();
        for (int i = 2; i <= torches.size() + 1; i++) {
            getVariantBuilder(torches.get(i - 2).get())
                    .partialState()
                    .with(RedstoneTorchBlock.LIT, false)
                    .modelForState()
                    .modelFile(models().torch("redstone_torch_" + i + "_off", modLoc("block/redstone_torch_" + i + "_off")))
                    .addModel()
                    .partialState()
                    .with(RedstoneTorchBlock.LIT, true)
                    .modelForState()
                    .modelFile(models().torch("redstone_torch_" + i, modLoc("block/redstone_torch_" + i)))
                    .addModel();
        }
    }

    private void registerRedstoneTorchWall() {
        List<RegistryObject<RedstoneWallTorchBlock>> torches = ChippedBlocks.REDSTONE_WALL_TORCHES;
        for (int i = 2; i <= torches.size() + 1; i++) {
            for (Direction dir : RedstoneWallTorchBlock.FACING.getPossibleValues()) {
                int angle = Chipped.getTorchAngleFromDir(dir);
                getVariantBuilder(torches.get(i - 2).get())
                        .partialState()
                        .with(RedstoneWallTorchBlock.FACING, dir)
                        .with(RedstoneTorchBlock.LIT, true)
                        .modelForState()
                        .modelFile(models().torchWall("redstone_wall_torch_" + i, modLoc("block/redstone_torch_" + i)))
                        .rotationY(angle)
                        .addModel()
                        .partialState()
                        .with(RedstoneWallTorchBlock.FACING, dir)
                        .with(RedstoneWallTorchBlock.LIT, false)
                        .modelForState()
                        .modelFile(models().torchWall("redstone_wall_torch_" + i + "_off", modLoc("block/redstone_torch_" + i + "_off")))
                        .rotationY(angle)
                        .addModel();
            }
        }
    }

    private void registerSpecialPumpkins(List<RegistryObject<CarvedPumpkinBlock>> specialCarved, List<RegistryObject<PumpkinBlock>> specialPumpkins, int index) {
        String carvedBlockName = specialCarved.get(index).getId().getPath();
        String pumpkinName = specialPumpkins.get(index / 2).getId().getPath();
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            //Carved Pumpkin
            getVariantBuilder(specialCarved.get(index).get())
                    .partialState()
                    .with(CarvedPumpkinBlock.FACING, direction)
                    .modelForState()
                    .modelFile(models().orientable(carvedBlockName, modLoc("block/" + pumpkinName + "_side"), modLoc("block/" + carvedBlockName), modLoc("block/" + pumpkinName + "_top")))
                    .rotationY(Chipped.getAngleFromDir(direction))
                    .addModel();
        }
    }
}
