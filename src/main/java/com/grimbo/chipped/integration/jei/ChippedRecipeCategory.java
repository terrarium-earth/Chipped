package com.grimbo.chipped.integration.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class ChippedRecipeCategory implements IRecipeCategory<ChippedRecipeCategory.FlattenedRecipe> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("jei", "textures/gui/gui_vanilla.png");

	private final RecipeType<ChippedRecipeCategory.FlattenedRecipe> recipeType;
	private final ResourceLocation itemKey;

	private final String localizedName;
	private final IDrawable background;
	private final IDrawable icon;

	public ChippedRecipeCategory(RecipeType<ChippedRecipeCategory.FlattenedRecipe> type, Item item, IGuiHelper guiHelper) {
		recipeType = type;
		itemKey = ForgeRegistries.ITEMS.getKey(item);
		localizedName = I18n.get("container.chipped." + itemKey.getPath());
		background = guiHelper.createDrawable(TEXTURE, 0, 220, 82, 34);
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, item.getDefaultInstance());
	}

	public RecipeType<FlattenedRecipe> getRecipeType() {
		return recipeType;
	}

	@Override
	public Component getTitle() {
		return Component.translatable(localizedName);
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
	public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull FlattenedRecipe recipe, @NotNull IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 8)
				.addIngredients(recipe.tag);
		builder.addSlot(RecipeIngredientRole.OUTPUT, 60, 8)
				.addItemStack(recipe.result);
	}

	public record FlattenedRecipe(Ingredient tag, ItemStack result) {}
}
