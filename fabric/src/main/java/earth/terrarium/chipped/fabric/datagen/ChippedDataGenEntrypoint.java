package earth.terrarium.chipped.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ChippedDataGenEntrypoint implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		// Client
		fabricDataGenerator.addProvider(ChippedModelProvider::new);

		// Server
		fabricDataGenerator.addProvider(ChippedBlockLootTableProvider::new);
		fabricDataGenerator.addProvider(ChippedItemTagProvider::new);
		fabricDataGenerator.addProvider(ChippedBlockTagProvider::new);
	}
}
