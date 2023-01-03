package earth.terrarium.chipped.menus;

import com.google.common.base.Suppliers;
import earth.terrarium.chipped.recipe.ChippedRecipe;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

//Pulled from net.minecraft.inventory.container.ChippedMenu
public class ChippedMenu extends AbstractContainerMenu {

    final Slot inputSlot;
    final Slot resultSlot;
    private final ContainerLevelAccess access;
    private final DataSlot selectedRecipeIndex = DataSlot.standalone();
    private final Level level;
    private final ResultContainer resultContainer = new ResultContainer();
    //Stores dynamic container data
    private final MenuType<ChippedMenu> containerType;
    private ChippedRecipe recipe;
    private Supplier<List<ItemStack>> results;
    private ItemStack input = ItemStack.EMPTY;
    private long lastSoundTime;
    private Runnable slotUpdateListener = () -> {
    };
    private RecipeType<ChippedRecipe> recipeType;
    public final Container container = new SimpleContainer(1) {
        public void setChanged() {
            super.setChanged();
            ChippedMenu.this.slotsChanged(this);
            ChippedMenu.this.slotUpdateListener.run();
        }
    };
    private Block blockWorkbench;

    public ChippedMenu(int id, Inventory inventory, final ContainerLevelAccess posCallable, MenuType<ChippedMenu> container, RecipeType<ChippedRecipe> recipe, Block block) {
        this(container, id, inventory, posCallable);
        recipeType = recipe;
        blockWorkbench = block;
    }

    public ChippedMenu(MenuType<ChippedMenu> container, int id, Inventory inventory, final ContainerLevelAccess posCallable) {
        super(container, id);
        containerType = container;
        this.access = posCallable;
        this.level = inventory.player.level;
        this.inputSlot = this.addSlot(new Slot(this.container, 0, 20, 33));
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, 1, 143, 33) {
            public boolean mayPlace(@NotNull ItemStack stack) {
                return false;
            }

            public void onTake(@NotNull Player player, @NotNull ItemStack stack) {
                stack.onCraftedBy(player.level, player, stack.getCount());
                ChippedMenu.this.resultContainer.awardUsedRecipes(player);
                ItemStack itemstack = ChippedMenu.this.inputSlot.remove(1);
                if (!itemstack.isEmpty()) {
                    ChippedMenu.this.setupResultSlot();
                }

                posCallable.execute((p_216954_1_, p_216954_2_) -> {
                    long l = p_216954_1_.getGameTime();
                    if (ChippedMenu.this.lastSoundTime != l) {
                        p_216954_1_.playSound(null, p_216954_2_, SoundEvents.UI_STONECUTTER_TAKE_RESULT,
                                SoundSource.BLOCKS, 1.0F, 1.0F);
                        ChippedMenu.this.lastSoundTime = l;
                    }

                });
                super.onTake(player, stack);
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
    public boolean stillValid(@NotNull Player player) {
        return stillValid(this.access, player, blockWorkbench);
    }

    public boolean clickMenuButton(@NotNull Player player, int index) {
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
    public void slotsChanged(@NotNull Container inventory) {
        ItemStack itemstack = this.inputSlot.getItem();
        if (itemstack.getItem() != this.input.getItem()) {
            this.input = itemstack.copy();
            this.setupRecipeList(inventory, itemstack);
        }

    }

    private void setupRecipeList(Container inventory, ItemStack stack) {
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
            this.resultSlot.set(results.get().get(selectedRecipeIndex.get()).copy());
        } else {
            this.resultSlot.set(ItemStack.EMPTY);
        }

        this.broadcastChanges();
    }

    @Override
    public @NotNull MenuType<?> getType() {
        return containerType;
    }

    @Environment(EnvType.CLIENT)
    public void registerUpdateListener(Runnable p_217071_1_) {
        this.slotUpdateListener = p_217071_1_;
    }

    @Override
    public boolean canTakeItemForPickAll(@NotNull ItemStack stack, Slot slot) {
        return slot.container != this.resultContainer && super.canTakeItemForPickAll(stack, slot);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int p_82846_2_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_82846_2_);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            Item item = itemstack1.getItem();
            itemstack = itemstack1.copy();
            if (p_82846_2_ == 1) {
                item.onCraftedBy(itemstack1, player.level, player);
                if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (p_82846_2_ == 0) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.level.getRecipeManager().getRecipeFor(recipeType, new SimpleContainer(itemstack1), this.level)
                    .isPresent()) {
                if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (p_82846_2_ < 29) {
                if (!this.moveItemStackTo(itemstack1, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (p_82846_2_ < 38 && !this.moveItemStackTo(itemstack1, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
            this.broadcastChanges();
        }

        return itemstack;
    }

    @Override
    public void removed(@NotNull Player player) {
        super.removed(player);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((p_217079_2_, p_217079_3_) -> this.clearContainer(player, this.container));
    }
}