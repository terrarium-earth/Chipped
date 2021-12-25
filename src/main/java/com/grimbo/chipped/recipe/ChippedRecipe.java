package com.grimbo.chipped.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.Container;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.tags.Tag;
import net.minecraft.tags.SerializationTags;
import net.minecraft.util.GsonHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Stream;

public class ChippedRecipe implements Recipe<Container> {
	private final Serializer serializer;
	private final ResourceLocation id;
	private final String group;
	private final List<Tag<Item>> tags;
	private final Block icon;

	public ChippedRecipe(Serializer serializer, ResourceLocation id, String group, List<Tag<Item>> tags, Block block) {
		this.serializer = serializer;
		this.id = id;
		this.group = group;
		this.tags = tags;
		this.icon = block;
	}

	@Override
	public boolean matches(Container inventory, @NotNull Level world) {
		ItemStack item = inventory.getItem(0);
		if (!item.isEmpty()) {
			for (Tag<Item> tag : tags) {
				if (tag.contains(item.getItem())) {
					return true;
				}
			}
		}
		return false;
	}

	public List<Tag<Item>> getTags() {
		return tags;
	}


	public Stream<ItemStack> getResults(Container container) {
		ItemStack current = container.getItem(0);
		if (!current.isEmpty()) {
			Item item = current.getItem();
			return tags.stream()
					.filter(tag -> tag.contains(item))
					.flatMap(tag -> tag.getValues().stream())
					.filter(value -> value != item)
					.map(ItemStack::new);
		}
		return Stream.empty();
	}

	@Override
	public @NotNull ItemStack assemble(@NotNull Container inventory) {
		return getResultItem();
	}

	@Override
	public boolean canCraftInDimensions(int i, int j) {
		return true;
	}

	@Override
	public @NotNull ItemStack getResultItem() {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean isSpecial() {
		return true;
	}

	public @NotNull String getGroup() {
		return group;
	}

	public @NotNull ItemStack getToastSymbol() {
		return new ItemStack(icon);
	}

	@Override
	public @NotNull ResourceLocation getId() {
		return id;
	}

	@Override
	public @NotNull RecipeSerializer<?> getSerializer() {
		return serializer;
	}

	@Override
	public @NotNull RecipeType<?> getType() {
		return serializer.getType();
	}

	public static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<ChippedRecipe> {
		private final RecipeType<?> type;
		private final Block icon;

		public Serializer(RecipeType<?> type, Block icon) {
			this.type = type;
			this.icon = icon;
		}

		@Override
		public @NotNull ChippedRecipe fromJson(@NotNull ResourceLocation recipeId, @NotNull JsonObject json) {
			String s = GsonHelper.getAsString(json,"group", "");
			List<Tag<Item>> tags = new ArrayList<>();
			JsonArray tagArray = GsonHelper.getAsJsonArray(json, "tags");
			for (int i = 0; i < tagArray.size(); ++i) {
				String tagName = GsonHelper.convertToString(tagArray.get(i), "tags[" + i + "]");
				Tag<Item> tag = SerializationTags.getInstance().getTagOrThrow(
						Registry.ITEM_REGISTRY,
						new ResourceLocation(tagName),
						id -> new JsonSyntaxException("Unknown item tag '" + id + "'")
				);
				tags.add(tag);
			}
			return new ChippedRecipe(this, recipeId, s, tags, icon);
		}

		@Override
		public ChippedRecipe fromNetwork(@NotNull ResourceLocation recipeId, FriendlyByteBuf buffer) {
			String s = buffer.readUtf(32767);
			int tagCount = buffer.readVarInt();
			List<Tag<Item>> tags = new ArrayList<>(tagCount);
			for (int i = 0; i < tagCount; i++) {
				int itemCount = buffer.readVarInt();
				Set<Item> items = new LinkedHashSet<>(itemCount);
				for (int j = 0; j < itemCount; j++) {
					items.add(Item.byId(buffer.readVarInt()));
				}
				tags.add(Tag.fromSet(items));
			}
			return new ChippedRecipe(this, recipeId, s, tags, icon);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buffer, @NotNull ChippedRecipe recipe) {
			buffer.writeUtf(recipe.group);
			buffer.writeVarInt(recipe.tags.size());
			for (Tag<Item> tag : recipe.tags) {
				List<Item> values = tag.getValues();
				buffer.writeVarInt(values.size());
				for (Item item : values) {
					buffer.writeVarInt(Item.getId(item));
				}
			}
		}

		public RecipeType<?> getType() {
			return type;
		}
	}
}
