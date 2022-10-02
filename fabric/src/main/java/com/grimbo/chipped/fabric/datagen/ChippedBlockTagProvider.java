package com.grimbo.chipped.fabric.datagen;

import org.apache.commons.lang3.StringUtils;

import com.grimbo.chipped.registry.ChippedBlocks;
import com.grimbo.chipped.registry.ChippedTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ChippedBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ChippedBlockTagProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateTags() {
        ChippedBlocks.BLOCKS.forEach(block -> {
            String name = StringUtils.substringBeforeLast(Registry.BLOCK.getKey(block.get()).getPath(), "_");
            if (ChippedTags.BLOCK_TAGS.containsKey(name)) {
                TagKey<Block> tag = ChippedTags.BLOCK_TAGS.get(name);
                getOrCreateTagBuilder(tag).add(block.get());
            }
        });
    }

}
