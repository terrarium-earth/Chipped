package com.grimbo.chipped.registry;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.recipe.ChippedRecipe;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class ChippedSerializer {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Chipped.MOD_ID, Registry.RECIPE_TYPE_REGISTRY);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Chipped.MOD_ID, Registry.RECIPE_SERIALIZER_REGISTRY);

    // Add new RecipeTypes here
    public static final RegistrySupplier<RecipeType<ChippedRecipe>> BOTANIST_WORKBENCH_TYPE = register("botanist_workbench");
    public static final RegistrySupplier<RecipeType<ChippedRecipe>> GLASSBLOWER_TYPE = register("glassblower");
    public static final RegistrySupplier<RecipeType<ChippedRecipe>> CARPENTERS_TABLE_TYPE = register("carpenters_table");
    public static final RegistrySupplier<RecipeType<ChippedRecipe>> LOOM_TABLE_TYPE = register("loom_table");
    public static final RegistrySupplier<RecipeType<ChippedRecipe>> MASON_TABLE_TYPE = register("mason_table");
    public static final RegistrySupplier<RecipeType<ChippedRecipe>> ALCHEMY_BENCH_TYPE = register("alchemy_bench");
    public static final RegistrySupplier<RecipeType<ChippedRecipe>> MECHANIST_WORKBENCH_TYPE = register("mechanist_workbench");

    public static void register() {

        RECIPE_TYPES.register();

        RECIPE_SERIALIZERS.register("botanist_workbench", () -> new ChippedRecipe.Serializer(BOTANIST_WORKBENCH_TYPE.get(), ChippedBlocks.BOTANIST_WORKBENCH.get()));
        RECIPE_SERIALIZERS.register("glassblower", () -> new ChippedRecipe.Serializer(GLASSBLOWER_TYPE.get(), ChippedBlocks.GLASSBLOWER.get()));
        RECIPE_SERIALIZERS.register("carpenters_table", () -> new ChippedRecipe.Serializer(CARPENTERS_TABLE_TYPE.get(), ChippedBlocks.CARPENTERS_TABLE.get()));
        RECIPE_SERIALIZERS.register("loom_table", () -> new ChippedRecipe.Serializer(LOOM_TABLE_TYPE.get(), ChippedBlocks.LOOM_TABLE.get()));
        RECIPE_SERIALIZERS.register("mason_table", () -> new ChippedRecipe.Serializer(MASON_TABLE_TYPE.get(), ChippedBlocks.MASON_TABLE.get()));
        RECIPE_SERIALIZERS.register("alchemy_bench", () -> new ChippedRecipe.Serializer(ALCHEMY_BENCH_TYPE.get(), ChippedBlocks.ALCHEMY_BENCH.get()));
        RECIPE_SERIALIZERS.register("mechanist_workbench", () -> new ChippedRecipe.Serializer(MECHANIST_WORKBENCH_TYPE.get(), ChippedBlocks.MECHANIST_WORKBENCH.get()));

        RECIPE_SERIALIZERS.register();
    }


    private static <T extends Recipe<?>> RegistrySupplier<RecipeType<T>> register(String identifier) {
		return RECIPE_TYPES.register(identifier, () -> new RecipeType<T>() {
			public String toString() {
				return identifier;
			}
		});
	}
}
