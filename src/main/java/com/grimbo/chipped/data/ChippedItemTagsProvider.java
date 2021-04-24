package com.grimbo.chipped.data;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.ChippedTags;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ChippedItemTagsProvider extends ItemTagsProvider {

	public ChippedItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
		super(dataGenerator, blockTagProvider, Chipped.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void registerTags() {
		for (String key : ChippedTags.blocks.keySet()) {
			copy(ChippedTags.blocks.get(key), ChippedTags.items.get(key));
		}
	}
}
