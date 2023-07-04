package earth.terrarium.chipped.datagen.provider.client;

import com.mojang.datafixers.util.Pair;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.palette.IdType;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.function.BiConsumer;

public class ModBlockStateProvider extends BlockStateProvider {
    private final ExistingFileHelper exFileHelper;

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Chipped.MOD_ID, exFileHelper);
        this.exFileHelper = exFileHelper;
    }

    @Override
    protected void registerStatesAndModels() {
        createSet(ModBlocks.AMETHYST_BLOCK, "amethyst_block");
        createSet(ModBlocks.ANCIENT_DEBRIS, "ancient_debris");
        createSet(ModBlocks.ANDESITE, "andesite");
        createSet(ModBlocks.BASALT, "basalt");
        createSet(ModBlocks.BLACKSTONE, "blackstone");
        createSet(ModBlocks.BLUE_ICE, "blue_ice");
        createSet(ModBlocks.CALCITE, "calcite");
        createSet(ModBlocks.COAL_BLOCK, "coal_block");
        createSet(ModBlocks.COBBLESTONE, "cobblestone");
        createSet(ModBlocks.CRYING_OBSIDIAN, "crying_obsidian");
        createSet(ModBlocks.DARK_PRISMARINE, "dark_prismarine");
        createSet(ModBlocks.DEEPSLATE, "deepslate");
        createSet(ModBlocks.DIORITE, "diorite");
        createSet(ModBlocks.DIRT, "dirt");
        createSet(ModBlocks.DRIPSTONE_BLOCK, "dripstone_block");
        createSet(ModBlocks.END_STONE, "end_stone");
        createSet(ModBlocks.GILDED_BLACKSTONE, "gilded_blackstone");
        createSet(ModBlocks.GRANITE, "granite");
        createSet(ModBlocks.ICE, "ice");
        createSet(ModBlocks.LAPIS_BLOCK, "lapis_block");
        createSet(ModBlocks.LODESTONE, "lodestone");
        createSet(ModBlocks.MAGMA_BLOCK, "magma_block");
        createSet(ModBlocks.MOSSY_COBBLESTONE, "mossy_cobblestone");
        createSet(ModBlocks.MOSSY_STONE_BRICKS, "mossy_stone_bricks");
        createSet(ModBlocks.NETHER_BRICKS, "nether_bricks");
        createSet(ModBlocks.NETHERRACK, "netherrack");
        createSet(ModBlocks.OBSIDIAN, "obsidian");
        createSet(ModBlocks.PACKED_ICE, "packed_ice");
        createSet(ModBlocks.PRISMARINE, "prismarine");
        createSet(ModBlocks.PURPUR_BLOCK, "purpur_block");
        createSet(ModBlocks.QUARTZ_BLOCK, "quartz_block");
        createSet(ModBlocks.RAW_COPPER_BLOCK, "raw_copper_block");
        createSet(ModBlocks.RAW_GOLD_BLOCK, "raw_gold_block");
        createSet(ModBlocks.RAW_IRON_BLOCK, "raw_iron_block");
        createSet(ModBlocks.RED_NETHER_BRICKS, "red_nether_bricks");
        createSet(ModBlocks.RED_SANDSTONE, "red_sandstone");
        createSet(ModBlocks.REDSTONE_BLOCK, "redstone_block");
        createSet(ModBlocks.SANDSTONE, "sandstone");
        createSet(ModBlocks.STONE, "stone");
        createSet(ModBlocks.SMOOTH_STONE, "smooth_stone");
        createSet(ModBlocks.SNOW_BLOCK, "snow_block");
        createSet(ModBlocks.TUFF, "tuff");

        createSet(ModBlocks.CLAY, "clay");
        createSet(ModBlocks.TERRACOTTA, "terracotta");
        createSet(ModBlocks.BLACK_TERRACOTTA, "black_terracotta");
        createSet(ModBlocks.BLUE_TERRACOTTA, "blue_terracotta");
        createSet(ModBlocks.BROWN_TERRACOTTA, "brown_terracotta");
        createSet(ModBlocks.CYAN_TERRACOTTA, "cyan_terracotta");
        createSet(ModBlocks.GRAY_TERRACOTTA, "gray_terracotta");
        createSet(ModBlocks.GREEN_TERRACOTTA, "green_terracotta");
        createSet(ModBlocks.LIGHT_BLUE_TERRACOTTA, "light_blue_terracotta");
        createSet(ModBlocks.LIGHT_GRAY_TERRACOTTA, "light_gray_terracotta");
        createSet(ModBlocks.LIME_TERRACOTTA, "lime_terracotta");
        createSet(ModBlocks.MAGENTA_TERRACOTTA, "magenta_terracotta");
        createSet(ModBlocks.ORANGE_TERRACOTTA, "orange_terracotta");
        createSet(ModBlocks.PINK_TERRACOTTA, "pink_terracotta");
        createSet(ModBlocks.PURPLE_TERRACOTTA, "purple_terracotta");
        createSet(ModBlocks.RED_TERRACOTTA, "red_terracotta");
        createSet(ModBlocks.WHITE_TERRACOTTA, "white_terracotta");
        createSet(ModBlocks.YELLOW_TERRACOTTA, "yellow_terracotta");

        createGlazedTerracotta(ModBlocks.BLACK_GLAZED_TERRACOTTA, "black_glazed_terracotta");
        createGlazedTerracotta(ModBlocks.BLUE_GLAZED_TERRACOTTA, "blue_glazed_terracotta");
        createGlazedTerracotta(ModBlocks.BROWN_GLAZED_TERRACOTTA, "brown_glazed_terracotta");
        createGlazedTerracotta(ModBlocks.CYAN_GLAZED_TERRACOTTA, "cyan_glazed_terracotta");
        createGlazedTerracotta(ModBlocks.GRAY_GLAZED_TERRACOTTA, "gray_glazed_terracotta");
        createGlazedTerracotta(ModBlocks.GREEN_GLAZED_TERRACOTTA, "green_glazed_terracotta");
        createGlazedTerracotta(ModBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA, "light_blue_glazed_terracotta");
        createGlazedTerracotta(ModBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA, "light_gray_glazed_terracotta");
        createGlazedTerracotta(ModBlocks.LIME_GLAZED_TERRACOTTA, "lime_glazed_terracotta");
        createGlazedTerracotta(ModBlocks.MAGENTA_GLAZED_TERRACOTTA, "magenta_glazed_terracotta");
        createGlazedTerracotta(ModBlocks.ORANGE_GLAZED_TERRACOTTA, "orange_glazed_terracotta");
        createGlazedTerracotta(ModBlocks.PINK_GLAZED_TERRACOTTA, "pink_glazed_terracotta");
        createGlazedTerracotta(ModBlocks.PURPLE_GLAZED_TERRACOTTA, "purple_glazed_terracotta");
        createGlazedTerracotta(ModBlocks.RED_GLAZED_TERRACOTTA, "red_glazed_terracotta");
        createGlazedTerracotta(ModBlocks.WHITE_GLAZED_TERRACOTTA, "white_glazed_terracotta");
        createGlazedTerracotta(ModBlocks.YELLOW_GLAZED_TERRACOTTA, "yellow_glazed_terracotta");

        createSet(ModBlocks.BLACK_CONCRETE, "black_concrete");
        createSet(ModBlocks.BLUE_CONCRETE, "blue_concrete");
        createSet(ModBlocks.BROWN_CONCRETE, "brown_concrete");
        createSet(ModBlocks.CYAN_CONCRETE, "cyan_concrete");
        createSet(ModBlocks.GRAY_CONCRETE, "gray_concrete");
        createSet(ModBlocks.GREEN_CONCRETE, "green_concrete");
        createSet(ModBlocks.LIGHT_BLUE_CONCRETE, "light_blue_concrete");
        createSet(ModBlocks.LIGHT_GRAY_CONCRETE, "light_gray_concrete");
        createSet(ModBlocks.LIME_CONCRETE, "lime_concrete");
        createSet(ModBlocks.MAGENTA_CONCRETE, "magenta_concrete");
        createSet(ModBlocks.ORANGE_CONCRETE, "orange_concrete");
        createSet(ModBlocks.PINK_CONCRETE, "pink_concrete");
        createSet(ModBlocks.PURPLE_CONCRETE, "purple_concrete");
        createSet(ModBlocks.RED_CONCRETE, "red_concrete");
        createSet(ModBlocks.WHITE_CONCRETE, "white_concrete");
        createSet(ModBlocks.YELLOW_CONCRETE, "yellow_concrete");

        createSet(ModBlocks.BLACK_WOOL, "black_wool");
        createSet(ModBlocks.BLUE_WOOL, "blue_wool");
        createSet(ModBlocks.BROWN_WOOL, "brown_wool");
        createSet(ModBlocks.CYAN_WOOL, "cyan_wool");
        createSet(ModBlocks.GRAY_WOOL, "gray_wool");
        createSet(ModBlocks.GREEN_WOOL, "green_wool");
        createSet(ModBlocks.LIGHT_BLUE_WOOL, "light_blue_wool");
        createSet(ModBlocks.LIGHT_GRAY_WOOL, "light_gray_wool");
        createSet(ModBlocks.LIME_WOOL, "lime_wool");
        createSet(ModBlocks.MAGENTA_WOOL, "magenta_wool");
        createSet(ModBlocks.ORANGE_WOOL, "orange_wool");
        createSet(ModBlocks.PINK_WOOL, "pink_wool");
        createSet(ModBlocks.PURPLE_WOOL, "purple_wool");
        createSet(ModBlocks.RED_WOOL, "red_wool");
        createSet(ModBlocks.WHITE_WOOL, "white_wool");
        createSet(ModBlocks.YELLOW_WOOL, "yellow_wool");

        createCarpetSet(ModBlocks.BLACK_CARPET, "black_wool");
        createCarpetSet(ModBlocks.BLUE_CARPET, "blue_wool");
        createCarpetSet(ModBlocks.BROWN_CARPET, "brown_wool");
        createCarpetSet(ModBlocks.CYAN_CARPET, "cyan_wool");
        createCarpetSet(ModBlocks.GRAY_CARPET, "gray_wool");
        createCarpetSet(ModBlocks.GREEN_CARPET, "green_wool");
        createCarpetSet(ModBlocks.LIGHT_BLUE_CARPET, "light_blue_wool");
        createCarpetSet(ModBlocks.LIGHT_GRAY_CARPET, "light_gray_wool");
        createCarpetSet(ModBlocks.LIME_CARPET, "lime_wool");
        createCarpetSet(ModBlocks.MAGENTA_CARPET, "magenta_wool");
        createCarpetSet(ModBlocks.ORANGE_CARPET, "orange_wool");
        createCarpetSet(ModBlocks.PINK_CARPET, "pink_wool");
        createCarpetSet(ModBlocks.PURPLE_CARPET, "purple_wool");
        createCarpetSet(ModBlocks.RED_CARPET, "red_wool");
        createCarpetSet(ModBlocks.WHITE_CARPET, "white_wool");
        createCarpetSet(ModBlocks.YELLOW_CARPET, "yellow_wool");

        createSet(ModBlocks.ACACIA_PLANKS, "acacia_planks");
        createSet(ModBlocks.BIRCH_PLANKS, "birch_planks");
        createSet(ModBlocks.DARK_OAK_PLANKS, "dark_oak_planks");
        createSet(ModBlocks.JUNGLE_PLANKS, "jungle_planks");
        createSet(ModBlocks.MANGROVE_PLANKS, "mangrove_planks");
        createSet(ModBlocks.OAK_PLANKS, "oak_planks");
        createSet(ModBlocks.SPRUCE_PLANKS, "spruce_planks");
        createSet(ModBlocks.CRIMSON_PLANKS, "crimson_planks");
        createSet(ModBlocks.WARPED_PLANKS, "warped_planks");

        createSet(ModBlocks.BRICKS, "bricks");
        createSet(ModBlocks.MUD, "mud");
        createSet(ModBlocks.PACKED_MUD, "packed_mud");
        createSet(ModBlocks.MUD_BRICKS, "mud_bricks");


        createLogSet(ModBlocks.ACACIA_LOG, "acacia_log");
        createLogSet(ModBlocks.BIRCH_LOG, "birch_log");
        createLogSet(ModBlocks.DARK_OAK_LOG, "dark_oak_log");
        createLogSet(ModBlocks.JUNGLE_LOG, "jungle_log");
        createLogSet(ModBlocks.MANGROVE_LOG, "mangrove_log");
        createLogSet(ModBlocks.OAK_LOG, "oak_log");
        createLogSet(ModBlocks.SPRUCE_LOG, "spruce_log");
        createLogSet(ModBlocks.CRIMSON_STEM, "crimson_stem");
        createLogSet(ModBlocks.WARPED_STEM, "warped_stem");

        createSet(ModBlocks.GLASS, "glass");
        createGlassPaneSet(ModBlocks.GLASS_PANE, "glass_pane");
        createSet(ModBlocks.BLACK_STAINED_GLASS, "black_stained_glass");
        createGlassPaneSet(ModBlocks.BLACK_STAINED_GLASS_PANE, "black_stained_glass_pane");
        createSet(ModBlocks.BLUE_STAINED_GLASS, "blue_stained_glass");
        createGlassPaneSet(ModBlocks.BLUE_STAINED_GLASS_PANE, "blue_stained_glass_pane");
        createSet(ModBlocks.BROWN_STAINED_GLASS, "brown_stained_glass");
        createGlassPaneSet(ModBlocks.BROWN_STAINED_GLASS_PANE, "brown_stained_glass_pane");
        createSet(ModBlocks.CYAN_STAINED_GLASS, "cyan_stained_glass");
        createGlassPaneSet(ModBlocks.CYAN_STAINED_GLASS_PANE, "cyan_stained_glass_pane");
        createSet(ModBlocks.GRAY_STAINED_GLASS, "gray_stained_glass");
        createGlassPaneSet(ModBlocks.GRAY_STAINED_GLASS_PANE, "gray_stained_glass_pane");
        createSet(ModBlocks.GREEN_STAINED_GLASS, "green_stained_glass");
        createGlassPaneSet(ModBlocks.GREEN_STAINED_GLASS_PANE, "green_stained_glass_pane");
        createSet(ModBlocks.LIGHT_BLUE_STAINED_GLASS, "light_blue_stained_glass");
        createGlassPaneSet(ModBlocks.LIGHT_BLUE_STAINED_GLASS_PANE, "light_blue_stained_glass_pane");
        createSet(ModBlocks.LIGHT_GRAY_STAINED_GLASS, "light_gray_stained_glass");
        createGlassPaneSet(ModBlocks.LIGHT_GRAY_STAINED_GLASS_PANE, "light_gray_stained_glass_pane");
        createSet(ModBlocks.LIME_STAINED_GLASS, "lime_stained_glass");
        createGlassPaneSet(ModBlocks.LIME_STAINED_GLASS_PANE, "lime_stained_glass_pane");
        createSet(ModBlocks.MAGENTA_STAINED_GLASS, "magenta_stained_glass");
        createGlassPaneSet(ModBlocks.MAGENTA_STAINED_GLASS_PANE, "magenta_stained_glass_pane");
        createSet(ModBlocks.ORANGE_STAINED_GLASS, "orange_stained_glass");
        createGlassPaneSet(ModBlocks.ORANGE_STAINED_GLASS_PANE, "orange_stained_glass_pane");
        createSet(ModBlocks.PINK_STAINED_GLASS, "pink_stained_glass");
        createGlassPaneSet(ModBlocks.PINK_STAINED_GLASS_PANE, "pink_stained_glass_pane");
        createSet(ModBlocks.PURPLE_STAINED_GLASS, "purple_stained_glass");
        createGlassPaneSet(ModBlocks.PURPLE_STAINED_GLASS_PANE, "purple_stained_glass_pane");
        createSet(ModBlocks.RED_STAINED_GLASS, "red_stained_glass");
        createGlassPaneSet(ModBlocks.RED_STAINED_GLASS_PANE, "red_stained_glass_pane");
        createSet(ModBlocks.WHITE_STAINED_GLASS, "white_stained_glass");
        createGlassPaneSet(ModBlocks.WHITE_STAINED_GLASS_PANE, "white_stained_glass_pane");
        createSet(ModBlocks.YELLOW_STAINED_GLASS, "yellow_stained_glass");
        createGlassPaneSet(ModBlocks.YELLOW_STAINED_GLASS_PANE, "yellow_stained_glass_pane");

        createSet(ModBlocks.ACACIA_LEAVES, "acacia_leaves", 4);
        createSet(ModBlocks.BIRCH_LEAVES, "birch_leaves", 4);
        createSet(ModBlocks.DARK_OAK_LEAVES, "dark_oak_leaves", 4);
        createSet(ModBlocks.JUNGLE_LEAVES, "jungle_leaves", 4);
        createRootSet(ModBlocks.MANGROVE_ROOTS, "mangrove_roots");
        createSet(ModBlocks.OAK_LEAVES, "oak_leaves", 4);
        createSet(ModBlocks.SPRUCE_LEAVES, "spruce_leaves", 4);

        createSet(ModBlocks.OCHRE_FROGLIGHT, "ochre_froglight");
        createSet(ModBlocks.PEARLESCENT_FROGLIGHT, "pearlescent_froglight");
        createSet(ModBlocks.VERDANT_FROGLIGHT, "verdant_froglight");

        createSnowyLeaves(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Chipped.MOD_ID, "frosted_acacia_leaves")), "acacia_leaves");
        createSnowyLeaves(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Chipped.MOD_ID, "frosted_birch_leaves")), "birch_leaves");
        createSnowyLeaves(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Chipped.MOD_ID, "frosted_dark_oak_leaves")), "dark_oak_leaves");
        createSnowyLeaves(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Chipped.MOD_ID, "frosted_jungle_leaves")), "jungle_leaves");
        createSnowyLeaves(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Chipped.MOD_ID, "frosted_oak_leaves")), "oak_leaves");
        createSnowyLeaves(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Chipped.MOD_ID, "frosted_spruce_leaves")), "spruce_leaves");

        createSet(ModBlocks.DIAMOND_BLOCK, "diamond_block");
        createSet(ModBlocks.EMERALD_BLOCK, "emerald_block");
        createSet(ModBlocks.GOLD_BLOCK, "gold_block");
        createSet(ModBlocks.IRON_BLOCK, "iron_block");
        createSet(ModBlocks.NETHERITE_BLOCK, "netherite_block");

        createBarrelSet(ModBlocks.BARREL, "barrel");
        createLogSet(ModBlocks.BONE_BLOCK, "bone_block");
        createBookshelfSet(ModBlocks.BOOKSHELF, "bookshelf");
        createSet(ModBlocks.BROWN_MUSHROOM_BLOCK, "brown_mushroom_block");
        createSet(ModBlocks.RED_MUSHROOM_BLOCK, "red_mushroom_block");
        createCross(ModBlocks.BROWN_MUSHROOM, "brown_mushroom");
        createCross(ModBlocks.RED_MUSHROOM, "red_mushroom");
        createCross(ModBlocks.COBWEB, "cobweb");
        createSet(ModBlocks.SPONGE, "sponge");
        createSet(ModBlocks.MUSHROOM_STEM, "mushroom_stem");
        createSet(ModBlocks.GLOWSTONE, "glowstone");
        createSet(ModBlocks.GRAVEL, "gravel");
        createLogSet(ModBlocks.HAY_BLOCK, "hay_block");
        createIronBarsSet(ModBlocks.IRON_BARS, "iron_bars");
        createSet(ModBlocks.MOSS_BLOCK, "moss_block");
        createLadderSet(ModBlocks.LADDER, "ladder");
        createMelonBlock(ModBlocks.MELON, "melon");
        createSet(ModBlocks.SHROOMLIGHT, "shroomlight");
        createSet(ModBlocks.SEA_LANTERN, "sea_lantern");
        createSet(ModBlocks.SAND, "sand");
        createSet(ModBlocks.SOUL_SAND, "soul_sand");
        createRedstoneLampBlock(ModBlocks.REDSTONE_LAMP, "redstone_lamp");

        createSet(ModBlocks.WAXED_COPPER_BLOCK, "waxed_copper_block");
        createSet(ModBlocks.WAXED_EXPOSED_COPPER, "waxed_exposed_copper");
        createSet(ModBlocks.WAXED_WEATHERED_COPPER, "waxed_weathered_copper");
        createSet(ModBlocks.WAXED_OXIDIZED_COPPER, "waxed_oxidized_copper");

        createStrippedLogSet(ModBlocks.STRIPPED_ACACIA_LOG, "stripped_acacia_log");
        createStrippedLogSet(ModBlocks.STRIPPED_BIRCH_LOG, "stripped_birch_log");
        createStrippedLogSet(ModBlocks.STRIPPED_DARK_OAK_LOG, "stripped_dark_oak_log");
        createStrippedLogSet(ModBlocks.STRIPPED_JUNGLE_LOG, "stripped_jungle_log");
        createStrippedLogSet(ModBlocks.STRIPPED_MANGROVE_LOG, "stripped_mangrove_log");
        createStrippedLogSet(ModBlocks.STRIPPED_OAK_LOG, "stripped_oak_log");
        createStrippedLogSet(ModBlocks.STRIPPED_SPRUCE_LOG, "stripped_spruce_log");
        createStrippedLogSet(ModBlocks.STRIPPED_WARPED_STEM, "stripped_warped_stem");
        createStrippedLogSet(ModBlocks.STRIPPED_CRIMSON_STEM, "stripped_crimson_stem");

        createDoorSet(ModBlocks.ACACIA_DOOR, "acacia_door");
        createDoorSet(ModBlocks.BIRCH_DOOR, "birch_door");
        createDoorSet(ModBlocks.DARK_OAK_DOOR, "dark_oak_door");
        createDoorSet(ModBlocks.JUNGLE_DOOR, "jungle_door");
        createDoorSet(ModBlocks.MANGROVE_DOOR, "mangrove_door");
        createDoorSet(ModBlocks.OAK_DOOR, "oak_door");
        createDoorSet(ModBlocks.SPRUCE_DOOR, "spruce_door");
        createDoorSet(ModBlocks.CRIMSON_DOOR, "crimson_door");
        createDoorSet(ModBlocks.WARPED_DOOR, "warped_door");

        createTrapdoorSet(ModBlocks.ACACIA_TRAPDOOR, "acacia_trapdoor");
        createTrapdoorSet(ModBlocks.BIRCH_TRAPDOOR, "birch_trapdoor");
        createTrapdoorSet(ModBlocks.DARK_OAK_TRAPDOOR, "dark_oak_trapdoor");
        createTrapdoorSet(ModBlocks.JUNGLE_TRAPDOOR, "jungle_trapdoor");
        createTrapdoorSet(ModBlocks.MANGROVE_TRAPDOOR, "mangrove_trapdoor");
        createTrapdoorSet(ModBlocks.OAK_TRAPDOOR, "oak_trapdoor");
        createTrapdoorSet(ModBlocks.SPRUCE_TRAPDOOR, "spruce_trapdoor");
        createTrapdoorSet(ModBlocks.CRIMSON_TRAPDOOR, "crimson_trapdoor");
        createTrapdoorSet(ModBlocks.WARPED_TRAPDOOR, "warped_trapdoor");

        createCross(ModBlocks.CRIMSON_ROOTS, "crimson_roots");
        createCross(ModBlocks.WARPED_ROOTS, "warped_roots");
        createDriedKelpSet(ModBlocks.DRIED_KELP_BLOCK, "dried_kelp_block");
        createLilyPadSet(ModBlocks.LILY_PAD, "lily_pad");
        createCross(ModBlocks.NETHER_SPROUTS, "nether_sprouts");
        createSet(ModBlocks.NETHER_WART_BLOCK, "nether_wart_block");
        createPumpkinSet(ModBlocks.PUMPKIN, "pumpkin");

        createCarvedPumpkinBlock(ModBlocks.CARVED_PUMPKIN, "carved_pumpkin");
        createCarvedPumpkinBlock(ModBlocks.JACK_O_LANTERN, "jack_o_lantern");

        createSet(ModBlocks.WARPED_WART_BLOCK, "warped_wart_block");
        createCross(ModBlocks.CRIMSON_FUNGUS, "crimson_fungus");
        createCross(ModBlocks.WARPED_FUNGUS, "warped_fungus");
        createTorchSet(ModBlocks.TORCH, "torch");
        createRedstoneTorchSet(ModBlocks.REDSTONE_TORCH, "redstone_torch");
        createPointedDripstoneSet(ModBlocks.POINTED_DRIPSTONE, "pointed_dripstone");

        createLanternSet(ModBlocks.LANTERN);
        createLanternSet(ModBlocks.SOUL_LANTERN);
    }

    private void createPointedDripstoneSet(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, -1, false, (block, i) -> {
            ResourceLocation texture = customTexture(block, folder);
            BlockModelBuilder downBase = createChildModel(extend(texture, "_down_base"), new ResourceLocation("block/pointed_dripstone"), extend(texture, "_down_base"), "cross");
            BlockModelBuilder downFrustum = createChildModel(extend(texture, "_down_frustum"), new ResourceLocation("block/pointed_dripstone"), extend(texture, "_down_frustum"), "cross");
            BlockModelBuilder downMiddle = createChildModel(extend(texture, "_down_middle"), new ResourceLocation("block/pointed_dripstone"), extend(texture, "_down_middle"), "cross");
            BlockModelBuilder downTipMerge = createChildModel(extend(texture, "_down_tip_merge"), new ResourceLocation("block/pointed_dripstone"), extend(texture, "_down_tip_merge"), "cross");
            BlockModelBuilder downTip = createChildModel(extend(texture, "_down_tip"), new ResourceLocation("block/pointed_dripstone"), extend(texture, "_down_tip"), "cross");
            BlockModelBuilder upBase = createChildModel(extend(texture, "_up_base"), new ResourceLocation("block/pointed_dripstone"), extend(texture, "_up_base"), "cross");
            BlockModelBuilder upFrustum = createChildModel(extend(texture, "_up_frustum"), new ResourceLocation("block/pointed_dripstone"), extend(texture, "_up_frustum"), "cross");
            BlockModelBuilder upMiddle = createChildModel(extend(texture, "_up_middle"), new ResourceLocation("block/pointed_dripstone"), extend(texture, "_up_middle"), "cross");
            BlockModelBuilder upTipMerge = createChildModel(extend(texture, "_up_tip_merge"), new ResourceLocation("block/pointed_dripstone"), extend(texture, "_up_tip_merge"), "cross");
            BlockModelBuilder upTip = createChildModel(extend(texture, "_up_tip"), new ResourceLocation("block/pointed_dripstone"), extend(texture, "_up_tip"), "cross");

            getVariantBuilder(block)
                    .forAllStates(state -> {
                        DripstoneThickness thickness = state.getValue(PointedDripstoneBlock.THICKNESS);
                        Direction dir = state.getValue(PointedDripstoneBlock.TIP_DIRECTION);

                        return ConfiguredModel.builder()
                                .modelFile(switch (thickness) {
                                    case TIP_MERGE -> {
                                        if (dir == Direction.DOWN) {
                                            yield downTipMerge;
                                        } else {
                                            yield upTipMerge;
                                        }
                                    }
                                    case TIP -> {
                                        if (dir == Direction.DOWN) {
                                            yield downTip;
                                        } else {
                                            yield upTip;
                                        }
                                    }
                                    case FRUSTUM -> {
                                        if (dir == Direction.DOWN) {
                                            yield downFrustum;
                                        } else {
                                            yield upFrustum;
                                        }
                                    }
                                    case MIDDLE -> {
                                        if (dir == Direction.DOWN) {
                                            yield downMiddle;
                                        } else {
                                            yield upMiddle;
                                        }
                                    }
                                    case BASE -> {
                                        if (dir == Direction.DOWN) {
                                            yield downBase;
                                        } else {
                                            yield upBase;
                                        }
                                    }
                                })
                                .build();
                    });
        });
    }

    private void createSnowyLeaves(Block block, String folder) {
        BlockModelBuilder model = models().cubeColumn(name(block), customTexture(block, folder), extend(customTexture(block, folder), "_top"));
        simpleBlock(block, model);
        simpleBlockItem(block, model);
    }

    private void createSet(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, folder, -1);
    }

    private void createSet(ResourcefulRegistry<Block> registry, String folder, int exclude) {
        createSet(registry, exclude, (block, i) -> simpleBlock(block, models().cubeAll(name(block), customTexture(block, folder))));
    }

    private void createCross(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, -1, false, (block, i) -> simpleBlock(block, models().cross(name(block), customTexture(block, folder))));
    }

    private void createCarpetSet(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, (block, i) -> simpleBlock(block, models().carpet(name(block), new ResourceLocation(Chipped.MOD_ID, customTexture(block, folder).getPath().replace("_carpet", "_wool")))));
    }

    private void createDriedKelpSet(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, (block, i) -> {
            ResourceLocation texture = customTexture(block, folder);
            simpleBlock(block, models().getBuilder(name(block))
                    .texture("particle", texture)
                    .texture("down", extend(texture, "_top"))
                    .texture("up", extend(texture, "_top"))
                    .texture("north", texture)
                    .texture("east", texture)
                    .texture("south", texture)
                    .texture("west", texture)
                    .parent(models().getExistingFile(new ResourceLocation("block/dried_kelp_block"))));
        });
    }

    private void createLilyPadSet(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, -1, false, (block, i) -> {
            ResourceLocation texture = customTexture(block, folder);
            simpleBlock(block, models().getBuilder(name(block))
                    .texture("particle", texture)
                    .texture("texture", texture)
                    .parent(models().getExistingFile(new ResourceLocation("block/lily_pad"))));
        });
    }

    private void createPumpkinSet(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, (block, i) -> {
            ResourceLocation texture = customTexture(block, folder);
            simpleBlock(block, models().cubeBottomTop(name(block), extend(texture, "_side"), extend(texture, "_bottom"), extend(texture, "_top")));
        });
    }

    private void createCarvedPumpkinBlock(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, (block, i) -> {
            ResourceLocation texture = customTexture(block, folder);
            if (texture.getPath().contains("nether")) {
                createCarvedPumpkinBlock(block, folder, new ResourceLocation(Chipped.MOD_ID, "block/pumpkin/nether_pumpkin_top"), new ResourceLocation(Chipped.MOD_ID, "block/pumpkin/nether_pumpkin_bottom"), new ResourceLocation(Chipped.MOD_ID, "block/pumpkin/nether_pumpkin_side"));
            } else if (texture.getPath().contains("end_purple")) {
                createCarvedPumpkinBlock(block, folder, new ResourceLocation(Chipped.MOD_ID, "block/pumpkin/end_pumpkin_purple_top"), new ResourceLocation(Chipped.MOD_ID, "block/pumpkin/end_pumpkin_purple_bottom"), new ResourceLocation(Chipped.MOD_ID, "block/pumpkin/end_pumpkin_purple_side"));
            } else if (texture.getPath().contains("end")) {
                createCarvedPumpkinBlock(block, folder, new ResourceLocation(Chipped.MOD_ID, "block/pumpkin/end_pumpkin_top"), new ResourceLocation(Chipped.MOD_ID, "block/pumpkin/end_pumpkin_bottom"), new ResourceLocation(Chipped.MOD_ID, "block/pumpkin/end_pumpkin_side"));
            } else {
                createCarvedPumpkinBlock(block, folder, new ResourceLocation("block/pumpkin_top"), new ResourceLocation("block/pumpkin_top"), new ResourceLocation("block/pumpkin_side"));
            }
        });
    }

    private void createCarvedPumpkinBlock(Block block, String folder, ResourceLocation top, ResourceLocation bottom, ResourceLocation side) {
        ResourceLocation texture = customTexture(block, folder);
        BlockModelBuilder model = models().getBuilder(name(block))
                .texture("down", bottom)
                .texture("east", texture)
                .texture("north", side)
                .texture("particle", texture)
                .texture("south", side)
                .texture("up", top)
                .texture("west", side)
                .parent(models().getExistingFile(new ResourceLocation("block/cube")));

        getVariantBuilder(block)
                .forAllStates(state -> {
                    Direction dir = state.getValue(CarvedPumpkinBlock.FACING);
                    return ConfiguredModel.builder()
                            .modelFile(model)
                            .rotationY(dir.getAxis().isVertical() ? 0 : (((int) dir.toYRot()) + 90) % 360)
                            .build();
                });
    }

    private void createLanternSet(ResourcefulRegistry<Block> registry) {
        createSet(registry, -1, false, (block, i) -> getVariantBuilder(block)
                .forAllStates(state -> ConfiguredModel.builder()
                        .modelFile(state.getValue(LanternBlock.HANGING) ? new ModelFile.UncheckedModelFile(extend(blockTexture(block), "_hanging")) : new ModelFile.UncheckedModelFile(blockTexture(block)))
                        .build()));

    }

    private void createTorchSet(Pair<? extends ResourcefulRegistry<Block>, ? extends ResourcefulRegistry<Block>> registry, String folder) {
        createSet(registry.getFirst(), -1, false, (block, i) -> {
            ResourceLocation texture = customTexture(block, folder);
            BlockModelBuilder model = models().getBuilder(name(block))
                    .texture("torch", texture)
                    .parent(models().getExistingFile(new ResourceLocation("block/template_torch")));

            simpleBlock(block, model);
        });

        createSet(registry.getSecond(), (block, i) -> {
            ResourceLocation texture = new ResourceLocation(Chipped.MOD_ID, customTexture(block, folder).getPath().replace("_wall", ""));
            BlockModelBuilder model = models().getBuilder(name(block))
                    .texture("torch", texture)
                    .parent(models().getExistingFile(new ResourceLocation("block/template_torch_wall")));


            getVariantBuilder(block)
                    .forAllStates(state -> {
                        Direction dir = state.getValue(WallTorchBlock.FACING);
                        return ConfiguredModel.builder()
                                .modelFile(model)
                                .rotationY(dir.getAxis().isVertical() ? 0 : (((int) dir.toYRot()) + 90) % 360)
                                .build();
                    });
        });
    }

    private void createRedstoneTorchSet(Pair<? extends ResourcefulRegistry<Block>, ? extends ResourcefulRegistry<Block>> registry, String folder) {
        createSet(registry.getFirst(), -1, false, (block, i) -> {
            ResourceLocation texture1 = customTexture(block, folder);
            BlockModelBuilder model1 = models().getBuilder(name(block))
                    .texture("torch", texture1)
                    .parent(models().getExistingFile(new ResourceLocation("block/template_torch")));


            ResourceLocation texture2 = customTexture(block, folder);
            BlockModelBuilder model2 = models().getBuilder(name(block))
                    .texture("torch", texture2)
                    .parent(models().getExistingFile(new ResourceLocation("block/template_torch")));

            getVariantBuilder(block)
                    .forAllStates(state -> ConfiguredModel.builder()
                            .modelFile(state.getValue(RedstoneTorchBlock.LIT) ? model1 : model2)
                            .build());
        });

        createSet(registry.getSecond(), (block, i) -> {
            ResourceLocation texture = new ResourceLocation(Chipped.MOD_ID, customTexture(block, folder).getPath().replace("_wall", ""));
            BlockModelBuilder model1 = models().getBuilder(name(block))
                    .texture("torch", extend(texture, "_on"))
                    .parent(models().getExistingFile(new ResourceLocation("block/template_torch_wall")));

            BlockModelBuilder model2 = models().getBuilder(name(block))
                    .texture("torch", texture)
                    .parent(models().getExistingFile(new ResourceLocation("block/template_torch_wall")));

            getVariantBuilder(block)
                    .forAllStates(state -> {
                        Direction dir = state.getValue(RedstoneWallTorchBlock.FACING);
                        return ConfiguredModel.builder()
                                .modelFile(state.getValue(RedstoneWallTorchBlock.LIT) ? model1 : model2)
                                .rotationY(dir.getAxis().isVertical() ? 0 : (((int) dir.toYRot()) + 90) % 360)
                                .build();
                    });
        });
    }

    private void createLadderSet(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, -1, false, (block, i) -> {

            BlockModelBuilder model = createChildModel(block, new ResourceLocation("block/ladder"), customTexture(block, folder), "texture", folder);

            getVariantBuilder(block)
                    .forAllStates(state -> {
                        Direction dir = state.getValue(LadderBlock.FACING);
                        return ConfiguredModel.builder()
                                .modelFile(model)
                                .rotationY(dir.getAxis().isVertical() ? 0 : (((int) dir.toYRot()) + 180) % 360)
                                .build();
                    });
        });
    }

    private void createGlazedTerracotta(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, (block, i) -> {
            BlockModelBuilder model = createChildModel(block, new ResourceLocation("block/template_glazed_terracotta"), customTexture(block, folder), "pattern", folder);
            horizontalBlock(block, model);
        });
    }

    private void createRootSet(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, (block, i) -> {
            BlockModelBuilder model = models().getBuilder(name(block)).texture("side", customTexture(block, folder)).texture("top", extend(customTexture(block, folder), "_top")).parent(models().getExistingFile(new ResourceLocation("block/mangrove_roots")));
            simpleBlock(block, model);
        });
    }

    private void createMelonBlock(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, (block, i) -> {
            ResourceLocation baseName = customTexture(block, folder);
            simpleBlock(block, models().cubeBottomTop(name(block), baseName, extend(baseName, "_bottom"), extend(baseName, "_top")));
        });
    }

    private void createBookshelfSet(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, (block, i) -> {
            BlockModelBuilder model = models().cubeColumn(name(block), customTexture(block, folder), blockTexture(Blocks.OAK_PLANKS));
            simpleBlock(block, model);
        });
    }

    private void createBarrelSet(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, (block, i) -> {

            boolean isCrate = blockTexture(block).getPath().contains("crate");
            ModelFile model = models().getBuilder(name(block)).texture("bottom", extend(customTexture(block, folder), isCrate ? "_top" : "_bottom")).texture("side", extend(customTexture(block, folder), "_side")).texture("top", extend(customTexture(block, folder), "_top")).parent(models().getExistingFile(new ResourceLocation("block/cube_bottom_top")));
            ModelFile openModel = isCrate ? model : models().getBuilder(name(block) + "_open").texture("bottom", extend(customTexture(block, folder), "_bottom")).texture("side", extend(customTexture(block, folder), "_side")).texture("top", extend(customTexture(block, folder), "_top_open")).parent(models().getExistingFile(new ResourceLocation("block/cube_bottom_top")));

            getVariantBuilder(block)
                    .forAllStates(state -> {
                        Direction dir = state.getValue(BarrelBlock.FACING);
                        return ConfiguredModel.builder()
                                .modelFile(state.getValue(BarrelBlock.OPEN) ? openModel : model)
                                .rotationX(dir == Direction.DOWN ? 180 : dir.getAxis().isHorizontal() ? 90 : 0)
                                .rotationY(dir.getAxis().isVertical() ? 0 : (((int) dir.toYRot()) + 180) % 360)
                                .build();
                    });
        });
    }

    private void createRedstoneLampBlock(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, (block, i) -> {

            ModelFile model = models().cubeAll(name(block), customTexture(block, folder));
            ModelFile modelOn = models().cubeAll(name(block) + "_on", extend(customTexture(block, folder), "_on"));

            getVariantBuilder(block)
                    .forAllStates(state -> ConfiguredModel.builder()
                            .modelFile(state.getValue(RedstoneLampBlock.LIT) ? modelOn : model)
                            .build());
        });
    }

    private void createLogSet(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, (block, i) -> {
            ResourceLocation baseName = customTexture(block, folder);
            axisBlock((RotatedPillarBlock) block, baseName, extend(baseName, "_top"));
        });
    }

    private void createStrippedLogSet(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, (block, i) -> axisBlock((RotatedPillarBlock) block, customTexture(block, folder), extend(customTexture(block, folder), "_top")));
    }

    private void createGlassPaneSet(ChippedPaletteRegistry<Block> registry, String folder) {
        final String id = BuiltInRegistries.BLOCK.getKey(registry.getBase()).getPath();
        for (var entry : registry.getPalette().ids()) {
            final var blockId = new ResourceLocation(Chipped.MOD_ID, entry.getSecond().replace("%", id));
            final var block = BuiltInRegistries.BLOCK.get(blockId);

            final var pane = blockId.getPath().replace("_pane", "");

            if (entry.getFirst() == IdType.NONE) {
                ResourceLocation paneTopTexture;
                if (exFileHelper.exists(customTexture(block, folder), PackType.CLIENT_RESOURCES, ".png", "textures/block")) {
                    paneTopTexture = extend(customTexture(block, folder), "_top");
                } else {
                    paneTopTexture = extend(blockTexture(Blocks.GLASS_PANE), "_top");
                }
                paneBlock((IronBarsBlock) block, pane, new ResourceLocation(Chipped.MOD_ID, customTexture(block, folder).getPath().replace("_pane", "")), paneTopTexture);
            } else {
                final var iddahdahdahblahblahblah = new ResourceLocation(Chipped.MOD_ID, "block/" + id.replace("_pane", "") + "/" + pane);
                simpleBlock(block, models().cubeAll(blockId.getPath(), iddahdahdahblahblahblah));
                itemModels().getBuilder(blockId.toString())
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", iddahdahdahblahblahblah);
            }
        }
    }

    private void createIronBarsSet(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, -1, false, (block, i) -> paneBlock((IronBarsBlock) block, key(block).toString(), customTexture(block, folder), customTexture(block, folder)));
    }

    private void createDoorSet(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, -1, false, (block, i) -> doorBlock((DoorBlock) block, extend(customTexture(block, folder), "_bottom"), extend(customTexture(block, folder), "_top")));
    }

    private void createTrapdoorSet(ResourcefulRegistry<Block> registry, String folder) {
        createSet(registry, -1, false, (block, i) -> {
            trapdoorBlock((TrapDoorBlock) block, customTexture(block, folder), false);
            simpleBlockItem(block, new ModelFile.UncheckedModelFile(extend(blockTexture(block), "_bottom")));
        });
    }

    private void createSet(ResourcefulRegistry<Block> registry, BiConsumer<Block, Integer> consumer) {
        createSet(registry, -1, consumer);
    }

    private void createSet(ResourcefulRegistry<Block> registry, int exclude, BiConsumer<Block, Integer> consumer) {
        createSet(registry, exclude, true, consumer);
    }

    private void createSet(ResourcefulRegistry<Block> registry, int exclude, boolean makeItem, BiConsumer<Block, Integer> consumer) {
        List<Block> blocks = registry.stream().map(RegistryEntry::get).toList();
        for (int i = 0; i < blocks.size(); i++) {
            if (i + 1 == exclude) continue;
            Block block = blocks.get(i);
            consumer.accept(block, i + 1);
            if (makeItem) {
                simpleBlockItem(block, new ModelFile.UncheckedModelFile(blockTexture(block)));
            }
        }
    }

    public ResourceLocation customTexture(Block block, String folder) {
        ResourceLocation name = key(block);
        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + folder + "/" + name.getPath());
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }

    private BlockModelBuilder createChildModel(Block block, ResourceLocation parent, ResourceLocation texture, String textureName, String folder) {
        return models().getBuilder(name(block)).texture(textureName, texture).texture("particle", customTexture(block, folder)).parent(models().getExistingFile(parent));
    }

    private BlockModelBuilder createChildModel(ResourceLocation model, ResourceLocation parent, ResourceLocation texture, String textureName) {
        return models().getBuilder(model.getPath()).texture(textureName, texture).texture("particle", texture).parent(models().getExistingFile(parent));
    }
}
