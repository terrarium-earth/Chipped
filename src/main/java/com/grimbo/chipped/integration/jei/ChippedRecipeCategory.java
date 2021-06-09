package com.grimbo.chipped.integration.jei;

import com.grimbo.chipped.recipe.ChippedRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ChippedRecipeCategory implements IRecipeCategory<ChippedRecipe> {

	private static final ResourceLocation TEXTURE = new ResourceLocation("jei", "textures/gui/gui_vanilla.png");

	private final ResourceLocation UID;

	private final String localizedName;
	private final IDrawable background;
	private final IDrawable icon;

	public ChippedRecipeCategory(Item item, IGuiHelper guiHelper) {
		UID = item.getRegistryName();
		localizedName = I18n.get("container.chipped." + UID.getPath());
		background = guiHelper.createDrawable(TEXTURE, 0, 220, 82, 34);
		icon = guiHelper.createDrawableIngredient(item.getDefaultInstance());
	}

	@Override
	public ResourceLocation getUid() {
		return UID;
	}

	@Override
	public Class<? extends ChippedRecipe> getRecipeClass() {
		return ChippedRecipe.class;
	}

	@Override
	public String getTitle() {
		return localizedName;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setIngredients(ChippedRecipe recipe, IIngredients ingredients) {
		ingredients.setInputIngredients(recipe.getIngredients());
		ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, ChippedRecipe recipe, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		guiItemStacks.init(0, true, 0, 8);
		guiItemStacks.init(1, false, 60, 8);
		guiItemStacks.set(ingredients);
	}

}
