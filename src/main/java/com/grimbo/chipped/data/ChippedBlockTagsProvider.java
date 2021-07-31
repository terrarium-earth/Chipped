package com.grimbo.chipped.data;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.ChippedTags;
import com.grimbo.chipped.api.BlockRegistry;
import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.stream.Collectors;

public class ChippedBlockTagsProvider extends BlockTagsProvider {

	public ChippedBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
		super(generatorIn, Chipped.MOD_ID, existingFileHelper);
	}

	//TODO: Give the blocks the same tags as vanilla so they can function in crafting
	@Override
	protected void addTags() {
		//All blocks with a vanilla variant

		BlockRegistry.getBlockMap().asMap().forEach((type, blocks) -> {
			Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(type));
			if (block != null && !block.equals(Blocks.AIR)) {
				tag(ChippedTags.tags.get(type).getFirst()).add(block);
				tag(ChippedTags.tags.get(type).getFirst()).add(blocks.stream().map(RegistryObject::get).toArray(Block[]::new));
			}
		});
		
		//Default Vanilla tags
		for (String wood : ChippedBlocks.woodsList) {
			tag(BlockTags.PLANKS).addTag(ChippedTags.tags.get(wood + "_planks").getFirst());
		}
		
		for (String color : ChippedBlocks.colorsList) {
			tag(BlockTags.WOOL).addTag(ChippedTags.tags.get(color + "_wool").getFirst());
			tag(BlockTags.CARPETS).addTag(ChippedTags.tags.get(color + "_carpet").getFirst());
		}

		tag(BlockTags.DRAGON_IMMUNE).addTag(ChippedTags.tags.get("obsidian").getFirst());
		tag(BlockTags.DRAGON_IMMUNE).addTag(ChippedTags.tags.get("crying_obsidian").getFirst());
		
		tag(BlockTags.CLIMBABLE).addTag(ChippedTags.tags.get("vine").getFirst());
		
		tag(BlockTags.WALL_POST_OVERRIDE).addTag(ChippedTags.tags.get("torch").getFirst());
		tag(BlockTags.WALL_POST_OVERRIDE).addTag(ChippedTags.tags.get("redstone_torch").getFirst());
		
		//Default Forge tags
		tag(Tags.Blocks.STONE).addTag(ChippedTags.tags.get("stone").getFirst());
		tag(Tags.Blocks.COBBLESTONE).addTag(ChippedTags.tags.get("cobblestone").getFirst());
		tag(Tags.Blocks.END_STONES).addTag(ChippedTags.tags.get("end_stone").getFirst());
		tag(Tags.Blocks.GLASS).addTag(ChippedTags.tags.get("glass").getFirst());
		tag(Tags.Blocks.NETHERRACK).addTag(ChippedTags.tags.get("netherrack").getFirst());
		tag(Tags.Blocks.OBSIDIAN).addTag(ChippedTags.tags.get("obsidian").getFirst());
	}
}
