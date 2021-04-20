package com.grimbo.chipped.recipe;

import com.google.gson.JsonObject;

import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.SingleItemRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class ChippedRecipe extends SingleItemRecipe {
	
	private Block icon;
	
	public ChippedRecipe(int serializerId, IRecipeType<?> type, ResourceLocation id, String group, Ingredient ingredient, ItemStack result, Block block) {
		this(type, fromId(serializerId), id, group, ingredient, result, block);
	}
	
	public ChippedRecipe(IRecipeType<?> type, IRecipeSerializer<?> serializer, ResourceLocation id, String group, Ingredient ingredient, ItemStack result, Block block) {
		super(type, serializer, id, group, ingredient, result);
		icon = block;
	}
	
	//Add new ids for each workbench recipe here
	public static IRecipeSerializer<?> fromId(int serializerId) {
		switch(serializerId) {
		case 0:
			return ChippedSerializer.BOTANIST_WORKBENCH.get();
		case 1:
			return ChippedSerializer.GLASSBLOWER.get();
		case 2:
			return ChippedSerializer.CARPENTERS_TABLE.get();
			case 3: return ChippedSerializer.LOOM_TABLE.get();
			case 4: return ChippedSerializer.MASON_TABLE.get();
			case 5: return ChippedSerializer.ALCHEMY_BENCH.get();
		default:
			return null;
		}
	}

	@Override
	public boolean matches(IInventory inv, World worldIn) {
		return this.ingredient.test(inv.getStackInSlot(0));
	}
	
	public ItemStack getIcon() {
		return new ItemStack(icon);
	}
	
	   public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ChippedRecipe> {
		   
		   private int id;
		   private IRecipeType<?> type;
		   private Block icon;
		   
		   public Serializer(int id, IRecipeType<?> type, Block icon) {
			   this.id = id;
			   this.type = type;
			   this.icon = icon;
		   }
		   
		   public ChippedRecipe read(ResourceLocation recipeId, JsonObject json) {
		       String s = JSONUtils.getString(json, "group", "");
		       Ingredient ingredient;
		       if (JSONUtils.isJsonArray(json, "ingredient")) {
		          ingredient = Ingredient.deserialize(JSONUtils.getJsonArray(json, "ingredient"));
		       } else {
		          ingredient = Ingredient.deserialize(JSONUtils.getJsonObject(json, "ingredient"));
		       }

		       String s1 = JSONUtils.getString(json, "result");
		       int i = JSONUtils.getInt(json, "count");
		       ItemStack itemstack = new ItemStack(Registry.ITEM.getOrDefault(new ResourceLocation(s1)), i);
		       return new ChippedRecipe(id, type, recipeId, s, ingredient, itemstack, icon);
		    }

		    public ChippedRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
		       String s = buffer.readString(32767);
		       Ingredient ingredient = Ingredient.read(buffer);
		       ItemStack itemstack = buffer.readItemStack();
		       return new ChippedRecipe(id, type, recipeId, s, ingredient, itemstack, icon);
		    }

		    public void write(PacketBuffer buffer, ChippedRecipe recipe) {
		       buffer.writeString(recipe.group);
		       recipe.ingredient.write(buffer);
		       buffer.writeItemStack(recipe.result);
		    }
	 }
}