package com.grimbo.chipped;

import com.grimbo.chipped.block.ChippedBlockTypes;
import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.container.ChippedContainer;
import com.grimbo.chipped.container.ChippedContainerType;
import com.grimbo.chipped.container.ChippedScreen;
import com.grimbo.chipped.item.ChippedItems;
import com.grimbo.chipped.recipe.ChippedSerializer;
import net.minecraft.block.*;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.*;
import net.minecraft.util.Direction;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
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
	public void checkHarvest(PlayerEvent.HarvestCheck event) {
		Item held = event.getPlayer().getMainHandItem().getItem();
		if ((held instanceof SwordItem || held instanceof ShearsItem) && event.getTargetBlock().getBlock() instanceof WebBlock) {
			event.setCanHarvest(true);
		}
	}

	@SubscribeEvent
	public void clientRender(final FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(ChippedBlocks.CARPENTERS_TABLE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(ChippedBlocks.BOTANIST_WORKBENCH.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(ChippedBlocks.LOOM_TABLE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(ChippedBlocks.ALCHEMY_BENCH.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(ChippedBlocks.MECHANIST_WORKBENCH.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(ChippedBlocks.MASON_TABLE.get(), RenderType.translucent());
		RenderTypeLookup.setRenderLayer(ChippedBlocks.GLASSBLOWER.get(), RenderType.translucent());



		for (RegistryObject<GlassBlock> glass : ChippedBlockTypes.GLASSES) {
			RenderTypeLookup.setRenderLayer(glass.get(), RenderType.cutout());
		}

		for (RegistryObject<PaneBlock> glassPane : ChippedBlockTypes.GLASS_PANES) {
			RenderTypeLookup.setRenderLayer(glassPane.get(), RenderType.cutout());
		}

		for (int id = 0; id < 16; id++) {
			DyeColor color = DyeColor.byId(id);
			for (RegistryObject<StainedGlassBlock> stainedGlass : ChippedBlockTypes.STAINED_GLASSES.get(color)) {
				RenderTypeLookup.setRenderLayer(stainedGlass.get(), RenderType.translucent());
			}

			for (RegistryObject<StainedGlassPaneBlock> stainedGlassPane : ChippedBlockTypes.STAINED_GLASS_PANES.get(color)) {
				RenderTypeLookup.setRenderLayer(stainedGlassPane.get(), RenderType.translucent());
			}
		}

		for (RegistryObject<VineBlock> vine : ChippedBlockTypes.VINES) {
			RenderTypeLookup.setRenderLayer(vine.get(), RenderType.cutout());
		}

		for (RegistryObject<MushroomBlock> brown_mushroom : ChippedBlockTypes.BROWN_MUSHROOMS) {
			RenderTypeLookup.setRenderLayer(brown_mushroom.get(), RenderType.cutout());
		}

		for (RegistryObject<MushroomBlock> red_mushroom : ChippedBlockTypes.RED_MUSHROOMS) {
			RenderTypeLookup.setRenderLayer(red_mushroom.get(), RenderType.cutout());
		}

		for (RegistryObject<MushroomBlock> warped_fungus : ChippedBlockTypes.WARPED_FUNGUS) {
			RenderTypeLookup.setRenderLayer(warped_fungus.get(), RenderType.cutout());
		}

		for (RegistryObject<MushroomBlock> crimson_fungus : ChippedBlockTypes.CRIMSON_FUNGUS) {
			RenderTypeLookup.setRenderLayer(crimson_fungus.get(), RenderType.cutout());
		}

		for (RegistryObject<NetherRootsBlock> warped_roots : ChippedBlockTypes.WARPED_ROOTS) {
			RenderTypeLookup.setRenderLayer(warped_roots.get(), RenderType.cutout());
		}

		for (RegistryObject<NetherRootsBlock> crimson_roots : ChippedBlockTypes.CRIMSON_ROOTS) {
			RenderTypeLookup.setRenderLayer(crimson_roots.get(), RenderType.cutout());
		}

		for (RegistryObject<NetherSproutsBlock> nether_sprouts : ChippedBlockTypes.NETHER_SPROUTS) {
			RenderTypeLookup.setRenderLayer(nether_sprouts.get(), RenderType.cutout());
		}

		for (RegistryObject<LilyPadBlock> lily_pad : ChippedBlockTypes.LILY_PAD) {
			RenderTypeLookup.setRenderLayer(lily_pad.get(), RenderType.cutout());
		}

		for (RegistryObject<RedstoneTorchBlock> redstoneTorch : ChippedBlockTypes.REDSTONE_TORCHES) {
			RenderTypeLookup.setRenderLayer(redstoneTorch.get(), RenderType.cutout());
		}

		for (RegistryObject<RedstoneWallTorchBlock> redstoneWallTorch : ChippedBlocks.REDSTONE_WALL_TORCHES) {
			RenderTypeLookup.setRenderLayer(redstoneWallTorch.get(), RenderType.cutout());
		}

		for (RegistryObject<WebBlock> cobweb : ChippedBlockTypes.COBWEBS) {
			RenderTypeLookup.setRenderLayer(cobweb.get(), RenderType.cutout());
		}

		for (RegistryObject<TorchBlock> torch : ChippedBlockTypes.TORCHES) {
			RenderTypeLookup.setRenderLayer(torch.get(), RenderType.cutout());
		}

		for (RegistryObject<WallTorchBlock> wallTorch : ChippedBlocks.WALL_TORCHES) {
			RenderTypeLookup.setRenderLayer(wallTorch.get(), RenderType.cutout());
		}

		for (RegistryObject<Block> lantern : ChippedBlockTypes.LANTERNS) {
			RenderTypeLookup.setRenderLayer(lantern.get(), RenderType.cutout());
		}

		for (RegistryObject<Block> lantern : ChippedBlockTypes.SOUL_LANTERNS) {
			RenderTypeLookup.setRenderLayer(lantern.get(), RenderType.cutout());
		}
		for (RegistryObject<Block> ice : ChippedBlockTypes.ICE) {
			RenderTypeLookup.setRenderLayer(ice.get(), RenderType.translucent());
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
