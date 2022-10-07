package earth.terrarium.chipped.compat.jei;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.recipe.ChippedRecipe;
import earth.terrarium.chipped.registry.ChippedBlocks;
import earth.terrarium.chipped.registry.ChippedRecipeTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
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
				new ChippedRecipeCategory(ChippedBlocks.BOTANIST_WORKBENCH.get().asItem(), helper),
				new ChippedRecipeCategory(ChippedBlocks.GLASSBLOWER.get().asItem(), helper),
				new ChippedRecipeCategory(ChippedBlocks.CARPENTERS_TABLE.get().asItem(), helper),
				new ChippedRecipeCategory(ChippedBlocks.LOOM_TABLE.get().asItem(), helper),
				new ChippedRecipeCategory(ChippedBlocks.MASON_TABLE.get().asItem(), helper),
				new ChippedRecipeCategory(ChippedBlocks.ALCHEMY_BENCH.get().asItem(), helper),
				new ChippedRecipeCategory(ChippedBlocks.MECHANIST_WORKBENCH.get().asItem(), helper)
		);
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
		registration.addRecipes(flatten(recipeManager.getAllRecipesFor(ChippedRecipeTypes.BOTANIST_WORKBENCH_TYPE.get())), getUidFromId("botanist_workbench"));
		registration.addRecipes(flatten(recipeManager.getAllRecipesFor(ChippedRecipeTypes.GLASSBLOWER_TYPE.get())), getUidFromId("glassblower"));
		registration.addRecipes(flatten(recipeManager.getAllRecipesFor(ChippedRecipeTypes.CARPENTERS_TABLE_TYPE.get())), getUidFromId("carpenters_table"));
		registration.addRecipes(flatten(recipeManager.getAllRecipesFor(ChippedRecipeTypes.LOOM_TABLE_TYPE.get())), getUidFromId("loom_table"));
		registration.addRecipes(flatten(recipeManager.getAllRecipesFor(ChippedRecipeTypes.MASON_TABLE_TYPE.get())), getUidFromId("mason_table"));
		registration.addRecipes(flatten(recipeManager.getAllRecipesFor(ChippedRecipeTypes.ALCHEMY_BENCH_TYPE.get())), getUidFromId("alchemy_bench"));
		registration.addRecipes(flatten(recipeManager.getAllRecipesFor(ChippedRecipeTypes.MECHANIST_WORKBENCH_TYPE.get())), getUidFromId("mechanist_workbench"));
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.BOTANIST_WORKBENCH.get()), getUidFromId("botanist_workbench"));
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.GLASSBLOWER.get()), getUidFromId("glassblower"));
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.CARPENTERS_TABLE.get()), getUidFromId("carpenters_table"));
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.LOOM_TABLE.get()), getUidFromId("loom_table"));
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.MASON_TABLE.get()), getUidFromId("mason_table"));
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.ALCHEMY_BENCH.get()), getUidFromId("alchemy_bench"));
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.MECHANIST_WORKBENCH.get()), getUidFromId("mechanist_workbench"));
	}

	private static List<ChippedRecipeCategory.FlattenedRecipe> flatten(Collection<ChippedRecipe> recipes) {
		List<ChippedRecipeCategory.FlattenedRecipe> flattenedRecipes = new ArrayList<>();
		for (ChippedRecipe recipe : recipes) {
			for (HolderSet<Item> tag : recipe.tags()) {
				var items = tag.stream().filter(Holder::isBound).map(Holder::value).toList();
				Ingredient ingredient = Ingredient.of(items.stream().map(ItemStack::new));
				for (Item item : items) {
					flattenedRecipes.add(new ChippedRecipeCategory.FlattenedRecipe(ingredient, new ItemStack(item)));
				}
			}
		}
		return flattenedRecipes;
	}

	private static ResourceLocation getUidFromId(String id) {
		return new ResourceLocation(Chipped.MOD_ID, id);
	}
}
