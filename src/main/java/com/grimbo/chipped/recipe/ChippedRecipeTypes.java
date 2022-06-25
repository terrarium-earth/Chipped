package com.grimbo.chipped.recipe;

import com.grimbo.chipped.Chipped;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChippedRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, Chipped.MOD_ID);

    public static final RegistryObject<RecipeType<ChippedRecipe>> BOTANIST_WORKBENCH_TYPE = RECIPE_TYPES.register("botanist_workbench",
            () -> RecipeType.simple(new ResourceLocation(Chipped.MOD_ID, "botanist_workbench")));

    public static final RegistryObject<RecipeType<ChippedRecipe>> GLASSBLOWER_TYPE = RECIPE_TYPES.register("glassblower",
            () -> RecipeType.simple(new ResourceLocation(Chipped.MOD_ID, "glassblower")));
    public static final RegistryObject<RecipeType<ChippedRecipe>> CARPENTERS_TABLE_TYPE = RECIPE_TYPES.register("carpenters_table",
            () -> RecipeType.simple(new ResourceLocation(Chipped.MOD_ID, "carpenters_table")));
    public static final RegistryObject<RecipeType<ChippedRecipe>> LOOM_TABLE_TYPE = RECIPE_TYPES.register("loom_table",
            () -> RecipeType.simple(new ResourceLocation(Chipped.MOD_ID, "loom_table")));
    public static final RegistryObject<RecipeType<ChippedRecipe>> MASON_TABLE_TYPE = RECIPE_TYPES.register("mason_table",
            () -> RecipeType.simple(new ResourceLocation(Chipped.MOD_ID, "mason_table")));
    public static final RegistryObject<RecipeType<ChippedRecipe>> ALCHEMY_BENCH_TYPE = RECIPE_TYPES.register("alchemy_bench",
            () -> RecipeType.simple(new ResourceLocation(Chipped.MOD_ID, "alchemy_bench")));
    public static final RegistryObject<RecipeType<ChippedRecipe>> MECHANIST_WORKBENCH_TYPE = RECIPE_TYPES.register("mechanist_workbench",
            () -> RecipeType.simple(new ResourceLocation(Chipped.MOD_ID, "mechanist_workbench")));
}
