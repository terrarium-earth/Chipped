package earth.terrarium.chipped.common.items;

import earth.terrarium.chipped.Chipped;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class ChippedBlockItemProperties extends Item.Properties {

    private static final Identifier BLOCK = Chipped.id("block");

    private final @Nullable Identifier model;

    private ChippedBlockItemProperties(@Nullable Identifier model) {
        super();
        this.model = model;
    }

    @Override
    public @NonNull Identifier effectiveModel() {
        return this.model == null ? super.effectiveModel() : this.model;
    }

    public static ChippedBlockItemProperties model() {
        var properties = new ChippedBlockItemProperties(BLOCK);
        properties.useBlockDescriptionPrefix();
        return properties;
    }

    public static ChippedBlockItemProperties base() {
        var properties = new ChippedBlockItemProperties(null);
        properties.useBlockDescriptionPrefix();
        return properties;
    }
}
