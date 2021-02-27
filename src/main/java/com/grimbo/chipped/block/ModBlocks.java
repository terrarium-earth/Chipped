package com.grimbo.chipped.block;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> BLACK_WOOL_1 = register("black_wool_1",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(2f, 4f).sound(SoundType.SNOW)));

    public static final RegistryObject<Block> BLACK_WOOL_2 = register("black_wool_2",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(2f, 4f).sound(SoundType.SNOW)));

    public static void register() {}


    private  static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
    Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
            new Item.Properties().group(Chipped.CHIPPED)));
    return toReturn;

    }
}
