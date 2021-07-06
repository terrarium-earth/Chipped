package com.grimbo.chipped.recipe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import com.google.gson.JsonSyntaxException;
import com.mojang.realmsclient.util.JsonUtils;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.SingleItemRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tags.ITag;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagCollectionManager;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

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
	public boolean matches(IInventory inventory, World world) {
		Item item = inventory.getItem(0).getItem();
		if (item != Items.AIR) {
			for (ITag<Item> tag : tags) {
				if (item.is(tag)) {
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
		Item current = container.getItem(0).getItem();
		if (current != Items.AIR) {
			for (ITag<Item> tag : tags) {
				if (current.is(tag)) {
					return tag.getValues().stream().filter(item -> item != current).map(ItemStack::new);
				}
			}
		}
		return Stream.empty();
	}

	@Override
	public ItemStack assemble(IInventory inventory) {
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

	public String getGroup() {
		return group;
	}

	public ItemStack getToastSymbol() {
		return new ItemStack(icon);
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return serializer;
	}

	@Override
	public IRecipeType<?> getType() {
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
		public ChippedRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
			String s = JsonUtils.getStringOr("group", json, "");
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
		public ChippedRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
			String s = buffer.readUtf(32767);
			int tagCount = buffer.readVarInt();
			List<ITag<Item>> tags = new ArrayList<>(tagCount);
			for (int i = 0; i < tagCount; i++) {
				int itemCount = buffer.readVarInt();
				Set<Item> items = new HashSet<>(itemCount);
				for (int j = 0; j < itemCount; j++) {
					items.add(Item.byId(buffer.readVarInt()));
				}
				tags.add(ITag.fromSet(items));
			}
			return new ChippedRecipe(this, recipeId, s, tags, icon);
		}

		@Override
		public void toNetwork(PacketBuffer buffer, ChippedRecipe recipe) {
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
