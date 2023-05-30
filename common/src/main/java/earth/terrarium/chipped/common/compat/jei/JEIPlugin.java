package earth.terrarium.chipped.common.compat.jei;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.recipe.ChippedRecipe;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.ModRecipeTypes;
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
            new ChippedRecipeCategory(ModBlocks.BOTANIST_WORKBENCH.get().asItem(), ChippedRecipeCategory.BOTANIST_WORKBENCH_RECIPE, helper),
            new ChippedRecipeCategory(ModBlocks.GLASSBLOWER.get().asItem(), ChippedRecipeCategory.GLASSBLOWER_RECIPE, helper),
            new ChippedRecipeCategory(ModBlocks.CARPENTERS_TABLE.get().asItem(), ChippedRecipeCategory.CARPENTERS_TABLE_RECIPE, helper),
            new ChippedRecipeCategory(ModBlocks.LOOM_TABLE.get().asItem(), ChippedRecipeCategory.LOOM_TABLE_RECIPE, helper),
            new ChippedRecipeCategory(ModBlocks.MASON_TABLE.get().asItem(), ChippedRecipeCategory.MASON_TABLE_RECIPE, helper),
            new ChippedRecipeCategory(ModBlocks.ALCHEMY_BENCH.get().asItem(), ChippedRecipeCategory.ALCHEMY_BENCH_RECIPE, helper),
            new ChippedRecipeCategory(ModBlocks.TINKERING_TABLE.get().asItem(), ChippedRecipeCategory.TINKERING_TABLE_RECIPE, helper)

        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        registration.addRecipes(ChippedRecipeCategory.BOTANIST_WORKBENCH_RECIPE, flatten(recipeManager.getAllRecipesFor(ModRecipeTypes.BOTANIST_WORKBENCH_TYPE.get())));
        registration.addRecipes(ChippedRecipeCategory.GLASSBLOWER_RECIPE, flatten(recipeManager.getAllRecipesFor(ModRecipeTypes.GLASSBLOWER_TYPE.get())));
        registration.addRecipes(ChippedRecipeCategory.CARPENTERS_TABLE_RECIPE, flatten(recipeManager.getAllRecipesFor(ModRecipeTypes.CARPENTERS_TABLE_TYPE.get())));
        registration.addRecipes(ChippedRecipeCategory.LOOM_TABLE_RECIPE, flatten(recipeManager.getAllRecipesFor(ModRecipeTypes.LOOM_TABLE_TYPE.get())));
        registration.addRecipes(ChippedRecipeCategory.MASON_TABLE_RECIPE, flatten(recipeManager.getAllRecipesFor(ModRecipeTypes.MASON_TABLE_TYPE.get())));
        registration.addRecipes(ChippedRecipeCategory.ALCHEMY_BENCH_RECIPE, flatten(recipeManager.getAllRecipesFor(ModRecipeTypes.ALCHEMY_BENCH_TYPE.get())));
        registration.addRecipes(ChippedRecipeCategory.TINKERING_TABLE_RECIPE, flatten(recipeManager.getAllRecipesFor(ModRecipeTypes.TINKERING_TABLE_TYPE.get())));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.BOTANIST_WORKBENCH.get()), ChippedRecipeCategory.BOTANIST_WORKBENCH_RECIPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.GLASSBLOWER.get()), ChippedRecipeCategory.GLASSBLOWER_RECIPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CARPENTERS_TABLE.get()), ChippedRecipeCategory.CARPENTERS_TABLE_RECIPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.LOOM_TABLE.get()), ChippedRecipeCategory.LOOM_TABLE_RECIPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.MASON_TABLE.get()), ChippedRecipeCategory.MASON_TABLE_RECIPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ALCHEMY_BENCH.get()), ChippedRecipeCategory.ALCHEMY_BENCH_RECIPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.TINKERING_TABLE.get()), ChippedRecipeCategory.TINKERING_TABLE_RECIPE);
    }
}
