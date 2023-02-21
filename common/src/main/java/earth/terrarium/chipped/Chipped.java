package earth.terrarium.chipped;

import earth.terrarium.chipped.common.registry.*;

public class Chipped {
    public static final String MOD_ID = "chipped";

    public static void init() {
        ModBlocks.BLOCKS.init();
        ModItems.ITEMS.init();
        ModMenus.MENUS.init();
        ModRecipeTypes.RECIPE_TYPES.init();
        ModRecipeSerializers.RECIPE_SERIALIZERS.init();
    }
}
