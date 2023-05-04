package earth.terrarium.chipped.common.fabric.compat.emi;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import earth.terrarium.chipped.common.recipe.ChippedRecipe;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.ModRecipeTypes;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EMIChippedPlugin implements EmiPlugin {
    public static final EmiRecipeCategory BOTANIST_WORKBENCH_CATEGORY = new ChippedEmiRecipeCategory(ModBlocks.BOTANIST_WORKBENCH.get());
    public static final EmiRecipeCategory GLASSBLOWER_CATEGORY = new ChippedEmiRecipeCategory(ModBlocks.GLASSBLOWER.get());
    public static final EmiRecipeCategory CARPENTERS_TABLE_CATEGORY = new ChippedEmiRecipeCategory(ModBlocks.CARPENTERS_TABLE.get());
    public static final EmiRecipeCategory LOOM_TABLE_CATEGORY = new ChippedEmiRecipeCategory(ModBlocks.LOOM_TABLE.get());
    public static final EmiRecipeCategory MASON_TABLE_CATEGORY = new ChippedEmiRecipeCategory(ModBlocks.MASON_TABLE.get());
    public static final EmiRecipeCategory ALCHEMY_BENCH_CATEGORY = new ChippedEmiRecipeCategory(ModBlocks.ALCHEMY_BENCH.get());
    public static final EmiRecipeCategory TINKERING_TABLE_CATEGORY = new ChippedEmiRecipeCategory(ModBlocks.TINKERING_TABLE.get());

    @Override
    public void register(EmiRegistry registry) {
        // categories
        registry.addCategory(BOTANIST_WORKBENCH_CATEGORY);
        registry.addCategory(GLASSBLOWER_CATEGORY);
        registry.addCategory(CARPENTERS_TABLE_CATEGORY);
        registry.addCategory(LOOM_TABLE_CATEGORY);
        registry.addCategory(MASON_TABLE_CATEGORY);
        registry.addCategory(ALCHEMY_BENCH_CATEGORY);
        registry.addCategory(TINKERING_TABLE_CATEGORY);
        
        // workstations
        registry.addWorkstation(BOTANIST_WORKBENCH_CATEGORY, EmiStack.of(ModBlocks.BOTANIST_WORKBENCH.get()));
        registry.addWorkstation(GLASSBLOWER_CATEGORY, EmiStack.of(ModBlocks.GLASSBLOWER.get()));
        registry.addWorkstation(CARPENTERS_TABLE_CATEGORY, EmiStack.of(ModBlocks.CARPENTERS_TABLE.get()));
        registry.addWorkstation(LOOM_TABLE_CATEGORY, EmiStack.of(ModBlocks.LOOM_TABLE.get()));
        registry.addWorkstation(MASON_TABLE_CATEGORY, EmiStack.of(ModBlocks.MASON_TABLE.get()));
        registry.addWorkstation(ALCHEMY_BENCH_CATEGORY, EmiStack.of(ModBlocks.ALCHEMY_BENCH.get()));
        registry.addWorkstation(TINKERING_TABLE_CATEGORY, EmiStack.of(ModBlocks.TINKERING_TABLE.get()));

        // recipes
        RecipeManager manager = registry.getRecipeManager();
        flatten(manager.getAllRecipesFor(ModRecipeTypes.BOTANIST_WORKBENCH_TYPE.get()), BOTANIST_WORKBENCH_CATEGORY)
                .forEach(registry::addRecipe);
        flatten(manager.getAllRecipesFor(ModRecipeTypes.GLASSBLOWER_TYPE.get()), GLASSBLOWER_CATEGORY)
                .forEach(registry::addRecipe);
        flatten(manager.getAllRecipesFor(ModRecipeTypes.CARPENTERS_TABLE_TYPE.get()), CARPENTERS_TABLE_CATEGORY)
                .forEach(registry::addRecipe);
        flatten(manager.getAllRecipesFor(ModRecipeTypes.LOOM_TABLE_TYPE.get()), LOOM_TABLE_CATEGORY)
                .forEach(registry::addRecipe);
        flatten(manager.getAllRecipesFor(ModRecipeTypes.MASON_TABLE_TYPE.get()), MASON_TABLE_CATEGORY)
                .forEach(registry::addRecipe);
        flatten(manager.getAllRecipesFor(ModRecipeTypes.ALCHEMY_BENCH_TYPE.get()), ALCHEMY_BENCH_CATEGORY)
                .forEach(registry::addRecipe);
        flatten(manager.getAllRecipesFor(ModRecipeTypes.TINKERING_TABLE_TYPE.get()), TINKERING_TABLE_CATEGORY)
                .forEach(registry::addRecipe);
    }

    private static List<ChippedEmiRecipe> flatten(Collection<ChippedRecipe> recipes, EmiRecipeCategory category) {
        List<ChippedEmiRecipe> flattenedRecipes = new ArrayList<>();
        for (ChippedRecipe recipe : recipes) {
            for (HolderSet<Item> tag : recipe.tags()) {
                var items = tag.stream().filter(Holder::isBound).map(Holder::value).toList();
                EmiIngredient ingredient;
                if (tag instanceof HolderSet.Named<Item> named) {
                    ingredient = EmiIngredient.of(named.key());
                } else {
                    ingredient = EmiIngredient.of(items.stream().map(EmiStack::of).toList());
                }
                for (Item item : items) {
                    String namespace = recipe.id().getNamespace();
                    String path = recipe.id().getPath() + "/" + Registry.ITEM.getKey(item).toString().replace(":", "/");
                    ResourceLocation id = new ResourceLocation(namespace, path);
                    flattenedRecipes.add(new ChippedEmiRecipe(ingredient, item, category, id));
                }
            }
        }
        return flattenedRecipes;
    }

    private static class ChippedEmiRecipeCategory extends EmiRecipeCategory {
        public ChippedEmiRecipeCategory(Block block) {
            super(Registry.BLOCK.getKey(block), EmiStack.of(block));
        }

        @Override
        public Component getName() {
            return Component.translatable("container.chipped." + id.getPath());
        }
    }
}
