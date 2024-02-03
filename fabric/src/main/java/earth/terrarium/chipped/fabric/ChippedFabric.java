package earth.terrarium.chipped.fabric;

import earth.terrarium.chipped.Chipped;
import net.fabricmc.api.ModInitializer;

public class ChippedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Chipped.init();
    }
}
