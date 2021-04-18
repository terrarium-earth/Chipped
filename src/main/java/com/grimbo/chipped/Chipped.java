package com.grimbo.chipped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.container.ChippedContainerType;
import com.grimbo.chipped.container.ChippedScreen;
import com.grimbo.chipped.item.ChippedItems;
import com.grimbo.chipped.recipe.ChippedSerializer;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Chipped.MOD_ID)
public class Chipped
{
    public static final String MOD_ID = "chipped";
    public static final ItemGroup CHIPPED = new ItemGroup("chippedTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ChippedBlocks.wools.get(0).get());
        }
    };

    private static final Logger LOGGER = LogManager.getLogger();

    public Chipped() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ChippedBlocks.BLOCKS.register(eventBus);
        ChippedBlocks.register();
        ChippedItems.ITEMS.register(eventBus);
        ChippedSerializer.SERIALIZER.register(eventBus);
        ChippedContainerType.CONTAINER.register(eventBus);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ChippedBlocks::clientRender);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetupEvent);
        MinecraftForge.EVENT_BUS.register(this);
    }

    //Register containers and screens together here
    @SubscribeEvent
	public void onClientSetupEvent(FMLClientSetupEvent event) {
    	ScreenManager.registerFactory(ChippedContainerType.BOTANIST_WORKBENCH.get(), ChippedScreen::new);
        ScreenManager.registerFactory(ChippedContainerType.GLASSBLOWER.get(), ChippedScreen::new);
        ScreenManager.registerFactory(ChippedContainerType.CARPENTERS_TABLE.get(), ChippedScreen::new);
        ScreenManager.registerFactory(ChippedContainerType.LOOM_TABLE.get(), ChippedScreen::new);
        ScreenManager.registerFactory(ChippedContainerType.MASON_TABLE.get(), ChippedScreen::new);
    }
}



