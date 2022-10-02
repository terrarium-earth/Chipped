package com.grimbo.chipped;

import com.grimbo.chipped.client.ChippedClient;
import com.grimbo.chipped.registry.ChippedBlocks;
import com.grimbo.chipped.registry.ChippedMenuType;
import com.grimbo.chipped.registry.ChippedSerializer;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.utils.Env;
import dev.architectury.utils.EnvExecutor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class Chipped {
    public static final String MOD_ID = "chipped";

    public static final CreativeModeTab CHIPPED_ITEM_GROUP = CreativeTabRegistry.create(new ResourceLocation(MOD_ID, "chipped_item_group"), () -> new ItemStack(ChippedBlocks.BOTANIST_WORKBENCH.get()));

    public static void init() {
        ChippedBlocks.register();
        ChippedMenuType.register();
        ChippedSerializer.register();
        EnvExecutor.runInEnv(Env.CLIENT, () -> ChippedClient::initializeClient);
    }
}
