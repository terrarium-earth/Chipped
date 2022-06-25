package com.grimbo.chipped.recipe;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChippedSerializer {
	
	//Add new IRecipeSerializers here, must keep ids in numerical order for ChippedRecipe::fromId
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Chipped.MOD_ID);
	
	public static final RegistryObject<RecipeSerializer<?>> BOTANIST_WORKBENCH = SERIALIZER.register("botanist_workbench",
			() -> new ChippedRecipe.Serializer(ChippedRecipeTypes.BOTANIST_WORKBENCH_TYPE.get(), ChippedBlocks.BOTANIST_WORKBENCH.get()));

	public static final RegistryObject<RecipeSerializer<?>> GLASSBLOWER = SERIALIZER.register("glassblower",
			() -> new ChippedRecipe.Serializer(ChippedRecipeTypes.GLASSBLOWER_TYPE.get(), ChippedBlocks.GLASSBLOWER.get()));

	public static final RegistryObject<RecipeSerializer<?>> CARPENTERS_TABLE = SERIALIZER.register("carpenters_table",
			() -> new ChippedRecipe.Serializer(ChippedRecipeTypes.CARPENTERS_TABLE_TYPE.get(), ChippedBlocks.CARPENTERS_TABLE.get()));

	public static final RegistryObject<RecipeSerializer<?>> LOOM_TABLE = SERIALIZER.register("loom_table",
			() -> new ChippedRecipe.Serializer(ChippedRecipeTypes.LOOM_TABLE_TYPE.get(), ChippedBlocks.LOOM_TABLE.get()));

	public static final RegistryObject<RecipeSerializer<?>> MASON_TABLE = SERIALIZER.register("mason_table",
			() -> new ChippedRecipe.Serializer(ChippedRecipeTypes.MASON_TABLE_TYPE.get(), ChippedBlocks.MASON_TABLE.get()));

	public static final RegistryObject<RecipeSerializer<?>> ALCHEMY_BENCH = SERIALIZER.register("alchemy_bench",
			() -> new ChippedRecipe.Serializer(ChippedRecipeTypes.ALCHEMY_BENCH_TYPE.get(), ChippedBlocks.ALCHEMY_BENCH.get()));

	public static final RegistryObject<RecipeSerializer<?>> MECHANIST_WORKBENCH = SERIALIZER.register("mechanist_workbench",
			() -> new ChippedRecipe.Serializer(ChippedRecipeTypes.MECHANIST_WORKBENCH_TYPE.get(), ChippedBlocks.MECHANIST_WORKBENCH.get()));
}