package earth.terrarium.chipped.common.registry;

import com.teamresourceful.resourcefullib.common.menu.MenuContentHelper;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.menus.WorkbenchMenu;
import earth.terrarium.chipped.common.menus.WorkbenchMenuProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;

public class ModMenuTypes {
    public static final ResourcefulRegistry<MenuType<?>> MENUS = ResourcefulRegistries.create(BuiltInRegistries.MENU, Chipped.MOD_ID);

    public static final RegistryEntry<MenuType<WorkbenchMenu>> WORKBENCH = MENUS.register(
        "workbench",
        () -> MenuContentHelper.create(WorkbenchMenu::new, WorkbenchMenuProvider.Serializer.INSTANCE)
    );
}
