package com.grimbo.chipped.container;

import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.recipe.ChippedRecipe;
import com.grimbo.chipped.recipe.ChippedSerializer;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IWorldPosCallable;

public class MasonTableContainer extends ChippedContainer {

    private static final ContainerType<ChippedContainer> containerType = ChippedContainerType.MASON_TABLE.get();
    private static final IRecipeType<ChippedRecipe> recipeType = ChippedSerializer.MASON_TABLE_TYPE;
    private static final Block blockWorkbench = ChippedBlocks.MASON_TABLE.get();

    public MasonTableContainer(int windowId, PlayerInventory playerInventory, final IWorldPosCallable worldPosCallableIn) {
        super(windowId, playerInventory, worldPosCallableIn, containerType, recipeType, blockWorkbench);
    }

    public MasonTableContainer(int windowId, PlayerInventory playerInventory, PacketBuffer extraData) {
        super(windowId, playerInventory, extraData, containerType, recipeType, blockWorkbench);
    }

}