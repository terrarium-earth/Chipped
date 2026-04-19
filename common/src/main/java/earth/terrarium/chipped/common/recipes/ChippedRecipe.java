package earth.terrarium.chipped.common.recipes;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import earth.terrarium.chipped.common.registry.ModRecipeSerializers;
import earth.terrarium.chipped.common.registry.ModRecipeTypes;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.List;

public record ChippedRecipe(List<HolderSet<Item>> entries) implements Recipe<SingleRecipeInput> {

    public static final MapCodec<ChippedRecipe> CODEC = RecordCodecBuilder.mapCodec(
        instance -> instance.group(
            RegistryCodecs.homogeneousList(Registries.ITEM).listOf().fieldOf("entries").forGetter(ChippedRecipe::entries)
        ).apply(instance, ChippedRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, ChippedRecipe> NETWORK_CODEC = ByteBufCodecs.holderSet(Registries.ITEM)
        .apply(ByteBufCodecs.list())
        .map(ChippedRecipe::new, ChippedRecipe::entries);

    @Override
    public boolean matches(SingleRecipeInput input, @NonNull Level level) {
        return this.matches(input.item());
    }

    public boolean matches(ItemStack stack) {
        return !stack.isEmpty() && this.entries.stream().anyMatch(stack::is);
    }

    @Override
    public @NonNull ItemStack assemble(@NonNull SingleRecipeInput input) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public @NonNull String group() {
        return "";
    }

    @Override
    public @NonNull RecipeSerializer<ChippedRecipe> getSerializer() {
        return ModRecipeSerializers.WORKBENCH.get();
    }

    @Override
    public @NonNull RecipeType<ChippedRecipe> getType() {
        return ModRecipeTypes.WORKBENCH.get();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public @NonNull PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public @NonNull RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static List<Holder<Item>> getResultsFor(ServerPlayer player, ItemStack stack) {
        var level = player.level();
        var item = stack.typeHolder();

        var output = new ArrayList<Holder<Item>>();

        for (var holder : level.recipeAccess().getRecipes()) {
            if (!(holder.value() instanceof ChippedRecipe recipe)) continue;
            if (!recipe.matches(stack)) continue;

            for (var entry : recipe.entries()) {
                if (!entry.contains(item)) continue;

                entry.forEach(output::add);
            }
        }

        return output;
    }
}