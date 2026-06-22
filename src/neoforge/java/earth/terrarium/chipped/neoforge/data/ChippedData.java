package earth.terrarium.chipped.neoforge.data;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = "chipped")
public class ChippedData {
    @SubscribeEvent
    public static void gatherServerData(GatherDataEvent.Server event) {
        var generator = event.getGenerator();

        generator.addProvider(new ChippedBlockTags(generator, existingFileHelper));
        generator.addProvider(new ChippedItemTags(generator, existingFileHelper));
    }

    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        var generator = event.getGenerator();

        generator.addProvider(new ChippedBlockStates(generator, existingFileHelper));
        generator.addProvider(new ChippedItemModels(generator, existingFileHelper));
    }
}
