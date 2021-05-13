package com.grimbo.chipped.data;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.ChippedTags;
import com.grimbo.chipped.data.client.*;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Chipped.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChippedDataGenerator {

	/*
	 * To add a new recipe for generic blocks
	 * 1. Generate each block in data.client.ChippedBlockStateProvider::register
	 * 2. Register the tags based off of a list or manually in ChippedTags
	 * 3. Generate each tag in ChippedBlockTagsProvider::register
	 * 4. Generate each recipe in ChippedRecipeProvider::registerRecipes
	 */

	@SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
		ChippedTags.register();
		
		DataGenerator generate = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		
		generate.addProvider(new ChippedBlockStateProvider(generate, existingFileHelper));
		generate.addProvider(new ChippedItemModelProvider(generate, existingFileHelper));
		
		ChippedBlockTagsProvider blockTags = new ChippedBlockTagsProvider(generate, existingFileHelper);
		generate.addProvider(blockTags);
		generate.addProvider(new ChippedItemTagsProvider(generate, blockTags, existingFileHelper));
		
		generate.addProvider(new ChippedLootTableProvider(generate));
		generate.addProvider(new ChippedRecipeProvider(generate));

	}	
}