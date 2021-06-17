package com.grimbo.chipped.recipe;

import com.google.gson.JsonObject;
import com.mojang.realmsclient.util.JsonUtils;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class ChippedRecipe extends SingleItemRecipe {

    private final Block icon;

    public ChippedRecipe(RecipeType<?> type, RecipeSerializer<?> serializer, ResourceLocation id, String group, Ingredient ingredient, ItemStack result, Block block) {
        super(type, serializer, id, group, ingredient, result);
        this.icon = block;
    }
    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(icon);
    }

    @Override
    public boolean matches(Container inv, Level worldIn) {
        return this.ingredient.test(inv.getItem(0));
    }


    public record Serializer(RecipeType<?> type, Block icon) implements RecipeSerializer<ChippedRecipe> {

        public ChippedRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            String s = JsonUtils.getStringOr("group", json, "");
            Ingredient ingredient;
            if (GsonHelper.isArrayNode(json, "ingredient")) {
                ingredient = Ingredient.fromJson(GsonHelper.getAsJsonArray(json, "ingredient"));
            } else {
                ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "ingredient"));
            }

            String s1 = GsonHelper.getAsString(json, "result");
            int i = GsonHelper.getAsInt(json, "count");
            ItemStack itemstack = new ItemStack(Registry.ITEM.get(new ResourceLocation(s1)), i);
            return new ChippedRecipe(type, this, recipeId, s, ingredient, itemstack, icon);
        }

        public ChippedRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            String s = buffer.readUtf(32767);
            Ingredient ingredient = Ingredient.fromNetwork(buffer);
            ItemStack itemstack = buffer.readItem();
            return new ChippedRecipe(type, this, recipeId, s, ingredient, itemstack, icon);
        }

        public void toNetwork(FriendlyByteBuf buffer, ChippedRecipe recipe) {
            buffer.writeUtf(recipe.group);
            recipe.ingredient.toNetwork(buffer);
            buffer.writeItem(recipe.result);
        }
    }
}