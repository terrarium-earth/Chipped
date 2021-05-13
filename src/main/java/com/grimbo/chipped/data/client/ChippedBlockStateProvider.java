package com.grimbo.chipped.data.client;

import java.util.ArrayList;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.data.DataGenerator;
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
		createCubeFromList(ChippedBlocks.stones);
		createCubeFromList(ChippedBlocks.wools);
		createCubeFromList(ChippedBlocks.glasses);
		createCubeFromList(ChippedBlocks.stainedGlasses);
		createCubeFromList(ChippedBlocks.clays);
		createCubeFromList(ChippedBlocks.terracottas);
		createCubeFromList(ChippedBlocks.concretes);
		
		for (int i = 0; i < ChippedBlocks.carpets.size(); i++) {
			Block block = ChippedBlocks.carpets.get(i).get();
			String name = block.getRegistryName().getPath();
			String name2 = ChippedBlocks.wools.get(i).get().getRegistryName().getPath();
			getVariantBuilder(block).partialState()
			.setModels(new ConfiguredModel(models().carpet(name, modLoc("block/" + name2))));
		}
		for (RegistryObject<Block> block : ChippedBlocks.hayBlock) {
			axisBlock((RotatedPillarBlock) block.get());	
		}
	}
	
	private void createCubeFromList(ArrayList<RegistryObject<Block>> list) {
		for (RegistryObject<Block> block : list) {
			simpleBlock(block.get());	
		}
	}

}
