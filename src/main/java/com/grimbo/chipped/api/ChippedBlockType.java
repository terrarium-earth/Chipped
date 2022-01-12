package com.grimbo.chipped.api;

import com.grimbo.chipped.Chipped;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ChippedBlockType<T extends Block> implements Iterable<RegistryObject<T>> {
    private final Tags.IOptionalNamedTag<Block> blockTag;
    private final Tags.IOptionalNamedTag<Item> itemTag;
    private final ResourceLocation id;
    private final List<RegistryObject<T>> list = new ArrayList<>();

    public ChippedBlockType(String tag) {
        ResourceLocation id = new ResourceLocation(Chipped.MOD_ID, tag);
        this.blockTag = BlockTags.createOptional( id);
        this.itemTag = ItemTags.createOptional(id);
        this.id = id;
    }

    public Tags.IOptionalNamedTag<Block> getBlockTag() {
        return blockTag;
    }

    public Tags.IOptionalNamedTag<Item> getItemTag() {
        return itemTag;
    }

    public ResourceLocation getId() {
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
        return id.toString();
    }
}
