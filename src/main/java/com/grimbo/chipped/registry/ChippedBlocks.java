package com.grimbo.chipped.registry;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.block.ChippedUniqueLantern;
import com.grimbo.chipped.block.ChippedWorkbench;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockBehaviour.StateArgumentPredicate;
import net.minecraft.world.level.block.state.BlockBehaviour.StatePredicate;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

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
    protected static final VoxelShape DONUT_LANTERN_SHAPE_EAST = Block.box(5.0D, 0.0D, 1.0D, 11.0D, 15.0D, 15.0D);
    protected static final VoxelShape DONUT_LANTERN_SHAPE_NORTH = Block.box(1.0D, 0.0D, 5.0D, 15.0D, 15.0D, 11.0D);
    protected static final VoxelShape TALL_LANTERN_SHAPE = Block.box(5, 0, 5, 11, 15, 11);

    public static Multimap<String, Block> blocksMap = ArrayListMultimap.create();

    //Simple Blocks which have 18 of its own variant
    public static final String[] stones18 = {"stone", "granite", "diorite", "andesite", "prismarine", "dark_prismarine", "purpur_block",
            "cobblestone", "quartz_block", "sandstone", "red_sandstone", "nether_bricks", "red_nether_bricks", "end_stone", "netherrack"};

    public static final String[] woodsList = {"oak", "birch", "spruce", "jungle", "acacia", "dark_oak", "warped", "crimson"};
    public static final String[] specialPumpkinList = {"end", "end2", "nether"};
    public static final String[] carvedPumpkinList = {"happy", "angry", "bigeyes", "bighappy", "boo", "bruh", "classic", "enthusiastic",
            "grinning", "kawaii", "mourn", "owo", "plotting", "sans", "scared", "smallhappy", "squashy", "stretchy", "upsidedown"};
	public static final String[] colorsList = { "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray",
			"cyan", "purple", "blue", "brown", "green", "red", "black" };

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
    public static final Block BOTANIST_WORKBENCH = register("botanist_workbench", new ChippedWorkbench(ChippedMenuType.botanistWorkbench, ChippedSerializer.BOTANIST_WORKBENCH_TYPE,
            FabricBlockSettings.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final Block GLASSBLOWER = register("glassblower", new ChippedWorkbench(ChippedMenuType.glassblower, ChippedSerializer.GLASSBLOWER_TYPE,
            FabricBlockSettings.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final Block CARPENTERS_TABLE = register("carpenters_table", new ChippedWorkbench(ChippedMenuType.carpentersTable, ChippedSerializer.CARPENTERS_TABLE_TYPE,
            FabricBlockSettings.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final Block LOOM_TABLE = register("loom_table", new ChippedWorkbench(ChippedMenuType.loomTable, ChippedSerializer.LOOM_TABLE_TYPE,
            FabricBlockSettings.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final Block MASON_TABLE = register("mason_table", new ChippedWorkbench(ChippedMenuType.masonTable, ChippedSerializer.MASON_TABLE_TYPE,
            FabricBlockSettings.of(Material.METAL).strength(5F, 6F).sound(SoundType.METAL).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION).requiresCorrectToolForDrops()));

    public static final Block ALCHEMY_BENCH = register("alchemy_bench", new ChippedWorkbench(ChippedMenuType.alchemyBench, ChippedSerializer.ALCHEMY_BENCH_TYPE,
            FabricBlockSettings.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final Block MECHANIST_WORKBENCH = register("mechanist_workbench", new ChippedWorkbench(ChippedMenuType.mechanistWorkbench, ChippedSerializer.MECHANIST_WORKBENCH_TYPE,
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
        registerBlocks( "redstone_lamp", () -> new RedstoneLampBlock(REDSTONE_LAMP_PROPERTIES), 18);

        //Register Wools and Carpets
        for (int id = 0; id < 16; ++id) {
            DyeColor color = DyeColor.byId(id);
            registerVanillaBlocks(color + "_wool", 18);
            registerBlocks(color + "_carpet", () -> new WoolCarpetBlock(color, WOOL_PROPERTIES){}, 18);
        }

        //Register Glasses and Stained Glasses
        registerBlocks("glass", () -> new GlassBlock(GLASS_PROPERTIES), 14);
        registerBlocks("glass_pane", () -> new IronBarsBlock(GLASS_PANE_PROPERTIES){}, 14);

        for (String wood : woodsList) {
            registerBlocks(wood + "_wood_glass", () -> new GlassBlock(GLASS_PROPERTIES), 6);
            registerBlocks(wood + "_wood_glass_pane",  () -> new IronBarsBlock(GLASS_PANE_PROPERTIES){}, 6);
        }

        for (int id = 0; id < 16; ++id) {
            DyeColor color = DyeColor.byId(id);
            registerBlocks(color + "_stained_glass", () -> new StainedGlassBlock(color, GLASS_PROPERTIES), 8);
            registerBlocks(color + "_stained_glass_pane",  () -> new StainedGlassPaneBlock(color, GLASS_PANE_PROPERTIES), 8);
        }

        //Register Misc
        registerVanillaBlocks(Blocks.CLAY, "clay", 19);

        for (String wood : woodsList) {
            registerBlocks(wood + "_planks", () -> new Block(WOOD_PROPERTIES), 18);
        }

        registerBlocks("hay_block", () -> new HayBlock(HAY_BLOCK_PROPERTIES), 8);
        registerBlocks("melon", () -> new MelonBlock(MELON_PROPERTIES){}, 10);
        registerBlocks("vine", () -> new VineBlock(VINE_PROPERTIES), 8);

        Block lantern1 = register("lantern_1", new ChippedUniqueLantern(LANTERN_PROPERTIES, CHONK_LANTERN_SHAPE));
        Block lantern2 = register("lantern_2", new ChippedUniqueLantern(LANTERN_PROPERTIES, DONUT_LANTERN_SHAPE_EAST, DONUT_LANTERN_SHAPE_NORTH));
        Block lantern3 = register("lantern_3", new ChippedUniqueLantern(LANTERN_PROPERTIES, TALL_LANTERN_SHAPE));
        blocksMap.put("lantern", lantern1);
        blocksMap.put("lantern", lantern2);
        blocksMap.put("lantern", lantern3);

        Block soul_lantern_1 = register("soul_lantern_1", new ChippedUniqueLantern(LANTERN_PROPERTIES, CHONK_LANTERN_SHAPE));
        Block soul_lantern_2 = register("soul_lantern_2", new ChippedUniqueLantern(LANTERN_PROPERTIES, DONUT_LANTERN_SHAPE_EAST, DONUT_LANTERN_SHAPE_NORTH));
        Block soul_lantern_3 = register("soul_lantern_3", new ChippedUniqueLantern(LANTERN_PROPERTIES, TALL_LANTERN_SHAPE));
        blocksMap.put("soul_lantern", soul_lantern_1);
        blocksMap.put("soul_lantern", soul_lantern_2);
        blocksMap.put("soul_lantern", soul_lantern_3);

        //Redstone Torches
        for (int i = 2; i <= 6; i++) {
            Block redstoneWallTorch = Registry.register(Registry.BLOCK, new ResourceLocation(Chipped.MOD_ID,"redstone_wall_torch_" + i), new RedstoneWallTorchBlock(REDSTONE_WALL_TORCH_PROPERTIES){});
            Block redstoneTorch = Registry.register(Registry.BLOCK, new ResourceLocation(Chipped.MOD_ID,"redstone_torch_" + i), new RedstoneTorchBlock(REDSTONE_TORCH_PROPERTIES){});
            Registry.register(Registry.ITEM, new ResourceLocation(Chipped.MOD_ID, "redstone_torch_" + i), new StandingAndWallBlockItem(redstoneTorch, redstoneWallTorch, new Item.Properties().tab(Chipped.CHIPPED)));
            blocksMap.put("redstone_torch", redstoneTorch);
            blocksMap.put("redstone_wall_torch", redstoneWallTorch);
        }
        //Regular Torches
        for (int i = 1; i <= 9; i++) {
            Block wallTorch = Registry.register(Registry.BLOCK, new ResourceLocation(Chipped.MOD_ID, "wall_torch_" + i), new WallTorchBlock(TORCH_PROPERTIES, ParticleTypes.FLAME){});
            Block torch = Registry.register(Registry.BLOCK, new ResourceLocation(Chipped.MOD_ID, "torch_" + i), new TorchBlock(TORCH_PROPERTIES, ParticleTypes.FLAME){});
            Registry.register(Registry.ITEM, new ResourceLocation(Chipped.MOD_ID, "torch_" + i), new StandingAndWallBlockItem(torch, wallTorch, new Item.Properties().tab(Chipped.CHIPPED)));
            blocksMap.put("torch", torch);
            blocksMap.put("wall_torch", wallTorch);
        }

        //Pumpkins
        for (String pumpkin : specialPumpkinList) {
            Block pumpkinBlock = register("pumpkin_" + pumpkin, new PumpkinBlock(PUMPKIN_PROPERTIES){});
            Block jackOLanternBlock = register("jack_o_lantern_" + pumpkin, new CarvedPumpkinBlock(JACK_O_LANTERN_PROPERTIES){});
            Block carvedPumpkinBlock = register("carved_pumpkin_" + pumpkin, new CarvedPumpkinBlock(PUMPKIN_PROPERTIES){});
            blocksMap.put("jack_o_lantern", jackOLanternBlock);
            blocksMap.put("carved_pumpkin", carvedPumpkinBlock);
            blocksMap.put("carved_pumpkin_special", jackOLanternBlock);
            blocksMap.put("carved_pumpkin_special", carvedPumpkinBlock);
            blocksMap.put("pumpkin", pumpkinBlock);
        }

        //Jack'o'Lantern & Carved Pumpkins
        for (int i = 1; i <= carvedPumpkinList.length; i++) {
            Block jackOLanternBlock = register("jack_o_lantern_" + i,  new CarvedPumpkinBlock(JACK_O_LANTERN_PROPERTIES){});
            Block carvedPumpkinBlock = register("carved_pumpkin_" + i, new CarvedPumpkinBlock(PUMPKIN_PROPERTIES){});
            blocksMap.put("jack_o_lantern", jackOLanternBlock);
            blocksMap.put("carved_pumpkin", carvedPumpkinBlock);
            blocksMap.put("carved_pumpkin_vanilla", carvedPumpkinBlock);
            blocksMap.put("carved_pumpkin_vanilla", jackOLanternBlock);
        }
    }

    //Registries

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

    /**
     * Only use if a vanilla block counterpart exists and the same properties should be used.
     *
     * @param name  The registry name to be used.
     * @param count How many of the block should be registered, the index is used as the suffix.
     */
    private static void registerBlocks(String name, Supplier<Block> block, int count) {
        for (int i = 1; i <= count; i++) {
            String newName = name + "_" + i;
            blocksMap.put(name, register(newName, block.get()));
        }
    }

//    private static Block register(String name, Supplier<Block> block) {
//        Block toReturn = Registry.register(Registry.BLOCK, new ResourceLocation(Chipped.MOD_ID, name), block.get());
//        Registry.register(Registry.ITEM, new ResourceLocation(Chipped.MOD_ID, name), new BlockItem(block, new Item.Properties().tab(Chipped.CHIPPED)));
//        return toReturn;
//    }

    private static Block register(String name, Block block) {
        Block toReturn = Registry.register(Registry.BLOCK, new ResourceLocation(Chipped.MOD_ID, name), block);
        Registry.register(Registry.ITEM, new ResourceLocation(Chipped.MOD_ID, name), new BlockItem(block, new Item.Properties().tab(Chipped.CHIPPED)));
        return toReturn;
    }
}
