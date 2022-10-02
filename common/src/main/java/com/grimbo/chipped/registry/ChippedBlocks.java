package com.grimbo.chipped.registry;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedUniqueLantern;
import com.grimbo.chipped.block.ChippedWorkbench;
import com.grimbo.chipped.menus.ChippedMenu;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.WaterLilyBlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockBehaviour.StateArgumentPredicate;
import net.minecraft.world.level.block.state.BlockBehaviour.StatePredicate;
import net.minecraft.world.level.material.Material;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class ChippedBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Chipped.MOD_ID, Registry.BLOCK_REGISTRY);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Chipped.MOD_ID, Registry.ITEM_REGISTRY);

    public static final Set<RegistrySupplier<Block>> TRANSPARENT_BLOCKS = new HashSet<>();
    public static final Set<RegistrySupplier<Block>> CUTOUT_BLOCKS = new HashSet<>();

    public static final Set<RegistrySupplier<? extends Block>> REGISTERED_BLOCKS = new HashSet<>();
    public static final Set<RegistrySupplier<? extends Block>> SKIPPED_MODELS = new HashSet<>();
    public static final Set<RegistrySupplier<? extends Block>> EXCLUDED_DROPS = new HashSet<>();
    public static final Set<Pair<RegistrySupplier<? extends Block>, RegistrySupplier<? extends Block>>> BLOCK_PAIRS = new HashSet<>();

    private static final StatePredicate ALWAYS_FALSE_POSITION = (state, world, position) -> false;
    private static final StateArgumentPredicate<EntityType<?>> VALID_SPAWN = (state, world, position, type) -> false;

    public static final RegistrySupplier<Block> BOTANIST_WORKBENCH = BLOCKS.register("botanist_workbench", () -> new ChippedWorkbench((id, inventory, position) -> new ChippedMenu(id, inventory, ChippedMenuType.BOTANIST_WORKBENCH.get(), ChippedSerializer.BOTANIST_WORKBENCH_TYPE.get(), position, ChippedBlocks.BOTANIST_WORKBENCH.get()), BlockBehaviour.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION).isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));
    public static final RegistrySupplier<Block> GLASSBLOWER = BLOCKS.register("glassblower", () -> new ChippedWorkbench((windowId, inventory, access) -> new ChippedMenu(windowId, inventory, ChippedMenuType.GLASSBLOWER.get(), ChippedSerializer.GLASSBLOWER_TYPE.get(), access, ChippedBlocks.GLASSBLOWER.get()), BlockBehaviour.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION).isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));
    public static final RegistrySupplier<Block> CARPENTERS_TABLE = BLOCKS.register("carpenters_table", () -> new ChippedWorkbench((windowId, inventory, access) -> new ChippedMenu(windowId, inventory, ChippedMenuType.CARPENTERS_TABLE.get(), ChippedSerializer.CARPENTERS_TABLE_TYPE.get(), access, ChippedBlocks.CARPENTERS_TABLE.get()), BlockBehaviour.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION).isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));
    public static final RegistrySupplier<Block> LOOM_TABLE = BLOCKS.register("loom_table", () -> new ChippedWorkbench((windowId, inventory, access) -> new ChippedMenu(windowId, inventory, ChippedMenuType.LOOM_TABLE.get(), ChippedSerializer.LOOM_TABLE_TYPE.get(), access, ChippedBlocks.LOOM_TABLE.get()), BlockBehaviour.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION).isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));
    public static final RegistrySupplier<Block> MASON_TABLE = BLOCKS.register("mason_table", () -> new ChippedWorkbench((windowId, inventory, access) -> new ChippedMenu(windowId, inventory, ChippedMenuType.MASON_TABLE.get(), ChippedSerializer.MASON_TABLE_TYPE.get(), access, ChippedBlocks.MASON_TABLE.get()), BlockBehaviour.Properties.of(Material.METAL).strength(5F, 6F).sound(SoundType.METAL).noOcclusion().isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION).isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));
    public static final RegistrySupplier<Block> ALCHEMY_BENCH = BLOCKS.register("alchemy_bench", () -> new ChippedWorkbench((windowId, inventory, access) -> new ChippedMenu(windowId, inventory, ChippedMenuType.ALCHEMY_BENCH.get(), ChippedSerializer.ALCHEMY_BENCH_TYPE.get(), access, ChippedBlocks.ALCHEMY_BENCH.get()), BlockBehaviour.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION).isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));
    public static final RegistrySupplier<Block> MECHANIST_WORKBENCH = BLOCKS.register("mechanist_workbench", () -> new ChippedWorkbench((windowId, inventory, access) -> new ChippedMenu(windowId, inventory, ChippedMenuType.MECHANIST_WORKBENCH.get(), ChippedSerializer.MECHANIST_WORKBENCH_TYPE.get(), access, ChippedBlocks.MECHANIST_WORKBENCH.get()), BlockBehaviour.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION).isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static void register() {

        // Workbenches
        ITEMS.register("botanist_workbench", () -> new BlockItem(BOTANIST_WORKBENCH.get(), new Item.Properties().tab(Chipped.CHIPPED_ITEM_GROUP)));
        ITEMS.register("glassblower", () -> new BlockItem(GLASSBLOWER.get(), new Item.Properties().tab(Chipped.CHIPPED_ITEM_GROUP)));
        ITEMS.register("carpenters_table", () -> new BlockItem(CARPENTERS_TABLE.get(), new Item.Properties().tab(Chipped.CHIPPED_ITEM_GROUP)));
        ITEMS.register("loom_table", () -> new BlockItem(LOOM_TABLE.get(), new Item.Properties().tab(Chipped.CHIPPED_ITEM_GROUP)));
        ITEMS.register("mason_table", () -> new BlockItem(MASON_TABLE.get(), new Item.Properties().tab(Chipped.CHIPPED_ITEM_GROUP)));
        ITEMS.register("alchemy_bench", () -> new BlockItem(ALCHEMY_BENCH.get(), new Item.Properties().tab(Chipped.CHIPPED_ITEM_GROUP)));
        ITEMS.register("mechanist_workbench", () -> new BlockItem(MECHANIST_WORKBENCH.get(), new Item.Properties().tab(Chipped.CHIPPED_ITEM_GROUP)));

        // Leaves
        registerBlockWithPalette(Blocks.ACACIA_LEAVES, 12, new ChippedProperties().blockType(LeavesBlock::new).transparent().excludeLoot());
        registerBlockWithPalette(Blocks.BIRCH_LEAVES, 12, new ChippedProperties().blockType(LeavesBlock::new).transparent().excludeLoot());
        registerBlockWithPalette(Blocks.DARK_OAK_LEAVES, 12, new ChippedProperties().blockType(LeavesBlock::new).transparent().excludeLoot());
        registerBlockWithPalette(Blocks.JUNGLE_LEAVES, 12, new ChippedProperties().blockType(LeavesBlock::new).transparent().excludeLoot());
        registerBlockWithPalette(Blocks.OAK_LEAVES, 12, new ChippedProperties().blockType(LeavesBlock::new).transparent().excludeLoot());
        registerBlockWithPalette(Blocks.SPRUCE_LEAVES, 12, new ChippedProperties().blockType(LeavesBlock::new).transparent().excludeLoot());

        // Planks
        registerBlockWithPalette(Blocks.ACACIA_PLANKS, 41);
        registerBlockWithPalette(Blocks.BIRCH_PLANKS, 41);
        registerBlockWithPalette(Blocks.CRIMSON_PLANKS, 41);
        registerBlockWithPalette(Blocks.DARK_OAK_PLANKS, 41);
        registerBlockWithPalette(Blocks.JUNGLE_PLANKS, 41);
        registerBlockWithPalette(Blocks.OAK_PLANKS, 41);
        registerBlockWithPalette(Blocks.SPRUCE_PLANKS, 41);
        registerBlockWithPalette(Blocks.WARPED_PLANKS, 41);
        registerBlockWithPalette(Blocks.STRIPPED_WARPED_STEM, 19, new ChippedProperties().blockType(RotatedPillarBlock::new));

        // Generic
        registerBlockWithPalette(Blocks.AMETHYST_BLOCK, 69);
        registerBlockWithPalette(Blocks.ANCIENT_DEBRIS, 69);
        registerBlockWithPalette(Blocks.ANDESITE, 69);
        registerBlockWithPalette(Blocks.BARREL, 33, new ChippedProperties().blockType(BarrelBlock::new));
        registerBlockWithPalette(Blocks.BASALT, 69);
        registerBlockWithPalette(Blocks.BLACKSTONE, 69);
        registerBlockWithPalette(Blocks.BLUE_ICE, 69);
        registerBlockWithPalette(Blocks.BONE_BLOCK, 11);
        registerBlockWithPalette(Blocks.BOOKSHELF, 57);
        registerBlockWithPalette(Blocks.BRICKS, 133);
        registerBlockWithPalette(Blocks.BROWN_MUSHROOM, 15, new ChippedProperties().blockType(p -> new MushroomBlock(p, () -> TreeFeatures.HUGE_BROWN_MUSHROOM)).cutout());
        registerBlockWithPalette(Blocks.BROWN_MUSHROOM_BLOCK, 24, new ChippedProperties().blockType(HugeMushroomBlock::new));
        registerBlockWithPalette(Blocks.CALCITE, 69);
        registerBlockWithPalette(Blocks.CARVED_PUMPKIN, 22, new ChippedProperties().blockType(CarvedPumpkinBlock::new).excludeModel());
        registerBlockWithPalette(Blocks.CLAY, 67, new ChippedProperties().excludeLoot());
        registerBlockWithPalette(Blocks.COAL_BLOCK, 67);
        registerBlockWithPalette(Blocks.COBBLESTONE, 69);
        registerBlockWithPalette(Blocks.COBWEB, 10, new ChippedProperties().blockType(WebBlock::new).cutout().excludeLoot());
        registerBlockWithPalette(Blocks.CRIMSON_FUNGUS, 15, new ChippedProperties().blockType(p -> new FungusBlock(p, () -> TreeFeatures.CRIMSON_FUNGUS_PLANTED)).cutout());
        registerBlockWithPalette(Blocks.CRIMSON_ROOTS, 14, new ChippedProperties().blockType(RootsBlock::new).cutout());
        registerBlockWithPalette(Blocks.CRYING_OBSIDIAN, 69, new ChippedProperties().blockType(CryingObsidianBlock::new));
        registerBlockWithPalette(Blocks.DARK_PRISMARINE, 69);
        registerBlockWithPalette(Blocks.DEEPSLATE, 69);
        registerBlockWithPalette(Blocks.DIAMOND_BLOCK, 12);
        registerBlockWithPalette(Blocks.DIORITE, 69);
        registerBlockWithPalette(Blocks.DIRT, 69);
        registerBlockWithPalette(Blocks.DRIED_KELP_BLOCK, 12);
        registerBlockWithPalette(Blocks.DRIPSTONE_BLOCK, 69);
        registerBlockWithPalette(Blocks.EMERALD_BLOCK, 12);
        registerBlockWithPalette(Blocks.END_STONE, 69);
        registerBlockWithPalette(Blocks.GILDED_BLACKSTONE, 69);
        registerBlockWithPalette(Blocks.GLOWSTONE, 20);
        registerBlockWithPalette(Blocks.GOLD_BLOCK, 12);
        registerBlockWithPalette(Blocks.GRANITE, 69);
        registerBlockWithPalette(Blocks.GRAVEL, 7);
        registerBlockWithPalette(Blocks.HAY_BLOCK, 8, new ChippedProperties().blockType(HayBlock::new));
        registerBlockWithPalette(Blocks.ICE, 69, new ChippedProperties().blockType(IceBlock::new));
        registerBlockWithPalette(Blocks.IRON_BARS, 21, new ChippedProperties().blockType(IronBarsBlock::new));
        registerBlockWithPalette(Blocks.IRON_BLOCK, 12);
        registerBlockWithPalette(Blocks.JACK_O_LANTERN, 22, new ChippedProperties().blockType(CarvedPumpkinBlock::new).excludeModel());
        registerBlockWithPalette(Blocks.LADDER, 10);
        registerBlockWithPalette(Blocks.LAPIS_BLOCK, 69);
        registerBlockWithPalette(Blocks.LILY_PAD, 24, new ChippedProperties().blockType(WaterlilyBlock::new).cutout().itemType(WaterLilyBlockItem::new));
        registerBlockWithPalette(Blocks.LODESTONE, 69);
        registerBlockWithPalette(Blocks.MAGMA_BLOCK, 69); // Don't use magma block type. These should not burn you.
        registerBlockWithPalette(Blocks.MELON, 10, new ChippedProperties().blockType(MelonBlock::new).excludeLoot());
        registerBlockWithPalette(Blocks.MOSS_BLOCK, 11, new ChippedProperties().blockType(MossBlock::new));
        registerBlockWithPalette(Blocks.MOSSY_COBBLESTONE, 69);
        registerBlockWithPalette(Blocks.MOSSY_STONE_BRICKS, 69);
        registerBlockWithPalette(Blocks.MUSHROOM_STEM, 7, new ChippedProperties().blockType(HugeMushroomBlock::new));
        registerBlockWithPalette(Blocks.NETHER_BRICKS, 69);
        registerBlockWithPalette(Blocks.NETHER_SPROUTS, 20, new ChippedProperties().blockType(NetherSproutsBlock::new).cutout().excludeLoot());
        registerBlockWithPalette(Blocks.NETHER_WART_BLOCK, 14);
        registerBlockWithPalette(Blocks.NETHERITE_BLOCK, 12);
        registerBlockWithPalette(Blocks.NETHERRACK, 69);
        registerBlockWithPalette(Blocks.OBSIDIAN, 69);
        registerBlockWithPalette(Blocks.PACKED_ICE, 69);
        registerBlockWithPalette(Blocks.POINTED_DRIPSTONE, 13, new ChippedProperties().blockType(PointedDripstoneBlock::new));
        registerBlockWithPalette(Blocks.PRISMARINE, 69);
        registerBlockWithPalette(Blocks.PUMPKIN, 16, new ChippedProperties().blockType(PumpkinBlock::new).excludeModel());
        registerBlockWithPalette(Blocks.PURPUR_BLOCK, 69);
        registerBlockWithPalette(Blocks.QUARTZ_BLOCK, 69);
        registerBlockWithPalette(Blocks.RAW_COPPER_BLOCK, 61);
        registerBlockWithPalette(Blocks.RAW_GOLD_BLOCK, 61);
        registerBlockWithPalette(Blocks.RAW_IRON_BLOCK, 61);
        registerBlockWithPalette(Blocks.RED_MUSHROOM, 15, new ChippedProperties().blockType(p -> new MushroomBlock(p, () -> TreeFeatures.HUGE_RED_MUSHROOM)).cutout());
        registerBlockWithPalette(Blocks.RED_MUSHROOM_BLOCK, 15, new ChippedProperties().blockType(HugeMushroomBlock::new));
        registerBlockWithPalette(Blocks.RED_NETHER_BRICKS, 69);
        registerBlockWithPalette(Blocks.RED_SANDSTONE, 69);
        registerBlockWithPalette(Blocks.REDSTONE_BLOCK, 69, new ChippedProperties().blockType(PoweredBlock::new));
        registerBlockWithPalette(Blocks.REDSTONE_LAMP, 18, new ChippedProperties().blockType(RedstoneLampBlock::new));
        registerBlockWithPalette(Blocks.SAND, 12);
        registerBlockWithPalette(Blocks.SANDSTONE, 69);
        registerBlockWithPalette(Blocks.SEA_LANTERN, 16);
        registerBlockWithPalette(Blocks.SHROOMLIGHT, 16);
        registerBlockWithPalette(Blocks.SMOOTH_STONE, 69);
        registerBlockWithPalette(Blocks.SNOW_BLOCK, 69);
        registerBlockWithPalette(Blocks.LANTERN, 14, new ChippedProperties().blockType(LanternBlock::new).cutout().excludeModel());
        registerBlockWithPalette(Blocks.SOUL_LANTERN, 11, new ChippedProperties().blockType(LanternBlock::new).cutout().excludeModel());
        registerBlockWithPalette(Blocks.SOUL_SAND, 11, new ChippedProperties().blockType(SoulSandBlock::new));
        registerBlockWithPalette(Blocks.SPONGE, 7, new ChippedProperties().blockType(SpongeBlock::new));
        registerBlockWithPalette(Blocks.STONE, 69);
        registerBlockWithPalette(Blocks.TUFF, 69);
        registerBlockWithPalette(Blocks.VINE, 17, new ChippedProperties().blockType(VineBlock::new).cutout().excludeLoot());
        registerBlockWithPalette(Blocks.WARPED_FUNGUS, 14, new ChippedProperties().blockType(p -> new FungusBlock(p, () -> TreeFeatures.WARPED_FUNGUS_PLANTED)).cutout());
        registerBlockWithPalette(Blocks.WARPED_ROOTS, 9, new ChippedProperties().blockType(RootsBlock::new).cutout());
        registerBlockWithPalette(Blocks.WARPED_WART_BLOCK, 14, new ChippedProperties().cutout());
        registerBlockWithPalette(Blocks.WAXED_COPPER_BLOCK, 11);
        registerBlockWithPalette(Blocks.WAXED_EXPOSED_COPPER, 11);
        registerBlockWithPalette(Blocks.WAXED_OXIDIZED_COPPER, 11);
        registerBlockWithPalette(Blocks.WAXED_WEATHERED_COPPER, 11);

        // Terracotta
        registerBlockWithPalette(Blocks.WHITE_TERRACOTTA, 66);
        registerBlockWithPalette(Blocks.ORANGE_TERRACOTTA, 66);
        registerBlockWithPalette(Blocks.MAGENTA_TERRACOTTA, 66);
        registerBlockWithPalette(Blocks.LIGHT_BLUE_TERRACOTTA, 66);
        registerBlockWithPalette(Blocks.YELLOW_TERRACOTTA, 66);
        registerBlockWithPalette(Blocks.LIME_TERRACOTTA, 66);
        registerBlockWithPalette(Blocks.PINK_TERRACOTTA, 66);
        registerBlockWithPalette(Blocks.GRAY_TERRACOTTA, 66);
        registerBlockWithPalette(Blocks.LIGHT_GRAY_TERRACOTTA, 66);
        registerBlockWithPalette(Blocks.CYAN_TERRACOTTA, 66);
        registerBlockWithPalette(Blocks.PURPLE_TERRACOTTA, 66);
        registerBlockWithPalette(Blocks.BLUE_TERRACOTTA, 66);
        registerBlockWithPalette(Blocks.BROWN_TERRACOTTA, 66);
        registerBlockWithPalette(Blocks.GREEN_TERRACOTTA, 66);
        registerBlockWithPalette(Blocks.RED_TERRACOTTA, 66);
        registerBlockWithPalette(Blocks.BLACK_TERRACOTTA, 66);

        // Glazed Terracotta
        registerBlockWithPalette(Blocks.WHITE_GLAZED_TERRACOTTA, 11);
        registerBlockWithPalette(Blocks.ORANGE_GLAZED_TERRACOTTA, 11);
        registerBlockWithPalette(Blocks.MAGENTA_GLAZED_TERRACOTTA, 11);
        registerBlockWithPalette(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, 11);
        registerBlockWithPalette(Blocks.YELLOW_GLAZED_TERRACOTTA, 11);
        registerBlockWithPalette(Blocks.LIME_GLAZED_TERRACOTTA, 11);
        registerBlockWithPalette(Blocks.PINK_GLAZED_TERRACOTTA, 11);
        registerBlockWithPalette(Blocks.GRAY_GLAZED_TERRACOTTA, 11);
        registerBlockWithPalette(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, 11);
        registerBlockWithPalette(Blocks.CYAN_GLAZED_TERRACOTTA, 11);
        registerBlockWithPalette(Blocks.PURPLE_GLAZED_TERRACOTTA, 11);
        registerBlockWithPalette(Blocks.BLUE_GLAZED_TERRACOTTA, 11);
        registerBlockWithPalette(Blocks.BROWN_GLAZED_TERRACOTTA, 11);
        registerBlockWithPalette(Blocks.GREEN_GLAZED_TERRACOTTA, 11);
        registerBlockWithPalette(Blocks.RED_GLAZED_TERRACOTTA, 11);
        registerBlockWithPalette(Blocks.BLACK_GLAZED_TERRACOTTA, 11);

        // Concrete
        registerBlockWithPalette(Blocks.WHITE_CONCRETE, 21);
        registerBlockWithPalette(Blocks.BLACK_CONCRETE, 21);
        registerBlockWithPalette(Blocks.BLUE_CONCRETE, 21);
        registerBlockWithPalette(Blocks.BROWN_CONCRETE, 21);
        registerBlockWithPalette(Blocks.CYAN_CONCRETE, 21);
        registerBlockWithPalette(Blocks.GRAY_CONCRETE, 21);
        registerBlockWithPalette(Blocks.GREEN_CONCRETE, 21);
        registerBlockWithPalette(Blocks.LIGHT_BLUE_CONCRETE, 21);
        registerBlockWithPalette(Blocks.LIGHT_GRAY_CONCRETE, 21);
        registerBlockWithPalette(Blocks.LIME_CONCRETE, 21);
        registerBlockWithPalette(Blocks.MAGENTA_CONCRETE, 21);
        registerBlockWithPalette(Blocks.ORANGE_CONCRETE, 21);
        registerBlockWithPalette(Blocks.PINK_CONCRETE, 21);
        registerBlockWithPalette(Blocks.PURPLE_CONCRETE, 21);
        registerBlockWithPalette(Blocks.RED_CONCRETE, 21);
        registerBlockWithPalette(Blocks.YELLOW_CONCRETE, 21);

        // Glass
        registerGlass(Blocks.GLASS, Blocks.GLASS_PANE, 106);
        registerGlass(Blocks.WHITE_STAINED_GLASS, Blocks.WHITE_STAINED_GLASS_PANE, 10);
        registerGlass(Blocks.ORANGE_STAINED_GLASS, Blocks.ORANGE_STAINED_GLASS_PANE, 10);
        registerGlass(Blocks.MAGENTA_STAINED_GLASS, Blocks.MAGENTA_STAINED_GLASS_PANE, 10);
        registerGlass(Blocks.LIGHT_BLUE_STAINED_GLASS, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, 10);
        registerGlass(Blocks.YELLOW_STAINED_GLASS, Blocks.YELLOW_STAINED_GLASS_PANE, 10);
        registerGlass(Blocks.LIME_STAINED_GLASS, Blocks.LIME_STAINED_GLASS_PANE, 10);
        registerGlass(Blocks.PINK_STAINED_GLASS, Blocks.PINK_STAINED_GLASS_PANE, 10);
        registerGlass(Blocks.GRAY_STAINED_GLASS, Blocks.GRAY_STAINED_GLASS_PANE, 10);
        registerGlass(Blocks.LIGHT_GRAY_STAINED_GLASS, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, 10);
        registerGlass(Blocks.CYAN_STAINED_GLASS, Blocks.CYAN_STAINED_GLASS_PANE, 10);
        registerGlass(Blocks.PURPLE_STAINED_GLASS, Blocks.PURPLE_STAINED_GLASS_PANE, 10);
        registerGlass(Blocks.BLUE_STAINED_GLASS, Blocks.BLUE_STAINED_GLASS_PANE, 10);
        registerGlass(Blocks.BROWN_STAINED_GLASS, Blocks.BROWN_STAINED_GLASS_PANE, 10);
        registerGlass(Blocks.GREEN_STAINED_GLASS, Blocks.GREEN_STAINED_GLASS_PANE, 10);
        registerGlass(Blocks.RED_STAINED_GLASS, Blocks.RED_STAINED_GLASS_PANE, 10);
        registerGlass(Blocks.BLACK_STAINED_GLASS, Blocks.BLACK_STAINED_GLASS_PANE, 10);

        // Wools
        registerWool(Blocks.WHITE_WOOL, Blocks.WHITE_CARPET, 20);
        registerWool(Blocks.ORANGE_WOOL, Blocks.ORANGE_CARPET, 20);
        registerWool(Blocks.MAGENTA_WOOL, Blocks.MAGENTA_CARPET, 20);
        registerWool(Blocks.LIGHT_BLUE_WOOL, Blocks.LIGHT_BLUE_CARPET, 20);
        registerWool(Blocks.YELLOW_WOOL, Blocks.YELLOW_CARPET, 20);
        registerWool(Blocks.LIME_WOOL, Blocks.LIME_CARPET, 20);
        registerWool(Blocks.PINK_WOOL, Blocks.PINK_CARPET, 20);
        registerWool(Blocks.GRAY_WOOL, Blocks.GRAY_CARPET, 20);
        registerWool(Blocks.LIGHT_GRAY_WOOL, Blocks.LIGHT_GRAY_CARPET, 20);
        registerWool(Blocks.CYAN_WOOL, Blocks.CYAN_CARPET, 20);
        registerWool(Blocks.PURPLE_WOOL, Blocks.PURPLE_CARPET, 20);
        registerWool(Blocks.BLUE_WOOL, Blocks.BLUE_CARPET, 20);
        registerWool(Blocks.BROWN_WOOL, Blocks.BROWN_CARPET, 20);
        registerWool(Blocks.GREEN_WOOL, Blocks.GREEN_CARPET, 20);
        registerWool(Blocks.RED_WOOL, Blocks.RED_CARPET, 20);
        registerWool(Blocks.BLACK_WOOL, Blocks.BLACK_CARPET, 20);

        // Torches
        registerTorch(Blocks.TORCH, Blocks.WALL_TORCH, 9, p -> new TorchBlock(p, ParticleTypes.FLAME), p -> new WallTorchBlock(p, ParticleTypes.FLAME));
        registerTorch(Blocks.REDSTONE_TORCH, Blocks.REDSTONE_WALL_TORCH, 6, RedstoneTorchBlock::new, RedstoneWallTorchBlock::new);

        // Lanterns
        register("special_lantern_1", Blocks.LANTERN, new ChippedProperties().blockType(p -> new ChippedUniqueLantern(p, ChippedUniqueLantern.CHONK_LANTERN_SHAPE)).cutout().excludeModel());
        register("special_lantern_2", Blocks.LANTERN, new ChippedProperties().blockType(p -> new ChippedUniqueLantern(p, ChippedUniqueLantern.DONUT_LANTERN_SHAPE_EAST, ChippedUniqueLantern.DONUT_LANTERN_SHAPE_NORTH)).cutout().excludeModel());
        register("special_lantern_3", Blocks.LANTERN, new ChippedProperties().blockType(p -> new ChippedUniqueLantern(p, ChippedUniqueLantern.TALL_LANTERN_SHAPE)).cutout().excludeModel());
        register("special_lantern_4", Blocks.LANTERN, new ChippedProperties().blockType(p -> new ChippedUniqueLantern(p, ChippedUniqueLantern.THICC_LANTERN_SHAPE)).cutout().excludeModel());

        // Soul Lanterns
        register("special_soul_lantern_1", Blocks.LANTERN, new ChippedProperties().blockType(p -> new ChippedUniqueLantern(p, ChippedUniqueLantern.CHONK_LANTERN_SHAPE)).cutout().excludeModel());
        register("special_soul_lantern_2", Blocks.LANTERN, new ChippedProperties().blockType(p -> new ChippedUniqueLantern(p, ChippedUniqueLantern.DONUT_LANTERN_SHAPE_EAST, ChippedUniqueLantern.DONUT_LANTERN_SHAPE_NORTH)).cutout().excludeModel());
        register("special_soul_lantern_3", Blocks.LANTERN, new ChippedProperties().blockType(p -> new ChippedUniqueLantern(p, ChippedUniqueLantern.TALL_LANTERN_SHAPE)).cutout().excludeModel());
        register("special_soul_lantern_4", Blocks.LANTERN, new ChippedProperties().blockType(p -> new ChippedUniqueLantern(p, ChippedUniqueLantern.THICC_LANTERN_SHAPE)).cutout().excludeModel());

        BLOCKS.register();
        ITEMS.register();
        REGISTERED_BLOCKS.forEach(block -> ChippedTags.addOrCreateTag(block.get()));
    }

    private static void registerWool(Block wool, Block carpet, int count) {
        registerPair(wool, carpet, count, new ChippedProperties(), new ChippedProperties().blockType(CarpetBlock::new));
    }

    private static void registerGlass(Block glass, Block pane, int count) {
        registerPair(glass, pane, count, new ChippedProperties().transparent().excludeLoot().blockType(GlassBlock::new), new ChippedProperties().transparent().excludeLoot().blockType(IronBarsBlock::new));
    }

    private static void registerTorch(Block torch, Block wallTorch, int count, Function<Properties, Block> type1, Function<Properties, Block> type2) {
        var pairs = registerPair(torch, wallTorch, count, new ChippedProperties().cutout().blockType(type1::apply).skipItem(), new ChippedProperties().cutout().excludeLoot().blockType(type2::apply).skipItem());
        int i = 0;
        for (var pair : pairs) {
            String appended = Registry.BLOCK.getKey(torch).getPath() + "_" + (i + 1);
            ITEMS.register(appended, () -> new StandingAndWallBlockItem(pair.getLeft().get(), pair.getRight().get(), new Item.Properties().tab(Chipped.CHIPPED_ITEM_GROUP)));
            i++;
        }
    }

    private static void registerBlockWithPalette(Block ref, int count) {
        registerBlockWithPalette(ref, count, new ChippedProperties().blockType(Block::new));
    }

    private static void registerBlockWithPalette(Block ref, int count, ChippedProperties properties) {
        for (int i = 0; i < count; i++) {
            String appended = Registry.BLOCK.getKey(ref).getPath() + "_" + (i + 1);
            register(appended, ref, properties);
        }
    }

    private static Set<Pair<RegistrySupplier<? extends Block>, RegistrySupplier<? extends Block>>> registerPair(Block ref, Block ref1, int count, ChippedProperties properties, ChippedProperties properties1) {
        Set<Pair<RegistrySupplier<? extends Block>, RegistrySupplier<? extends Block>>> pairs = new HashSet<>();
        for (int i = 0; i < count; i++) {
            String appended = Registry.BLOCK.getKey(ref).getPath() + "_" + (i + 1);
            RegistrySupplier<? extends Block> block = register(appended, ref, properties);

            String appended1 = Registry.BLOCK.getKey(ref1).getPath() + "_" + (i + 1);
            RegistrySupplier<? extends Block> block1 = register(appended1, ref1, properties1);

            SKIPPED_MODELS.add(block);
            SKIPPED_MODELS.add(block1);
            pairs.add(Pair.of(block, block1));
        }
        BLOCK_PAIRS.addAll(pairs);
        return pairs;
    }

    @SuppressWarnings("unchecked")
    private static RegistrySupplier<? extends Block> register(String id, Block block, ChippedProperties properties) {
        RegistrySupplier<? extends Block> registered = BLOCKS.register(id, () -> properties.getBlockType().apply(BlockBehaviour.Properties.copy(block)));

        if (!properties.skippedItem()) {
            ITEMS.register(id, () -> properties.getItemType().apply(registered.get(), new Item.Properties().tab(Chipped.CHIPPED_ITEM_GROUP)));
        }
        if (properties.isCutout()) {
            CUTOUT_BLOCKS.add((RegistrySupplier<Block>) registered);
        }
        if (properties.isTransparent()) {
            TRANSPARENT_BLOCKS.add((RegistrySupplier<Block>) registered);
        }
        if (properties.isExcludedFromLootTable()) {
            EXCLUDED_DROPS.add((RegistrySupplier<Block>) registered);
        }
        if (properties.isExcludedModel()) {
            SKIPPED_MODELS.add((RegistrySupplier<Block>) registered);
        }
        REGISTERED_BLOCKS.add(registered);
        return registered;
    }
}