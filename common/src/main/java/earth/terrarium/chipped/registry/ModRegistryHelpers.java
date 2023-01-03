package earth.terrarium.chipped.registry;

import com.mojang.datafixers.util.Pair;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.NotImplementedException;

import java.util.function.Supplier;

public class ModRegistryHelpers {

    @ExpectPlatform
    public static <V, T extends V> Pair<Supplier<T>, ResourceLocation> registerFull(Registry<V> registry, String id, Supplier<T> object) {
        throw new NotImplementedException();
    }

    public static <V, T extends V> Supplier<T> register(Registry<V> registry, String id, Supplier<T> object) {
        return registerFull(registry, id, object).getFirst();
    }

    @ExpectPlatform
    public static CreativeModeTab createTab(ResourceLocation loc, Supplier<ItemStack> icon) {
        throw new NotImplementedException();
    }
}
