//package earth.terrarium.chipped.common.compat.jei;
//
//import earth.terrarium.chipped.Chipped;
//import earth.terrarium.chipped.common.recipes.ChippedRecipe;
//import earth.terrarium.chipped.common.registry.ModItems;
//import mezz.jei.api.constants.VanillaTypes;
//import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
//import mezz.jei.api.gui.ingredient.IRecipeSlotDrawable;
//import mezz.jei.api.gui.placement.HorizontalAlignment;
//import mezz.jei.api.gui.placement.VerticalAlignment;
//import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
//import mezz.jei.api.helpers.IGuiHelper;
//import mezz.jei.api.recipe.IFocusGroup;
//import mezz.jei.api.recipe.RecipeIngredientRole;
//import mezz.jei.api.recipe.category.AbstractRecipeCategory;
//import mezz.jei.api.recipe.types.IRecipeType;
//import net.minecraft.core.Holder;
//import net.minecraft.core.HolderSet;
//import net.minecraft.network.chat.Component;
//import net.minecraft.resources.Identifier;
//import net.minecraft.world.item.ItemStack;
//import org.jspecify.annotations.NullMarked;
//
//import java.util.List;
//
//@NullMarked
//public class WorkbenchCategory extends AbstractRecipeCategory<ChippedRecipe> {
//    public static final Identifier ID = Chipped.id("workbench");
//    public static final IRecipeType<ChippedRecipe> RECIPE = IRecipeType.create(ID, ChippedRecipe.class);
//
//    public WorkbenchCategory(IGuiHelper guiHelper) {
//        super(
//            RECIPE,
//            Component.translatable("container.chipped.workbench"),
//            guiHelper.createDrawableItemLike(ModItems.MASON_TABLE.get()),
//            142,
//            110
//        );
//    }
//
//    @Override
//    public void setRecipe(IRecipeLayoutBuilder builder, ChippedRecipe recipe, IFocusGroup focuses) {
//        var items = recipe.entries()
//            .stream()
//            .flatMap(HolderSet::stream)
//            .filter(Holder::isBound)
//            .map(Holder::value)
//            .map(ItemStack::new)
//            .toList();
//
//
//        builder.addInputSlot(6, 9)
//            .setStandardSlotBackground()
//            .setPosition(0, 0, getWidth(), getHeight(), HorizontalAlignment.CENTER, VerticalAlignment.TOP)
//            .addIngredients(VanillaTypes.ITEM_STACK, items);
//
//        builder.addOutputSlot()
//            .addIngredients(VanillaTypes.ITEM_STACK, items);
//    }
//
//    @Override
//    public void createRecipeExtras(IRecipeExtrasBuilder builder, ChippedRecipe recipe, IFocusGroup focuses) {
//        List<IRecipeSlotDrawable> outputs = builder.getRecipeSlots().getSlots(RecipeIngredientRole.OUTPUT);
//
//        builder.addScrollGridWidget(outputs, 7, 5)
//            .setPosition(0, 0, getWidth(), getHeight(), HorizontalAlignment.CENTER, VerticalAlignment.BOTTOM);
//    }
//}
