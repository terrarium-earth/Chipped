package earth.terrarium.chipped.common.compat.jei;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.registry.ModItems;
import earth.terrarium.chipped.common.registry.ModRecipeTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class ChippedJeiPlugin implements IModPlugin {

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(Chipped.MOD_ID, "jei");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new WorkbenchCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager()
            .getAllRecipesFor(ModRecipeTypes.WORKBENCH.get()).forEach(recipe ->
                recipe.value().ingredients().forEach(ingredient ->
                    registration.addRecipes(WorkbenchCategory.RECIPE, List.of(ingredient))));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(ModItems.BOTANIST_WORKBENCH.get().getDefaultInstance(), WorkbenchCategory.RECIPE);
        registration.addRecipeCatalyst(ModItems.GLASSBLOWER.get().getDefaultInstance(), WorkbenchCategory.RECIPE);
        registration.addRecipeCatalyst(ModItems.CARPENTERS_TABLE.get().getDefaultInstance(), WorkbenchCategory.RECIPE);
        registration.addRecipeCatalyst(ModItems.LOOM_TABLE.get().getDefaultInstance(), WorkbenchCategory.RECIPE);
        registration.addRecipeCatalyst(ModItems.MASON_TABLE.get().getDefaultInstance(), WorkbenchCategory.RECIPE);
        registration.addRecipeCatalyst(ModItems.ALCHEMY_BENCH.get().getDefaultInstance(), WorkbenchCategory.RECIPE);
        registration.addRecipeCatalyst(ModItems.TINKERING_TABLE.get().getDefaultInstance(), WorkbenchCategory.RECIPE);
    }
}
