package com.grimbo.chipped.compat;

import com.google.common.collect.Lists;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ChippedRecipeCategory implements DisplayCategory<ChippedRecipeCategory.FlattenedRecipe> {
	private final CategoryIdentifier<FlattenedRecipe> id;
    private final ItemStack icon;

	public ChippedRecipeCategory(Block block) {
        this.id = CategoryIdentifier.of(Registry.BLOCK.getKey(block));
        this.icon = new ItemStack(block);
	}

    @Override
    public Renderer getIcon() {
        return EntryStack.of(VanillaEntryTypes.ITEM, this.icon);
    }

    @Override
    public Component getTitle() {
        return new TranslatableComponent("container.chipped." + id.getPath());
    }

    @Override
    public List<Widget> setupDisplay(FlattenedRecipe recipeDisplay, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 41, bounds.getCenterY() - 13);
        List<Widget> widgets = Lists.newArrayList();
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createArrow(new Point(startPoint.x + 27, startPoint.y + 4)));
        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 61, startPoint.y + 5)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 4, startPoint.y + 5)).entries(recipeDisplay.getInputEntries().get(0)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 61, startPoint.y + 5)).entries(recipeDisplay.getOutputEntries().get(0)).disableBackground().markOutput());
        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 36;
    }

    @Override
    public CategoryIdentifier<? extends FlattenedRecipe> getCategoryIdentifier() {
        return id;
    }

    public record FlattenedRecipe(
            Tag<Item> tag,
            ItemStack result,
            CategoryIdentifier<FlattenedRecipe> category
    ) implements Display {
        @Override
        public List<EntryIngredient> getInputEntries() {
            return Collections.singletonList(EntryIngredient.of(this.tag.getValues().stream().map(item -> EntryStack.of(VanillaEntryTypes.ITEM, new ItemStack(item))).collect(Collectors.toList())));
        }

        @Override
        public List<EntryIngredient> getOutputEntries() {
            return Collections.singletonList(EntryIngredient.of(EntryStack.of(VanillaEntryTypes.ITEM, this.result)));
        }

        @Override
        public CategoryIdentifier<?> getCategoryIdentifier() {
            return this.category;
        }
    }
}
