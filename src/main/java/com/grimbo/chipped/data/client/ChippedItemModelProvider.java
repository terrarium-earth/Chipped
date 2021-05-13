package com.grimbo.chipped.data.client;

import java.util.ArrayList;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ChippedItemModelProvider extends ItemModelProvider {

	public ChippedItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Chipped.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		createFromList(ChippedBlocks.stones);
		createFromList(ChippedBlocks.wools);
		createFromList(ChippedBlocks.carpets);
		createFromList(ChippedBlocks.glasses);
		createFromList(ChippedBlocks.stainedGlasses);
		createFromList(ChippedBlocks.hayBlock);
		createFromList(ChippedBlocks.clays);
		createFromList(ChippedBlocks.terracottas);
		createFromList(ChippedBlocks.concretes);
	}
	
	private void createFromList(ArrayList<RegistryObject<Block>> list) {
		for (RegistryObject<Block> block : list) {
			String name = block.get().getRegistryName().getPath();
			withExistingParent(name, modLoc("block/" + name));
		}
	}
}
