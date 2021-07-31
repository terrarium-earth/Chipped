package com.grimbo.chipped.data;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.ChippedTags;
import com.grimbo.chipped.block.ChippedBlocks;

import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ChippedItemTagsProvider extends ItemTagsProvider {

	public ChippedItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider,
			ExistingFileHelper existingFileHelper) {
		super(dataGenerator, blockTagProvider, Chipped.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		for (Pair<ITag.INamedTag<Block>, ITag.INamedTag<Item>> tag : ChippedTags.tags.values()) {
			copy(tag.getFirst(), tag.getSecond());
		}
		
		//Default Vanilla tags
		for (String wood : ChippedBlocks.woodsList) {
			tag(ItemTags.PLANKS).addTag(ChippedTags.tags.get(wood + "_planks").getSecond());
		}
		
		for (String color : ChippedBlocks.colorsList) {
			tag(ItemTags.WOOL).addTag(ChippedTags.tags.get(color + "_wool").getSecond());
			tag(ItemTags.CARPETS).addTag(ChippedTags.tags.get(color + "_carpet").getSecond());
		}
		
		tag(ItemTags.STONE_CRAFTING_MATERIALS).addTag(ChippedTags.tags.get("cobblestone").getSecond());
		tag(ItemTags.STONE_CRAFTING_MATERIALS).addTag(ChippedTags.tags.get("blackstone").getSecond());

		//Default Forge tags
		tag(Tags.Items.STONE).addTag(ChippedTags.tags.get("stone").getSecond());
		tag(Tags.Items.COBBLESTONE).addTag(ChippedTags.tags.get("cobblestone").getSecond());
		tag(Tags.Items.END_STONES).addTag(ChippedTags.tags.get("end_stone").getSecond());
		tag(Tags.Items.GLASS).addTag(ChippedTags.tags.get("glass").getSecond());
		tag(Tags.Items.NETHERRACK).addTag(ChippedTags.tags.get("netherrack").getSecond());
		tag(Tags.Items.OBSIDIAN).addTag(ChippedTags.tags.get("obsidian").getSecond());

	}
}
