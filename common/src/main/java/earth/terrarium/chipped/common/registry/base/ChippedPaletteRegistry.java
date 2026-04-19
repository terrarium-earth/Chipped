package earth.terrarium.chipped.common.registry.base;

import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import com.teamresourceful.resourcefullib.common.registry.builtin.ResourcefulBlockRegistry;
import com.teamresourceful.resourcefullib.common.registry.builtin.base.ItemLikeEntry;
import earth.terrarium.chipped.common.palette.Palette;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Function;

public class ChippedPaletteRegistry extends ResourcefulBlockRegistry {

    private final Block base;
    private final Palette palette;
    private final @Nullable String customBase;

    public ChippedPaletteRegistry(ResourcefulRegistry<Block> parent, Block base, Palette palette) {
        this(parent, base, null, palette);
    }

    public ChippedPaletteRegistry(ResourcefulRegistry<Block> parent, Block base, @Nullable String customBase, Palette palette) {
        super(ResourcefulRegistries.create(parent));
        this.base = base;
        this.palette = palette;
        this.customBase = customBase;
    }

    public <I extends Block> ItemLikeEntry<I> registerWithBaseProperties(String id, Function<Block.Properties, I> factory) {
        return register(id, p -> factory.apply(p), () -> BlockBehaviour.Properties.ofFullCopy(this.base).noLootTable());
    }

    public Block getBase() {
        return base;
    }

    public Optional<String> getCustomBase() {
        return Optional.ofNullable(customBase);
    }

    public Palette getPalette() {
        return palette;
    }
}
