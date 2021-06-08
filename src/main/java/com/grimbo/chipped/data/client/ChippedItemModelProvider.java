package com.grimbo.chipped.data.client;

import java.util.ArrayList;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedBlocks;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ChippedItemModelProvider extends ItemModelProvider {

	public ChippedItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Chipped.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		//Any blocks which has a custom model and does not need an auto generated one
		ArrayList<String> custom = new ArrayList<String>();
		custom.add("vine");
		for (int i = 1; i <= ChippedBlocks.blocksMap.get("vine").size(); i++) {
			withExistingParent("vine_" + i, mcLoc("generated")).texture("layer0", modLoc("block/vine_" + i));
		}
		
		custom.add("glass_pane");
		for (int i = 1; i <= ChippedBlocks.blocksMap.get("glass_pane").size(); i++) {
			withExistingParent("glass_pane_" + i, mcLoc("generated")).texture("layer0", modLoc("block/glass_" + i));
		}
		
		for (String color : ChippedBlocks.colorsList) {
			custom.add(color + "_stained_glass_pane");
			for (int i = 1; i <= ChippedBlocks.blocksMap.get(color + "_stained_glass_pane").size(); i++) {
				withExistingParent(color + "_stained_glass_pane_" + i, mcLoc("generated")).texture("layer0", modLoc("block/" + color + "_stained_glass_" + i));
			}
		}
		
		for (String wood : ChippedBlocks.woodsList) {
			custom.add(wood + "_wood_glass_pane");
			for (int i = 1; i <= ChippedBlocks.blocksMap.get(wood + "_wood_glass_pane").size(); i++) {
				withExistingParent(wood + "_wood_glass_pane_" + i, mcLoc("generated")).texture("layer0", modLoc("block/" + wood + "_wood_glass_" + i));
			}
		}
		
		for (String type : ChippedBlocks.blocksMap.keySet()) {
			if (!custom.contains(type)) {
				for (RegistryObject<Block> block : ChippedBlocks.blocksMap.get(type)) {
					String name = block.get().getRegistryName().getPath();
					withExistingParent(name, modLoc("block/" + name));
				}
			}
		}
	}
}
