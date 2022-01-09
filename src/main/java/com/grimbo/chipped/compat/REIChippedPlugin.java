package com.grimbo.chipped.compat;

import com.grimbo.chipped.recipe.ChippedRecipe;
import com.grimbo.chipped.registry.ChippedBlocks;
import com.grimbo.chipped.registry.ChippedSerializer;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class REIChippedPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(
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
    public void registerDisplays(DisplayRegistry registry) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        registerRecipes(recipeManager, registry, ChippedSerializer.BOTANIST_WORKBENCH_TYPE, ChippedBlocks.BOTANIST_WORKBENCH);
        registerRecipes(recipeManager, registry, ChippedSerializer.CARPENTERS_TABLE_TYPE, ChippedBlocks.CARPENTERS_TABLE);
        registerRecipes(recipeManager, registry, ChippedSerializer.LOOM_TABLE_TYPE, ChippedBlocks.LOOM_TABLE);
        registerRecipes(recipeManager, registry, ChippedSerializer.MASON_TABLE_TYPE, ChippedBlocks.MASON_TABLE);
        registerRecipes(recipeManager, registry, ChippedSerializer.ALCHEMY_BENCH_TYPE, ChippedBlocks.ALCHEMY_BENCH);
        registerRecipes(recipeManager, registry, ChippedSerializer.MECHANIST_WORKBENCH_TYPE, ChippedBlocks.MECHANIST_WORKBENCH);
    }

    private void registerRecipes(@NotNull RecipeManager recipeManager, DisplayRegistry registry, RecipeType<ChippedRecipe> type, Block block) {
        final ResourceLocation category = Registry.BLOCK.getKey(block);
        for (ChippedRecipeCategory.FlattenedRecipe recipe : flatten(recipeManager.getAllRecipesFor(type), CategoryIdentifier.of(category))) {
            registry.add(recipe);
        }
    }

    private static @NotNull List<ChippedRecipeCategory.FlattenedRecipe> flatten(@NotNull Collection<ChippedRecipe> recipes, CategoryIdentifier<ChippedRecipeCategory.FlattenedRecipe> category) {
        List<ChippedRecipeCategory.FlattenedRecipe> flattenedRecipes = new ArrayList<>();
        for (ChippedRecipe recipe : recipes) {
            for (Tag<Item> tag : recipe.tags()) {
                for (Item item : tag.getValues()) {
                    flattenedRecipes.add(new ChippedRecipeCategory.FlattenedRecipe(tag, new ItemStack(item), category));
                }
            }
        }
        return flattenedRecipes;
    }
}
