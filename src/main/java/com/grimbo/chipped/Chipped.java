package com.grimbo.chipped;

import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.menus.ChippedMenuType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class Chipped implements ModInitializer {
    public static final String MOD_ID = "chipped";
    public static final CreativeModeTab CHIPPED = FabricItemGroupBuilder
            .create(new ResourceLocation(MOD_ID, "chipped"))
            .icon(() -> new ItemStack(ChippedBlocks.BOTANIST_WORKBENCH))
            .build();

    @Override
    public void onInitialize() {
        ChippedMenuType.register();
        ChippedBlocks.register();
    }
}
