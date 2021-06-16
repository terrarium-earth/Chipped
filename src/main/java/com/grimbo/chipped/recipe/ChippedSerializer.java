package com.grimbo.chipped.recipe;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlocks;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class ChippedSerializer {

	//Add new RecipeTypes here
	public static final RecipeType<ChippedRecipe> BOTANIST_WORKBENCH_TYPE = RecipeType.register("botanist_workbench");
	public static final RecipeType<ChippedRecipe> GLASSBLOWER_TYPE = RecipeType.register("glassblower");
	public static final RecipeType<ChippedRecipe> CARPENTERS_TABLE_TYPE = RecipeType.register("carpenters_table");
	public static final RecipeType<ChippedRecipe> LOOM_TABLE_TYPE = RecipeType.register("loom_table");
	public static final RecipeType<ChippedRecipe> MASON_TABLE_TYPE = RecipeType.register("mason_table");
	public static final RecipeType<ChippedRecipe> ALCHEMY_BENCH_TYPE = RecipeType.register("alchemy_bench");
	public static final RecipeType<ChippedRecipe> MECHANIST_WORKBENCH_TYPE = RecipeType.register("mechanist_workbench");
	
	//Add new RecipeSerializers here, must keep ids in numerical order for ChippedRecipe::fromId
	public static final RecipeSerializer<?> BOTANIST_WORKBENCH = Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(Chipped.MOD_ID, "botanist_workbench"), new ChippedRecipe.Serializer(ALCHEMY_BENCH_TYPE, ChippedBlocks.ALCHEMY_BENCH));
	public static final RecipeSerializer<?> GLASSBLOWER = Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(Chipped.MOD_ID, "glassblower"), new ChippedRecipe.Serializer(BOTANIST_WORKBENCH_TYPE, ChippedBlocks.BOTANIST_WORKBENCH));
	public static final RecipeSerializer<?> CARPENTERS_TABLE = Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(Chipped.MOD_ID, "carpenters_table"), new ChippedRecipe.Serializer(CARPENTERS_TABLE_TYPE, ChippedBlocks.CARPENTERS_TABLE));
	public static final RecipeSerializer<?> LOOM_TABLE = Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(Chipped.MOD_ID, "loom_table"), new ChippedRecipe.Serializer(LOOM_TABLE_TYPE, ChippedBlocks.LOOM_TABLE));
	public static final RecipeSerializer<?> MASON_TABLE = Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(Chipped.MOD_ID, "mason_table"), new ChippedRecipe.Serializer(MASON_TABLE_TYPE, ChippedBlocks.MASON_TABLE));
	public static final RecipeSerializer<?> ALCHEMY_BENCH = Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(Chipped.MOD_ID, "alchemy_bench"), new ChippedRecipe.Serializer(ALCHEMY_BENCH_TYPE, ChippedBlocks.ALCHEMY_BENCH));
	public static final RecipeSerializer<?> MECHANIST_WORKBENCH = Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(Chipped.MOD_ID, "alchemy_bench"),  new ChippedRecipe.Serializer(MECHANIST_WORKBENCH_TYPE, ChippedBlocks.MECHANIST_WORKBENCH));

}