package earth.terrarium.chipped.client.screens;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.AbstractContainerWidget;
import net.minecraft.client.gui.components.AbstractScrollArea;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.layouts.Layout;
import net.minecraft.client.gui.layouts.LayoutElement;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.navigation.ScreenDirection;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.network.chat.CommonComponents;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

@NullMarked
public class ScrollableLayout implements Layout {
    private static final int DEFAULT_SCROLLBAR_SPACING = 4;

    private final Layout content;
    private final ScrollableLayout.Container container;
    private final int maxHeight;

    public ScrollableLayout(Layout content, int maxHeight) {
        this.content = content;
        this.maxHeight = maxHeight;
        this.container = new Container(0, maxHeight);
    }

    @Override
    public void arrangeElements() {
        this.content.arrangeElements();
        int contentWidth = this.content.getWidth();

        this.container.setWidth(contentWidth + this.container.scrollbarReserve());
        this.container.setHeight(Math.clamp(this.container.getHeight(), 0, this.maxHeight));
        this.container.refreshScrollAmount();
    }

    @Override
    public void visitChildren(Consumer<LayoutElement> visitor) {
        visitor.accept(this.container);
    }

    @Override
    public void visitWidgets(Consumer<AbstractWidget> visitor) {
        visitor.accept(this.container);
    }

    @Override
    public void setX(int x) {
        this.container.setX(x);
    }

    @Override
    public void setY(int y) {
        this.container.setY(y);
    }

    @Override
    public int getX() {
        return this.container.getX();
    }

    @Override
    public int getY() {
        return this.container.getY();
    }

    @Override
    public int getWidth() {
        return this.container.getWidth();
    }

    @Override
    public int getHeight() {
        return this.container.getHeight();
    }

    private class Container extends AbstractContainerWidget {
        private final List<AbstractWidget> children = new ArrayList<>();

        public Container(int width, int height) {
            super(0, 0, width, height, CommonComponents.EMPTY, AbstractScrollArea.defaultSettings(10));
            ScrollableLayout.this.content.visitWidgets(this.children::add);
        }

        @Override
        protected int contentHeight() {
            return ScrollableLayout.this.content.getHeight();
        }

        @Override
        protected void extractWidgetRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
            graphics.enableScissor(this.getX(), this.getY(), this.getX() + this.width, this.getY() + this.height);

            for (AbstractWidget child : this.children) {
                child.extractRenderState(graphics, mouseX, mouseY, partialTicks);
            }

            graphics.disableScissor();
        }

        @Override
        protected void updateWidgetNarration(NarrationElementOutput output) {
        }

        @Override
        public ScreenRectangle getBorderForArrowNavigation(ScreenDirection opposite) {
            GuiEventListener focused = this.getFocused();
            return focused != null
                ? focused.getBorderForArrowNavigation(opposite)
                : new ScreenRectangle(this.getX(), this.getY(), this.width, this.contentHeight()).getBorder(opposite);
        }

        @Override
        public void setFocused(@Nullable GuiEventListener focused) {
            super.setFocused(focused);
            if (focused != null && Minecraft.getInstance().getLastInputType().isKeyboard()) {
                ScreenRectangle area = this.getRectangle();
                ScreenRectangle focusedRect = focused.getRectangle();
                int topDelta = focusedRect.top() - area.top();
                int bottomDelta = focusedRect.bottom() - area.bottom();
                double scrollRate = this.scrollRate();
                if (topDelta < 0) {
                    this.setScrollAmount(this.scrollAmount() + topDelta - scrollRate);
                } else if (bottomDelta > 0) {
                    this.setScrollAmount(this.scrollAmount() + bottomDelta + scrollRate);
                }
            }
        }

        @Override
        public void setX(int x) {
            super.setX(x);
            ScrollableLayout.this.content.setX(x);
        }

        @Override
        public void setY(int y) {
            super.setY(y);
            ScrollableLayout.this.content.setY(y - (int) this.scrollAmount());
        }

        private int scrollbarReserve() {
            return DEFAULT_SCROLLBAR_SPACING + this.scrollbarWidth();
        }

        @Override
        public void setScrollAmount(double scrollAmount) {
            super.setScrollAmount(scrollAmount);
            ScrollableLayout.this.content.setY(this.getRectangle().top() - (int) this.scrollAmount());
        }

        @Override
        public List<? extends GuiEventListener> children() {
            return this.children;
        }

        @Override
        public Collection<? extends NarratableEntry> getNarratables() {
            return this.children;
        }
    }
}
