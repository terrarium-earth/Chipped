package com.grimbo.chipped.model;

import com.google.common.base.Suppliers;
import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.api.BlockRegistry;
import com.grimbo.chipped.block.ChippedBlockTypes;
import net.minecraft.block.Block;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Chipped.MOD_ID, value = Dist.CLIENT, bus = Bus.MOD)
public class ChippedColors {

	private static final Supplier<Block[]> vines = Suppliers.memoize(() -> ChippedBlockTypes.VINES.getBlocks().subList(0,7).stream().map(RegistryObject::get).toArray(Block[]::new));

	@SubscribeEvent
	public static void registerBlockColourHandlers(ColorHandlerEvent.Block event) {
		event.getBlockColors().register((state, blockAccess, pos, tintIndex) ->
				blockAccess != null && pos != null ? BiomeColors.getAverageGrassColor(blockAccess, pos) : FoliageColors.getDefaultColor(),
				vines.get());
	}

	@SubscribeEvent
	public static void registerItemColourHandlers(ColorHandlerEvent.Item event) {
		event.getItemColors().register((stack, tintIndex) ->
				event.getBlockColors().getColor(Block.byItem(stack.getItem()).defaultBlockState(), null, null, tintIndex),
				vines.get());
	}
}
