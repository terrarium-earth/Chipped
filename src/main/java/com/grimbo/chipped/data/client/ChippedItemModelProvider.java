package com.grimbo.chipped.data.client;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class ChippedItemModelProvider extends ItemModelProvider {

	public ChippedItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Chipped.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		//Any blocks which has a custom model and does not need an auto generated one
		ArrayList<String> custom = new ArrayList<String>();
		
		custom.add("vine");
		
		custom.add("glass_pane");
		for (int i = 1; i <= ChippedBlocks.blocksMap.get("glass_pane").size(); i++) {
			List<RegistryObject<Block>> blocks = ChippedBlocks.blocksMap.get("glass_pane");
			String block = blocks.get(i).getId().getPath();
			withExistingParent(block, mcLoc("generated")).texture("layer0", modLoc("block/" + block));
		}
		
		for (String color : ChippedBlocks.colorsList) {
			custom.add(color + "_stained_glass_pane");
			for (int i = 1; i <= ChippedBlocks.blocksMap.get(color + "_stained_glass_pane").size(); i++) {
				withExistingParent(color + "_stained_glass_pane_" + i, mcLoc("generated")).texture("layer0", modLoc("block/" + color + "_stained_glass_" + i));
			}
		}

		custom.add("redstone_torch");
		for (int i = 2; i <=6 ; i++) {
			withExistingParent("redstone_torch_" + i, mcLoc("generated")).texture("layer0", modLoc("block/redstone_torch_"+ i));
		}
		custom.add("torch");
		for (int i = 1; i <=9 ; i++) {
			withExistingParent("torch_" + i, mcLoc("generated")).texture("layer0", modLoc("block/torch_"+ i));
		}
		custom.add("soul_lantern");
		for (int i = 1; i <=11 ; i++) {
			withExistingParent("soul_lantern_" + i, mcLoc("generated")).texture("layer0", modLoc("item/soul_lantern_"+ i));
		}
		custom.add("lantern");
		for (int i = 1; i <=14 ; i++) {
			withExistingParent("lantern_" + i, mcLoc("generated")).texture("layer0", modLoc("item/lantern_"+ i));
		}
		for (int i = 1; i <=4 ; i++) {
			withExistingParent("special_lantern_" + i, mcLoc("generated")).texture("layer0", modLoc("item/special_lantern_"+ i));
		}
		for (int i = 1; i <=4 ; i++) {
			withExistingParent("special_soul_lantern_" + i, mcLoc("generated")).texture("layer0", modLoc("item/special_soul_lantern_"+ i));
		}

		custom.add("jack_o_lantern");
		custom.add("carved_pumpkin");
		custom.add("wall_torch");
		custom.add("redstone_wall_torch");
		custom.add("special_lantern");
		custom.add("special_soul_lantern");

		for (String type : ChippedBlocks.blocksMap.keySet()) {
			if (!custom.contains(type)) {
				for (RegistryObject<Block> block : ChippedBlocks.blocksMap.get(type)) {
					String name = block.getId().getPath();
					withExistingParent(name, modLoc("block/" + name));
				}
			}
		}
	}
}
