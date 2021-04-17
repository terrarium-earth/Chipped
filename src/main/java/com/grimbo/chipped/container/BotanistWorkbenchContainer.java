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

public class BotanistWorkbenchContainer extends ChippedContainer {
	
	private static ContainerType<ChippedContainer> containerType = ChippedContainerType.BOTANIST_WORKBENCH.get();
	private static IRecipeType<ChippedRecipe> recipeType = ChippedSerializer.BOTANIST_WORKBENCH_TYPE;
	private static Block blockWorkbench = ChippedBlocks.BOTANIST_WORKBENCH.get();
	
	public BotanistWorkbenchContainer(int windowId, PlayerInventory playerInventory, final IWorldPosCallable worldPosCallableIn) {
		super(windowId, playerInventory, worldPosCallableIn, containerType, recipeType, blockWorkbench);
	}
	
	public BotanistWorkbenchContainer(int windowId, PlayerInventory playerInventory, PacketBuffer extraData) {
		super(windowId, playerInventory, extraData, containerType, recipeType, blockWorkbench);
	}

}
