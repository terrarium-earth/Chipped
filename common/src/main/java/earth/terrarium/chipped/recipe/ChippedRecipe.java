package earth.terrarium.chipped.recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
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
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public record ChippedRecipe(
        Serializer serializer,
        ResourceLocation id,
        String group,
        List<HolderSet<Item>> tags,
        Block icon
) implements Recipe<Container> {
    @Override
    public boolean matches(Container container, Level level) {
        ItemStack stack = container.getItem(0);
        return !stack.isEmpty() && this.tags.stream().anyMatch(tag -> tagIs(stack, tag));
    }

    @SuppressWarnings("deprecation")
    private static boolean tagIs(ItemStack stack, HolderSet<Item> tag) {
        return tag.contains(stack.getItem().builtInRegistryHolder());
    }

    public Stream<ItemStack> getResults(Container container) {
        ItemStack current = container.getItem(0);
        if (!current.isEmpty()) {
            Item item = current.getItem();
            return this.tags.stream()
                    .filter(tag -> tagIs(current, tag))
                    .flatMap(tag -> tag.stream().filter(Holder::isBound).map(Holder::value))
                    .filter(value -> value != item)
                    .map(ItemStack::new);
        }
        return Stream.empty();
    }

    @Override
    public ItemStack assemble(Container container) {
        return getResultItem();
    }

    @Override
    public boolean canCraftInDimensions(int i, int j) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
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

    public static class Serializer extends SimpleRecipeSerializer<ChippedRecipe> {

        public final Supplier<RecipeType<ChippedRecipe>> type;
        public final Supplier<Block> icon;

        public Serializer(Supplier<RecipeType<ChippedRecipe>> type, Supplier<Block> icon) {
            super(p -> null);
            this.type = type;
            this.icon = icon;
        }

        @Override
        public ChippedRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            String s = GsonHelper.getAsString(json, "group", "");
            List<HolderSet<Item>> tags = new ArrayList<>();
            JsonArray tagArray = GsonHelper.getAsJsonArray(json, "tags");
            for (int i = 0; i < tagArray.size(); ++i) {
                String tagName = GsonHelper.convertToString(tagArray.get(i), "tags[" + i + "]");
                var tag = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(tagName));
                tags.add(Registry.ITEM.getOrCreateTag(tag));
            }
            return new ChippedRecipe(this, recipeId, s, tags, this.icon.get());
        }

        @SuppressWarnings("deprecation")
        @Override
        public ChippedRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            String s = buffer.readUtf(32767);
            int tagCount = buffer.readVarInt();
            List<HolderSet<Item>> tags = new ArrayList<>(tagCount);
            for (int i = 0; i < tagCount; i++) {
                tags.add(HolderSet.direct(Item::builtInRegistryHolder, buffer.readList(buf -> Item.byId(buf.readVarInt()))));
            }
            return new ChippedRecipe(this, recipeId, s, tags, this.icon.get());
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, ChippedRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeVarInt(recipe.tags.size());
            for (HolderSet<Item> tag : recipe.tags) {
                List<Item> items = tag.stream().filter(Holder::isBound).map(Holder::value).toList();
                buffer.writeCollection(items, (buf, item) -> buf.writeVarInt(Item.getId(item)));
            }
        }
    }
}