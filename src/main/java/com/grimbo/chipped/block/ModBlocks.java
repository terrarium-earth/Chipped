package com.grimbo.chipped.block;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.util.Registration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.function.Supplier;

import static javafx.scene.input.KeyCode.V;
@Mod.EventBusSubscriber(modid = Chipped.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModBlocks {

    // Black Wool 18 Variations

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

    // Blue Wool 18 Variations

    public static final RegistryObject<Block> BLUE_WOOL_1 = register("blue_wool_1",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_WOOL_2 = register("blue_wool_2",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_WOOL_3 = register("blue_wool_3",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_WOOL_4 = register("blue_wool_4",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_WOOL_5 = register("blue_wool_5",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_WOOL_6 = register("blue_wool_6",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_WOOL_7 = register("blue_wool_7",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_WOOL_8 = register("blue_wool_8",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_WOOL_9 = register("blue_wool_9",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_WOOL_10 = register("blue_wool_10",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_WOOL_11 = register("blue_wool_11",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_WOOL_12 = register("blue_wool_12",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_WOOL_13 = register("blue_wool_13",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_WOOL_14 = register("blue_wool_14",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_WOOL_15 = register("blue_wool_15",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_WOOL_16 = register("blue_wool_16",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_WOOL_17 = register("blue_wool_17",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_WOOL_18 = register("blue_wool_18",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    // Brown Wool 18 Variations

    public static final RegistryObject<Block> BROWN_WOOL_1 = register("brown_wool_1",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_WOOL_2 = register("brown_wool_2",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_WOOL_3 = register("brown_wool_3",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_WOOL_4 = register("brown_wool_4",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_WOOL_5 = register("brown_wool_5",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_WOOL_6 = register("brown_wool_6",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_WOOL_7 = register("brown_wool_7",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_WOOL_8 = register("brown_wool_8",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_WOOL_9 = register("brown_wool_9",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_WOOL_10 = register("brown_wool_10",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_WOOL_11 = register("brown_wool_11",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_WOOL_12 = register("brown_wool_12",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_WOOL_13 = register("brown_wool_13",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_WOOL_14 = register("brown_wool_14",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_WOOL_15 = register("brown_wool_15",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_WOOL_16 = register("brown_wool_16",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_WOOL_17 = register("brown_wool_17",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_WOOL_18 = register("brown_wool_18",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    // Cyan Wool 18 Variations


    public static final RegistryObject<Block> CYAN_WOOL_1 = register("cyan_wool_1",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> CYAN_WOOL_2 = register("cyan_wool_2",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> CYAN_WOOL_3 = register("cyan_wool_3",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> CYAN_WOOL_4 = register("cyan_wool_4",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> CYAN_WOOL_5 = register("cyan_wool_5",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> CYAN_WOOL_6 = register("cyan_wool_6",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_WOOL_7 = register("cyan_wool_7",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_WOOL_8 = register("cyan_wool_8",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_WOOL_9 = register("cyan_wool_9",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_WOOL_10 = register("cyan_wool_10",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_WOOL_11 = register("cyan_wool_11",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_WOOL_12 = register("cyan_wool_12",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_WOOL_13 = register("cyan_wool_13",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_WOOL_14 = register("cyan_wool_14",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_WOOL_15 = register("cyan_wool_15",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_WOOL_16 = register("cyan_wool_16",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_WOOL_17 = register("cyan_wool_17",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_WOOL_18 = register("cyan_wool_18",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    // Purple Wool 18 Variations

    public static final RegistryObject<Block> PURPLE_WOOL_1 = register("purple_wool_1",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_WOOL_2 = register("purple_wool_2",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_WOOL_3 = register("purple_wool_3",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_WOOL_4 = register("purple_wool_4",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_WOOL_5 = register("purple_wool_5",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_WOOL_6 = register("purple_wool_6",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_WOOL_7 = register("purple_wool_7",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_WOOL_8 = register("purple_wool_8",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_WOOL_9 = register("purple_wool_9",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_WOOL_10 = register("purple_wool_10",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_WOOL_11 = register("purple_wool_11",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_WOOL_12 = register("purple_wool_12",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_WOOL_13 = register("purple_wool_13",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_WOOL_14 = register("purple_wool_14",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_WOOL_15 = register("purple_wool_15",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_WOOL_16 = register("purple_wool_16",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_WOOL_17 = register("purple_wool_17",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_WOOL_18 = register("purple_wool_18",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    // 8 Hay Bale Variations

    public static final RegistryObject<Block> HAY_BALE_1 = register("hay_bale_1",
            () -> createHayBlock(MaterialColor.YELLOW, MaterialColor.YELLOW));

    public static final RegistryObject<Block> HAY_BALE_2 = register("hay_bale_2",
            () -> createHayBlock(MaterialColor.YELLOW, MaterialColor.YELLOW));

    public static final RegistryObject<Block> HAY_BALE_3 = register("hay_bale_3",
            () -> createHayBlock(MaterialColor.YELLOW, MaterialColor.YELLOW));

    public static final RegistryObject<Block> HAY_BALE_4 = register("hay_bale_4",
            () -> createHayBlock(MaterialColor.YELLOW, MaterialColor.YELLOW));

    public static final RegistryObject<Block> HAY_BALE_5 = register("hay_bale_5",
            () -> createHayBlock(MaterialColor.YELLOW, MaterialColor.YELLOW));

    public static final RegistryObject<Block> HAY_BALE_6 = register("hay_bale_6",
            () -> createHayBlock(MaterialColor.YELLOW, MaterialColor.YELLOW));

    public static final RegistryObject<Block> HAY_BALE_7 = register("hay_bale_7",
            () -> createHayBlock(MaterialColor.YELLOW, MaterialColor.YELLOW));

    public static final RegistryObject<Block> HAY_BALE_8 = register("hay_bale_8",
            () -> createHayBlock(MaterialColor.YELLOW, MaterialColor.YELLOW));

    // 18 Gray Wool Variations

    public static final RegistryObject<Block> GRAY_WOOL_1 = register("gray_wool_1",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_WOOL_2 = register("gray_wool_2",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_WOOL_3 = register("gray_wool_3",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_WOOL_4 = register("gray_wool_4",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_WOOL_5 = register("gray_wool_5",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_WOOL_6 = register("gray_wool_6",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_WOOL_7 = register("gray_wool_7",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_WOOL_8 = register("gray_wool_8",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_WOOL_9 = register("gray_wool_9",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_WOOL_10 = register("gray_wool_10",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_WOOL_11 = register("gray_wool_11",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_WOOL_12 = register("gray_wool_12",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_WOOL_13 = register("gray_wool_13",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_WOOL_14 = register("gray_wool_14",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_WOOL_15 = register("gray_wool_15",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_WOOL_16 = register("gray_wool_16",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_WOOL_17 = register("gray_wool_17",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_WOOL_18 = register("gray_wool_18",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    // 18 Green Wool Variations

    public static final RegistryObject<Block> GREEN_WOOL_1 = register("green_wool_1",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_WOOL_2 = register("green_wool_2",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_WOOL_3 = register("green_wool_3",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_WOOL_4 = register("green_wool_4",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_WOOL_5 = register("green_wool_5",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_WOOL_6 = register("green_wool_6",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_WOOL_7 = register("green_wool_7",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_WOOL_8 = register("green_wool_8",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_WOOL_9 = register("green_wool_9",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_WOOL_10 = register("green_wool_10",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_WOOL_11 = register("green_wool_11",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_WOOL_12 = register("green_wool_12",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_WOOL_13 = register("green_wool_13",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_WOOL_14 = register("green_wool_14",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_WOOL_15 = register("green_wool_15",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_WOOL_16 = register("green_wool_16",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_WOOL_17 = register("green_wool_17",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_WOOL_18 = register("green_wool_18",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    // 18 Yellow Wool Variations

    public static final RegistryObject<Block> YELLOW_WOOL_1 = register("yellow_wool_1",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_WOOL_2 = register("yellow_wool_2",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_WOOL_3 = register("yellow_wool_3",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_WOOL_4 = register("yellow_wool_4",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_WOOL_5 = register("yellow_wool_5",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_WOOL_6 = register("yellow_wool_6",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_WOOL_7 = register("yellow_wool_7",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_WOOL_8 = register("yellow_wool_8",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_WOOL_9 = register("yellow_wool_9",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_WOOL_10 = register("yellow_wool_10",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_WOOL_11 = register("yellow_wool_11",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_WOOL_12 = register("yellow_wool_12",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_WOOL_13 = register("yellow_wool_13",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_WOOL_14 = register("yellow_wool_14",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_WOOL_15 = register("yellow_wool_15",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_WOOL_16 = register("yellow_wool_16",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_WOOL_17 = register("yellow_wool_17",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_WOOL_18 = register("yellow_wool_18",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    // 18 Light Blue Wool Variations

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_1 = register("light_blue_wool_1",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_2 = register("light_blue_wool_2",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_3 = register("light_blue_wool_3",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_4 = register("light_blue_wool_4",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_5 = register("light_blue_wool_5",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_6 = register("light_blue_wool_6",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_7 = register("light_blue_wool_7",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_8 = register("light_blue_wool_8",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_9 = register("light_blue_wool_9",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_10 = register("light_blue_wool_10",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_11 = register("light_blue_wool_11",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_12 = register("light_blue_wool_12",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_13 = register("light_blue_wool_13",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_14 = register("light_blue_wool_14",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_15 = register("light_blue_wool_15",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_16 = register("light_blue_wool_16",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_17 = register("light_blue_wool_17",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_WOOL_18 = register("light_blue_wool_18",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    // 18 Light Gray Wool Variations

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_1 = register("light_gray_wool_1",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_2 = register("light_gray_wool_2",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_3 = register("light_gray_wool_3",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_4 = register("light_gray_wool_4",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_5 = register("light_gray_wool_5",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_6 = register("light_gray_wool_6",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_7 = register("light_gray_wool_7",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_8 = register("light_gray_wool_8",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_9 = register("light_gray_wool_9",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_10 = register("light_gray_wool_10",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_11 = register("light_gray_wool_11",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_12 = register("light_gray_wool_12",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_13 = register("light_gray_wool_13",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_14 = register("light_gray_wool_14",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_15 = register("light_gray_wool_15",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_16 = register("light_gray_wool_16",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_17 = register("light_gray_wool_17",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_WOOL_18 = register("light_gray_wool_18",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    // 18 Lime Wool Variations

    public static final RegistryObject<Block> LIME_WOOL_1 = register("lime_wool_1",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_WOOL_2 = register("lime_wool_2",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_WOOL_3 = register("lime_wool_3",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_WOOL_4 = register("lime_wool_4",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_WOOL_5 = register("lime_wool_5",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_WOOL_6 = register("lime_wool_6",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_WOOL_7 = register("lime_wool_7",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_WOOL_8 = register("lime_wool_8",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_WOOL_9 = register("lime_wool_9",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_WOOL_10 = register("lime_wool_10",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_WOOL_11 = register("lime_wool_11",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_WOOL_12 = register("lime_wool_12",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_WOOL_13 = register("lime_wool_13",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_WOOL_14 = register("lime_wool_14",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_WOOL_15 = register("lime_wool_15",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_WOOL_16 = register("lime_wool_16",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_WOOL_17 = register("lime_wool_17",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_WOOL_18 = register("lime_wool_18",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    // 18 Magenta Wool
    public static final RegistryObject<Block> MAGENTA_WOOL_1 = register("magenta_wool_1",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_WOOL_2 = register("magenta_wool_2",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> MAGENTA_WOOL_3 = register("magenta_wool_3",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> MAGENTA_WOOL_4 = register("magenta_wool_4",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> MAGENTA_WOOL_5 = register("magenta_wool_5",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> MAGENTA_WOOL_6 = register("magenta_wool_6",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> MAGENTA_WOOL_7 = register("magenta_wool_7",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_WOOL_8 = register("magenta_wool_8",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> MAGENTA_WOOL_9 = register("magenta_wool_9",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_WOOL_10 = register("magenta_wool_10",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_WOOL_11 = register("magenta_wool_11",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> MAGENTA_WOOL_12 = register("magenta_wool_12",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> MAGENTA_WOOL_13 = register("magenta_wool_13",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> MAGENTA_WOOL_14 = register("magenta_wool_14",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_WOOL_15 = register("magenta_wool_15",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> MAGENTA_WOOL_16 = register("magenta_wool_16",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_WOOL_17 = register("magenta_wool_17",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_WOOL_18 = register("magenta_wool_18",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    // 18 Orange Wool
    public static final RegistryObject<Block> ORANGE_WOOL_1 = register("orange_wool_1",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_WOOL_2 = register("orange_wool_2",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> ORANGE_WOOL_3 = register("orange_wool_3",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> ORANGE_WOOL_4 = register("orange_wool_4",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> ORANGE_WOOL_5 = register("orange_wool_5",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_WOOL_6 = register("orange_wool_6",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> ORANGE_WOOL_7 = register("orange_wool_7",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> ORANGE_WOOL_8 = register("orange_wool_8",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_WOOL_9 = register("orange_wool_9",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_WOOL_10 = register("orange_wool_10",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> ORANGE_WOOL_11 = register("orange_wool_11",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> ORANGE_WOOL_12 = register("orange_wool_12",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> ORANGE_WOOL_13 = register("orange_wool_13",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_WOOL_14 = register("orange_wool_14",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> ORANGE_WOOL_15 = register("orange_wool_15",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_WOOL_16 = register("orange_wool_16",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_WOOL_17 = register("orange_wool_17",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_WOOL_18 = register("orange_wool_18",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    // Pink Wool

    public static final RegistryObject<Block> PINK_WOOL_1 = register("pink_wool_1",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_WOOL_2 = register("pink_wool_2",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_WOOL_3 = register("pink_wool_3",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_WOOL_4 = register("pink_wool_4",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_WOOL_5 = register("pink_wool_5",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_WOOL_6 = register("pink_wool_6",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_WOOL_7 = register("pink_wool_7",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_WOOL_8 = register("pink_wool_8",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_WOOL_9 = register("pink_wool_9",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_WOOL_10 = register("pink_wool_10",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_WOOL_11 = register("pink_wool_11",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_WOOL_12 = register("pink_wool_12",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_WOOL_13 = register("pink_wool_13",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_WOOL_14 = register("pink_wool_14",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_WOOL_15 = register("pink_wool_15",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_WOOL_16 = register("pink_wool_16",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_WOOL_17 = register("pink_wool_17",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_WOOL_18 = register("pink_wool_18",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    // Red Wool

    public static final RegistryObject<Block> RED_WOOL_1 = register("red_wool_1",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_WOOL_2 = register("red_wool_2",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_WOOL_3 = register("red_wool_3",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_WOOL_4 = register("red_wool_4",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_WOOL_5 = register("red_wool_5",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_WOOL_6 = register("red_wool_6",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_WOOL_7 = register("red_wool_7",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_WOOL_8 = register("red_wool_8",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_WOOL_9 = register("red_wool_9",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_WOOL_10 = register("red_wool_10",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_WOOL_11 = register("red_wool_11",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_WOOL_12 = register("red_wool_12",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_WOOL_13 = register("red_wool_13",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> RED_WOOL_14 = register("red_wool_14",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> RED_WOOL_15 = register("red_wool_15",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> RED_WOOL_16 = register("red_wool_16",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> RED_WOOL_17 = register("red_wool_17",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_WOOL_18 = register("red_wool_18",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    // White Wool

    public static final RegistryObject<Block> WHITE_WOOL_1 = register("white_wool_1",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_WOOL_2 = register("white_wool_2",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> WHITE_WOOL_3 = register("white_wool_3",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> WHITE_WOOL_4 = register("white_wool_4",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> WHITE_WOOL_5 = register("white_wool_5",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> WHITE_WOOL_6 = register("white_wool_6",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_WOOL_7 = register("white_wool_7",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> WHITE_WOOL_8 = register("white_wool_8",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> WHITE_WOOL_9 = register("white_wool_9",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));


    public static final RegistryObject<Block> WHITE_WOOL_10 = register("white_wool_10",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_WOOL_11 = register("white_wool_11",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_WOOL_12 = register("white_wool_12",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_WOOL_13 = register("white_wool_13",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_WOOL_14 = register("white_wool_14",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_WOOL_15 = register("white_wool_15",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_WOOL_16 = register("white_wool_16",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_WOOL_17 = register("white_wool_17",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_WOOL_18 = register("white_wool_18",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH)));

    // Glass

    public static final RegistryObject<Block> GLASS_1 = register("glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_2 = register("glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_3 = register("glass_3",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_4 = register("glass_4",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_5 = register("glass_5",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_6 = register("glass_6",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_7 = register("glass_7",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_8 = register("glass_8",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_9 = register("glass_9",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_10 = register("glass_10",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_11 = register("glass_11",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_12 = register("glass_12",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_13 = register("glass_13",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_14 = register("glass_14",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Dark Oak Glass

    public static final RegistryObject<Block> DARK_OAK_GLASS_1 = register("dark_oak_glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> DARK_OAK_GLASS_2 = register("dark_oak_glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> DARK_OAK_GLASS_3 = register("dark_oak_glass_3",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> DARK_OAK_GLASS_4 = register("dark_oak_glass_4",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> DARK_OAK_GLASS_5 = register("dark_oak_glass_5",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> DARK_OAK_GLASS_6 = register("dark_oak_glass_6",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Warped Wood Glass

    public static final RegistryObject<Block> WARPED_WOOD_GLASS_1 = register("warped_wood_glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> WARPED_WOOD_GLASS_2 = register("warped_wood_glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> WARPED_WOOD_GLASS_3 = register("warped_wood_glass_3",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> WARPED_WOOD_GLASS_4 = register("warped_wood_glass_4",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> WARPED_WOOD_GLASS_5 = register("warped_wood_glass_5",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> WARPED_WOOD_GLASS_6 = register("warped_wood_glass_6",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Spruce Wood Glass

    public static final RegistryObject<Block> SPRUCE_WOOD_GLASS_1 = register("spruce_wood_glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> SPRUCE_WOOD_GLASS_2 = register("spruce_wood_glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> SPRUCE_WOOD_GLASS_3 = register("spruce_wood_glass_3",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> SPRUCE_WOOD_GLASS_4 = register("spruce_wood_glass_4",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> SPRUCE_WOOD_GLASS_5 = register("spruce_wood_glass_5",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> SPRUCE_WOOD_GLASS_6 = register("spruce_wood_glass_6",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Oak Wood Glass

    public static final RegistryObject<Block> OAK_WOOD_GLASS_1 = register("oak_wood_glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> OAK_WOOD_GLASS_2 = register("oak_wood_glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> OAK_WOOD_GLASS_3 = register("oak_wood_glass_3",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> OAK_WOOD_GLASS_4 = register("oak_wood_glass_4",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> OAK_WOOD_GLASS_5 = register("oak_wood_glass_5",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> OAK_WOOD_GLASS_6 = register("oak_wood_glass_6",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Birch Wood Glass

    public static final RegistryObject<Block> BIRCH_WOOD_GLASS_1 = register("birch_wood_glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BIRCH_WOOD_GLASS_2 = register("birch_wood_glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BIRCH_WOOD_GLASS_3 = register("birch_wood_glass_3",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BIRCH_WOOD_GLASS_4 = register("birch_wood_glass_4",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BIRCH_WOOD_GLASS_5 = register("birch_wood_glass_5",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BIRCH_WOOD_GLASS_6 = register("birch_wood_glass_6",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Jungle Wood Glass

    public static final RegistryObject<Block> JUNGLE_WOOD_GLASS_1 = register("jungle_wood_glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> JUNGLE_WOOD_GLASS_2 = register("jungle_wood_glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> JUNGLE_WOOD_GLASS_3 = register("jungle_wood_glass_3",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> JUNGLE_WOOD_GLASS_4 = register("jungle_wood_glass_4",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> JUNGLE_WOOD_GLASS_5 = register("jungle_wood_glass_5",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> JUNGLE_WOOD_GLASS_6 = register("jungle_wood_glass_6",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Crimson Wood Glass

    public static final RegistryObject<Block> CRIMSON_WOOD_GLASS_1 = register("crimson_wood_glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> CRIMSON_WOOD_GLASS_2 = register("crimson_wood_glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> CRIMSON_WOOD_GLASS_3 = register("crimson_wood_glass_3",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));


    public static final RegistryObject<Block> CRIMSON_WOOD_GLASS_4 = register("crimson_wood_glass_4",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));


    public static final RegistryObject<Block> CRIMSON_WOOD_GLASS_5 = register("crimson_wood_glass_5",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));


    public static final RegistryObject<Block> CRIMSON_WOOD_GLASS_6 = register("crimson_wood_glass_6",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Acacia Glass

    public static final RegistryObject<Block> ACACIA_WOOD_GLASS_1 = register("acacia_wood_glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> ACACIA_WOOD_GLASS_2 = register("acacia_wood_glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> ACACIA_WOOD_GLASS_3 = register("acacia_wood_glass_3",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> ACACIA_WOOD_GLASS_4 = register("acacia_wood_glass_4",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> ACACIA_WOOD_GLASS_5 = register("acacia_wood_glass_5",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> ACACIA_WOOD_GLASS_6 = register("acacia_wood_glass_6",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_1 = register("black_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));



    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            RenderType cutOutRenderType = RenderType.getCutout();
            // Normal
            RenderTypeLookup.setRenderLayer(GLASS_1.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(GLASS_2.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(GLASS_3.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(GLASS_4.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(GLASS_5.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(GLASS_6.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(GLASS_7.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(GLASS_8.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(GLASS_9.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(GLASS_10.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(GLASS_11.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(GLASS_12.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(GLASS_13.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(GLASS_14.get(), cutOutRenderType);
            // Dark Oak
            RenderTypeLookup.setRenderLayer(DARK_OAK_GLASS_1.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(DARK_OAK_GLASS_2.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(DARK_OAK_GLASS_3.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(DARK_OAK_GLASS_4.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(DARK_OAK_GLASS_5.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(DARK_OAK_GLASS_6.get(), cutOutRenderType);
            // Warped
            RenderTypeLookup.setRenderLayer(WARPED_WOOD_GLASS_1.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(WARPED_WOOD_GLASS_2.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(WARPED_WOOD_GLASS_3.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(WARPED_WOOD_GLASS_4.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(WARPED_WOOD_GLASS_5.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(WARPED_WOOD_GLASS_6.get(), cutOutRenderType);
            // Spruce
            RenderTypeLookup.setRenderLayer(SPRUCE_WOOD_GLASS_1.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(SPRUCE_WOOD_GLASS_2.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(SPRUCE_WOOD_GLASS_3.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(SPRUCE_WOOD_GLASS_4.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(SPRUCE_WOOD_GLASS_5.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(SPRUCE_WOOD_GLASS_6.get(), cutOutRenderType);
            // Oak
            RenderTypeLookup.setRenderLayer(OAK_WOOD_GLASS_1.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(OAK_WOOD_GLASS_2.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(OAK_WOOD_GLASS_3.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(OAK_WOOD_GLASS_4.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(OAK_WOOD_GLASS_5.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(OAK_WOOD_GLASS_6.get(), cutOutRenderType);
            // Birch
            RenderTypeLookup.setRenderLayer(BIRCH_WOOD_GLASS_1.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(BIRCH_WOOD_GLASS_2.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(BIRCH_WOOD_GLASS_3.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(BIRCH_WOOD_GLASS_4.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(BIRCH_WOOD_GLASS_5.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(BIRCH_WOOD_GLASS_6.get(), cutOutRenderType);
            // Jungle
            RenderTypeLookup.setRenderLayer(JUNGLE_WOOD_GLASS_1.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(JUNGLE_WOOD_GLASS_2.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(JUNGLE_WOOD_GLASS_3.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(JUNGLE_WOOD_GLASS_4.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(JUNGLE_WOOD_GLASS_5.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(JUNGLE_WOOD_GLASS_6.get(), cutOutRenderType);
            // Crimson
            RenderTypeLookup.setRenderLayer(CRIMSON_WOOD_GLASS_1.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(CRIMSON_WOOD_GLASS_2.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(CRIMSON_WOOD_GLASS_3.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(CRIMSON_WOOD_GLASS_4.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(CRIMSON_WOOD_GLASS_5.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(CRIMSON_WOOD_GLASS_6.get(), cutOutRenderType);
            // Acacia
            RenderTypeLookup.setRenderLayer(ACACIA_WOOD_GLASS_1.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(ACACIA_WOOD_GLASS_2.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(ACACIA_WOOD_GLASS_3.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(ACACIA_WOOD_GLASS_4.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(ACACIA_WOOD_GLASS_5.get(), cutOutRenderType);
            RenderTypeLookup.setRenderLayer(ACACIA_WOOD_GLASS_6.get(), cutOutRenderType);
            // Black Stained Glass
            RenderTypeLookup.setRenderLayer(BLACK_STAINED_GLASS_1.get(), RenderType.getTranslucent());


        }
    }

    private static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }

    private static Boolean neverAllowSpawn(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
        return (boolean) false;
    }



































    private static RotatedPillarBlock createHayBlock(MaterialColor topColor, MaterialColor sideColor) {
        return new RotatedPillarBlock(AbstractBlock.Properties.create(Material.EARTH, (state) -> {
            return state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor;
        }).hardnessAndResistance(1.0F, 2.0F).sound(SoundType.PLANT));








    }





    public static void register() {}


    private  static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
    Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
            new Item.Properties().group(Chipped.CHIPPED)));
    return toReturn;

    }
}
