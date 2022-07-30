package com.grimbo.chipped.compat;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EMIChippedRecipe implements EmiRecipe {
    final EmiRecipeCategory category;
    final ResourceLocation id;
    final List<EmiIngredient> input;
    final List<EmiStack> output;

    public EMIChippedRecipe(final Ingredient inputs, final Item output, final EmiRecipeCategory category, final ResourceLocation id)
    {
        this.category = category;
        this.id = id;
        this.input = Arrays.stream(inputs.getItems()).map(Ingredient::of).map(EmiIngredient::of).collect(Collectors.toList());
        this.output = List.of(EmiStack.of(output));
    }

    public EMIChippedRecipe(final HolderSet<Item> recipeTags, final EmiRecipeCategory category, final ResourceLocation id)
    {
        this.category = category;
        this.id = id;
        this.input = recipeTags.stream().filter(Holder::isBound).map(Holder::value).map(Ingredient::of).map(EmiIngredient::of).collect(Collectors.toList());
        this.output = recipeTags.stream().filter(Holder::isBound).map(Holder::value).map(EmiStack::of).collect(Collectors.toList());
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return this.category;
    }

    @Override
    public @Nullable ResourceLocation getId() {
        return this.id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return this.input;
    }

    @Override
    public List<EmiStack> getOutputs() {
        return this.output;
    }

    @Override
    public int getDisplayWidth() {
        return 120;
    }

    @Override
    public int getDisplayHeight() {
        return 45 + ((output.size() / 7) * 16);
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addFillingArrow(20, 0, 280);
        widgets.addGeneratedSlot(this::getRandomInput, 0, 1, 1);
        for(int i = 0; i < output.size(); i++)
        {
            widgets.addSlot(output.get(i), ((i % 7) * 17), 21 + (i / 7) * 18).recipeContext(this);
        }
    }

    private EmiIngredient getRandomInput(Random r)
    {
        if(input.size() > 0)
        {
            return this.input.get(r.nextInt(input.size()));
        }
        else return EmiIngredient.of(Ingredient.EMPTY);
    }
}
