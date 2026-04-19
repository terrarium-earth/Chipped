package earth.terrarium.chipped.common.menus;

import earth.terrarium.chipped.common.network.ClientboundRecipesPacket;
import earth.terrarium.chipped.common.network.NetworkHandler;
import earth.terrarium.chipped.common.recipes.ChippedRecipe;
import earth.terrarium.chipped.common.registry.ModMenuTypes;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NullMarked;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NullMarked
public class WorkbenchMenu extends AbstractContainerMenu {

    private static final int PLAYER_X = 86;
    private static final int PLAYER_Y = 167;

    protected final Inventory inventory;
    protected final Level level;

    private List<Holder<Item>> results = new ArrayList<>();

    private int slot;
    private ItemStack input = ItemStack.EMPTY;
    private ItemStack output = ItemStack.EMPTY;

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public WorkbenchMenu(int containerId, Inventory inventory, Optional<WorkbenchMenuProvider.Content> content) {
        super(ModMenuTypes.WORKBENCH.get(), containerId);
        this.inventory = inventory;
        this.level = inventory.player.level();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlot(new InventorySlot(inventory, col + row * 9 + 9, PLAYER_X + col * 18, PLAYER_Y + row * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            addSlot(new InventorySlot(inventory, i, PLAYER_X + i * 18, PLAYER_Y + 58));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void clicked(int slot, int buttonNum, ContainerInput input, Player player) {
        if (slot >= 0 && slot < this.slots.size()) {
            this.slot = this.slots.get(slot).getContainerSlot();
            this.input = this.slots.get(slot).getItem();
            this.output = this.input;
            // reset search

            if (player instanceof ServerPlayer sp) {
                this.setResults(ChippedRecipe.getResultsFor(sp, this.input));
                NetworkHandler.CHANNEL.sendToPlayer(new ClientboundRecipesPacket(this.results, false), sp);
            }
        }
        super.clicked(slot, buttonNum, input, player);
    }

    public void setResults(List<Holder<Item>> results) {
        this.results = new ArrayList<>(results);
    }

    public void craft(Holder<Item> item, boolean replaceAll) {
        if (this.results.contains(item)) {
            if (replaceAll) {
                for (int i = 0; i < this.inventory.getContainerSize(); i++) {
                    var slot = this.inventory.getSlot(i);
                    if (slot != null && slot.get().is(this.input.getItem())) {
                        slot.set(slot.get().transmuteCopy(item.value()));
                    }
                }
            } else if (this.slot != -1) {
                var slot = this.inventory.getSlot(this.slot);
                if (slot != null && slot.get().is(this.input.getItem())) {
                    slot.set(slot.get().transmuteCopy(item.value()));
                }
            }
            this.broadcastChanges();
        }

        this.reset();
        NetworkHandler.CHANNEL.sendToPlayer(new ClientboundRecipesPacket(this.results, true), this.inventory.player);
    }

    public void reset() {
        this.slot = -1;
        this.input = ItemStack.EMPTY;
        this.output = ItemStack.EMPTY;
        this.results.clear();
    }

    public ItemStack getSelectedInput() {
        return input;
    }

    public ItemStack getSelectedOutput() {
        return output;
    }

    public void setSelectedOutput(ItemStack stack) {
        output = stack;
    }

    public List<Holder<Item>> getResults() {
        return this.results;
    }

    private static class InventorySlot extends Slot {
        public InventorySlot(Container container, int slot, int x, int y) {
            super(container, slot, x, y);
        }

        @Override
        public boolean mayPickup(Player player) {
            return false;
        }
    }
}