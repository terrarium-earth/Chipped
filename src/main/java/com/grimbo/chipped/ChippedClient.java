package com.grimbo.chipped;

import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.menus.ChippedMenuType;
import com.grimbo.chipped.menus.ChippedScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class ChippedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ChippedBlocks.BOTANIST_WORKBENCH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ChippedBlocks.LOOM_TABLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ChippedBlocks.ALCHEMY_BENCH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ChippedBlocks.MECHANIST_WORKBENCH, RenderType.cutout());

        for (Block glass : ChippedBlocks.blocksMap.get("glass")) {
            BlockRenderLayerMap.INSTANCE.putBlock(glass, RenderType.cutout());
        }

        for (Block glass : ChippedBlocks.blocksMap.get("glass_pane")) {
            BlockRenderLayerMap.INSTANCE.putBlock(glass, RenderType.cutout());
        }

        for (String wood : ChippedBlocks.woodsList) {
            for (Block glass : ChippedBlocks.blocksMap.get(wood + "_wood_glass")) {
                BlockRenderLayerMap.INSTANCE.putBlock(glass, RenderType.cutout());
            }

            for (Block glass : ChippedBlocks.blocksMap.get(wood + "_wood_glass_pane")) {
                BlockRenderLayerMap.INSTANCE.putBlock(glass, RenderType.cutout());
            }


        }

        for (String color : ChippedBlocks.colorsList) {
            for (Block stainedGlass : ChippedBlocks.blocksMap.get(color + "_stained_glass")) {
                BlockRenderLayerMap.INSTANCE.putBlock(stainedGlass, RenderType.translucent());
            }

            for (Block stainedGlassPane : ChippedBlocks.blocksMap.get(color + "_stained_glass_pane")) {
                BlockRenderLayerMap.INSTANCE.putBlock(stainedGlassPane, RenderType.translucent());
            }
        }

        for (Block vine : ChippedBlocks.blocksMap.get("vine")) {
            BlockRenderLayerMap.INSTANCE.putBlock(vine, RenderType.translucent());
        }
        for (Block redstoneTorch : ChippedBlocks.blocksMap.get("redstone_torch")) {
            BlockRenderLayerMap.INSTANCE.putBlock(redstoneTorch, RenderType.cutout());
        }
        for (Block redstoneWallTorch : ChippedBlocks.blocksMap.get("redstone_wall_torch")) {
            BlockRenderLayerMap.INSTANCE.putBlock(redstoneWallTorch, RenderType.cutout());
        }
        for (Block torch : ChippedBlocks.blocksMap.get("torch")) {
            BlockRenderLayerMap.INSTANCE.putBlock(torch, RenderType.cutout());
        }
        for (Block wallTorch : ChippedBlocks.blocksMap.get("wall_torch")) {
            BlockRenderLayerMap.INSTANCE.putBlock(wallTorch, RenderType.cutout());
        }

        for (Block lantern : ChippedBlocks.blocksMap.get("lantern")) {
            BlockRenderLayerMap.INSTANCE.putBlock(lantern, RenderType.cutout());
        }

        for (Block lantern : ChippedBlocks.blocksMap.get("soul_lantern")) {
            BlockRenderLayerMap.INSTANCE.putBlock(lantern, RenderType.cutout());
        }

        final BlockColor grassColourHandler = (state, blockAccess, pos, tintIndex) -> {
            if (blockAccess != null && pos != null) {
                return BiomeColors.getAverageGrassColor(blockAccess, pos);
            }

            return GrassColor.get(0.5d, 1.0d);
        };

        for (Block vine : ChippedBlocks.blocksMap.get("vine")) {
            ColorProviderRegistry.BLOCK.register(grassColourHandler, vine);
        }

        final ItemColor itemBlockColorHandler = (stack, tintIndex) -> {
            final BlockState state = Block.byItem(stack.getItem()).defaultBlockState();
            return ColorProviderRegistry.BLOCK.get(state.getBlock()).getColor(state, null, null, tintIndex);
        };

        for (Block vine : ChippedBlocks.blocksMap.get("vine")) {
            ColorProviderRegistry.ITEM.register(itemBlockColorHandler, vine);
        }

        ScreenRegistry.register(ChippedMenuType.botanistWorkbench, ChippedScreen::new);
        ScreenRegistry.register(ChippedMenuType.glassblower, ChippedScreen::new);
        ScreenRegistry.register(ChippedMenuType.carpentersTable, ChippedScreen::new);
        ScreenRegistry.register(ChippedMenuType.loomTable, ChippedScreen::new);
        ScreenRegistry.register(ChippedMenuType.masonTable, ChippedScreen::new);
        ScreenRegistry.register(ChippedMenuType.alchemyBench, ChippedScreen::new);
        ScreenRegistry.register(ChippedMenuType.mechanistWorkbench, ChippedScreen::new);
    }
}
