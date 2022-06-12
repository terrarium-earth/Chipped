package com.grimbo.chipped.block;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Random;

public class ChippedBarrel extends ContainerBlock {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    public ChippedBarrel(AbstractBlock.Properties p_i49996_1_) {
        super(p_i49996_1_);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(OPEN, Boolean.FALSE));
    }

    @Override
    public @NotNull ActionResultType use(@NotNull BlockState state, World world, @NotNull BlockPos pos, @NotNull PlayerEntity player, @NotNull Hand hand, @NotNull BlockRayTraceResult result) {
        if (world.isClientSide) {
            return ActionResultType.SUCCESS;
        }
        TileEntity tileentity = world.getBlockEntity(pos);
        if (tileentity instanceof ChippedBarrelEntity) {
            player.openMenu((ChippedBarrelEntity)tileentity);
            player.awardStat(Stats.OPEN_BARREL);
            PiglinTasks.angerNearbyPiglins(player, true);
        }

        return ActionResultType.CONSUME;
    }

    @Override
    public void onRemove(BlockState state, @NotNull World world, @NotNull BlockPos p_196243_3_, BlockState newState, boolean moved) {
        if (!state.is(newState.getBlock())) {
            TileEntity tileentity = world.getBlockEntity(p_196243_3_);
            if (tileentity instanceof IInventory) {
                InventoryHelper.dropContents(world, p_196243_3_, (IInventory)tileentity);
                world.updateNeighbourForOutputSignal(p_196243_3_, this);
            }

            super.onRemove(state, world, p_196243_3_, newState, moved);
        }
    }

    @Override
    public void tick(@NotNull BlockState state, ServerWorld p_225534_2_, @NotNull BlockPos pos, @NotNull Random random) {
        TileEntity tileentity = p_225534_2_.getBlockEntity(pos);
        if (tileentity instanceof ChippedBarrelEntity) {
            ((ChippedBarrelEntity)tileentity).recheckOpen();
        }
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(@NotNull IBlockReader world) {
        return new ChippedBarrelEntity();
    }

    @Override
    public @NotNull BlockRenderType getRenderShape(@NotNull BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void setPlacedBy(@NotNull World world, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable LivingEntity livingEntity, ItemStack stack) {
        if (stack.hasCustomHoverName()) {
            TileEntity tileentity = world.getBlockEntity(pos);
            if (tileentity instanceof ChippedBarrelEntity) {
                ((ChippedBarrelEntity)tileentity).setCustomName(stack.getHoverName());
            }
        }

    }

    @Override
    public boolean hasAnalogOutputSignal(@NotNull BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(@NotNull BlockState state, World p_180641_2_, @NotNull BlockPos pos) {
        return Container.getRedstoneSignalFromBlockEntity(p_180641_2_.getBlockEntity(pos));
    }

    @Override
    public @NotNull BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public @NotNull BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());
    }
}
