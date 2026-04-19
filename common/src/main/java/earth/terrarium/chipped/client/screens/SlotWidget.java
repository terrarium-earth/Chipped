package earth.terrarium.chipped.client.screens;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.menus.WorkbenchMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class SlotWidget extends AbstractWidget {
    private static final Identifier TEXTURE = Chipped.id("textures/gui/sprites/slot.png");
    private static final Identifier SLOT_HIGHLIGHT_BACK_SPRITE = Identifier.withDefaultNamespace("container/slot_highlight_back");
    private static final Identifier SLOT_HIGHLIGHT_FRONT_SPRITE = Identifier.withDefaultNamespace("container/slot_highlight_front");

    private final ItemStack stack;
    private final WorkbenchMenu menu;

    public SlotWidget(ItemStack stack, WorkbenchMenu menu) {
        super(0, 0, 18, 18, CommonComponents.EMPTY);
        this.stack = stack;
        this.menu = menu;
    }

    @Override
    protected void extractWidgetRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
        var isHovered = isMouseOver(mouseX, mouseY);

        if (isHovered) {
            graphics.blitSprite(RenderPipelines.GUI_TEXTURED, SLOT_HIGHLIGHT_BACK_SPRITE, getX() - 3, getY() - 3, 24, 24);
        }

        graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, getX(), getY(), 0, 0, 18, 18, 18, 18);
        graphics.item(this.stack, getX() + 1, getY() + 1);

        if (isHovered) {
            graphics.blitSprite(RenderPipelines.GUI_TEXTURED, SLOT_HIGHLIGHT_FRONT_SPRITE, getX() - 3, getY() - 3, 24, 24);
        }

        if (isHoveredOrFocused() && !this.stack.isEmpty()) {
            graphics.setTooltipForNextFrame(Minecraft.getInstance().font, this.stack, mouseX, mouseY);
        }
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {}

    @Override
    public boolean mouseClicked(MouseButtonEvent event, boolean doubleClick) {
        if (this.isMouseOver(event.x(), event.y()) && this.isActive()) {
            if (this.stack.isEmpty()) return false;
            this.menu.setSelectedOutput(this.stack);
        }
        return super.mouseClicked(event, doubleClick);
    }
}
