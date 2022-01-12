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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ChippedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ChippedBlocks.BOTANIST_WORKBENCH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ChippedBlocks.LOOM_TABLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ChippedBlocks.ALCHEMY_BENCH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ChippedBlocks.MECHANIST_WORKBENCH, RenderType.cutout());

        renderType(ChippedBlockTypes.GLASSES, RenderType.cutout());
        renderType(ChippedBlockTypes.GLASS_PANES, RenderType.cutout());

        for (var wood : ChippedWoodType.VALUES) {
            renderType(ChippedBlockTypes.WOOD_GLASSES.get(wood), RenderType.cutout());
            renderType(ChippedBlockTypes.WOOD_GLASS_PANES.get(wood), RenderType.cutout());
        }

        for (int i = 0; i < 16; i++) {
            DyeColor color = DyeColor.byId(i);
            renderType(ChippedBlockTypes.STAINED_GLASSES.get(color), RenderType.translucent());
            renderType(ChippedBlockTypes.STAINED_GLASS_PANES.get(color), RenderType.translucent());
        }

        renderType(ChippedBlockTypes.VINES, RenderType.translucent());
        renderType(ChippedBlockTypes.REDSTONE_TORCHES, RenderType.cutout());
        renderType(ChippedBlocks.REDSTONE_WALL_TORCHES, RenderType.cutout());
        renderType(ChippedBlockTypes.TORCHES, RenderType.cutout());
        renderType(ChippedBlocks.WALL_TORCHES, RenderType.cutout());
        renderType(ChippedBlockTypes.LANTERNS, RenderType.cutout());
        renderType(ChippedBlockTypes.SOUL_LANTERNS, RenderType.cutout());
        renderType(ChippedBlockTypes.BROWN_MUSHROOMS, RenderType.cutout());
        renderType(ChippedBlockTypes.RED_MUSHROOMS, RenderType.cutout());
        renderType(ChippedBlockTypes.WARPED_FUNGI, RenderType.cutout());
        renderType(ChippedBlockTypes.CRIMSON_FUNGI, RenderType.cutout());
        renderType(ChippedBlockTypes.WARPED_ROOTS, RenderType.cutout());
        renderType(ChippedBlockTypes.CRIMSON_ROOTS, RenderType.cutout());
        renderType(ChippedBlockTypes.NETHER_SPROUTS, RenderType.cutout());
        renderType(ChippedBlockTypes.COBWEBS, RenderType.cutout());
        renderType(ChippedBlockTypes.LILY_PADS, RenderType.cutout());

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

    private static <T extends Block> void renderType(List<T> blockArrayList, RenderType renderType) {
        for (var block : blockArrayList) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, renderType);
        }
    }
}
