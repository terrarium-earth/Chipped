package earth.terrarium.chipped.common.util.fabric;

import net.fabricmc.loader.api.FabricLoader;

public class PlatformUtilsImpl {

    public static boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}
