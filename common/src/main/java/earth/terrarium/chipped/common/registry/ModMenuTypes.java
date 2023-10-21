package earth.terrarium.chipped.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import dev.architectury.injectables.annotations.ExpectPlatform;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.menu.WorkbenchMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.apache.commons.lang3.NotImplementedException;

public class ModMenuTypes {
    public static final ResourcefulRegistry<MenuType<?>> MENUS = ResourcefulRegistries.create(BuiltInRegistries.MENU, Chipped.MOD_ID);

    public static final RegistryEntry<MenuType<WorkbenchMenu>> WORKBENCH = MENUS.register("workbench", () -> create(WorkbenchMenu::new));

    @ExpectPlatform
    public static <T extends AbstractContainerMenu> MenuType<T> create(MenuFactory<T> factory) {
        throw new NotImplementedException();
    }

    @FunctionalInterface
    public interface MenuFactory<T extends AbstractContainerMenu> {
        T create(int id, Inventory inventory, FriendlyByteBuf buf);
    }
}
