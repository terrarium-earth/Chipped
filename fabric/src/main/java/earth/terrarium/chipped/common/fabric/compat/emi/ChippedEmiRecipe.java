package earth.terrarium.chipped.common.fabric.compat.emi;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChippedEmiRecipe implements EmiRecipe {
    private final EmiRecipeCategory category;
    private final EmiIngredient input;
    private final EmiStack output;
    private final ResourceLocation id;

    public ChippedEmiRecipe(EmiIngredient ingredient, Item stack, EmiRecipeCategory category, ResourceLocation id) {
        this.category = category;
        this.input = ingredient;
        this.output = EmiStack.of(stack);
        this.id = id;
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return category;
    }

    @Override
    public @Nullable ResourceLocation getId() {
        return id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return List.of(input);
    }

    @Override
    public List<EmiStack> getOutputs() {
        return List.of(output);
    }

    @Override
    public int getDisplayWidth() {
        return 76;
    }

    @Override
    public int getDisplayHeight() {
        return 18;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(EmiTexture.EMPTY_ARROW, 26, 1);
        widgets.addSlot(input, 0, 0);
        widgets.addSlot(output, 58, 0).recipeContext(this);
    }
}
