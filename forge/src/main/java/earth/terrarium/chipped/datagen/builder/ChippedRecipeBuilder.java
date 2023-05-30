package earth.terrarium.chipped.datagen.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.recipe.ChippedRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class ChippedRecipeBuilder implements RecipeBuilder {

    protected final Advancement.Builder advancement = Advancement.Builder.advancement();
    protected final RecipeSerializer<ChippedRecipe> serializer;
    protected final Item workbench;
    protected final List<String> tags;

    public ChippedRecipeBuilder(RecipeSerializer<ChippedRecipe> serializer, Item workbench, List<String> tags) {
        this.serializer = serializer;
        this.workbench = workbench;
        this.tags = tags;
    }

    @Override
    public @NotNull ChippedRecipeBuilder unlockedBy(@NotNull String name, @NotNull CriterionTriggerInstance trigger) {
        this.advancement.addCriterion(name, trigger);
        return this;
    }

    @Override
    public @NotNull ChippedRecipeBuilder group(@Nullable String group) {
        return this;
    }


    @Override
    public @NotNull Item getResult() {
        return this.workbench;
    }

    @Override
    public void save(@NotNull Consumer<FinishedRecipe> consumer, @NotNull ResourceLocation id) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT)
            .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
            .rewards(net.minecraft.advancements.AdvancementRewards.Builder.recipe(id))
            .requirements(RequirementsStrategy.OR);

        consumer.accept(new Result(
            id,
            serializer,
            workbench,
            this.tags,
            this.advancement, new ResourceLocation(id.getNamespace(), "recipes/" + id.getPath()))
        );
    }

    public record Result(
        ResourceLocation id,
        RecipeSerializer<ChippedRecipe> serializer,
        Item workbench,
        List<String> tags,
        Advancement.Builder advancement, ResourceLocation advancementId
    ) implements FinishedRecipe {

        @Override
        public void serializeRecipeData(@NotNull JsonObject json) {
            JsonArray jsonElements = new JsonArray();
            tags.forEach(s -> jsonElements.add(new ResourceLocation(Chipped.MOD_ID, s).toString()));
            json.add("tags", jsonElements);
        }

        @Override
        public @NotNull ResourceLocation getId() {
            return this.id;
        }

        @Override
        public @NotNull RecipeSerializer<?> getType() {
            return serializer;
        }

        @Override
        public @NotNull JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
