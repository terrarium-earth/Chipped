package com.grimbo.chipped.registry;

import com.grimbo.chipped.menus.ChippedMenu;
import net.minecraft.core.Registry;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class ChippedMenuType {


	public static Supplier<MenuType<ChippedMenu>> BOTANIST_WORKBENCH;
	public static Supplier<MenuType<ChippedMenu>> GLASSBLOWER;
	public static Supplier<MenuType<ChippedMenu>> CARPENTERS_TABLE;
	public static Supplier<MenuType<ChippedMenu>> LOOM_TABLE;
	public static Supplier<MenuType<ChippedMenu>> MASON_TABLE;
	public static Supplier<MenuType<ChippedMenu>> ALCHEMY_BENCH;
	public static Supplier<MenuType<ChippedMenu>> MECHANIST_WORKBENCH;

	public static void register() {
		BOTANIST_WORKBENCH = register("botanist_workbench", () -> createMenuType((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, BOTANIST_WORKBENCH.get(), ChippedRecipeTypes.BOTANIST_WORKBENCH_TYPE.get(), ChippedBlocks.BOTANIST_WORKBENCH.get())));
		GLASSBLOWER = register("glassblower", () -> createMenuType((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, GLASSBLOWER.get(), ChippedRecipeTypes.GLASSBLOWER_TYPE.get(), ChippedBlocks.GLASSBLOWER.get())));
		CARPENTERS_TABLE = register("carpenters_table", () -> createMenuType((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, CARPENTERS_TABLE.get(), ChippedRecipeTypes.CARPENTERS_TABLE_TYPE.get(), ChippedBlocks.CARPENTERS_TABLE.get())));
		LOOM_TABLE = register("loom_table", () -> createMenuType((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, LOOM_TABLE.get(), ChippedRecipeTypes.LOOM_TABLE_TYPE.get(), ChippedBlocks.LOOM_TABLE.get())));
		MASON_TABLE = register("mason_table", () -> createMenuType((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, MASON_TABLE.get(), ChippedRecipeTypes.MASON_TABLE_TYPE.get(), ChippedBlocks.MASON_TABLE.get())));
		ALCHEMY_BENCH = register("alchemy_bench", () -> createMenuType((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, ALCHEMY_BENCH.get(), ChippedRecipeTypes.ALCHEMY_BENCH_TYPE.get(), ChippedBlocks.ALCHEMY_BENCH.get())));
		MECHANIST_WORKBENCH = register("mechanist_workbench", () -> createMenuType((id, inventory) -> new ChippedMenu(id, inventory, ContainerLevelAccess.NULL, MECHANIST_WORKBENCH.get(), ChippedRecipeTypes.MECHANIST_WORKBENCH_TYPE.get(), ChippedBlocks.MECHANIST_WORKBENCH.get())));
	}

	public static <T extends AbstractContainerMenu> MenuType<T> createMenuType(MenuType.MenuSupplier <T> factory) {
		return new MenuType<>(factory);
	}

	private static <T extends MenuType<E>, E extends AbstractContainerMenu> Supplier<T> register(String id, Supplier<T> menu) {
		return RegistryHelpers.register(Registry.MENU, id, menu);
	}
}
