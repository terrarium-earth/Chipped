package earth.terrarium.chipped.datagen.provider.server;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.datagen.builder.ChippedRecipeBuilder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MethodsReturnNonnullByDefault
public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        Map<TagKey<Item>, List<Ingredient>> workbenchTags = new HashMap<>();

        ModBlockTagProvider.registerTags((block, registry, tag, workbench, mineableTag) -> {
            var ingredients = workbenchTags.getOrDefault(workbench, new ArrayList<>());
            TagKey<Item> item = TagKey.create(Registries.ITEM, new ResourceLocation(Chipped.MOD_ID, tag));
            ingredients.add(Ingredient.of(item));
            workbenchTags.put(workbench, ingredients);
        });
        workbenchTags.forEach((tag, blocks) -> {
            Item workbench = BuiltInRegistries.ITEM.get(tag.location());
            createSimpleChippedRecipe(output, workbench, blocks);
        });
    }

    public static void createSimpleChippedRecipe(RecipeOutput output, Item workbench, List<Ingredient> tags) {
        new ChippedRecipeBuilder(tags)
            .unlockedBy("has_item", has(workbench))
            .save(output, BuiltInRegistries.ITEM.getKey(workbench));
    }
}
