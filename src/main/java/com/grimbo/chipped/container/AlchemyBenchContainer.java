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

public class AlchemyBenchContainer extends ChippedContainer {

    private static final ContainerType<ChippedContainer> containerType = ChippedContainerType.ALCHEMY_BENCH.get();
    private static final IRecipeType<ChippedRecipe> recipeType = ChippedSerializer.ALCHEMY_BENCH_TYPE;
    private static final Block blockWorkbench = ChippedBlocks.ALCHEMY_BENCH.get();

    public AlchemyBenchContainer(int windowId, PlayerInventory playerInventory, final IWorldPosCallable worldPosCallableIn) {
        super(windowId, playerInventory, worldPosCallableIn, containerType, recipeType, blockWorkbench);
    }

    public AlchemyBenchContainer(int windowId, PlayerInventory playerInventory, PacketBuffer extraData) {
        super(windowId, playerInventory, extraData, containerType, recipeType, blockWorkbench);
    }

}