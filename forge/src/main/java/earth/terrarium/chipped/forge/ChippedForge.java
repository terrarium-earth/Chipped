package earth.terrarium.chipped.forge;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.client.ChippedClient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Chipped.MOD_ID)
public class ChippedForge {
    public ChippedForge() {
        Chipped.init();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(ChippedForge::onClientSetup);
    }

    public static void onClientSetup(FMLClientSetupEvent event) {
        ChippedClient.init();
    }
}
