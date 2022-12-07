package earth.terrarium.chipped.registry;

import earth.terrarium.chipped.menus.ChippedMenu;
import net.minecraft.core.Registry;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class ModMenuTypes {
	public static Supplier<MenuType<ChippedMenu>> BOTANIST_WORKBENCH;
	public static Supplier<MenuType<ChippedMenu>> GLASSBLOWER;
	public static Supplier<MenuType<ChippedMenu>> CARPENTERS_TABLE;
	public static Supplier<MenuType<ChippedMenu>> LOOM_TABLE;
	public static Supplier<MenuType<ChippedMenu>> MASON_TABLE;
	public static Supplier<MenuType<ChippedMenu>> ALCHEMY_BENCH;
	public static Supplier<MenuType<ChippedMenu>> MECHANIST_WORKBENCH;

	public static void register() {
		BOTANIST_WORKBENCH = register("botanist_workbench", () -> createMenuType((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, BOTANIST_WORKBENCH.get(), ModRecipeTypes.BOTANIST_WORKBENCH_TYPE.get(), ModBlocks.BOTANIST_WORKBENCH.get())));
		GLASSBLOWER = register("glassblower", () -> createMenuType((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, GLASSBLOWER.get(), ModRecipeTypes.GLASSBLOWER_TYPE.get(), ModBlocks.GLASSBLOWER.get())));
		CARPENTERS_TABLE = register("carpenters_table", () -> createMenuType((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, CARPENTERS_TABLE.get(), ModRecipeTypes.CARPENTERS_TABLE_TYPE.get(), ModBlocks.CARPENTERS_TABLE.get())));
		LOOM_TABLE = register("loom_table", () -> createMenuType((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, LOOM_TABLE.get(), ModRecipeTypes.LOOM_TABLE_TYPE.get(), ModBlocks.LOOM_TABLE.get())));
		MASON_TABLE = register("mason_table", () -> createMenuType((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, MASON_TABLE.get(), ModRecipeTypes.MASON_TABLE_TYPE.get(), ModBlocks.MASON_TABLE.get())));
		ALCHEMY_BENCH = register("alchemy_bench", () -> createMenuType((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, ALCHEMY_BENCH.get(), ModRecipeTypes.ALCHEMY_BENCH_TYPE.get(), ModBlocks.ALCHEMY_BENCH.get())));
		MECHANIST_WORKBENCH = register("mechanist_workbench", () -> createMenuType((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, MECHANIST_WORKBENCH.get(), ModRecipeTypes.MECHANIST_WORKBENCH_TYPE.get(), ModBlocks.MECHANIST_WORKBENCH.get())));
	}

	public static <T extends AbstractContainerMenu> MenuType<T> createMenuType(MenuType.MenuSupplier <T> factory) {
		return new MenuType<>(factory);
	}

	private static <T extends MenuType<E>, E extends AbstractContainerMenu> Supplier<T> register(String id, Supplier<T> menu) {
		return ModRegistryHelpers.register(Registry.MENU, id, menu);
	}
}
