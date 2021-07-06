package com.grimbo.chipped.container;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.google.common.base.Suppliers;
import com.google.common.collect.Lists;
import com.grimbo.chipped.recipe.ChippedRecipe;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

//Pulled from net.minecraft.inventory.container.ChippedContainer
public class ChippedContainer extends Container {

	private final IWorldPosCallable access;
	private final IntReferenceHolder selectedRecipeIndex = IntReferenceHolder.standalone();
	private final World level;
	private ChippedRecipe recipe;
	private Supplier<List<ItemStack>> results;
	private ItemStack input = ItemStack.EMPTY;
	private long lastSoundTime;
	final Slot inputSlot;
	final Slot resultSlot;
	private Runnable slotUpdateListener = () -> {};
	public final IInventory container = new Inventory(1) {
		public void setChanged() {
			super.setChanged();
			ChippedContainer.this.slotsChanged(this);
			ChippedContainer.this.slotUpdateListener.run();
		}
	};

	private final CraftResultInventory resultContainer = new CraftResultInventory();

	//Stores dynamic container data
	private ContainerType<ChippedContainer> containerType;
	private IRecipeType<ChippedRecipe> recipeType;
	private Block blockWorkbench;

	public ChippedContainer(int id, PlayerInventory inventory, final IWorldPosCallable posCallable, ContainerType<ChippedContainer> container, IRecipeType<ChippedRecipe> recipe, Block block) {
		this(container, id, inventory, posCallable);
		recipeType = recipe;
		blockWorkbench = block;
	}

	public ChippedContainer(int id, PlayerInventory inventory, PacketBuffer extraData, ContainerType<ChippedContainer> container, IRecipeType<ChippedRecipe> recipe, Block block) {
		this(container, id, inventory, IWorldPosCallable.NULL);
		recipeType = recipe;
		blockWorkbench = block;
	}

	public ChippedContainer(ContainerType<ChippedContainer> container, int id, PlayerInventory inventory, final IWorldPosCallable posCallable) {
		super(container, id);
		containerType = container;
		this.access = posCallable;
		this.level = inventory.player.level;
		this.inputSlot = this.addSlot(new Slot(this.container, 0, 20, 33));
		this.resultSlot = this.addSlot(new Slot(this.resultContainer, 1, 143, 33) {
			public boolean mayPlace(ItemStack p_75214_1_) {
				return false;
			}

			public ItemStack onTake(PlayerEntity p_190901_1_, ItemStack p_190901_2_) {
				p_190901_2_.onCraftedBy(p_190901_1_.level, p_190901_1_, p_190901_2_.getCount());
				ChippedContainer.this.resultContainer.awardUsedRecipes(p_190901_1_);
				ItemStack itemstack = ChippedContainer.this.inputSlot.remove(1);
				if (!itemstack.isEmpty()) {
					ChippedContainer.this.setupResultSlot();
				}

				posCallable.execute((p_216954_1_, p_216954_2_) -> {
					long l = p_216954_1_.getGameTime();
					if (ChippedContainer.this.lastSoundTime != l) {
						p_216954_1_.playSound(null, p_216954_2_, SoundEvents.UI_STONECUTTER_TAKE_RESULT,
								SoundCategory.BLOCKS, 1.0F, 1.0F);
						ChippedContainer.this.lastSoundTime = l;
					}

				});
				return super.onTake(p_190901_1_, p_190901_2_);
			}
		});

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int k = 0; k < 9; ++k) {
			this.addSlot(new Slot(inventory, k, 8 + k * 18, 142));
		}

		this.addDataSlot(this.selectedRecipeIndex);
	}

	public int getSelectedIndex() {
		return this.selectedRecipeIndex.get();
	}

	public List<ItemStack> getResults() {
		return results == null ? Collections.emptyList() : results.get();
	}

	public boolean hasInputItem() {
		return this.inputSlot.hasItem() && results != null;
	}

	@Override
	public boolean stillValid(PlayerEntity p_75145_1_) { return stillValid(this.access, p_75145_1_, blockWorkbench); }

	public boolean clickMenuButton(PlayerEntity player, int index) {
		if (this.isValidRecipeIndex(index)) {
			this.selectedRecipeIndex.set(index);
			this.setupResultSlot();
		}

		return true;
	}

	private boolean isValidRecipeIndex(int index) {
		return index >= 0 && index < getResults().size();
	}

	@Override
	public void slotsChanged(IInventory p_75130_1_) {
		ItemStack itemstack = this.inputSlot.getItem();
		if (itemstack.getItem() != this.input.getItem()) {
			this.input = itemstack.copy();
			this.setupRecipeList(p_75130_1_, itemstack);
		}

	}

	private void setupRecipeList(IInventory inventory, ItemStack stack) {
		results = null;
		this.selectedRecipeIndex.set(-1);
		this.resultSlot.set(ItemStack.EMPTY);
		if (!stack.isEmpty()) {
			this.recipe = this.level.getRecipeManager().getRecipeFor(recipeType, inventory, this.level).orElse(null);
			if (recipe != null) {
				this.results = Suppliers.memoize(() -> recipe.getResults(inventory).collect(Collectors.toList()));
			}
		}
	}

	private void setupResultSlot() {
		if (recipe != null && results != null && !this.results.get().isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
			this.resultContainer.setRecipeUsed(recipe);
			this.resultSlot.set(results.get().get(selectedRecipeIndex.get()));
		} else {
			this.resultSlot.set(ItemStack.EMPTY);
		}

		this.broadcastChanges();
	}

	@Override
	public ContainerType<?> getType() {
		return containerType;
	}

	@OnlyIn(Dist.CLIENT)
	public void registerUpdateListener(Runnable p_217071_1_) {
		this.slotUpdateListener = p_217071_1_;
	}

	@Override
	public boolean canTakeItemForPickAll(ItemStack p_94530_1_, Slot p_94530_2_) {
		return p_94530_2_.container != this.resultContainer && super.canTakeItemForPickAll(p_94530_1_, p_94530_2_);
	}

	@Override
	public ItemStack quickMoveStack(PlayerEntity p_82846_1_, int p_82846_2_) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(p_82846_2_);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			Item item = itemstack1.getItem();
			itemstack = itemstack1.copy();
			if (p_82846_2_ == 1) {
				item.onCraftedBy(itemstack1, p_82846_1_.level, p_82846_1_);
				if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
					return ItemStack.EMPTY;
				}

				slot.onQuickCraft(itemstack1, itemstack);
			} else if (p_82846_2_ == 0) {
				if (!this.moveItemStackTo(itemstack1, 2, 38, false)) {
					return ItemStack.EMPTY;
				}
			} else if (this.level.getRecipeManager().getRecipeFor(recipeType, new Inventory(itemstack1), this.level)
					.isPresent()) {
				if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
					return ItemStack.EMPTY;
				}
			} else if (p_82846_2_ >= 2 && p_82846_2_ < 29) {
				if (!this.moveItemStackTo(itemstack1, 29, 38, false)) {
					return ItemStack.EMPTY;
				}
			} else if (p_82846_2_ >= 29 && p_82846_2_ < 38 && !this.moveItemStackTo(itemstack1, 2, 29, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			}

			slot.setChanged();
			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(p_82846_1_, itemstack1);
			this.broadcastChanges();
		}

		return itemstack;
	}

	@Override
	public void removed(PlayerEntity p_75134_1_) {
		super.removed(p_75134_1_);
		this.resultContainer.removeItemNoUpdate(1);
		this.access.execute((p_217079_2_, p_217079_3_) -> {
			this.clearContainer(p_75134_1_, p_75134_1_.level, this.container);
		});
	}
}