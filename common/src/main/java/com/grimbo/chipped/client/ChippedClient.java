package com.grimbo.chipped.client;

import com.grimbo.chipped.menus.ChippedScreen;
import com.grimbo.chipped.registry.ChippedBlocks;
import com.grimbo.chipped.registry.ChippedMenuType;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public class ChippedClient {

    public static void initializeClient() {
        for (var block : ChippedBlocks.CUTOUT_BLOCKS) {
            registerBlockRenderType(RenderType.cutout(), block);
        }

        for (var block : ChippedBlocks.TRANSPARENT_BLOCKS) {
            registerBlockRenderType(RenderType.translucent(), block);
        }

        // Workbenches
        registerBlockRenderType(RenderType.cutout(), ChippedBlocks.BOTANIST_WORKBENCH);
        registerBlockRenderType(RenderType.cutout(), ChippedBlocks.GLASSBLOWER);
        registerBlockRenderType(RenderType.cutout(), ChippedBlocks.CARPENTERS_TABLE);
        registerBlockRenderType(RenderType.cutout(), ChippedBlocks.LOOM_TABLE);
        registerBlockRenderType(RenderType.cutout(), ChippedBlocks.MASON_TABLE);
        registerBlockRenderType(RenderType.cutout(), ChippedBlocks.ALCHEMY_BENCH);
        registerBlockRenderType(RenderType.cutout(), ChippedBlocks.MECHANIST_WORKBENCH);

        register(ChippedMenuType.ALCHEMY_BENCH.get(), ChippedScreen::new);
        register(ChippedMenuType.BOTANIST_WORKBENCH.get(), ChippedScreen::new);
        register(ChippedMenuType.CARPENTERS_TABLE.get(), ChippedScreen::new);
        register(ChippedMenuType.GLASSBLOWER.get(), ChippedScreen::new);
        register(ChippedMenuType.LOOM_TABLE.get(), ChippedScreen::new);
        register(ChippedMenuType.MASON_TABLE.get(), ChippedScreen::new);
        register(ChippedMenuType.MECHANIST_WORKBENCH.get(), ChippedScreen::new);
    }

    @ExpectPlatform
    public static void registerBlockRenderType(RenderType type, Supplier<Block> block) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> void register(MenuType<? extends M> type, ScreenConstructor<M, U> factory) {
        throw new AssertionError();
    }

    @Environment(EnvType.CLIENT)
    public interface ScreenConstructor<T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>> {
        U create(T abstractContainerMenu, Inventory inventory, Component component);
    }
}
