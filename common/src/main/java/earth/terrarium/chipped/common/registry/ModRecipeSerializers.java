package earth.terrarium.chipped.common.registry;

import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.recipe.ChippedRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Supplier;

public class ModRecipeSerializers {
    public static final ResourcefulRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = ResourcefulRegistries.create(Registry.RECIPE_SERIALIZER, Chipped.MOD_ID);

    public static final Supplier<ChippedRecipe.Serializer> BOTANIST_WORKBENCH_SERIALIZER = RECIPE_SERIALIZERS.register("botanist_workbench", () -> new ChippedRecipe.Serializer(ModRecipeTypes.BOTANIST_WORKBENCH_TYPE, ModBlocks.BOTANIST_WORKBENCH));
    public static final Supplier<ChippedRecipe.Serializer> GLASSBLOWER_SERIALIZER = RECIPE_SERIALIZERS.register("glassblower", () -> new ChippedRecipe.Serializer(ModRecipeTypes.GLASSBLOWER_TYPE, ModBlocks.GLASSBLOWER));
    public static final Supplier<ChippedRecipe.Serializer> CARPENTERS_TABLE_SERIALIZER = RECIPE_SERIALIZERS.register("carpenters_table", () -> new ChippedRecipe.Serializer(ModRecipeTypes.CARPENTERS_TABLE_TYPE, ModBlocks.CARPENTERS_TABLE));
    public static final Supplier<ChippedRecipe.Serializer> LOOM_TABLE_SERIALIZER = RECIPE_SERIALIZERS.register("loom_table", () -> new ChippedRecipe.Serializer(ModRecipeTypes.LOOM_TABLE_TYPE, ModBlocks.LOOM_TABLE));
    public static final Supplier<ChippedRecipe.Serializer> MASON_TABLE_SERIALIZER = RECIPE_SERIALIZERS.register("mason_table", () -> new ChippedRecipe.Serializer(ModRecipeTypes.MASON_TABLE_TYPE, ModBlocks.MASON_TABLE));
    public static final Supplier<ChippedRecipe.Serializer> ALCHEMY_BENCH_SERIALIZER = RECIPE_SERIALIZERS.register("alchemy_bench", () -> new ChippedRecipe.Serializer(ModRecipeTypes.ALCHEMY_BENCH_TYPE, ModBlocks.ALCHEMY_BENCH));
    public static final Supplier<ChippedRecipe.Serializer> TINKERING_TABLE_SERIALIZER = RECIPE_SERIALIZERS.register("tinkering_table", () -> new ChippedRecipe.Serializer(ModRecipeTypes.TINKERING_TABLE_TYPE, ModBlocks.TINKERING_TABLE));
}
