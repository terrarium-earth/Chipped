package com.grimbo.chipped.api;

import com.grimbo.chipped.Chipped;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ChippedBlockType<T extends Block> implements Iterable<RegistryObject<T>> {
    private final Tag.Named<Block> blockTag;
    private final Tag.Named<Item> itemTag;
    private final String id;
    private final List<RegistryObject<T>> list = new ArrayList<>();

    public ChippedBlockType(String tag) {
        this.blockTag = BlockTags.bind(Chipped.MOD_ID + ":" + tag);
        this.itemTag = ItemTags.bind(Chipped.MOD_ID + ":" + tag);
        this.id = tag;
    }

    public Tag.Named<Block> getBlockTag() {
        return blockTag;
    }

    public Tag.Named<Item> getItemTag() {
        return itemTag;
    }

    public String getId() {
        return id;
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
        return id;
    }
}
