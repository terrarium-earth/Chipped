package earth.terrarium.chipped.fabric.datagen;

import net.minecraft.resources.ResourceLocation;
import org.apache.commons.lang3.StringUtils;

import earth.terrarium.chipped.registry.ModBlocks;
import earth.terrarium.chipped.registry.ModTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.HashSet;
import java.util.Set;

public class ChippedBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ChippedBlockTagProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateTags() {
        Set<String> addedBlocks = new HashSet<>();
        ModBlocks.BLOCKS.forEach(block -> {
            String name = StringUtils.substringBeforeLast(Registry.BLOCK.getKey(block.get()).getPath(), "_");
            if (ModTags.BLOCK_TAGS.containsKey(name)) {
                TagKey<Block> tag = ModTags.BLOCK_TAGS.get(name);
                if (!addedBlocks.contains(name)) {
                    getOrCreateTagBuilder(tag).add(Registry.BLOCK.get(new ResourceLocation(name)));
                    addedBlocks.add(name);
                }
                getOrCreateTagBuilder(tag).add(block.get());
            }
        });
    }

}
