package com.grimbo.chipped.block;

import javax.annotation.Nullable;


import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class ChippedWorkbench extends Block {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

	protected static final VoxelShape WORKBENCH_NORTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_EAST_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_WEST_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_SOUTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public static final EnumProperty<WorkbenchModelType> MODEL_TYPE = EnumProperty.create("model", WorkbenchModelType.class);

    private final ContainerFactory factory;
    private final LazyValue<ITextComponent> containerName;

	public ChippedWorkbench(ContainerFactory factory, Properties properties) {
		super(properties);
        this.factory = factory;
		containerName = new LazyValue<>(() -> new TranslationTextComponent("container.chipped." + ForgeRegistries.BLOCKS.getKey(ChippedWorkbench.this).getPath()));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(MODEL_TYPE, WorkbenchModelType.MAIN));
	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public @NotNull ActionResultType use(@NotNull BlockState state, World worldIn, @NotNull BlockPos pos, @NotNull PlayerEntity player, @NotNull Hand handIn, @NotNull BlockRayTraceResult hit) {
		if (worldIn.isClientSide) {
			return ActionResultType.SUCCESS;
		} else {
			player.openMenu(state.getMenuProvider(worldIn, pos));
			return ActionResultType.CONSUME;
		}
	}

	@Nullable
	@Override
	public INamedContainerProvider getMenuProvider(@NotNull BlockState state, @NotNull World worldIn, @NotNull BlockPos pos) {
        return new SimpleNamedContainerProvider(
                (id, inventory, player) -> factory.create(id, inventory, IWorldPosCallable.create(worldIn, pos)),
                containerName.get()
        );
    }

	@Override
	public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		if (!worldIn.isClientSide) {
			WorkbenchModelType workbenchModel = state.getValue(MODEL_TYPE);
			if (workbenchModel == WorkbenchModelType.MAIN) {
				BlockPos otherpos = pos.relative(state.getValue(FACING).getClockWise());
				BlockState otherstate = worldIn.getBlockState(otherpos);
				if (otherstate.getBlock() == this) {
					worldIn.setBlock(otherpos, Blocks.AIR.defaultBlockState(), 35);
					worldIn.levelEvent(player, 2001, otherpos, Block.getId(otherstate));
				}
			}
			if (workbenchModel == WorkbenchModelType.SIDE) {
				BlockPos otherpos = pos.relative(state.getValue(FACING).getCounterClockWise());
				BlockState otherstate = worldIn.getBlockState(otherpos);
				if (otherstate.getBlock() == this) {
					worldIn.setBlock(otherpos, Blocks.AIR.defaultBlockState(), 35);
					worldIn.levelEvent(player, 2001, otherpos, Block.getId(otherstate));
				}
			}
		}
		super.playerWillDestroy(worldIn, pos, state, player);
	}

	@Override
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		super.setPlacedBy(worldIn, pos, state, placer, stack);
		if (!worldIn.isClientSide) {
			BlockPos blockpos = pos.relative(state.getValue(FACING).getClockWise());
			worldIn.setBlock(blockpos, state.setValue(MODEL_TYPE, WorkbenchModelType.SIDE), 3);
			worldIn.blockUpdated(pos, Blocks.AIR);
			state.updateNeighbourShapes(worldIn, pos, 3);
		}
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.getValue(FACING)) {
		case NORTH:
			return WORKBENCH_NORTH_SHAPE;
		case SOUTH:
			return WORKBENCH_SOUTH_SHAPE;
		case WEST:
			return WORKBENCH_WEST_SHAPE;
		default:
			return WORKBENCH_EAST_SHAPE;
		}
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState state) {
		return true;
	}

	@Override
	public BlockRenderType getRenderShape(BlockState state) {
		return BlockRenderType.MODEL;
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, MODEL_TYPE);
	}

	@Deprecated
	@Override
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos otherpos = pos.relative(state.getValue(FACING).getClockWise());
		return worldIn.getBlockState(otherpos).getMaterial().isReplaceable();
	}

	@Deprecated
	@OnlyIn(Dist.CLIENT)
	@Override
	public float getShadeBrightness(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 1;
	}

	@FunctionalInterface
	public interface ContainerFactory {
        Container create(int windowId, PlayerInventory inventory, IWorldPosCallable position);
    }

    public enum WorkbenchModelType implements IStringSerializable {
        MAIN, SIDE;

        @Override
        public String getSerializedName() {
            return name().toLowerCase();
        }

        @Override
        public String toString() {
            return getSerializedName();
        }
    }
}
