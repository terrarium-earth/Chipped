package com.grimbo.chipped.registry;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.grimbo.chipped.Chipped;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ChippedTags {

    public static final Map<String, TagKey<Block>> BLOCK_TAGS = new HashMap<>();
    public static final Map<String, TagKey<Item>> ITEM_TAGS = new HashMap<>();

    public static void addOrCreateTag(Block block) {
        String name = StringUtils.substringBeforeLast(Registry.BLOCK.getKey(block).getPath(), "_");
        if (!BLOCK_TAGS.containsKey(name)) {
            BLOCK_TAGS.put(name, TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Chipped.MOD_ID, name)));
            ITEM_TAGS.put(name, TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Chipped.MOD_ID, name)));
        }
    }
}
