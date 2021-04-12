package com.grimbo.chipped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.grimbo.chipped.block.ChippedBlocks;
import com.grimbo.chipped.item.ChippedItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Chipped.MOD_ID)
public class Chipped
{
    public static final String MOD_ID = "chipped";
    public static final ItemGroup CHIPPED = new ItemGroup("chippedTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ChippedBlocks.BLACK_WOOL_1.get());
        }
    };
    
    private static final Logger LOGGER = LogManager.getLogger();

    public Chipped() {
    	IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ChippedBlocks.BLOCKS.register(eventBus);
        ChippedItems.ITEMS.register(eventBus);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ChippedBlocks::clientRender);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
