package com.grimbo.chipped.data;

import java.util.stream.Collectors;

import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.fml.RegistryObject;

public class ChippedBlockLootTables extends BlockLootTables {

	@Override
	protected void addTables() {
		for (RegistryObject<Block> block : ChippedBlocks.stones) {
			dropSelf(block.get());
		}
		for (RegistryObject<Block> block : ChippedBlocks.wools) {
			dropSelf(block.get());
		}
		for (RegistryObject<Block> block : ChippedBlocks.carpets) {
			dropSelf(block.get());
		}
		for (RegistryObject<Block> block : ChippedBlocks.glasses) {
			dropSelf(block.get());
		}
		for (RegistryObject<Block> block : ChippedBlocks.stainedGlasses) {
			dropSelf(block.get());
		}
		for (RegistryObject<Block> block : ChippedBlocks.hayBlock) {
			dropSelf(block.get());
		}
		for (RegistryObject<Block> block : ChippedBlocks.clays) {
			dropSelf(block.get());
		}
		for (RegistryObject<Block> block : ChippedBlocks.terracottas) {
			dropSelf(block.get());
		}
		for (RegistryObject<Block> block : ChippedBlocks.concretes) {
			dropSelf(block.get());
		}
		for (RegistryObject<Block> block : ChippedBlocks.woods) {
			dropSelf(block.get());
		}
		for (RegistryObject<Block> block: ChippedBlocks.melons) {
			dropSelf(block.get());
		}

		dropSelf(ChippedBlocks.BOTANIST_WORKBENCH.get());
		dropSelf(ChippedBlocks.GLASSBLOWER.get());
		dropSelf(ChippedBlocks.CARPENTERS_TABLE.get());
		dropSelf(ChippedBlocks.LOOM_TABLE.get());
		dropSelf(ChippedBlocks.MASON_TABLE.get());
		dropSelf(ChippedBlocks.ALCHEMY_BENCH.get());

		dropSelf(ChippedBlocks.VINE_1.get());
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ChippedBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
	}
}