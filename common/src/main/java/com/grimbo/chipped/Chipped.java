package com.grimbo.chipped;

import com.grimbo.chipped.registry.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class Chipped {
    public static final String MOD_ID = "chipped";

    public static final CreativeModeTab CHIPPED_ITEM_GROUP = RegistryHelpers.createTab(new ResourceLocation(MOD_ID, "chipped_item_group"), () -> new ItemStack(ChippedBlocks.BOTANIST_WORKBENCH.get()));

    public static void init() {
        ChippedBlocks.register();
        ChippedMenuType.register();
        ChippedRecipeTypes.register();
        ChippedSerializer.register();
    }
}
