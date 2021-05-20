package com.grimbo.chipped.data;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.ChippedTags;
import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
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
		//All blocks with a vanilla variant
		for (String type : ChippedBlocks.blocksMap.keys()) {
			if (ForgeRegistries.BLOCKS.containsKey(new ResourceLocation("minecraft:" + type))) {
				tag(ChippedTags.blocks.get(type)).add(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft:" + type)));
				for (RegistryObject<Block> block : ChippedBlocks.blocksMap.get(type)) {
					tag(ChippedTags.blocks.get(type)).add(block.get());
				}
			}
		}
		
		//Wood Glasses
		for (String wood : ChippedBlocks.woodsList) {
			String type = wood + "_wood_glass";
			tag(ChippedTags.blocks.get(type)).add(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft:glass")));
			for (RegistryObject<Block> block : ChippedBlocks.blocksMap.get(type)) {
				tag(ChippedTags.blocks.get(type)).add(block.get());
			}
		}
		
		//Default Vanilla tags
		for (String wood : ChippedBlocks.woodsList) {
			tag(ChippedTags.Blocks.PLANKS).addTag(ChippedTags.blocks.get(wood + "_planks"));
		}
		
		for (String color : ChippedBlocks.colorsList) {
			tag(ChippedTags.Blocks.WOOL).addTag(ChippedTags.blocks.get(color + "_wool"));
			tag(ChippedTags.Blocks.CARPETS).addTag(ChippedTags.blocks.get(color + "_carpet"));
		}

		tag(ChippedTags.Blocks.DRAGON_IMMUNE).addTag(ChippedTags.blocks.get("obsidian"));
		tag(ChippedTags.Blocks.DRAGON_IMMUNE).addTag(ChippedTags.blocks.get("crying_obsidian"));
		
		tag(ChippedTags.Blocks.CLIMBABLE).addTag(ChippedTags.blocks.get("vine"));
		
		//Default Forge tags
		tag(Tags.Blocks.STONE).addTag(ChippedTags.blocks.get("stone"));
		tag(Tags.Blocks.COBBLESTONE).addTag(ChippedTags.blocks.get("cobblestone"));
		tag(Tags.Blocks.END_STONES).addTag(ChippedTags.blocks.get("end_stone"));
		tag(Tags.Blocks.GLASS).addTag(ChippedTags.blocks.get("glass"));
		tag(Tags.Blocks.NETHERRACK).addTag(ChippedTags.blocks.get("netherrack"));
		tag(Tags.Blocks.OBSIDIAN).addTag(ChippedTags.blocks.get("obsidian"));
	}
}
