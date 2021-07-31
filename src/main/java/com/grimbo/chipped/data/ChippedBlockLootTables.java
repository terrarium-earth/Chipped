package com.grimbo.chipped.data;

import java.util.stream.Collectors;

import com.grimbo.chipped.api.BlockRegistry;
import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.fml.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ChippedBlockLootTables extends BlockLootTables {

	@Override
	protected void addTables() {
		for (RegistryObject<Block> block : BlockRegistry.getBlocks()) {
			dropSelf(block.get());
		}

		dropSelf(ChippedBlocks.BOTANIST_WORKBENCH.get());
		dropSelf(ChippedBlocks.GLASSBLOWER.get());
		dropSelf(ChippedBlocks.CARPENTERS_TABLE.get());
		dropSelf(ChippedBlocks.LOOM_TABLE.get());
		dropSelf(ChippedBlocks.MASON_TABLE.get());
		dropSelf(ChippedBlocks.ALCHEMY_BENCH.get());
		dropSelf(ChippedBlocks.MECHANIST_WORKBENCH.get());
	}

	@Override
	protected @NotNull Iterable<Block> getKnownBlocks() {
		return ChippedBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
	}
}