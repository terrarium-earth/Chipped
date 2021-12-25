package com.grimbo.chipped.container;

import com.grimbo.chipped.Chipped;

import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.block.ChippedWorkbench;
import com.grimbo.chipped.recipe.ChippedSerializer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.IWorldPosCallable;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ChippedContainerType {

	//Add new ContainerTypes here
	public static final DeferredRegister<ContainerType<?>> CONTAINER = DeferredRegister.create(ForgeRegistries.CONTAINERS, Chipped.MOD_ID);

	public static final RegistryObject<ContainerType<ChippedContainer>> BOTANIST_WORKBENCH = CONTAINER.register("botanist_workbench",
			() -> IForgeContainerType.create((id, inv, data) -> new ChippedContainer(id, inv, IWorldPosCallable.NULL, ChippedContainerType.BOTANIST_WORKBENCH.get(), ChippedSerializer.BOTANIST_WORKBENCH_TYPE, ChippedBlocks.BOTANIST_WORKBENCH.get())));
	public static final RegistryObject<ContainerType<ChippedContainer>> GLASSBLOWER = CONTAINER.register("glassblower",
			() -> IForgeContainerType.create((id, inv, data) -> new ChippedContainer(id, inv, IWorldPosCallable.NULL, ChippedContainerType.GLASSBLOWER.get(), ChippedSerializer.GLASSBLOWER_TYPE, ChippedBlocks.GLASSBLOWER.get())));
	public static final RegistryObject<ContainerType<ChippedContainer>> CARPENTERS_TABLE = CONTAINER.register("carpenters_table",
			() -> IForgeContainerType.create((id, inv, data) -> new ChippedContainer(id, inv, IWorldPosCallable.NULL, ChippedContainerType.CARPENTERS_TABLE.get(), ChippedSerializer.CARPENTERS_TABLE_TYPE, ChippedBlocks.CARPENTERS_TABLE.get())));
	public static final RegistryObject<ContainerType<ChippedContainer>> LOOM_TABLE = CONTAINER.register("loom_table",
			() -> IForgeContainerType.create((id, inv, data) -> new ChippedContainer(id, inv, IWorldPosCallable.NULL, ChippedContainerType.LOOM_TABLE.get(), ChippedSerializer.LOOM_TABLE_TYPE, ChippedBlocks.LOOM_TABLE.get())));
	public static final RegistryObject<ContainerType<ChippedContainer>> MASON_TABLE = CONTAINER.register("mason_table",
			() -> IForgeContainerType.create((id, inv, data) -> new ChippedContainer(id, inv, IWorldPosCallable.NULL, ChippedContainerType.MASON_TABLE.get(), ChippedSerializer.MASON_TABLE_TYPE, ChippedBlocks.MASON_TABLE.get())));
	public static final RegistryObject<ContainerType<ChippedContainer>> ALCHEMY_BENCH = CONTAINER.register("alchemy_bench",
			() -> IForgeContainerType.create((id, inv, data) -> new ChippedContainer(id, inv, IWorldPosCallable.NULL, ChippedContainerType.ALCHEMY_BENCH.get(), ChippedSerializer.ALCHEMY_BENCH_TYPE, ChippedBlocks.ALCHEMY_BENCH.get())));
	public static final RegistryObject<ContainerType<ChippedContainer>> MECHANIST_WORKBENCH = CONTAINER.register("mechanist_workbench",
			() -> IForgeContainerType.create((id, inv, data) -> new ChippedContainer(id, inv, IWorldPosCallable.NULL, ChippedContainerType.MECHANIST_WORKBENCH.get(), ChippedSerializer.MECHANIST_WORKBENCH_TYPE, ChippedBlocks.MECHANIST_WORKBENCH.get())));
}
