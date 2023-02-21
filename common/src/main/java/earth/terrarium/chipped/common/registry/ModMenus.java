package earth.terrarium.chipped.common.registry;

import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.menus.ChippedMenu;
import net.minecraft.core.Registry;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class ModMenus {
    public static final ResourcefulRegistry<MenuType<?>> MENUS = ResourcefulRegistries.create(Registry.MENU, Chipped.MOD_ID);

    public static final Supplier<MenuType<ChippedMenu>> BOTANIST_WORKBENCH = MENUS.register("botanist_workbench", () -> new MenuType<>((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, ModMenus.BOTANIST_WORKBENCH.get(), ModRecipeTypes.BOTANIST_WORKBENCH_TYPE.get(), ModBlocks.BOTANIST_WORKBENCH.get())));
    public static final Supplier<MenuType<ChippedMenu>> GLASSBLOWER = MENUS.register("glassblower", () -> new MenuType<>((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, ModMenus.GLASSBLOWER.get(), ModRecipeTypes.GLASSBLOWER_TYPE.get(), ModBlocks.GLASSBLOWER.get())));
    public static final Supplier<MenuType<ChippedMenu>> CARPENTERS_TABLE = MENUS.register("carpenters_table", () -> new MenuType<>((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, ModMenus.CARPENTERS_TABLE.get(), ModRecipeTypes.CARPENTERS_TABLE_TYPE.get(), ModBlocks.CARPENTERS_TABLE.get())));
    public static final Supplier<MenuType<ChippedMenu>> LOOM_TABLE = MENUS.register("loom_table", () -> new MenuType<>((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, ModMenus.LOOM_TABLE.get(), ModRecipeTypes.LOOM_TABLE_TYPE.get(), ModBlocks.LOOM_TABLE.get())));
    public static final Supplier<MenuType<ChippedMenu>> MASON_TABLE = MENUS.register("mason_table", () -> new MenuType<>((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, ModMenus.MASON_TABLE.get(), ModRecipeTypes.MASON_TABLE_TYPE.get(), ModBlocks.MASON_TABLE.get())));
    public static final Supplier<MenuType<ChippedMenu>> ALCHEMY_BENCH = MENUS.register("alchemy_bench", () -> new MenuType<>((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, ModMenus.ALCHEMY_BENCH.get(), ModRecipeTypes.ALCHEMY_BENCH_TYPE.get(), ModBlocks.ALCHEMY_BENCH.get())));
    public static final Supplier<MenuType<ChippedMenu>> TINKERING_TABLE = MENUS.register("tinkering_table", () -> new MenuType<>((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, ModMenus.TINKERING_TABLE.get(), ModRecipeTypes.TINKERING_TABLE_TYPE.get(), ModBlocks.TINKERING_TABLE.get())));


}
