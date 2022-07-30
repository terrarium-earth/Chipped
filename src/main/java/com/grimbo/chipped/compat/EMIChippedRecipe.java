package com.grimbo.chipped.compat;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EMIChippedRecipe implements EmiRecipe {
    private static final int MAX_OUTPUT_WIDTH = 7;
    private static final int MAX_OUTPUT_HEIGHT = 5;
    protected static final int MAX_OUTPUTS_PER_PAGE = MAX_OUTPUT_WIDTH * MAX_OUTPUT_HEIGHT - 2;
    final EmiRecipeCategory category;
    final ResourceLocation id;
    final List<EmiIngredient> inputs;
    final List<EmiStack> output;
    final List<EmiIngredient> origin;
    final boolean isContinuingRecipe;

    public EMIChippedRecipe(final Item input, final List<Item> taggedItems, final EmiRecipeCategory category, final ResourceLocation id, final boolean isContinuingRecipe)
    {
        this.category = category;
        this.id = id;
        this.inputs = taggedItems.stream().map(Ingredient::of).map(EmiIngredient::of).collect(Collectors.toList());
        this.output = taggedItems.stream().map(EmiStack::of).collect(Collectors.toList());
        this.origin = List.of(EmiIngredient.of(Ingredient.of(input)));
        this.isContinuingRecipe = isContinuingRecipe;
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
        // Specifically _not_ the full Inputs, or the Cost Tooltip gets very badly overfilled.
        // Using an EmiIngredient derived from tags directly would avoid some of this mess,
        // But require a lot of complex sync testing on servers.
        return this.origin;
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
        return 45 + ((output.size() / MAX_OUTPUT_WIDTH) * 16);
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addFillingArrow(20, 0, 280);
        widgets.addGeneratedSlot(this::getRandomInput, 0, 1, 1);
        for(int i = 0; i < output.size(); i++)
        {
            widgets.addSlot(output.get(i), ((i % 7) * 17), 19 + (i / MAX_OUTPUT_WIDTH) * 18).recipeContext(this);
        }
        if(isContinuingRecipe)
        {
            widgets.addFillingArrow(94, 92, 900);
        }
    }

    private EmiIngredient getRandomInput(Random r)
    {
        if(inputs.size() > 0)
        {
            return this.inputs.get(r.nextInt(inputs.size()));
        }
        else return EmiIngredient.of(Ingredient.EMPTY);
    }
}
