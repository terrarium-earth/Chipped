package earth.terrarium.chipped.common.util.forge;

import net.minecraftforge.fml.loading.FMLLoader;

public class PlatformUtilsImpl {

    public static boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }
}
