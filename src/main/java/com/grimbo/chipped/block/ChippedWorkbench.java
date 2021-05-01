package com.grimbo.chipped.block;

import javax.annotation.Nullable;

import com.grimbo.chipped.container.AlchemyBenchContainer;
import com.grimbo.chipped.container.BotanistWorkbenchContainer;
import com.grimbo.chipped.container.CarpentersTableContainer;
import com.grimbo.chipped.container.GlassblowerContainer;
import com.grimbo.chipped.container.LoomTableContainer;
import com.grimbo.chipped.container.MasonTableContainer;

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
	
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	protected static final VoxelShape WORKBENCH_NORTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_EAST_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_WEST_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_SOUTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public enum WorkbenchModelType implements IStringSerializable {
    	MAIN,
        SIDE;

        @Override
        public String getString() {
            return name().toLowerCase();
        }
        
        @Override
        public String toString() {
        	return getString();
        }
    }

    public static final EnumProperty<WorkbenchModelType> MODEL_TYPE = EnumProperty.create("model", WorkbenchModelType.class);
    
	public ChippedWorkbench(int containerId, String itemId, Properties properties) {
		super(properties);
		CONTAINER_ID = containerId;
		ITEM_ID = itemId;
		CONTAINER_NAME = new TranslationTextComponent("container.chipped." + itemId);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(MODEL_TYPE, WorkbenchModelType.MAIN));
	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if (worldIn.isRemote) {
			return ActionResultType.SUCCESS;
		} else {
			player.openContainer(state.getContainer(worldIn, pos));
			return ActionResultType.CONSUME;
		}
	}
	
	@Nullable
	@Override
	public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
		return new SimpleNamedContainerProvider((id, inventory, player) -> {
			//Add new ids for each workbench container here
			switch(CONTAINER_ID) {
				case 0:
					return new BotanistWorkbenchContainer(id, inventory, IWorldPosCallable.of(worldIn, pos));
				case 1:
					return new GlassblowerContainer(id, inventory, IWorldPosCallable.of(worldIn, pos));
				case 2:
					return new CarpentersTableContainer(id, inventory, IWorldPosCallable.of(worldIn, pos));
				case 3:
					return new LoomTableContainer(id, inventory, IWorldPosCallable.of(worldIn, pos));
				case 4:
					return new MasonTableContainer(id, inventory, IWorldPosCallable.of(worldIn, pos));
				case 5:
					return new AlchemyBenchContainer(id, inventory, IWorldPosCallable.of(worldIn,pos));
			}
			return null;
		}, CONTAINER_NAME);
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		if (!worldIn.isRemote) {
			WorkbenchModelType workbenchModel = state.get(MODEL_TYPE);
			if (workbenchModel == WorkbenchModelType.MAIN) {
				BlockPos otherpos = pos.offset(state.get(FACING).rotateY());
				BlockState otherstate = worldIn.getBlockState(otherpos);
				if (otherstate.getBlock() == this) {
					worldIn.setBlockState(otherpos, Blocks.AIR.getDefaultState(), 35);
					worldIn.playEvent(player, 2001, otherpos, Block.getStateId(otherstate));
				}
			}
			if (workbenchModel == WorkbenchModelType.SIDE) {
				BlockPos otherpos = pos.offset(state.get(FACING).rotateYCCW());
				BlockState otherstate = worldIn.getBlockState(otherpos);
				if (otherstate.getBlock() == this) {
					worldIn.setBlockState(otherpos, Blocks.AIR.getDefaultState(), 35);
					worldIn.playEvent(player, 2001, otherpos, Block.getStateId(otherstate));
				}
			}
		}
		super.onBlockHarvested(worldIn, pos, state, player);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		if (!worldIn.isRemote) {
			BlockPos blockpos = pos.offset(state.get(FACING).rotateY());
			worldIn.setBlockState(blockpos, state.with(MODEL_TYPE, WorkbenchModelType.SIDE), 3);
			worldIn.func_230547_a_(pos, Blocks.AIR);
			state.updateNeighbours(worldIn, pos, 3);
		}
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(FACING);
		switch(direction) {
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
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(FACING);
		switch(direction) {
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
	public boolean isTransparent(BlockState state) {
		return true;
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, MODEL_TYPE);
	}

	//Can only be placed if air is adjacent, this could be fixed by using tile entities and .is
	@Deprecated
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos otherpos = pos.offset(state.get(FACING).rotateY());
		if (!worldIn.getBlockState(otherpos).isAir()) {
			return false;
		}
		return true;
	}
	
	@Deprecated
	@OnlyIn(Dist.CLIENT)
	public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 1;
	}
}