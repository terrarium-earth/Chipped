package com.grimbo.chipped;

import com.grimbo.chipped.block.ChippedWoodType;
import com.grimbo.chipped.menus.ChippedScreen;
import com.grimbo.chipped.registry.ChippedBlockTypes;
import com.grimbo.chipped.registry.ChippedBlocks;
import com.grimbo.chipped.registry.ChippedMenuType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

public class ChippedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ChippedBlocks.BOTANIST_WORKBENCH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ChippedBlocks.LOOM_TABLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ChippedBlocks.ALCHEMY_BENCH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ChippedBlocks.MECHANIST_WORKBENCH, RenderType.cutout());

        for (GlassBlock glass : ChippedBlockTypes.GLASSES) {
            BlockRenderLayerMap.INSTANCE.putBlock(glass, RenderType.cutout());
        }

        for (IronBarsBlock glass : ChippedBlockTypes.GLASS_PANES) {
            BlockRenderLayerMap.INSTANCE.putBlock(glass, RenderType.cutout());
        }

        for (ChippedWoodType wood : ChippedWoodType.VALUES) {
            for (GlassBlock glass : ChippedBlockTypes.WOOD_GLASSES.get(wood)) {
                BlockRenderLayerMap.INSTANCE.putBlock(glass, RenderType.cutout());
            }

            for (IronBarsBlock glass : ChippedBlockTypes.WOOD_GLASS_PANES.get(wood)) {
                BlockRenderLayerMap.INSTANCE.putBlock(glass, RenderType.cutout());
            }
        }

        for (int i = 0; i < 16; i++) {
            DyeColor color = DyeColor.byId(i);
            for (StainedGlassBlock stainedGlass : ChippedBlockTypes.STAINED_GLASSES.get(color)) {
                BlockRenderLayerMap.INSTANCE.putBlock(stainedGlass, RenderType.translucent());
            }

            for (StainedGlassPaneBlock stainedGlassPane : ChippedBlockTypes.STAINED_GLASS_PANES.get(color)) {
                BlockRenderLayerMap.INSTANCE.putBlock(stainedGlassPane, RenderType.translucent());
            }
        }

        for (VineBlock vine : ChippedBlockTypes.VINES) {
            BlockRenderLayerMap.INSTANCE.putBlock(vine, RenderType.translucent());
        }

        for (RedstoneTorchBlock redstoneTorch : ChippedBlockTypes.REDSTONE_TORCHES) {
            BlockRenderLayerMap.INSTANCE.putBlock(redstoneTorch, RenderType.cutout());
        }

        for (RedstoneWallTorchBlock redstoneWallTorch : ChippedBlocks.REDSTONE_WALL_TORCHES) {
            BlockRenderLayerMap.INSTANCE.putBlock(redstoneWallTorch, RenderType.cutout());
        }

        for (TorchBlock torch : ChippedBlockTypes.TORCHES) {
            BlockRenderLayerMap.INSTANCE.putBlock(torch, RenderType.cutout());
        }

        for (WallTorchBlock wallTorch : ChippedBlocks.WALL_TORCHES) {
            BlockRenderLayerMap.INSTANCE.putBlock(wallTorch, RenderType.cutout());
        }

        for (Block lantern : ChippedBlockTypes.LANTERNS) {
            BlockRenderLayerMap.INSTANCE.putBlock(lantern, RenderType.cutout());
        }

        for (Block lantern : ChippedBlockTypes.SOUL_LANTERNS) {
            BlockRenderLayerMap.INSTANCE.putBlock(lantern, RenderType.cutout());
        }

        final BlockColor grassColourHandler = (state, blockAccess, pos, tintIndex) -> {
            if (blockAccess != null && pos != null) {
                return BiomeColors.getAverageGrassColor(blockAccess, pos);
            }

            return GrassColor.get(0.5d, 1.0d);
        };

        final ItemColor itemBlockColorHandler = (stack, tintIndex) -> {
            final BlockState state = Block.byItem(stack.getItem()).defaultBlockState();
            return ColorProviderRegistry.BLOCK.get(state.getBlock()).getColor(state, null, null, tintIndex);
        };

        for (Block vine : ChippedBlockTypes.VINES) {
            ColorProviderRegistry.BLOCK.register(grassColourHandler, vine);
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
