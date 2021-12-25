package com.grimbo.chipped.container;

import com.grimbo.chipped.Chipped;

import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.recipe.ChippedSerializer;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChippedContainerType {

	//Add new ContainerTypes here
	public static final DeferredRegister<MenuType<?>> CONTAINER = DeferredRegister.create(ForgeRegistries.CONTAINERS, Chipped.MOD_ID);

	public static final RegistryObject<MenuType<ChippedContainer>> BOTANIST_WORKBENCH = CONTAINER.register("botanist_workbench",
			() -> IForgeMenuType.create((id, inv, data) -> new ChippedContainer(id, inv, ContainerLevelAccess.NULL, ChippedContainerType.BOTANIST_WORKBENCH.get(), ChippedSerializer.BOTANIST_WORKBENCH_TYPE, ChippedBlocks.BOTANIST_WORKBENCH.get())));
	public static final RegistryObject<MenuType<ChippedContainer>> GLASSBLOWER = CONTAINER.register("glassblower",
			() -> IForgeMenuType.create((id, inv, data) -> new ChippedContainer(id, inv, ContainerLevelAccess.NULL, ChippedContainerType.GLASSBLOWER.get(), ChippedSerializer.GLASSBLOWER_TYPE, ChippedBlocks.GLASSBLOWER.get())));
	public static final RegistryObject<MenuType<ChippedContainer>> CARPENTERS_TABLE = CONTAINER.register("carpenters_table",
			() -> IForgeMenuType.create((id, inv, data) -> new ChippedContainer(id, inv, ContainerLevelAccess.NULL, ChippedContainerType.CARPENTERS_TABLE.get(), ChippedSerializer.CARPENTERS_TABLE_TYPE, ChippedBlocks.CARPENTERS_TABLE.get())));
	public static final RegistryObject<MenuType<ChippedContainer>> LOOM_TABLE = CONTAINER.register("loom_table",
			() -> IForgeMenuType.create((id, inv, data) -> new ChippedContainer(id, inv, ContainerLevelAccess.NULL, ChippedContainerType.LOOM_TABLE.get(), ChippedSerializer.LOOM_TABLE_TYPE, ChippedBlocks.LOOM_TABLE.get())));
	public static final RegistryObject<MenuType<ChippedContainer>> MASON_TABLE = CONTAINER.register("mason_table",
			() -> IForgeMenuType.create((id, inv, data) -> new ChippedContainer(id, inv, ContainerLevelAccess.NULL, ChippedContainerType.MASON_TABLE.get(), ChippedSerializer.MASON_TABLE_TYPE, ChippedBlocks.MASON_TABLE.get())));
	public static final RegistryObject<MenuType<ChippedContainer>> ALCHEMY_BENCH = CONTAINER.register("alchemy_bench",
			() -> IForgeMenuType.create((id, inv, data) -> new ChippedContainer(id, inv, ContainerLevelAccess.NULL, ChippedContainerType.ALCHEMY_BENCH.get(), ChippedSerializer.ALCHEMY_BENCH_TYPE, ChippedBlocks.ALCHEMY_BENCH.get())));
	public static final RegistryObject<MenuType<ChippedContainer>> MECHANIST_WORKBENCH = CONTAINER.register("mechanist_workbench",
			() -> IForgeMenuType.create((id, inv, data) -> new ChippedContainer(id, inv, ContainerLevelAccess.NULL, ChippedContainerType.MECHANIST_WORKBENCH.get(), ChippedSerializer.MECHANIST_WORKBENCH_TYPE, ChippedBlocks.MECHANIST_WORKBENCH.get())));
}
