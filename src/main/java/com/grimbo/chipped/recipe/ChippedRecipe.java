package com.grimbo.chipped.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tags.ITag;
import net.minecraft.tags.TagCollectionManager;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Stream;

public class ChippedRecipe implements IRecipe<IInventory> {
	private final Serializer serializer;
	private final ResourceLocation id;
	private final String group;
	private final List<ITag<Item>> tags;
	private final Block icon;

	public ChippedRecipe(Serializer serializer, ResourceLocation id, String group, List<ITag<Item>> tags, Block block) {
		this.serializer = serializer;
		this.id = id;
		this.group = group;
		this.tags = tags;
		this.icon = block;
	}

	@Override
	public boolean matches(IInventory inventory, @NotNull World world) {
		ItemStack item = inventory.getItem(0);
		if (!item.isEmpty()) {
			for (ITag<Item> tag : tags) {
				if (item.getItem().is(tag)) {
					return true;
				}
			}
		}
		return false;
	}

	public List<ITag<Item>> getTags() {
		return tags;
	}

	public Stream<ItemStack> getResults(IInventory container) {
		ItemStack current = container.getItem(0);
		if (!current.isEmpty()) {
			Item item = current.getItem();
			return tags.stream()
					.filter(item::is)
					.flatMap(tag -> tag.getValues().stream())
					.filter(value -> value != item)
					.map(ItemStack::new);
		}
		return Stream.empty();
	}
	@Override
	public @NotNull ItemStack assemble(@NotNull IInventory inventory) {
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
	public @NotNull IRecipeSerializer<?> getSerializer() {
		return serializer;
	}

	@Override
	public @NotNull IRecipeType<?> getType() {
		return serializer.getType();
	}

	public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ChippedRecipe> {
		private final IRecipeType<?> type;
		private final Block icon;

		public Serializer(IRecipeType<?> type, Block icon) {
			this.type = type;
			this.icon = icon;
		}

		@Override
		public @NotNull ChippedRecipe fromJson(@NotNull ResourceLocation recipeId, @NotNull JsonObject json) {
			String s = JSONUtils.getAsString(json,"group", "");
			List<ITag<Item>> tags = new ArrayList<>();
			JsonArray tagArray = JSONUtils.getAsJsonArray(json, "tags");
			for (int i = 0; i < tagArray.size(); ++i) {
				String tagName = JSONUtils.convertToString(tagArray.get(i), "tags[" + i + "]");
				ResourceLocation id = new ResourceLocation(tagName);
				ITag<Item> tag = TagCollectionManager.getInstance().getItems().getTag(id);
				if (tag == null) {
					throw new JsonSyntaxException("Unknown item tag '" + id + "'");
				}
				tags.add(tag);
			}
			return new ChippedRecipe(this, recipeId, s, tags, icon);
		}

		@Override
		public ChippedRecipe fromNetwork(@NotNull ResourceLocation recipeId, PacketBuffer buffer) {
			String s = buffer.readUtf(32767);
			int tagCount = buffer.readVarInt();
			List<ITag<Item>> tags = new ArrayList<>(tagCount);
			for (int i = 0; i < tagCount; i++) {
				int itemCount = buffer.readVarInt();
				Set<Item> items = new LinkedHashSet<>(itemCount);
				for (int j = 0; j < itemCount; j++) {
					items.add(Item.byId(buffer.readVarInt()));
				}
				tags.add(ITag.fromSet(items));
			}
			return new ChippedRecipe(this, recipeId, s, tags, icon);
		}

		@Override
		public void toNetwork(PacketBuffer buffer, @NotNull ChippedRecipe recipe) {
			buffer.writeUtf(recipe.group);
			buffer.writeVarInt(recipe.tags.size());
			for (ITag<Item> tag : recipe.tags) {
				List<Item> values = tag.getValues();
				buffer.writeVarInt(values.size());
				for (Item item : values) {
					buffer.writeVarInt(Item.getId(item));
				}
			}
		}

		public IRecipeType<?> getType() {
			return type;
		}
	}
}
