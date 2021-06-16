/*
package com.grimbo.chipped.integration;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.recipe.ChippedRecipe;
import com.grimbo.chipped.recipe.ChippedSerializer;
import me.shedaniel.rei.api.EntryStack;
import me.shedaniel.rei.api.RecipeHelper;
import me.shedaniel.rei.api.plugins.REIPluginV0;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

public class REIChippedPlugin implements REIPluginV0 {
    @Override
    public void registerPluginCategories(RecipeHelper recipeHelper) {
        recipeHelper.registerCategories(
                new ChippedRecipeCategory(ChippedBlocks.BOTANIST_WORKBENCH),
                new ChippedRecipeCategory(ChippedBlocks.GLASSBLOWER),
                new ChippedRecipeCategory(ChippedBlocks.CARPENTERS_TABLE),
                new ChippedRecipeCategory(ChippedBlocks.LOOM_TABLE),
                new ChippedRecipeCategory(ChippedBlocks.MASON_TABLE),
                new ChippedRecipeCategory(ChippedBlocks.ALCHEMY_BENCH),
                new ChippedRecipeCategory(ChippedBlocks.MECHANIST_WORKBENCH)
        );
    }

    @Override
    public void registerRecipeDisplays(RecipeHelper recipeHelper) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        registerRecipes(recipeManager, recipeHelper, ChippedSerializer.BOTANIST_WORKBENCH_TYPE, ChippedBlocks.BOTANIST_WORKBENCH);
        registerRecipes(recipeManager, recipeHelper, ChippedSerializer.CARPENTERS_TABLE_TYPE, ChippedBlocks.CARPENTERS_TABLE);
        registerRecipes(recipeManager, recipeHelper, ChippedSerializer.LOOM_TABLE_TYPE, ChippedBlocks.LOOM_TABLE);
        registerRecipes(recipeManager, recipeHelper, ChippedSerializer.MASON_TABLE_TYPE, ChippedBlocks.MASON_TABLE);
        registerRecipes(recipeManager, recipeHelper, ChippedSerializer.ALCHEMY_BENCH_TYPE, ChippedBlocks.ALCHEMY_BENCH);
        registerRecipes(recipeManager, recipeHelper, ChippedSerializer.MECHANIST_WORKBENCH_TYPE, ChippedBlocks.MECHANIST_WORKBENCH);
    }

    private void registerRecipes(RecipeManager recipeManager, RecipeHelper recipeHelper, RecipeType<ChippedRecipe> type, Block block) {
        final ResourceLocation category = Registry.BLOCK.getKey(block);
        recipeManager.getAllRecipesFor(type).stream().map(recipe -> new ChippedRecipeCategory.RecipeWrapper(recipe, category)).forEach(recipeHelper::registerDisplay);
    }

    @Override
    public void registerOthers(RecipeHelper recipeHelper) {
        registerWorkingStation(recipeHelper, ChippedBlocks.BOTANIST_WORKBENCH);
        registerWorkingStation(recipeHelper, ChippedBlocks.GLASSBLOWER);
        registerWorkingStation(recipeHelper, ChippedBlocks.CARPENTERS_TABLE);
        registerWorkingStation(recipeHelper, ChippedBlocks.LOOM_TABLE);
        registerWorkingStation(recipeHelper, ChippedBlocks.MASON_TABLE);
        registerWorkingStation(recipeHelper, ChippedBlocks.ALCHEMY_BENCH);
        registerWorkingStation(recipeHelper, ChippedBlocks.MECHANIST_WORKBENCH);
    }

    private void registerWorkingStation(RecipeHelper recipeHelper, Block block) {
        recipeHelper.registerWorkingStations(Registry.BLOCK.getKey(block), EntryStack.create(new ItemStack(block)));
    }

    @Override
    public ResourceLocation getPluginIdentifier() {
        return new ResourceLocation(Chipped.MOD_ID, "recipes_plugin");
    }
}
*/
