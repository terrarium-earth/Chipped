package earth.terrarium.chipped.common.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class ChippedRecipeCategory implements IRecipeCategory<ChippedRecipeCategory.FlattenedRecipe> {

    public static final RecipeType<FlattenedRecipe> BOTANIST_WORKBENCH_RECIPE = new RecipeType<>(new ResourceLocation("botanist_workbench"), FlattenedRecipe.class);
    public static final RecipeType<FlattenedRecipe> GLASSBLOWER_RECIPE = new RecipeType<>(new ResourceLocation("glassblower"), FlattenedRecipe.class);
    public static final RecipeType<FlattenedRecipe> CARPENTERS_TABLE_RECIPE = new RecipeType<>(new ResourceLocation("carpenters_table"), FlattenedRecipe.class);
    public static final RecipeType<FlattenedRecipe> LOOM_TABLE_RECIPE = new RecipeType<>(new ResourceLocation("loom_table"), FlattenedRecipe.class);
    public static final RecipeType<FlattenedRecipe> MASON_TABLE_RECIPE = new RecipeType<>(new ResourceLocation("mason_table"), FlattenedRecipe.class);
    public static final RecipeType<FlattenedRecipe> ALCHEMY_BENCH_RECIPE = new RecipeType<>(new ResourceLocation("alchemy_bench"), FlattenedRecipe.class);
    public static final RecipeType<FlattenedRecipe> MECHANIST_WORKBENCH_RECIPE = new RecipeType<>(new ResourceLocation("mechanist_workbench"), FlattenedRecipe.class);

    private static final ResourceLocation TEXTURE = new ResourceLocation("jei", "textures/gui/gui_vanilla.png");


    private final RecipeType<FlattenedRecipe> type;
    private final String localizedName;
    private final IDrawable background;
    private final IDrawable icon;

    public ChippedRecipeCategory(Item item, RecipeType<FlattenedRecipe> type, IGuiHelper guiHelper) {
        this.type = type;
        localizedName = I18n.get("container.chipped." + Registry.ITEM.getKey(item).getPath());
        background = guiHelper.createDrawable(TEXTURE, 0, 220, 82, 34);
        icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, item.getDefaultInstance());
    }

    @Override
    public RecipeType<FlattenedRecipe> getRecipeType() {
        return type;
    }

    @Override
    public Component getTitle() {
        return Component.literal(localizedName);
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
    public void setRecipe(IRecipeLayoutBuilder builder, FlattenedRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 9).addIngredients(recipe.tag);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 9).addItemStack(recipe.result);
    }

    public record FlattenedRecipe(Ingredient tag, ItemStack result) {
    }
}
