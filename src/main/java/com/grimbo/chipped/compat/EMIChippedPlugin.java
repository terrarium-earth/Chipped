package com.grimbo.chipped.compat;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.recipe.ChippedRecipe;
import com.grimbo.chipped.registry.ChippedBlocks;
import com.grimbo.chipped.registry.ChippedSerializer;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
        // Chipped doesn't really need to add simplified logos; recipes are low-depth.

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
            for (final HolderSet<Item> recipeTag : recipe.tags()) {
                if(recipeTag.size() == 0)
                {
                    // You shouldn't get serialized recipes with no inputs, but it can happen if sync botches badly.
                    continue;
                }
                var items = recipeTag.stream().filter(Holder::isBound).map(Holder::value).collect(Collectors.toList());
                // Assume the first item in the tag is the default input to display for Recipe Tree and summary cost purposes.
                final Item input = items.get(0);
                // Recipes with a lot of outputs are Bad to draw, both for performance and for readability.
                // Instead, we'll divide recipes that exceed a certain draw amount into smaller groups.
                // Ugly for list variant, but we do need the counter.
                for(int i = 0; i < items.size();) {
                    // Just pulling the allowed count of recipes out.
                    // Can make this more compact with streams or ternaries, but it gets unreadable quick.
                    final List<Item> subItemList;
                    final boolean isContinuingRecipe;
                    if(items.size() <= EMIChippedRecipe.MAX_OUTPUTS_PER_PAGE)
                    {
                        subItemList = items;
                        isContinuingRecipe = false;
                    }
                    else
                    {
                        // Remember, subList is inclusive on the start, exclusive on the tail.
                        if(items.size() - i <= EMIChippedRecipe.MAX_OUTPUTS_PER_PAGE)
                        {
                            subItemList = items.subList(i, items.size());
                        }
                        else
                        {
                            subItemList = items.subList(i, i + EMIChippedRecipe.MAX_OUTPUTS_PER_PAGE);
                        }
                        // Let the recipe know if it's got more pages.
                        isContinuingRecipe = true;
                    }
                    i += subItemList.size();
                    outputRecipes.add(new EMIChippedRecipe(input, subItemList, category, recipe.getId(), isContinuingRecipe));
                }
            }
        }
        return outputRecipes;
    }
}