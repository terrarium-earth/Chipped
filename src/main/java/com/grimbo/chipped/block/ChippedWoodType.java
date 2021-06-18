package com.grimbo.chipped.block;

//For easier handling of the vanilla wood types, the reason WoodType isn't used is that it only exposes its APIs to clients.
public enum ChippedWoodType {
    OAK, BIRCH, SPRUCE, JUNGLE, ACACIA, DARK_OAK, WARPED, CRIMSON;

    public static final ChippedWoodType[] VALUES = values();

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
