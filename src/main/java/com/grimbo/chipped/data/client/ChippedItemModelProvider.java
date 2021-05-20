package com.grimbo.chipped.data.client;

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
		String[] custom = {"vine"};
		
		for (String type : ChippedBlocks.blocksMap.keySet()) {
			for (String skip : custom) {
				if (!type.equals(skip)) {
					for (RegistryObject<Block> block : ChippedBlocks.blocksMap.get(type)) {
						String name = block.get().getRegistryName().getPath();
						withExistingParent(name, modLoc("block/" + name));
					}
				}
			}
		}
	}
}
