package com.grimbo.chipped.data;

import java.util.ArrayList;
import java.util.function.Consumer;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.ChippedTags;
import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.recipe.ChippedSerializer;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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

public class ChippedRecipeProvider extends RecipeProvider {

	public ChippedRecipeProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}

	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		createRecipeFromList(ChippedBlocks.stones, ChippedSerializer.MASON_TABLE.get(), consumer);
		createRecipeFromList(ChippedBlocks.wools, ChippedSerializer.LOOM_TABLE.get(), consumer);
		createRecipeFromList(ChippedBlocks.carpets, ChippedSerializer.LOOM_TABLE.get(), consumer);
		createRecipeFromList(ChippedBlocks.stainedGlasses, ChippedSerializer.GLASSBLOWER.get(), consumer);
		createRecipeFromList(ChippedBlocks.hayBlock, ChippedSerializer.BOTANIST_WORKBENCH.get(), consumer);
		createRecipeFromList(ChippedBlocks.clays, ChippedSerializer.MASON_TABLE.get(), consumer);
		createRecipeFromList(ChippedBlocks.terracottas, ChippedSerializer.MASON_TABLE.get(), consumer);
		createRecipeFromList(ChippedBlocks.concretes, ChippedSerializer.MASON_TABLE.get(), consumer);
		createRecipeFromList(ChippedBlocks.woods, ChippedSerializer.CARPENTERS_TABLE.get(), consumer);
		
		//Glass + Wood Glass
		chippedRecipe(ChippedSerializer.GLASSBLOWER.get(), 
				Ingredient.fromTag(ChippedTags.items.get("glass")), 
				Blocks.GLASS)
				.addCriterion("has_item", hasItem(Blocks.GLASS))
				.build(consumer, new ResourceLocation(Chipped.MOD_ID, ChippedSerializer.GLASSBLOWER.get().getRegistryName().getPath() + "/glass"));
		for (RegistryObject<Block> block : ChippedBlocks.glasses) {
			String name = block.get().getRegistryName().getPath();
			String name2 = name.split("_([1-9])")[0];
			chippedRecipe(ChippedSerializer.GLASSBLOWER.get(), 
					Ingredient.fromTag(ChippedTags.items.get(name2)), 
					block.get())
					.addCriterion("has_item", hasItem(Blocks.GLASS))
					.build(consumer, new ResourceLocation(Chipped.MOD_ID, ChippedSerializer.GLASSBLOWER.get().getRegistryName().getPath() + "/" + name));
		}
		
		//Vines
		//Currently no undo, waiting for new vines
		createRecipeFromBlock(ChippedBlocks.VINE_1.get(), ChippedSerializer.BOTANIST_WORKBENCH.get(), consumer);
	}
	
	private static void createRecipeFromBlock(Block block, IRecipeSerializer<?> serializer, Consumer<IFinishedRecipe> consumer) {
		String name = block.getRegistryName().getPath();
		chippedRecipe(serializer, 
				Ingredient.fromTag(ChippedTags.items.get(name.split("_([1-9])")[0])), 
				block)
				.addCriterion("has_item", hasItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft:" + name))))
				.build(consumer, new ResourceLocation(Chipped.MOD_ID, serializer.getRegistryName().getPath() + "/" + name));
	}
	
	private static void createRecipeFromList(ArrayList<RegistryObject<Block>> list, IRecipeSerializer<?> serializer, Consumer<IFinishedRecipe> consumer) {
		String previousName = "";
		for (RegistryObject<Block> block : list) {
			String name = block.get().getRegistryName().getPath();
			String name2 = name.split("_([1-9])")[0];
			Block vanillaBlock = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft:" + name2));
			if (!previousName.equals(name2)) {
				chippedRecipe(serializer, 
						Ingredient.fromTag(ChippedTags.items.get(name2)), 
						vanillaBlock)
						.addCriterion("has_item", hasItem(vanillaBlock))
						.build(consumer, new ResourceLocation(Chipped.MOD_ID, serializer.getRegistryName().getPath() + "/" + name2));
			}
			chippedRecipe(serializer, 
					Ingredient.fromTag(ChippedTags.items.get(name2)), 
					block.get())
					.addCriterion("has_item", hasItem(vanillaBlock))
					.build(consumer, new ResourceLocation(Chipped.MOD_ID, serializer.getRegistryName().getPath() + "/" + name));
			previousName = name2;
		}
	}
	
	public static SingleItemRecipeBuilder chippedRecipe(IRecipeSerializer<?> serializer, Ingredient ingredientIn, IItemProvider resultIn) {
	    return new SingleItemRecipeBuilder(serializer, ingredientIn, resultIn, 1);
	}

	public static SingleItemRecipeBuilder chippedRecipe(IRecipeSerializer<?> serializer, Ingredient ingredientIn, IItemProvider resultIn, int countIn) {
	    return new SingleItemRecipeBuilder(serializer, ingredientIn, resultIn, countIn);
	}
}
