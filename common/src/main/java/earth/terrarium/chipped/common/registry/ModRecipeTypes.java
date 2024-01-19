package earth.terrarium.chipped.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.recipes.ChippedRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipeTypes {
    public static final ResourcefulRegistry<RecipeType<?>> RECIPE_TYPES = ResourcefulRegistries.create(BuiltInRegistries.RECIPE_TYPE, Chipped.MOD_ID);

    public static final RegistryEntry<RecipeType<ChippedRecipe>> BOTANIST_WORKBENCH = register("botanist_workbench");
    public static final RegistryEntry<RecipeType<ChippedRecipe>> GLASSBLOWER = register("glassblower");
    public static final RegistryEntry<RecipeType<ChippedRecipe>> CARPENTERS_TABLE = register("carpenters_table");
    public static final RegistryEntry<RecipeType<ChippedRecipe>> LOOM_TABLE = register("loom_table");
    public static final RegistryEntry<RecipeType<ChippedRecipe>> MASON_TABLE = register("mason_table");
    public static final RegistryEntry<RecipeType<ChippedRecipe>> ALCHEMY_BENCH = register("alchemy_bench");
    public static final RegistryEntry<RecipeType<ChippedRecipe>> TINKERING_TABLE = register("tinkering_table");

    private static <T extends Recipe<?>> RegistryEntry<RecipeType<T>> register(String id) {
        return RECIPE_TYPES.register(id, () -> new RecipeType<>() {
            public String toString() {
                return id;
            }
        });
    }
}
