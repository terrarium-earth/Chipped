package com.grimbo.chipped.recipe;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChippedSerializer {

	//Add new IRecipeTypes here
	public static final RecipeType<ChippedRecipe> BOTANIST_WORKBENCH_TYPE = RecipeType.register(Chipped.MOD_ID +":botanist_workbench");
	public static final RecipeType<ChippedRecipe> GLASSBLOWER_TYPE = RecipeType.register(Chipped.MOD_ID +":glassblower");
	public static final RecipeType<ChippedRecipe> CARPENTERS_TABLE_TYPE = RecipeType.register(Chipped.MOD_ID +":carpenters_table");
	public static final RecipeType<ChippedRecipe> LOOM_TABLE_TYPE = RecipeType.register(Chipped.MOD_ID +":loom_table");
	public static final RecipeType<ChippedRecipe> MASON_TABLE_TYPE = RecipeType.register(Chipped.MOD_ID +":mason_table");
	public static final RecipeType<ChippedRecipe> ALCHEMY_BENCH_TYPE = RecipeType.register(Chipped.MOD_ID +":alchemy_bench");
	public static final RecipeType<ChippedRecipe> MECHANIST_WORKBENCH_TYPE = RecipeType.register(Chipped.MOD_ID +":mechanist_workbench");
	
	//Add new IRecipeSerializers here, must keep ids in numerical order for ChippedRecipe::fromId
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Chipped.MOD_ID);
	
	public static final RegistryObject<RecipeSerializer<?>> BOTANIST_WORKBENCH = SERIALIZER.register("botanist_workbench",
			() -> new ChippedRecipe.Serializer(BOTANIST_WORKBENCH_TYPE, ChippedBlocks.BOTANIST_WORKBENCH.get()));

	public static final RegistryObject<RecipeSerializer<?>> GLASSBLOWER = SERIALIZER.register("glassblower",
			() -> new ChippedRecipe.Serializer(GLASSBLOWER_TYPE, ChippedBlocks.GLASSBLOWER.get()));

	public static final RegistryObject<RecipeSerializer<?>> CARPENTERS_TABLE = SERIALIZER.register("carpenters_table",
			() -> new ChippedRecipe.Serializer(CARPENTERS_TABLE_TYPE, ChippedBlocks.CARPENTERS_TABLE.get()));

	public static final RegistryObject<RecipeSerializer<?>> LOOM_TABLE = SERIALIZER.register("loom_table",
			() -> new ChippedRecipe.Serializer(LOOM_TABLE_TYPE, ChippedBlocks.LOOM_TABLE.get()));

	public static final RegistryObject<RecipeSerializer<?>> MASON_TABLE = SERIALIZER.register("mason_table",
			() -> new ChippedRecipe.Serializer(MASON_TABLE_TYPE, ChippedBlocks.MASON_TABLE.get()));

	public static final RegistryObject<RecipeSerializer<?>> ALCHEMY_BENCH = SERIALIZER.register("alchemy_bench",
			() -> new ChippedRecipe.Serializer(ALCHEMY_BENCH_TYPE, ChippedBlocks.ALCHEMY_BENCH.get()));

	public static final RegistryObject<RecipeSerializer<?>> MECHANIST_WORKBENCH = SERIALIZER.register("mechanist_workbench",
			() -> new ChippedRecipe.Serializer(MECHANIST_WORKBENCH_TYPE, ChippedBlocks.MECHANIST_WORKBENCH.get()));
}