package earth.terrarium.chipped.common.registry;

import earth.terrarium.chipped.common.menus.ChippedMenu;
import net.minecraft.core.Registry;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class ModMenuTypes {
    private static <T extends MenuType<E>, E extends AbstractContainerMenu> Supplier<T> register(String id, Supplier<T> menu) {
        return ModRegistryHelpers.register(Registry.MENU, id, menu);
    }    public static Supplier<MenuType<ChippedMenu>> BOTANIST_WORKBENCH = register("botanist_workbench", () -> new MenuType<>((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, ModMenuTypes.BOTANIST_WORKBENCH.get(), ModRecipeTypes.BOTANIST_WORKBENCH_TYPE.get(), ModBlocks.BOTANIST_WORKBENCH.get())));

    public static void init() {
    }    public static Supplier<MenuType<ChippedMenu>> GLASSBLOWER = register("glassblower", () -> new MenuType<>((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, ModMenuTypes.GLASSBLOWER.get(), ModRecipeTypes.GLASSBLOWER_TYPE.get(), ModBlocks.GLASSBLOWER.get())));
    public static Supplier<MenuType<ChippedMenu>> CARPENTERS_TABLE = register("carpenters_table", () -> new MenuType<>((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, ModMenuTypes.CARPENTERS_TABLE.get(), ModRecipeTypes.CARPENTERS_TABLE_TYPE.get(), ModBlocks.CARPENTERS_TABLE.get())));
    public static Supplier<MenuType<ChippedMenu>> LOOM_TABLE = register("loom_table", () -> new MenuType<>((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, ModMenuTypes.LOOM_TABLE.get(), ModRecipeTypes.LOOM_TABLE_TYPE.get(), ModBlocks.LOOM_TABLE.get())));
    public static Supplier<MenuType<ChippedMenu>> MASON_TABLE = register("mason_table", () -> new MenuType<>((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, ModMenuTypes.MASON_TABLE.get(), ModRecipeTypes.MASON_TABLE_TYPE.get(), ModBlocks.MASON_TABLE.get())));
    public static Supplier<MenuType<ChippedMenu>> ALCHEMY_BENCH = register("alchemy_bench", () -> new MenuType<>((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, ModMenuTypes.ALCHEMY_BENCH.get(), ModRecipeTypes.ALCHEMY_BENCH_TYPE.get(), ModBlocks.ALCHEMY_BENCH.get())));
    public static Supplier<MenuType<ChippedMenu>> MECHANIST_WORKBENCH = register("mechanist_workbench", () -> new MenuType<>((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, ModMenuTypes.MECHANIST_WORKBENCH.get(), ModRecipeTypes.MECHANIST_WORKBENCH_TYPE.get(), ModBlocks.MECHANIST_WORKBENCH.get())));




}
