package com.grimbo.chipped.integration.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.tags.Tag;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class ChippedRecipeCategory implements IRecipeCategory<ChippedRecipeCategory.FlattenedRecipe> {

	private static final ResourceLocation TEXTURE = new ResourceLocation("jei", "textures/gui/gui_vanilla.png");

	private final ResourceLocation UID;

	private final String localizedName;
	private final IDrawable background;
	private final IDrawable icon;

	public ChippedRecipeCategory(Item item, IGuiHelper guiHelper) {
		UID = item.getRegistryName();
		localizedName = I18n.get("container.chipped." + UID.getPath());
		background = guiHelper.createDrawable(TEXTURE, 0, 220, 82, 34);
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM, item.getDefaultInstance());
	}

	@Override
	public @NotNull ResourceLocation getUid() {
		return UID;
	}

	@Override
	public @NotNull Class<? extends FlattenedRecipe> getRecipeClass() {
		return FlattenedRecipe.class;
	}

	@Override
	public Component getTitle() {
		return new TextComponent(localizedName);
	}

	@Override
	public @NotNull IDrawable getBackground() {
		return background;
	}

	@Override
	public @NotNull IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setIngredients(FlattenedRecipe recipe, IIngredients ingredients) {
		ingredients.setInputIngredients(Collections.singletonList(recipe.tag));
		ingredients.setOutput(VanillaTypes.ITEM, recipe.result);
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, @NotNull FlattenedRecipe recipe, @NotNull IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		guiItemStacks.init(0, true, 0, 8);
		guiItemStacks.init(1, false, 60, 8);
		guiItemStacks.set(ingredients);
	}

	public record FlattenedRecipe(Ingredient tag, ItemStack result) {}
}
