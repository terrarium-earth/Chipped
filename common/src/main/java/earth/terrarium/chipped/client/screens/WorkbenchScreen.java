package earth.terrarium.chipped.client.screens;

import com.teamresourceful.resourcefullib.client.utils.RenderUtils;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.menus.WorkbenchMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class WorkbenchScreen extends AbstractContainerScreen<WorkbenchMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Chipped.MOD_ID, "textures/gui/container/workbench.png");

    private static final ResourceLocation RECIPE_TEXTURE = new ResourceLocation(Chipped.MOD_ID, "textures/gui/sprites/recipe.png");
    private static final ResourceLocation RECIPE_SELECTED_TEXTURE = new ResourceLocation(Chipped.MOD_ID, "textures/gui/sprites/recipe_selected.png");
    private static final ResourceLocation RECIPE_HIGHLIGHT_TEXTURE = new ResourceLocation(Chipped.MOD_ID, "textures/gui/sprites/recipe_highlighted.png");

    private EditBox searchBox;
    private double scrollAmount;

    public WorkbenchScreen(WorkbenchMenu container, Inventory inventory, Component title) {
        super(container, inventory, title);
        this.imageWidth = 176;
        this.imageHeight = 180;
        this.inventoryLabelY += 14;
    }

    @Override
    protected void init() {
        super.init();
        searchBox = addRenderableWidget(new EditBox(font, leftPos + 53, topPos + 17, 70, 11, Component.empty()));
        searchBox.setMaxLength(50);
        searchBox.setBordered(false);
        searchBox.setResponder(s -> {
            scrollAmount = 0;
            clickRecipe(-1);
        });
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);
        renderRecipes(graphics, leftPos + 52, topPos + 27, mouseX, mouseY);
        renderTooltip(graphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        int left = (this.width - this.imageWidth) / 2;
        int top = (this.height - this.imageHeight) / 2;
        graphics.blit(TEXTURE, left, top, 0, 0, this.imageWidth, this.imageHeight, 256, 256);
    }

    @Override
    protected void containerTick() {
        super.containerTick();
        searchBox.tick();
    }

    @Override
    protected void slotClicked(Slot slot, int slotId, int mouseButton, ClickType type) {
        super.slotClicked(slot, slotId, mouseButton, type);
        if ((type == ClickType.QUICK_MOVE && slotId != 1) || (type == ClickType.QUICK_CRAFT && slotId == 0)) {
            setFocused(searchBox);
        }
    }

    private void renderRecipes(GuiGraphics graphics, int x, int y, int mouseX, int mouseY) {
        List<ItemStack> results = menu.results();
        if (results.isEmpty()) setFocused(null);
        int scrollPixels = (int) scrollAmount;
        int offset = 0;
        ItemStack tooltipStack = null;
        try (var ignored = RenderUtils.createScissorBox(Minecraft.getInstance(), graphics.pose(), x - 1, y + 2, 81, 54)) {
            for (int i = 0; i < results.size(); i++) {
                ItemStack stack = results.get(i);
                if (!searchBox.getValue().isEmpty() && !stack.getItem().getName(stack).getString().toLowerCase(Locale.ROOT).contains(searchBox.getValue().toLowerCase(Locale.ROOT))) {
                    offset++;
                    continue;
                }
                int k = x + (i - offset) % 5 * 16;
                int l = (i - offset) / 5;
                int m = (y - scrollPixels) + l * 16 + 2;
                graphics.renderItem(stack, k, m);
                boolean isSelected = ItemStack.isSameItem(menu.slots.get(1).getItem(), stack);
                if (mouseX >= k && mouseX <= k + 15 && mouseY >= m && mouseY <= m + 15 && mouseY < y + 57) {
                    tooltipStack = stack;
                    graphics.blit(isSelected ? RECIPE_SELECTED_TEXTURE : RECIPE_HIGHLIGHT_TEXTURE, k, m, 0, 0, 16, 16, 16, 16);
                } else {
                    graphics.blit(isSelected ? RECIPE_SELECTED_TEXTURE : RECIPE_TEXTURE, k, m, 0, 0, 16, 16, 16, 16);
                }
            }
        }
        if (tooltipStack != null) {
            graphics.renderTooltip(font, tooltipStack, mouseX, mouseY);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        List<ItemStack> results = menu.results();
        int scrollPixels = (int) scrollAmount;
        int offset = 0;
        for (int i = 0; i < results.size(); i++) {
            ItemStack stack = results.get(i);
            if (!searchBox.getValue().isEmpty() && !stack.getItem().getName(stack).getString().toLowerCase(Locale.ROOT).contains(searchBox.getValue().toLowerCase(Locale.ROOT))) {
                offset++;
                continue;
            }
            int x = leftPos + 52;
            int y = topPos + 27;
            int k = x + (i - offset) % 5 * 16;
            int l = (i - offset) / 5;
            int m = (y - scrollPixels) + l * 16 + 2;
            if (mouseX >= k && mouseX <= k + 16 && mouseY >= m && mouseY <= m + 16 && mouseY < y + 57) {
                Objects.requireNonNull(minecraft).getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
                clickRecipe(i);
                searchBox.setFocused(false);
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    private void clickRecipe(int index) {
        Objects.requireNonNull(Objects.requireNonNull(minecraft).gameMode).handleInventoryButtonClick(menu.containerId, index);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (Objects.requireNonNull(minecraft).options.keyInventory.matches(keyCode, scanCode)) {
            if (searchBox.isFocused()) {
                return false;
            }
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
        setScrollAmount(scrollAmount - delta * 16 / 2f);
        return true;
    }

    protected void setScrollAmount(double amount) {
        int size = menu.results().stream().filter(stack -> stack.getItem().getName(stack).getString().toLowerCase(Locale.ROOT).contains(searchBox.getValue().toLowerCase(Locale.ROOT))).toArray().length;
        scrollAmount = Mth.clamp(amount, 0, Math.max(0, ((size / 5) + (size % 5 == 0 ? 0 : 1)) * 16 - 55));
    }
}