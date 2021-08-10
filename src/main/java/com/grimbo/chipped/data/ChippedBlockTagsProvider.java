package com.grimbo.chipped.data;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.api.BlockRegistry;
import com.grimbo.chipped.api.ChippedBlockType;
import com.grimbo.chipped.api.ChippedWoodType;
import com.grimbo.chipped.block.ChippedBlockTypes;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.DyeColor;
import net.minecraft.tags.BlockTags;
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
		for (ChippedBlockType<Block> type : BlockRegistry.getBlockTypes()) {
			Block vanillaBlock = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(type.getId()));
			if (vanillaBlock != null && vanillaBlock != Blocks.AIR) {
				Builder<Block> tag = tag(type.getBlockTag());
				tag.add(vanillaBlock);
				for (RegistryObject<Block> block : type.getBlocks()) {
					tag.add(block.get());
				}
			}
		}

		//Default Vanilla tags
		for (ChippedWoodType wood : ChippedWoodType.VALUES) {
			tag(BlockTags.PLANKS).addTag(ChippedBlockTypes.PLANKS.get(wood).getBlockTag());
		}

		for (int i = 0; i < 16; i++) {
			DyeColor color = DyeColor.byId(i);
			tag(BlockTags.WOOL).addTag(ChippedBlockTypes.WOOL.get(color).getBlockTag());
			tag(BlockTags.CARPETS).addTag(ChippedBlockTypes.CARPETS.get(color).getBlockTag());
		}

		tag(BlockTags.DRAGON_IMMUNE).addTag(ChippedBlockTypes.OBSIDIAN.getBlockTag());
		tag(BlockTags.DRAGON_IMMUNE).addTag(ChippedBlockTypes.CRYING_OBSIDIAN.getBlockTag());

		tag(BlockTags.CLIMBABLE).addTag(ChippedBlockTypes.VINES.getBlockTag());
		
		tag(BlockTags.WALL_POST_OVERRIDE).addTag(ChippedBlockTypes.TORCHES.getBlockTag());
		tag(BlockTags.WALL_POST_OVERRIDE).addTag(ChippedBlockTypes.REDSTONE_TORCHES.getBlockTag());
		
		//Default Forge tags
		tag(Tags.Blocks.STONE).addTag(ChippedBlockTypes.STONE.getBlockTag());
		tag(Tags.Blocks.COBBLESTONE).addTag(ChippedBlockTypes.COBBLESTONE.getBlockTag());
		tag(Tags.Blocks.END_STONES).addTag(ChippedBlockTypes.END_STONE.getBlockTag());
		tag(Tags.Blocks.GLASS).addTag(ChippedBlockTypes.GLASSES.getBlockTag());
		tag(Tags.Blocks.NETHERRACK).addTag(ChippedBlockTypes.NETHERRACK.getBlockTag());
		tag(Tags.Blocks.OBSIDIAN).addTag(ChippedBlockTypes.OBSIDIAN.getBlockTag());
	}
}
