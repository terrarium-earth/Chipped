package com.grimbo.chipped.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.grimbo.chipped.api.BenchType;
import com.grimbo.chipped.api.BlockRegistry;
import com.grimbo.chipped.recipe.ChippedSerializer;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.function.Consumer;

public class ChippedRecipeProvider extends RecipeProvider {

	public ChippedRecipeProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}

	@Override
	protected void buildShapelessRecipes(@NotNull Consumer<IFinishedRecipe> consumer) {
		createRecipeFromTypes(ChippedSerializer.MASON_TABLE, consumer, BlockRegistry.getTags(BenchType.MASON));
		createRecipeFromTypes(ChippedSerializer.ALCHEMY_BENCH, consumer, BlockRegistry.getTags(BenchType.ALCHEMY));
		createRecipeFromTypes(ChippedSerializer.BOTANIST_WORKBENCH, consumer, BlockRegistry.getTags(BenchType.BOTANIST));
		createRecipeFromTypes(ChippedSerializer.MECHANIST_WORKBENCH, consumer, BlockRegistry.getTags(BenchType.MECHANIST));
		createRecipeFromTypes(ChippedSerializer.CARPENTERS_TABLE, consumer, BlockRegistry.getTags(BenchType.CARPENTERS));
		createRecipeFromTypes(ChippedSerializer.GLASSBLOWER, consumer, BlockRegistry.getTags(BenchType.GLASSBLOWER));
		createRecipeFromTypes(ChippedSerializer.LOOM_TABLE, consumer, BlockRegistry.getTags(BenchType.LOOM));
	}

	private static void createRecipeFromTypes(RegistryObject<IRecipeSerializer<?>> serializer, Consumer<IFinishedRecipe> consumer, Collection<String> types) {
		consumer.accept(new Result(types, serializer));
	}

	private static class Result implements IFinishedRecipe {
		private final Collection<String> tags;
		private final RegistryObject<IRecipeSerializer<?>> serializer;

		public Result(Collection<String> tags, RegistryObject<IRecipeSerializer<?>> serializer) {
			this.tags = tags;
			this.serializer = serializer;
		}

		@Override
		public void serializeRecipeData(JsonObject json) {
			JsonArray array = new JsonArray();
			tags.forEach(array::add);
			json.add("tags", array);
		}

		@Override
		public @NotNull ResourceLocation getId() {
			return serializer.getId();
		}

		@Override
		public @NotNull IRecipeSerializer<?> getType() {
			return serializer.get();
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
