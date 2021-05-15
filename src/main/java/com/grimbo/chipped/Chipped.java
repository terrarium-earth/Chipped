package com.grimbo.chipped;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.container.ChippedContainer;
import com.grimbo.chipped.container.ChippedContainerType;
import com.grimbo.chipped.container.ChippedScreen;
import com.grimbo.chipped.item.ChippedItems;
import com.grimbo.chipped.recipe.ChippedSerializer;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Chipped.MOD_ID)
public class Chipped {
	public static final String MOD_ID = "chipped";
	public static final ItemGroup CHIPPED = (new ItemGroup("chippedTab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ChippedBlocks.BOTANIST_WORKBENCH.get());
		}
	});// .setTabPath("chipped_tab");

	private static final Logger LOGGER = LogManager.getLogger();

	public Chipped() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ChippedBlocks.BLOCKS.register(eventBus);
		ChippedBlocks.register();
		ChippedItems.ITEMS.register(eventBus);
		ChippedSerializer.SERIALIZER.register(eventBus);
		ChippedContainerType.CONTAINER.register(eventBus);
		eventBus.addListener(ChippedBlocks::clientRender);
		eventBus.addListener(this::onClientSetupEvent);
		MinecraftForge.EVENT_BUS.register(this);

	}

	@SuppressWarnings("unchecked")
	@SubscribeEvent
	public void onClientSetupEvent(FMLClientSetupEvent event) {
		for (ContainerType<?> container : ChippedContainerType.CONTAINER.getEntries().stream().map(RegistryObject::get)
				.collect(Collectors.toList())) {
			ScreenManager.register((ContainerType<ChippedContainer>) container, ChippedScreen::new);
		}
	}
}
