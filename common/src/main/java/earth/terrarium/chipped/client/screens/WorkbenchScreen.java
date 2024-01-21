package earth.terrarium.chipped.client.screens;

import com.mojang.blaze3d.vertex.PoseStack;
import com.teamresourceful.resourcefullib.client.screens.AbstractContainerCursorScreen;
import com.teamresourceful.resourcefullib.client.utils.RenderUtils;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.menus.WorkbenchMenu;
import earth.terrarium.chipped.common.network.NetworkHandler;
import earth.terrarium.chipped.common.network.ServerboundCraftPacket;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WorkbenchScreen extends AbstractContainerCursorScreen<WorkbenchMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Chipped.MOD_ID, "textures/gui/container/workbench.png");

    private static final ResourceLocation SINGLE_BLOCK_BUTTON = new ResourceLocation(Chipped.MOD_ID, "textures/gui/sprites/single_block_button.png");
    private static final ResourceLocation HORIZONTAL_BLOCKS_BUTTON = new ResourceLocation(Chipped.MOD_ID, "textures/gui/sprites/horizontal_blocks_button.png");
    private static final ResourceLocation VERTICAL_BLOCKS_BUTTON = new ResourceLocation(Chipped.MOD_ID, "textures/gui/sprites/vertical_blocks_button.png");
    private static final ResourceLocation TWO_BY_TWO_BUTTON = new ResourceLocation(Chipped.MOD_ID, "textures/gui/sprites/two_by_two_button.png");
    private static final ResourceLocation BUTTON = new ResourceLocation(Chipped.MOD_ID, "textures/gui/sprites/button.png");

    public static final int YELLOW = 0xFFFFFF00;
    public static final int BLUE = 0xFF0000FF;

    private static final Component PREVIEW_TEXT = Component.translatable("text.chipped.preview");
    private static final Component CRAFT_TEXT = Component.translatable("text.chipped.craft");
    private static final Component SINGLE_TEXT = Component.translatable("text.chipped.single");
    private static final Component HORIZONTAL_TEXT = Component.translatable("text.chipped.horizontal");
    private static final Component VERTICAL_TEXT = Component.translatable("text.chipped.vertical");
    private static final Component TWO_BY_TWO_TEXT = Component.translatable("text.chipped.two_by_two");

    protected EditBox searchBox;
    protected double scrollAmount;


    protected GridLayout grid;
    protected final List<SlotWidget> slotWidgets = new ArrayList<>();
    protected Mode mode = Mode.SINGLE_BLOCK;

    public WorkbenchScreen(WorkbenchMenu container, Inventory inventory, Component title) {
        super(container, inventory, title);
        this.imageWidth = 256;
        this.imageHeight = 256;
        this.titleLabelX = 88;
        this.titleLabelY = 14;
        this.inventoryLabelY = 155;
        this.inventoryLabelX = 88;
    }

    @Override
    protected void init() {
        super.init();

        searchBox = addRenderableWidget(new EditBox(font, leftPos + 104, topPos + 27, 115, 11, Component.empty()));
        searchBox.setCanLoseFocus(false);
        searchBox.setTextColor(-1);
        searchBox.setTextColorUneditable(-1);
        searchBox.setBordered(false);
        searchBox.setMaxLength(50);
        searchBox.setResponder(this::onSearchBarChanged);
        setInitialFocus(searchBox);
        searchBox.setEditable(false);

        addRenderableWidget(new ImageButton(leftPos + 9, topPos + 121,
            18, 18,
            0, 0, 18,
            SINGLE_BLOCK_BUTTON, 18, 36,
            button -> mode = Mode.SINGLE_BLOCK)).setTooltip(Tooltip.create(SINGLE_TEXT));
        addRenderableWidget(new ImageButton(leftPos + 27, topPos + 121,
            18, 18,
            0, 0, 18,
            HORIZONTAL_BLOCKS_BUTTON, 18, 36,
            button -> mode = Mode.HORIZONTAL_BLOCK)).setTooltip(Tooltip.create(HORIZONTAL_TEXT));
        addRenderableWidget(new ImageButton(leftPos + 45, topPos + 121,
            18, 18,
            0, 0, 18,
            VERTICAL_BLOCKS_BUTTON, 18, 36,
            button -> mode = Mode.VERTICAL_BLOCK)).setTooltip(Tooltip.create(VERTICAL_TEXT));
        addRenderableWidget(new ImageButton(leftPos + 63, topPos + 121,
            18, 18,
            0, 0, 18,
            TWO_BY_TWO_BUTTON, 18, 36,
            button -> mode = Mode.TWO_BY_TWO)).setTooltip(Tooltip.create(TWO_BY_TWO_TEXT));

        addRenderableWidget(new ImageButton(leftPos + 9, topPos + 101,
            72, 18,
            0, 0, 18,
            BUTTON, 72, 36,
            button -> {
                if (!menu.selectedStack().isEmpty()) {
                    NetworkHandler.CHANNEL.sendToServer(new ServerboundCraftPacket(menu.chosenStack(), hasShiftDown()));
                    minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_TAKE_RESULT, 1, 1));
                    menu.reset();
                    addSlotWidgets();
                    scrollAmount = 0;
                }
            }));

        addSlotWidgets();
    }

    private void addSlotWidgets() {
        slotWidgets.forEach(this::removeWidget);
        slotWidgets.clear();

        int left = (width - imageWidth) / 2;
        int top = (height - imageHeight) / 2;
        grid = new GridLayout(left + 85, top + 41);
        var results = menu.results();
        int rows = Math.max(6, Mth.ceil(results.size() / 9f));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < rows; j++) {
                int index = i + j * 9;
                var stack = results.size() > index ? results.get(index) : ItemStack.EMPTY;
                SlotWidget slot = addWidget(new SlotWidget(stack, menu, top + 40, top + 141));
                grid.addChild(slot, j, i);
                slotWidgets.add(slot);
            }
        }
        grid.arrangeElements();
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);

        int left = (width - imageWidth) / 2;
        int top = (height - imageHeight) / 2;
        grid.setY(top + 41 - (int) scrollAmount);
        try (var ignored = RenderUtils.createScissorBox(Objects.requireNonNull(minecraft), graphics.pose(), left + 84, top + 40, 163, 101)) {
            for (var widget : slotWidgets) {
                widget.renderWidget(graphics, mouseX, mouseY, partialTick);
            }
        }

        for (var widget : slotWidgets) {
            widget.renderTooltip(graphics, font, mouseX, mouseY);
        }

        renderTooltip(graphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        int left = (width - imageWidth) / 2;
        int top = (height - imageHeight) / 2;
        graphics.blit(TEXTURE, left, top, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
        graphics.drawString(font, PREVIEW_TEXT, left + 11, top + 14, 0x404040, false);
        graphics.drawCenteredString(font, CRAFT_TEXT, left + 45, top + 106, 0x404040);

        var stack = menu.chosenStack();
        if (stack.isEmpty()) return;
        renderBlock(graphics, stack);

        var selectedStack = menu.selectedStack();
        if (selectedStack.isEmpty()) return;
        for (var slot : menu.slots) {
            if (selectedStack.equals(slot.getItem()) || (ItemStack.isSameItem(selectedStack, slot.getItem()) && hasShiftDown())) {
                graphics.renderOutline(slot.x + left - 1, slot.y + 6, 18, 18, YELLOW);
            } else if (ItemStack.isSameItem(selectedStack, slot.getItem())) {
                graphics.renderOutline(slot.x + left - 1, slot.y + 6, 18, 18, BLUE);
            }
        }
    }

    private void onSearchBarChanged(String filter) {
        scrollAmount = 0;
        menu.updateResults(filter);
        addSlotWidgets();
    }

    @Override
    protected void slotClicked(Slot slot, int slotId, int mouseButton, ClickType type) {
        super.slotClicked(slot, slotId, mouseButton, type);
        addSlotWidgets();
        searchBox.setEditable(!menu.selectedStack().isEmpty());
        scrollAmount = 0;
        menu.setFilter(searchBox.getValue());
    }

    @Override
    public void containerTick() {
        super.containerTick();
        searchBox.tick();
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            menu.player().closeContainer();
        }

        setFocused(searchBox);
        return searchBox.keyPressed(keyCode, scanCode, modifiers)
            || searchBox.canConsumeInput()
            || super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (getFocused() != searchBox) {
            setFocused(null);
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
        if (menu.results().size() <= 54) return false;
        setScrollAmount(scrollAmount - delta * 16 / 2f);
        return true;
    }

    protected void setScrollAmount(double amount) {
        int rows = Mth.ceil(menu.results().size() / 9f);
        scrollAmount = Mth.clamp(amount, 0, rows * 18 - 100);
    }

    private void renderBlock(GuiGraphics graphics, ItemStack stack) {
        int left = (width - imageWidth) / 2;
        int top = (height - imageHeight) / 2;

        BlockState state = Block.byItem(stack.getItem()).defaultBlockState();
        if (state.isAir()) return;
        PoseStack poseStack = graphics.pose();

        switch (mode) {
            case SINGLE_BLOCK -> renderSingleBlock(poseStack, state, left, top);
            case HORIZONTAL_BLOCK -> renderHorizontalBlocks(poseStack, state, left, top);
            case VERTICAL_BLOCK -> renderVerticalBlocks(poseStack, state, left, top);
            case TWO_BY_TWO -> renderTwoByTwo(poseStack, state, left, top);
        }
    }

    private void renderSingleBlock(PoseStack poseStack, BlockState state, int left, int top) {} // TODO

    private void renderHorizontalBlocks(PoseStack poseStack, BlockState state, int left, int top) {} // TODO

    private void renderVerticalBlocks(PoseStack poseStack, BlockState state, int left, int top) {} // TODO

    private void renderTwoByTwo(PoseStack poseStack, BlockState state, int left, int top) {} // TODO

    protected enum Mode {
        SINGLE_BLOCK,
        HORIZONTAL_BLOCK,
        VERTICAL_BLOCK,
        TWO_BY_TWO,
    }
}