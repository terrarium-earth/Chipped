package com.grimbo.chipped.data;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableManager;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class ChippedLootTableProvider extends LootTableProvider {

	public ChippedLootTableProvider(DataGenerator dataGeneratorIn) {
		super(dataGeneratorIn);
	}

	@Override
	protected @NotNull List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
		return ImmutableList.of(Pair.of(ChippedBlockLootTables::new, LootParameterSets.BLOCK));
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, @NotNull ValidationTracker validationtracker) {
		map.forEach((resourceLocation, lootTable) -> LootTableManager.validate(validationtracker, resourceLocation, lootTable));
	}
}
