package earth.terrarium.chipped.registry;

import earth.terrarium.chipped.recipe.ChippedRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Supplier;

public class ChippedSerializer {

    public static void register() {
        registerSerializer("botanist_workbench", () -> new ChippedRecipe.Serializer(ChippedRecipeTypes.BOTANIST_WORKBENCH_TYPE, ChippedBlocks.BOTANIST_WORKBENCH));
        registerSerializer("glassblower", () -> new ChippedRecipe.Serializer(ChippedRecipeTypes.GLASSBLOWER_TYPE, ChippedBlocks.GLASSBLOWER));
        registerSerializer("carpenters_table", () -> new ChippedRecipe.Serializer(ChippedRecipeTypes.CARPENTERS_TABLE_TYPE, ChippedBlocks.CARPENTERS_TABLE));
        registerSerializer("loom_table", () -> new ChippedRecipe.Serializer(ChippedRecipeTypes.LOOM_TABLE_TYPE, ChippedBlocks.LOOM_TABLE));
        registerSerializer("mason_table", () -> new ChippedRecipe.Serializer(ChippedRecipeTypes.MASON_TABLE_TYPE, ChippedBlocks.MASON_TABLE));
        registerSerializer("alchemy_bench", () -> new ChippedRecipe.Serializer(ChippedRecipeTypes.ALCHEMY_BENCH_TYPE, ChippedBlocks.ALCHEMY_BENCH));
        registerSerializer("mechanist_workbench", () -> new ChippedRecipe.Serializer(ChippedRecipeTypes.MECHANIST_WORKBENCH_TYPE, ChippedBlocks.MECHANIST_WORKBENCH));
    }

    private static <T extends RecipeSerializer<E>, E extends Recipe<?>> Supplier<T> registerSerializer(String id, Supplier<T> serializer) {
        return RegistryHelpers.register(Registry.RECIPE_SERIALIZER, id, serializer);
    }
}
