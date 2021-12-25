package com.grimbo.chipped.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.grimbo.chipped.api.BenchType;
import com.grimbo.chipped.api.BlockRegistry;
import com.grimbo.chipped.recipe.ChippedSerializer;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.function.Consumer;

public class ChippedRecipeProvider extends RecipeProvider {

	public ChippedRecipeProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}

	@Override
	protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
		createRecipeFromTypes(ChippedSerializer.MASON_TABLE, consumer, BlockRegistry.getTags(BenchType.MASON));
		createRecipeFromTypes(ChippedSerializer.ALCHEMY_BENCH, consumer, BlockRegistry.getTags(BenchType.ALCHEMY));
		createRecipeFromTypes(ChippedSerializer.BOTANIST_WORKBENCH, consumer, BlockRegistry.getTags(BenchType.BOTANIST));
		createRecipeFromTypes(ChippedSerializer.MECHANIST_WORKBENCH, consumer, BlockRegistry.getTags(BenchType.MECHANIST));
		createRecipeFromTypes(ChippedSerializer.CARPENTERS_TABLE, consumer, BlockRegistry.getTags(BenchType.CARPENTERS));
		createRecipeFromTypes(ChippedSerializer.GLASSBLOWER, consumer, BlockRegistry.getTags(BenchType.GLASSBLOWER));
		createRecipeFromTypes(ChippedSerializer.LOOM_TABLE, consumer, BlockRegistry.getTags(BenchType.LOOM));
	}

	private static void createRecipeFromTypes(RegistryObject<RecipeSerializer<?>> serializer, Consumer<FinishedRecipe> consumer, Collection<String> types) {
		consumer.accept(new Result(types, serializer));
	}

	private record Result(Collection<String> tags, RegistryObject<RecipeSerializer<?>> serializer) implements FinishedRecipe {

		@Override
		public void serializeRecipeData(JsonObject json) {
			JsonArray array = new JsonArray();
			tags.forEach(array::add);
			json.add("tags", array);
		}

		@Override
		public @NotNull
		ResourceLocation getId() {
			return serializer.getId();
		}

		@Override
		public @NotNull
		RecipeSerializer<?> getType() {
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
