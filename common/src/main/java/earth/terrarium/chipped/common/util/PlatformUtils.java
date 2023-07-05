package earth.terrarium.chipped.common.util;

import dev.architectury.injectables.annotations.ExpectPlatform;
import org.apache.commons.lang3.NotImplementedException;

public class PlatformUtils {

    @ExpectPlatform
    public static boolean isDevelopmentEnvironment() {
        throw new NotImplementedException();
    }
}
