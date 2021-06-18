package com.grimbo.chipped;

import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.block.ChippedLanternBlock;
import com.grimbo.chipped.block.ChippedWoodType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
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

        for (GlassBlock glass : ChippedBlocks.GLASSES) {
            BlockRenderLayerMap.INSTANCE.putBlock(glass, RenderType.cutout());
        }

        for (IronBarsBlock glass : ChippedBlocks.GLASS_PANES) {
            BlockRenderLayerMap.INSTANCE.putBlock(glass, RenderType.cutout());
        }

        for (ChippedWoodType wood : ChippedWoodType.VALUES) {
            for (GlassBlock glass : ChippedBlocks.WOOD_GLASSES.get(wood)) {
                BlockRenderLayerMap.INSTANCE.putBlock(glass, RenderType.cutout());
            }

            for (IronBarsBlock glass : ChippedBlocks.WOOD_GLASS_PANES.get(wood)) {
                BlockRenderLayerMap.INSTANCE.putBlock(glass, RenderType.cutout());
            }
        }

        for (int i = 0; i < 16; i++) {
            DyeColor color = DyeColor.byId(i);
            for (StainedGlassBlock stainedGlass : ChippedBlocks.STAINED_GLASSES.get(color)) {
                BlockRenderLayerMap.INSTANCE.putBlock(stainedGlass, RenderType.translucent());
            }

            for (StainedGlassPaneBlock stainedGlassPane : ChippedBlocks.STAINED_GLASS_PANES.get(color)) {
                BlockRenderLayerMap.INSTANCE.putBlock(stainedGlassPane, RenderType.translucent());
            }
        }

        for (VineBlock vine : ChippedBlocks.VINES) {
            BlockRenderLayerMap.INSTANCE.putBlock(vine, RenderType.translucent());
        }
        for (RedstoneTorchBlock redstoneTorch : ChippedBlocks.REDSTONE_TORCHES) {
            BlockRenderLayerMap.INSTANCE.putBlock(redstoneTorch, RenderType.cutout());
        }
        for (RedstoneWallTorchBlock redstoneWallTorch : ChippedBlocks.REDSTONE_WALL_TORCHES) {
            BlockRenderLayerMap.INSTANCE.putBlock(redstoneWallTorch, RenderType.cutout());
        }
        for (TorchBlock torch : ChippedBlocks.TORCHES) {
            BlockRenderLayerMap.INSTANCE.putBlock(torch, RenderType.cutout());
        }
        for (WallTorchBlock wallTorch : ChippedBlocks.WALL_TORCHES) {
            BlockRenderLayerMap.INSTANCE.putBlock(wallTorch, RenderType.cutout());
        }

        for (ChippedLanternBlock lantern : ChippedBlocks.LANTERNS) {
            BlockRenderLayerMap.INSTANCE.putBlock(lantern, RenderType.cutout());
        }

        for (ChippedLanternBlock lantern : ChippedBlocks.SOUL_LANTERNS) {
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

        for (Block vine : ChippedBlocks.VINES) {
            ColorProviderRegistry.BLOCK.register(grassColourHandler, vine);
            ColorProviderRegistry.ITEM.register(itemBlockColorHandler, vine);
        }
    }
}
