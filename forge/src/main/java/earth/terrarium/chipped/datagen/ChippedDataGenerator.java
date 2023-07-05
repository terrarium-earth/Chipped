package earth.terrarium.chipped.datagen;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.datagen.provider.MinifiedProvider;
import earth.terrarium.chipped.datagen.provider.client.*;
import earth.terrarium.chipped.datagen.provider.server.ModBlockTagProvider;
import earth.terrarium.chipped.datagen.provider.server.ModItemTagProvider;
import earth.terrarium.chipped.datagen.provider.server.ModLootTableProvider;
import earth.terrarium.chipped.datagen.provider.server.ModRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Chipped.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ChippedDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // Client
        var packOutput = generator.getPackOutput();
        ModBlockStateProvider stateProvider = new ModBlockStateProvider(packOutput, existingFileHelper);
        addProvider(generator, event.includeClient(), stateProvider);
        addProvider(generator, event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        addProvider(generator, event.includeClient(), new ModLangProvider(packOutput));
        ModCtmTextureProvider textures = new ModCtmTextureProvider(packOutput, existingFileHelper);
        generator.addProvider(event.includeClient(), textures);
        addProvider(generator, event.includeClient(), new ModCtmModelProvider(packOutput, stateProvider, textures));

        // Server
        addProvider(generator, event.includeServer(), new ModLootTableProvider(packOutput));
        addProvider(generator, event.includeServer(), new ModRecipeProvider(packOutput));

        var lookupProvider = event.getLookupProvider();
        ModBlockTagProvider blockTags = new ModBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        addProvider(generator, event.includeServer(), blockTags);
        addProvider(generator, event.includeServer(), new ModItemTagProvider(packOutput, lookupProvider, blockTags.contentsGetter(), existingFileHelper));
    }

    private static void addProvider(DataGenerator generator, boolean condition, DataProvider provider) {
        generator.addProvider(condition, new MinifiedProvider(provider));
    }
}
