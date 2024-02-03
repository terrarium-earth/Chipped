package earth.terrarium.chipped.common.compat.jei;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.registry.ModItems;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

public record WorkbenchCategory(IGuiHelper guiHelper) implements IRecipeCategory<Ingredient> {
    public static final ResourceLocation ID = new ResourceLocation(Chipped.MOD_ID, "workbench");
    public static final RecipeType<Ingredient> RECIPE = new RecipeType<>(ID, Ingredient.class);

    private static final ResourceLocation TEXTURE = new ResourceLocation("jei", "textures/jei/gui/gui_vanilla.png");

    @Override
    public RecipeType<Ingredient> getRecipeType() {
        return RECIPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("container.chipped.workbench");
    }

    @Override
    public IDrawable getBackground() {
        return guiHelper.createDrawable(TEXTURE, 0, 220, 82, 34);
    }

    @Override
    public IDrawable getIcon() {
        return guiHelper.createDrawableItemStack(ModItems.MASON_TABLE.get().getDefaultInstance());
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, Ingredient recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 9).addIngredients(recipe);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 9).addIngredients(recipe);
    }

    @Override
    public void draw(Ingredient recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics graphics, double mouseX, double mouseY) {
    }
}
