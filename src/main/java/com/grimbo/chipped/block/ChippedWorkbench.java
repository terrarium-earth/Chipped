package com.grimbo.chipped.block;

import javax.annotation.Nullable;

import com.grimbo.chipped.container.*;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.LoomContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
public class ChippedWorkbench extends Block {

	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private ITextComponent CONTAINER_NAME;
	private int containerId;

	public ChippedWorkbench(int id, String containerName, Properties properties) {
		super(properties);
		containerId = id;
		CONTAINER_NAME = new TranslationTextComponent(containerName);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
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
	public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
		return new SimpleNamedContainerProvider((id, inventory, player) -> {
			//Add new ids for each workbench container here
			switch(containerId) {
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

			}
			return null;
		}, CONTAINER_NAME);
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
		builder.add(FACING);
	}
}