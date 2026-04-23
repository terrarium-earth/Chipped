package earth.terrarium.chipped.client.neoforge;

import earth.terrarium.chipped.client.item.ChippedItemModel;
import earth.terrarium.chipped.client.network.ClientNetwork;
import earth.terrarium.chipped.client.preview.FakeLevelPreviewRenderer;
import earth.terrarium.chipped.client.preview.FakeLevelPreviewState;
import earth.terrarium.chipped.client.screens.WorkbenchScreen;
import earth.terrarium.chipped.common.registry.ModMenuTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.RegisterItemModelsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterPictureInPictureRenderersEvent;

@EventBusSubscriber(value = Dist.CLIENT)
public class ChippedClientNeoForge {

    @SubscribeEvent
    public static void onRegisterScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.WORKBENCH.get(), WorkbenchScreen::new);
    }

    @SubscribeEvent
    public static void onRegisterRenderers(RegisterPictureInPictureRenderersEvent event) {
        event.register(FakeLevelPreviewState.class, FakeLevelPreviewRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterItemModels(RegisterItemModelsEvent event) {
        event.register(ChippedItemModel.ID, ChippedItemModel.Unbaked.CODEC);
    }

    @SubscribeEvent
    public static void onServerLeave(ClientPlayerNetworkEvent.LoggingOut event) {
        ClientNetwork.handleServerLeave();
    }
}
