package com.grimbo.chipped.model;

import com.google.common.base.Suppliers;
import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlockTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Chipped.MOD_ID, value = Dist.CLIENT, bus = Bus.MOD)
public class ChippedColors {

	private static final Supplier<Block[]> vines = Suppliers.memoize(() -> ChippedBlockTypes.VINES.getBlocks().subList(0,8).stream().map(RegistryObject::get).toArray(Block[]::new));

	@SubscribeEvent
	public static void registerBlockColourHandlers(RegisterColorHandlersEvent.Block event) {
		event.getBlockColors().register((state, blockAccess, pos, tintIndex) ->
				blockAccess != null && pos != null ? BiomeColors.getAverageGrassColor(blockAccess, pos) : FoliageColor.getDefaultColor(),
				vines.get());
	}

	@SubscribeEvent
	public static void registerItemColourHandlers(RegisterColorHandlersEvent.Item event) {
		event.getItemColors().register((stack, tintIndex) ->
				event.getBlockColors().getColor(Block.byItem(stack.getItem()).defaultBlockState(), null, null, tintIndex),
				vines.get());
	}
}
