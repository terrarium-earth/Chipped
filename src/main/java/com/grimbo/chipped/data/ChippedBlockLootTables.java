package com.grimbo.chipped.data;

import java.util.stream.Collectors;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.fml.RegistryObject;

public class ChippedBlockLootTables extends BlockLootTables {
	
	@Override
	protected void addTables() {
		for (RegistryObject<Block> block : ChippedBlocks.stones) {
			registerDropSelfLootTable(block.get());
		}
		for (RegistryObject<Block> block : ChippedBlocks.wools) {
			registerDropSelfLootTable(block.get());
		}
		for (RegistryObject<Block> block : ChippedBlocks.carpets) {
			registerDropSelfLootTable(block.get());
		}
		for (RegistryObject<Block> block : ChippedBlocks.glasses) {
			registerDropSelfLootTable(block.get());
		}
		for (RegistryObject<Block> block : ChippedBlocks.stainedGlasses) {
			registerDropSelfLootTable(block.get());
		}
		for (RegistryObject<Block> block : ChippedBlocks.hayBlock) {
			registerDropSelfLootTable(block.get());
		}
		for (RegistryObject<Block> block : ChippedBlocks.clays) {
			registerDropSelfLootTable(block.get());
		}
		for (RegistryObject<Block> block : ChippedBlocks.terracottas) {
			registerDropSelfLootTable(block.get());
		}
		
		registerDropSelfLootTable(ChippedBlocks.BOTANIST_WORKBENCH.get());
		registerDropSelfLootTable(ChippedBlocks.GLASSBLOWER.get());
		registerDropSelfLootTable(ChippedBlocks.CARPENTERS_TABLE.get());
		registerDropSelfLootTable(ChippedBlocks.LOOM_TABLE.get());
		registerDropSelfLootTable(ChippedBlocks.MASON_TABLE.get());
		registerDropSelfLootTable(ChippedBlocks.ALCHEMY_BENCH.get());
		
		registerDropSelfLootTable(ChippedBlocks.VINE_1.get());
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ChippedBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
	}
}