package earth.terrarium.chipped.common.compat.jei;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.client.network.ClientNetwork;
import earth.terrarium.chipped.common.registry.ModItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NullMarked;

@JeiPlugin
@NullMarked
public class ChippedJeiPlugin implements IModPlugin {

    @Override
    public Identifier getPluginUid() {
        return Chipped.id("jei");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new WorkbenchCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(
            WorkbenchCategory.RECIPE,
            ClientNetwork.recipes()
                .stream()
                .flatMap(recipe -> recipe.entries().stream())
                .map(WorkbenchCategory.Recipe::new)
                .toList()
        );
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addCraftingStation(WorkbenchCategory.RECIPE,
            ModItems.BOTANIST_WORKBENCH.get(),
            ModItems.GLASSBLOWER.get(),
            ModItems.CARPENTERS_TABLE.get(),
            ModItems.LOOM_TABLE.get(),
            ModItems.MASON_TABLE.get(),
            ModItems.ALCHEMY_BENCH.get(),
            ModItems.TINKERING_TABLE.get()
        );
    }
}
