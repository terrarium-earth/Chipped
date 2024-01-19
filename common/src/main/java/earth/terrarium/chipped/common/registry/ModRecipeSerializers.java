package earth.terrarium.chipped.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.recipes.ChippedRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ModRecipeSerializers {
    public static final ResourcefulRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = ResourcefulRegistries.create(BuiltInRegistries.RECIPE_SERIALIZER, Chipped.MOD_ID);

    public static final RegistryEntry<ChippedRecipe.Serializer> BOTANIST_WORKBENCH = RECIPE_SERIALIZERS.register("botanist_workbench", () ->
        new ChippedRecipe.Serializer(ModRecipeTypes.BOTANIST_WORKBENCH, ModBlocks.BOTANIST_WORKBENCH));

    public static final RegistryEntry<ChippedRecipe.Serializer> GLASSBLOWER = RECIPE_SERIALIZERS.register("glassblower", () ->
        new ChippedRecipe.Serializer(ModRecipeTypes.GLASSBLOWER, ModBlocks.GLASSBLOWER));

    public static final RegistryEntry<ChippedRecipe.Serializer> CARPENTERS_TABLE = RECIPE_SERIALIZERS.register("carpenters_table", () ->
        new ChippedRecipe.Serializer(ModRecipeTypes.CARPENTERS_TABLE, ModBlocks.CARPENTERS_TABLE));

    public static final RegistryEntry<ChippedRecipe.Serializer> LOOM_TABLE = RECIPE_SERIALIZERS.register("loom_table", () ->
        new ChippedRecipe.Serializer(ModRecipeTypes.LOOM_TABLE, ModBlocks.LOOM_TABLE));

    public static final RegistryEntry<ChippedRecipe.Serializer> MASON_TABLE = RECIPE_SERIALIZERS.register("mason_table", () ->
        new ChippedRecipe.Serializer(ModRecipeTypes.MASON_TABLE, ModBlocks.MASON_TABLE));

    public static final RegistryEntry<ChippedRecipe.Serializer> ALCHEMY_BENCH = RECIPE_SERIALIZERS.register("alchemy_bench", () ->
        new ChippedRecipe.Serializer(ModRecipeTypes.ALCHEMY_BENCH, ModBlocks.ALCHEMY_BENCH));

    public static final RegistryEntry<ChippedRecipe.Serializer> TINKERING_TABLE = RECIPE_SERIALIZERS.register("tinkering_table", () ->
        new ChippedRecipe.Serializer(ModRecipeTypes.TINKERING_TABLE, ModBlocks.TINKERING_TABLE));
}
