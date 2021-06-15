package com.grimbo.chipped;

import java.util.Hashtable;

import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class ChippedTags {

	public static Hashtable<String, ITag.INamedTag<Block>> blocks = new Hashtable<>();
	public static Hashtable<String, ITag.INamedTag<Item>> items = new Hashtable<>();

	public static void register() {
		for (String type : ChippedBlocks.blocksMap.keySet()) {
			blocks.put(type, Blocks.mod(type));
			items.put(type, Items.mod(type));
		}
	}

	public static class Blocks {

		public static final ITag.INamedTag<Block> PLANKS = vanilla("planks");
		public static final ITag.INamedTag<Block> WOOL = vanilla("wool");
		public static final ITag.INamedTag<Block> CARPETS = vanilla("carpets");
		
		public static final ITag.INamedTag<Block> DRAGON_IMMUNE = vanilla("dragon_immune");
		public static final ITag.INamedTag<Block> CLIMBABLE = vanilla("climbable");
		public static final ITag.INamedTag<Block> WALL_POST_OVERRIDE = vanilla("wall_post_override");
		
		private static ITag.INamedTag<Block> vanilla(String id) {
			return BlockTags.bind("minecraft:" + id);
		}
		
		private static ITag.INamedTag<Block> forge(String id) {
			return BlockTags.bind("forge:" + id);
		}

		private static ITag.INamedTag<Block> mod(String id) {
			return BlockTags.bind(Chipped.MOD_ID + ":" + id);
		}
	}

	public static class Items {

		public static final ITag.INamedTag<Item> PLANKS = vanilla("planks");
		public static final ITag.INamedTag<Item> WOOL = vanilla("wool");
		public static final ITag.INamedTag<Item> CARPETS = vanilla("carpets");
		
		public static final ITag.INamedTag<Item> STONE_CRAFTING_MATERIALS = vanilla("stone_crafting_materials");
		
		private static ITag.INamedTag<Item> vanilla(String id) {
			return ItemTags.bind("minecraft:" + id);
		}
		
		private static ITag.INamedTag<Item> forge(String id) {
			return ItemTags.bind("forge:" + id);
		}

		private static ITag.INamedTag<Item> mod(String id) {
			return ItemTags.bind(Chipped.MOD_ID + ":" + id);
		}
	}
}
