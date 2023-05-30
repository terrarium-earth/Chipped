package earth.terrarium.chipped.common.compat.rei;

import earth.terrarium.chipped.common.recipe.ChippedRecipe;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.ModRecipeTypes;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class REIChippedPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(
            new ChippedRecipeCategory(ModBlocks.BOTANIST_WORKBENCH.get()),
            new ChippedRecipeCategory(ModBlocks.GLASSBLOWER.get()),
            new ChippedRecipeCategory(ModBlocks.CARPENTERS_TABLE.get()),
            new ChippedRecipeCategory(ModBlocks.LOOM_TABLE.get()),
            new ChippedRecipeCategory(ModBlocks.MASON_TABLE.get()),
            new ChippedRecipeCategory(ModBlocks.ALCHEMY_BENCH.get()),
            new ChippedRecipeCategory(ModBlocks.TINKERING_TABLE.get())
        );
    }


    @Override
    public void registerDisplays(DisplayRegistry registry) {
        Minecraft client = Minecraft.getInstance();
        assert client.level != null;
        RecipeManager recipeManager = client.level.getRecipeManager();
        registerRecipes(recipeManager, registry, ModRecipeTypes.BOTANIST_WORKBENCH_TYPE.get(), ModBlocks.BOTANIST_WORKBENCH.get());
        registerRecipes(recipeManager, registry, ModRecipeTypes.GLASSBLOWER_TYPE.get(), ModBlocks.GLASSBLOWER.get());
        registerRecipes(recipeManager, registry, ModRecipeTypes.CARPENTERS_TABLE_TYPE.get(), ModBlocks.CARPENTERS_TABLE.get());
        registerRecipes(recipeManager, registry, ModRecipeTypes.LOOM_TABLE_TYPE.get(), ModBlocks.LOOM_TABLE.get());
        registerRecipes(recipeManager, registry, ModRecipeTypes.MASON_TABLE_TYPE.get(), ModBlocks.MASON_TABLE.get());
        registerRecipes(recipeManager, registry, ModRecipeTypes.ALCHEMY_BENCH_TYPE.get(), ModBlocks.ALCHEMY_BENCH.get());
        registerRecipes(recipeManager, registry, ModRecipeTypes.TINKERING_TABLE_TYPE.get(), ModBlocks.TINKERING_TABLE.get());
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
