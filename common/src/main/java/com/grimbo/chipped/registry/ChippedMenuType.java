package com.grimbo.chipped.registry;

import java.util.function.Supplier;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.menus.ChippedMenu;

import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.Registry;
import net.minecraft.world.inventory.MenuType;

public class ChippedMenuType {

	// Add new ContainerTypes here

	public static final DeferredRegister<MenuType<?>> SCREEN_HANDLERS = DeferredRegister.create(Chipped.MOD_ID, Registry.MENU_REGISTRY);

	public static final Supplier<MenuType<ChippedMenu>> BOTANIST_WORKBENCH = SCREEN_HANDLERS.register("botanist_workbench", () -> RegistryHelpers.createMenuType((id, inventory, buf) -> new ChippedMenu(id, inventory, ChippedSerializer.BOTANIST_WORKBENCH_TYPE.get(), ChippedBlocks.BOTANIST_WORKBENCH.get())));
	public static final Supplier<MenuType<ChippedMenu>> GLASSBLOWER = SCREEN_HANDLERS.register("glassblower", () -> RegistryHelpers.createMenuType((id, inventory, buf) -> new ChippedMenu(id, inventory, ChippedSerializer.GLASSBLOWER_TYPE.get(), ChippedBlocks.GLASSBLOWER.get())));
	public static final Supplier<MenuType<ChippedMenu>> CARPENTERS_TABLE = SCREEN_HANDLERS.register("carpenters_table", () -> RegistryHelpers.createMenuType((id, inventory, buf) -> new ChippedMenu(id, inventory, ChippedSerializer.CARPENTERS_TABLE_TYPE.get(), ChippedBlocks.CARPENTERS_TABLE.get())));
	public static final Supplier<MenuType<ChippedMenu>> LOOM_TABLE = SCREEN_HANDLERS.register("loom_table", () -> RegistryHelpers.createMenuType((id, inventory, buf) -> new ChippedMenu(id, inventory, ChippedSerializer.LOOM_TABLE_TYPE.get(), ChippedBlocks.LOOM_TABLE.get())));
	public static final Supplier<MenuType<ChippedMenu>> MASON_TABLE = SCREEN_HANDLERS.register("mason_table", () -> RegistryHelpers.createMenuType((id, inventory, buf) -> new ChippedMenu(id, inventory, ChippedSerializer.MASON_TABLE_TYPE.get(), ChippedBlocks.MASON_TABLE.get())));
	public static final Supplier<MenuType<ChippedMenu>> ALCHEMY_BENCH = SCREEN_HANDLERS.register("alchemy_bench", () -> RegistryHelpers.createMenuType((id, inventory, buf) -> new ChippedMenu(id, inventory, ChippedSerializer.ALCHEMY_BENCH_TYPE.get(), ChippedBlocks.ALCHEMY_BENCH.get())));
	public static final Supplier<MenuType<ChippedMenu>> MECHANIST_WORKBENCH = SCREEN_HANDLERS.register("mechanist_workbench", () -> RegistryHelpers.createMenuType((id, inventory, buf) -> new ChippedMenu(id, inventory, ChippedSerializer.MECHANIST_WORKBENCH_TYPE.get(), ChippedBlocks.MECHANIST_WORKBENCH.get())));

	public static void register() {
		SCREEN_HANDLERS.register();
	}
}
