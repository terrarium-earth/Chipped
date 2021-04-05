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

    // Black Carpet

    public static final RegistryObject<Block> BLACK_CARPET_1 = register("black_carpet_1",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_CARPET_2 = register("black_carpet_2",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_CARPET_3 = register("black_carpet_3",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_CARPET_4 = register("black_carpet_4",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_CARPET_5 = register("black_carpet_5",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_CARPET_6 = register("black_carpet_6",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_CARPET_7 = register("black_carpet_7",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_CARPET_8 = register("black_carpet_8",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_CARPET_9 = register("black_carpet_9",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_CARPET_10 = register("black_carpet_10",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_CARPET_11 = register("black_carpet_11",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_CARPET_12 = register("black_carpet_12",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_CARPET_13 = register("black_carpet_13",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_CARPET_14 = register("black_carpet_14",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_CARPET_15 = register("black_carpet_15",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_CARPET_16 = register("black_carpet_16",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_CARPET_17 = register("black_carpet_17",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLACK_CARPET_18 = register("black_carpet_18",
            () -> new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    // Blue Carpet

    public static final RegistryObject<Block> BLUE_CARPET_1 = register("blue_carpet_1",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_CARPET_2 = register("blue_carpet_2",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_CARPET_3 = register("blue_carpet_3",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_CARPET_4 = register("blue_carpet_4",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_CARPET_5 = register("blue_carpet_5",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_CARPET_6 = register("blue_carpet_6",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_CARPET_7 = register("blue_carpet_7",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_CARPET_8 = register("blue_carpet_8",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_CARPET_9 = register("blue_carpet_9",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_CARPET_10 = register("blue_carpet_10",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_CARPET_11 = register("blue_carpet_11",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_CARPET_12 = register("blue_carpet_12",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_CARPET_13 = register("blue_carpet_13",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_CARPET_14 = register("blue_carpet_14",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_CARPET_15 = register("blue_carpet_15",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_CARPET_16 = register("blue_carpet_16",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_CARPET_17 = register("blue_carpet_17",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BLUE_CARPET_18 = register("blue_carpet_18",
            () -> new CarpetBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    // Brown Carpet

    public static final RegistryObject<Block> BROWN_CARPET_1 = register("brown_carpet_1",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_CARPET_2 = register("brown_carpet_2",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_CARPET_3 = register("brown_carpet_3",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_CARPET_4 = register("brown_carpet_4",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_CARPET_5 = register("brown_carpet_5",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_CARPET_6 = register("brown_carpet_6",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_CARPET_7 = register("brown_carpet_7",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_CARPET_8 = register("brown_carpet_8",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_CARPET_9 = register("brown_carpet_9",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_CARPET_10 = register("brown_carpet_10",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_CARPET_11 = register("brown_carpet_11",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_CARPET_12 = register("brown_carpet_12",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_CARPET_13 = register("brown_carpet_13",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_CARPET_14 = register("brown_carpet_14",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_CARPET_15 = register("brown_carpet_15",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_CARPET_16 = register("brown_carpet_16",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_CARPET_17 = register("brown_carpet_17",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> BROWN_CARPET_18 = register("brown_carpet_18",
            () -> new CarpetBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    // Cyan Carpet

    public static final RegistryObject<Block> CYAN_CARPET_1 = register("cyan_carpet_1",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_CARPET_2 = register("cyan_carpet_2",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_CARPET_3 = register("cyan_carpet_3",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_CARPET_4 = register("cyan_carpet_4",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_CARPET_5 = register("cyan_carpet_5",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_CARPET_6 = register("cyan_carpet_6",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_CARPET_7 = register("cyan_carpet_7",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_CARPET_8 = register("cyan_carpet_8",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_CARPET_9 = register("cyan_carpet_9",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_CARPET_10 = register("cyan_carpet_10",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_CARPET_11 = register("cyan_carpet_11",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_CARPET_12 = register("cyan_carpet_12",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_CARPET_13 = register("cyan_carpet_13",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_CARPET_14 = register("cyan_carpet_14",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_CARPET_15 = register("cyan_carpet_15",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_CARPET_16 = register("cyan_carpet_16",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_CARPET_17 = register("cyan_carpet_17",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> CYAN_CARPET_18 = register("cyan_carpet_18",
            () -> new CarpetBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    // Purple Carpet

    public static final RegistryObject<Block> PURPLE_CARPET_1 = register("purple_carpet_1",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_CARPET_2 = register("purple_carpet_2",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_CARPET_3 = register("purple_carpet_3",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_CARPET_4 = register("purple_carpet_4",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_CARPET_5 = register("purple_carpet_5",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_CARPET_6 = register("purple_carpet_6",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_CARPET_7 = register("purple_carpet_7",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_CARPET_8 = register("purple_carpet_8",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_CARPET_9 = register("purple_carpet_9",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_CARPET_10 = register("purple_carpet_10",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_CARPET_11 = register("purple_carpet_11",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_CARPET_12 = register("purple_carpet_12",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_CARPET_13 = register("purple_carpet_13",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_CARPET_14 = register("purple_carpet_14",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_CARPET_15 = register("purple_carpet_15",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_CARPET_16 = register("purple_carpet_16",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_CARPET_17 = register("purple_carpet_17",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PURPLE_CARPET_18 = register("purple_carpet_18",
            () -> new CarpetBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    // Gray Carpet

    public static final RegistryObject<Block> GRAY_CARPET_1 = register("gray_carpet_1",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_CARPET_2 = register("gray_carpet_2",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_CARPET_3 = register("gray_carpet_3",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_CARPET_4 = register("gray_carpet_4",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_CARPET_5 = register("gray_carpet_5",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_CARPET_6 = register("gray_carpet_6",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_CARPET_7 = register("gray_carpet_7",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_CARPET_8 = register("gray_carpet_8",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_CARPET_9 = register("gray_carpet_9",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_CARPET_10 = register("gray_carpet_10",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_CARPET_11 = register("gray_carpet_11",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_CARPET_12 = register("gray_carpet_12",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_CARPET_13 = register("gray_carpet_13",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_CARPET_14 = register("gray_carpet_14",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_CARPET_15 = register("gray_carpet_15",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_CARPET_16 = register("gray_carpet_16",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_CARPET_17 = register("gray_carpet_17",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GRAY_CARPET_18 = register("gray_carpet_18",
            () -> new CarpetBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    // Green Carpet

    public static final RegistryObject<Block> GREEN_CARPET_1 = register("green_carpet_1",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_CARPET_2 = register("green_carpet_2",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_CARPET_3 = register("green_carpet_3",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_CARPET_4 = register("green_carpet_4",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_CARPET_5 = register("green_carpet_5",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_CARPET_6 = register("green_carpet_6",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_CARPET_7 = register("green_carpet_7",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_CARPET_8 = register("green_carpet_8",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_CARPET_9 = register("green_carpet_9",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_CARPET_10 = register("green_carpet_10",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_CARPET_11 = register("green_carpet_11",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_CARPET_12 = register("green_carpet_12",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_CARPET_13 = register("green_carpet_13",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_CARPET_14 = register("green_carpet_14",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_CARPET_15 = register("green_carpet_15",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_CARPET_16 = register("green_carpet_16",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_CARPET_17 = register("green_carpet_17",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> GREEN_CARPET_18 = register("green_carpet_18",
            () -> new CarpetBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    // Yellow Carpet

    public static final RegistryObject<Block> YELLOW_CARPET_1 = register("yellow_carpet_1",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_CARPET_2 = register("yellow_carpet_2",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_CARPET_3 = register("yellow_carpet_3",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_CARPET_4 = register("yellow_carpet_4",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_CARPET_5 = register("yellow_carpet_5",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_CARPET_6 = register("yellow_carpet_6",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_CARPET_7 = register("yellow_carpet_7",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_CARPET_8 = register("yellow_carpet_8",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_CARPET_9 = register("yellow_carpet_9",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_CARPET_10 = register("yellow_carpet_10",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_CARPET_11 = register("yellow_carpet_11",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_CARPET_12 = register("yellow_carpet_12",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_CARPET_13 = register("yellow_carpet_13",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_CARPET_14 = register("yellow_carpet_14",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_CARPET_15 = register("yellow_carpet_15",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_CARPET_16 = register("yellow_carpet_16",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_CARPET_17 = register("yellow_carpet_17",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> YELLOW_CARPET_18 = register("yellow_carpet_18",
            () -> new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    // Light Blue Carpet

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_1 = register("light_blue_carpet_1",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_2 = register("light_blue_carpet_2",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_3 = register("light_blue_carpet_3",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_4 = register("light_blue_carpet_4",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_5 = register("light_blue_carpet_5",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_6 = register("light_blue_carpet_6",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_7 = register("light_blue_carpet_7",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_8 = register("light_blue_carpet_8",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_9 = register("light_blue_carpet_9",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_10 = register("light_blue_carpet_10",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_11 = register("light_blue_carpet_11",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_12 = register("light_blue_carpet_12",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_13 = register("light_blue_carpet_13",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_14 = register("light_blue_carpet_14",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_15 = register("light_blue_carpet_15",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_16 = register("light_blue_carpet_16",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_17 = register("light_blue_carpet_17",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_18 = register("light_blue_carpet_18",
            () -> new CarpetBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    // Light Gray Carpet

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_1 = register("light_gray_carpet_1",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_2 = register("light_gray_carpet_2",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_3 = register("light_gray_carpet_3",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_4 = register("light_gray_carpet_4",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_5 = register("light_gray_carpet_5",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_6 = register("light_gray_carpet_6",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_7 = register("light_gray_carpet_7",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_8 = register("light_gray_carpet_8",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_9 = register("light_gray_carpet_9",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_10 = register("light_gray_carpet_10",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_11 = register("light_gray_carpet_11",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_12 = register("light_gray_carpet_12",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_13 = register("light_gray_carpet_13",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_14 = register("light_gray_carpet_14",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_15 = register("light_gray_carpet_15",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_16 = register("light_gray_carpet_16",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_17 = register("light_gray_carpet_17",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_18 = register("light_gray_carpet_18",
            () -> new CarpetBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    // Lime Carpet

    public static final RegistryObject<Block> LIME_CARPET_1 = register("lime_carpet_1",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_CARPET_2 = register("lime_carpet_2",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_CARPET_3 = register("lime_carpet_3",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_CARPET_4 = register("lime_carpet_4",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_CARPET_5 = register("lime_carpet_5",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_CARPET_6 = register("lime_carpet_6",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_CARPET_7 = register("lime_carpet_7",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_CARPET_8 = register("lime_carpet_8",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_CARPET_9 = register("lime_carpet_9",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_CARPET_10 = register("lime_carpet_10",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_CARPET_11 = register("lime_carpet_11",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_CARPET_12 = register("lime_carpet_12",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_CARPET_13 = register("lime_carpet_13",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_CARPET_14 = register("lime_carpet_14",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_CARPET_15 = register("lime_carpet_15",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_CARPET_16 = register("lime_carpet_16",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_CARPET_17 = register("lime_carpet_17",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> LIME_CARPET_18 = register("lime_carpet_18",
            () -> new CarpetBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    // Magenta Carpet

    public static final RegistryObject<Block> MAGENTA_CARPET_1 = register("magenta_carpet_1",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_CARPET_2 = register("magenta_carpet_2",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_CARPET_3 = register("magenta_carpet_3",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_CARPET_4 = register("magenta_carpet_4",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_CARPET_5 = register("magenta_carpet_5",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_CARPET_6 = register("magenta_carpet_6",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_CARPET_7 = register("magenta_carpet_7",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_CARPET_8 = register("magenta_carpet_8",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_CARPET_9 = register("magenta_carpet_9",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_CARPET_10 = register("magenta_carpet_10",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_CARPET_11 = register("magenta_carpet_11",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_CARPET_12 = register("magenta_carpet_12",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_CARPET_13 = register("magenta_carpet_13",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_CARPET_14 = register("magenta_carpet_14",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_CARPET_15 = register("magenta_carpet_15",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_CARPET_16 = register("magenta_carpet_16",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_CARPET_17 = register("magenta_carpet_17",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> MAGENTA_CARPET_18 = register("magenta_carpet_18",
            () -> new CarpetBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    // Orange Carpet

    public static final RegistryObject<Block> ORANGE_CARPET_1 = register("orange_carpet_1",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_CARPET_2 = register("orange_carpet_2",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_CARPET_3 = register("orange_carpet_3",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_CARPET_4 = register("orange_carpet_4",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_CARPET_5 = register("orange_carpet_5",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_CARPET_6 = register("orange_carpet_6",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_CARPET_7 = register("orange_carpet_7",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_CARPET_8 = register("orange_carpet_8",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_CARPET_9 = register("orange_carpet_9",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_CARPET_10 = register("orange_carpet_10",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_CARPET_11 = register("orange_carpet_11",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_CARPET_12 = register("orange_carpet_12",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_CARPET_13 = register("orange_carpet_13",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_CARPET_14 = register("orange_carpet_14",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_CARPET_15 = register("orange_carpet_15",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_CARPET_16 = register("orange_carpet_16",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_CARPET_17 = register("orange_carpet_17",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> ORANGE_CARPET_18 = register("orange_carpet_18",
            () -> new CarpetBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    // Pink Carpet

    public static final RegistryObject<Block> PINK_CARPET_1 = register("pink_carpet_1",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_CARPET_2 = register("pink_carpet_2",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_CARPET_3 = register("pink_carpet_3",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_CARPET_4 = register("pink_carpet_4",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_CARPET_5 = register("pink_carpet_5",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_CARPET_6 = register("pink_carpet_6",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_CARPET_7 = register("pink_carpet_7",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_CARPET_8 = register("pink_carpet_8",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_CARPET_9 = register("pink_carpet_9",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_CARPET_10 = register("pink_carpet_10",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_CARPET_11 = register("pink_carpet_11",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_CARPET_12 = register("pink_carpet_12",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_CARPET_13 = register("pink_carpet_13",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_CARPET_14 = register("pink_carpet_14",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_CARPET_15 = register("pink_carpet_15",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_CARPET_16 = register("pink_carpet_16",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_CARPET_17 = register("pink_carpet_17",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> PINK_CARPET_18 = register("pink_carpet_18",
            () -> new CarpetBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    // Red Carpet

    public static final RegistryObject<Block> RED_CARPET_1 = register("red_carpet_1",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_CARPET_2 = register("red_carpet_2",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_CARPET_3 = register("red_carpet_3",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_CARPET_4 = register("red_carpet_4",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_CARPET_5 = register("red_carpet_5",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_CARPET_6 = register("red_carpet_6",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_CARPET_7 = register("red_carpet_7",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_CARPET_8 = register("red_carpet_8",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_CARPET_9 = register("red_carpet_9",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_CARPET_10 = register("red_carpet_10",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_CARPET_11 = register("red_carpet_11",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_CARPET_12 = register("red_carpet_12",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_CARPET_13 = register("red_carpet_13",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_CARPET_14 = register("red_carpet_14",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_CARPET_15 = register("red_carpet_15",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_CARPET_16 = register("red_carpet_16",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_CARPET_17 = register("red_carpet_17",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> RED_CARPET_18 = register("red_carpet_18",
            () -> new CarpetBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    // White Carpet

    public static final RegistryObject<Block> WHITE_CARPET_1 = register("white_carpet_1",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_CARPET_2 = register("white_carpet_2",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_CARPET_3 = register("white_carpet_3",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_CARPET_4 = register("white_carpet_4",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_CARPET_5 = register("white_carpet_5",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_CARPET_6 = register("white_carpet_6",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_CARPET_7 = register("white_carpet_7",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_CARPET_8 = register("white_carpet_8",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_CARPET_9 = register("white_carpet_9",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_CARPET_10 = register("white_carpet_10",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_CARPET_11 = register("white_carpet_11",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_CARPET_12 = register("white_carpet_12",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_CARPET_13 = register("white_carpet_13",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_CARPET_14 = register("white_carpet_14",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_CARPET_15 = register("white_carpet_15",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_CARPET_16 = register("white_carpet_16",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_CARPET_17 = register("white_carpet_17",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));

    public static final RegistryObject<Block> WHITE_CARPET_18 = register("white_carpet_18",
            () -> new CarpetBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.WOOL)
                    .hardnessAndResistance(0.3F).sound(SoundType.CLOTH)));


    // Stained Glass
    // Black Stained Glass

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_1 = register("black_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_2 = register("black_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_3 = register("black_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_4 = register("black_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_5 = register("black_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_6 = register("black_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_7 = register("black_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_8 = register("black_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Blue Stained Glass

    public static final RegistryObject<Block> BLUE_STAINED_GLASS_1 = register("blue_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BLUE_STAINED_GLASS_2 = register("blue_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BLUE_STAINED_GLASS_3 = register("blue_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BLUE_STAINED_GLASS_4 = register("blue_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BLUE_STAINED_GLASS_5 = register("blue_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BLUE_STAINED_GLASS_6 = register("blue_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BLUE_STAINED_GLASS_7 = register("blue_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BLUE_STAINED_GLASS_8 = register("blue_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Brown SG

    public static final RegistryObject<Block> BROWN_STAINED_GLASS_1 = register("brown_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor. BROWN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BROWN_STAINED_GLASS_2 = register("brown_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BROWN_STAINED_GLASS_3 = register("brown_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BROWN_STAINED_GLASS_4 = register("brown_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BROWN_STAINED_GLASS_5 = register("brown_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor. BROWN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BROWN_STAINED_GLASS_6 = register("brown_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BROWN_STAINED_GLASS_7 = register("brown_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> BROWN_STAINED_GLASS_8 = register("brown_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Cyan SG

    public static final RegistryObject<Block> CYAN_STAINED_GLASS_1 = register("cyan_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> CYAN_STAINED_GLASS_2 = register("cyan_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> CYAN_STAINED_GLASS_3 = register("cyan_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> CYAN_STAINED_GLASS_4 = register("cyan_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> CYAN_STAINED_GLASS_5 = register("cyan_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> CYAN_STAINED_GLASS_6 = register("cyan_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> CYAN_STAINED_GLASS_7 = register("cyan_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> CYAN_STAINED_GLASS_8 = register("cyan_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Purple SG

    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_1 = register("purple_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_2 = register("purple_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_3 = register("purple_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_4 = register("purple_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_5 = register("purple_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_6 = register("purple_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_7 = register("purple_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_8 = register("purple_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Gray SG

    public static final RegistryObject<Block> GRAY_STAINED_GLASS_1 = register("gray_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GRAY_STAINED_GLASS_2 = register("gray_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GRAY_STAINED_GLASS_3 = register("gray_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GRAY_STAINED_GLASS_4 = register("gray_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GRAY_STAINED_GLASS_5 = register("gray_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GRAY_STAINED_GLASS_6 = register("gray_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GRAY_STAINED_GLASS_7 = register("gray_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GRAY_STAINED_GLASS_8 = register("gray_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Green SG

    public static final RegistryObject<Block> GREEN_STAINED_GLASS_1 = register("green_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GREEN_STAINED_GLASS_2 = register("green_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GREEN_STAINED_GLASS_3 = register("green_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GREEN_STAINED_GLASS_4 = register("green_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GREEN_STAINED_GLASS_5 = register("green_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GREEN_STAINED_GLASS_6 = register("green_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GREEN_STAINED_GLASS_7 = register("green_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> GREEN_STAINED_GLASS_8 = register("green_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Yellow SG

    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_1 = register("yellow_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_2 = register("yellow_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_3 = register("yellow_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_4 = register("yellow_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_5 = register("yellow_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_6 = register("yellow_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_7 = register("yellow_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_8 = register("yellow_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Light Blue SG

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_1 = register("light_blue_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_2 = register("light_blue_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_3 = register("light_blue_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_4 = register("light_blue_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_5 = register("light_blue_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_6 = register("light_blue_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_7 = register("light_blue_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_8 = register("light_blue_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Light Gray SG

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_1 = register("light_gray_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_2 = register("light_gray_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_3 = register("light_gray_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_4 = register("light_gray_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_5 = register("light_gray_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_6 = register("light_gray_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_7 = register("light_gray_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_8 = register("light_gray_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Lime SG

    public static final RegistryObject<Block> LIME_STAINED_GLASS_1 = register("lime_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIME_STAINED_GLASS_2 = register("lime_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIME_STAINED_GLASS_3 = register("lime_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIME_STAINED_GLASS_4 = register("lime_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIME_STAINED_GLASS_5 = register("lime_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIME_STAINED_GLASS_6 = register("lime_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIME_STAINED_GLASS_7 = register("lime_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> LIME_STAINED_GLASS_8 = register("lime_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Magenta SG

    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_1 = register("magenta_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_2 = register("magenta_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_3 = register("magenta_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_4 = register("magenta_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_5 = register("magenta_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_6 = register("magenta_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_7 = register("magenta_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_8 = register("magenta_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Orange SG

    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_1 = register("orange_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_2 = register("orange_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_3 = register("orange_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_4 = register("orange_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_5 = register("orange_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_6 = register("orange_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_7 = register("orange_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_8 = register("orange_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Pink SG

    public static final RegistryObject<Block> PINK_STAINED_GLASS_1 = register("pink_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> PINK_STAINED_GLASS_2 = register("pink_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> PINK_STAINED_GLASS_3 = register("pink_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> PINK_STAINED_GLASS_4 = register("pink_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> PINK_STAINED_GLASS_5 = register("pink_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> PINK_STAINED_GLASS_6 = register("pink_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> PINK_STAINED_GLASS_7 = register("pink_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> PINK_STAINED_GLASS_8 = register("pink_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // Red SG

    public static final RegistryObject<Block> RED_STAINED_GLASS_1 = register("red_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> RED_STAINED_GLASS_2 = register("red_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> RED_STAINED_GLASS_3 = register("red_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> RED_STAINED_GLASS_4 = register("red_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> RED_STAINED_GLASS_5 = register("red_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> RED_STAINED_GLASS_6 = register("red_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> RED_STAINED_GLASS_7 = register("red_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> RED_STAINED_GLASS_8 = register("red_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    // White SG

    public static final RegistryObject<Block> WHITE_STAINED_GLASS_1 = register("white_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> WHITE_STAINED_GLASS_2 = register("white_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> WHITE_STAINED_GLASS_3 = register("white_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> WHITE_STAINED_GLASS_4 = register("white_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> WHITE_STAINED_GLASS_5 = register("white_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> WHITE_STAINED_GLASS_6 = register("white_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> WHITE_STAINED_GLASS_7 = register("white_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));

    public static final RegistryObject<Block> WHITE_STAINED_GLASS_8 = register("white_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn).setOpaque(ModBlocks::isntSolid).setSuffocates(ModBlocks::isntSolid).setBlocksVision(ModBlocks::isntSolid)));
    // Vines

    public static final RegistryObject<Block> VINE_1 = register("vine_1",
            () -> new VineBlock(AbstractBlock.Properties.create(Material.PLANTS)
                    .hardnessAndResistance(0.2F).sound(SoundType.PLANT)));

    // Andesite

    public static final RegistryObject<Block> ANDESITE_1 = register("andesite_1",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_2 = register("andesite_2",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_3 = register("andesite_3",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_4 = register("andesite_4",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_5 = register("andesite_5",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_6 = register("andesite_6",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_7 = register("andesite_7",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_8 = register("andesite_8",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_9 = register("andesite_9",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_10 = register("andesite_10",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_11 = register("andesite_11",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_12 = register("andesite_12",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_13 = register("andesite_13",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_14 = register("andesite_14",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_15 = register("andesite_15",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_16 = register("andesite_16",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_17 = register("andesite_17",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_18 = register("andesite_18",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    // Clay


    public static final RegistryObject<Block> CLAY_1 = register("clay_1",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_2 = register("clay_2",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_3 = register("clay_3",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_4 = register("clay_4",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_5 = register("clay_5",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_6 = register("clay_6",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_7 = register("clay_7",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_8 = register("clay_8",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_9 = register("clay_9",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_10 = register("clay_10",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_11 = register("clay_11",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_12 = register("clay_12",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_13 = register("clay_13",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_14 = register("clay_14",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_15 = register("clay_15",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_16 = register("clay_16",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_17 = register("clay_17",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_18 = register("clay_18",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> CLAY_19 = register("clay_19",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.GROUND)));

    // Dark Prismarine


    public static final RegistryObject<Block> DARKPRISMARINE_1 = register("darkprismarine_1",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_2 = register("darkprismarine_2",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_3 = register("darkprismarine_3",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_4 = register("darkprismarine_4",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_5 = register("darkprismarine_5",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_6 = register("darkprismarine_6",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_7 = register("darkprismarine_7",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_8 = register("darkprismarine_8",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_9 = register("darkprismarine_9",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_10 = register("darkprismarine_10",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_11 = register("darkprismarine_11",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_12 = register("darkprismarine_12",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_13 = register("darkprismarine_13",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_14 = register("darkprismarine_14",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_15 = register("darkprismarine_15",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_16 = register("darkprismarine_16",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_17 = register("darkprismarine_17",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_18 = register("darkprismarine_18",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    // Prismarine

    public static final RegistryObject<Block> PRISMARINE_1 = register("prismarine_1",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_2 = register("prismarine_2",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_3 = register("prismarine_3",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_4 = register("prismarine_4",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_5 = register("prismarine_5",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_6 = register("prismarine_6",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_7 = register("prismarine_7",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_8 = register("prismarine_8",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_9 = register("prismarine_9",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_10 = register("prismarine_10",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_11 = register("prismarine_11",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_12 = register("prismarine_12",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_13 = register("prismarine_13",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_14 = register("prismarine_14",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_15 = register("prismarine_15",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_16 = register("prismarine_16",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_17 = register("prismarine_17",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_18 = register("prismarine_18",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    //









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
