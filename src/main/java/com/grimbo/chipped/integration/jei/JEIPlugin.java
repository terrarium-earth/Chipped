package com.grimbo.chipped.integration.jei;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.recipe.ChippedSerializer;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

	private static final ResourceLocation UID = new ResourceLocation(Chipped.MOD_ID, "chipped");

	@Override
	public ResourceLocation getPluginUid() {
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
		registration.addRecipes(recipeManager.getAllRecipesFor(ChippedSerializer.BOTANIST_WORKBENCH_TYPE), getUidFromId("botanist_workbench"));
		registration.addRecipes(recipeManager.getAllRecipesFor(ChippedSerializer.GLASSBLOWER_TYPE), getUidFromId("glassblower"));
		registration.addRecipes(recipeManager.getAllRecipesFor(ChippedSerializer.CARPENTERS_TABLE_TYPE), getUidFromId("carpenters_table"));
		registration.addRecipes(recipeManager.getAllRecipesFor(ChippedSerializer.LOOM_TABLE_TYPE), getUidFromId("loom_table"));
		registration.addRecipes(recipeManager.getAllRecipesFor(ChippedSerializer.MASON_TABLE_TYPE), getUidFromId("mason_table"));
		registration.addRecipes(recipeManager.getAllRecipesFor(ChippedSerializer.ALCHEMY_BENCH_TYPE), getUidFromId("alchemy_bench"));
		registration.addRecipes(recipeManager.getAllRecipesFor(ChippedSerializer.MECHANIST_WORKBENCH_TYPE), getUidFromId("mechanist_workbench"));
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

	private static ResourceLocation getUidFromId(String id) {
		return new ResourceLocation(Chipped.MOD_ID, id);
	}

}
