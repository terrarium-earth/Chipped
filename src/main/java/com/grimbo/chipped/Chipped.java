package com.grimbo.chipped;

import java.util.stream.Collectors;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
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
	}).setRecipeFolderName("chipped_tab");

	@SubscribeEvent
	public void clientRender(final FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(ChippedBlocks.BOTANIST_WORKBENCH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ChippedBlocks.LOOM_TABLE.get(), RenderType.cutout());

		for (RegistryObject<Block> glass : ChippedBlocks.glasses) {
			RenderTypeLookup.setRenderLayer(glass.get(), RenderType.cutout());
		}

		for (RegistryObject<Block> stainedGlass : ChippedBlocks.stainedGlasses) {
			RenderTypeLookup.setRenderLayer(stainedGlass.get(), RenderType.translucent());
		}

		// Vines
		RenderTypeLookup.setRenderLayer(ChippedBlocks.VINE_1.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(ChippedBlocks.VINE_2.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(ChippedBlocks.VINE_3.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(ChippedBlocks.VINE_4.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(ChippedBlocks.VINE_5.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(ChippedBlocks.VINE_6.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(ChippedBlocks.VINE_7.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(ChippedBlocks.VINE_8.get(), RenderType.translucent());

	}

	private static final Logger LOGGER = LogManager.getLogger();

	public Chipped() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		eventBus.addListener(this::clientRender);
		ChippedBlocks.BLOCKS.register(eventBus);
		ChippedBlocks.register();
		ChippedItems.ITEMS.register(eventBus);
		ChippedSerializer.SERIALIZER.register(eventBus);
		ChippedContainerType.CONTAINER.register(eventBus);
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
