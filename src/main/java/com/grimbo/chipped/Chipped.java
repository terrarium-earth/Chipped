package com.grimbo.chipped;

import java.util.stream.Collectors;

import net.minecraft.util.Direction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.container.ChippedContainer;
import com.grimbo.chipped.container.ChippedContainerType;
import com.grimbo.chipped.container.ChippedScreen;
import com.grimbo.chipped.item.ChippedItems;
import com.grimbo.chipped.recipe.ChippedSerializer;

import net.minecraft.block.Block;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
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

	private static final Logger LOGGER = LogManager.getLogger();

	public Chipped() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ChippedBlocks.BLOCKS.register(eventBus);
		ChippedBlocks.register();
		ChippedItems.ITEMS.register(eventBus);
		ChippedSerializer.SERIALIZER.register(eventBus);
		ChippedContainerType.CONTAINER.register(eventBus);
		eventBus.addListener(this::clientRender);
		eventBus.addListener(this::onClientSetupEvent);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void clientRender(final FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(ChippedBlocks.BOTANIST_WORKBENCH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ChippedBlocks.LOOM_TABLE.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ChippedBlocks.ALCHEMY_BENCH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ChippedBlocks.MECHANIST_WORKBENCH.get(), RenderType.cutout());

		for (RegistryObject<Block> glass : ChippedBlocks.blocksMap.get("glass")) {
			RenderTypeLookup.setRenderLayer(glass.get(), RenderType.cutout());
		}

		for (RegistryObject<Block> glass : ChippedBlocks.blocksMap.get("glass_pane")) {
			RenderTypeLookup.setRenderLayer(glass.get(), RenderType.cutout());
		}

		for (String wood : ChippedBlocks.woodsList) {
			for (RegistryObject<Block> glass : ChippedBlocks.blocksMap.get(wood + "_wood_glass")) {
				RenderTypeLookup.setRenderLayer(glass.get(), RenderType.cutout());
			}

			for (RegistryObject<Block> glass : ChippedBlocks.blocksMap.get(wood + "_wood_glass_pane")) {
				RenderTypeLookup.setRenderLayer(glass.get(), RenderType.cutout());
			}


		}

		for (String color : ChippedBlocks.colorsList) {
			for (RegistryObject<Block> stainedGlass : ChippedBlocks.blocksMap.get(color + "_stained_glass")) {
				RenderTypeLookup.setRenderLayer(stainedGlass.get(), RenderType.translucent());
			}

			for (RegistryObject<Block> stainedGlassPane : ChippedBlocks.blocksMap.get(color + "_stained_glass_pane")) {
				RenderTypeLookup.setRenderLayer(stainedGlassPane.get(), RenderType.translucent());
			}
		}

		for (RegistryObject<Block> vine : ChippedBlocks.blocksMap.get("vine")) {
			RenderTypeLookup.setRenderLayer(vine.get(), RenderType.translucent());
		}
		for (RegistryObject<Block> redstoneTorch : ChippedBlocks.blocksMap.get("redstone_torch")) {
			RenderTypeLookup.setRenderLayer(redstoneTorch.get(), RenderType.cutout());
		}
		for (RegistryObject<Block> redstoneWallTorch : ChippedBlocks.blocksMap.get("redstone_wall_torch")) {
			RenderTypeLookup.setRenderLayer(redstoneWallTorch.get(), RenderType.cutout());
		}
	}

	@SuppressWarnings("unchecked")
	@SubscribeEvent
	public void onClientSetupEvent(FMLClientSetupEvent event) {
		for (ContainerType<?> container : ChippedContainerType.CONTAINER.getEntries().stream().map(RegistryObject::get)
				.collect(Collectors.toList())) {
			ScreenManager.register((ContainerType<ChippedContainer>) container, ChippedScreen::new);
		}

	}


	public static int getTorchAngleFromDir(Direction direction) {
		switch (direction) {
			case WEST:
				return 180;
			case NORTH:
				return 270;
			case SOUTH:
				return 90;
			default:
				return 0;
		}
	}

	public static int getAngleFromDir(Direction direction) {
		switch (direction) {
			case WEST:
				return 270;
			case SOUTH:
				return 180;
			case EAST:
				return 90;
			default:
				return 0;
		}
	}

}
