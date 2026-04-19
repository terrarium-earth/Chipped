package earth.terrarium.chipped;

import earth.terrarium.chipped.common.network.NetworkHandler;
import earth.terrarium.chipped.common.registry.*;
import net.minecraft.resources.Identifier;

public class Chipped {
    public static final String MOD_ID = "chipped";

    public static void init() {
        NetworkHandler.init();

        ModBlocks.BLOCKS.init();
        ModItems.ITEMS.init();
        ModItems.TABS.init();
        ModMenuTypes.MENUS.init();
        ModRecipeTypes.RECIPE_TYPES.init();
        ModRecipeSerializers.RECIPE_SERIALIZERS.init();
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
