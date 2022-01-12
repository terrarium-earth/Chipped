package com.grimbo.chipped.block;

import org.jetbrains.annotations.NotNull;

public enum ChippedWoodType {
    OAK, BIRCH, SPRUCE, JUNGLE, ACACIA, DARK_OAK, WARPED, CRIMSON;

    public static final ChippedWoodType[] VALUES = values();

    @Override
    public String toString() {
            return name().toLowerCase();
        }
}
