package earth.terrarium.chipped.common.compat.rei;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.recipes.ChippedRecipe;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.ModRecipeTypes;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.client.Minecraft;

import java.util.Objects;

public class ChippedReiPlugin implements REIClientPlugin {
    public static final CategoryIdentifier<WorkbenchDisplay> ID = CategoryIdentifier.of(Chipped.MOD_ID, "workbench");

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new WorkbenchCategory());

        registry.addWorkstations(ID,
            EntryStacks.of(ModBlocks.BOTANIST_WORKBENCH.get()),
            EntryStacks.of(ModBlocks.GLASSBLOWER.get()),
            EntryStacks.of(ModBlocks.CARPENTERS_TABLE.get()),
            EntryStacks.of(ModBlocks.LOOM_TABLE.get()),
            EntryStacks.of(ModBlocks.MASON_TABLE.get()),
            EntryStacks.of(ModBlocks.ALCHEMY_BENCH.get()),
            EntryStacks.of(ModBlocks.TINKERING_TABLE.get())
        );
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager()
            .getAllRecipesFor(ModRecipeTypes.WORKBENCH.get()).forEach(recipe ->
                recipe.value().ingredients().forEach(ingredient ->
                    registry.registerRecipeFiller(ChippedRecipe.class, ModRecipeTypes.WORKBENCH.get(), r -> new WorkbenchDisplay(ingredient))));
    }
}
