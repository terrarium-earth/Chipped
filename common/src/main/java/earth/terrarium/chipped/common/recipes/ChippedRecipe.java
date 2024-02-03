package earth.terrarium.chipped.common.recipes;

import com.google.gson.JsonObject;
import earth.terrarium.chipped.common.utils.ModUtils;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@MethodsReturnNonnullByDefault
public record ChippedRecipe(
    Serializer serializer,
    ResourceLocation id,
    String group,
    List<? extends HolderSet<Item>> tags,
    Block icon
) implements Recipe<Container> {

    @Override
    public boolean matches(Container container, Level level) {
        ItemStack stack = container.getItem(0);
        return !stack.isEmpty() && this.tags.stream().anyMatch(tag -> stack.is(tag::contains));
    }

    public Stream<ItemStack> getResults(ItemStack stack) {
        if (!stack.isEmpty()) {
            Item item = stack.getItem();
            return this.tags.stream()
                .filter(set -> stack.is(set::contains))
                .flatMap(ModUtils::streamHolderSet)
                .filter(value -> value != item)
                .map(ItemStack::new);
        }
        return Stream.empty();
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int i, int j) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String getGroup() {
        return group;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(icon);
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return serializer;
    }

    @Override
    public RecipeType<ChippedRecipe> getType() {
        return serializer.type.get();
    }

    public record Serializer(Supplier<RecipeType<ChippedRecipe>> type,
                             Supplier<Block> icon) implements RecipeSerializer<ChippedRecipe> {

        @Override
        public ChippedRecipe fromJson(ResourceLocation id, JsonObject json) {
            String group = GsonHelper.getAsString(json, "group", "");
            List<? extends HolderSet<Item>> tags = StreamSupport.stream(GsonHelper.getAsJsonArray(json, "tags").spliterator(), false)
                .map(ModUtils::expectResourcelocation)
                .map(tag -> TagKey.create(Registries.ITEM, tag))
                .map(BuiltInRegistries.ITEM::getOrCreateTag)
                .toList();
            return new ChippedRecipe(this, id, group, tags, this.icon.get());
        }

        @SuppressWarnings("deprecation")
        @Override
        public ChippedRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            String group = buffer.readUtf();
            var holders = buffer.readList(holderBuf -> HolderSet.direct(Item::builtInRegistryHolder, buffer.readList(ModUtils::readItem)));
            return new ChippedRecipe(this, recipeId, group, holders, this.icon.get());
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, ChippedRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeCollection(recipe.tags, (buf, tag) -> buf.writeCollection(ModUtils.fromHolderSet(tag), ModUtils::writeItem));
        }
    }
}