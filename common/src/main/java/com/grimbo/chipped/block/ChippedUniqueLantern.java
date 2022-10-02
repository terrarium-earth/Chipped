package com.grimbo.chipped.block;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ChippedUniqueLantern extends Block implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private final VoxelShape toEast;
    private final VoxelShape toNorth;

    public static final VoxelShape CHONK_LANTERN_SHAPE = Shapes.or(Block.box(2.0D, 0.0D, 2.0D, 14.0D, 1.0D, 14.0D), Block.box(1, 1, 1, 15, 15, 15));
    public static final VoxelShape THICC_LANTERN_SHAPE = Shapes.or(Block.box(2.0D, 0.0D, 2.0D, 14.0D, 1.0D, 14.0D), Block.box(1, 1, 1, 15, 15, 15));
    public static final VoxelShape DONUT_LANTERN_SHAPE_EAST = Block.box(5.0D, 0.0D, 1.0D, 11.0D, 15.0D, 15.0D);
    public static final VoxelShape DONUT_LANTERN_SHAPE_NORTH = Block.box(1.0D, 0.0D, 5.0D, 15.0D, 15.0D, 11.0D);
    public static final VoxelShape TALL_LANTERN_SHAPE = Block.box(5, 0, 5, 11, 15, 11);

    public ChippedUniqueLantern(Properties properties, VoxelShape shape) {
        super(properties);
        this.toEast = shape;
        this.toNorth = shape;
    }

    public ChippedUniqueLantern(Properties properties, VoxelShape toEast, VoxelShape toNorth) {
        super(properties);
        this.toEast = toEast;
        this.toNorth = toNorth;
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return getShape(blockState);
    }

    public VoxelShape getShape(BlockState state) {
        Direction direction = state.getValue(FACING);
        if (direction == Direction.EAST || direction == Direction.WEST) {
            return this.toEast;
        } else {
            return this.toNorth;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = this.defaultBlockState();
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Direction[] directions = context.getNearestLookingDirections();

        for (var direction : directions) {
            if (direction.getAxis().isHorizontal()) {
                Direction direction1 = direction.getOpposite();
                blockstate = blockstate.setValue(FACING, direction1);
                if (blockstate.canSurvive(level, blockpos)) {
                    return blockstate;
                }
            }
        }
        return null;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, BlockStateProperties.WATERLOGGED);
    }
}
