package com.grimbo.chipped.block;

import com.grimbo.chipped.api.ChippedBlockType;
import com.grimbo.chipped.api.ChippedWoodType;
import net.minecraft.block.*;
import net.minecraft.item.DyeColor;

import java.util.EnumMap;

public class ChippedBlockTypes {
    public static final ChippedBlockType<GlassBlock> GLASSES = new ChippedBlockType<>("glass");
    public static final ChippedBlockType<PaneBlock> GLASS_PANES = new ChippedBlockType<>("glass_pane");
    public static final EnumMap<DyeColor, ChippedBlockType<StainedGlassBlock>> STAINED_GLASSES = new EnumMap<>(DyeColor.class);
    public static final EnumMap<DyeColor, ChippedBlockType<StainedGlassPaneBlock>> STAINED_GLASS_PANES = new EnumMap<>(DyeColor.class);

    public static final EnumMap<ChippedWoodType, ChippedBlockType<Block>> PLANKS = new EnumMap<>(ChippedWoodType.class);
    public static final EnumMap<DyeColor, ChippedBlockType<Block>> WOOL = new EnumMap<>(DyeColor.class);
    public static final EnumMap<DyeColor, ChippedBlockType<CarpetBlock>> CARPETS = new EnumMap<>(DyeColor.class);

    public static final EnumMap<DyeColor, ChippedBlockType<Block>> TERRACOTTAS = new EnumMap<>(DyeColor.class);
    public static final EnumMap<DyeColor, ChippedBlockType<Block>> CONCRETES = new EnumMap<>(DyeColor.class);

    public static final ChippedBlockType<VineBlock> VINES = new ChippedBlockType<>("vine");
    public static final ChippedBlockType<HayBlock> HAY_BLOCKS = new ChippedBlockType<>("hay_block");
    public static final ChippedBlockType<MelonBlock> MELONS = new ChippedBlockType<>("melon");

    public static final ChippedBlockType<Block> LANTERNS = new ChippedBlockType<>("lantern");
    public static final ChippedBlockType<Block> SOUL_LANTERNS = new ChippedBlockType<>("soul_lantern");

    public static final ChippedBlockType<RedstoneTorchBlock> REDSTONE_TORCHES = new ChippedBlockType<>("redstone_torch");
    public static final ChippedBlockType<TorchBlock> TORCHES = new ChippedBlockType<>("torch");

    public static final ChippedBlockType<CarvedPumpkinBlock> JACK_O_LANTERNS = new ChippedBlockType<>("jack_o_lantern");
    public static final ChippedBlockType<CarvedPumpkinBlock> CARVED_PUMPKINS = new ChippedBlockType<>("carved_pumpkin");
    //public static final ChippedBlockType<CarvedPumpkinBlock> SPECIAL_CARVED_PUMPKINS = new ChippedBlockType<>("carved_pumpkin_special");
    //public static final ChippedBlockType<CarvedPumpkinBlock> VANILLA_CARVED_PUMPKINS = new ChippedBlockType<>("carved_pumpkin_vanilla");
    public static final ChippedBlockType<PumpkinBlock> PUMPKINS = new ChippedBlockType<>("pumpkin");
    public static final ChippedBlockType<MushroomBlock> BROWN_MUSHROOMS = new ChippedBlockType<>("brown_mushroom");
    public static final ChippedBlockType<MushroomBlock> RED_MUSHROOMS = new ChippedBlockType<>("red_mushroom");
    public static final ChippedBlockType<MushroomBlock> WARPED_FUNGUS = new ChippedBlockType<>("warped_fungus");
    public static final ChippedBlockType<MushroomBlock> CRIMSON_FUNGUS = new ChippedBlockType<>("crimson_fungus");
    public static final ChippedBlockType<NetherRootsBlock> WARPED_ROOTS = new ChippedBlockType<>("warped_roots");
    public static final ChippedBlockType<NetherRootsBlock> CRIMSON_ROOTS = new ChippedBlockType<>("crimson_roots");
    public static final ChippedBlockType<NetherSproutsBlock> NETHER_SPROUTS = new ChippedBlockType<>("nether_sprouts");

    public static final ChippedBlockType<HugeMushroomBlock> BROWN_MUSHROOM_BLOCK = new ChippedBlockType<>("brown_mushroom_block");
    public static final ChippedBlockType<HugeMushroomBlock> RED_MUSHROOM_BLOCK = new ChippedBlockType<>("red_mushroom_block");

    public static final ChippedBlockType<Block> WARPED_WART_BLOCK = new ChippedBlockType<>("warped_wart_block");
    public static final ChippedBlockType<Block> NETHER_WART_BLOCK = new ChippedBlockType<>("nether_wart_block");
    public static final ChippedBlockType<SoulSandBlock> SOUL_SANDS = new ChippedBlockType<>("soul_sand");

    public static final ChippedBlockType<LilyPadBlock> LILY_PAD = new ChippedBlockType<>("lily_pad");

    public static final ChippedBlockType<Block> OBSIDIAN = new ChippedBlockType<>("obsidian");
    public static final ChippedBlockType<Block> CRYING_OBSIDIAN = new ChippedBlockType<>("crying_obsidian");

    public static final ChippedBlockType<Block> STONE = new ChippedBlockType<>("stone");
    public static final ChippedBlockType<Block> COBBLESTONE = new ChippedBlockType<>("cobblestone");
    public static final ChippedBlockType<Block> MOSSY_COBBLESTONE = new ChippedBlockType<>("mossy_cobblestone");
    public static final ChippedBlockType<Block> END_STONE = new ChippedBlockType<>("end_stone");
    public static final ChippedBlockType<Block> NETHERRACK = new ChippedBlockType<>("netherrack");
    public static final ChippedBlockType<Block> ANDESITE = new ChippedBlockType<>("andesite");
    public static final ChippedBlockType<Block> DIORITE = new ChippedBlockType<>("diorite");
    public static final ChippedBlockType<Block> BASALT = new ChippedBlockType<>("basalt");
    public static final ChippedBlockType<Block> MOSSY_STONE_BRICKS = new ChippedBlockType<>("mossy_stone_bricks");
    public static final ChippedBlockType<Block> BRICKS = new ChippedBlockType<>("bricks");
    public static final ChippedBlockType<Block> GILDED_BLACKSTONES = new ChippedBlockType<>("gilded_blackstone");
    public static final ChippedBlockType<Block> BLACKSTONES = new ChippedBlockType<>("blackstone");

    public static final ChippedBlockType<Block> BLUE_ICE = new ChippedBlockType<>("blue_ice");
    public static final ChippedBlockType<Block> CLAYS = new ChippedBlockType<>("clay");
    public static final ChippedBlockType<Block> DRIED_KELP_BLOCKS = new ChippedBlockType<>("dried_kelp_block");

    public static final ChippedBlockType<Block> GLOWSTONES = new ChippedBlockType<>("glowstone");
    public static final ChippedBlockType<Block> ANCIENT_DEBRIS = new ChippedBlockType<>("ancient_debris");
    public static final ChippedBlockType<Block> SEA_LANTERNS = new ChippedBlockType<>("sea_lantern");
    public static final ChippedBlockType<Block> SHROOMLIGHTS = new ChippedBlockType<>("shroomlight");

    public static final ChippedBlockType<RedstoneLampBlock> REDSTONE_LAMPS = new ChippedBlockType<>("redstone_lamp");

    public static final ChippedBlockType<WebBlock> COBWEBS = new ChippedBlockType<>("cobweb");
}

