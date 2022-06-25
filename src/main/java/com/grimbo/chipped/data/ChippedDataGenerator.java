package com.grimbo.chipped.data;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.data.client.*;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Chipped.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChippedDataGenerator {

	/*
	 * To make generated data for generic blocks:
	 * 1. Generate each block in data.client.ChippedBlockStateProvider::register
	 * 2. Generate each item in data.client.ChippedItemModelProvider::register
	 * 3. Check for vanilla/forge tags in ChippedBlockTagsProvider and ChippedItemTagsProvider
	 * 
	 * Any abnormal blocks should additionally look into:
	 * 1. ChippedTags
	 * 2. ChippedBlockLootTables
	 */
	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		DataGenerator generate = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		generate.addProvider(event.includeClient(), new ChippedBlockStateProvider(generate, existingFileHelper));
		generate.addProvider(event.includeClient(), new ChippedItemModelProvider(generate, existingFileHelper));

		ChippedBlockTagsProvider blockTags = new ChippedBlockTagsProvider(generate, existingFileHelper);
		generate.addProvider(event.includeServer(), blockTags);
		generate.addProvider(event.includeServer(), new ChippedItemTagsProvider(generate, blockTags, existingFileHelper));

		generate.addProvider(event.includeServer(), new ChippedLootTableProvider(generate));
		generate.addProvider(event.includeServer(), new ChippedRecipeProvider(generate));

		//generate.addProvider(new ChippedLanguageProvider(generate, "en_us"));
	}
}