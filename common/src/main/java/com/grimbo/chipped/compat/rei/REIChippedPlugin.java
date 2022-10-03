package com.grimbo.chipped.compat.rei;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.grimbo.chipped.recipe.ChippedRecipe;
import com.grimbo.chipped.registry.ChippedBlocks;
import com.grimbo.chipped.registry.ChippedRecipeTypes;
import com.grimbo.chipped.registry.ChippedSerializer;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

public class REIChippedPlugin implements REIClientPlugin {
    @Override
    @SuppressWarnings("unchecked")
    public void registerCategories(CategoryRegistry registry) {
        registry.add(
                new ChippedRecipeCategory(ChippedBlocks.BOTANIST_WORKBENCH.get()),
                new ChippedRecipeCategory(ChippedBlocks.GLASSBLOWER.get()),
                new ChippedRecipeCategory(ChippedBlocks.CARPENTERS_TABLE.get()),
                new ChippedRecipeCategory(ChippedBlocks.LOOM_TABLE.get()),
                new ChippedRecipeCategory(ChippedBlocks.MASON_TABLE.get()),
                new ChippedRecipeCategory(ChippedBlocks.ALCHEMY_BENCH.get()),
                new ChippedRecipeCategory(ChippedBlocks.MECHANIST_WORKBENCH.get())
        );
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        Minecraft client = Minecraft.getInstance();
        RecipeManager recipeManager = client.level.getRecipeManager();
        registerRecipes(recipeManager, registry, ChippedRecipeTypes.BOTANIST_WORKBENCH_TYPE.get(), ChippedBlocks.BOTANIST_WORKBENCH.get());
        registerRecipes(recipeManager, registry, ChippedRecipeTypes.CARPENTERS_TABLE_TYPE.get(), ChippedBlocks.CARPENTERS_TABLE.get());
        registerRecipes(recipeManager, registry, ChippedRecipeTypes.LOOM_TABLE_TYPE.get(), ChippedBlocks.LOOM_TABLE.get());
        registerRecipes(recipeManager, registry, ChippedRecipeTypes.MASON_TABLE_TYPE.get(), ChippedBlocks.MASON_TABLE.get());
        registerRecipes(recipeManager, registry, ChippedRecipeTypes.ALCHEMY_BENCH_TYPE.get(), ChippedBlocks.ALCHEMY_BENCH.get());
        registerRecipes(recipeManager, registry, ChippedRecipeTypes.MECHANIST_WORKBENCH_TYPE.get(), ChippedBlocks.MECHANIST_WORKBENCH.get());
    }

    private void registerRecipes(RecipeManager recipeManager, DisplayRegistry registry, RecipeType<ChippedRecipe> type, Block block) {
        final ResourceLocation category = Registry.BLOCK.getKey(block);
        for (ChippedRecipeCategory.FlattenedRecipe recipe : flatten(recipeManager.getAllRecipesFor(type), CategoryIdentifier.of(category))) {
            registry.add(recipe);
        }
    }

    private static List<ChippedRecipeCategory.FlattenedRecipe> flatten(Collection<ChippedRecipe> recipes, CategoryIdentifier<ChippedRecipeCategory.FlattenedRecipe> category) {
        List<ChippedRecipeCategory.FlattenedRecipe> flattenedRecipes = new ArrayList<>();
        for (ChippedRecipe recipe : recipes) {
            for (HolderSet<Item> tag : recipe.tags()) {
                var items = tag.stream().filter(Holder::isBound).map(Holder::value).toList();
                Ingredient ingredient = Ingredient.of(items.stream().map(ItemStack::new));
                for (Item item : items) {
                    flattenedRecipes.add(new ChippedRecipeCategory.FlattenedRecipe(ingredient, new ItemStack(item), category));
                }
            }
        }
        return flattenedRecipes;
    }
}
