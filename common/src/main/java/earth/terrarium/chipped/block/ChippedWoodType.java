package earth.terrarium.chipped.block;

public enum ChippedWoodType {
    OAK, BIRCH, SPRUCE, JUNGLE, ACACIA, DARK_OAK, WARPED, CRIMSON;

    public static final ChippedWoodType[] VALUES = values();

    @Override
    public String toString() {
            return name().toLowerCase();
        }
}
