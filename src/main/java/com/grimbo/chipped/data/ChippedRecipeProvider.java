package com.grimbo.chipped.data;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.ChippedTags;
import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.recipe.ChippedSerializer;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.SingleItemRecipeBuilder;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

public class ChippedRecipeProvider extends RecipeProvider {

	public ChippedRecipeProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}

	@Override
	protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
		for (String type : ChippedBlocks.stones18) {
			createRecipeFromType(type, ChippedSerializer.MASON_TABLE.get(), consumer);
		}
		
		createRecipeFromType("gilded_blackstone", ChippedSerializer.MASON_TABLE.get(), consumer);
		createRecipeFromType("blackstone", ChippedSerializer.MASON_TABLE.get(), consumer);
		createRecipeFromType("basalt", ChippedSerializer.MASON_TABLE.get(), consumer);
		createRecipeFromType("clay", ChippedSerializer.MASON_TABLE.get(), consumer);
		
		createRecipeFromType("obsidian", ChippedSerializer.ALCHEMY_BENCH.get(), consumer);
		createRecipeFromType("crying_obsidian", ChippedSerializer.ALCHEMY_BENCH.get(), consumer);
		
		createRecipeFromType("glass", ChippedSerializer.GLASSBLOWER.get(), consumer);
		createRecipeFromType("glass_pane", ChippedSerializer.GLASSBLOWER.get(), consumer);
		
		createRecipeFromType("hay_block", ChippedSerializer.BOTANIST_WORKBENCH.get(), consumer);
		createRecipeFromType("melon", ChippedSerializer.BOTANIST_WORKBENCH.get(), consumer);
		createRecipeFromType("vine", ChippedSerializer.BOTANIST_WORKBENCH.get(), consumer);
		createRecipeFromType("glowstone", ChippedSerializer.ALCHEMY_BENCH.get(), consumer);
		createRecipeFromType("sea_lantern", ChippedSerializer.ALCHEMY_BENCH.get(), consumer);
		createRecipeFromType("shroomlight", ChippedSerializer.BOTANIST_WORKBENCH.get(), consumer);
		createRecipeFromType("redstone_torch", ChippedSerializer.MECHANIST_WORKBENCH.get(), consumer);
		createRecipeFromType("pumpkin", ChippedSerializer.BOTANIST_WORKBENCH.get(), consumer);
		createRecipeFromType("jack_o_lantern", ChippedSerializer.BOTANIST_WORKBENCH.get(), consumer);
		createRecipeFromType("carved_pumpkin", ChippedSerializer.BOTANIST_WORKBENCH.get(), consumer);
		createRecipeFromType("lantern", ChippedSerializer.MECHANIST_WORKBENCH.get(), consumer);
		createRecipeFromType("soul_lantern", ChippedSerializer.MECHANIST_WORKBENCH.get(), consumer);
		createRecipeFromType("redstone_lamp", ChippedSerializer.MECHANIST_WORKBENCH.get(), consumer);

		for (String color : ChippedBlocks.colorsList) {
			createRecipeFromType(color + "_terracotta", ChippedSerializer.MASON_TABLE.get(), consumer);
			createRecipeFromType(color + "_concrete", ChippedSerializer.MASON_TABLE.get(), consumer);
			createRecipeFromType(color + "_wool", ChippedSerializer.LOOM_TABLE.get(), consumer);
			createRecipeFromType(color + "_carpet", ChippedSerializer.LOOM_TABLE.get(), consumer);
			createRecipeFromType(color + "_stained_glass", ChippedSerializer.GLASSBLOWER.get(), consumer);
			createRecipeFromType(color + "_stained_glass_pane", ChippedSerializer.GLASSBLOWER.get(), consumer);
		}
		
		for (String wood : ChippedBlocks.woodsList) {
			createRecipeFromType(wood + "_wood_glass", "glass", ChippedSerializer.GLASSBLOWER.get(), consumer);
			createRecipeFromType(wood + "_wood_glass_pane", "glass_pane", ChippedSerializer.GLASSBLOWER.get(), consumer);
			createRecipeFromType(wood + "_planks", ChippedSerializer.CARPENTERS_TABLE.get(), consumer);
		}
	}
	
	private static void createRecipeFromType(String type, IRecipeSerializer<?> serializer, Consumer<IFinishedRecipe> consumer) {
		chippedRecipe(serializer, 
				Ingredient.of(ChippedTags.items.get(type)), ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft", type)))
				.unlocks("has_item", has(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft", type))))
				.save(consumer, new ResourceLocation(Chipped.MOD_ID, serializer.getRegistryName().getPath() + "/" + type));
		for (RegistryObject<Block> block : ChippedBlocks.blocksMap.get(type)) {
			
			String name = block.get().getRegistryName().getPath();
			chippedRecipe(serializer, 
					Ingredient.of(ChippedTags.items.get(type)), block.get())
					.unlocks("has_item", has(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft", type))))
					.save(consumer, new ResourceLocation(Chipped.MOD_ID, serializer.getRegistryName().getPath() + "/" + name));
		}
	}
	
	private static void createRecipeFromType(String type, String type2, IRecipeSerializer<?> serializer, Consumer<IFinishedRecipe> consumer) {
		chippedRecipe(serializer, 
				Ingredient.of(ChippedTags.items.get(type)), ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft", type2)))
				.unlocks("has_item", has(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft", type2))))
				.save(consumer, new ResourceLocation(Chipped.MOD_ID, serializer.getRegistryName().getPath() + "/" + "default_" + type));
		for (RegistryObject<Block> block : ChippedBlocks.blocksMap.get(type)) {
			String name = block.get().getRegistryName().getPath();
			chippedRecipe(serializer, 
					Ingredient.of(ChippedTags.items.get(type)), block.get())
					.unlocks("has_item", has(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft", type2))))
					.save(consumer, new ResourceLocation(Chipped.MOD_ID, serializer.getRegistryName().getPath() + "/" + name));
		}
	}
	
	public static SingleItemRecipeBuilder chippedRecipe(IRecipeSerializer<?> serializer, Ingredient ingredientIn, IItemProvider resultIn) {
	    return new SingleItemRecipeBuilder(serializer, ingredientIn, resultIn, 1);
	}

	public static SingleItemRecipeBuilder chippedRecipe(IRecipeSerializer<?> serializer, Ingredient ingredientIn,
			IItemProvider resultIn, int countIn) {
		return new SingleItemRecipeBuilder(serializer, ingredientIn, resultIn, countIn);
	}
}
