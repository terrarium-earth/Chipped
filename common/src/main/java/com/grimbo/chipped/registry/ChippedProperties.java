package com.grimbo.chipped.registry;

import java.util.function.BiFunction;
import java.util.function.Function;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ChippedProperties {
    private boolean transparent;
    private boolean cutout;
    private boolean skipItem;
    private boolean excludeFromLootTable;
    private boolean excludeModel;
    private Function<BlockBehaviour.Properties, ? extends Block> blockType = Block::new;
    private BiFunction<Block, Item.Properties, ? extends Item> itemType = BlockItem::new;

    public <T extends Block> ChippedProperties blockType(Function<BlockBehaviour.Properties, T> blockType) {
        this.blockType = blockType;
        return this;
    }

    public <T extends Item> ChippedProperties itemType(BiFunction<Block, Item.Properties, T> itemType) {
        this.itemType = itemType;
        return this;
    }

    public ChippedProperties transparent() {
        this.transparent = true;
        return this;
    }

    public ChippedProperties cutout() {
        this.cutout = true;
        return this;
    }

    public ChippedProperties excludeLoot() {
        this.excludeFromLootTable = true;
        return this;
    }

    public ChippedProperties excludeModel() {
        this.excludeModel = true;
        return this;
    }

    public ChippedProperties skipItem() {
        this.skipItem = true;
        return this;
    }

    public ChippedProperties coloured() {
        this.transparent = true;
        return this;
    }

    public boolean isTransparent() {
        return this.transparent;
    }

    public boolean isCutout() {
        return this.cutout;
    }

    public boolean skippedItem() {
        return this.skipItem;
    }

    public boolean isExcludedFromLootTable() {
        return this.excludeFromLootTable;
    }

    public boolean isExcludedModel() {
        return this.excludeModel;
    }

    public Function<BlockBehaviour.Properties, ? extends Block> getBlockType() {
        return this.blockType;
    }

    public BiFunction<Block, Item.Properties, ? extends Item> getItemType() {
        return this.itemType;
    }
}
