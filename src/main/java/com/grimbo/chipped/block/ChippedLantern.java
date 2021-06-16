package com.grimbo.chipped.block;



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
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;


public class ChippedLantern extends Block implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private final VoxelShape toEast;
    private final VoxelShape toNorth;
    public ChippedLantern(Properties properties, VoxelShape shape) {
        super(properties);
        this.toEast = shape;
        this.toNorth = shape;
    }
    public ChippedLantern(Properties properties, VoxelShape toEast, VoxelShape toNorth) {
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
            return toEast;
        } else {
            return toNorth;
        }
    }
    @Nullable
    public BlockState getStateForPlacement (BlockPlaceContext context) {
        BlockState blockstate = this.defaultBlockState();
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Direction[] adirection = context.getNearestLookingDirections();

        for(Direction direction : adirection) {
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

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
