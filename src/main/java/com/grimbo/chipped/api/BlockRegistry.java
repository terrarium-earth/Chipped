package com.grimbo.chipped.api;

import com.google.common.collect.*;
import com.grimbo.chipped.Chipped;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class BlockRegistry {

    private static final ListMultimap<String, RegistryObject<Block>> BLOCKS = ArrayListMultimap.create();
    private static final SetMultimap<BenchType, String> BENCH_TAGS = LinkedHashMultimap.create();

    public static void addBlock(BenchType type, String id, RegistryObject<Block> block){
        BLOCKS.put(id, block);
        BENCH_TAGS.put(type, Chipped.MOD_ID + ":" + id);
    }

    public static void addBlock(String id, RegistryObject<Block> block){
        BLOCKS.put(id, block);
    }

    public static Set<String> getTags(BenchType type) {
        return BENCH_TAGS.get(type);
    }

    public static List<RegistryObject<Block>> getBlocks(String type){
        return BLOCKS.get(type);
    }

    public static Collection<RegistryObject<Block>> getBlocks() {
        return BLOCKS.values();
    }

    public static Set<String> getBlockTypes() {
        return BLOCKS.keySet();
    }

    public static ListMultimap<String, RegistryObject<Block>> getBlockMap() {
        return BLOCKS;
    }

    public static Stream<RegistryObject<Block>> getBlocks(String type, String id) {
        return BLOCKS.get(type).stream().filter(registry -> registry.getId().getPath().startsWith(id));
    }


}
