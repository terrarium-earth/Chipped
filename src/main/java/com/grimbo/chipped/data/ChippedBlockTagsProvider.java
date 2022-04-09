package com.grimbo.chipped.data;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.api.BlockRegistry;
import com.grimbo.chipped.api.ChippedBlockType;
import com.grimbo.chipped.api.ChippedWoodType;

import com.grimbo.chipped.block.ChippedBlocks;
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

import static com.grimbo.chipped.block.ChippedBlockTypes.*;

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
			tag(BlockTags.PLANKS).addTag(PLANKS.get(wood).getBlockTag());
		}

		tag(BlockTags.NON_FLAMMABLE_WOOD).addTag(PLANKS.get(ChippedWoodType.WARPED).getBlockTag());
		tag(BlockTags.NON_FLAMMABLE_WOOD).addTag(PLANKS.get(ChippedWoodType.CRIMSON).getBlockTag());

		for (int i = 0; i < 16; i++) {
			DyeColor color = DyeColor.byId(i);
			tag(BlockTags.WOOL).addTag(WOOL.get(color).getBlockTag());
			tag(BlockTags.CARPETS).addTag(CARPETS.get(color).getBlockTag());
		}

		tag(BlockTags.DRAGON_IMMUNE).addTag(OBSIDIAN.getBlockTag());
		tag(BlockTags.DRAGON_IMMUNE).addTag(CRYING_OBSIDIAN.getBlockTag());

		tag(BlockTags.CLIMBABLE).addTag(VINES.getBlockTag());
		
		tag(BlockTags.WALL_POST_OVERRIDE).addTag(TORCHES.getBlockTag());
		tag(BlockTags.WALL_POST_OVERRIDE).addTag(REDSTONE_TORCHES.getBlockTag());

		tag(BlockTags.WITHER_SUMMON_BASE_BLOCKS).addTag(SOUL_SANDS.getBlockTag());
		tag(BlockTags.SOUL_FIRE_BASE_BLOCKS).addTag(SOUL_SANDS.getBlockTag());
		tag(BlockTags.SOUL_SPEED_BLOCKS).addTag(SOUL_SANDS.getBlockTag());

		tag(BlockTags.PIGLIN_REPELLENTS).addTag(SOUL_LANTERNS.getBlockTag());
		tag(BlockTags.HOGLIN_REPELLENTS).addTag(WARPED_FUNGUS.getBlockTag());

		//Default Forge tags

		tag(Tags.Blocks.STONE)
				.addTag(ANDESITE.getBlockTag())
				.addTag(DIORITE.getBlockTag())
				.addTag(BASALT.getBlockTag())
				.addTag(MOSSY_STONE_BRICKS.getBlockTag())
				.addTag(BRICKS.getBlockTag())
				.addTag(ANCIENT_DEBRIS.getBlockTag())
				.addTag(BLUE_ICE.getBlockTag())
				.addTag(CLAYS.getBlockTag())
				.addTag(DARK_PRISMARINE.getBlockTag());

		tag(Tags.Blocks.COBBLESTONE).addTag(MOSSY_COBBLESTONE.getBlockTag()).addTag(COBBLESTONE.getBlockTag());

		tag(Tags.Blocks.END_STONES).addTag(END_STONE.getBlockTag());


		tag(Tags.Blocks.GLASS).addTag(GLASSES.getBlockTag());
		tag(Tags.Blocks.GLASS_COLORLESS).addTag(GLASSES.getBlockTag());
		tag(Tags.Blocks.GLASS_PANES).addTag(GLASS_PANES.getBlockTag());
		tag(Tags.Blocks.GLASS_PANES_COLORLESS).addTag(GLASS_PANES.getBlockTag());
		for (int id = 0; id < 16; ++id) {
			DyeColor color = DyeColor.byId(id);

			tag(Tags.Blocks.GLASS).addTag(STAINED_GLASSES.get(color).getBlockTag());
			tag(BlockTags.bind("forge:glass/" + color)).addTag(STAINED_GLASSES.get(color).getBlockTag());

			tag(Tags.Blocks.GLASS).addTag(STAINED_GLASS_PANES.get(color).getBlockTag());
			tag(BlockTags.bind("forge:glass_panes/" + color)).addTag(STAINED_GLASS_PANES.get(color).getBlockTag());

			tag(BlockTags.bind("forge:terracotta")).addTag(TERRACOTTAS.get(color).getBlockTag());
			tag(BlockTags.bind("forge:terracotta/" + color)).addTag(TERRACOTTAS.get(color).getBlockTag());
		}

		tag(Tags.Blocks.NETHERRACK).addTag(NETHERRACK.getBlockTag());

		tag(Tags.Blocks.OBSIDIAN).addTag(OBSIDIAN.getBlockTag());
	}
}
