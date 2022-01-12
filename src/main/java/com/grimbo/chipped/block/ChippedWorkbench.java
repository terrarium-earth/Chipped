package com.grimbo.chipped.block;

import com.google.common.base.Suppliers;
import com.grimbo.chipped.menus.ChippedMenu;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ChippedWorkbench extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	protected static final VoxelShape WORKBENCH_NORTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_EAST_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_WEST_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_SOUTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public static final EnumProperty<WorkbenchModelType> MODEL_TYPE = EnumProperty.create("model", WorkbenchModelType.class);

	private final ContainerFactory factory;
	private final Supplier<Component> containerName;

	public ChippedWorkbench(ContainerFactory factory, Properties properties) {
		super(properties);
		this.factory = factory;
		this.containerName = Suppliers.memoize(() -> new TranslatableComponent("container.chipped." + Registry.BLOCK.getKey(ChippedWorkbench.this).getPath()));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(MODEL_TYPE, WorkbenchModelType.MAIN));
	}

	@Override
	public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public InteractionResult use(BlockState state, @NotNull Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
		if (worldIn.isClientSide) {
			return InteractionResult.SUCCESS;
		} else {
			player.openMenu(state.getMenuProvider(worldIn, pos));
			return InteractionResult.CONSUME;
		}
	}

	@Nullable
	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		return new SimpleMenuProvider(
				(id, inventory, player) -> this.factory.create(id, inventory, ContainerLevelAccess.create(worldIn, pos)),
				this.containerName.get()
		);
	}

	@Override
	public void playerWillDestroy(@NotNull Level worldIn, BlockPos pos, BlockState state, Player player) {
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
	public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		super.setPlacedBy(worldIn, pos, state, placer, stack);
		if (!worldIn.isClientSide) {
			BlockPos blockpos = pos.relative(state.getValue(FACING).getClockWise());
			worldIn.setBlock(blockpos, state.setValue(MODEL_TYPE, WorkbenchModelType.SIDE), 3);
			worldIn.blockUpdated(pos, Blocks.AIR);
			state.updateNeighbourShapes(worldIn, pos, 3);
		}
	}

	@Override
	public VoxelShape getShape(@NotNull BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return switch (blockState.getValue(FACING)) {
			case NORTH -> WORKBENCH_NORTH_SHAPE;
			case SOUTH -> WORKBENCH_SOUTH_SHAPE;
			case WEST -> WORKBENCH_WEST_SHAPE;
			default -> WORKBENCH_EAST_SHAPE;
		};
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState state) {
		return true;
	}

	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}

	@Override
	public BlockState rotate(@NotNull BlockState state, @NotNull Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
		builder.add(FACING, MODEL_TYPE);
	}

	@Override
	public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader levelReader, @NotNull BlockPos pos) {
		BlockPos otherpos = pos.relative(state.getValue(FACING).getClockWise());
		return levelReader.getBlockState(otherpos).getMaterial().isReplaceable();
	}

	@Override
	@Environment(EnvType.CLIENT)
	public float getShadeBrightness(BlockState state, BlockGetter blockGetter, BlockPos pos) {
		return 1;
	}

	@FunctionalInterface
	public interface ContainerFactory {
		ChippedMenu create(int windowId, Inventory inventory, ContainerLevelAccess access);
	}

	public enum WorkbenchModelType implements StringRepresentable {
		MAIN, SIDE;

		@Override
		public @NotNull String getSerializedName() {
			return name().toLowerCase();
		}

		@Override
		public @NotNull String toString() {
			return getSerializedName();
		}
	}
}
