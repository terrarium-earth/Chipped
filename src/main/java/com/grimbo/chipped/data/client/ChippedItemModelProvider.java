package com.grimbo.chipped.data.client;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.api.ChippedBlockType;
import com.grimbo.chipped.block.ChippedBlocks;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.DyeColor;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

import java.util.Collection;
import java.util.List;

import static com.grimbo.chipped.block.ChippedBlockTypes.*;

public class ChippedItemModelProvider extends ItemModelProvider {

	public ChippedItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Chipped.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		List<RegistryObject<PaneBlock>> blocks = GLASS_PANES.getBlocks();
		for (int i = 0; i < blocks.size(); ++i) {
			RegistryObject<PaneBlock> glassPane = blocks.get(i);
			String block = glassPane.getId().getPath();
			withExistingParent(block, mcLoc("generated")).texture("layer0", modLoc("block/" + GLASSES + "/" + GLASSES.getBlocks().get(i).getId().getPath()));
		}

		for (int id = 0; id < 16; id++) {
			DyeColor color = DyeColor.byId(id);
			List<RegistryObject<StainedGlassPaneBlock>> glassPanes = STAINED_GLASS_PANES.get(color).getBlocks();
			List<RegistryObject<StainedGlassBlock>> glasses = STAINED_GLASSES.get(color).getBlocks();
			for (int i = 0; i < glassPanes.size(); ++i) {
				RegistryObject<StainedGlassPaneBlock> glass = glassPanes.get(i);
				withExistingParent(glass.getId().getPath(), mcLoc("generated")).texture("layer0", modLoc("block/" + STAINED_GLASSES.get(color) + "/" + glasses.get(i).getId().getPath()));
			}
		}

		for (int i = 2; i <= 6; i++) {
			withExistingParent("redstone_torch_" + i, mcLoc("generated")).texture("layer0", modLoc("block/redstone_torch/redstone_torch_" + i));
		}

		for (int i = 1; i <= 9; i++) {
			withExistingParent("torch_" + i, mcLoc("generated")).texture("layer0", modLoc("block/torch/torch_" + i));
		}

		for (int i = 1; i <= 11; i++) {
			withExistingParent("soul_lantern_" + i, mcLoc("generated")).texture("layer0", modLoc("item/soul_lantern/soul_lantern_" + i));
		}

		for (int i = 1; i <= 14; i++) {
			withExistingParent("lantern_" + i, mcLoc("generated")).texture("layer0", modLoc("item/lantern/lantern_" + i));
		}

		for (int i = 1; i <= 4; i++) {
			withExistingParent("special_lantern_" + i, mcLoc("generated")).texture("layer0", modLoc("item/special_lantern/special_lantern_" + i));
		}

		for (int i = 1; i <= 4; i++) {
			withExistingParent("special_soul_lantern_" + i, mcLoc("generated")).texture("layer0", modLoc("item/special_soul_lantern/special_soul_lantern_" + i));
		}

		for (int i = 1; i <= 15; i++) {
			withExistingParent("brown_mushroom_" + i, mcLoc("generated")).texture("layer0", modLoc("item/brown_mushroom/brown_mushroom_" + i));
		}

		for (int i = 1; i <= 15; i++) {
			withExistingParent("red_mushroom_" + i, mcLoc("generated")).texture("layer0", modLoc("item/red_mushroom/red_mushroom_" + i));
		}

		for (int i = 1; i <= 14; i++) {
			withExistingParent("warped_fungus_" + i, mcLoc("generated")).texture("layer0", modLoc("item/warped_fungus/warped_fungus_" + i));
		}

		for (int i = 1; i <= 15; i++) {
			withExistingParent("crimson_fungus_" + i, mcLoc("generated")).texture("layer0", modLoc("item/crimson_fungus/crimson_fungus_" + i));
		}

		for (int i = 1; i <= 9; i++) {
			withExistingParent("warped_roots_" + i, mcLoc("generated")).texture("layer0", modLoc("item/warped_roots/warped_roots_" + i));
		}

		for (int i = 1; i <= 14; i++) {
			withExistingParent("crimson_roots_" + i, mcLoc("generated")).texture("layer0", modLoc("item/crimson_roots/crimson_roots_" + i));
		}

		for (int i = 1; i <= 20; i++) {
			withExistingParent("nether_sprouts_" + i, mcLoc("generated")).texture("layer0", modLoc("item/nether_sprouts/nether_sprouts_" + i));
		}

		for (int i = 1; i <= 6; i++) {
			withExistingParent("lily_pad_" + i, mcLoc("generated")).texture("layer0", modLoc("item/lily_pad/lily_pad_" + i));
		}

		for (int i = 9; i <= 17; i++) {
			withExistingParent("vine_" + i, mcLoc("generated")).texture("layer0", modLoc("block/vine/vine_" + i));
		}

		for (RegistryObject<WebBlock> block : COBWEBS.getBlocks()) {
			withExistingParent(block.getId().getPath(), mcLoc("generated")).texture("layer0", modLoc("block/" + COBWEBS + "/" + block.getId().getPath()));
		}

		applyDefault(
				GLASSES, STONE, COBBLESTONE, OBSIDIAN, CRYING_OBSIDIAN, HAY_BLOCKS,
				MELONS, END_STONE, NETHERRACK, GILDED_BLACKSTONES, BLACKSTONES, CLAYS,
				GLOWSTONES, SEA_LANTERNS, SHROOMLIGHTS, CARVED_PUMPKINS, REDSTONE_LAMPS, JACK_O_LANTERNS, BROWN_MUSHROOM_BLOCK, RED_MUSHROOM_BLOCK,
				WARPED_WART_BLOCK, NETHER_WART_BLOCK, SOUL_SANDS, DRIED_KELP_BLOCKS, MOSSY_COBBLESTONE, ANDESITE,
				DIORITE, BASALT, MOSSY_STONE_BRICKS, BRICKS, ANCIENT_DEBRIS, BLUE_ICE
		);

		applyDefault(PLANKS.values());
		applyDefault(TERRACOTTAS.values());
		applyDefault(CONCRETES.values());
		applyDefault(STAINED_GLASSES.values());
		applyDefault(WOOL.values());
		applyDefault(CARPETS.values());


		//Special Pumpkins + First 3
		List<RegistryObject<PumpkinBlock>> pumpkin_blocks = PUMPKINS.getBlocks();
		for (int i = 1; i <= ChippedBlocks.specialPumpkinList.length + 3; i++) {
			RegistryObject<PumpkinBlock> block = pumpkin_blocks.get(i - 1);
			String name = block.getId().getPath();
			withExistingParent(name, modLoc("block/" + name));
		}
		//Rest of Pumpkins
		for (int i =  ChippedBlocks.specialPumpkinList.length + 4; i <= pumpkin_blocks.size(); i++) {
			RegistryObject<PumpkinBlock> block = pumpkin_blocks.get(i - 1);
			String name = block.getId().getPath();
			withExistingParent(name, modLoc("block/" + PUMPKINS + "s/" + name));
		}
	}

	private void applyDefault(ChippedBlockType<?>... blockLists) {
		for (ChippedBlockType<?> blockList : blockLists) {
			for (RegistryObject<? extends Block> block : blockList) {
				String name = block.getId().getPath();
				withExistingParent(name, modLoc("block/" + name));
			}
		}
	}

	private <T extends Block> void applyDefault(Collection<ChippedBlockType<T>> blockLists) {
		for (ChippedBlockType<T> blockList : blockLists) {
			for (RegistryObject<? extends Block> block : blockList) {
				String name = block.getId().getPath();
				withExistingParent(name, modLoc("block/" + name));
			}
		}
	}
}
