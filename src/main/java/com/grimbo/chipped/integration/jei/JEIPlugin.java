package com.grimbo.chipped.integration.jei;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.recipe.ChippedRecipe;
import com.grimbo.chipped.recipe.ChippedRecipeTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

	private static final ResourceLocation UID = new ResourceLocation(Chipped.MOD_ID, "chipped");

	public static final RecipeType<ChippedRecipeCategory.FlattenedRecipe> BOTANIST_WORKBENCH = RecipeType.create(Chipped.MOD_ID, "botanist_workbench", ChippedRecipeCategory.FlattenedRecipe.class);
	public static final RecipeType<ChippedRecipeCategory.FlattenedRecipe> GLASSBLOWER_TYPE = RecipeType.create(Chipped.MOD_ID, "glassblower", ChippedRecipeCategory.FlattenedRecipe.class);
	public static final RecipeType<ChippedRecipeCategory.FlattenedRecipe> CARPENTERS_TABLE_TYPE = RecipeType.create(Chipped.MOD_ID, "carpenters_table", ChippedRecipeCategory.FlattenedRecipe.class);
	public static final RecipeType<ChippedRecipeCategory.FlattenedRecipe> LOOM_TABLE_TYPE = RecipeType.create(Chipped.MOD_ID, "loom_table", ChippedRecipeCategory.FlattenedRecipe.class);
	public static final RecipeType<ChippedRecipeCategory.FlattenedRecipe> MASON_TABLE_TYPE = RecipeType.create(Chipped.MOD_ID, "mason_table", ChippedRecipeCategory.FlattenedRecipe.class);
	public static final RecipeType<ChippedRecipeCategory.FlattenedRecipe> ALCHEMY_BENCH_TYPE = RecipeType.create(Chipped.MOD_ID, "alchemy_bench", ChippedRecipeCategory.FlattenedRecipe.class);
	public static final RecipeType<ChippedRecipeCategory.FlattenedRecipe> MECHANIST_WORKBENCH_TYPE = RecipeType.create(Chipped.MOD_ID, "mechanist_workbench", ChippedRecipeCategory.FlattenedRecipe.class);

	@Override
	public @NotNull ResourceLocation getPluginUid() {
		return UID;
	}

	/*
	 * Registering workbenches under JEI
	 * 1. Create a new RecipeCategory in this::registerCategories
	 * 2. Add the recipe in this::registerRecipes
	 * 3. Add the recipe catalyst in this::registerRecipeCatalysts
	 */
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		IGuiHelper helper = registry.getJeiHelpers().getGuiHelper();
		registry.addRecipeCategories(
				new ChippedRecipeCategory(BOTANIST_WORKBENCH, ChippedBlocks.BOTANIST_WORKBENCH.get().asItem(), helper),
				new ChippedRecipeCategory(GLASSBLOWER_TYPE, ChippedBlocks.GLASSBLOWER.get().asItem(), helper),
				new ChippedRecipeCategory(CARPENTERS_TABLE_TYPE, ChippedBlocks.CARPENTERS_TABLE.get().asItem(), helper),
				new ChippedRecipeCategory(LOOM_TABLE_TYPE, ChippedBlocks.LOOM_TABLE.get().asItem(), helper),
				new ChippedRecipeCategory(MASON_TABLE_TYPE, ChippedBlocks.MASON_TABLE.get().asItem(), helper),
				new ChippedRecipeCategory(ALCHEMY_BENCH_TYPE, ChippedBlocks.ALCHEMY_BENCH.get().asItem(), helper),
				new ChippedRecipeCategory(MECHANIST_WORKBENCH_TYPE, ChippedBlocks.MECHANIST_WORKBENCH.get().asItem(), helper)
		);
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
		registration.addRecipes(BOTANIST_WORKBENCH, flatten(recipeManager.getAllRecipesFor(ChippedRecipeTypes.BOTANIST_WORKBENCH_TYPE.get())));
		registration.addRecipes(GLASSBLOWER_TYPE, flatten(recipeManager.getAllRecipesFor(ChippedRecipeTypes.GLASSBLOWER_TYPE.get())));
		registration.addRecipes(CARPENTERS_TABLE_TYPE, flatten(recipeManager.getAllRecipesFor(ChippedRecipeTypes.CARPENTERS_TABLE_TYPE.get())));
		registration.addRecipes(LOOM_TABLE_TYPE, flatten(recipeManager.getAllRecipesFor(ChippedRecipeTypes.LOOM_TABLE_TYPE.get())));
		registration.addRecipes(MASON_TABLE_TYPE, flatten(recipeManager.getAllRecipesFor(ChippedRecipeTypes.MASON_TABLE_TYPE.get())));
		registration.addRecipes(ALCHEMY_BENCH_TYPE, flatten(recipeManager.getAllRecipesFor(ChippedRecipeTypes.ALCHEMY_BENCH_TYPE.get())));
		registration.addRecipes(MECHANIST_WORKBENCH_TYPE, flatten(recipeManager.getAllRecipesFor(ChippedRecipeTypes.MECHANIST_WORKBENCH_TYPE.get())));
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.BOTANIST_WORKBENCH.get()), BOTANIST_WORKBENCH);
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.GLASSBLOWER.get()), GLASSBLOWER_TYPE);
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.CARPENTERS_TABLE.get()), CARPENTERS_TABLE_TYPE);
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.LOOM_TABLE.get()), LOOM_TABLE_TYPE);
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.MASON_TABLE.get()), MASON_TABLE_TYPE);
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.ALCHEMY_BENCH.get()), ALCHEMY_BENCH_TYPE);
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.MECHANIST_WORKBENCH.get()), MECHANIST_WORKBENCH_TYPE);
	}

	private static List<ChippedRecipeCategory.FlattenedRecipe> flatten(Collection<ChippedRecipe> recipes) {
		List<ChippedRecipeCategory.FlattenedRecipe> flattenedRecipes = new ArrayList<>();
		for (ChippedRecipe recipe : recipes) {
			for (HolderSet<Item> tag : recipe.getTags()) {
				var items = tag.stream().filter(Holder::isBound).map(Holder::value).toList();
				Ingredient ingredient = Ingredient.of(items.stream().map(ItemStack::new));
				for (Item item : items) {
					flattenedRecipes.add(new ChippedRecipeCategory.FlattenedRecipe(ingredient, new ItemStack(item)));
				}
			}
		}
		return flattenedRecipes;
	}
}
