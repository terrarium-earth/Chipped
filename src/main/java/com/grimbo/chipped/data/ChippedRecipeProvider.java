package com.grimbo.chipped.data;

import com.google.common.collect.Streams;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.ChippedTags;
import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.recipe.ChippedSerializer;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.IRequirementsStrategy;
import net.minecraft.advancements.criterion.*;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.SingleItemRecipeBuilder;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChippedRecipeProvider extends RecipeProvider {

	public ChippedRecipeProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}

	@Override
	protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
		createRecipeFromTypes(ChippedSerializer.MASON_TABLE.get(), consumer, Streams.concat(
				Arrays.stream(ChippedBlocks.stones18),
				Arrays.stream(ChippedBlocks.colorsList).map(s -> s + "_terracotta"),
				Arrays.stream(ChippedBlocks.colorsList).map(s -> s + "_concrete"),
				Stream.of("gilded_blackstone", "blackstone", "basalt", "clay")
		));

		createRecipeFromTypes(ChippedSerializer.ALCHEMY_BENCH.get(), consumer, "obsidian", "crying_obsidian", "glowstone", "sea_lantern");
		createRecipeFromTypes(ChippedSerializer.BOTANIST_WORKBENCH.get(), consumer, "hay_block", "melon", "vine", "shroomlight", "pumpkin", "jack_o_lantern", "carved_pumpkin");

		createRecipeFromTypes(ChippedSerializer.MECHANIST_WORKBENCH.get(), consumer, "redstone_torch", "lantern", "soul_lantern", "redstone_lamp");

		createRecipeFromTypes(ChippedSerializer.CARPENTERS_TABLE.get(), consumer, Streams.concat(
				Arrays.stream(ChippedBlocks.woodsList).map(s -> s + "_planks"),
				Stream.of("torch")
		));

		createRecipeFromTypes(ChippedSerializer.GLASSBLOWER.get(), consumer, Streams.concat(
				Arrays.stream(ChippedBlocks.woodsList).map(s -> s + "_wood_glass"),
				Arrays.stream(ChippedBlocks.woodsList).map(s -> s + "_wood_glass_pane"),
				Arrays.stream(ChippedBlocks.colorsList).map(s -> s + "_stained_glass"),
				Arrays.stream(ChippedBlocks.colorsList).map(s -> s + "_stained_glass_pane"),
				Stream.of("glass", "glass_pane")
		));

		createRecipeFromTypes(ChippedSerializer.LOOM_TABLE.get(), consumer, Streams.concat(
				Arrays.stream(ChippedBlocks.colorsList).map(s -> s + "_wool"),
				Arrays.stream(ChippedBlocks.colorsList).map(s -> s + "_carpet")
		));
	}
	
	private static void createRecipeFromTypes(IRecipeSerializer<?> serializer, Consumer<IFinishedRecipe> consumer, String... types) {
		createRecipeFromTypes(serializer, consumer, Stream.of(types));
	}

	private static void createRecipeFromTypes(IRecipeSerializer<?> serializer, Consumer<IFinishedRecipe> consumer, Stream<String> types) {
		consumer.accept(new Result(
				types.map(s -> Chipped.MOD_ID + ":" + s),
				serializer.getRegistryName(),
				serializer
		));
	}

	private static class Result implements IFinishedRecipe {
		private final Stream<String> tags;
		private final ResourceLocation id;
		private final IRecipeSerializer<?> serializer;

		public Result(Stream<String> tags, ResourceLocation id, IRecipeSerializer<?> serializer) {
			this.tags = tags;
			this.id = id;
			this.serializer = serializer;
		}

		@Override
		public void serializeRecipeData(JsonObject json) {
			JsonArray array = new JsonArray();
			tags.forEach(array::add);
			json.add("tags", array);
		}

		@Override
		public ResourceLocation getId() {
			return id;
		}

		@Override
		public IRecipeSerializer<?> getType() {
			return serializer;
		}

		@Nullable
		@Override
		public JsonObject serializeAdvancement() {
			return null;
		}

		@Nullable
		@Override
		public ResourceLocation getAdvancementId() {
			return null;
		}
	}
}
