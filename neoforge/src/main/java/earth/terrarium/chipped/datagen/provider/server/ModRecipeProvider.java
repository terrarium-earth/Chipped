package earth.terrarium.chipped.datagen.provider.server;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.registry.ModItems;
import earth.terrarium.chipped.datagen.builder.ChippedRecipeBuilder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

@MethodsReturnNonnullByDefault
public class ModRecipeProvider extends RecipeProvider {
    private RecipeOutput output;

    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        this.output = output;
        Map<TagKey<Item>, List<Ingredient>> workbenchTags = new HashMap<>();

        ModBlockTagProvider.registerTags((block, registry, tag, workbench, mineableTag) -> {
            var ingredients = workbenchTags.getOrDefault(workbench, new ArrayList<>());
            TagKey<Item> item = TagKey.create(Registries.ITEM, new ResourceLocation(Chipped.MOD_ID, tag));
            ingredients.add(Ingredient.of(item));
            workbenchTags.put(workbench, ingredients);
        });
        workbenchTags.forEach((tag, blocks) -> {
            Item workbench = BuiltInRegistries.ITEM.get(tag.location());
            createSimpleChippedRecipe(workbench, blocks);
        });

        shaped(ModItems.ALCHEMY_BENCH, 1, () -> Items.CRAFTING_TABLE, r -> r
            .define('B', Items.BREWING_STAND)
            .define('S', ItemTags.WOODEN_SLABS)
            .define('E', Items.ENCHANTING_TABLE)
            .pattern(" B ")
            .pattern("S#S")
            .pattern("SES"));

        shaped(ModItems.BOTANIST_WORKBENCH, 1, () -> Items.CRAFTING_TABLE, r -> r
            .define('F', Items.FLOWER_POT)
            .define('S', ItemTags.WOODEN_SLABS)
            .define('/', Items.STICK)
            .pattern("FFF")
            .pattern("S#S")
            .pattern("/ /"));

        shaped(ModItems.CARPENTERS_TABLE, 1, () -> Items.CRAFTING_TABLE, r -> r
            .define('I', Items.IRON_INGOT)
            .define('A', Items.IRON_AXE)
            .define('P', ItemTags.PLANKS)
            .pattern("A I")
            .pattern("P#P")
            .pattern("PPP"));

        shaped(ModItems.GLASSBLOWER, 1, () -> Items.CRAFTING_TABLE, r -> r
            .define('I', Items.IRON_INGOT)
            .define('F', Items.BLAST_FURNACE)
            .define('B', Items.BRICKS)
            .define('G', Items.GLASS)
            .pattern("IGI")
            .pattern("B#B")
            .pattern("BFB"));

        shaped(ModItems.LOOM_TABLE, 1, () -> Items.CRAFTING_TABLE, r -> r
            .define('/', Items.STICK)
            .define('W', ItemTags.WOOL)
            .define('L', ItemTags.LOGS)
            .pattern("WWW")
            .pattern("/#/")
            .pattern("LLL"));

        shaped(ModItems.MASON_TABLE, 1, () -> Items.CRAFTING_TABLE, r -> r
            .define('I', Items.IRON_INGOT)
            .define('B', Items.BRICK)
            .define('L', ItemTags.LOGS)
            .pattern("BBB")
            .pattern("I#I")
            .pattern("LLL"));

        shaped(ModItems.TINKERING_TABLE, 1, () -> Items.CRAFTING_TABLE, r -> r
            .define('I', Items.IRON_INGOT)
            .define('T', Items.REDSTONE_TORCH)
            .define('R', Items.REDSTONE)
            .define('L', ItemTags.LOGS)
            .pattern("TRT")
            .pattern("I#I")
            .pattern("L L"));

        shapeless(ModItems.WATERING_CAN, 1, ModItems.BOTANIST_WORKBENCH, r -> r
            .requires(Items.BUCKET));
        shapeless(ModItems.ALCHEMY_BOOK, 1, ModItems.ALCHEMY_BENCH, r -> r
            .requires(Items.BOOK));
        shapeless(ModItems.SAW, 1, ModItems.CARPENTERS_TABLE, r -> r
            .requires(Items.IRON_INGOT));
        shapeless(ModItems.NEEDLES, 1, ModItems.LOOM_TABLE, r -> r
            .requires(Items.STICK));
        shapeless(ModItems.CHISEL, 1, ModItems.MASON_TABLE, r -> r
            .requires(Items.IRON_INGOT));
        shapeless(ModItems.MULTIMETER, 1, ModItems.TINKERING_TABLE, r -> r
            .requires(Items.REDSTONE));
    }

    private void createSimpleChippedRecipe(Item workbench, List<Ingredient> tags) {
        new ChippedRecipeBuilder(tags)
            .unlockedBy("has_item", has(workbench))
            .save(output, BuiltInRegistries.ITEM.getKey(workbench));
    }

    private void shaped(RegistryEntry<Item> result, int count, Supplier<Item> mainItem, Function<ShapedRecipeBuilder, ShapedRecipeBuilder> builder) {
        builder.apply(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get(), count)
                .define('#', mainItem.get())
                .unlockedBy("has_" + result.getId().getPath(), has(mainItem.get())))
            .save(output, "workbench/" + result.getId().getPath());
    }

    private void shapeless(RegistryEntry<Item> result, int count, Supplier<Item> mainItem, Function<ShapelessRecipeBuilder, ShapelessRecipeBuilder> builder) {
        builder.apply(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result.get(), count)
                .requires(mainItem.get())
                .unlockedBy("has_" + result.getId().getPath(), has(mainItem.get())))
            .save(output);
    }
}
