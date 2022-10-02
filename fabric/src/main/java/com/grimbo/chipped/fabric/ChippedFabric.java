package com.grimbo.chipped.fabric;

import com.grimbo.chipped.Chipped;

import net.fabricmc.api.ModInitializer;

public class ChippedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Chipped.init();
    }
}
