package com.grimbo.chipped.data;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.api.BlockRegistry;
import com.grimbo.chipped.api.ChippedBlockType;
import com.grimbo.chipped.api.ChippedWoodType;
import com.grimbo.chipped.block.ChippedBlockTypes;

import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.DyeColor;
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
		for (ChippedBlockType<Block> type : BlockRegistry.getBlockTypes()) {
			copy(type.getBlockTag(), type.getItemTag());
		}

		//Default Vanilla tags
		for (ChippedWoodType wood : ChippedWoodType.VALUES) {
			tag(ItemTags.PLANKS).addTag(ChippedBlockTypes.PLANKS.get(wood).getItemTag());
		}

		for (int i = 0; i < 16; i++) {
			DyeColor color = DyeColor.byId(i);
			tag(ItemTags.WOOL).addTag(ChippedBlockTypes.WOOL.get(color).getItemTag());
			tag(ItemTags.CARPETS).addTag(ChippedBlockTypes.CARPETS.get(color).getItemTag());
		}

		tag(ItemTags.STONE_CRAFTING_MATERIALS).addTag(ChippedBlockTypes.COBBLESTONE.getItemTag());
		tag(ItemTags.STONE_CRAFTING_MATERIALS).addTag(ChippedBlockTypes.BLACKSTONES.getItemTag());

		tag(ItemTags.SOUL_FIRE_BASE_BLOCKS).addTag(ChippedBlockTypes.SOUL_SANDS.getItemTag());
		tag(ItemTags.PIGLIN_REPELLENTS).addTag(ChippedBlockTypes.SOUL_LANTERNS.getItemTag());

		//Default Forge tags
		tag(Tags.Items.STONE).addTag(ChippedBlockTypes.STONE.getItemTag());
		tag(Tags.Items.COBBLESTONE).addTag(ChippedBlockTypes.COBBLESTONE.getItemTag());
		tag(Tags.Items.END_STONES).addTag(ChippedBlockTypes.END_STONE.getItemTag());
		tag(Tags.Items.GLASS).addTag(ChippedBlockTypes.GLASSES.getItemTag());
		tag(Tags.Items.NETHERRACK).addTag(ChippedBlockTypes.NETHERRACK.getItemTag());
		tag(Tags.Items.OBSIDIAN).addTag(ChippedBlockTypes.OBSIDIAN.getItemTag());
	}
}
