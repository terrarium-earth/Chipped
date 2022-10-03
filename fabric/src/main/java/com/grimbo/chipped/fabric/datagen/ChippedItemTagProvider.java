package com.grimbo.chipped.fabric.datagen;

import com.grimbo.chipped.registry.ChippedBlocks;
import com.grimbo.chipped.registry.ChippedTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class ChippedItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ChippedItemTagProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateTags() {
        Set<String> addedBlocks = new HashSet<>();
        ChippedBlocks.ITEMS.forEach(item -> {
            String name = StringUtils.substringBeforeLast(Registry.ITEM.getKey(item.get()).getPath(), "_");
            if (ChippedTags.ITEM_TAGS.containsKey(name)) {
                TagKey<Item> tag = ChippedTags.ITEM_TAGS.get(name);
                if (!addedBlocks.contains(name)) {
                    getOrCreateTagBuilder(tag).add(Registry.ITEM.get(new ResourceLocation(name)));
                    addedBlocks.add(name);
                }
                getOrCreateTagBuilder(tag).add(item.get());
            }
        });
    }
}
