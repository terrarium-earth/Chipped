package earth.terrarium.chipped.common.registry.fabric;

import earth.terrarium.chipped.common.registry.ModMenuTypes;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public class ModMenuTypesImpl {
    public static <T extends AbstractContainerMenu> MenuType<T> create(ModMenuTypes.MenuFactory<T> factory) {
        return new ExtendedScreenHandlerType<>(factory::create);
    }
}
