package com.grimbo.chipped.compat;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.recipe.ChippedRecipe;
import com.grimbo.chipped.registry.ChippedBlocks;
import com.grimbo.chipped.registry.ChippedSerializer;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EMIChippedPlugin implements EmiPlugin
{
    @Override
    public void register(EmiRegistry registry)
    {
        buildCategory(registry, ChippedBlocks.BOTANIST_WORKBENCH, ChippedSerializer.BOTANIST_WORKBENCH_TYPE);
        buildCategory(registry, ChippedBlocks.GLASSBLOWER, ChippedSerializer.GLASSBLOWER_TYPE);
        buildCategory(registry, ChippedBlocks.CARPENTERS_TABLE, ChippedSerializer.CARPENTERS_TABLE_TYPE);
        buildCategory(registry, ChippedBlocks.LOOM_TABLE, ChippedSerializer.LOOM_TABLE_TYPE);
        buildCategory(registry, ChippedBlocks.MASON_TABLE, ChippedSerializer.MASON_TABLE_TYPE);
        buildCategory(registry, ChippedBlocks.ALCHEMY_BENCH, ChippedSerializer.ALCHEMY_BENCH_TYPE);
        buildCategory(registry, ChippedBlocks.MECHANIST_WORKBENCH, ChippedSerializer.MECHANIST_WORKBENCH_TYPE);
    }

    private void buildCategory(final EmiRegistry registry, final Block block, final RecipeType<ChippedRecipe> recipeType)
    {
        final EmiRecipeCategory category = new EmiRecipeCategory(new ResourceLocation(Chipped.MOD_ID, Registry.BLOCK.getKey(block).getPath()),
          EmiStack.of(block));
        // Chipped doesn't really need to add simplified logos; recipes are depth == 1.

        registry.addCategory(category);
        registry.addWorkstation(category, EmiStack.of(block));

        for (EMIChippedRecipe recipe : parseRecipe(registry.getRecipeManager().getAllRecipesFor(recipeType), category))
        {
            registry.addRecipe(recipe);
        }
    }

    private List<EMIChippedRecipe> parseRecipe(final Collection<ChippedRecipe> recipes, final EmiRecipeCategory category)
    {
        final List<EMIChippedRecipe> outputRecipes = new ArrayList<>();
        for (final ChippedRecipe recipe : recipes)
        {
            for (final HolderSet<Item> recipeTag : recipe.tags())
            {
                outputRecipes.add(new EMIChippedRecipe(recipeTag, category, recipe.getId()));
            }
        }
        return outputRecipes;
    }
}