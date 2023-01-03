package earth.terrarium.chipped.registry;

import earth.terrarium.chipped.recipe.ChippedRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Supplier;

public class ModRecipeSerializers {
    public static final Supplier<ChippedRecipe.Serializer> BOTANIST_WORKBENCH_SERIALIZER = init("botanist_workbench", () -> new ChippedRecipe.Serializer(ModRecipeTypes.BOTANIST_WORKBENCH_TYPE, ModBlocks.BOTANIST_WORKBENCH));
    public static final Supplier<ChippedRecipe.Serializer> GLASSBLOWER_SERIALIZER = init("glassblower", () -> new ChippedRecipe.Serializer(ModRecipeTypes.GLASSBLOWER_TYPE, ModBlocks.GLASSBLOWER));
    public static final Supplier<ChippedRecipe.Serializer> CARPENTERS_TABLE_SERIALIZER = init("carpenters_table", () -> new ChippedRecipe.Serializer(ModRecipeTypes.CARPENTERS_TABLE_TYPE, ModBlocks.CARPENTERS_TABLE));
    public static final Supplier<ChippedRecipe.Serializer> LOOM_TABLE_SERIALIZER = init("loom_table", () -> new ChippedRecipe.Serializer(ModRecipeTypes.LOOM_TABLE_TYPE, ModBlocks.LOOM_TABLE));
    public static final Supplier<ChippedRecipe.Serializer> MASON_TABLE_SERIALIZER = init("mason_table", () -> new ChippedRecipe.Serializer(ModRecipeTypes.MASON_TABLE_TYPE, ModBlocks.MASON_TABLE));
    public static final Supplier<ChippedRecipe.Serializer> ALCHEMY_BENCH_SERIALIZER = init("alchemy_bench", () -> new ChippedRecipe.Serializer(ModRecipeTypes.ALCHEMY_BENCH_TYPE, ModBlocks.ALCHEMY_BENCH));
    public static final Supplier<ChippedRecipe.Serializer> MECHANIST_WORKBENCH_SERIALIZER = init("mechanist_workbench", () -> new ChippedRecipe.Serializer(ModRecipeTypes.MECHANIST_WORKBENCH_TYPE, ModBlocks.MECHANIST_WORKBENCH));

    private static <T extends RecipeSerializer<E>, E extends Recipe<?>> Supplier<T> init(String id, Supplier<T> serializer) {
        return ModRegistryHelpers.register(Registry.RECIPE_SERIALIZER, id, serializer);
    }

    public static void init() {
    }
}
