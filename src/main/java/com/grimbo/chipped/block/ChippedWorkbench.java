package com.grimbo.chipped.block;

import javax.annotation.Nullable;

import com.grimbo.chipped.container.*;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.Rotation;
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

public class ChippedWorkbench extends Block {

	private final int CONTAINER_ID;
	public final String ITEM_ID;
	private final ITextComponent CONTAINER_NAME;

	public static final DirectionProperty FACING = HorizontalBlock.FACING;

	protected static final VoxelShape WORKBENCH_NORTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_EAST_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_WEST_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_SOUTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

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

	public static final EnumProperty<WorkbenchModelType> MODEL_TYPE = EnumProperty.create("model",
			WorkbenchModelType.class);

	public ChippedWorkbench(int containerId, String itemId, Properties properties) {
		super(properties);
		CONTAINER_ID = containerId;
		ITEM_ID = itemId;
		CONTAINER_NAME = new TranslationTextComponent("container.chipped." + itemId);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(MODEL_TYPE,
				WorkbenchModelType.MAIN));
	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult hit) {
		if (worldIn.isClientSide) {
			return ActionResultType.SUCCESS;
		} else {
			player.openMenu(state.getMenuProvider(worldIn, pos));
			return ActionResultType.CONSUME;
		}
	}

	@Nullable
	@Override
	public INamedContainerProvider getMenuProvider(BlockState state, World worldIn, BlockPos pos) {
		return new SimpleNamedContainerProvider((id, inventory, player) -> {
			// Add new ids for each workbench container here
			switch (CONTAINER_ID) {
			case 0:
				return new BotanistWorkbenchContainer(id, inventory, IWorldPosCallable.create(worldIn, pos));
			case 1:
				return new GlassblowerContainer(id, inventory, IWorldPosCallable.create(worldIn, pos));
			case 2:
				return new CarpentersTableContainer(id, inventory, IWorldPosCallable.create(worldIn, pos));
			case 3:
				return new LoomTableContainer(id, inventory, IWorldPosCallable.create(worldIn, pos));
			case 4:
				return new MasonTableContainer(id, inventory, IWorldPosCallable.create(worldIn, pos));
			case 5:
				return new AlchemyBenchContainer(id, inventory, IWorldPosCallable.create(worldIn, pos));
			case 6:
				return new MechanistWorkbenchContainer(id, inventory, IWorldPosCallable.create(worldIn, pos));
			}
			return null;
		}, CONTAINER_NAME);
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
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer,
			ItemStack stack) {
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
		Direction direction = state.getValue(FACING);
		switch (direction) {
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
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos,
			ISelectionContext context) {
		Direction direction = state.getValue(FACING);
		switch (direction) {
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
}