package com.grimbo.chipped.forge;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.client.ChippedClient;
import com.grimbo.chipped.registry.forge.RegistryHelpersImpl;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Chipped.MOD_ID)
public class ChippedForge {
    public ChippedForge() {
        Chipped.init();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(ChippedForge::onClientSetup);
        RegistryHelpersImpl.REGISTRIES.values().forEach(deferredRegister -> deferredRegister.register(modEventBus));
    }

    public static void onClientSetup(FMLClientSetupEvent event) {
        ChippedClient.initializeClient();
    }
}
