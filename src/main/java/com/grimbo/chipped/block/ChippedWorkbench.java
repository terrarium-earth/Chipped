package com.grimbo.chipped.block;

import com.grimbo.chipped.menus.ChippedMenu;
import com.grimbo.chipped.recipe.ChippedRecipe;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class ChippedWorkbench extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	protected static final VoxelShape WORKBENCH_NORTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_EAST_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_WEST_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape WORKBENCH_SOUTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public static final EnumProperty<WorkbenchModelType> MODEL_TYPE = EnumProperty.create("model", WorkbenchModelType.class);

    private final MenuType<ChippedMenu> menuType;
    private final RecipeType<ChippedRecipe> recipeType;
    private final LazyLoadedValue<Component> containerName;

	public ChippedWorkbench(MenuType<ChippedMenu> menuType, RecipeType<ChippedRecipe> recipeType, Properties properties) {
		super(properties);
        this.menuType = menuType;
        this.recipeType = recipeType;
		containerName = new LazyLoadedValue<>(() -> new TranslatableComponent("container.chipped." + Registry.BLOCK.getKey(ChippedWorkbench.this).getPath()));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(MODEL_TYPE, WorkbenchModelType.MAIN));
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		/*Direction direction = blockPlaceContext.getHorizontalDirection();
		BlockPos blockPos = blockPlaceContext.getClickedPos();
		BlockPos blockPos2 = blockPos.relative(direction);
		return blockPlaceContext.getLevel().getBlockState(blockPos2).canBeReplaced(blockPlaceContext) ? (BlockState)this.defaultBlockState().setValue(FACING, direction) : null;
		*/return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
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
                (id, inventory, player) -> new ChippedMenu(id, inventory, menuType, recipeType, ContainerLevelAccess.create(worldIn, pos), this),
                containerName.get()
        );
    }

	@Override
	public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player player) {
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
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		switch (blockState.getValue(FACING)) {
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
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, MODEL_TYPE);
	}

	@Deprecated
	public boolean canSurvive(BlockState state, Level worldIn, BlockPos pos) {
		BlockPos otherpos = pos.relative(state.getValue(FACING).getClockWise());
		return worldIn.getBlockState(otherpos).getMaterial().isReplaceable();
	}

	@Deprecated
	@Environment(EnvType.CLIENT)
	public float getShadeBrightness(BlockState state, Level worldIn, BlockPos pos) {
		return 1;
	}

	@FunctionalInterface
	public interface ContainerFactory {
        ChippedMenu create(int windowId, Inventory inventory, ContainerLevelAccess access);
    }

    public enum WorkbenchModelType implements StringRepresentable {
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
