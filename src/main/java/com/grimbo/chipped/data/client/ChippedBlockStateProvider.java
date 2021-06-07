package com.grimbo.chipped.data.client;

import java.util.ArrayList;
import java.util.Collection;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.Direction;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ChippedBlockStateProvider extends BlockStateProvider {

	public ChippedBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, Chipped.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		for (String type : ChippedBlocks.stones18) {
			createCubeFromList(ChippedBlocks.blocksMap.get(type));
		}
		
		createCubeFromList(ChippedBlocks.blocksMap.get("gilded_blackstone"));
		createCubeFromList(ChippedBlocks.blocksMap.get("blackstone"));
		createCubeFromList(ChippedBlocks.blocksMap.get("basalt"));
		createCubeFromList(ChippedBlocks.blocksMap.get("obsidian"));
		createCubeFromList(ChippedBlocks.blocksMap.get("crying_obsidian"));
		createCubeFromList(ChippedBlocks.blocksMap.get("clay"));
		createCubeFromList(ChippedBlocks.blocksMap.get("glass"));
		createCubeFromList(ChippedBlocks.blocksMap.get("glowstone"));
		createCubeFromList(ChippedBlocks.blocksMap.get("sea_lantern"));
		createCubeFromList(ChippedBlocks.blocksMap.get("shroomlight"));
		
		registerGlassPanes("glass_pane", "glass", "glass_pane_1_top", 1, 6);
		registerGlassPanes("glass_pane", "glass", "glass_pane_2_top", 7, 14);
		
		for (String color : ChippedBlocks.colorsList) {
			createCubeFromList(ChippedBlocks.blocksMap.get(color + "_terracotta"));
			createCubeFromList(ChippedBlocks.blocksMap.get(color + "_concrete"));
			createCubeFromList(ChippedBlocks.blocksMap.get(color + "_wool"));
			createCubeFromList(ChippedBlocks.blocksMap.get(color + "_stained_glass"));
			
			for (int i = 1; i <= ChippedBlocks.blocksMap.get(color + "_carpet").size(); i++) {
				ArrayList<RegistryObject<Block>> blocks = new ArrayList<RegistryObject<Block>>(ChippedBlocks.blocksMap.get(color + "_carpet"));
				String name = color + "_carpet_" + i;
				String name2 = color + "_wool_" + i;
				simpleBlock(blocks.get(i - 1).get(), models().carpet(name, modLoc("block/" + name2)));
			}
			
			registerGlassPanes(color + "_stained_glass_pane", color + "_stained_glass", "glass_pane_2_top");
		}
		
		for (String wood : ChippedBlocks.woodsList) {
			createCubeFromList(ChippedBlocks.blocksMap.get(wood + "_wood_glass"));
			createCubeFromList(ChippedBlocks.blocksMap.get(wood + "_planks"));
			
			registerGlassPanes(wood + "_wood_glass_pane", wood + "_wood_glass", wood + "_wood_glass_pane_top");
		}
		
		for (RegistryObject<Block> block : ChippedBlocks.blocksMap.get("hay_block")) {
			axisBlock((RotatedPillarBlock) block.get());
		}
		
		for (RegistryObject<Block> block : ChippedBlocks.blocksMap.get("melon")) {
			String name = block.get().getRegistryName().getPath();
			simpleBlock(block.get(), models().cubeColumn(name, modLoc("block/" + name + "_side"), modLoc("block/" + name + "_top")));
		}


		registerRedstoneTorch("redstone_torch");
		registerRedstoneTorchWall("redstone_wall_torch");

	}

	private void createCubeFromList(Collection<RegistryObject<Block>> list) {
		for (RegistryObject<Block> block : list) {
			simpleBlock(block.get());
		}
	}
	
	private void registerGlassPanes(String type, String originalType, String topName, int start, int end) {
		for (int i = start; i <= end; i++) {
			ArrayList<RegistryObject<Block>> blocks = new ArrayList<RegistryObject<Block>>(ChippedBlocks.blocksMap.get(type));
			String block = type + "_" + i;
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

	private void registerRedstoneTorch(String type) {
		ArrayList<RegistryObject<Block>> torches = new ArrayList<RegistryObject<Block>>(ChippedBlocks.blocksMap.get(type));
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



	private void registerRedstoneTorchWall(String type) {
		ArrayList<RegistryObject<Block>> torches = new ArrayList<RegistryObject<Block>>(ChippedBlocks.blocksMap.get(type));
		for (int i = 2; i <= torches.size() + 1; i++) {
			for(Direction dir : RedstoneWallTorchBlock.FACING.getPossibleValues()) {
				int angle = Chipped.getAngleFromDir(dir);
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

	
	private void registerGlassPanes(String type, String originalType, String topName) {
		registerGlassPanes(type, originalType, topName, 1, ChippedBlocks.blocksMap.get(type).size());
	}
}