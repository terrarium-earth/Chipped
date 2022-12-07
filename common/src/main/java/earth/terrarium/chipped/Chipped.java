package earth.terrarium.chipped;

import earth.terrarium.chipped.registry.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class Chipped {
    public static final String MOD_ID = "chipped";

    public static final CreativeModeTab CHIPPED_ITEM_GROUP = ModRegistryHelpers.createTab(new ResourceLocation(MOD_ID, "chipped_item_group"), () -> new ItemStack(ModBlocks.BOTANIST_WORKBENCH.get()));

    public static void init() {
        ModBlocks.register();
        ModMenuTypes.register();
        ModRecipeTypes.register();
        ModRecipeSerializers.register();
    }
}
