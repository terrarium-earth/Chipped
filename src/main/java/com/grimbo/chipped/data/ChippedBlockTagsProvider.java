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

	//TODO: Give the blocks the same tags as vanilla so they can function in crafting
	@Override
	protected void addTags() {
		tagFromList(ChippedBlocks.stones);
		tagFromList(ChippedBlocks.wools);
		tagFromList(ChippedBlocks.carpets);
		tagFromList(ChippedBlocks.glasses, "glass");
		tagFromList(ChippedBlocks.stainedGlasses);
		tagFromList(ChippedBlocks.hayBlock);
		tagFromList(ChippedBlocks.clays);
		tagFromList(ChippedBlocks.terracottas);
		tagFromList(ChippedBlocks.concretes);
		tagFromList(ChippedBlocks.woods);
		tagFromList(ChippedBlocks.melons);
		tagFromList(ChippedBlocks.vines);
	}

	private void tagFromList(ArrayList<RegistryObject<Block>> list) {
		String previousName = "";
		for (RegistryObject<Block> block : list) {
			String name = block.get().getRegistryName().getPath().split("_([1-9])")[0];
			if (!previousName.equals(name)) {
				tag(ChippedTags.blocks.get(name)).add(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft:" + name)));
			}
			tag(ChippedTags.blocks.get(name)).add(block.get());
			previousName = name;
		}
	}
	
	private void tagFromList(ArrayList<RegistryObject<Block>> list, String defaultBlock) {
		String previousName = "";
		for (RegistryObject<Block> block : list) {
			String name = block.get().getRegistryName().getPath().split("_([1-9])")[0];
			if (!previousName.equals(name)) {
				tag(ChippedTags.blocks.get(name)).add(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft:" + defaultBlock)));
			}
			tag(ChippedTags.blocks.get(name)).add(block.get());
			previousName = name;
		}
	}
}
