package com.grimbo.chipped.api;

import com.grimbo.chipped.Chipped;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.fml.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChippedBlockType<T extends Block> implements Iterable<RegistryObject<T>> {
    private final ITag.INamedTag<Block> blockTag;
    private final ITag.INamedTag<Item> itemTag;
    private final String id;
    private final List<RegistryObject<T>> list = new ArrayList<>();

    public ChippedBlockType(String tag) {
        this.blockTag = BlockTags.bind(Chipped.MOD_ID + ":" + tag);
        this.itemTag = ItemTags.bind(Chipped.MOD_ID + ":" + tag);
        this.id = tag;
    }

    public ITag.INamedTag<Block> getBlockTag() {
        return blockTag;
    }

    public ITag.INamedTag<Item> getItemTag() {
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
