package com.grimbo.chipped.block;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.api.*;
import com.grimbo.chipped.container.ChippedContainer;
import com.grimbo.chipped.container.ChippedContainerType;
import com.grimbo.chipped.item.ChippedItems;
import com.grimbo.chipped.recipe.ChippedSerializer;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.level.BlockGetter;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.grimbo.chipped.block.ChippedBlockTypes.*;

import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;

public class ChippedBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Chipped.MOD_ID);

    private static final BlockBehaviour.Properties LANTERN_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.LANTERN);

    private static final BlockBehaviour.StatePredicate ALWAYS_FALSE_POSITION = (state, world, position) -> false;
    private static final BlockBehaviour.StateArgumentPredicate<EntityType<?>> VALID_SPAWN = (state, world, position, type) -> false;

    public static final List<RegistryObject<WallTorchBlock>> WALL_TORCHES = new ArrayList<>();
    public static final List<RegistryObject<RedstoneWallTorchBlock>> REDSTONE_WALL_TORCHES = new ArrayList<>();

    public static final List<RegistryObject<CarvedPumpkinBlock>> SPECIAL_CARVED_PUMPKINS = new ArrayList<>();
    public static final List<RegistryObject<CarvedPumpkinBlock>> VANILLA_CARVED_PUMPKINS = new ArrayList<>();

    // Simple Blocks which have 18 of its own variant
    // Check ChippedBlocks/ItemTagsProvider before editing!
    public static final List<ChippedBlockType<Block>> stones18 = Stream.of(
            "granite", "diorite", "andesite", "prismarine", "dark_prismarine", "purpur_block", "quartz_block",
            "sandstone", "red_sandstone", "nether_bricks", "red_nether_bricks"
    ).map(ChippedBlockType::new).collect(Collectors.toList());

    public static final String[] specialPumpkinList = {"end", "end2", "nether"};
    public static final String[] carvedPumpkinList = {"happy", "angry", "bigeyes", "bighappy", "boo", "bruh", "classic", "enthusiastic",
            "grinning", "kawaii", "mourn", "owo", "plotting", "sans", "scared", "smallhappy", "squashy", "stretchy", "upsidedown"};

    public static final RegistryObject<Block> BOTANIST_WORKBENCH = register("botanist_workbench",
            () -> new ChippedWorkbench((id, inv, pos) -> new ChippedContainer(id, inv, pos, ChippedContainerType.BOTANIST_WORKBENCH.get(), ChippedSerializer.BOTANIST_WORKBENCH_TYPE, ChippedBlocks.BOTANIST_WORKBENCH.get()),
            BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final RegistryObject<Block> GLASSBLOWER = register("glassblower",
            () -> new ChippedWorkbench((id, inv, pos) -> new ChippedContainer(id, inv, pos, ChippedContainerType.GLASSBLOWER.get(), ChippedSerializer.GLASSBLOWER_TYPE, ChippedBlocks.GLASSBLOWER.get()),
            BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final RegistryObject<Block> CARPENTERS_TABLE = register("carpenters_table",
            () -> new ChippedWorkbench((id, inv, pos) -> new ChippedContainer(id, inv, pos, ChippedContainerType.CARPENTERS_TABLE.get(), ChippedSerializer.CARPENTERS_TABLE_TYPE, ChippedBlocks.CARPENTERS_TABLE.get()),
            BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final RegistryObject<Block> LOOM_TABLE = register("loom_table",
            () -> new ChippedWorkbench((id, inv, pos) -> new ChippedContainer(id, inv, pos, ChippedContainerType.LOOM_TABLE.get(), ChippedSerializer.LOOM_TABLE_TYPE, ChippedBlocks.LOOM_TABLE.get()),
            BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final RegistryObject<Block> MASON_TABLE = register("mason_table",
            () -> new ChippedWorkbench((id, inv, pos) -> new ChippedContainer(id, inv, pos, ChippedContainerType.MASON_TABLE.get(), ChippedSerializer.MASON_TABLE_TYPE, ChippedBlocks.MASON_TABLE.get()),
            BlockBehaviour.Properties.of(Material.METAL).strength(5F, 6F).sound(SoundType.METAL).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ALCHEMY_BENCH = register("alchemy_bench",
            () -> new ChippedWorkbench((id, inv, pos) -> new ChippedContainer(id, inv, pos, ChippedContainerType.ALCHEMY_BENCH.get(), ChippedSerializer.ALCHEMY_BENCH_TYPE, ChippedBlocks.ALCHEMY_BENCH.get()),
            BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final RegistryObject<Block> MECHANIST_WORKBENCH = register("mechanist_workbench",
            () -> new ChippedWorkbench((id, inv, pos) -> new ChippedContainer(id, inv, pos, ChippedContainerType.MECHANIST_WORKBENCH.get(), ChippedSerializer.MECHANIST_WORKBENCH_TYPE, ChippedBlocks.MECHANIST_WORKBENCH.get()),
            BlockBehaviour.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static void register() {
        // Register Stones
        for (ChippedBlockType<Block> type : stones18) {
            registerVanillaBlocks(BenchType.MASON, type, 18);
        }

        registerVanillaBlocks(BenchType.MASON, STONE, 18);
        registerVanillaBlocks(BenchType.MASON, COBBLESTONE, 18);
        registerVanillaBlocks(BenchType.MASON, END_STONE, 18);
        registerVanillaBlocks(BenchType.MASON, NETHERRACK, 18);

        registerVanillaBlocks(BenchType.MASON, Blocks.GILDED_BLACKSTONE, GILDED_BLACKSTONES, 26);
        registerVanillaBlocks(BenchType.MASON, Blocks.BLACKSTONE, BLACKSTONES, 21);
        registerVanillaBlocks(BenchType.MASON, Blocks.BASALT, BASALTS, 20);

        for (int id = 0; id < 16; ++id) {
            DyeColor color = DyeColor.byId(id);
            registerVanillaBlocks(BenchType.MASON, TERRACOTTAS.computeIfAbsent(color, k -> new ChippedBlockType<>(k + "_terracotta")), 18);
            registerVanillaBlocks(BenchType.MASON, CONCRETES.computeIfAbsent(color, k -> new ChippedBlockType<>(k + "_concrete")), 18);
        }

        registerVanillaBlocks(BenchType.ALCHEMY, Blocks.OBSIDIAN, OBSIDIAN, 20);
        final BlockBehaviour.Properties CRYING_OBSIDIAN_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.CRYING_OBSIDIAN);
        registerBlocks(BenchType.ALCHEMY, CRYING_OBSIDIAN, () -> new CryingObsidianBlock(CRYING_OBSIDIAN_PROPERTIES), 20);
        registerVanillaBlocks(BenchType.ALCHEMY, Blocks.GLOWSTONE, GLOWSTONES, 20);
        registerVanillaBlocks(BenchType.ALCHEMY, Blocks.SEA_LANTERN, SEA_LANTERNS, 16);
        registerVanillaBlocks(BenchType.BOTANIST, Blocks.SHROOMLIGHT, SHROOMLIGHTS, 16);

        final BlockBehaviour.Properties REDSTONE_LAMP_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.REDSTONE_LAMP);
        registerBlocks(BenchType.MECHANIST, REDSTONE_LAMPS, () -> new RedstoneLampBlock(REDSTONE_LAMP_PROPERTIES), 18);

        // Register Wools and Carpets
        final BlockBehaviour.Properties WOOL_PROPERTIES = BlockBehaviour.Properties.of(Material.WOOL).strength(0.1F).sound(SoundType.WOOL);
        for (int id = 0; id < 16; ++id) {
            DyeColor color = DyeColor.byId(id);
            registerVanillaBlocks(BenchType.LOOM, WOOL.computeIfAbsent(color, k -> new ChippedBlockType<>(k + "_wool")), 18);
            registerBlocks(BenchType.LOOM, CARPETS.computeIfAbsent(color, k -> new ChippedBlockType<>(k + "_carpet")), () -> new WoolCarpetBlock(color, WOOL_PROPERTIES), 18);
        }

        // Register Glasses and Stained Glasses
        final BlockBehaviour.Properties GLASS_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.GLASS);
        final BlockBehaviour.Properties GLASS_PANE_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.GLASS_PANE);
        registerBlocks(BenchType.GLASSBLOWER, GLASSES, () -> new GlassBlock(GLASS_PROPERTIES), 14);
        registerBlocks(BenchType.GLASSBLOWER, GLASS_PANES, () -> new IronBarsBlock(GLASS_PANE_PROPERTIES), 14);

        for (ChippedWoodType type : ChippedWoodType.VALUES) {
            registerBlocks(BenchType.GLASSBLOWER, GLASSES, type + "_wood_glass", () -> new GlassBlock(GLASS_PROPERTIES), 6);
            registerBlocks(BenchType.GLASSBLOWER, GLASS_PANES, type + "_wood_glass_pane", () -> new IronBarsBlock(GLASS_PANE_PROPERTIES), 6);
        }

        for (int id = 0; id < 16; ++id) {
            DyeColor color = DyeColor.byId(id);
            registerBlocks(BenchType.GLASSBLOWER, STAINED_GLASSES.computeIfAbsent(color, k -> new ChippedBlockType<>(k + "_stained_glass")), () -> new StainedGlassBlock(color, GLASS_PROPERTIES), 8);
            registerBlocks(BenchType.GLASSBLOWER, STAINED_GLASS_PANES.computeIfAbsent(color, k -> new ChippedBlockType<>(k + "_stained_glass_pane")), () -> new StainedGlassPaneBlock(color, GLASS_PANE_PROPERTIES), 8);
        }

        // Register Misc
        registerVanillaBlocks(BenchType.MASON, Blocks.CLAY, CLAYS, 19);
        registerVanillaBlocks(BenchType.BOTANIST, Blocks.DRIED_KELP_BLOCK, DRIED_KELP_BLOCKS, 12);

        final BlockBehaviour.Properties woodProperties = BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD);
        for (ChippedWoodType type : ChippedWoodType.VALUES) {
            registerBlocks(BenchType.CARPENTERS, PLANKS.computeIfAbsent(type, k -> new ChippedBlockType<>(k + "_planks")), () -> new Block(woodProperties), 18);
        }

        final BlockBehaviour.Properties hayProperties = BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK);
        registerBlocks(BenchType.BOTANIST, HAY_BLOCKS, () -> new HayBlock(hayProperties), 8);
        final BlockBehaviour.Properties melonProperties = BlockBehaviour.Properties.copy(Blocks.MELON);
        registerBlocks(BenchType.BOTANIST, MELONS, () -> new MelonBlock(melonProperties), 10);
        final BlockBehaviour.Properties vineProperties = BlockBehaviour.Properties.copy(Blocks.VINE);
        registerBlocks(BenchType.BOTANIST, VINES, () -> new VineBlock(vineProperties), 17);

        final BlockBehaviour.Properties brownMushroomProperties = BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM);
        registerBlocks(BenchType.BOTANIST, BROWN_MUSHROOMS, () -> new MushroomBlock(brownMushroomProperties, () -> TreeFeatures.HUGE_BROWN_MUSHROOM), 15);
        final BlockBehaviour.Properties redMushroomProperties = BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM);
        registerBlocks(BenchType.BOTANIST, RED_MUSHROOMS, () -> new MushroomBlock(redMushroomProperties, () -> TreeFeatures.HUGE_RED_MUSHROOM), 15);

        final BlockBehaviour.Properties warpedFungusProperties = BlockBehaviour.Properties.copy(Blocks.WARPED_FUNGUS);
        registerBlocks(BenchType.BOTANIST, WARPED_FUNGUS, () -> new MushroomBlock(warpedFungusProperties, () -> TreeFeatures.WARPED_FUNGUS_PLANTED), 14);
        final BlockBehaviour.Properties crimsonFungusProperties = BlockBehaviour.Properties.copy(Blocks.CRIMSON_FUNGUS);
        registerBlocks(BenchType.BOTANIST, CRIMSON_FUNGUS, () -> new MushroomBlock(crimsonFungusProperties, () -> TreeFeatures.CRIMSON_FUNGUS_PLANTED), 15);

        final BlockBehaviour.Properties warpedRootsProperties = BlockBehaviour.Properties.copy(Blocks.WARPED_ROOTS);
        registerBlocks(BenchType.BOTANIST, WARPED_ROOTS, () -> new RootsBlock(warpedRootsProperties), 9);
        final BlockBehaviour.Properties crimsonRootsProperties = BlockBehaviour.Properties.copy(Blocks.CRIMSON_ROOTS);
        registerBlocks(BenchType.BOTANIST, CRIMSON_ROOTS, () -> new RootsBlock(crimsonRootsProperties), 14);
        final BlockBehaviour.Properties netherSproutsProperties = BlockBehaviour.Properties.copy(Blocks.NETHER_SPROUTS);
        registerBlocks(BenchType.BOTANIST, NETHER_SPROUTS, () -> new NetherSproutsBlock(netherSproutsProperties), 20);

        final BlockBehaviour.Properties brownMushroomBlockProperties = BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM_BLOCK);
        registerBlocks(BenchType.BOTANIST, BROWN_MUSHROOM_BLOCK, () -> new HugeMushroomBlock(brownMushroomBlockProperties), 24);
        final BlockBehaviour.Properties redMushroomBlockProperties = BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM_BLOCK);
        registerBlocks(BenchType.BOTANIST, RED_MUSHROOM_BLOCK, () -> new HugeMushroomBlock(redMushroomBlockProperties), 15);

        registerVanillaBlocks(BenchType.BOTANIST, WARPED_WART_BLOCK, 14);
        registerVanillaBlocks(BenchType.BOTANIST, NETHER_WART_BLOCK, 13);

        final BlockBehaviour.Properties cobwebProperties = BlockBehaviour.Properties.copy(Blocks.COBWEB).strength(4.0F/15F, 4.0F);
        registerBlocks(BenchType.BOTANIST, COBWEBS, () -> new WebBlock(cobwebProperties), 10);

        final BlockBehaviour.Properties soulSandProperties = BlockBehaviour.Properties.copy(Blocks.SOUL_SAND);
        registerBlocks(BenchType.ALCHEMY, SOUL_SANDS, () -> new SoulSandBlock(soulSandProperties), 11);

        final BlockBehaviour.Properties lilyPadProperties = BlockBehaviour.Properties.copy(Blocks.LILY_PAD);
        for (int i = 1; i <= 6; i++) {
            String name = LILY_PAD.getId() + "_" + i;
            RegistryObject<WaterlilyBlock> lilyPad = BLOCKS.register(name, () -> new WaterlilyBlock(lilyPadProperties) {
                @Override
                public PlantType getPlantType(BlockGetter world, BlockPos pos) {
                    return net.minecraftforge.common.PlantType.WATER;
                }
            });
            BlockRegistry.addBlock(BenchType.BOTANIST, LILY_PAD, lilyPad);
            ChippedItems.ITEMS.register(name, () -> new WaterLilyBlockItem(lilyPad.get(), new Item.Properties().tab(Chipped.CHIPPED)));
        }

        // TODO please, whoever put these here, rename them - Ashley
        // Regular Lanterns
        final VoxelShape CHONK_LANTERN_SHAPE = Shapes.or(Block.box(2.0D, 0.0D, 2.0D, 14.0D, 1.0D, 14.0D), Block.box(1, 1, 1, 15, 15, 15));
        final VoxelShape THICC_LANTERN_SHAPE = Shapes.or(Block.box(2.0D, 0.0D, 2.0D, 14.0D, 1.0D, 14.0D), Block.box(1, 1, 1, 15, 15, 15));
        final VoxelShape DONUT_LANTERN_SHAPE_EAST = Block.box(5.0D, 0.0D, 1.0D, 11.0D, 15.0D, 15.0D);
        final VoxelShape DONUT_LANTERN_SHAPE_NORTH = Block.box(1.0D, 0.0D, 5.0D, 15.0D, 15.0D, 11.0D);
        final VoxelShape TALL_LANTERN_SHAPE = Block.box(5, 0, 5, 11, 15, 11);
        final VoxelShape HANGING_WOOD_LANTERN = Shapes.or(Block.box(5.0D, 2.0D, 5.0D, 11.0D, 12.0D, 11.0D), Block.box(4, 12, 4, 12, 13, 12), Block.box(4, 1, 4, 12, 2, 12),  Block.box(5, 13, 5, 11, 14, 11));
        final VoxelShape WOOD_LANTERN = Shapes.or(Block.box(5.0D, 1D, 5.0D, 11.0D, 11.0D, 11.0D), Block.box(4, 11, 4, 12, 12, 12), Block.box(4, 0, 4, 12, 1, 12), Block.box(5, 12, 5, 11, 13, 11));
        final VoxelShape HANGING_JAR_LANTERN = Shapes.or(Block.box(7.0D, 11D, 7.0D, 9.0D, 12.0D, 9.0D), Block.box(6, 5, 6, 10, 11, 10));
        final VoxelShape JAR_LANTERN  = Shapes.or(Block.box(7.0D, 6D, 7.0D, 9.0D, 7.0D, 9.0D), Block.box(6, 0, 6, 10, 6, 10));
        final VoxelShape HANGING_PAPER_LANTERN = Shapes.or(Block.box(4, 5, 4, 12, 14, 12), Block.box(5, 3, 5, 11, 5, 11), Block.box(5, 14, 5, 11, 16, 11));
        final VoxelShape PAPER_LANTERN = Shapes.or(Block.box(4, 3, 4, 12, 12, 12), Block.box(5, 1, 5, 11, 3, 11),Block.box(5, 12, 5, 11, 14, 11), Block.box(4, 0, 4, 12, 2, 12));
        final VoxelShape HANGING_PAPER_LANTERN_2 = Shapes.or(Block.box(4, 9, 4, 12, 15, 12), Block.box(5, 1 ,5, 11, 5, 11), Block.box(6, 0, 6, 10, 1, 10), Block.box(6, 5, 6, 10, 6, 10), Block.box(5, 15, 5, 11, 16, 11), Block.box(5, 8, 5, 11, 9 ,11));
        final VoxelShape PAPER_LANTERN_2 = Shapes.or(Block.box(4, 3, 4, 12, 9, 12), Block.box(5, 9, 5, 11, 10, 11), Block.box(5, 2, 5, 11, 3, 11), Block.box(4, 0, 4, 12, 2, 12));

        for (int i : new int[]{1, 3, 4}) {
            RegistryObject<LanternBlock> lantern = register("lantern_" + i, () -> new LanternBlock(LANTERN_PROPERTIES));
            BlockRegistry.addGenericBlock(BenchType.MECHANIST, LANTERNS, lantern);
        }

        registerSpecialLantern(LANTERNS, HANGING_WOOD_LANTERN, WOOD_LANTERN, 2);
        // registerSpecialLantern(LANTERNS, HANGING_CLEAR_LANTERN, CLEAR_LANTERN, 5, 7, 8);
        registerSpecialLantern(LANTERNS, HANGING_JAR_LANTERN, JAR_LANTERN, 6);
        registerSpecialLantern(LANTERNS, HANGING_PAPER_LANTERN, PAPER_LANTERN, 9, 10, 11, 12, 13, 14);

        // Regular Soul Lanterns
        for (int i : new int[]{1, 3}) {
            RegistryObject<LanternBlock> lantern = register("soul_lantern_" + i, () -> new LanternBlock(LANTERN_PROPERTIES));
            BlockRegistry.addGenericBlock(BenchType.MECHANIST, SOUL_LANTERNS, lantern);
        }

        registerSpecialLantern(SOUL_LANTERNS, HANGING_WOOD_LANTERN, WOOD_LANTERN, 2);
        registerSpecialLantern(SOUL_LANTERNS, HANGING_JAR_LANTERN, JAR_LANTERN, 5);
        // registerSpecialLantern(SOUL_LANTERNS, HANGING_CLEAR_LANTERN, CLEAR_LANTERN, 4);
        registerSpecialLantern(SOUL_LANTERNS, HANGING_PAPER_LANTERN_2, PAPER_LANTERN_2, 6, 7, 8, 9, 10, 11);

        RegistryObject<ChippedLantern> lantern1 = register("special_lantern_1", () -> new ChippedLantern(LANTERN_PROPERTIES, CHONK_LANTERN_SHAPE));
        RegistryObject<ChippedLantern> lantern2 = register("special_lantern_2", () -> new ChippedLantern(LANTERN_PROPERTIES, DONUT_LANTERN_SHAPE_EAST, DONUT_LANTERN_SHAPE_NORTH));
        RegistryObject<ChippedLantern> lantern3 = register("special_lantern_3", () -> new ChippedLantern(LANTERN_PROPERTIES, TALL_LANTERN_SHAPE));
        RegistryObject<ChippedLantern> lantern4 = register("special_lantern_4", () -> new ChippedLantern(LANTERN_PROPERTIES, THICC_LANTERN_SHAPE));

        BlockRegistry.addGenericBlock(BenchType.MECHANIST, LANTERNS, lantern1);
        BlockRegistry.addGenericBlock(BenchType.MECHANIST, LANTERNS, lantern2);
        BlockRegistry.addGenericBlock(BenchType.MECHANIST, LANTERNS, lantern3);
        BlockRegistry.addGenericBlock(BenchType.MECHANIST, LANTERNS, lantern4);

        RegistryObject<ChippedLantern> soulLantern1 = register("special_soul_lantern_1", () -> new ChippedLantern(LANTERN_PROPERTIES, CHONK_LANTERN_SHAPE));
        RegistryObject<ChippedLantern> soulLantern2 = register("special_soul_lantern_2", () -> new ChippedLantern(LANTERN_PROPERTIES, DONUT_LANTERN_SHAPE_EAST, DONUT_LANTERN_SHAPE_NORTH));
        RegistryObject<ChippedLantern> soulLantern3 = register("special_soul_lantern_3", () -> new ChippedLantern(LANTERN_PROPERTIES, TALL_LANTERN_SHAPE));
        RegistryObject<ChippedLantern> soulLantern4 = register("special_soul_lantern_4", () -> new ChippedLantern(LANTERN_PROPERTIES, THICC_LANTERN_SHAPE));

        BlockRegistry.addGenericBlock(BenchType.MECHANIST, SOUL_LANTERNS, soulLantern1);
        BlockRegistry.addGenericBlock(BenchType.MECHANIST, SOUL_LANTERNS, soulLantern2);
        BlockRegistry.addGenericBlock(BenchType.MECHANIST, SOUL_LANTERNS, soulLantern3);
        BlockRegistry.addGenericBlock(BenchType.MECHANIST, SOUL_LANTERNS, soulLantern4);


        // Redstone Torches
        final BlockBehaviour.Properties REDSTONE_TORCH_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.REDSTONE_TORCH);
        final BlockBehaviour.Properties REDSTONE_WALL_TORCH_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.REDSTONE_WALL_TORCH);
        for (int i = 2; i <= 6; i++) {
            RegistryObject<RedstoneWallTorchBlock> redstoneWallTorch = BLOCKS.register("redstone_wall_torch_" + i, () -> new RedstoneWallTorchBlock(REDSTONE_WALL_TORCH_PROPERTIES));
            RegistryObject<RedstoneTorchBlock> redstoneTorch = BLOCKS.register("redstone_torch_" + i, () -> new RedstoneTorchBlock(REDSTONE_TORCH_PROPERTIES));
            ChippedItems.ITEMS.register("redstone_torch_" + i, () -> new StandingAndWallBlockItem(redstoneTorch.get(), redstoneWallTorch.get(), new Item.Properties().tab(Chipped.CHIPPED)));
            BlockRegistry.addBlock(BenchType.MECHANIST, REDSTONE_TORCHES, redstoneTorch);
            REDSTONE_WALL_TORCHES.add(redstoneWallTorch);
        }

        // Regular Torches
        final BlockBehaviour.Properties TORCH_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.TORCH);
        final BlockBehaviour.Properties WALL_TORCH_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.WALL_TORCH);
        for (int i = 1; i <= 9; i++) {
            RegistryObject<WallTorchBlock> wallTorch = BLOCKS.register("wall_torch_" + i, () -> new WallTorchBlock(TORCH_PROPERTIES, ParticleTypes.FLAME));
            RegistryObject<TorchBlock> torch = BLOCKS.register("torch_" + i, () -> new TorchBlock(WALL_TORCH_PROPERTIES, ParticleTypes.FLAME));
            ChippedItems.ITEMS.register("torch_" + i, () -> new StandingAndWallBlockItem(torch.get(), wallTorch.get(), new Item.Properties().tab(Chipped.CHIPPED)));
            BlockRegistry.addBlock(BenchType.CARPENTERS, TORCHES, torch);
            WALL_TORCHES.add(wallTorch);
        }

        // Pumpkins
        final BlockBehaviour.Properties PUMPKIN_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN);
        final BlockBehaviour.Properties JACK_O_LANTERN_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN);
        for (String pumpkin : specialPumpkinList) {
            RegistryObject<PumpkinBlock> pumpkinBlock = register("pumpkin_" + pumpkin, () -> new PumpkinBlock(PUMPKIN_PROPERTIES));
            RegistryObject<CarvedPumpkinBlock> jackOLanternBlock = register("jack_o_lantern_" + pumpkin, () -> new CarvedPumpkinBlock(JACK_O_LANTERN_PROPERTIES));
            RegistryObject<CarvedPumpkinBlock> carvedPumpkinBlock = register("carved_pumpkin_" + pumpkin, () -> new CarvedPumpkinBlock(PUMPKIN_PROPERTIES));

            BlockRegistry.addBlock(BenchType.BOTANIST, JACK_O_LANTERNS, jackOLanternBlock);
            BlockRegistry.addBlock(BenchType.BOTANIST, CARVED_PUMPKINS, carvedPumpkinBlock);
            BlockRegistry.addBlock(BenchType.BOTANIST, PUMPKINS, pumpkinBlock);

            SPECIAL_CARVED_PUMPKINS.add(jackOLanternBlock);
            SPECIAL_CARVED_PUMPKINS.add(carvedPumpkinBlock);
        }
        // Regular Pumpkins register AFTER Special Pumpkins
        for (int i = 1; i<= 13; i++) {
            RegistryObject<PumpkinBlock> pumpkinBlock = register("pumpkin_" + i, () -> new PumpkinBlock(PUMPKIN_PROPERTIES));
            BlockRegistry.addBlock(BenchType.BOTANIST, PUMPKINS, pumpkinBlock);
        }

        // Jack'o'Lantern & Carved Pumpkins
        for (int i = 1; i <= carvedPumpkinList.length; i++) {
            RegistryObject<CarvedPumpkinBlock> jackOLanternBlock = register("jack_o_lantern_" + i, () -> new CarvedPumpkinBlock(JACK_O_LANTERN_PROPERTIES));
            RegistryObject<CarvedPumpkinBlock> carvedPumpkinBlock = register("carved_pumpkin_" + i, () -> new CarvedPumpkinBlock(PUMPKIN_PROPERTIES));

            BlockRegistry.addBlock(BenchType.BOTANIST, JACK_O_LANTERNS, jackOLanternBlock);
            BlockRegistry.addBlock(BenchType.BOTANIST, CARVED_PUMPKINS, carvedPumpkinBlock);

            VANILLA_CARVED_PUMPKINS.add(carvedPumpkinBlock);
            VANILLA_CARVED_PUMPKINS.add(jackOLanternBlock);
        }
    }

    // Registries
    private static void registerSpecialLantern(ChippedBlockType<Block> list, VoxelShape hangingShape, VoxelShape normalShape, int... indices) {
        for (int i : indices) {
            RegistryObject<LanternBlock> lantern = register(list.getId() + "_" + i, () -> new LanternBlock(LANTERN_PROPERTIES) {
                @Override
                public @NotNull VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockReader, @NotNull BlockPos pos, @NotNull CollisionContext selectionContext) {
                    return blockState.getValue(HANGING) ? hangingShape : normalShape;
                }
            });
            BlockRegistry.addGenericBlock(BenchType.MECHANIST, list, lantern);
        }
    }

    private static void registerVanillaBlocks(BenchType bench, ChippedBlockType<Block> type, int count) {
        registerVanillaBlocks(bench, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft", type.getId())), type, count);
    }

    private static void registerVanillaBlocks(BenchType bench, Block vanillaBlock, ChippedBlockType<Block> type, int count) {
        registerBlocks(bench, type, () -> new Block(BlockBehaviour.Properties.copy(vanillaBlock)), count);
    }

    private static <T extends Block> void registerBlocks(BenchType bench, ChippedBlockType<T> type, Supplier<T> block, int count) {
        registerBlocks(bench, type, type.getId(), block, count);
    }

    private static <T extends Block> void registerBlocks(BenchType bench, ChippedBlockType<T> type, String name, Supplier<T> block, int count) {
        for (int i = 1; i <= count; i++) {
            BlockRegistry.addBlock(bench, type, register(name + "_" + i, block));
        }
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        ChippedItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(Chipped.CHIPPED)));
        return toReturn;
    }
}
