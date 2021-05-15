package com.grimbo.chipped.integration.jei;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.recipe.ChippedSerializer;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
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
		registry.addRecipeCategories(
				new ChippedRecipeCategory("botanist_workbench", registry.getJeiHelpers().getGuiHelper()),
				new ChippedRecipeCategory("glassblower", registry.getJeiHelpers().getGuiHelper()),
				new ChippedRecipeCategory("carpenters_table", registry.getJeiHelpers().getGuiHelper()),
				new ChippedRecipeCategory("loom_table", registry.getJeiHelpers().getGuiHelper()),
				new ChippedRecipeCategory("mason_table", registry.getJeiHelpers().getGuiHelper()),
				new ChippedRecipeCategory("alchemy_bench", registry.getJeiHelpers().getGuiHelper())
		);
	}
	
	@SuppressWarnings("resource")
	@Override
    public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
		registration.addRecipes(recipeManager.getAllRecipesFor(ChippedSerializer.BOTANIST_WORKBENCH_TYPE), getUidFromId("botanist_workbench"));
		registration.addRecipes(recipeManager.getAllRecipesFor(ChippedSerializer.GLASSBLOWER_TYPE), getUidFromId("glassblower"));
		registration.addRecipes(recipeManager.getAllRecipesFor(ChippedSerializer.CARPENTERS_TABLE_TYPE), getUidFromId("carpenters_table"));
		registration.addRecipes(recipeManager.getAllRecipesFor(ChippedSerializer.LOOM_TABLE_TYPE), getUidFromId("loom_table"));
		registration.addRecipes(recipeManager.getAllRecipesFor(ChippedSerializer.MASON_TABLE_TYPE), getUidFromId("mason_table"));
		registration.addRecipes(recipeManager.getAllRecipesFor(ChippedSerializer.ALCHEMY_BENCH_TYPE), getUidFromId("alchemy_bench"));
	}

	@Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.BOTANIST_WORKBENCH.get()), getUidFromId("botanist_workbench"));
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.GLASSBLOWER.get()), getUidFromId("glassblower"));
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.CARPENTERS_TABLE.get()), getUidFromId("carpenters_table"));
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.LOOM_TABLE.get()), getUidFromId("loom_table"));
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.MASON_TABLE.get()), getUidFromId("mason_table"));
		registration.addRecipeCatalyst(new ItemStack(ChippedBlocks.ALCHEMY_BENCH.get()), getUidFromId("alchemy_bench"));
	}
	
	private static ResourceLocation getUidFromId(String id) {
		return new ResourceLocation(Chipped.MOD_ID, id);
	}

}
