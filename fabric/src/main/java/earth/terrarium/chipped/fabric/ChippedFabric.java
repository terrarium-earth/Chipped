package earth.terrarium.chipped.fabric;

import earth.terrarium.chipped.Chipped;
import net.fabricmc.api.ModInitializer;
import net.minecraft.SharedConstants;

public class ChippedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Chipped.init();
    }
}
