package com.grimbo.chipped.block;

import com.google.common.collect.ImmutableSet;
import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.api.BenchType;
import com.grimbo.chipped.api.BlockRegistry;
import com.grimbo.chipped.api.ChippedBlockType;
import com.grimbo.chipped.api.ChippedWoodType;
import com.grimbo.chipped.container.ChippedContainer;
import com.grimbo.chipped.container.ChippedContainerType;
import com.grimbo.chipped.item.ChippedItems;
import com.grimbo.chipped.recipe.ChippedSerializer;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.grimbo.chipped.block.ChippedBlockTypes.*;

public class ChippedBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Chipped.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Chipped.MOD_ID);

    private static final AbstractBlock.Properties LANTERN_PROPERTIES = AbstractBlock.Properties.copy(Blocks.LANTERN);

    private static final AbstractBlock.IPositionPredicate ALWAYS_FALSE_POSITION = (state, world, position) -> false;
    private static final AbstractBlock.IExtendedPositionPredicate<EntityType<?>> VALID_SPAWN = (state, world, position, type) -> false;

    public static final List<RegistryObject<WallTorchBlock>> WALL_TORCHES = new ArrayList<>();
    public static final List<RegistryObject<RedstoneWallTorchBlock>> REDSTONE_WALL_TORCHES = new ArrayList<>();

    public static final List<RegistryObject<CarvedPumpkinBlock>> SPECIAL_CARVED_PUMPKINS = new ArrayList<>();
    public static final List<RegistryObject<CarvedPumpkinBlock>> VANILLA_CARVED_PUMPKINS = new ArrayList<>();

    public static final String[] specialPumpkinList = {"end", "end2", "nether"};
    public static final String[] carvedPumpkinList = {"happy", "angry", "bigeyes", "bighappy", "boo", "bruh", "classic", "enthusiastic",
            "grinning", "kawaii", "mourn", "owo", "plotting", "sans", "scared", "smallhappy", "squashy", "stretchy", "upsidedown"};

    public static final RegistryObject<Block> BOTANIST_WORKBENCH = register("botanist_workbench",
            () -> new ChippedWorkbench((id, inv, pos) -> new ChippedContainer(id, inv, pos, ChippedContainerType.BOTANIST_WORKBENCH.get(), ChippedSerializer.BOTANIST_WORKBENCH_TYPE, ChippedBlocks.BOTANIST_WORKBENCH.get()),
            AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final RegistryObject<Block> GLASSBLOWER = register("glassblower",
            () -> new ChippedWorkbench((id, inv, pos) -> new ChippedContainer(id, inv, pos, ChippedContainerType.GLASSBLOWER.get(), ChippedSerializer.GLASSBLOWER_TYPE, ChippedBlocks.GLASSBLOWER.get()),
            AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final RegistryObject<Block> CARPENTERS_TABLE = register("carpenters_table",
            () -> new ChippedWorkbench((id, inv, pos) -> new ChippedContainer(id, inv, pos, ChippedContainerType.CARPENTERS_TABLE.get(), ChippedSerializer.CARPENTERS_TABLE_TYPE, ChippedBlocks.CARPENTERS_TABLE.get()),
            AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final RegistryObject<Block> LOOM_TABLE = register("loom_table",
            () -> new ChippedWorkbench((id, inv, pos) -> new ChippedContainer(id, inv, pos, ChippedContainerType.LOOM_TABLE.get(), ChippedSerializer.LOOM_TABLE_TYPE, ChippedBlocks.LOOM_TABLE.get()),
            AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final RegistryObject<Block> MASON_TABLE = register("mason_table",
            () -> new ChippedWorkbench((id, inv, pos) -> new ChippedContainer(id, inv, pos, ChippedContainerType.MASON_TABLE.get(), ChippedSerializer.MASON_TABLE_TYPE, ChippedBlocks.MASON_TABLE.get()),
            AbstractBlock.Properties.of(Material.METAL).strength(5F, 6F).sound(SoundType.METAL).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ALCHEMY_BENCH = register("alchemy_bench",
            () -> new ChippedWorkbench((id, inv, pos) -> new ChippedContainer(id, inv, pos, ChippedContainerType.ALCHEMY_BENCH.get(), ChippedSerializer.ALCHEMY_BENCH_TYPE, ChippedBlocks.ALCHEMY_BENCH.get()),
            AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final RegistryObject<Block> MECHANIST_WORKBENCH = register("mechanist_workbench",
            () -> new ChippedWorkbench((id, inv, pos) -> new ChippedContainer(id, inv, pos, ChippedContainerType.MECHANIST_WORKBENCH.get(), ChippedSerializer.MECHANIST_WORKBENCH_TYPE, ChippedBlocks.MECHANIST_WORKBENCH.get()),
            AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final RegistryObject<TileEntityType<ChippedBarrelEntity>> CHIPPED_BARREL_ENTITY = TILE_ENTITIES.register("barrel",
            () -> new TileEntityType<>(ChippedBarrelEntity::new, ImmutableSet.copyOf(BARRELS.getBlocks().stream().map(RegistryObject::get).collect(Collectors.toSet())), null));


    public static void register() {
        // Register Mason Bench Blocks
        registerVanillaBlocks(BenchType.MASON, ANDESITE, 65);
        registerVanillaBlocks(BenchType.MASON, DIORITE, 65);
        registerVanillaBlocks(BenchType.MASON, GRANITE, 65);
        registerVanillaBlocks(BenchType.MASON, BASALT, 65);
        registerVanillaBlocks(BenchType.MASON, MOSSY_COBBLESTONE, 65);
        registerVanillaBlocks(BenchType.MASON, BRICKS, 133);
        registerVanillaBlocks(BenchType.MASON, COBBLESTONE, 65);
        registerVanillaBlocks(BenchType.MASON, END_STONE, 65);
        registerVanillaBlocks(BenchType.MASON, MOSSY_STONE_BRICKS, 65);
        registerVanillaBlocks(BenchType.MASON, DARK_PRISMARINE, 65);
        registerVanillaBlocks(BenchType.MASON, NETHER_BRICKS, 65);
        registerVanillaBlocks(BenchType.MASON, NETHERRACK, 65);
        registerVanillaBlocks(BenchType.MASON, PRISMARINE, 65);
        registerVanillaBlocks(BenchType.MASON, PURPUR_BLOCK, 65);
        registerVanillaBlocks(BenchType.MASON, QUARTZ_BLOCK, 65);
        registerVanillaBlocks(BenchType.MASON, RED_NETHER_BRICKS, 65);
        registerVanillaBlocks(BenchType.MASON, RED_SANDSTONE, 65);
        registerVanillaBlocks(BenchType.MASON, SANDSTONE, 65);
        registerVanillaBlocks(BenchType.MASON, SMOOTH_STONE, 65);
        registerVanillaBlocks(BenchType.MASON, Blocks.GILDED_BLACKSTONE, GILDED_BLACKSTONES, 65);
        registerVanillaBlocks(BenchType.MASON, Blocks.BLACKSTONE, BLACKSTONES, 65);
        registerVanillaBlocks(BenchType.MASON, STONE, 65);
        registerVanillaBlocks(BenchType.MASON, TERRACOTTA, 66);

        for (int id = 0; id < 16; ++id) {
            DyeColor color = DyeColor.byId(id);
            registerVanillaBlocks(BenchType.MASON, TERRACOTTAS.computeIfAbsent(color, k -> new ChippedBlockType<>(k + "_terracotta")), 66);
            registerVanillaBlocks(BenchType.MASON, CONCRETES.computeIfAbsent(color, k -> new ChippedBlockType<>(k + "_concrete")), 21);
            registerVanillaBlocks(BenchType.MASON, GLAZED_TERRACOTTAS.computeIfAbsent(color, k -> new ChippedBlockType<>(k + "_glazed_terracotta")), 11);
        }

        // Register Alchemy Bench Blocks
        registerVanillaBlocks(BenchType.ALCHEMY, ANCIENT_DEBRIS, 65);
        registerVanillaBlocks(BenchType.ALCHEMY, LAPIS_BLOCK, 65);
        registerVanillaBlocks(BenchType.ALCHEMY, COAL_BLOCK, 65);
        registerVanillaBlocks(BenchType.MECHANIST, REDSTONE_BLOCK, 65);
        registerVanillaBlocks(BenchType.ALCHEMY, LODESTONE, 65);
        registerVanillaBlocks(BenchType.ALCHEMY, MAGMA_BLOCK, 65);
        registerVanillaBlocks(BenchType.ALCHEMY, DIAMOND_BLOCK, 12);
        registerVanillaBlocks(BenchType.ALCHEMY, EMERALD_BLOCK, 12);
        registerVanillaBlocks(BenchType.ALCHEMY, GOLD_BLOCK, 12);
        registerVanillaBlocks(BenchType.ALCHEMY, IRON_BLOCK, 12);
        registerVanillaBlocks(BenchType.ALCHEMY, NETHERITE_BLOCK, 12);
        registerVanillaBlocks(BenchType.ALCHEMY, OBSIDIAN, 65);
        final AbstractBlock.Properties CRYING_OBSIDIAN_PROPERTIES = AbstractBlock.Properties.copy(Blocks.CRYING_OBSIDIAN);
        registerBlocks(BenchType.ALCHEMY, CRYING_OBSIDIAN, () -> new CryingObsidianBlock(CRYING_OBSIDIAN_PROPERTIES), 65);

        //
        registerVanillaBlocks(BenchType.ALCHEMY, Blocks.GLOWSTONE, GLOWSTONES, 20);
        registerVanillaBlocks(BenchType.ALCHEMY, Blocks.SEA_LANTERN, SEA_LANTERNS, 16);

        // Register Botanist Bench Blocks
        registerVanillaBlocks(BenchType.BOTANIST, DIRT, 65);
        registerVanillaBlocks(BenchType.BOTANIST, SNOW_BLOCK, 65);
        registerVanillaBlocks(BenchType.BOTANIST, Blocks.SHROOMLIGHT, SHROOMLIGHTS, 16);
        registerVanillaBlocks(BenchType.BOTANIST, BLUE_ICE, 65);
        final AbstractBlock.Properties ICE_PROPERTIES = AbstractBlock.Properties.copy(Blocks.ICE);
        registerBlocks(BenchType.BOTANIST, ICE, () -> new IceBlock(ICE_PROPERTIES), 65);
        registerVanillaBlocks(BenchType.BOTANIST, PACKED_ICE, 65);
        registerVanillaBlocks(BenchType.BOTANIST, Blocks.CLAY, CLAYS, 62);
        registerVanillaBlocks(BenchType.BOTANIST, Blocks.DRIED_KELP_BLOCK, DRIED_KELP_BLOCKS, 12);
        registerVanillaBlocks(BenchType.BOTANIST, WARPED_WART_BLOCK, 14);
        registerVanillaBlocks(BenchType.BOTANIST, NETHER_WART_BLOCK, 13);

        final AbstractBlock.Properties ACACIA_LEAVES_PROPERTIES = AbstractBlock.Properties.copy(Blocks.ACACIA_LEAVES);
        registerBlocks(BenchType.BOTANIST, ACACIA_LEAVES, () -> new LeavesBlock(ACACIA_LEAVES_PROPERTIES), 12);
        final AbstractBlock.Properties BIRCH_LEAVES_PROPERTIES = AbstractBlock.Properties.copy(Blocks.BIRCH_LEAVES);
        registerBlocks(BenchType.BOTANIST, BIRCH_LEAVES, () -> new LeavesBlock(BIRCH_LEAVES_PROPERTIES), 12);
        final AbstractBlock.Properties DARK_OAK_LEAVES_PROPERTIES = AbstractBlock.Properties.copy(Blocks.DARK_OAK_LEAVES);
        registerBlocks(BenchType.BOTANIST, DARK_OAK_LEAVES, () -> new LeavesBlock(DARK_OAK_LEAVES_PROPERTIES), 12);
        final AbstractBlock.Properties JUNGLE_LEAVES_PROPERTIES = AbstractBlock.Properties.copy(Blocks.JUNGLE_LEAVES);
        registerBlocks(BenchType.BOTANIST, JUNGLE_LEAVES, () -> new LeavesBlock(JUNGLE_LEAVES_PROPERTIES), 12);
        final AbstractBlock.Properties OAK_LEAVES_PROPERTIES = AbstractBlock.Properties.copy(Blocks.OAK_LEAVES);
        registerBlocks(BenchType.BOTANIST, OAK_LEAVES, () -> new LeavesBlock(OAK_LEAVES_PROPERTIES), 12);
        final AbstractBlock.Properties SPRUCE_LEAVES_PROPERTIES = AbstractBlock.Properties.copy(Blocks.SPRUCE_LEAVES);
        registerBlocks(BenchType.BOTANIST, SPRUCE_LEAVES, () -> new LeavesBlock(SPRUCE_LEAVES_PROPERTIES), 12);

        registerVanillaBlocks(BenchType.CARPENTERS, BOOKSHELF, 57);
        final AbstractBlock.Properties BARREL_PROPERTIES = AbstractBlock.Properties.copy(Blocks.BARREL);
        registerBlocks(BenchType.CARPENTERS, BARRELS, () -> new ChippedBarrel(BARREL_PROPERTIES), 33);

        // Register Mechanist Bench Blocks
        final AbstractBlock.Properties REDSTONE_LAMP_PROPERTIES = AbstractBlock.Properties.copy(Blocks.REDSTONE_LAMP);
        registerBlocks(BenchType.MECHANIST, REDSTONE_LAMPS, () -> new RedstoneLampBlock(REDSTONE_LAMP_PROPERTIES), 18);

        // Register Wools and Carpets
        final AbstractBlock.Properties WOOL_PROPERTIES = AbstractBlock.Properties.of(Material.WOOL).strength(0.1F).sound(SoundType.WOOL);
        for (int id = 0; id < 16; ++id) {
            DyeColor color = DyeColor.byId(id);
            registerVanillaBlocks(BenchType.LOOM, WOOL.computeIfAbsent(color, k -> new ChippedBlockType<>(k + "_wool")), 20);
            registerBlocks(BenchType.LOOM, CARPETS.computeIfAbsent(color, k -> new ChippedBlockType<>(k + "_carpet")), () -> new CarpetBlock(color, WOOL_PROPERTIES), 20);
        }

        // Register Glasses and Stained Glasses
        final AbstractBlock.Properties GLASS_PROPERTIES = AbstractBlock.Properties.copy(Blocks.GLASS);
        final AbstractBlock.Properties GLASS_PANE_PROPERTIES = AbstractBlock.Properties.copy(Blocks.GLASS_PANE);
        registerBlocks(BenchType.GLASSBLOWER, GLASSES, () -> new GlassBlock(GLASS_PROPERTIES), 11);
        registerBlocks(BenchType.GLASSBLOWER, GLASS_PANES, () -> new PaneBlock(GLASS_PANE_PROPERTIES), 11);

        for (ChippedWoodType type : ChippedWoodType.VALUES) {
            registerBlocks(BenchType.GLASSBLOWER, GLASSES, type + "_wood_glass", () -> new GlassBlock(GLASS_PROPERTIES), 11);
            registerBlocks(BenchType.GLASSBLOWER, GLASS_PANES, type + "_wood_glass_pane", () -> new PaneBlock(GLASS_PANE_PROPERTIES), 11);
        }

        for (int id = 0; id < 16; ++id) {
            DyeColor color = DyeColor.byId(id);
            registerBlocks(BenchType.GLASSBLOWER, STAINED_GLASSES.computeIfAbsent(color, k -> new ChippedBlockType<>(k + "_stained_glass")), () -> new StainedGlassBlock(color, GLASS_PROPERTIES), 10);
            registerBlocks(BenchType.GLASSBLOWER, STAINED_GLASS_PANES.computeIfAbsent(color, k -> new ChippedBlockType<>(k + "_stained_glass_pane")), () -> new StainedGlassPaneBlock(color, GLASS_PANE_PROPERTIES), 10);
        }

        final AbstractBlock.Properties woodProperties = AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD);
        for (ChippedWoodType type : ChippedWoodType.VALUES) {
            registerBlocks(BenchType.CARPENTERS, PLANKS.computeIfAbsent(type, k -> new ChippedBlockType<>(k + "_planks")), () -> new Block(woodProperties), 38);
        }

        final AbstractBlock.Properties hayProperties = AbstractBlock.Properties.copy(Blocks.HAY_BLOCK);
        registerBlocks(BenchType.BOTANIST, HAY_BLOCKS, () -> new HayBlock(hayProperties), 8);
        final AbstractBlock.Properties melonProperties = AbstractBlock.Properties.copy(Blocks.MELON);
        registerBlocks(BenchType.BOTANIST, MELONS, () -> new MelonBlock(melonProperties), 10);
        final AbstractBlock.Properties vineProperties = AbstractBlock.Properties.copy(Blocks.VINE);
        registerBlocks(BenchType.BOTANIST, VINES, () -> new VineBlock(vineProperties), 17);
        final AbstractBlock.Properties gravelProperties = AbstractBlock.Properties.copy(Blocks.GRAVEL);
        registerBlocks(BenchType.BOTANIST, GRAVEL, () -> new GravelBlock(gravelProperties), 7);
        final AbstractBlock.Properties sandProperties = AbstractBlock.Properties.copy(Blocks.SAND);
        registerBlocks(BenchType.BOTANIST, SAND, () -> new SandBlock(1, sandProperties), 12);

        final AbstractBlock.Properties brownMushroomProperties = AbstractBlock.Properties.copy(Blocks.BROWN_MUSHROOM);
        registerBlocks(BenchType.BOTANIST, BROWN_MUSHROOMS, () -> new MushroomBlock(brownMushroomProperties), 15);
        final AbstractBlock.Properties redMushroomProperties = AbstractBlock.Properties.copy(Blocks.RED_MUSHROOM);
        registerBlocks(BenchType.BOTANIST, RED_MUSHROOMS, () -> new MushroomBlock(redMushroomProperties), 15);

        final AbstractBlock.Properties warpedFungusProperties = AbstractBlock.Properties.copy(Blocks.WARPED_FUNGUS);
        registerBlocks(BenchType.BOTANIST, WARPED_FUNGUS, () -> new MushroomBlock(warpedFungusProperties), 14);
        final AbstractBlock.Properties crimsonFungusProperties = AbstractBlock.Properties.copy(Blocks.CRIMSON_FUNGUS);
        registerBlocks(BenchType.BOTANIST, CRIMSON_FUNGUS, () -> new MushroomBlock(crimsonFungusProperties), 15);

        final AbstractBlock.Properties warpedRootsProperties = AbstractBlock.Properties.copy(Blocks.WARPED_ROOTS);
        registerBlocks(BenchType.BOTANIST, WARPED_ROOTS, () -> new NetherRootsBlock(warpedRootsProperties), 9);
        final AbstractBlock.Properties crimsonRootsProperties = AbstractBlock.Properties.copy(Blocks.CRIMSON_ROOTS);
        registerBlocks(BenchType.BOTANIST, CRIMSON_ROOTS, () -> new NetherRootsBlock(crimsonRootsProperties), 14);
        final AbstractBlock.Properties netherSproutsProperties = AbstractBlock.Properties.copy(Blocks.NETHER_SPROUTS);
        registerBlocks(BenchType.BOTANIST, NETHER_SPROUTS, () -> new NetherSproutsBlock(netherSproutsProperties), 20);

        final AbstractBlock.Properties brownMushroomBlockProperties = AbstractBlock.Properties.copy(Blocks.BROWN_MUSHROOM_BLOCK);
        registerBlocks(BenchType.BOTANIST, BROWN_MUSHROOM_BLOCK, () -> new HugeMushroomBlock(brownMushroomBlockProperties), 24);
        final AbstractBlock.Properties redMushroomBlockProperties = AbstractBlock.Properties.copy(Blocks.RED_MUSHROOM_BLOCK);
        registerBlocks(BenchType.BOTANIST, RED_MUSHROOM_BLOCK, () -> new HugeMushroomBlock(redMushroomBlockProperties), 15);

        final AbstractBlock.Properties cobwebProperties = AbstractBlock.Properties.copy(Blocks.COBWEB).strength(4.0F/15F, 4.0F);
        registerBlocks(BenchType.BOTANIST, COBWEBS, () -> new WebBlock(cobwebProperties), 10);

        final AbstractBlock.Properties soulSandProperties = AbstractBlock.Properties.copy(Blocks.SOUL_SAND);
        registerBlocks(BenchType.ALCHEMY, SOUL_SANDS, () -> new SoulSandBlock(soulSandProperties), 11);

        // Lilypads require a custom item
        final AbstractBlock.Properties lilyPadProperties = AbstractBlock.Properties.copy(Blocks.LILY_PAD);
        for (int i = 1; i <= 22; i++) {
            String name = LILY_PAD.getId() + "_" + i;
            RegistryObject<LilyPadBlock> lilyPad = BLOCKS.register(name, () -> new LilyPadBlock(lilyPadProperties) {
                @Override
                public PlantType getPlantType(IBlockReader world, BlockPos pos) {
                    return net.minecraftforge.common.PlantType.WATER;
                }
            });
            BlockRegistry.addBlock(BenchType.BOTANIST, LILY_PAD, lilyPad);
            ChippedItems.ITEMS.register(name, () -> new LilyPadItem(lilyPad.get(), new Item.Properties().tab(Chipped.CHIPPED)));
        }

        // TODO please, whoever put these here, rename them - Ashley
        // Regular Lanterns
        final VoxelShape CHONK_LANTERN_SHAPE = VoxelShapes.or(Block.box(2.0D, 0.0D, 2.0D, 14.0D, 1.0D, 14.0D), Block.box(1, 1, 1, 15, 15, 15));
        final VoxelShape THICC_LANTERN_SHAPE = VoxelShapes.or(Block.box(2.0D, 0.0D, 2.0D, 14.0D, 1.0D, 14.0D), Block.box(1, 1, 1, 15, 15, 15));
        final VoxelShape DONUT_LANTERN_SHAPE_EAST = Block.box(5.0D, 0.0D, 1.0D, 11.0D, 15.0D, 15.0D);
        final VoxelShape DONUT_LANTERN_SHAPE_NORTH = Block.box(1.0D, 0.0D, 5.0D, 15.0D, 15.0D, 11.0D);
        final VoxelShape TALL_LANTERN_SHAPE = Block.box(5, 0, 5, 11, 15, 11);
        final VoxelShape HANGING_WOOD_LANTERN = VoxelShapes.or(Block.box(5.0D, 2.0D, 5.0D, 11.0D, 12.0D, 11.0D), Block.box(4, 12, 4, 12, 13, 12), Block.box(4, 1, 4, 12, 2, 12),  Block.box(5, 13, 5, 11, 14, 11));
        final VoxelShape WOOD_LANTERN = VoxelShapes.or(Block.box(5.0D, 1D, 5.0D, 11.0D, 11.0D, 11.0D), Block.box(4, 11, 4, 12, 12, 12), Block.box(4, 0, 4, 12, 1, 12), Block.box(5, 12, 5, 11, 13, 11));
        final VoxelShape HANGING_JAR_LANTERN = VoxelShapes.or(Block.box(7.0D, 11D, 7.0D, 9.0D, 12.0D, 9.0D), Block.box(6, 5, 6, 10, 11, 10));
        final VoxelShape JAR_LANTERN  = VoxelShapes.or(Block.box(7.0D, 6D, 7.0D, 9.0D, 7.0D, 9.0D), Block.box(6, 0, 6, 10, 6, 10));
        final VoxelShape HANGING_PAPER_LANTERN = VoxelShapes.or(Block.box(4, 5, 4, 12, 14, 12), Block.box(5, 3, 5, 11, 5, 11), Block.box(5, 14, 5, 11, 16, 11));
        final VoxelShape PAPER_LANTERN = VoxelShapes.or(Block.box(4, 3, 4, 12, 12, 12), Block.box(5, 1, 5, 11, 3, 11),Block.box(5, 12, 5, 11, 14, 11), Block.box(4, 0, 4, 12, 2, 12));
        final VoxelShape HANGING_PAPER_LANTERN_2 = VoxelShapes.or(Block.box(4, 9, 4, 12, 15, 12), Block.box(5, 1 ,5, 11, 5, 11), Block.box(6, 0, 6, 10, 1, 10), Block.box(6, 5, 6, 10, 6, 10), Block.box(5, 15, 5, 11, 16, 11), Block.box(5, 8, 5, 11, 9 ,11));
        final VoxelShape PAPER_LANTERN_2 = VoxelShapes.or(Block.box(4, 3, 4, 12, 9, 12), Block.box(5, 9, 5, 11, 10, 11), Block.box(5, 2, 5, 11, 3, 11), Block.box(4, 0, 4, 12, 2, 12));

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
        final AbstractBlock.Properties REDSTONE_TORCH_PROPERTIES = AbstractBlock.Properties.copy(Blocks.REDSTONE_TORCH);
        final AbstractBlock.Properties REDSTONE_WALL_TORCH_PROPERTIES = AbstractBlock.Properties.copy(Blocks.REDSTONE_WALL_TORCH);
        for (int i = 2; i <= 6; i++) {
            RegistryObject<RedstoneWallTorchBlock> redstoneWallTorch = BLOCKS.register("redstone_wall_torch_" + i, () -> new RedstoneWallTorchBlock(REDSTONE_WALL_TORCH_PROPERTIES));
            RegistryObject<RedstoneTorchBlock> redstoneTorch = BLOCKS.register("redstone_torch_" + i, () -> new RedstoneTorchBlock(REDSTONE_TORCH_PROPERTIES));
            ChippedItems.ITEMS.register("redstone_torch_" + i, () -> new WallOrFloorItem(redstoneTorch.get(), redstoneWallTorch.get(), new Item.Properties().tab(Chipped.CHIPPED)));
            BlockRegistry.addBlock(BenchType.MECHANIST, REDSTONE_TORCHES, redstoneTorch);
            REDSTONE_WALL_TORCHES.add(redstoneWallTorch);
        }

        // Regular Torches
        final AbstractBlock.Properties TORCH_PROPERTIES = AbstractBlock.Properties.copy(Blocks.TORCH);
        final AbstractBlock.Properties WALL_TORCH_PROPERTIES = AbstractBlock.Properties.copy(Blocks.WALL_TORCH);
        for (int i = 1; i <= 9; i++) {
            RegistryObject<WallTorchBlock> wallTorch = BLOCKS.register("wall_torch_" + i, () -> new WallTorchBlock(TORCH_PROPERTIES, ParticleTypes.FLAME));
            RegistryObject<TorchBlock> torch = BLOCKS.register("torch_" + i, () -> new TorchBlock(WALL_TORCH_PROPERTIES, ParticleTypes.FLAME));
            ChippedItems.ITEMS.register("torch_" + i, () -> new WallOrFloorItem(torch.get(), wallTorch.get(), new Item.Properties().tab(Chipped.CHIPPED)));
            BlockRegistry.addBlock(BenchType.CARPENTERS, TORCHES, torch);
            WALL_TORCHES.add(wallTorch);
        }

        // Pumpkins
        final AbstractBlock.Properties PUMPKIN_PROPERTIES = AbstractBlock.Properties.copy(Blocks.CARVED_PUMPKIN);
        final AbstractBlock.Properties JACK_O_LANTERN_PROPERTIES = AbstractBlock.Properties.copy(Blocks.JACK_O_LANTERN);
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
                public @NotNull VoxelShape getShape(@NotNull BlockState blockState, @NotNull IBlockReader blockReader, @NotNull BlockPos pos, @NotNull ISelectionContext selectionContext) {
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
        registerBlocks(bench, type, () -> new Block(AbstractBlock.Properties.copy(vanillaBlock)), count);
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
