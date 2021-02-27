package com.grimbo.chipped.block;

import com.grimbo.chipped.util.Registration;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {



    private  static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
    Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
            new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    return toReturn;

    }
}
