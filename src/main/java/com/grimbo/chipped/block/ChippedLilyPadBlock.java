package com.grimbo.chipped.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraftforge.common.PlantType;

import net.minecraft.world.level.block.WaterlilyBlock;

public class ChippedLilyPadBlock extends WaterlilyBlock {

    public ChippedLilyPadBlock(Properties p_i48297_1_) {
        super(p_i48297_1_);
    }

    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return net.minecraftforge.common.PlantType.WATER;
    }
}
