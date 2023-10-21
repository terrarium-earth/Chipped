package earth.terrarium.chipped.common.menu;

import earth.terrarium.chipped.common.block.WorkbenchBlock;
import earth.terrarium.chipped.common.block.WorkbenchBlockEntity;
import earth.terrarium.chipped.common.recipe.ChippedRecipe;
import earth.terrarium.chipped.common.registry.ModMenuTypes;
import earth.terrarium.chipped.common.utils.WorldUtils;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class WorkbenchMenu extends AbstractContainerMenu {
    private final WorkbenchBlockEntity entity;
    protected final Inventory inventory;
    protected final Player player;
    protected final Level level;
    private final RecipeType<ChippedRecipe> recipeType;

    private final ResultContainer resultContainer;
    private final List<ItemStack> results = new ArrayList<>();

    private ItemStack input = ItemStack.EMPTY;
    private long lastSoundTime;
    private int selectedIndex = -1;

    public WorkbenchMenu(int id, Inventory inventory, FriendlyByteBuf buf) {
        this(id, inventory, getBlockEntityFromBuf(inventory.player.level(), buf));
    }

    public WorkbenchMenu(int id, Inventory inventory, WorkbenchBlockEntity entity) {
        super(ModMenuTypes.WORKBENCH.get(), id);

        this.entity = entity;
        this.inventory = inventory;
        this.player = inventory.player;
        this.level = player.level();
        this.resultContainer = new ResultContainer();
        recipeType = ((WorkbenchBlock) entity.getBlockState().getBlock()).recipeType();

        addMenuSlots();
        addPlayerInvSlots();
        slotsChanged(entity);
    }

    protected int getContainerInputEnd() {
        return 1;
    }

    protected int getInventoryStart() {
        return 1;
    }

    protected int startIndex() {
        return 0;
    }

    public int getPlayerInvXOffset() {
        return 8;
    }

    public int getPlayerInvYOffset() {
        return 98;
    }

    protected void addMenuSlots() {
        addSlot(new Slot(entity, 0, 20, 47) {
            @Override
            public void setChanged() {
                super.setChanged();
                slotsChanged(this.container);
            }
        });
        addSlot(new FurnaceResultSlot(player, resultContainer, 1, 143, 47) {
            @Override
            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player.level(), player, stack.getCount());
                ItemStack input = slots.get(0).remove(1);
                if (!input.isEmpty()) {
                    setupResultSlot();
                }

                long time = level.getGameTime();
                if (lastSoundTime != time) {
                    level.playSound(null, entity.getBlockPos(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
                    lastSoundTime = time;
                }

                super.onTake(player, stack);
            }
        });
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return true;
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = slots.get(index);
        if (slot.hasItem()) {
            ItemStack slotItem = slot.getItem();
            itemStack = slotItem.copy();

            if (index == 1) {
                slotItem.getItem().onCraftedBy(slotItem, player.level(), player);
				if (!this.moveItemStackTo(slotItem, 2, 38, true)) {
					return ItemStack.EMPTY;
				}

				slot.onQuickCraft(slotItem, itemStack);

                if (slotItem.isEmpty()) {
                    slot.setByPlayer(ItemStack.EMPTY);
                }

                slot.setChanged();
                if (slotItem.getCount() == itemStack.getCount()) {
                    return ItemStack.EMPTY;
                }

                slot.onTake(player, slotItem);
                this.broadcastChanges();

                return itemStack;
            }

            if (index < getInventoryStart()) {
                if (!moveItemStackTo(slotItem, getInventoryStart(), slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!moveItemStackTo(slotItem, startIndex(), getContainerInputEnd(), false)) {
                return ItemStack.EMPTY;
            }

            if (slotItem.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return itemStack;
    }

    protected void addPlayerInvSlots() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlot(new Slot(inventory, j + i * 9 + 9, getPlayerInvXOffset() + j * 18, getPlayerInvYOffset() + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            addSlot(new Slot(inventory, i, getPlayerInvXOffset() + i * 18, getPlayerInvYOffset() + 58));
        }
    }

    @Override
    public void slotsChanged(Container container) {
        super.slotsChanged(container);
        ItemStack inputStack = slots.get(0).getItem();
        if (!inputStack.is(input.getItem())) {
            input = inputStack.copy();
            updateResults(container, inputStack);
            selectedIndex = -1;
        }
    }

    private void updateResults(Container container, ItemStack stack) {
        results.clear();
        slots.get(1).set(ItemStack.EMPTY);
        if (stack.isEmpty()) return;
        level.getRecipeManager().getRecipeFor(recipeType, container, this.level).ifPresent(recipe ->
            recipe.getResults(container).forEach(results::add));
    }

    public List<ItemStack> results() {
        return results;
    }

    @Override
    public void clicked(int slotIndex, int button, @NotNull ClickType actionType, @NotNull Player player) {
        super.clicked(slotIndex, button, actionType, player);
        broadcastFullState();
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.resultContainer.removeItemNoUpdate(1);
    }

    @Override
    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != resultContainer && super.canTakeItemForPickAll(stack, slot);
    }

    @Override
    public boolean clickMenuButton(Player player, int id) {
        selectedIndex = id;
        setupResultSlot();
        return true;
    }

    private void setupResultSlot() {
        if (selectedIndex == -1 || slots.get(0).getItem().isEmpty()) {
            slots.get(1).set(ItemStack.EMPTY);
        } else if (results.size() > selectedIndex) {
            ItemStack stack = results.get(selectedIndex);
            if (!stack.isEmpty()) {
                slots.get(1).set(stack.copy());
            }
        }
    }

    protected static WorkbenchBlockEntity getBlockEntityFromBuf(Level level, FriendlyByteBuf buf) {
        if (buf == null) return null;
        if (!level.isClientSide) return null;
        return WorldUtils.getTileEntity(WorkbenchBlockEntity.class, level, buf.readBlockPos());
    }
}