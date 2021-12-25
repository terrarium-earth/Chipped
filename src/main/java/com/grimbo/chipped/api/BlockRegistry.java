package com.grimbo.chipped.api;

import com.google.common.collect.*;
import com.grimbo.chipped.Chipped;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

public class BlockRegistry {
    private static final Set<ChippedBlockType<Block>> BLOCKS = new HashSet<>();
    private static final SetMultimap<BenchType, String> BENCH_TAGS = LinkedHashMultimap.create();

    @SuppressWarnings("unchecked")
    public static <T extends Block> void addBlock(BenchType benchType, ChippedBlockType<T> blockType, RegistryObject<T> block) {
        blockType.getBlocks().add(block);
        BLOCKS.add((ChippedBlockType<Block>) blockType);
        BENCH_TAGS.put(benchType, Chipped.MOD_ID + ":" + blockType);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Block> void addGenericBlock(BenchType benchType, ChippedBlockType<Block> blockType, RegistryObject<T> block) {
        blockType.getBlocks().add((RegistryObject<Block>) block);
        BLOCKS.add(blockType);
        BENCH_TAGS.put(benchType, Chipped.MOD_ID + ":" + blockType);
    }


    public static Set<String> getTags(BenchType type) {
        return BENCH_TAGS.get(type);
    }

    public static Set<ChippedBlockType<Block>> getBlockTypes() {
        return BLOCKS;
    }
}
