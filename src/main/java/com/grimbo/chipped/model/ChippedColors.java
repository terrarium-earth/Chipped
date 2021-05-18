package com.grimbo.chipped.model;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

//Pulled from Choonster's choonster.testmod3.client.model.ModColourManager
@Mod.EventBusSubscriber(modid = Chipped.MOD_ID, value = Dist.CLIENT, bus = Bus.MOD)
public class ChippedColors {

	@SubscribeEvent
	public static void registerBlockColourHandlers(final ColorHandlerEvent.Block event) {
		final BlockColors blockColors = event.getBlockColors();

		final IBlockColor grassColourHandler = (state, blockAccess, pos, tintIndex) -> {
			if (blockAccess != null && pos != null) {
				return BiomeColors.getAverageGrassColor(blockAccess, pos);
			}

			return GrassColors.get(0.5d, 1.0d);
		};

		for (RegistryObject<Block> vine : ChippedBlocks.vines) {
			blockColors.register(grassColourHandler, vine.get());
		}
	}

	@SubscribeEvent
	public static void registerItemColourHandlers(final ColorHandlerEvent.Item event) {
		final BlockColors blockColors = event.getBlockColors();
		final ItemColors itemColors = event.getItemColors();

		final IItemColor itemBlockColourHandler = (stack, tintIndex) -> {
			final BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
			return blockColors.getColor(state, null, null, tintIndex);
		};

		for (RegistryObject<Block> vine : ChippedBlocks.vines) {
			itemColors.register(itemBlockColourHandler, vine.get());
		}
	}
}
