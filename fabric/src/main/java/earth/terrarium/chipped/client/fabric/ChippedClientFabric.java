package earth.terrarium.chipped.client.fabric;

import earth.terrarium.chipped.client.ChippedClient;
import net.fabricmc.api.ClientModInitializer;

public class ChippedClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ChippedClient.init();
    }
}
