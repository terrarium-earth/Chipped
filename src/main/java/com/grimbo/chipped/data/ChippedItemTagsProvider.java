package com.grimbo.chipped.data;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.ChippedTags;
import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ChippedItemTagsProvider extends ItemTagsProvider {

	public ChippedItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider,
			ExistingFileHelper existingFileHelper) {
		super(dataGenerator, blockTagProvider, Chipped.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		for (String key : ChippedTags.blocks.keySet()) {
			copy(ChippedTags.blocks.get(key), ChippedTags.items.get(key));
		}
		
		//Default Vanilla tags
		for (String wood : ChippedBlocks.woodsList) {
			tag(ChippedTags.Items.PLANKS).addTag(ChippedTags.items.get(wood + "_planks"));
		}
		
		for (String color : ChippedBlocks.colorsList) {
			tag(ChippedTags.Items.WOOL).addTag(ChippedTags.items.get(color + "_wool"));
			tag(ChippedTags.Items.CARPETS).addTag(ChippedTags.items.get(color + "_carpet"));
		}
		
		tag(ChippedTags.Items.STONE_CRAFTING_MATERIALS).addTag(ChippedTags.items.get("cobblestone"));
		tag(ChippedTags.Items.STONE_CRAFTING_MATERIALS).addTag(ChippedTags.items.get("blackstone"));

		//Default Forge tags
		tag(Tags.Items.STONE).addTag(ChippedTags.items.get("stone"));
		tag(Tags.Items.COBBLESTONE).addTag(ChippedTags.items.get("cobblestone"));
		tag(Tags.Items.END_STONES).addTag(ChippedTags.items.get("end_stone"));
		tag(Tags.Items.GLASS).addTag(ChippedTags.items.get("glass"));
		tag(Tags.Items.NETHERRACK).addTag(ChippedTags.items.get("netherrack"));
		tag(Tags.Items.OBSIDIAN).addTag(ChippedTags.items.get("obsidian"));

	}
}
