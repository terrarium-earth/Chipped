package com.grimbo.chipped.data;

import java.util.stream.Collectors;

import com.grimbo.chipped.api.BlockRegistry;
import com.grimbo.chipped.api.ChippedBlockType;
import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.RedstoneWallTorchBlock;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.fml.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ChippedBlockLootTables extends BlockLootTables {

	@Override
	protected void addTables() {
		for (ChippedBlockType<Block> type : BlockRegistry.getBlockTypes()) {
			for (RegistryObject<Block> block : type.getBlocks()) {
				dropSelf(block.get());
			}
		}

		for (RegistryObject<RedstoneWallTorchBlock> redstoneWallTorch : ChippedBlocks.REDSTONE_WALL_TORCHES) {
			dropSelf(redstoneWallTorch.get());
		}

		for (RegistryObject<WallTorchBlock> wallTorch : ChippedBlocks.WALL_TORCHES) {
			dropSelf(wallTorch.get());
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