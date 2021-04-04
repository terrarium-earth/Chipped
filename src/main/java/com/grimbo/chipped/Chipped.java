package com.grimbo.chipped;

import com.grimbo.chipped.block.ModBlocks;
import com.grimbo.chipped.item.ModItems;
import com.grimbo.chipped.util.Registration;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Chipped.MOD_ID)
public class Chipped
{
    // Directly reference a log4j logger.
    public static final String MOD_ID = "chipped";
    public static final ItemGroup CHIPPED = new ItemGroup("chippedTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.BLACK_WOOL_1.get());
        }
    };
    private static final Logger LOGGER = LogManager.getLogger();

    public Chipped() {
        Registration.register();
        ModBlocks.register();
        ModItems.register();
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        // Black Stained Glass
        RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLACK_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Blue SG
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUE_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUE_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUE_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUE_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUE_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUE_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUE_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUE_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Brown SG
        RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Cyan SG
        RenderTypeLookup.setRenderLayer(ModBlocks.CYAN_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.CYAN_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.CYAN_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.CYAN_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.CYAN_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.CYAN_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.CYAN_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.CYAN_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Purple SG
        RenderTypeLookup.setRenderLayer(ModBlocks.PURPLE_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PURPLE_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PURPLE_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PURPLE_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PURPLE_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PURPLE_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PURPLE_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PURPLE_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Gray SG
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAY_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAY_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAY_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAY_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAY_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAY_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAY_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GRAY_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Green SG
        RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.GREEN_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Yellow SG
        RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Light Blue SG
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_BLUE_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_BLUE_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_BLUE_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_BLUE_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_BLUE_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_BLUE_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_BLUE_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_BLUE_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Light Gray SG
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_GRAY_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_GRAY_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_GRAY_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_GRAY_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_GRAY_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_GRAY_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_GRAY_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_GRAY_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Lime SG
        RenderTypeLookup.setRenderLayer(ModBlocks.LIME_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIME_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIME_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIME_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIME_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIME_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIME_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIME_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Magenta SG
        RenderTypeLookup.setRenderLayer(ModBlocks.MAGENTA_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.MAGENTA_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.MAGENTA_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.MAGENTA_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.MAGENTA_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.MAGENTA_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.MAGENTA_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.MAGENTA_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Orange SG
        RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Pink SG
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Red SG
        RenderTypeLookup.setRenderLayer(ModBlocks.RED_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.RED_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.RED_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.RED_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.RED_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.RED_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.RED_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.RED_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // White SG
        RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Vines
        RenderTypeLookup.setRenderLayer(ModBlocks.VINE_1.get(), RenderType.getTranslucent());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
