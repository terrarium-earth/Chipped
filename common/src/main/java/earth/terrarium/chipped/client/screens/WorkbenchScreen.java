package earth.terrarium.chipped.client.screens;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.menus.WorkbenchMenu;
import earth.terrarium.chipped.common.network.NetworkHandler;
import earth.terrarium.chipped.common.network.ServerboundCraftPacket;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Locale;

@NullMarked
public class WorkbenchScreen extends AbstractContainerScreen<WorkbenchMenu> {
    private static final Identifier TEXTURE = Chipped.id("textures/gui/container/workbench.png");
    public static final WidgetSprites SINGLE_BLOCK_BUTTON_SPRITES = new WidgetSprites(Chipped.id("single_block_button"), Chipped.id("single_block_button_highlighted"));
    public static final WidgetSprites HORIZONTAL_BLOCKS_BUTTON_SPRITES = new WidgetSprites(Chipped.id("horizontal_blocks_button"), Chipped.id("horizontal_blocks_button_highlighted"));
    public static final WidgetSprites VERTICAL_BLOCKS_BUTTON_SPRITES = new WidgetSprites(Chipped.id("vertical_blocks_button"), Chipped.id("vertical_blocks_button_highlighted"));
    public static final WidgetSprites TWO_BY_TWO_BUTTON_SPRITES = new WidgetSprites(Chipped.id("two_by_two_button"), Chipped.id("two_by_two_button_highlighted"));
    public static final WidgetSprites BUTTON_SPRITES = new WidgetSprites(Chipped.id("button"), Chipped.id("button_highlighted"));

    public static final int YELLOW = 0x70FFFF00;
    public static final int BLUE = 0x700000FF;
    public static final int DARK_GRAY = 0x70000000;

    private static final Component PREVIEW_TEXT = Component.translatable("text.chipped.preview");
    private static final Component CRAFT_TEXT = Component.translatable("text.chipped.craft");
    private static final Component CRAFT_ALL_TEXT = Component.translatable("text.chipped.craft_all");
    private static final Component SINGLE_TEXT = Component.translatable("text.chipped.single");
    private static final Component HORIZONTAL_TEXT = Component.translatable("text.chipped.horizontal");
    private static final Component VERTICAL_TEXT = Component.translatable("text.chipped.vertical");
    private static final Component TWO_BY_TWO_TEXT = Component.translatable("text.chipped.two_by_two");

    protected @Nullable EditBox search;
    protected @Nullable ScrollableLayout slots;

    protected RenderWindowWidget.Mode mode = RenderWindowWidget.Mode.TWO_BY_TWO;

    public WorkbenchScreen(WorkbenchMenu container, Inventory inventory, Component title) {
        super(container, inventory, title, 256, 256);
        this.titleLabelX = 88;
        this.titleLabelY = 14;
        this.inventoryLabelY = 155;
        this.inventoryLabelX = 88;
    }

    @Override
    protected void init() {
        super.init();

        this.search = addRenderableWidget(new EditBox(font, leftPos + 105, topPos + 27, 115, 11, Component.empty()));
        this.search.setTextColor(-1);
        this.search.setTextColorUneditable(-1);
        this.search.setBordered(false);
        this.search.setMaxLength(50);
        this.search.setResponder(_ -> this.setResults(this.menu.getResults()));
        this.search.setEditable(false);
        this.search.active = true;

        this.addRenderableWidget(new ImageButton(leftPos + 9, topPos + 121,
            18, 18,
            SINGLE_BLOCK_BUTTON_SPRITES,
            _ -> mode = RenderWindowWidget.Mode.SINGLE_BLOCK)
        ).setTooltip(Tooltip.create(SINGLE_TEXT));
        this.addRenderableWidget(new ImageButton(leftPos + 27, topPos + 121,
            18, 18,
            HORIZONTAL_BLOCKS_BUTTON_SPRITES,
            _ -> mode = RenderWindowWidget.Mode.HORIZONTAL_BLOCK)
        ).setTooltip(Tooltip.create(HORIZONTAL_TEXT));
        this.addRenderableWidget(new ImageButton(leftPos + 45, topPos + 121,
            18, 18,
            VERTICAL_BLOCKS_BUTTON_SPRITES,
            _ -> mode = RenderWindowWidget.Mode.VERTICAL_BLOCK)
        ).setTooltip(Tooltip.create(VERTICAL_TEXT));
        this.addRenderableWidget(new ImageButton(leftPos + 63, topPos + 121,
            18, 18,
            TWO_BY_TWO_BUTTON_SPRITES,
            _ -> mode = RenderWindowWidget.Mode.TWO_BY_TWO)
        ).setTooltip(Tooltip.create(TWO_BY_TWO_TEXT));

        this.addRenderableWidget(new ImageButton(leftPos + 9, topPos + 101,
            72, 18,
            BUTTON_SPRITES,
            _ -> {
                if (!this.menu.getSelectedInput().isEmpty()) {
                    NetworkHandler.CHANNEL.sendToServer(new ServerboundCraftPacket(menu.getSelectedOutput().typeHolder(), this.minecraft.hasShiftDown()));
                    this.minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_TAKE_RESULT, 1, 1));
                    this.menu.reset();
                    this.setResults(List.of());
                    this.setFocused(null);
                }
            }
        ));

        addRenderableWidget(new RenderWindowWidget(
            this.leftPos + 9,
            this.topPos + 26,
            72,
            72,
            this::getMode,
            this::getBlock
        ));

        this.setResults(this.menu.getResults());
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
        super.extractBackground(graphics, mouseX, mouseY, partialTicks);
        graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

        var hasShiftDown = this.minecraft.hasShiftDown();
        var output = this.menu.getSelectedOutput();
        var input = this.menu.getSelectedInput();

        if (!output.isEmpty() && !input.isEmpty()) {
            for (var slot : this.menu.slots) {
                var x = slot.x + this.leftPos;
                var y = slot.y + this.topPos;

                var isSame = ItemStack.isSameItem(input, slot.getItem());
                var color = input.equals(slot.getItem()) || (isSame && hasShiftDown) ? YELLOW : isSame ? BLUE : DARK_GRAY;
                graphics.fill(x - 1, y - 1, x + 17, y + 17, color);
            }
        }
    }

    @Override
    protected void extractLabels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
        super.extractLabels(graphics, mouseX, mouseY);

        graphics.text(this.font, PREVIEW_TEXT, 11, 14, 0xFF404040, false);

        var hasShiftDown = this.minecraft.hasShiftDown();
        var text = hasShiftDown ? CRAFT_ALL_TEXT : CRAFT_TEXT;
        graphics.text(font, text, 45 - font.width(text) / 2, 106, 0xFF404040, false);
    }

    @Override
    public boolean keyPressed(KeyEvent event) {
        if (event.isEscape()) {
            onClose();
            return true;
        } else if (getFocused() == this.search && this.search != null) {
            return this.search.keyPressed(event) || search.canConsumeInput() || super.keyPressed(event);
        } else {
            return super.keyPressed(event);
        }
    }

    @Override
    public boolean mouseReleased(MouseButtonEvent event) {
        if (getFocused() != this.search) {
            setFocused(null);
        }
        return super.mouseReleased(event);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        return this.getChildAt(mouseX, mouseY)
            .filter(child -> child.mouseScrolled(mouseX, mouseY, scrollX, scrollY))
            .isPresent();
    }

    public void setResults(List<Holder<Item>> results) {
        this.menu.setResults(results);

        var query = this.search != null ? this.search.getValue().toLowerCase(Locale.ROOT) : "";

        var filteredResults = results.stream()
            .map(Holder::value)
            .filter(item -> {
                var holder = item.builtInRegistryHolder();

                if (query.isEmpty()) return true;
                if (!holder.areComponentsBound()) return false;

                var name = holder.components().getOrDefault(DataComponents.ITEM_NAME, Component.empty());
                return name.getString().toLowerCase(Locale.ROOT).contains(query);
            })
            .map(ItemStack::new)
            .toList();

        var layout = new GridLayout();
        int rows = Math.max(6, Mth.ceil(filteredResults.size() / 9f));
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < rows; row++) {
                int index = col + row * 9;
                var stack = filteredResults.size() > index ? filteredResults.get(index) : ItemStack.EMPTY;
                layout.addChild(new SlotWidget(stack, menu), row, col);
            }
        }

        if (this.slots != null) this.slots.visitWidgets(this::removeWidget);
        if (this.search != null) this.search.setEditable(!this.menu.getSelectedInput().isEmpty() && !results.isEmpty());

        this.slots = new ScrollableLayout(layout, 108);
        this.slots.setPosition(this.leftPos + 85, this.topPos + 41);
        this.slots.arrangeElements();
        this.slots.visitWidgets(this::addRenderableWidget);
    }

    public RenderWindowWidget.Mode getMode() {
        return mode;
    }

    public @Nullable BlockState getBlock() {
        Block block = Block.byItem(menu.getSelectedOutput().getItem());
        if (block instanceof CrossCollisionBlock) {
            return block.defaultBlockState()
                .setValue(CrossCollisionBlock.NORTH, true)
                .setValue(CrossCollisionBlock.SOUTH, true);
        }
        BlockState state = block.defaultBlockState();
        return state.isAir() ? null : state;
    }
}