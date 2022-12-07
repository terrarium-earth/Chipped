package earth.terrarium.chipped.registry;

import earth.terrarium.chipped.recipe.ChippedRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Supplier;

public class ModRecipeSerializers {

    public static void register() {
        registerSerializer("botanist_workbench", () -> new ChippedRecipe.Serializer(ModRecipeTypes.BOTANIST_WORKBENCH_TYPE, ModBlocks.BOTANIST_WORKBENCH));
        registerSerializer("glassblower", () -> new ChippedRecipe.Serializer(ModRecipeTypes.GLASSBLOWER_TYPE, ModBlocks.GLASSBLOWER));
        registerSerializer("carpenters_table", () -> new ChippedRecipe.Serializer(ModRecipeTypes.CARPENTERS_TABLE_TYPE, ModBlocks.CARPENTERS_TABLE));
        registerSerializer("loom_table", () -> new ChippedRecipe.Serializer(ModRecipeTypes.LOOM_TABLE_TYPE, ModBlocks.LOOM_TABLE));
        registerSerializer("mason_table", () -> new ChippedRecipe.Serializer(ModRecipeTypes.MASON_TABLE_TYPE, ModBlocks.MASON_TABLE));
        registerSerializer("alchemy_bench", () -> new ChippedRecipe.Serializer(ModRecipeTypes.ALCHEMY_BENCH_TYPE, ModBlocks.ALCHEMY_BENCH));
        registerSerializer("mechanist_workbench", () -> new ChippedRecipe.Serializer(ModRecipeTypes.MECHANIST_WORKBENCH_TYPE, ModBlocks.MECHANIST_WORKBENCH));
    }

    private static <T extends RecipeSerializer<E>, E extends Recipe<?>> Supplier<T> registerSerializer(String id, Supplier<T> serializer) {
        return ModRegistryHelpers.register(Registry.RECIPE_SERIALIZER, id, serializer);
    }
}
