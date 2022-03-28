package com.grimbo.chipped.api;

import com.grimbo.chipped.Chipped;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChippedBlockType<T extends Block> implements Iterable<RegistryObject<T>> {
    private final TagKey<Block> blockTag;
    private final TagKey<Item> itemTag;
    private final ResourceLocation id;
    private final List<RegistryObject<T>> list = new ArrayList<>();

    public ChippedBlockType(String tag) {
        ResourceLocation id = new ResourceLocation(Chipped.MOD_ID, tag);
        this.blockTag = BlockTags.create(id);
        this.itemTag = ItemTags.create(id);
        this.id = id;
    }

    public TagKey<Block> getBlockTag() {
        return blockTag;
    }

    public TagKey<Item> getItemTag() {
        return itemTag;
    }

    public String getId() {
        return id.getPath();
    }

    public List<RegistryObject<T>> getBlocks() {
        return list;
    }

    @NotNull
    @Override
    public Iterator<RegistryObject<T>> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
