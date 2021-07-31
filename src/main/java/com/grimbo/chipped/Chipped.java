package com.grimbo.chipped;

import com.grimbo.chipped.api.BlockRegistry;
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
import net.minecraft.util.Direction;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

@Mod(Chipped.MOD_ID)
public class Chipped {
	public static final String MOD_ID = "chipped";
	public static final ItemGroup CHIPPED = (new ItemGroup("chippedTab") {
		@Override
		public @NotNull ItemStack makeIcon() {
			return new ItemStack(ChippedBlocks.BOTANIST_WORKBENCH.get());
		}
	}).setRecipeFolderName("chipped_tab");

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

		for (RegistryObject<Block> glass : BlockRegistry.getBlocks("glass")) {
			RenderTypeLookup.setRenderLayer(glass.get(), RenderType.cutout());
		}

		for (RegistryObject<Block> glass : BlockRegistry.getBlocks("glass_pane")) {
			RenderTypeLookup.setRenderLayer(glass.get(), RenderType.cutout());
		}

		for (String wood : ChippedBlocks.woodsList) {
			for (RegistryObject<Block> glass : BlockRegistry.getBlocks(wood + "_wood_glass")) {
				RenderTypeLookup.setRenderLayer(glass.get(), RenderType.cutout());
			}

			for (RegistryObject<Block> glass : BlockRegistry.getBlocks(wood + "_wood_glass_pane")) {
				RenderTypeLookup.setRenderLayer(glass.get(), RenderType.cutout());
			}
		}

		for (String color : ChippedBlocks.colorsList) {
			for (RegistryObject<Block> stainedGlass : BlockRegistry.getBlocks(color + "_stained_glass")) {
				RenderTypeLookup.setRenderLayer(stainedGlass.get(), RenderType.translucent());
			}

			for (RegistryObject<Block> stainedGlassPane : BlockRegistry.getBlocks(color + "_stained_glass_pane")) {
				RenderTypeLookup.setRenderLayer(stainedGlassPane.get(), RenderType.translucent());
			}
		}

		for (RegistryObject<Block> vine : BlockRegistry.getBlocks("vine")) {
			RenderTypeLookup.setRenderLayer(vine.get(), RenderType.translucent());
		}
		for (RegistryObject<Block> redstoneTorch : BlockRegistry.getBlocks("redstone_torch")) {
			RenderTypeLookup.setRenderLayer(redstoneTorch.get(), RenderType.cutout());
		}
		for (RegistryObject<Block> redstoneWallTorch : BlockRegistry.getBlocks("redstone_wall_torch")) {
			RenderTypeLookup.setRenderLayer(redstoneWallTorch.get(), RenderType.cutout());
		}
		for (RegistryObject<Block> torch : BlockRegistry.getBlocks("torch")) {
			RenderTypeLookup.setRenderLayer(torch.get(), RenderType.cutout());
		}
		for (RegistryObject<Block> wallTorch : BlockRegistry.getBlocks("wall_torch")) {
			RenderTypeLookup.setRenderLayer(wallTorch.get(), RenderType.cutout());
		}

		for (RegistryObject<Block> lantern : BlockRegistry.getBlocks("lantern")) {
			RenderTypeLookup.setRenderLayer(lantern.get(), RenderType.cutout());
		}

		for (RegistryObject<Block> lantern : BlockRegistry.getBlocks("soul_lantern")) {
			RenderTypeLookup.setRenderLayer(lantern.get(), RenderType.cutout());
		}
	}

	@SuppressWarnings("unchecked")
	@SubscribeEvent
	public void onClientSetupEvent(FMLClientSetupEvent event) {
		for (ContainerType<?> container : ChippedContainerType.CONTAINER.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
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
