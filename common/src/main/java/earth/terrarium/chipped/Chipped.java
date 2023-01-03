package earth.terrarium.chipped;

import earth.terrarium.chipped.registry.ModBlocks;
import earth.terrarium.chipped.registry.ModMenuTypes;
import earth.terrarium.chipped.registry.ModRecipeSerializers;
import earth.terrarium.chipped.registry.ModRecipeTypes;

public class Chipped {
    public static final String MOD_ID = "chipped";

    public static void init() {
        ModBlocks.init();
        ModMenuTypes.init();
        ModRecipeTypes.init();
        ModRecipeSerializers.init();
    }

    public static void postInit() {
    }
}
