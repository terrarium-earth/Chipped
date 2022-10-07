package earth.terrarium.chipped.registry.fabric;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.registry.RegistryHelpers;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class RegistryHelpersImpl {

    public static <T extends AbstractContainerMenu> MenuType<T> createMenuType(RegistryHelpers.MenuFactory<T> factory) {
        return new ExtendedScreenHandlerType<>(factory::create);
    }

    public static CreativeModeTab createTab(ResourceLocation loc, Supplier<ItemStack> icon) {
        return FabricItemGroupBuilder.build(loc, icon);
    }

    public static <E extends BlockEntity> BlockEntityType<E> createBlockEntityType(RegistryHelpers.BlockEntityFactory<E> factory, Block... blocks) {
        return FabricBlockEntityTypeBuilder.create(factory::create, blocks).build(null);
    }

    public static <V, T extends V> Pair<Supplier<T>, ResourceLocation> registerFull(Registry<V> registry, String id, Supplier<T> object) {
        var register = Registry.register(registry, new ResourceLocation(Chipped.MOD_ID, id), object.get());
        return Pair.of(() -> register, new ResourceLocation(Chipped.MOD_ID, id));
    }
}
