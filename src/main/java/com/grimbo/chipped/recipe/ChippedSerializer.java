package com.grimbo.chipped.recipe;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ChippedSerializer {

	//Add new IRecipeTypes here
	public static final IRecipeType<ChippedRecipe> BOTANIST_WORKBENCH_TYPE = IRecipeType.register("botanist_workbench");
	
	//Add new IRecipeSerializers here
	public static final DeferredRegister<IRecipeSerializer<?>> SERIALIZER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Chipped.MOD_ID);
	
	public static final RegistryObject<IRecipeSerializer<?>> BOTANIST_WORKBENCH = SERIALIZER.register("botanist_workbench", 
			() -> new ChippedRecipe.Serializer(0, ChippedSerializer.BOTANIST_WORKBENCH_TYPE, ChippedBlocks.BOTANIST_WORKBENCH.get()));
	
}