package com.grimbo.chipped.block;

import java.util.Optional;

import javax.annotation.Nullable;

import org.apache.commons.lang3.ArrayUtils;

import com.grimbo.chipped.container.*;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BedPart;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntityMerger;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.Rotation;
import net.minecraft.util.TransportationHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.ICollisionReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
public class ChippedWorkbench extends Block {

	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final EnumProperty<BedPart> PART = BlockStateProperties.BED_PART;
	private ITextComponent CONTAINER_NAME;
	private int containerId;
	protected static final VoxelShape WORKBENCH_NORTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_EAST_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_WEST_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_SOUTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public ChippedWorkbench(int id, String containerName, Properties properties) {
		super(properties);
		containerId = id;
		CONTAINER_NAME = new TranslationTextComponent(containerName);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(PART, BedPart.FOOT));
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

	@OnlyIn(Dist.CLIENT)
	public static TileEntityMerger.Type getMergeType(BlockState state) {
		BedPart bedpart = state.get(PART);
		return bedpart == BedPart.HEAD ? TileEntityMerger.Type.FIRST : TileEntityMerger.Type.SECOND;
	}


	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		if (!worldIn.isRemote) {
			BedPart bedpart = state.get(PART);
			if (bedpart == BedPart.FOOT) {
				if (state == this.getDefaultState().with(FACING, Direction.NORTH)) {
					BlockPos blockpos = pos.add(1, 0, 0);
					BlockState blockstate = worldIn.getBlockState(blockpos);
					if (blockstate.getBlock() == this && blockstate.get(PART) == BedPart.HEAD) {
						worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
						worldIn.playEvent(player, 2001, blockpos, Block.getStateId(blockstate));
					}
				} else if(state == this.getDefaultState().with(FACING, Direction.SOUTH))  {
					BlockPos blockpos = pos.add(-1, 0, 0);
					BlockState blockstate = worldIn.getBlockState(blockpos);
					if (blockstate.getBlock() == this && blockstate.get(PART) == BedPart.HEAD) {
						worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
						worldIn.playEvent(player, 2001, blockpos, Block.getStateId(blockstate));
					}
				} else if(state == this.getDefaultState().with(FACING, Direction.EAST))  {
					BlockPos blockpos = pos.add(0, 0, 1);
					BlockState blockstate = worldIn.getBlockState(blockpos);
					if (blockstate.getBlock() == this && blockstate.get(PART) == BedPart.HEAD) {
						worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
						worldIn.playEvent(player, 2001, blockpos, Block.getStateId(blockstate));
					}
				} else if(state == this.getDefaultState().with(FACING, Direction.WEST))  {
					BlockPos blockpos = pos.add(0, 0, -1);
					BlockState blockstate = worldIn.getBlockState(blockpos);
					if (blockstate.getBlock() == this && blockstate.get(PART) == BedPart.HEAD) {
						worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
						worldIn.playEvent(player, 2001, blockpos, Block.getStateId(blockstate));
					}
				}
			}
		}
		super.onBlockHarvested(worldIn, pos, state, player);
	}


	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		if (!worldIn.isRemote) {
			if(state == this.getDefaultState().with(FACING, Direction.NORTH)) {
				BlockPos blockpos = pos.add(1, 0, 0);
				worldIn.setBlockState(blockpos, state.with(PART, BedPart.HEAD), 3);
				worldIn.func_230547_a_(pos, Blocks.AIR);
				state.updateNeighbours(worldIn, pos, 3);
			} else if(state == this.getDefaultState().with(FACING, Direction.SOUTH))  {
				BlockPos blockpos = pos.add(-1, 0, 0);
				worldIn.setBlockState(blockpos, state.with(PART, BedPart.HEAD), 3);
				worldIn.func_230547_a_(pos, Blocks.AIR);
				state.updateNeighbours(worldIn, pos, 3);
			} else if(state == this.getDefaultState().with(FACING, Direction.EAST))  {
				BlockPos blockpos = pos.add(0, 0, 1);
				worldIn.setBlockState(blockpos, state.with(PART, BedPart.HEAD), 3);
				worldIn.func_230547_a_(pos, Blocks.AIR);
				state.updateNeighbours(worldIn, pos, 3);
			} else if(state == this.getDefaultState().with(FACING, Direction.WEST))  {
				BlockPos blockpos = pos.add(0, 0, -1);
				worldIn.setBlockState(blockpos, state.with(PART, BedPart.HEAD), 3);
				worldIn.func_230547_a_(pos, Blocks.AIR);
				state.updateNeighbours(worldIn, pos, 3);
			}
		}

	}


	@Nullable
	public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
		return new SimpleNamedContainerProvider((id, inventory, player) -> {
			//Add new ids for each workbench container here
			switch(containerId) {
<<<<<<< HEAD
=======
<<<<<<< HEAD
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
=======
>>>>>>> CookieCNetwork-main
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

<<<<<<< HEAD
=======
>>>>>>> f8148344ea775996d9129482903ed9e83a1aecd2
>>>>>>> CookieCNetwork-main
			}
			return null;
		}, CONTAINER_NAME);
	}

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

	public boolean isTransparent(BlockState state) {
		return true;
	}

	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, PART);
	}

	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		if(state == this.getDefaultState().with(FACING, Direction.NORTH)) {
			BlockPos blockpos = pos.add(1, 0, 0);
			if(worldIn.getBlockState(blockpos).isSolid()) {
				return false;
			}
		} else if(state == this.getDefaultState().with(FACING, Direction.SOUTH))  {
			BlockPos blockpos = pos.add(-1, 0, 0);
			if(worldIn.getBlockState(blockpos).isSolid()) {
				return false;
			}
		} else if(state == this.getDefaultState().with(FACING, Direction.EAST))  {
			BlockPos blockpos = pos.add(0, 0, 1);
			if(worldIn.getBlockState(blockpos).isSolid()) {
				return false;
			}
		} else if(state == this.getDefaultState().with(FACING, Direction.WEST))  {
			BlockPos blockpos = pos.add(0, 0, -1);
			if(worldIn.getBlockState(blockpos).isSolid()) {
				return false;
			}
		}
		return true;
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> CookieCNetwork-main
