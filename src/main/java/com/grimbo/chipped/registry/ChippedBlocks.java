package com.grimbo.chipped.registry;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedUniqueLantern;
import com.grimbo.chipped.block.ChippedWoodType;
import com.grimbo.chipped.block.ChippedWorkbench;
import com.grimbo.chipped.menus.ChippedMenu;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockBehaviour.StateArgumentPredicate;
import net.minecraft.world.level.block.state.BlockBehaviour.StatePredicate;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;


public class ChippedBlocks {

    private static final Properties CRYING_OBSIDIAN_PROPERTIES = FabricBlockSettings.copy(Blocks.CRYING_OBSIDIAN);
    private static final Properties HAY_BLOCK_PROPERTIES = FabricBlockSettings.copy(Blocks.HAY_BLOCK);
    private static final Properties MELON_PROPERTIES = FabricBlockSettings.copy(Blocks.MELON);
    private static final Properties VINE_PROPERTIES = FabricBlockSettings.copy(Blocks.VINE);
    private static final Properties REDSTONE_TORCH_PROPERTIES = FabricBlockSettings.copy(Blocks.REDSTONE_TORCH);
    private static final Properties REDSTONE_WALL_TORCH_PROPERTIES = FabricBlockSettings.copy(Blocks.REDSTONE_WALL_TORCH);
    private static final Properties REDSTONE_LAMP_PROPERTIES = FabricBlockSettings.copy(Blocks.REDSTONE_LAMP);
    private static final Properties TORCH_PROPERTIES = FabricBlockSettings.copy(Blocks.TORCH);
    private static final Properties WALL_TORCH_PROPERTIES = FabricBlockSettings.copy(Blocks.WALL_TORCH);
    private static final Properties PUMPKIN_PROPERTIES = FabricBlockSettings.copy(Blocks.PUMPKIN);
    private static final Properties JACK_O_LANTERN_PROPERTIES = FabricBlockSettings.copy(Blocks.JACK_O_LANTERN);
    private static final Properties WOOD_PROPERTIES = FabricBlockSettings.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD);
    private static final Properties GLASS_PANE_PROPERTIES = FabricBlockSettings.copy(Blocks.GLASS_PANE);
    private static final Properties GLASS_PROPERTIES = FabricBlockSettings.copy(Blocks.GLASS);
    private static final Properties WOOL_PROPERTIES = FabricBlockSettings.of(Material.WOOL).strength(0.1F).sound(SoundType.WOOL);
    private static final Properties LANTERN_PROPERTIES = FabricBlockSettings.copy(Blocks.LANTERN);
    private static final StatePredicate ALWAYS_FALSE_POSITION = (state, world, position) -> false;
    private static final StateArgumentPredicate<EntityType<?>> VALID_SPAWN = (state, world, position, type) -> false;
    protected static final VoxelShape CHONK_LANTERN_SHAPE = Shapes.or(Block.box(2.0D, 0.0D, 2.0D, 14.0D, 1.0D, 14.0D), Block.box(1, 1, 1, 15, 15, 15));
    protected static final VoxelShape THICC_LANTERN_SHAPE = Shapes.or(Block.box(2.0D, 0.0D, 2.0D, 14.0D, 1.0D, 14.0D), Block.box(1, 1, 1, 15, 15, 15));
    protected static final VoxelShape DONUT_LANTERN_SHAPE_EAST = Block.box(5.0D, 0.0D, 1.0D, 11.0D, 15.0D, 15.0D);
    protected static final VoxelShape DONUT_LANTERN_SHAPE_NORTH = Block.box(1.0D, 0.0D, 5.0D, 15.0D, 15.0D, 11.0D);
    protected static final VoxelShape TALL_LANTERN_SHAPE = Block.box(5, 0, 5, 11, 15, 11);
    protected static final VoxelShape HANGING_WOOD_LANTERN = Shapes.or(Block.box(5.0D, 2.0D, 5.0D, 11.0D, 12.0D, 11.0D), Block.box(4, 12, 4, 12, 13, 12), Block.box(4, 1, 4, 12, 2, 12),  Block.box(5, 13, 5, 11, 14, 11));
    protected static final VoxelShape WOOD_LANTERN = Shapes.or(Block.box(5.0D, 1D, 5.0D, 11.0D, 11.0D, 11.0D), Block.box(4, 11, 4, 12, 12, 12), Block.box(4, 0, 4, 12, 1, 12), Block.box(5, 12, 5, 11, 13, 11));
    protected static final VoxelShape HANGING_JAR_LANTERN = Shapes.or(Block.box(7.0D, 11D, 7.0D, 9.0D, 12.0D, 9.0D), Block.box(6, 5, 6, 10, 11, 10));
    protected static final VoxelShape JAR_LANTERN  = Shapes.or(Block.box(7.0D, 6D, 7.0D, 9.0D, 7.0D, 9.0D), Block.box(6, 0, 6, 10, 6, 10));
    protected static final VoxelShape HANGING_PAPER_LANTERN = Shapes.or(Block.box(4, 5, 4, 12, 14, 12), Block.box(5, 3, 5, 11, 5, 11), Block.box(5, 14, 5, 11, 16, 11));
    protected static final VoxelShape PAPER_LANTERN = Shapes.or(Block.box(4, 3, 4, 12, 12, 12), Block.box(5, 1, 5, 11, 3, 11),Block.box(5, 12, 5, 11, 14, 11), Block.box(4, 0, 4, 12, 2, 12));
    protected static final VoxelShape HANGING_PAPER_LANTERN_2 = Shapes.or(Block.box(4, 9, 4, 12, 15, 12), Block.box(5, 1 ,5, 11, 5, 11), Block.box(6, 0, 6, 10, 1, 10), Block.box(6, 5, 6, 10, 6, 10), Block.box(5, 15, 5, 11, 16, 11), Block.box(5, 8, 5, 11, 9 ,11));
    protected static final VoxelShape PAPER_LANTERN_2 = Shapes.or(Block.box(4, 3, 4, 12, 9, 12), Block.box(5, 9, 5, 11, 10, 11), Block.box(5, 2, 5, 11, 3, 11), Block.box(4, 0, 4, 12, 2, 12));


    public static final List<GlassBlock> GLASSES = new ArrayList<>();
    public static final List<IronBarsBlock> GLASS_PANES = new ArrayList<>();
    public static final EnumMap<ChippedWoodType, List<GlassBlock>> WOOD_GLASSES = new EnumMap<>(ChippedWoodType.class);
    public static final EnumMap<ChippedWoodType, List<IronBarsBlock>> WOOD_GLASS_PANES = new EnumMap<>(ChippedWoodType.class);
    public static final EnumMap<DyeColor, List<StainedGlassBlock>> STAINED_GLASSES = new EnumMap<>(DyeColor.class);
    public static final EnumMap<DyeColor, List<StainedGlassPaneBlock>> STAINED_GLASS_PANES = new EnumMap<>(DyeColor.class);

    public static final List<VineBlock> VINES = new ArrayList<>();

    public static final List<LanternBlock> LANTERNS = new ArrayList<>();
    public static final List<LanternBlock> SOUL_LANTERNS = new ArrayList<>();
    public static final List<ChippedUniqueLantern> SPECIAL_LANTERNS = new ArrayList<>();
    public static final List<ChippedUniqueLantern> SPECIAL_SOUL_LANTERNS = new ArrayList<>();

    public static final List<RedstoneTorchBlock> REDSTONE_TORCHES = new ArrayList<>();
    public static final List<RedstoneWallTorchBlock> REDSTONE_WALL_TORCHES = new ArrayList<>();
    public static final List<TorchBlock> TORCHES = new ArrayList<>();
    public static final List<WallTorchBlock> WALL_TORCHES = new ArrayList<>();

    //Simple Blocks which have 18 of its own variant
    public static final String[] stones18 = {"stone", "granite", "diorite", "andesite", "prismarine", "dark_prismarine", "purpur_block",
            "cobblestone", "quartz_block", "sandstone", "red_sandstone", "nether_bricks", "red_nether_bricks", "end_stone", "netherrack"};

    public static final String[] specialPumpkinList = {"end", "end2", "nether"};
    public static final String[] carvedPumpkinList = {"happy", "angry", "bigeyes", "bighappy", "boo", "bruh", "classic", "enthusiastic",
            "grinning", "kawaii", "mourn", "owo", "plotting", "sans", "scared", "smallhappy", "squashy", "stretchy", "upsidedown"};

    // Workbenches
    /*
     * To register a new workbench:
     * 1. Add the workbench block to ChippedBlocks
     * 2. Give it an id in ChippedWorkbench
     * 3. Register a new ContainerType in container.ChippedContainerType
     * 4. Create a new class file that extends ChippedContainer in chipped.container
     * 5. Register a new IRecipeSerializer in recipe.ChippedSerializer
     * 6. Register it in integrations.jei.JEIPlugin
     * 7. Give it both a block and container name in en_us.json
     */
    public static final Block BOTANIST_WORKBENCH = register("botanist_workbench", new ChippedWorkbench(
            (id, inventory, position) -> new ChippedMenu(id, inventory, ChippedMenuType.botanistWorkbench, ChippedSerializer.BOTANIST_WORKBENCH_TYPE, position, ChippedBlocks.BOTANIST_WORKBENCH),
            FabricBlockSettings.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final Block GLASSBLOWER = register("glassblower", new ChippedWorkbench(
            (windowId, inventory, access) -> new ChippedMenu(windowId, inventory, ChippedMenuType.glassblower, ChippedSerializer.GLASSBLOWER_TYPE, access, ChippedBlocks.GLASSBLOWER),
            FabricBlockSettings.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final Block CARPENTERS_TABLE = register("carpenters_table", new ChippedWorkbench(
            (windowId, inventory, access) -> new ChippedMenu(windowId, inventory, ChippedMenuType.carpentersTable, ChippedSerializer.CARPENTERS_TABLE_TYPE, access, ChippedBlocks.CARPENTERS_TABLE),
            FabricBlockSettings.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final Block LOOM_TABLE = register("loom_table", new ChippedWorkbench(
            (windowId, inventory, access) -> new ChippedMenu(windowId, inventory, ChippedMenuType.loomTable, ChippedSerializer.LOOM_TABLE_TYPE, access, ChippedBlocks.LOOM_TABLE),
            FabricBlockSettings.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final Block MASON_TABLE = register("mason_table", new ChippedWorkbench(
            (windowId, inventory, access) -> new ChippedMenu(windowId, inventory, ChippedMenuType.masonTable, ChippedSerializer.MASON_TABLE_TYPE, access, ChippedBlocks.MASON_TABLE),
            FabricBlockSettings.of(Material.METAL).strength(5F, 6F).sound(SoundType.METAL).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION).requiresCorrectToolForDrops()));

    public static final Block ALCHEMY_BENCH = register("alchemy_bench", new ChippedWorkbench(
            (windowId, inventory, access) -> new ChippedMenu(windowId, inventory, ChippedMenuType.alchemyBench, ChippedSerializer.ALCHEMY_BENCH_TYPE, access, ChippedBlocks.ALCHEMY_BENCH),
            FabricBlockSettings.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final Block MECHANIST_WORKBENCH = register("mechanist_workbench", new ChippedWorkbench(
            (windowId, inventory, access) -> new ChippedMenu(windowId, inventory, ChippedMenuType.mechanistWorkbench, ChippedSerializer.MECHANIST_WORKBENCH_TYPE, access, ChippedBlocks.MECHANIST_WORKBENCH),
            FabricBlockSettings.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    /*
     * To add blocks:
     * 1. Register the RegistryObject in ChippedBlocks::register with properties (ChippedBlocks::registerBlocks is for any basic blocks that extends Block)
     * 2. Give it a client render if needed in Chipped::clientRender
     * 3. Add it to the data generators in ChippedDataGenerator
     * 4. Give it a block name in en_us.json
     */
    public static void register() {
        // Register Stones
        for (String type : stones18) {
            registerVanillaBlocks(type, 18);
        }

        registerVanillaBlocks(Blocks.GILDED_BLACKSTONE, "gilded_blackstone", 26);
        registerVanillaBlocks(Blocks.BLACKSTONE, "blackstone", 21);
        registerVanillaBlocks(Blocks.BASALT, "basalt", 20);
        registerVanillaBlocks(Blocks.OBSIDIAN, "obsidian", 20);

        for (int id = 0; id < 16; ++id) {
            DyeColor color = DyeColor.byId(id);
            registerVanillaBlocks(color + "_terracotta", 18);
            registerVanillaBlocks(color + "_concrete", 18);
        }

        registerBlocks("crying_obsidian", () -> new CryingObsidianBlock(CRYING_OBSIDIAN_PROPERTIES), 20);
        registerVanillaBlocks(Blocks.GLOWSTONE, "glowstone", 20);
        registerVanillaBlocks(Blocks.SEA_LANTERN, "sea_lantern", 16);
        registerVanillaBlocks(Blocks.SHROOMLIGHT, "shroomlight", 16);
        registerBlocks("redstone_lamp", () -> new RedstoneLampBlock(REDSTONE_LAMP_PROPERTIES), 18);

        //Register Wools and Carpets
        for (int id = 0; id < 16; ++id) {
            DyeColor color = DyeColor.byId(id);
            registerVanillaBlocks(color + "_wool", 18);
            registerBlocks(color + "_carpet", () -> new WoolCarpetBlock(color, WOOL_PROPERTIES) {
            }, 18);
        }

        //Register Glasses and Stained Glasses
        registerBlocks("glass", () -> new GlassBlock(GLASS_PROPERTIES), 14, GLASSES);
        registerBlocks("glass_pane", () -> new IronBarsBlock(GLASS_PANE_PROPERTIES) {}, 14, GLASS_PANES);

        for (ChippedWoodType type : ChippedWoodType.VALUES) {
            registerBlocks(type + "_wood_glass", () -> new GlassBlock(GLASS_PROPERTIES), 6, WOOD_GLASSES.computeIfAbsent(type, k -> new ArrayList<>()));
            registerBlocks(type + "_wood_glass_pane", () -> new IronBarsBlock(GLASS_PANE_PROPERTIES) {}, 6, WOOD_GLASS_PANES.computeIfAbsent(type, k -> new ArrayList<>()));
        }

        for (int id = 0; id < 16; ++id) {
            DyeColor color = DyeColor.byId(id);
            registerBlocks(color + "_stained_glass", () -> new StainedGlassBlock(color, GLASS_PROPERTIES), 8, STAINED_GLASSES.computeIfAbsent(color, k -> new ArrayList<>()));
            registerBlocks(color + "_stained_glass_pane", () -> new StainedGlassPaneBlock(color, GLASS_PANE_PROPERTIES), 8, STAINED_GLASS_PANES.computeIfAbsent(color, k -> new ArrayList<>()));
        }

        //Register Misc
        registerVanillaBlocks(Blocks.CLAY, "clay", 19);

        for (ChippedWoodType type : ChippedWoodType.VALUES) {
            registerBlocks(type + "_planks", () -> new Block(WOOD_PROPERTIES), 18);
        }

        registerBlocks("hay_block", () -> new HayBlock(HAY_BLOCK_PROPERTIES), 8);
        registerBlocks("melon", () -> new MelonBlock(MELON_PROPERTIES) {}, 10);
        registerBlocks("vine", () -> new VineBlock(VINE_PROPERTIES), 8, VINES);

        Collections.addAll(SPECIAL_LANTERNS,
                register("special_lantern_1", new ChippedUniqueLantern(LANTERN_PROPERTIES, CHONK_LANTERN_SHAPE)),
                register("special_lantern_2", new ChippedUniqueLantern(LANTERN_PROPERTIES, DONUT_LANTERN_SHAPE_EAST, DONUT_LANTERN_SHAPE_NORTH)),
                register("special_lantern_3", new ChippedUniqueLantern(LANTERN_PROPERTIES, TALL_LANTERN_SHAPE)),
                register("special_lantern_4", new ChippedUniqueLantern(LANTERN_PROPERTIES, THICC_LANTERN_SHAPE))
        );

        Collections.addAll(SPECIAL_SOUL_LANTERNS,
                register("special_soul_lantern_1", new ChippedUniqueLantern(LANTERN_PROPERTIES, CHONK_LANTERN_SHAPE)),
                register("special_soul_lantern_2", new ChippedUniqueLantern(LANTERN_PROPERTIES, DONUT_LANTERN_SHAPE_EAST, DONUT_LANTERN_SHAPE_NORTH)),
                register("special_soul_lantern_3", new ChippedUniqueLantern(LANTERN_PROPERTIES, TALL_LANTERN_SHAPE)),
                register("special_soul_lantern_4", new ChippedUniqueLantern(LANTERN_PROPERTIES, THICC_LANTERN_SHAPE))
        );

        for(int i: new int[]{1, 3, 4}) {
            LanternBlock lantern = register("lantern_" + i, new LanternBlock(LANTERN_PROPERTIES));
            Collections.addAll(LANTERNS, lantern);
        }

        registerSpecialLantern(new int[]{2}, LANTERNS, "lantern", HANGING_WOOD_LANTERN, WOOD_LANTERN);
        //registerSpecialLantern(new int[]{5, 7, 8}, LANTERNS, "lantern", HANGING_CLEAR_LANTERN, CLEAR_LANTERN);
        registerSpecialLantern(new int[]{6}, LANTERNS,"lantern", HANGING_JAR_LANTERN, JAR_LANTERN);
        registerSpecialLantern(new int[]{9, 10, 11, 12, 13, 14}, LANTERNS,"lantern", HANGING_PAPER_LANTERN, PAPER_LANTERN);


        for(int i: new int[]{1, 3}) {
            LanternBlock lantern = register("soul_lantern_" + i, new LanternBlock(LANTERN_PROPERTIES));
            Collections.addAll(SOUL_LANTERNS, lantern);
        }

        registerSpecialLantern(new int[]{2}, SOUL_LANTERNS, "soul_lantern", HANGING_WOOD_LANTERN, WOOD_LANTERN);
        registerSpecialLantern(new int[]{5},SOUL_LANTERNS, "soul_lantern", HANGING_JAR_LANTERN, JAR_LANTERN);
        //registerSpecialLantern(new int[]{4},SOUL_LANTERNS, "soul_lantern", HANGING_CLEAR_LANTERN, CLEAR_LANTERN);
        registerSpecialLantern(new int[]{6, 7, 8, 9, 10, 11}, SOUL_LANTERNS,"soul_lantern", HANGING_PAPER_LANTERN_2, PAPER_LANTERN_2);


        //Redstone Torches
        for (int i = 2; i <= 6; i++) {
            RedstoneWallTorchBlock redstoneWallTorch = Registry.register(Registry.BLOCK, new ResourceLocation(Chipped.MOD_ID, "redstone_wall_torch_" + i), new RedstoneWallTorchBlock(REDSTONE_WALL_TORCH_PROPERTIES) {});
            RedstoneTorchBlock redstoneTorch = Registry.register(Registry.BLOCK, new ResourceLocation(Chipped.MOD_ID, "redstone_torch_" + i), new RedstoneTorchBlock(REDSTONE_TORCH_PROPERTIES) {});
            Registry.register(Registry.ITEM, "redstone_torch_" + i, new StandingAndWallBlockItem(redstoneTorch, redstoneWallTorch, new Item.Properties().tab(Chipped.CHIPPED)));

            REDSTONE_TORCHES.add(redstoneTorch);
            REDSTONE_WALL_TORCHES.add(redstoneWallTorch);
        }

        //Regular Torches
        for (int i = 1; i <= 9; i++) {
            WallTorchBlock wallTorch = Registry.register(Registry.BLOCK, new ResourceLocation(Chipped.MOD_ID, "wall_torch_" + i), new WallTorchBlock(TORCH_PROPERTIES, ParticleTypes.FLAME) {});
            TorchBlock torch = Registry.register(Registry.BLOCK, new ResourceLocation(Chipped.MOD_ID, "torch_" + i), new TorchBlock(TORCH_PROPERTIES, ParticleTypes.FLAME) {});
            Registry.register(Registry.ITEM, "torch_" + i, new StandingAndWallBlockItem(torch, wallTorch, new Item.Properties().tab(Chipped.CHIPPED)));
            TORCHES.add(torch);
            WALL_TORCHES.add(wallTorch);
        }

        //Pumpkins
        for (String pumpkin : specialPumpkinList) {
            register("pumpkin_" + pumpkin, new PumpkinBlock(PUMPKIN_PROPERTIES) {});
            register("jack_o_lantern_" + pumpkin, new CarvedPumpkinBlock(JACK_O_LANTERN_PROPERTIES) {});
            register("carved_pumpkin_" + pumpkin, new CarvedPumpkinBlock(PUMPKIN_PROPERTIES) {});
        }

        //Jack'o'Lantern & Carved Pumpkins
        for (int i = 1; i <= carvedPumpkinList.length; i++) {
            register("jack_o_lantern_" + i, new CarvedPumpkinBlock(JACK_O_LANTERN_PROPERTIES) {});
            register("carved_pumpkin_" + i, new CarvedPumpkinBlock(PUMPKIN_PROPERTIES) {});
        }
    }

    //Registries
    private static void registerSpecialLantern(int[] indexes, List<LanternBlock> list, String name, VoxelShape hangingShape, VoxelShape normalShape) {
        for(int i: indexes) {
            LanternBlock lantern = register(name + "_" + i, new LanternBlock(LANTERN_PROPERTIES){
                @Override
                public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
                    return blockState.getValue(HANGING) ? hangingShape : normalShape;
                }
            });
            Collections.addAll(list, lantern);
        }
    }
    /**
     * Only use if a vanilla block counterpart exists and the same properties should be used.
     *
     * @param name  The registry name to be used, and to infer which vanilla block should be used.
     * @param count How many of the block should be registered, the index is used as the suffix.
     */
    private static void registerVanillaBlocks(String name, int count) {
        registerVanillaBlocks(Registry.BLOCK.get(new ResourceLocation("minecraft", name)), name, count);
    }

    /**
     * Only use if a vanilla block counterpart exists and the same properties should be used.
     *
     * @param vanillaBlock The vanilla equivalent, passed explicitly 'cause explicit > implicit.
     * @param name         The registry name to be used.
     * @param count        How many of the block should be registered, the index is used as the suffix.
     */
    private static void registerVanillaBlocks(Block vanillaBlock, String name, int count) {
        registerBlocks(name, () -> new Block(FabricBlockSettings.copy(vanillaBlock)), count);
    }

    private static <T extends Block> void registerBlocks(String name, Supplier<T> block, int count) {
        registerBlocks(name, block, count, null);
    }

    /**
     * Only use if a vanilla block counterpart exists and the same properties should be used.
     *
     * @param name  The registry name to be used.
     * @param count How many of the block should be registered, the index is used as the suffix.
     */
    private static <T extends Block> void registerBlocks(String name, Supplier<T> block, int count, List<T> list) {
        for (int i = 1; i <= count; i++) {
            String newName = name + "_" + i;
            final T registered = register(newName, block.get());
            if (list != null) list.add(registered);
        }
    }

//    private static Block register(String name, Supplier<Block> block) {
//        Block toReturn = Registry.register(Registry.BLOCK, new ResourceLocation(Chipped.MOD_ID, name), block.get());
//        Registry.register(Registry.ITEM, new ResourceLocation(Chipped.MOD_ID, name), new BlockItem(block, new Item.Properties().tab(Chipped.CHIPPED)));
//        return toReturn;
//    }

    private static <T extends Block> T register(String name, T block) {
        T toReturn = Registry.register(Registry.BLOCK, new ResourceLocation(Chipped.MOD_ID, name), block);
        Registry.register(Registry.ITEM, new ResourceLocation(Chipped.MOD_ID, name), new BlockItem(block, new Item.Properties().tab(Chipped.CHIPPED)));
        return toReturn;
    }
}