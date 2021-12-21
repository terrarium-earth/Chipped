package com.grimbo.chipped.block;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.PlantType;

public class ChippedLilyPadBlock extends LilyPadBlock {

    public ChippedLilyPadBlock(Properties p_i48297_1_) {
        super(p_i48297_1_);
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return net.minecraftforge.common.PlantType.WATER;
    }
}
