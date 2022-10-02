package com.grimbo.chipped.client;

import com.grimbo.chipped.registry.ChippedBlocks;

import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.RenderType;

@Environment(EnvType.CLIENT)
public class ChippedClient {

    public static void initializeClient() {
        for (var block : ChippedBlocks.CUTOUT_BLOCKS) {
            RenderTypeRegistry.register(RenderType.cutout(), block.get());
        }

        for (var block : ChippedBlocks.TRANSPARENT_BLOCKS) {
            RenderTypeRegistry.register(RenderType.translucent(), block.get());
        }

        // Workbenches
        RenderTypeRegistry.register(RenderType.cutout(), ChippedBlocks.BOTANIST_WORKBENCH.get());
        RenderTypeRegistry.register(RenderType.cutout(), ChippedBlocks.GLASSBLOWER.get());
        RenderTypeRegistry.register(RenderType.cutout(), ChippedBlocks.CARPENTERS_TABLE.get());
        RenderTypeRegistry.register(RenderType.cutout(), ChippedBlocks.LOOM_TABLE.get());
        RenderTypeRegistry.register(RenderType.cutout(), ChippedBlocks.MASON_TABLE.get());
        RenderTypeRegistry.register(RenderType.cutout(), ChippedBlocks.ALCHEMY_BENCH.get());
        RenderTypeRegistry.register(RenderType.cutout(), ChippedBlocks.MECHANIST_WORKBENCH.get());
    }
}
