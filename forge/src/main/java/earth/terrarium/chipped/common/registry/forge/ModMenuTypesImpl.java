package earth.terrarium.chipped.common.registry.forge;

import earth.terrarium.chipped.common.registry.ModMenuTypes;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;

public class ModMenuTypesImpl {
    public static <T extends AbstractContainerMenu> MenuType<T> create(ModMenuTypes.MenuFactory<T> factory) {
        return IForgeMenuType.create(factory::create);
    }
}
