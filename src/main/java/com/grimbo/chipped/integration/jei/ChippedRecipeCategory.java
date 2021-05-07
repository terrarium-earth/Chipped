package com.grimbo.chipped.integration.jei;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.recipe.ChippedRecipe;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class ChippedRecipeCategory implements IRecipeCategory<ChippedRecipe> {

	public ResourceLocation UID;
	
    private static final int inputSlot = 0;
    private static final int outputSlot = 1;
    
	private static final int width = 82;
	private static final int height = 34;

	private String localizedName;
	private IDrawable background;
	private IDrawable icon;
	
	public ChippedRecipeCategory(String itemId, IGuiHelper guiHelper) {
		UID = new ResourceLocation(Chipped.MOD_ID, itemId);
		localizedName = I18n.format("container.chipped." + itemId);
		ResourceLocation location = new ResourceLocation("jei", "textures/gui/gui_vanilla.png");
		background = guiHelper.createDrawable(location, 0, 220, width, height);
		icon = guiHelper.createDrawableIngredient(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Chipped.MOD_ID, itemId))));
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
		ingredients.setOutput(VanillaTypes.ITEM, recipe.getRecipeOutput());
		
	}

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, ChippedRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
        guiItemStacks.init(inputSlot, true, 0, 8);
        guiItemStacks.init(outputSlot, false, 60, 8);
        guiItemStacks.set(ingredients);
    }

}
