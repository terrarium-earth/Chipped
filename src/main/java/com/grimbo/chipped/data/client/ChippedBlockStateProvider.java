package com.grimbo.chipped.data.client;

import java.util.ArrayList;
import java.util.Collection;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ChippedBlockStateProvider extends BlockStateProvider {

	public ChippedBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, Chipped.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		for (String type : ChippedBlocks.stonesList) {
			createCubeFromList(ChippedBlocks.blocksMap.get(type));
		}
		
		for (String type : ChippedBlocks.stones2List) {
			createCubeFromList(ChippedBlocks.blocksMap.get(type));
		}
		
		for (String type : ChippedBlocks.stones3List) {
			createCubeFromList(ChippedBlocks.blocksMap.get(type));
		}
		
		for (String type : ChippedBlocks.stones4List) {
			createCubeFromList(ChippedBlocks.blocksMap.get(type));
		}
		
		for (String type : ChippedBlocks.stones5List) {
			createCubeFromList(ChippedBlocks.blocksMap.get(type));
		}
		
		createCubeFromList(ChippedBlocks.blocksMap.get("gilded_blackstone"));
		createCubeFromList(ChippedBlocks.blocksMap.get("netherrack"));
		createCubeFromList(ChippedBlocks.blocksMap.get("blackstone"));
		createCubeFromList(ChippedBlocks.blocksMap.get("basalt"));
		createCubeFromList(ChippedBlocks.blocksMap.get("obsidian"));
		createCubeFromList(ChippedBlocks.blocksMap.get("crying_obsidian"));
		createCubeFromList(ChippedBlocks.blocksMap.get("clay"));
		createCubeFromList(ChippedBlocks.blocksMap.get("glass"));
		
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
		}
		
		for (String wood : ChippedBlocks.woodsList) {
			createCubeFromList(ChippedBlocks.blocksMap.get(wood + "_wood_glass"));
			createCubeFromList(ChippedBlocks.blocksMap.get(wood + "_planks"));
		}
		
		for (RegistryObject<Block> block : ChippedBlocks.blocksMap.get("hay_block")) {
			axisBlock((RotatedPillarBlock) block.get());
		}
		
		for (RegistryObject<Block> block : ChippedBlocks.blocksMap.get("melon")) {
			String name = block.get().getRegistryName().getPath();
			simpleBlock(block.get(), models().cubeColumn(name, modLoc("block/" + name + "_side"), modLoc("block/" + name + "_top")));
		}
	}

	private void createCubeFromList(Collection<RegistryObject<Block>> list) {
		for (RegistryObject<Block> block : list) {
			simpleBlock(block.get());
		}
	}
}
