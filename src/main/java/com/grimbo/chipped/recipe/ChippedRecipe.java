package com.grimbo.chipped.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.grimbo.chipped.Chipped;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
//import net.minecraftforge.registries.ForgeRegistryEntry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ChippedRecipe implements Recipe<Container> {

	private final Serializer serializer;
	private final ResourceLocation id;
	private final String group;
	private final List<HolderSet<Item>> tags;
	private final Block icon;

	public ChippedRecipe(Serializer serializer, ResourceLocation id, String group, List<HolderSet<Item>> tags, Block block) {
		this.serializer = serializer;
		this.id = id;
		this.group = group;
		this.tags = tags;
		this.icon = block;
	}

	@Override
	public boolean matches(Container inventory, @NotNull Level world) {
		ItemStack item = inventory.getItem(0);
		return !item.isEmpty() && tags.stream().anyMatch(tag -> tagIs(item, tag));
	}

	private static boolean tagIs(ItemStack stack, HolderSet<Item> tag) {
		return tag.contains(stack.getItem().builtInRegistryHolder());
	}

	public List<HolderSet<Item>> getTags() {
		return tags;
	}


	public Stream<ItemStack> getResults(Container container) {
		ItemStack current = container.getItem(0);
		if (!current.isEmpty()) {
			Item item = current.getItem();
			return tags.stream()
					.filter(tag -> tagIs(current, tag))
					.flatMap(tag -> tag.stream().filter(Holder::isBound).map(Holder::value))
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

	public static class Serializer implements RecipeSerializer<ChippedRecipe> {
		private final RecipeType<?> type;
		private final Block icon;

		public Serializer(RecipeType<?> type, Block icon) {
			this.type = type;
			this.icon = icon;
		}

		@Override
		public @NotNull ChippedRecipe fromJson(@NotNull ResourceLocation recipeId, @NotNull JsonObject json) {
			String s = GsonHelper.getAsString(json,"group", "");
			List<HolderSet<Item>> tags = new ArrayList<>();
			JsonArray tagArray = GsonHelper.getAsJsonArray(json, "tags");
			for (int i = 0; i < tagArray.size(); ++i) {
				String tagName = GsonHelper.convertToString(tagArray.get(i), "tags[" + i + "]");
				var tag = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(tagName));
				tags.add(Registry.ITEM.getOrCreateTag(tag));
			}
			return new ChippedRecipe(this, recipeId, s, tags, icon);
		}

		@Override
		public ChippedRecipe fromNetwork(@NotNull ResourceLocation recipeId, FriendlyByteBuf buffer) {
			String s = buffer.readUtf(32767);
			int tagCount = buffer.readVarInt();
			List<HolderSet<Item>> tags = new ArrayList<>(tagCount);
			for (int i = 0; i < tagCount; i++) {
				tags.add(HolderSet.direct(Item::builtInRegistryHolder, buffer.readList(buf -> Item.byId(buf.readVarInt()))));
			}
			return new ChippedRecipe(this, recipeId, s, tags, icon);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buffer, @NotNull ChippedRecipe recipe) {
			buffer.writeUtf(recipe.group);
			buffer.writeVarInt(recipe.tags.size());
			for (HolderSet<Item> tag : recipe.tags) {
				List<Item> items = tag.stream().filter(Holder::isBound).map(Holder::value).toList();
				buffer.writeCollection(items, (buf, item) -> buf.writeVarInt(Item.getId(item)));
			}
		}

		public RecipeType<?> getType() {
			return type;
		}
	}
}
