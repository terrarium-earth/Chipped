package com.grimbo.chipped.block;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> BLACK_WOOL_1 = register("black_wool_1",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_WOOL_2 = register("black_wool_2",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_WOOL_3 = register("black_wool_3",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_WOOL_4 = register("black_wool_4",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_WOOL_5 = register("black_wool_5",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_WOOL_6 = register("black_wool_6",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_WOOL_7 = register("black_wool_7",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_WOOL_8 = register("black_wool_8",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_WOOL_9 = register("black_wool_9",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_WOOL_10 = register("black_wool_10",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_WOOL_11 = register("black_wool_11",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_WOOL_12 = register("black_wool_12",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_WOOL_13 = register("black_wool_13",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_WOOL_14 = register("black_wool_14",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_WOOL_15 = register("black_wool_15",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_WOOL_16 = register("black_wool_16",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_WOOL_17 = register("black_wool_17",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_WOOL_18 = register("black_wool_18",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));




    public static void register() {}


    private  static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
    Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
            new Item.Properties().group(Chipped.CHIPPED)));
    return toReturn;

    }
}
