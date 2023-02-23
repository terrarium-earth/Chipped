package earth.terrarium.chipped.common.registry;

import com.mojang.datafixers.util.Pair;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.block.SpecialLanternBlock;
import earth.terrarium.chipped.common.block.SpecialPointedDripstoneBlock;
import earth.terrarium.chipped.common.block.WorkbenchBlock;
import earth.terrarium.chipped.common.menu.ChippedMenu;
import earth.terrarium.chipped.common.palette.Palette;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ModBlocks {

    public static final ResourcefulRegistry<Block> BLOCKS = ResourcefulRegistries.create(Registry.BLOCK, Chipped.MOD_ID);
    public static final ResourcefulRegistry<Block> BENCHES = ResourcefulRegistries.create(BLOCKS);

    public static final RegistryEntry<Block> BOTANIST_WORKBENCH = BENCHES.register("botanist_workbench", () -> new WorkbenchBlock((id, inventory, access) -> new ChippedMenu(id, inventory, access, ModMenus.BOTANIST_WORKBENCH.get(), ModRecipeTypes.BOTANIST_WORKBENCH_TYPE.get(), ModBlocks.BOTANIST_WORKBENCH.get()), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryEntry<Block> GLASSBLOWER = BENCHES.register("glassblower", () -> new WorkbenchBlock((id, inventory, access) -> new ChippedMenu(id, inventory, access, ModMenus.GLASSBLOWER.get(), ModRecipeTypes.GLASSBLOWER_TYPE.get(), ModBlocks.GLASSBLOWER.get()), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryEntry<Block> CARPENTERS_TABLE = BENCHES.register("carpenters_table", () -> new WorkbenchBlock((id, inventory, access) -> new ChippedMenu(id, inventory, access, ModMenus.CARPENTERS_TABLE.get(), ModRecipeTypes.CARPENTERS_TABLE_TYPE.get(), ModBlocks.CARPENTERS_TABLE.get()), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryEntry<Block> LOOM_TABLE = BENCHES.register("loom_table", () -> new WorkbenchBlock((id, inventory, access) -> new ChippedMenu(id, inventory, access, ModMenus.LOOM_TABLE.get(), ModRecipeTypes.LOOM_TABLE_TYPE.get(), ModBlocks.LOOM_TABLE.get()), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryEntry<Block> MASON_TABLE = BENCHES.register("mason_table", () -> new WorkbenchBlock((id, inventory, access) -> new ChippedMenu(id, inventory, access, ModMenus.MASON_TABLE.get(), ModRecipeTypes.MASON_TABLE_TYPE.get(), ModBlocks.MASON_TABLE.get()), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryEntry<Block> ALCHEMY_BENCH = BENCHES.register("alchemy_bench", () -> new WorkbenchBlock((id, inventory, access) -> new ChippedMenu(id, inventory, access, ModMenus.ALCHEMY_BENCH.get(), ModRecipeTypes.ALCHEMY_BENCH_TYPE.get(), ModBlocks.ALCHEMY_BENCH.get()), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryEntry<Block> TINKERING_TABLE = BENCHES.register("tinkering_table", () -> new WorkbenchBlock((id, inventory, access) -> new ChippedMenu(id, inventory, access, ModMenus.TINKERING_TABLE.get(), ModRecipeTypes.TINKERING_TABLE_TYPE.get(), ModBlocks.TINKERING_TABLE.get()), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final ResourcefulRegistry<Block> AMETHYST_BLOCK = createRegistry(Blocks.AMETHYST_BLOCK, Palette.STONE);
    public static final ResourcefulRegistry<Block> COAL_BLOCK = createRegistry(Blocks.COAL_BLOCK, Palette.STONE);
    public static final ResourcefulRegistry<Block> CRYING_OBSIDIAN = createRegistry(Blocks.CRYING_OBSIDIAN, Palette.STONE, CryingObsidianBlock::new);
    public static final ResourcefulRegistry<Block> LODESTONE = createRegistry(Blocks.LODESTONE, Palette.LODESTONE);
    public static final ResourcefulRegistry<Block> LAPIS_BLOCK = createRegistry(Blocks.LAPIS_BLOCK, Palette.STONE);
    public static final ResourcefulRegistry<Block> DIAMOND_BLOCK = createRegistry(Blocks.DIAMOND_BLOCK, Palette.DIAMOND_BLOCK);
    public static final ResourcefulRegistry<Block> EMERALD_BLOCK = createRegistry(Blocks.EMERALD_BLOCK, Palette.EMERALD_BLOCK);
    public static final ResourcefulRegistry<Block> GOLD_BLOCK = createRegistry(Blocks.GOLD_BLOCK, Palette.DIAMOND_BLOCK);
    public static final ResourcefulRegistry<Block> IRON_BLOCK = createRegistry(Blocks.IRON_BLOCK, Palette.METAL);
    public static final ResourcefulRegistry<Block> NETHERITE_BLOCK = createRegistry(Blocks.NETHERITE_BLOCK, Palette.NETHERITE_BLOCK);
    public static final ResourcefulRegistry<Block> SPONGE = createRegistry(Blocks.SPONGE, Palette.SPONGE, SpongeBlock::new);
    public static final ResourcefulRegistry<Block> GLOWSTONE = createRegistry(Blocks.GLOWSTONE, Palette.GLOWSTONE);
    public static final ResourcefulRegistry<Block> WAXED_COPPER_BLOCK = createRegistry(Blocks.WAXED_COPPER_BLOCK, Palette.COPPER_BLOCK);
    public static final ResourcefulRegistry<Block> WAXED_EXPOSED_COPPER = createRegistry(Blocks.WAXED_EXPOSED_COPPER, Palette.COPPER_BLOCK);
    public static final ResourcefulRegistry<Block> WAXED_WEATHERED_COPPER = createRegistry(Blocks.WAXED_WEATHERED_COPPER, Palette.COPPER_BLOCK);
    public static final ResourcefulRegistry<Block> WAXED_OXIDIZED_COPPER = createRegistry(Blocks.WAXED_OXIDIZED_COPPER, Palette.COPPER_BLOCK);

    public static final ResourcefulRegistry<Block> BLUE_ICE = createRegistry(Blocks.BLUE_ICE, Palette.STONE);
    public static final ResourcefulRegistry<Block> DIRT = createRegistry(Blocks.DIRT, Palette.STONE);
    public static final ResourcefulRegistry<Block> ICE = createRegistry(Blocks.ICE, Palette.STONE, IceBlock::new);
    public static final ResourcefulRegistry<Block> PACKED_ICE = createRegistry(Blocks.PACKED_ICE, Palette.STONE);
    public static final ResourcefulRegistry<Block> SNOW_BLOCK = createRegistry(Blocks.SNOW_BLOCK, Palette.STONE);
    public static final ResourcefulRegistry<Block> CLAY = createRegistry(Blocks.CLAY, Palette.CLAY);
    public static final ResourcefulRegistry<Block> MUD = createRegistry(Blocks.MUD, Palette.MUD, MudBlock::new);
    public static final ResourcefulRegistry<Block> PACKED_MUD = createRegistry(Blocks.PACKED_MUD, Palette.MUD);
    public static final ResourcefulRegistry<Block> ACACIA_LEAVES = createRegistry(Blocks.ACACIA_LEAVES, Palette.LEAVES);
    public static final ResourcefulRegistry<Block> BIRCH_LEAVES = createRegistry(Blocks.BIRCH_LEAVES, Palette.LEAVES);
    public static final ResourcefulRegistry<Block> DARK_OAK_LEAVES = createRegistry(Blocks.DARK_OAK_LEAVES, Palette.LEAVES);
    public static final ResourcefulRegistry<Block> JUNGLE_LEAVES = createRegistry(Blocks.JUNGLE_LEAVES, Palette.LEAVES);
    public static final ResourcefulRegistry<Block> MANGROVE_ROOTS = createRegistry(Blocks.MANGROVE_ROOTS, Palette.ROOTS);
    public static final ResourcefulRegistry<Block> OAK_LEAVES = createRegistry(Blocks.OAK_LEAVES, Palette.LEAVES);
    public static final ResourcefulRegistry<Block> SPRUCE_LEAVES = createRegistry(Blocks.SPRUCE_LEAVES, Palette.LEAVES);
    public static final ResourcefulRegistry<Block> OCHRE_FROGLIGHT = createRegistry(Blocks.OCHRE_FROGLIGHT, Palette.FROGLIGHT);
    public static final ResourcefulRegistry<Block> PEARLESCENT_FROGLIGHT = createRegistry(Blocks.PEARLESCENT_FROGLIGHT, Palette.FROGLIGHT);
    public static final ResourcefulRegistry<Block> VERDANT_FROGLIGHT = createRegistry(Blocks.VERDANT_FROGLIGHT, Palette.FROGLIGHT);
    public static final ResourcefulRegistry<Block> BONE_BLOCK = createRegistry(Blocks.BONE_BLOCK, Palette.BONE_BLOCK, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> BROWN_MUSHROOM_BLOCK = createRegistry(Blocks.BROWN_MUSHROOM_BLOCK, Palette.MUSHROOM_BLOCK);
    public static final ResourcefulRegistry<Block> RED_MUSHROOM_BLOCK = createRegistry(Blocks.RED_MUSHROOM_BLOCK, Palette.RED_MUSHROOM_BLOCK);
    public static final ResourcefulRegistry<Block> BROWN_MUSHROOM = createRegistry(Blocks.BROWN_MUSHROOM, Palette.MUSHROOM, b -> new MushroomBlock(b, () -> TreeFeatures.HUGE_BROWN_MUSHROOM));
    public static final ResourcefulRegistry<Block> RED_MUSHROOM = createRegistry(Blocks.RED_MUSHROOM, Palette.MUSHROOM, b -> new MushroomBlock(b, () -> TreeFeatures.HUGE_RED_MUSHROOM));
    public static final ResourcefulRegistry<Block> COBWEB = createRegistry(Blocks.COBWEB, Palette.COBWEB, WebBlock::new);
    public static final ResourcefulRegistry<Block> MUSHROOM_STEM = createRegistry(Blocks.MUSHROOM_STEM, Palette.MUSHROOM_STEM, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> GRAVEL = createRegistry(Blocks.GRAVEL, Palette.GRAVEL, FallingBlock::new);
    public static final ResourcefulRegistry<Block> HAY_BLOCK = createRegistry(Blocks.HAY_BLOCK, Palette.HAY_BLOCK, HayBlock::new);
    public static final ResourcefulRegistry<Block> MOSS_BLOCK = createRegistry(Blocks.MOSS_BLOCK, Palette.MOSS_BLOCK, MossBlock::new);
    public static final ResourcefulRegistry<Block> MELON = createRegistry(Blocks.MELON, Palette.MELON, MelonBlock::new);
    public static final ResourcefulRegistry<Block> SHROOMLIGHT = createRegistry(Blocks.SHROOMLIGHT, Palette.SHROOMLIGHT);
    public static final ResourcefulRegistry<Block> SAND = createRegistry(Blocks.SAND, Palette.SAND, FallingBlock::new);
    public static final ResourcefulRegistry<Block> SOUL_SAND = createRegistry(Blocks.SOUL_SAND, Palette.SOUL_SAND, SoulSandBlock::new);
    public static final ResourcefulRegistry<Block> CRIMSON_ROOTS = createRegistry(Blocks.CRIMSON_ROOTS, Palette.CRIMSON_ROOTS, RootsBlock::new);
    public static final ResourcefulRegistry<Block> WARPED_ROOTS = createRegistry(Blocks.WARPED_ROOTS, Palette.WARPED_ROOTS, RootsBlock::new);
    public static final ResourcefulRegistry<Block> DRIED_KELP_BLOCK = createRegistry(Blocks.DRIED_KELP_BLOCK, Palette.DRIED_KELP_BLOCK);
    public static final ResourcefulRegistry<Block> LILY_PAD = createRegistry(Blocks.LILY_PAD, Palette.LILY_PAD, WaterlilyBlock::new, PlaceOnWaterBlockItem::new);
    public static final ResourcefulRegistry<Block> NETHER_SPROUTS = createRegistry(Blocks.NETHER_SPROUTS, Palette.NETHER_SPROUTS);
    public static final ResourcefulRegistry<Block> NETHER_WART_BLOCK = createRegistry(Blocks.NETHER_WART_BLOCK, Palette.WART_BLOCK);
    public static final ResourcefulRegistry<Block> PUMPKIN = createRegistry(Blocks.PUMPKIN, Palette.PUMPKIN, PumpkinBlock::new);
    public static final ResourcefulRegistry<Block> CARVED_PUMPKIN = createRegistry(Blocks.CARVED_PUMPKIN, Palette.CARVED_PUMPKIN, CarvedPumpkinBlock::new);
    public static final ResourcefulRegistry<Block> JACK_O_LANTERN = createRegistry(Blocks.JACK_O_LANTERN, Palette.CARVED_PUMPKIN, CarvedPumpkinBlock::new);
    public static final ResourcefulRegistry<Block> VINE = createRegistry(Blocks.VINE, Palette.VINE, VineBlock::new);
    public static final ResourcefulRegistry<Block> WARPED_WART_BLOCK = createRegistry(Blocks.WARPED_WART_BLOCK, Palette.WART_BLOCK);
    public static final ResourcefulRegistry<Block> CRIMSON_FUNGUS = createRegistry(Blocks.CRIMSON_FUNGUS, Palette.MUSHROOM);
    public static final ResourcefulRegistry<Block> WARPED_FUNGUS = createRegistry(Blocks.WARPED_FUNGUS, Palette.WARPED_FUNGUS);

    public static final ResourcefulRegistry<Block> ACACIA_PLANKS = createRegistry(Blocks.ACACIA_PLANKS, Palette.PLANKS);
    public static final ResourcefulRegistry<Block> BIRCH_PLANKS = createRegistry(Blocks.BIRCH_PLANKS, Palette.PLANKS);
    public static final ResourcefulRegistry<Block> DARK_OAK_PLANKS = createRegistry(Blocks.DARK_OAK_PLANKS, Palette.PLANKS);
    public static final ResourcefulRegistry<Block> JUNGLE_PLANKS = createRegistry(Blocks.JUNGLE_PLANKS, Palette.PLANKS);
    public static final ResourcefulRegistry<Block> MANGROVE_PLANKS = createRegistry(Blocks.MANGROVE_PLANKS, Palette.MANGROVE_PLANKS);
    public static final ResourcefulRegistry<Block> OAK_PLANKS = createRegistry(Blocks.OAK_PLANKS, Palette.PLANKS);
    public static final ResourcefulRegistry<Block> SPRUCE_PLANKS = createRegistry(Blocks.SPRUCE_PLANKS, Palette.PLANKS);
    public static final ResourcefulRegistry<Block> CRIMSON_PLANKS = createRegistry(Blocks.CRIMSON_PLANKS, Palette.PLANKS);
    public static final ResourcefulRegistry<Block> WARPED_PLANKS = createRegistry(Blocks.WARPED_PLANKS, Palette.PLANKS);
    public static final ResourcefulRegistry<Block> ACACIA_LOG = createRegistry(Blocks.ACACIA_LOG, Palette.LOG, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> BIRCH_LOG = createRegistry(Blocks.BIRCH_LOG, Palette.LOG, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> DARK_OAK_LOG = createRegistry(Blocks.DARK_OAK_LOG, Palette.LOG, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> JUNGLE_LOG = createRegistry(Blocks.JUNGLE_LOG, Palette.LOG, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> MANGROVE_LOG = createRegistry(Blocks.MANGROVE_LOG, Palette.LOG, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> OAK_LOG = createRegistry(Blocks.OAK_LOG, Palette.LOG, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> SPRUCE_LOG = createRegistry(Blocks.SPRUCE_LOG, Palette.LOG, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> CRIMSON_STEM = createRegistry(Blocks.CRIMSON_STEM, Palette.CRIMSON_STEM, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> WARPED_STEM = createRegistry(Blocks.WARPED_STEM, Palette.WARPED_STEM, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> BARREL = createRegistry(Blocks.BARREL, Palette.BARREL, BarrelBlock::new);
    public static final ResourcefulRegistry<Block> BOOKSHELF = createRegistry(Blocks.BOOKSHELF, Palette.BOOKSHELF);
    public static final ResourcefulRegistry<Block> LADDER = createRegistry(Blocks.LADDER, Palette.LADDER, LadderBlock::new);
    public static final ResourcefulRegistry<Block> STRIPPED_ACACIA_LOG = createRegistry(Blocks.STRIPPED_ACACIA_LOG, Palette.STRIPPED_LOG, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> STRIPPED_BIRCH_LOG = createRegistry(Blocks.STRIPPED_BIRCH_LOG, Palette.STRIPPED_LOG, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> STRIPPED_DARK_OAK_LOG = createRegistry(Blocks.STRIPPED_DARK_OAK_LOG, Palette.STRIPPED_LOG, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> STRIPPED_JUNGLE_LOG = createRegistry(Blocks.STRIPPED_JUNGLE_LOG, Palette.STRIPPED_LOG, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> STRIPPED_MANGROVE_LOG = createRegistry(Blocks.STRIPPED_MANGROVE_LOG, Palette.STRIPPED_MANGROVE_LOG, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> STRIPPED_OAK_LOG = createRegistry(Blocks.STRIPPED_OAK_LOG, Palette.STRIPPED_LOG, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> STRIPPED_SPRUCE_LOG = createRegistry(Blocks.STRIPPED_SPRUCE_LOG, Palette.STRIPPED_LOG, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> STRIPPED_WARPED_STEM = createRegistry(Blocks.STRIPPED_WARPED_STEM, Palette.STRIPPED_LOG, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> STRIPPED_CRIMSON_STEM = createRegistry(Blocks.STRIPPED_CRIMSON_STEM, Palette.STRIPPED_LOG, RotatedPillarBlock::new);
    public static final ResourcefulRegistry<Block> ACACIA_DOOR = createRegistry(Blocks.ACACIA_DOOR, Palette.ACACIA_DOOR, DoorBlock::new);
    public static final ResourcefulRegistry<Block> BIRCH_DOOR = createRegistry(Blocks.BIRCH_DOOR, Palette.BIRCH_DOOR, DoorBlock::new);
    public static final ResourcefulRegistry<Block> DARK_OAK_DOOR = createRegistry(Blocks.DARK_OAK_DOOR, Palette.DARK_OAK_DOOR, DoorBlock::new);
    public static final ResourcefulRegistry<Block> JUNGLE_DOOR = createRegistry(Blocks.JUNGLE_DOOR, Palette.JUNGLE_DOOR, DoorBlock::new);
    public static final ResourcefulRegistry<Block> MANGROVE_DOOR = createRegistry(Blocks.MANGROVE_DOOR, Palette.MANGROVE_DOOR, DoorBlock::new);
    public static final ResourcefulRegistry<Block> OAK_DOOR = createRegistry(Blocks.OAK_DOOR, Palette.DOOR, DoorBlock::new);
    public static final ResourcefulRegistry<Block> SPRUCE_DOOR = createRegistry(Blocks.SPRUCE_DOOR, Palette.SPRUCE_DOOR, DoorBlock::new);
    public static final ResourcefulRegistry<Block> CRIMSON_DOOR = createRegistry(Blocks.CRIMSON_DOOR, Palette.CRIMSON_DOOR, DoorBlock::new);
    public static final ResourcefulRegistry<Block> WARPED_DOOR = createRegistry(Blocks.WARPED_DOOR, Palette.WARPED_DOOR, DoorBlock::new);
    public static final ResourcefulRegistry<Block> ACACIA_TRAPDOOR = createRegistry(Blocks.ACACIA_TRAPDOOR, Palette.ACACIA_TRAPDOOR, TrapDoorBlock::new);
    public static final ResourcefulRegistry<Block> BIRCH_TRAPDOOR = createRegistry(Blocks.BIRCH_TRAPDOOR, Palette.TRAPDOOR, TrapDoorBlock::new);
    public static final ResourcefulRegistry<Block> DARK_OAK_TRAPDOOR = createRegistry(Blocks.DARK_OAK_TRAPDOOR, Palette.TRAPDOOR, TrapDoorBlock::new);
    public static final ResourcefulRegistry<Block> JUNGLE_TRAPDOOR = createRegistry(Blocks.JUNGLE_TRAPDOOR, Palette.JUNGLE_TRAPDOOR, TrapDoorBlock::new);
    public static final ResourcefulRegistry<Block> MANGROVE_TRAPDOOR = createRegistry(Blocks.MANGROVE_TRAPDOOR, Palette.MANGROVE_TRAPDOOR, TrapDoorBlock::new);
    public static final ResourcefulRegistry<Block> OAK_TRAPDOOR = createRegistry(Blocks.OAK_TRAPDOOR, Palette.OAK_TRAPDOOR, TrapDoorBlock::new);
    public static final ResourcefulRegistry<Block> SPRUCE_TRAPDOOR = createRegistry(Blocks.SPRUCE_TRAPDOOR, Palette.SPRUCE_TRAPDOOR, TrapDoorBlock::new);
    public static final ResourcefulRegistry<Block> CRIMSON_TRAPDOOR = createRegistry(Blocks.CRIMSON_TRAPDOOR, Palette.CRIMSON_TRAPDOOR, TrapDoorBlock::new);
    public static final ResourcefulRegistry<Block> WARPED_TRAPDOOR = createRegistry(Blocks.WARPED_TRAPDOOR, Palette.WARPED_TRAPDOOR, TrapDoorBlock::new);
    public static final Pair<ResourcefulRegistry<Block>, ResourcefulRegistry<Block>> TORCH = createTorchRegistry(Blocks.TORCH, Blocks.WALL_TORCH, Palette.TORCH, TorchBlock::new, WallTorchBlock::new);

    public static final ResourcefulRegistry<Block> GLASS = createRegistry(Blocks.GLASS, Palette.GLASS);
    public static final ResourcefulRegistry<Block> GLASS_PANE = createRegistry(Blocks.GLASS_PANE, Palette.GLASS, IronBarsBlock::new);
    public static final ResourcefulRegistry<Block> BLACK_STAINED_GLASS = createRegistry(Blocks.BLACK_STAINED_GLASS, Palette.STAINED_GLASS);
    public static final ResourcefulRegistry<Block> BLACK_STAINED_GLASS_PANE = createRegistry(Blocks.BLACK_STAINED_GLASS_PANE, Palette.STAINED_GLASS, IronBarsBlock::new);
    public static final ResourcefulRegistry<Block> BLUE_STAINED_GLASS = createRegistry(Blocks.BLUE_STAINED_GLASS, Palette.STAINED_GLASS);
    public static final ResourcefulRegistry<Block> BLUE_STAINED_GLASS_PANE = createRegistry(Blocks.BLUE_STAINED_GLASS_PANE, Palette.STAINED_GLASS, IronBarsBlock::new);
    public static final ResourcefulRegistry<Block> BROWN_STAINED_GLASS = createRegistry(Blocks.BROWN_STAINED_GLASS, Palette.STAINED_GLASS);
    public static final ResourcefulRegistry<Block> BROWN_STAINED_GLASS_PANE = createRegistry(Blocks.BROWN_STAINED_GLASS_PANE, Palette.STAINED_GLASS, IronBarsBlock::new);
    public static final ResourcefulRegistry<Block> CYAN_STAINED_GLASS = createRegistry(Blocks.CYAN_STAINED_GLASS, Palette.STAINED_GLASS);
    public static final ResourcefulRegistry<Block> CYAN_STAINED_GLASS_PANE = createRegistry(Blocks.CYAN_STAINED_GLASS_PANE, Palette.STAINED_GLASS, IronBarsBlock::new);
    public static final ResourcefulRegistry<Block> GRAY_STAINED_GLASS = createRegistry(Blocks.GRAY_STAINED_GLASS, Palette.STAINED_GLASS);
    public static final ResourcefulRegistry<Block> GRAY_STAINED_GLASS_PANE = createRegistry(Blocks.GRAY_STAINED_GLASS_PANE, Palette.STAINED_GLASS, IronBarsBlock::new);
    public static final ResourcefulRegistry<Block> GREEN_STAINED_GLASS = createRegistry(Blocks.GREEN_STAINED_GLASS, Palette.STAINED_GLASS);
    public static final ResourcefulRegistry<Block> GREEN_STAINED_GLASS_PANE = createRegistry(Blocks.GREEN_STAINED_GLASS_PANE, Palette.STAINED_GLASS, IronBarsBlock::new);
    public static final ResourcefulRegistry<Block> LIGHT_BLUE_STAINED_GLASS = createRegistry(Blocks.LIGHT_BLUE_STAINED_GLASS, Palette.STAINED_GLASS);
    public static final ResourcefulRegistry<Block> LIGHT_BLUE_STAINED_GLASS_PANE = createRegistry(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, Palette.STAINED_GLASS, IronBarsBlock::new);
    public static final ResourcefulRegistry<Block> LIGHT_GRAY_STAINED_GLASS = createRegistry(Blocks.LIGHT_GRAY_STAINED_GLASS, Palette.STAINED_GLASS);
    public static final ResourcefulRegistry<Block> LIGHT_GRAY_STAINED_GLASS_PANE = createRegistry(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, Palette.STAINED_GLASS, IronBarsBlock::new);
    public static final ResourcefulRegistry<Block> LIME_STAINED_GLASS = createRegistry(Blocks.LIME_STAINED_GLASS, Palette.STAINED_GLASS);
    public static final ResourcefulRegistry<Block> LIME_STAINED_GLASS_PANE = createRegistry(Blocks.LIME_STAINED_GLASS_PANE, Palette.STAINED_GLASS, IronBarsBlock::new);
    public static final ResourcefulRegistry<Block> MAGENTA_STAINED_GLASS = createRegistry(Blocks.MAGENTA_STAINED_GLASS, Palette.STAINED_GLASS);
    public static final ResourcefulRegistry<Block> MAGENTA_STAINED_GLASS_PANE = createRegistry(Blocks.MAGENTA_STAINED_GLASS_PANE, Palette.STAINED_GLASS, IronBarsBlock::new);
    public static final ResourcefulRegistry<Block> ORANGE_STAINED_GLASS = createRegistry(Blocks.ORANGE_STAINED_GLASS, Palette.STAINED_GLASS);
    public static final ResourcefulRegistry<Block> ORANGE_STAINED_GLASS_PANE = createRegistry(Blocks.ORANGE_STAINED_GLASS_PANE, Palette.STAINED_GLASS, IronBarsBlock::new);
    public static final ResourcefulRegistry<Block> PINK_STAINED_GLASS = createRegistry(Blocks.PINK_STAINED_GLASS, Palette.STAINED_GLASS);
    public static final ResourcefulRegistry<Block> PINK_STAINED_GLASS_PANE = createRegistry(Blocks.PINK_STAINED_GLASS_PANE, Palette.STAINED_GLASS, IronBarsBlock::new);
    public static final ResourcefulRegistry<Block> PURPLE_STAINED_GLASS = createRegistry(Blocks.PURPLE_STAINED_GLASS, Palette.STAINED_GLASS);
    public static final ResourcefulRegistry<Block> PURPLE_STAINED_GLASS_PANE = createRegistry(Blocks.PURPLE_STAINED_GLASS_PANE, Palette.STAINED_GLASS, IronBarsBlock::new);
    public static final ResourcefulRegistry<Block> RED_STAINED_GLASS = createRegistry(Blocks.RED_STAINED_GLASS, Palette.STAINED_GLASS);
    public static final ResourcefulRegistry<Block> RED_STAINED_GLASS_PANE = createRegistry(Blocks.RED_STAINED_GLASS_PANE, Palette.STAINED_GLASS, IronBarsBlock::new);
    public static final ResourcefulRegistry<Block> WHITE_STAINED_GLASS = createRegistry(Blocks.WHITE_STAINED_GLASS, Palette.STAINED_GLASS);
    public static final ResourcefulRegistry<Block> WHITE_STAINED_GLASS_PANE = createRegistry(Blocks.WHITE_STAINED_GLASS_PANE, Palette.STAINED_GLASS, IronBarsBlock::new);
    public static final ResourcefulRegistry<Block> YELLOW_STAINED_GLASS = createRegistry(Blocks.YELLOW_STAINED_GLASS, Palette.STAINED_GLASS);
    public static final ResourcefulRegistry<Block> YELLOW_STAINED_GLASS_PANE = createRegistry(Blocks.YELLOW_STAINED_GLASS_PANE, Palette.STAINED_GLASS, IronBarsBlock::new);

    public static final ResourcefulRegistry<Block> BLACK_WOOL = createRegistry(Blocks.BLACK_WOOL, Palette.WOOL);
    public static final ResourcefulRegistry<Block> BLUE_WOOL = createRegistry(Blocks.BLUE_WOOL, Palette.WOOL);
    public static final ResourcefulRegistry<Block> BROWN_WOOL = createRegistry(Blocks.BROWN_WOOL, Palette.WOOL);
    public static final ResourcefulRegistry<Block> CYAN_WOOL = createRegistry(Blocks.CYAN_WOOL, Palette.WOOL);
    public static final ResourcefulRegistry<Block> GRAY_WOOL = createRegistry(Blocks.GRAY_WOOL, Palette.WOOL);
    public static final ResourcefulRegistry<Block> GREEN_WOOL = createRegistry(Blocks.GREEN_WOOL, Palette.WOOL);
    public static final ResourcefulRegistry<Block> LIGHT_BLUE_WOOL = createRegistry(Blocks.LIGHT_BLUE_WOOL, Palette.WOOL);
    public static final ResourcefulRegistry<Block> LIGHT_GRAY_WOOL = createRegistry(Blocks.LIGHT_GRAY_WOOL, Palette.WOOL);
    public static final ResourcefulRegistry<Block> LIME_WOOL = createRegistry(Blocks.LIME_WOOL, Palette.WOOL);
    public static final ResourcefulRegistry<Block> MAGENTA_WOOL = createRegistry(Blocks.MAGENTA_WOOL, Palette.WOOL);
    public static final ResourcefulRegistry<Block> ORANGE_WOOL = createRegistry(Blocks.ORANGE_WOOL, Palette.WOOL);
    public static final ResourcefulRegistry<Block> PINK_WOOL = createRegistry(Blocks.PINK_WOOL, Palette.WOOL);
    public static final ResourcefulRegistry<Block> PURPLE_WOOL = createRegistry(Blocks.PURPLE_WOOL, Palette.WOOL);
    public static final ResourcefulRegistry<Block> RED_WOOL = createRegistry(Blocks.RED_WOOL, Palette.WOOL);
    public static final ResourcefulRegistry<Block> WHITE_WOOL = createRegistry(Blocks.WHITE_WOOL, Palette.WOOL);
    public static final ResourcefulRegistry<Block> YELLOW_WOOL = createRegistry(Blocks.YELLOW_WOOL, Palette.WOOL);
    public static final ResourcefulRegistry<Block> BLACK_CARPET = createRegistry(Blocks.BLACK_CARPET, Palette.WOOL, CarpetBlock::new);
    public static final ResourcefulRegistry<Block> BLUE_CARPET = createRegistry(Blocks.BLUE_CARPET, Palette.WOOL, CarpetBlock::new);
    public static final ResourcefulRegistry<Block> BROWN_CARPET = createRegistry(Blocks.BROWN_CARPET, Palette.WOOL, CarpetBlock::new);
    public static final ResourcefulRegistry<Block> CYAN_CARPET = createRegistry(Blocks.CYAN_CARPET, Palette.WOOL, CarpetBlock::new);
    public static final ResourcefulRegistry<Block> GRAY_CARPET = createRegistry(Blocks.GRAY_CARPET, Palette.WOOL, CarpetBlock::new);
    public static final ResourcefulRegistry<Block> GREEN_CARPET = createRegistry(Blocks.GREEN_CARPET, Palette.WOOL, CarpetBlock::new);
    public static final ResourcefulRegistry<Block> LIGHT_BLUE_CARPET = createRegistry(Blocks.LIGHT_BLUE_CARPET, Palette.WOOL, CarpetBlock::new);
    public static final ResourcefulRegistry<Block> LIGHT_GRAY_CARPET = createRegistry(Blocks.LIGHT_GRAY_CARPET, Palette.WOOL, CarpetBlock::new);
    public static final ResourcefulRegistry<Block> LIME_CARPET = createRegistry(Blocks.LIME_CARPET, Palette.WOOL, CarpetBlock::new);
    public static final ResourcefulRegistry<Block> MAGENTA_CARPET = createRegistry(Blocks.MAGENTA_CARPET, Palette.WOOL, CarpetBlock::new);
    public static final ResourcefulRegistry<Block> ORANGE_CARPET = createRegistry(Blocks.ORANGE_CARPET, Palette.WOOL, CarpetBlock::new);
    public static final ResourcefulRegistry<Block> PINK_CARPET = createRegistry(Blocks.PINK_CARPET, Palette.WOOL, CarpetBlock::new);
    public static final ResourcefulRegistry<Block> PURPLE_CARPET = createRegistry(Blocks.PURPLE_CARPET, Palette.WOOL, CarpetBlock::new);
    public static final ResourcefulRegistry<Block> RED_CARPET = createRegistry(Blocks.RED_CARPET, Palette.WOOL, CarpetBlock::new);
    public static final ResourcefulRegistry<Block> WHITE_CARPET = createRegistry(Blocks.WHITE_CARPET, Palette.WOOL, CarpetBlock::new);
    public static final ResourcefulRegistry<Block> YELLOW_CARPET = createRegistry(Blocks.YELLOW_CARPET, Palette.WOOL, CarpetBlock::new);

    public static final ResourcefulRegistry<Block> ANCIENT_DEBRIS = createRegistry(Blocks.ANCIENT_DEBRIS, Palette.STONE);
    public static final ResourcefulRegistry<Block> ANDESITE = createRegistry(Blocks.ANDESITE, Palette.STONE);
    public static final ResourcefulRegistry<Block> BASALT = createRegistry(Blocks.BASALT, Palette.BASALT);
    public static final ResourcefulRegistry<Block> BLACKSTONE = createRegistry(Blocks.BLACKSTONE, Palette.BLACKSTONE);
    public static final ResourcefulRegistry<Block> CALCITE = createRegistry(Blocks.CALCITE, Palette.STONE);
    public static final ResourcefulRegistry<Block> COBBLESTONE = createRegistry(Blocks.COBBLESTONE, Palette.STONE);
    public static final ResourcefulRegistry<Block> DARK_PRISMARINE = createRegistry(Blocks.DARK_PRISMARINE, Palette.DARK_PRISMARINE);
    public static final ResourcefulRegistry<Block> DEEPSLATE = createRegistry(Blocks.DEEPSLATE, Palette.DEEPSLATE);
    public static final ResourcefulRegistry<Block> DIORITE = createRegistry(Blocks.DIORITE, Palette.STONE);
    public static final ResourcefulRegistry<Block> DRIPSTONE_BLOCK = createRegistry(Blocks.DRIPSTONE_BLOCK, Palette.STONE);
    public static final ResourcefulRegistry<Block> END_STONE = createRegistry(Blocks.END_STONE, Palette.STONE);
    public static final ResourcefulRegistry<Block> GILDED_BLACKSTONE = createRegistry(Blocks.GILDED_BLACKSTONE, Palette.GILDED_BLACKSTONE);
    public static final ResourcefulRegistry<Block> GRANITE = createRegistry(Blocks.GRANITE, Palette.STONE);
    public static final ResourcefulRegistry<Block> MAGMA_BLOCK = createRegistry(Blocks.MAGMA_BLOCK, Palette.STONE); // Don't use the magma block type because we don't want these blocks to burn you
    public static final ResourcefulRegistry<Block> MOSSY_COBBLESTONE = createRegistry(Blocks.MOSSY_COBBLESTONE, Palette.STONE);
    public static final ResourcefulRegistry<Block> MOSSY_STONE_BRICKS = createRegistry(Blocks.MOSSY_STONE_BRICKS, Palette.MOSSY_STONE_BRICKS);
    public static final ResourcefulRegistry<Block> NETHER_BRICKS = createRegistry(Blocks.NETHER_BRICKS, Palette.STONE);
    public static final ResourcefulRegistry<Block> NETHERRACK = createRegistry(Blocks.NETHERRACK, Palette.STONE);
    public static final ResourcefulRegistry<Block> OBSIDIAN = createRegistry(Blocks.OBSIDIAN, Palette.STONE);
    public static final ResourcefulRegistry<Block> PRISMARINE = createRegistry(Blocks.PRISMARINE, Palette.PRISMARINE);
    public static final ResourcefulRegistry<Block> PURPUR_BLOCK = createRegistry(Blocks.PURPUR_BLOCK, Palette.PURPUR_BLOCK);
    public static final ResourcefulRegistry<Block> QUARTZ_BLOCK = createRegistry(Blocks.QUARTZ_BLOCK, Palette.QUARTZ_BLOCK);
    public static final ResourcefulRegistry<Block> RAW_COPPER_BLOCK = createRegistry(Blocks.RAW_COPPER_BLOCK, Palette.STONE);
    public static final ResourcefulRegistry<Block> RAW_GOLD_BLOCK = createRegistry(Blocks.RAW_GOLD_BLOCK, Palette.STONE);
    public static final ResourcefulRegistry<Block> RAW_IRON_BLOCK = createRegistry(Blocks.RAW_IRON_BLOCK, Palette.STONE);
    public static final ResourcefulRegistry<Block> RED_NETHER_BRICKS = createRegistry(Blocks.RED_NETHER_BRICKS, Palette.STONE);
    public static final ResourcefulRegistry<Block> RED_SANDSTONE = createRegistry(Blocks.RED_SANDSTONE, Palette.STONE);
    public static final ResourcefulRegistry<Block> SANDSTONE = createRegistry(Blocks.SANDSTONE, Palette.STONE);
    public static final ResourcefulRegistry<Block> STONE = createRegistry(Blocks.STONE, Palette.BASE_STONE);
    public static final ResourcefulRegistry<Block> SMOOTH_STONE = createRegistry(Blocks.SMOOTH_STONE, Palette.STONE);
    public static final ResourcefulRegistry<Block> TUFF = createRegistry(Blocks.TUFF, Palette.STONE);
    public static final ResourcefulRegistry<Block> TERRACOTTA = createRegistry(Blocks.TERRACOTTA, Palette.TERRACOTTA);
    public static final ResourcefulRegistry<Block> BLACK_TERRACOTTA = createRegistry(Blocks.BLACK_TERRACOTTA, Palette.TERRACOTTA);
    public static final ResourcefulRegistry<Block> BLUE_TERRACOTTA = createRegistry(Blocks.BLUE_TERRACOTTA, Palette.TERRACOTTA);
    public static final ResourcefulRegistry<Block> BROWN_TERRACOTTA = createRegistry(Blocks.BROWN_TERRACOTTA, Palette.TERRACOTTA);
    public static final ResourcefulRegistry<Block> CYAN_TERRACOTTA = createRegistry(Blocks.CYAN_TERRACOTTA, Palette.TERRACOTTA);
    public static final ResourcefulRegistry<Block> GRAY_TERRACOTTA = createRegistry(Blocks.GRAY_TERRACOTTA, Palette.TERRACOTTA);
    public static final ResourcefulRegistry<Block> GREEN_TERRACOTTA = createRegistry(Blocks.GREEN_TERRACOTTA, Palette.TERRACOTTA);
    public static final ResourcefulRegistry<Block> LIGHT_BLUE_TERRACOTTA = createRegistry(Blocks.LIGHT_BLUE_TERRACOTTA, Palette.TERRACOTTA);
    public static final ResourcefulRegistry<Block> LIGHT_GRAY_TERRACOTTA = createRegistry(Blocks.LIGHT_GRAY_TERRACOTTA, Palette.TERRACOTTA);
    public static final ResourcefulRegistry<Block> LIME_TERRACOTTA = createRegistry(Blocks.LIME_TERRACOTTA, Palette.TERRACOTTA);
    public static final ResourcefulRegistry<Block> MAGENTA_TERRACOTTA = createRegistry(Blocks.MAGENTA_TERRACOTTA, Palette.TERRACOTTA);
    public static final ResourcefulRegistry<Block> ORANGE_TERRACOTTA = createRegistry(Blocks.ORANGE_TERRACOTTA, Palette.TERRACOTTA);
    public static final ResourcefulRegistry<Block> PINK_TERRACOTTA = createRegistry(Blocks.PINK_TERRACOTTA, Palette.TERRACOTTA);
    public static final ResourcefulRegistry<Block> PURPLE_TERRACOTTA = createRegistry(Blocks.PURPLE_TERRACOTTA, Palette.TERRACOTTA);
    public static final ResourcefulRegistry<Block> RED_TERRACOTTA = createRegistry(Blocks.RED_TERRACOTTA, Palette.TERRACOTTA);
    public static final ResourcefulRegistry<Block> WHITE_TERRACOTTA = createRegistry(Blocks.WHITE_TERRACOTTA, Palette.TERRACOTTA);
    public static final ResourcefulRegistry<Block> YELLOW_TERRACOTTA = createRegistry(Blocks.YELLOW_TERRACOTTA, Palette.TERRACOTTA);
    public static final ResourcefulRegistry<Block> BLACK_GLAZED_TERRACOTTA = createRegistry(Blocks.BLACK_GLAZED_TERRACOTTA, Palette.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ResourcefulRegistry<Block> BLUE_GLAZED_TERRACOTTA = createRegistry(Blocks.BLUE_GLAZED_TERRACOTTA, Palette.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ResourcefulRegistry<Block> BROWN_GLAZED_TERRACOTTA = createRegistry(Blocks.BROWN_GLAZED_TERRACOTTA, Palette.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ResourcefulRegistry<Block> CYAN_GLAZED_TERRACOTTA = createRegistry(Blocks.CYAN_GLAZED_TERRACOTTA, Palette.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ResourcefulRegistry<Block> GRAY_GLAZED_TERRACOTTA = createRegistry(Blocks.GRAY_GLAZED_TERRACOTTA, Palette.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ResourcefulRegistry<Block> GREEN_GLAZED_TERRACOTTA = createRegistry(Blocks.GREEN_GLAZED_TERRACOTTA, Palette.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ResourcefulRegistry<Block> LIGHT_BLUE_GLAZED_TERRACOTTA = createRegistry(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, Palette.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ResourcefulRegistry<Block> LIGHT_GRAY_GLAZED_TERRACOTTA = createRegistry(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, Palette.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ResourcefulRegistry<Block> LIME_GLAZED_TERRACOTTA = createRegistry(Blocks.LIME_GLAZED_TERRACOTTA, Palette.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ResourcefulRegistry<Block> MAGENTA_GLAZED_TERRACOTTA = createRegistry(Blocks.MAGENTA_GLAZED_TERRACOTTA, Palette.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ResourcefulRegistry<Block> ORANGE_GLAZED_TERRACOTTA = createRegistry(Blocks.ORANGE_GLAZED_TERRACOTTA, Palette.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ResourcefulRegistry<Block> PINK_GLAZED_TERRACOTTA = createRegistry(Blocks.PINK_GLAZED_TERRACOTTA, Palette.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ResourcefulRegistry<Block> PURPLE_GLAZED_TERRACOTTA = createRegistry(Blocks.PURPLE_GLAZED_TERRACOTTA, Palette.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ResourcefulRegistry<Block> RED_GLAZED_TERRACOTTA = createRegistry(Blocks.RED_GLAZED_TERRACOTTA, Palette.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ResourcefulRegistry<Block> WHITE_GLAZED_TERRACOTTA = createRegistry(Blocks.WHITE_GLAZED_TERRACOTTA, Palette.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ResourcefulRegistry<Block> YELLOW_GLAZED_TERRACOTTA = createRegistry(Blocks.YELLOW_GLAZED_TERRACOTTA, Palette.GLAZED_TERRACOTTA, GlazedTerracottaBlock::new);
    public static final ResourcefulRegistry<Block> BLACK_CONCRETE = createRegistry(Blocks.BLACK_CONCRETE, Palette.CONCRETE);
    public static final ResourcefulRegistry<Block> BLUE_CONCRETE = createRegistry(Blocks.BLUE_CONCRETE, Palette.CONCRETE);
    public static final ResourcefulRegistry<Block> BROWN_CONCRETE = createRegistry(Blocks.BROWN_CONCRETE, Palette.CONCRETE);
    public static final ResourcefulRegistry<Block> CYAN_CONCRETE = createRegistry(Blocks.CYAN_CONCRETE, Palette.CONCRETE);
    public static final ResourcefulRegistry<Block> GRAY_CONCRETE = createRegistry(Blocks.GRAY_CONCRETE, Palette.CONCRETE);
    public static final ResourcefulRegistry<Block> GREEN_CONCRETE = createRegistry(Blocks.GREEN_CONCRETE, Palette.CONCRETE);
    public static final ResourcefulRegistry<Block> LIGHT_BLUE_CONCRETE = createRegistry(Blocks.LIGHT_BLUE_CONCRETE, Palette.CONCRETE);
    public static final ResourcefulRegistry<Block> LIGHT_GRAY_CONCRETE = createRegistry(Blocks.LIGHT_GRAY_CONCRETE, Palette.CONCRETE);
    public static final ResourcefulRegistry<Block> LIME_CONCRETE = createRegistry(Blocks.LIME_CONCRETE, Palette.CONCRETE);
    public static final ResourcefulRegistry<Block> MAGENTA_CONCRETE = createRegistry(Blocks.MAGENTA_CONCRETE, Palette.CONCRETE);
    public static final ResourcefulRegistry<Block> ORANGE_CONCRETE = createRegistry(Blocks.ORANGE_CONCRETE, Palette.CONCRETE);
    public static final ResourcefulRegistry<Block> PINK_CONCRETE = createRegistry(Blocks.PINK_CONCRETE, Palette.CONCRETE);
    public static final ResourcefulRegistry<Block> PURPLE_CONCRETE = createRegistry(Blocks.PURPLE_CONCRETE, Palette.CONCRETE);
    public static final ResourcefulRegistry<Block> RED_CONCRETE = createRegistry(Blocks.RED_CONCRETE, Palette.CONCRETE);
    public static final ResourcefulRegistry<Block> WHITE_CONCRETE = createRegistry(Blocks.WHITE_CONCRETE, Palette.CONCRETE);
    public static final ResourcefulRegistry<Block> YELLOW_CONCRETE = createRegistry(Blocks.YELLOW_CONCRETE, Palette.CONCRETE);
    public static final ResourcefulRegistry<Block> BRICKS = createRegistry(Blocks.BRICKS, Palette.BRICKS);
    public static final ResourcefulRegistry<Block> MUD_BRICKS = createRegistry(Blocks.MUD_BRICKS, Palette.MUD);
    public static final ResourcefulRegistry<Block> POINTED_DRIPSTONE = createRegistry(Blocks.POINTED_DRIPSTONE, Palette.POINTED_DRIPSTONE, SpecialPointedDripstoneBlock::new);

    public static final ResourcefulRegistry<Block> IRON_BARS = createRegistry(Blocks.IRON_BARS, Palette.IRON_BARS, IronBarsBlock::new);
    public static final ResourcefulRegistry<Block> SEA_LANTERN = createRegistry(Blocks.SEA_LANTERN, Palette.SEA_LANTERN);
    public static final ResourcefulRegistry<Block> REDSTONE_LAMP = createRegistry(Blocks.REDSTONE_LAMP, Palette.REDSTONE_LAMP, RedstoneLampBlock::new);
    public static final ResourcefulRegistry<Block> REDSTONE_BLOCK = createRegistry(Blocks.REDSTONE_BLOCK, Palette.STONE);
    public static final ResourcefulRegistry<Block> LANTERN = createRegistry(Blocks.LANTERN, Palette.LANTERN, LanternBlock::new);
    public static final ResourcefulRegistry<Block> SOUL_LANTERN = createRegistry(Blocks.SOUL_LANTERN, Palette.SOUL_LANTERN, LanternBlock::new);
    public static final ResourcefulRegistry<Block> SPECIAL_LANTERN = registerSpecialLanterns("special_lantern", Palette.SPECIAL_LANTERN);
    public static final ResourcefulRegistry<Block> SPECIAL_SOUL_LANTERN = registerSpecialLanterns("special_soul_lantern", Palette.SPECIAL_SOUL_LANTERN);
    public static final Pair<ResourcefulRegistry<Block>, ResourcefulRegistry<Block>> REDSTONE_TORCH = createTorchRegistry(Blocks.REDSTONE_TORCH, Blocks.REDSTONE_WALL_TORCH, Palette.REDSTONE_TORCH, (p, o) -> new RedstoneTorchBlock(p), (p, o) -> new RedstoneWallTorchBlock(p));


    public static ResourcefulRegistry<Block> createRegistry(Block ref, Palette palette) {
        return createRegistry(ref, palette, Block::new);
    }

    public static ResourcefulRegistry<Block> createRegistry(Block ref, Palette palette, Function<BlockBehaviour.Properties, Block> blockType) {
        return createRegistry(ref, palette, blockType, BlockItem::new);
    }

    public static ResourcefulRegistry<Block> createRegistry(Block ref, Palette palette, Function<BlockBehaviour.Properties, Block> blockType, BiFunction<Block, Item.Properties, BlockItem> itemType) {
        var registry = ResourcefulRegistries.create(BLOCKS);
        for (int i = 0; i < palette.getNames().length; i++) {
            String id = palette.getName(i).replace("%", Registry.BLOCK.getKey(ref).getPath().toLowerCase(Locale.ROOT));
            registry.register(id, () -> blockType.apply(BlockBehaviour.Properties.copy(ref)));
        }
        ModItems.createItemRegistry(registry, itemType);
        return registry;
    }

    public static Pair<ResourcefulRegistry<Block>, ResourcefulRegistry<Block>> createTorchRegistry(Block ref1, Block ref2, Palette palette, BiFunction<BlockBehaviour.Properties, ParticleOptions, Block> blockType1, BiFunction<BlockBehaviour.Properties, ParticleOptions, Block> blockType2) {
        var registry1 = ResourcefulRegistries.create(BLOCKS);
        var registry2 = ResourcefulRegistries.create(BLOCKS);
        var itemRegistry = ResourcefulRegistries.create(ModItems.ITEMS);

        for (int i = 0; i < palette.getNames().length; i++) {
            String id1 = palette.getName(i).replace("%", Registry.BLOCK.getKey(ref1).getPath().toLowerCase(Locale.ROOT));
            RegistryEntry<Block> torch1 = registry1.register(id1, () -> blockType1.apply(BlockBehaviour.Properties.copy(ref1), ParticleTypes.FLAME));

            String id2 = palette.getName(i).replace("%", Registry.BLOCK.getKey(ref2).getPath().toLowerCase(Locale.ROOT));
            RegistryEntry<Block> torch2 = registry2.register(id2, () -> blockType2.apply(BlockBehaviour.Properties.copy(ref2), ParticleTypes.FLAME));

            itemRegistry.register(torch1.getId().getPath(), () -> new StandingAndWallBlockItem(torch1.get(), torch2.get(), new Item.Properties().tab(ModItems.ITEM_GROUP)));
        }

        return Pair.of(registry1, registry2);
    }

    public static ResourcefulRegistry<Block> registerSpecialLanterns(String block, Palette palette) {
        var registry = ResourcefulRegistries.create(BLOCKS);
        String[] names = palette.getNames();
        registry.register(names[0].replace("%", block), () -> new SpecialLanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN), SpecialLanternBlock.CHONK_LANTERN_SHAPE));
        registry.register(names[1].replace("%", block), () -> new SpecialLanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN), SpecialLanternBlock.DONUT_LANTERN_SHAPE_EAST, SpecialLanternBlock.DONUT_LANTERN_SHAPE_NORTH));
        registry.register(names[2].replace("%", block), () -> new SpecialLanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN), SpecialLanternBlock.TALL_LANTERN_SHAPE));
        registry.register(names[3].replace("%", block), () -> new SpecialLanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN), SpecialLanternBlock.THICC_LANTERN_SHAPE));
        ModItems.createItemRegistry(registry, BlockItem::new);
        return registry;
    }
}
