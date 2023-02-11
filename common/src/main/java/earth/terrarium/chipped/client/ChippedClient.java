package earth.terrarium.chipped.client;

import dev.architectury.injectables.annotations.ExpectPlatform;
import earth.terrarium.chipped.common.menus.ChippedScreen;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.ModMenuTypes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.NotImplementedException;

import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public class ChippedClient {

    public static void init() {
        for (var block : ModBlocks.CUTOUT_BLOCKS) {
            registerBlockRenderType(RenderType.cutout(), block);
        }

        for (var block : ModBlocks.TRANSPARENT_BLOCKS) {
            registerBlockRenderType(RenderType.translucent(), block);
        }

        // Workbenches
        registerBlockRenderType(RenderType.cutout(), ModBlocks.BOTANIST_WORKBENCH);
        registerBlockRenderType(RenderType.cutout(), ModBlocks.GLASSBLOWER);
        registerBlockRenderType(RenderType.cutout(), ModBlocks.CARPENTERS_TABLE);
        registerBlockRenderType(RenderType.cutout(), ModBlocks.LOOM_TABLE);
        registerBlockRenderType(RenderType.cutout(), ModBlocks.MASON_TABLE);
        registerBlockRenderType(RenderType.cutout(), ModBlocks.ALCHEMY_BENCH);
        registerBlockRenderType(RenderType.cutout(), ModBlocks.MECHANIST_WORKBENCH);

        register(ModMenuTypes.ALCHEMY_BENCH.get(), ChippedScreen::new);
        register(ModMenuTypes.BOTANIST_WORKBENCH.get(), ChippedScreen::new);
        register(ModMenuTypes.CARPENTERS_TABLE.get(), ChippedScreen::new);
        register(ModMenuTypes.GLASSBLOWER.get(), ChippedScreen::new);
        register(ModMenuTypes.LOOM_TABLE.get(), ChippedScreen::new);
        register(ModMenuTypes.MASON_TABLE.get(), ChippedScreen::new);
        register(ModMenuTypes.MECHANIST_WORKBENCH.get(), ChippedScreen::new);
    }

    @ExpectPlatform
    public static void registerBlockRenderType(RenderType type, Supplier<Block> block) {
        throw new NotImplementedException();
    }

    @ExpectPlatform
    public static <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> void register(MenuType<? extends M> type, ScreenConstructor<M, U> factory) {
        throw new NotImplementedException();
    }

    @Environment(EnvType.CLIENT)
    public interface ScreenConstructor<T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>> {
        U create(T abstractContainerMenu, Inventory inventory, Component component);
    }
}
