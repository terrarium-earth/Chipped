package earth.terrarium.chipped.common.registry.base;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.common.palette.Palette;

import java.util.Collection;
import java.util.function.Supplier;

public class ChippedPaletteRegistry<T> implements ResourcefulRegistry<T> {

    private final ResourcefulRegistry<T> registry;
    private final T base;
    private final Palette palette;

    public ChippedPaletteRegistry(ResourcefulRegistry<T> registry, T base, Palette palette) {
        this.registry = registry;
        this.base = base;
        this.palette = palette;
    }

    @Override
    public <I extends T> RegistryEntry<I> register(String id, Supplier<I> supplier) {
        return registry.register(id, supplier);
    }

    @Override
    public Collection<RegistryEntry<T>> getEntries() {
        return registry.getEntries();
    }

    @Override
    public void init() {
        registry.init();
    }

    public T getBase() {
        return base;
    }

    public Palette getPalette() {
        return palette;
    }
}
