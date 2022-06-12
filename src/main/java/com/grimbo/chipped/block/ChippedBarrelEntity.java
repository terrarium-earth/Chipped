package com.grimbo.chipped.block;

import net.minecraft.block.BarrelBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.jetbrains.annotations.NotNull;

public class ChippedBarrelEntity extends LockableLootTileEntity {
    private NonNullList<ItemStack> items = NonNullList.withSize(27, ItemStack.EMPTY);
    private int openCount;

    public ChippedBarrelEntity() {
        super(ChippedBlocks.CHIPPED_BARREL_ENTITY.get());
    }

    public @NotNull CompoundNBT save(@NotNull CompoundNBT nbt) {
        super.save(nbt);
        if (!this.trySaveLootTable(nbt)) {
            ItemStackHelper.saveAllItems(nbt, this.items);
        }

        return nbt;
    }

    @Override
    public void load(@NotNull BlockState state, @NotNull CompoundNBT nbt) {
        super.load(state, nbt);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(nbt)) {
            ItemStackHelper.loadAllItems(nbt, this.items);
        }

    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    protected @NotNull NonNullList<ItemStack> getItems() {
        return this.items;
    }

    protected void setItems(@NotNull NonNullList<ItemStack> items) {
        this.items = items;
    }

    protected @NotNull ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.barrel");
    }

    protected @NotNull Container createMenu(int id, @NotNull PlayerInventory inventory) {
        return ChestContainer.threeRows(id, inventory, this);
    }

    public void startOpen(PlayerEntity p_174889_1_) {
        if (!p_174889_1_.isSpectator()) {
            if (this.openCount < 0) {
                this.openCount = 0;
            }

            ++this.openCount;
            BlockState blockstate = this.getBlockState();
            boolean flag = blockstate.getValue(BarrelBlock.OPEN);
            if (!flag) {
                this.playSound(blockstate, SoundEvents.BARREL_OPEN);
                this.updateBlockState(blockstate, true);
            }

            this.scheduleRecheck();
        }

    }

    private void scheduleRecheck() {
        this.level.getBlockTicks().scheduleTick(this.getBlockPos(), this.getBlockState().getBlock(), 5);
    }

    public void recheckOpen() {
        int i = this.worldPosition.getX();
        int j = this.worldPosition.getY();
        int k = this.worldPosition.getZ();
        this.openCount = ChestTileEntity.getOpenCount(this.level, this, i, j, k);
        if (this.openCount > 0) {
            this.scheduleRecheck();
        } else {
            BlockState blockstate = this.getBlockState();
            if (!(blockstate.getBlock() instanceof ChippedBarrel)) {
                this.setRemoved();
                return;
            }

            boolean flag = blockstate.getValue(BarrelBlock.OPEN);
            if (flag) {
                this.playSound(blockstate, SoundEvents.BARREL_CLOSE);
                this.updateBlockState(blockstate, false);
            }
        }

    }

    public void stopOpen(PlayerEntity p_174886_1_) {
        if (!p_174886_1_.isSpectator()) {
            --this.openCount;
        }

    }

    private void updateBlockState(BlockState p_213963_1_, boolean p_213963_2_) {
        this.level.setBlock(this.getBlockPos(), p_213963_1_.setValue(BarrelBlock.OPEN, p_213963_2_), 3);
    }

    private void playSound(BlockState state, SoundEvent soundEvent) {
        Vector3i vector3i = state.getValue(BarrelBlock.FACING).getNormal();
        double d0 = (double)this.worldPosition.getX() + 0.5D + (double)vector3i.getX() / 2.0D;
        double d1 = (double)this.worldPosition.getY() + 0.5D + (double)vector3i.getY() / 2.0D;
        double d2 = (double)this.worldPosition.getZ() + 0.5D + (double)vector3i.getZ() / 2.0D;
        this.level.playSound(null, d0, d1, d2, soundEvent, SoundCategory.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
    }
}
