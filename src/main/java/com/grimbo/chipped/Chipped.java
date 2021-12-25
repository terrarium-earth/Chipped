package com.grimbo.chipped;

import com.grimbo.chipped.block.*;
import com.grimbo.chipped.container.*;
import com.grimbo.chipped.item.ChippedItems;
import com.grimbo.chipped.recipe.ChippedSerializer;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.core.Direction;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

@Mod(Chipped.MOD_ID)
public class Chipped {
	public static final String MOD_ID = "chipped";
	public static final CreativeModeTab CHIPPED = (new CreativeModeTab("chippedTab") {
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
		if (event.getPlayer().getMainHandItem().getItem() instanceof SwordItem && event.getTargetBlock().getBlock() instanceof WebBlock) {
			event.setCanHarvest(true);
		}
	}

	@SubscribeEvent
	public void clientRender(final FMLClientSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(ChippedBlocks.BOTANIST_WORKBENCH.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ChippedBlocks.LOOM_TABLE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ChippedBlocks.ALCHEMY_BENCH.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ChippedBlocks.MECHANIST_WORKBENCH.get(), RenderType.cutout());

		for (RegistryObject<GlassBlock> glass : ChippedBlockTypes.GLASSES) {
			ItemBlockRenderTypes.setRenderLayer(glass.get(), RenderType.cutout());
		}

		for (RegistryObject<IronBarsBlock> glassPane : ChippedBlockTypes.GLASS_PANES) {
			ItemBlockRenderTypes.setRenderLayer(glassPane.get(), RenderType.cutout());
		}

		for (int id = 0; id < 16; id++) {
			DyeColor color = DyeColor.byId(id);
			for (RegistryObject<StainedGlassBlock> stainedGlass : ChippedBlockTypes.STAINED_GLASSES.get(color)) {
				ItemBlockRenderTypes.setRenderLayer(stainedGlass.get(), RenderType.translucent());
			}

			for (RegistryObject<StainedGlassPaneBlock> stainedGlassPane : ChippedBlockTypes.STAINED_GLASS_PANES.get(color)) {
				ItemBlockRenderTypes.setRenderLayer(stainedGlassPane.get(), RenderType.translucent());
			}
		}

		for (RegistryObject<VineBlock> vine : ChippedBlockTypes.VINES) {
			ItemBlockRenderTypes.setRenderLayer(vine.get(), RenderType.translucent());
		}

		for (RegistryObject<MushroomBlock> brown_mushroom : ChippedBlockTypes.BROWN_MUSHROOMS) {
			ItemBlockRenderTypes.setRenderLayer(brown_mushroom.get(), RenderType.translucent());
		}

		for (RegistryObject<MushroomBlock> red_mushroom : ChippedBlockTypes.RED_MUSHROOMS) {
			ItemBlockRenderTypes.setRenderLayer(red_mushroom.get(), RenderType.translucent());
		}

		for (RegistryObject<MushroomBlock> warped_fungus : ChippedBlockTypes.WARPED_FUNGUS) {
			ItemBlockRenderTypes.setRenderLayer(warped_fungus.get(), RenderType.translucent());
		}

		for (RegistryObject<MushroomBlock> crimson_fungus : ChippedBlockTypes.CRIMSON_FUNGUS) {
			ItemBlockRenderTypes.setRenderLayer(crimson_fungus.get(), RenderType.translucent());
		}

		for (RegistryObject<RootsBlock> warped_roots : ChippedBlockTypes.WARPED_ROOTS) {
			ItemBlockRenderTypes.setRenderLayer(warped_roots.get(), RenderType.translucent());
		}

		for (RegistryObject<RootsBlock> crimson_roots : ChippedBlockTypes.CRIMSON_ROOTS) {
			ItemBlockRenderTypes.setRenderLayer(crimson_roots.get(), RenderType.translucent());
		}

		for (RegistryObject<NetherSproutsBlock> nether_sprouts : ChippedBlockTypes.NETHER_SPROUTS) {
			ItemBlockRenderTypes.setRenderLayer(nether_sprouts.get(), RenderType.translucent());
		}

		for (RegistryObject<ChippedLilyPadBlock> lily_pad : ChippedBlockTypes.LILY_PAD) {
			ItemBlockRenderTypes.setRenderLayer(lily_pad.get(), RenderType.translucent());
		}

		for (RegistryObject<RedstoneTorchBlock> redstoneTorch : ChippedBlockTypes.REDSTONE_TORCHES) {
			ItemBlockRenderTypes.setRenderLayer(redstoneTorch.get(), RenderType.cutout());
		}

		for (RegistryObject<RedstoneWallTorchBlock> redstoneWallTorch : ChippedBlocks.REDSTONE_WALL_TORCHES) {
			ItemBlockRenderTypes.setRenderLayer(redstoneWallTorch.get(), RenderType.cutout());
		}

		for (RegistryObject<WebBlock> cobweb : ChippedBlockTypes.COBWEBS) {
			ItemBlockRenderTypes.setRenderLayer(cobweb.get(), RenderType.cutout());
		}

		for (RegistryObject<TorchBlock> torch : ChippedBlockTypes.TORCHES) {
			ItemBlockRenderTypes.setRenderLayer(torch.get(), RenderType.cutout());
		}

		for (RegistryObject<WallTorchBlock> wallTorch : ChippedBlocks.WALL_TORCHES) {
			ItemBlockRenderTypes.setRenderLayer(wallTorch.get(), RenderType.cutout());
		}

		for (RegistryObject<Block> lantern : ChippedBlockTypes.LANTERNS) {
			ItemBlockRenderTypes.setRenderLayer(lantern.get(), RenderType.cutout());
		}

		for (RegistryObject<Block> lantern : ChippedBlockTypes.SOUL_LANTERNS) {
			ItemBlockRenderTypes.setRenderLayer(lantern.get(), RenderType.cutout());
		}
	}

	@SuppressWarnings("unchecked")
	@SubscribeEvent
	public void onClientSetupEvent(FMLClientSetupEvent event) {
		for (MenuType<?> container : ChippedContainerType.CONTAINER.getEntries().stream().map(RegistryObject::get).toList()) {
			MenuScreens.register((MenuType<ChippedContainer>) container, ChippedScreen::new);
		}
	}

	public static int getTorchAngleFromDir(Direction direction) {
		return switch (direction) {
			case WEST:
				yield 180;
			case NORTH:
				yield 270;
			case SOUTH:
				yield 90;
			default:
				yield 0;
		};
	}

	public static int getAngleFromDir(Direction direction) {
		return switch (direction) {
			case WEST:
				yield 270;
			case SOUTH:
				yield 180;
			case EAST:
				yield 90;
			default:
				yield 0;
		};
	}
}
