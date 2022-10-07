package earth.terrarium.chipped.client.forge;

import earth.terrarium.chipped.client.ChippedClient;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ChippedClientImpl {
    public static void registerBlockRenderType(RenderType type, Supplier<Block> block) {
        ItemBlockRenderTypes.setRenderLayer(block.get(), type);
    }

    public static <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> void register(MenuType<? extends M> type, ChippedClient.ScreenConstructor<M, U> factory) {
        MenuScreens.register(type, factory::create);
    }
}
