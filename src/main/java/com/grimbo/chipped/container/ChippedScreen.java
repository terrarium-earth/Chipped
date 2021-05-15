package com.grimbo.chipped.container;

import java.util.List;

import com.grimbo.chipped.recipe.ChippedRecipe;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;

//Pulled from net.minecraft.client.gui.screen.inventory.StonecutterScreen
public class ChippedScreen extends ContainerScreen<ChippedContainer> {
	private static final ResourceLocation BG_LOCATION = new ResourceLocation("textures/gui/container/stonecutter.png");
	private float scrollOffs;
	private boolean scrolling;
	private int startIndex;
	private boolean displayRecipes;

	public ChippedScreen(ChippedContainer p_i51076_1_, PlayerInventory p_i51076_2_, ITextComponent p_i51076_3_) {
		super(p_i51076_1_, p_i51076_2_, p_i51076_3_);
		p_i51076_1_.registerUpdateListener(this::containerChanged);
		--this.titleLabelY;
	}

	public void render(MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
		super.render(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
		this.renderTooltip(p_230430_1_, p_230430_2_, p_230430_3_);
	}

	protected void renderBg(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
		this.renderBackground(p_230450_1_);
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bind(BG_LOCATION);
		int i = this.leftPos;
		int j = this.topPos;
		this.blit(p_230450_1_, i, j, 0, 0, this.imageWidth, this.imageHeight);
		int k = (int) (41.0F * this.scrollOffs);
		this.blit(p_230450_1_, i + 119, j + 15 + k, 176 + (this.isScrollBarActive() ? 0 : 12), 0, 12, 15);
		int l = this.leftPos + 52;
		int i1 = this.topPos + 14;
		int j1 = this.startIndex + 12;
		this.renderButtons(p_230450_1_, p_230450_3_, p_230450_4_, l, i1, j1);
		this.renderRecipes(l, i1, j1);
	}

	protected void renderTooltip(MatrixStack p_230459_1_, int p_230459_2_, int p_230459_3_) {
		super.renderTooltip(p_230459_1_, p_230459_2_, p_230459_3_);
		if (this.displayRecipes) {
			int i = this.leftPos + 52;
			int j = this.topPos + 14;
			int k = this.startIndex + 12;
			List<ChippedRecipe> list = this.menu.getRecipes();

			for (int l = this.startIndex; l < k && l < this.menu.getNumRecipes(); ++l) {
				int i1 = l - this.startIndex;
				int j1 = i + i1 % 4 * 16;
				int k1 = j + i1 / 4 * 18 + 2;
				if (p_230459_2_ >= j1 && p_230459_2_ < j1 + 16 && p_230459_3_ >= k1 && p_230459_3_ < k1 + 18) {
					this.renderTooltip(p_230459_1_, list.get(l).getResultItem(), p_230459_2_, p_230459_3_);
				}
			}
		}

	}

	private void renderButtons(MatrixStack p_238853_1_, int p_238853_2_, int p_238853_3_, int p_238853_4_,
			int p_238853_5_, int p_238853_6_) {
		for (int i = this.startIndex; i < p_238853_6_ && i < this.menu.getNumRecipes(); ++i) {
			int j = i - this.startIndex;
			int k = p_238853_4_ + j % 4 * 16;
			int l = j / 4;
			int i1 = p_238853_5_ + l * 18 + 2;
			int j1 = this.imageHeight;
			if (i == this.menu.getSelectedRecipeIndex()) {
				j1 += 18;
			} else if (p_238853_2_ >= k && p_238853_3_ >= i1 && p_238853_2_ < k + 16 && p_238853_3_ < i1 + 18) {
				j1 += 36;
			}

			this.blit(p_238853_1_, k, i1 - 1, 0, j1, 16, 18);
		}

	}

	private void renderRecipes(int p_214142_1_, int p_214142_2_, int p_214142_3_) {
		List<ChippedRecipe> list = this.menu.getRecipes();

		for (int i = this.startIndex; i < p_214142_3_ && i < this.menu.getNumRecipes(); ++i) {
			int j = i - this.startIndex;
			int k = p_214142_1_ + j % 4 * 16;
			int l = j / 4;
			int i1 = p_214142_2_ + l * 18 + 2;
			this.minecraft.getItemRenderer().renderAndDecorateItem(list.get(i).getResultItem(), k, i1);
		}

	}

	public boolean mouseClicked(double p_231044_1_, double p_231044_3_, int p_231044_5_) {
		this.scrolling = false;
		if (this.displayRecipes) {
			int i = this.leftPos + 52;
			int j = this.topPos + 14;
			int k = this.startIndex + 12;

			for (int l = this.startIndex; l < k; ++l) {
				int i1 = l - this.startIndex;
				double d0 = p_231044_1_ - (double) (i + i1 % 4 * 16);
				double d1 = p_231044_3_ - (double) (j + i1 / 4 * 18);
				if (d0 >= 0.0D && d1 >= 0.0D && d0 < 16.0D && d1 < 18.0D
						&& this.menu.clickMenuButton(this.minecraft.player, l)) {
					Minecraft.getInstance().getSoundManager()
							.play(SimpleSound.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
					this.minecraft.gameMode.handleInventoryButtonClick((this.menu).containerId, l);
					return true;
				}
			}

			i = this.leftPos + 119;
			j = this.topPos + 9;
			if (p_231044_1_ >= (double) i && p_231044_1_ < (double) (i + 12) && p_231044_3_ >= (double) j
					&& p_231044_3_ < (double) (j + 54)) {
				this.scrolling = true;
			}
		}

		return super.mouseClicked(p_231044_1_, p_231044_3_, p_231044_5_);
	}

	public boolean mouseDragged(double p_231045_1_, double p_231045_3_, int p_231045_5_, double p_231045_6_,
			double p_231045_8_) {
		if (this.scrolling && this.isScrollBarActive()) {
			int i = this.topPos + 14;
			int j = i + 54;
			this.scrollOffs = ((float) p_231045_3_ - (float) i - 7.5F) / ((float) (j - i) - 15.0F);
			this.scrollOffs = MathHelper.clamp(this.scrollOffs, 0.0F, 1.0F);
			this.startIndex = (int) ((double) (this.scrollOffs * (float) this.getOffscreenRows()) + 0.5D) * 4;
			return true;
		} else {
			return super.mouseDragged(p_231045_1_, p_231045_3_, p_231045_5_, p_231045_6_, p_231045_8_);
		}
	}

	public boolean mouseScrolled(double p_231043_1_, double p_231043_3_, double p_231043_5_) {
		if (this.isScrollBarActive()) {
			int i = this.getOffscreenRows();
			this.scrollOffs = (float) ((double) this.scrollOffs - p_231043_5_ / (double) i);
			this.scrollOffs = MathHelper.clamp(this.scrollOffs, 0.0F, 1.0F);
			this.startIndex = (int) ((double) (this.scrollOffs * (float) i) + 0.5D) * 4;
		}

		return true;
	}

	private boolean isScrollBarActive() {
		return this.displayRecipes && this.menu.getNumRecipes() > 12;
	}

	protected int getOffscreenRows() {
		return (this.menu.getNumRecipes() + 4 - 1) / 4 - 3;
	}

	private void containerChanged() {
		this.displayRecipes = this.menu.hasInputItem();
		if (!this.displayRecipes) {
			this.scrollOffs = 0.0F;
			this.startIndex = 0;
		}

	}
}