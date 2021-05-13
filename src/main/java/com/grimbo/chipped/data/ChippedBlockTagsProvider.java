package com.grimbo.chipped.data;

import java.util.ArrayList;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.ChippedTags;
import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class ChippedBlockTagsProvider extends BlockTagsProvider {

	public ChippedBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
		super(generatorIn, Chipped.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerTags() {
		createFromList(ChippedBlocks.stones);
		createFromList(ChippedBlocks.wools);
		createFromList(ChippedBlocks.carpets);
		createFromList(ChippedBlocks.glasses);
		createFromList(ChippedBlocks.stainedGlasses);
		createFromList(ChippedBlocks.hayBlock);
		createFromList(ChippedBlocks.clays);
		createFromList(ChippedBlocks.terracottas);
		createFromList(ChippedBlocks.concretes);
		createFromList(ChippedBlocks.woods);
		
		getOrCreateBuilder(ChippedTags.blocks.get("vine")).add(Blocks.VINE);
		getOrCreateBuilder(ChippedTags.blocks.get("vine")).add(ChippedBlocks.VINE_1.get());
	}
	
	private void createFromList(ArrayList<RegistryObject<Block>> list) {
		String previousName = "";
		for (RegistryObject<Block> block : list) {
			String name = block.get().getRegistryName().getPath().split("_([1-9])")[0];
			if (!previousName.equals(name)) {
				getOrCreateBuilder(ChippedTags.blocks.get(name)).add(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft:" + name)));
			}
			getOrCreateBuilder(ChippedTags.blocks.get(name)).add(block.get());
			previousName = name;
		}
	}
}
