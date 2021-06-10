package com.grimbo.chipped.container;

import java.util.List;

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
	private List<ChippedRecipe> recipes = Lists.newArrayList();
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

	@OnlyIn(Dist.CLIENT)
	public int getSelectedRecipeIndex() {
		return this.selectedRecipeIndex.get();
	}

	@OnlyIn(Dist.CLIENT)
	public List<ChippedRecipe> getRecipes() {
		return this.recipes;
	}

	@OnlyIn(Dist.CLIENT)
	public int getNumRecipes() {
		return this.recipes.size();
	}

	@OnlyIn(Dist.CLIENT)
	public boolean hasInputItem() {
		return this.inputSlot.hasItem() && !this.recipes.isEmpty();
	}

	@Override
	public boolean stillValid(PlayerEntity p_75145_1_) { return stillValid(this.access, p_75145_1_, blockWorkbench); }

	public boolean clickMenuButton(PlayerEntity p_75140_1_, int p_75140_2_) {
		if (this.isValidRecipeIndex(p_75140_2_)) {
			this.selectedRecipeIndex.set(p_75140_2_);
			this.setupResultSlot();
		}

		return true;
	}

	private boolean isValidRecipeIndex(int p_241818_1_) {
		return p_241818_1_ >= 0 && p_241818_1_ < this.recipes.size();
	}

	@Override
	public void slotsChanged(IInventory p_75130_1_) {
		ItemStack itemstack = this.inputSlot.getItem();
		if (itemstack.getItem() != this.input.getItem()) {
			this.input = itemstack.copy();
			this.setupRecipeList(p_75130_1_, itemstack);
		}

	}

	private void setupRecipeList(IInventory p_217074_1_, ItemStack p_217074_2_) {
		this.recipes.clear();
		this.selectedRecipeIndex.set(-1);
		this.resultSlot.set(ItemStack.EMPTY);
		if (!p_217074_2_.isEmpty()) {
			this.recipes = this.level.getRecipeManager().getRecipesFor(recipeType, p_217074_1_, this.level);
		}

	}

	private void setupResultSlot() {
		if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
			ChippedRecipe chippedrecipe = this.recipes.get(this.selectedRecipeIndex.get());
			this.resultContainer.setRecipeUsed(chippedrecipe);
			this.resultSlot.set(chippedrecipe.assemble(this.container));
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