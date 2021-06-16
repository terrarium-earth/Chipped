package com.grimbo.chipped.integration;

import com.google.common.collect.Lists;
import com.grimbo.chipped.recipe.ChippedRecipe;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.EntryStack;
import me.shedaniel.rei.api.RecipeCategory;
import me.shedaniel.rei.api.RecipeDisplay;
import me.shedaniel.rei.api.widgets.Widgets;
import me.shedaniel.rei.gui.widget.Widget;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChippedRecipeCategory implements RecipeCategory<ChippedRecipeCategory.RecipeWrapper> {
	private final ResourceLocation id;
    private final ItemStack icon;
    private final String name;

	public ChippedRecipeCategory(Block block) {
		id = Registry.BLOCK.getKey(block);
        icon = new ItemStack(block);
        name = I18n.get("container.chipped." + id.getPath());
	}

    @Override
    public @NotNull ResourceLocation getIdentifier() {
        return id;
    }

    @Override
    public @NotNull String getCategoryName() {
        return name;
    }

    @Override
    public @NotNull EntryStack getLogo() {
        return EntryStack.create(icon);
    }

    @Override
    public @NotNull List<Widget> setupDisplay(RecipeWrapper recipeDisplay, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 41, bounds.getCenterY() - 13);
        List<Widget> widgets = Lists.newArrayList();
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createArrow(new Point(startPoint.x + 27, startPoint.y + 4)));
        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 61, startPoint.y + 5)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 4, startPoint.y + 5)).entries(recipeDisplay.getInputEntries().get(0)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 61, startPoint.y + 5)).entries(recipeDisplay.getResultingEntries().get(0)).disableBackground().markOutput());
        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 36;
    }

    @Override
    public int getDisplayWidth(RecipeWrapper display) {
        return RecipeCategory.super.getDisplayWidth(display);
    }

    public static class RecipeWrapper implements RecipeDisplay {
	    private final ChippedRecipe recipe;
	    private final ResourceLocation category;

        public RecipeWrapper(ChippedRecipe recipe, ResourceLocation category) {
            this.recipe = recipe;
            this.category = category;
        }

        @Override
        public @NotNull List<List<EntryStack>> getInputEntries() {
            return EntryStack.ofIngredients(recipe.getIngredients());
        }

        @Override
        public @NotNull List<List<EntryStack>> getResultingEntries() {
            return Collections.singletonList(Collections.singletonList(EntryStack.create(recipe.getResultItem())));
        }

        @Override
        public @NotNull ResourceLocation getRecipeCategory() {
            return category;
        }
    }
}

