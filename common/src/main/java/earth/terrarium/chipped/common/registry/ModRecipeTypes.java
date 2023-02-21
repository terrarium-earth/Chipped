package earth.terrarium.chipped.common.registry;

import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.recipe.ChippedRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

public class ModRecipeTypes {
    public static final ResourcefulRegistry<RecipeType<?>> RECIPE_TYPES = ResourcefulRegistries.create(Registry.RECIPE_TYPE, Chipped.MOD_ID);

    public static final Supplier<RecipeType<ChippedRecipe>> BOTANIST_WORKBENCH_TYPE = register("botanist_workbench");
    public static final Supplier<RecipeType<ChippedRecipe>> GLASSBLOWER_TYPE = register("glassblower");
    public static final Supplier<RecipeType<ChippedRecipe>> CARPENTERS_TABLE_TYPE = register("carpenters_table");
    public static final Supplier<RecipeType<ChippedRecipe>> LOOM_TABLE_TYPE = register("loom_table");
    public static final Supplier<RecipeType<ChippedRecipe>> MASON_TABLE_TYPE = register("mason_table");
    public static final Supplier<RecipeType<ChippedRecipe>> ALCHEMY_BENCH_TYPE = register("alchemy_bench");
    public static final Supplier<RecipeType<ChippedRecipe>> TINKERING_TABLE_TYPE = register("mechanist_workbench");

    private static <T extends Recipe<?>> Supplier<RecipeType<T>> register(String id) {
        return RECIPE_TYPES.register(id, () -> new RecipeType<>() {
            public String toString() {
                return id;
            }
        });
    }
}
