package com.grimbo.chipped.api;

import java.util.Locale;

public enum ChippedWoodType {
    OAK, BIRCH, SPRUCE, JUNGLE, ACACIA, DARK_OAK, WARPED, CRIMSON;

    public static final ChippedWoodType[] VALUES = values();

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
