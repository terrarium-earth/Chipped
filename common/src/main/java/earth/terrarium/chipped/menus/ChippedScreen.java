package earth.terrarium.chipped.menus;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

//Pulled from net.minecraft.client.gui.screen.inventory.StonecutterScreen
public class ChippedScreen extends AbstractContainerScreen<ChippedMenu> {
    private static final ResourceLocation BG_LOCATION = new ResourceLocation("textures/gui/container/stonecutter.png");
    private float scrollOffs;
    private boolean scrolling;
    private int startIndex;
    private boolean displayRecipes;

    public ChippedScreen(ChippedMenu container, Inventory inventory, Component title) {
        super(container, inventory, title);
        container.registerUpdateListener(this::containerChanged);
        --this.titleLabelY;
    }

    @Override
    public void render(@NotNull PoseStack matrix, int mouseX, int mouseY, float partialTicks) {
        super.render(matrix, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrix, mouseX, mouseY);
    }

    @Override
    protected void renderBg(PoseStack poseStack, float mouseX, int mouseY, int partialTick) {
        this.renderBackground(poseStack);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, BG_LOCATION);
        int i = this.leftPos;
        int j = this.topPos;
        this.blit(poseStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
        int k = (int) (41.0F * this.scrollOffs);
        this.blit(poseStack, i + 119, j + 15 + k, 176 + (this.isScrollBarActive() ? 0 : 12), 0, 12, 15);
        int l = this.leftPos + 52;
        int i1 = this.topPos + 14;
        int j1 = this.startIndex + 12;
        this.renderButtons(poseStack, mouseY, partialTick, l, i1, j1);
        this.renderRecipes(l, i1, j1);
    }

    @Override
    protected void renderTooltip(@NotNull PoseStack matrix, int mouseX, int mouseY) {
        super.renderTooltip(matrix, mouseX, mouseY);
        if (this.displayRecipes) {
            int i = this.leftPos + 52;
            int j = this.topPos + 14;
            int k = this.startIndex + 12;
            List<ItemStack> list = this.menu.getResults();

            for (int l = this.startIndex; l < k && l < list.size(); ++l) {
                int i1 = l - this.startIndex;
                int j1 = i + i1 % 4 * 16;
                int k1 = j + i1 / 4 * 18 + 2;
                if (mouseX >= j1 && mouseX < j1 + 16 && mouseY >= k1 && mouseY < k1 + 18) {
                    this.renderTooltip(matrix, list.get(l), mouseX, mouseY);
                }
            }
        }

    }

    private void renderButtons(PoseStack matrix, int mouseX, int mouseY, int p_238853_4_, int p_238853_5_, int p_238853_6_) {
        for (int i = this.startIndex; i < p_238853_6_ && i < this.menu.getResults().size(); ++i) {
            int j = i - this.startIndex;
            int k = p_238853_4_ + j % 4 * 16;
            int l = j / 4;
            int i1 = p_238853_5_ + l * 18 + 2;
            int j1 = this.imageHeight;
            if (i == this.menu.getSelectedIndex()) {
                j1 += 18;
            } else if (mouseX >= k && mouseY >= i1 && mouseX < k + 16 && mouseY < i1 + 18) {
                j1 += 36;
            }

            this.blit(matrix, k, i1 - 1, 0, j1, 16, 18);
        }

    }

    private void renderRecipes(int p_214142_1_, int p_214142_2_, int p_214142_3_) {
        List<ItemStack> list = this.menu.getResults();

        for (int i = this.startIndex; i < p_214142_3_ && i < list.size(); ++i) {
            int j = i - this.startIndex;
            int k = p_214142_1_ + j % 4 * 16;
            int l = j / 4;
            int i1 = p_214142_2_ + l * 18 + 2;
            this.minecraft.getItemRenderer().renderAndDecorateItem(list.get(i), k, i1);
        }

    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        this.scrolling = false;
        if (this.displayRecipes) {
            int i = this.leftPos + 52;
            int j = this.topPos + 14;
            int k = this.startIndex + 12;

            for (int l = this.startIndex; l < k; ++l) {
                int i1 = l - this.startIndex;
                double d0 = mouseX - (double) (i + i1 % 4 * 16);
                double d1 = mouseY - (double) (j + i1 / 4 * 18);
                if (d0 >= 0.0D && d1 >= 0.0D && d0 < 16.0D && d1 < 18.0D
                        && this.menu.clickMenuButton(this.minecraft.player, l)) {
                    Minecraft.getInstance().getSoundManager()
                            .play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
                    this.minecraft.gameMode.handleInventoryButtonClick((this.menu).containerId, l);
                    return true;
                }
            }

            i = this.leftPos + 119;
            j = this.topPos + 9;
            if (mouseX >= (double) i && mouseX < (double) (i + 12) && mouseY >= (double) j
                    && mouseY < (double) (j + 54)) {
                this.scrolling = true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (this.scrolling && this.isScrollBarActive()) {
            int i = this.topPos + 14;
            int j = i + 54;
            this.scrollOffs = ((float) mouseY - (float) i - 7.5F) / ((float) (j - i) - 15.0F);
            this.scrollOffs = Mth.clamp(this.scrollOffs, 0.0F, 1.0F);
            this.startIndex = (int) ((double) (this.scrollOffs * (float) this.getOffscreenRows()) + 0.5D) * 4;
            return true;
        } else {
            return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollAmount) {
        if (this.isScrollBarActive()) {
            int i = this.getOffscreenRows();
            this.scrollOffs = (float) ((double) this.scrollOffs - scrollAmount / (double) i);
            this.scrollOffs = Mth.clamp(this.scrollOffs, 0.0F, 1.0F);
            this.startIndex = (int) ((double) (this.scrollOffs * (float) i) + 0.5D) * 4;
        }

        return true;
    }

    private boolean isScrollBarActive() {
        return this.displayRecipes && this.menu.getResults().size() > 12;
    }

    protected int getOffscreenRows() {
        return (this.menu.getResults().size() + 4 - 1) / 4 - 3;
    }

    private void containerChanged() {
        this.displayRecipes = this.menu.hasInputItem();
        if (!this.displayRecipes) {
            this.scrollOffs = 0.0F;
            this.startIndex = 0;
        }

    }
}