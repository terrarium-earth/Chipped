package earth.terrarium.chipped.client.fabric;

import earth.terrarium.chipped.client.item.ChippedItemModel;
import earth.terrarium.chipped.client.preview.FakeLevelPreviewRenderer;
import earth.terrarium.chipped.client.screens.WorkbenchScreen;
import earth.terrarium.chipped.common.registry.ModMenuTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.PictureInPictureRendererRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.item.ItemModels;

public class ChippedClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ItemModels.ID_MAPPER.put(ChippedItemModel.ID, ChippedItemModel.Unbaked.CODEC);
        MenuScreens.register(ModMenuTypes.WORKBENCH.get(), WorkbenchScreen::new);
        PictureInPictureRendererRegistry.register(ctx -> new FakeLevelPreviewRenderer(ctx.bufferSource()));
    }
}
