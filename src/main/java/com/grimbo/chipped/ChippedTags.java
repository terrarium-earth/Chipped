package com.grimbo.chipped;

import java.util.ArrayList;
import java.util.Hashtable;

import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.fml.RegistryObject;

public class ChippedTags {
	
	public static Hashtable<String, ITag.INamedTag<Block>> blocks = new Hashtable<>();
	public static Hashtable<String, ITag.INamedTag<Item>> items = new Hashtable<>();
	
	//Todo: Get a proper naming convention for tags
	public static void register() {
		createFromList("stones", ChippedBlocks.stones);
		createFromList("wools", ChippedBlocks.wools);
		createFromList("carpets", ChippedBlocks.carpets);
		createFromList("glasses", ChippedBlocks.glasses);
		createFromList("stained_glasses", ChippedBlocks.stainedGlasses);
		createFromList("hay_blocks", ChippedBlocks.hayBlock);
		createFromList("clays", ChippedBlocks.clays);
		
		createFromBlock("vines", ChippedBlocks.VINE_1.get());
	}
	
	private static void createFromBlock(String type, Block block) {
		String blockName = block.getRegistryName().getPath().split("_([1-9])")[0];
		blocks.put(blockName, Blocks.forge(type + "/" + blockName));
		items.put(blockName, Items.forge(type + "/" + blockName));
	}
	
	private static void createFromList(String type, ArrayList<RegistryObject<Block>> list) {
		for (RegistryObject<Block> block : list) {
			String blockName = block.get().getRegistryName().getPath().split("_([1-9])")[0];
			blocks.put(blockName, Blocks.forge(type + "/" + blockName));
			items.put(blockName, Items.forge(type + "/" + blockName));
		}
	}
	
	private static void createFromList(String type, String[] list) {
		for (String block : list) {
			blocks.put(block, Blocks.forge(type + "/" + block));
			items.put(block, Items.forge(type + "/" + block));
		}
	}
	
	public static class Blocks {
		
		private static ITag.INamedTag<Block> forge(String id) {
			return BlockTags.makeWrapperTag("forge:" + id);
		}
		
		private static ITag.INamedTag<Block> mod(String id) {
			return BlockTags.makeWrapperTag(Chipped.MOD_ID + ":" + id);
		}
	}

	public static class Items {
		
		private static ITag.INamedTag<Item> forge(String id) {
			return ItemTags.makeWrapperTag("forge:" + id);
		}
		
		private static ITag.INamedTag<Item> mod(String id) {
			return ItemTags.makeWrapperTag(Chipped.MOD_ID + ":" + id);
		}
	}
}
