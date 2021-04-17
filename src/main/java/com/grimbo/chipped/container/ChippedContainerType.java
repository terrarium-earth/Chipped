package com.grimbo.chipped.container;

import com.grimbo.chipped.Chipped;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ChippedContainerType {

	//Add new ContainerTypes here
	public static final DeferredRegister<ContainerType<?>> CONTAINER = DeferredRegister.create(ForgeRegistries.CONTAINERS, Chipped.MOD_ID);
	
	public static final RegistryObject<ContainerType<ChippedContainer>> BOTANIST_WORKBENCH = CONTAINER.register("botanist_workbench", () -> IForgeContainerType.create(BotanistWorkbenchContainer::new));
}
