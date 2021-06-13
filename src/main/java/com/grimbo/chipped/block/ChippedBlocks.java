package com.grimbo.chipped.block;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.container.*;
import com.grimbo.chipped.item.ChippedItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ChippedBlocks {

    private static final AbstractBlock.Properties CRYING_OBSIDIAN_PROPERTIES = AbstractBlock.Properties.copy(Blocks.CRYING_OBSIDIAN);
    private static final AbstractBlock.Properties HAY_BLOCK_PROPERTIES = AbstractBlock.Properties.copy(Blocks.HAY_BLOCK);
    private static final AbstractBlock.Properties MELON_PROPERTIES = AbstractBlock.Properties.copy(Blocks.MELON);
    private static final AbstractBlock.Properties VINE_PROPERTIES = AbstractBlock.Properties.copy(Blocks.VINE);
    private static final AbstractBlock.Properties REDSTONE_TORCH_PROPERTIES = AbstractBlock.Properties.copy(Blocks.REDSTONE_TORCH);
    private static final AbstractBlock.Properties REDSTONE_WALL_TORCH_PROPERTIES = AbstractBlock.Properties.copy(Blocks.REDSTONE_WALL_TORCH);
    // Unused so commented out.
    //private static final AbstractBlock.Properties REDSTONE_LAMP_PROPERTIES = AbstractBlock.Properties.copy(Blocks.REDSTONE_LAMP);
    private static final AbstractBlock.Properties TORCH_PROPERTIES = AbstractBlock.Properties.copy(Blocks.TORCH);
    private static final AbstractBlock.Properties WALL_TORCH_PROPERTIES = AbstractBlock.Properties.copy(Blocks.WALL_TORCH);
    private static final AbstractBlock.Properties PUMPKIN_PROPERTIES = AbstractBlock.Properties.copy(Blocks.PUMPKIN);
    private static final AbstractBlock.Properties JACK_O_LANTERN_PROPERTIES = AbstractBlock.Properties.copy(Blocks.JACK_O_LANTERN);
    private static final AbstractBlock.Properties WOOD_PROPERTIES = AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD);
    private static final AbstractBlock.Properties GLASS_PANE_PROPERTIES = AbstractBlock.Properties.copy(Blocks.GLASS_PANE);
    private static final AbstractBlock.Properties GLASS_PROPERTIES = AbstractBlock.Properties.copy(Blocks.GLASS);
    private static final AbstractBlock.Properties WOOL_PROPERTIES = AbstractBlock.Properties.of(Material.WOOL).strength(0.1F).sound(SoundType.WOOL);
    private static final AbstractBlock.Properties LANTERN_PROPERTIES = AbstractBlock.Properties.copy(Blocks.LANTERN);
    private static final AbstractBlock.IPositionPredicate ALWAYS_FALSE_POSITION = (state, world, position) -> false;
    private static final AbstractBlock.IExtendedPositionPredicate<EntityType<?>> VALID_SPAWN = (state, world, position, type) -> false;
    protected static final VoxelShape CHONK_LANTERN_SHAPE = VoxelShapes.or(Block.box(2.0D, 0.0D, 2.0D, 14.0D, 1.0D, 14.0D), Block.box(1, 1, 1, 15, 15, 15));
    protected static final VoxelShape DONUT_LANTERN_SHAPE_EAST = Block.box(5.0D, 0.0D, 1.0D, 11.0D, 15.0D, 15.0D);
    protected static final VoxelShape DONUT_LANTERN_SHAPE_NORTH = Block.box(1.0D, 0.0D, 5.0D, 15.0D, 15.0D, 11.0D);
    protected static final VoxelShape TALL_LANTERN_SHAPE = Block.box(5, 0, 5, 11, 15, 11);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Chipped.MOD_ID);

    public static Multimap<String, RegistryObject<Block>> blocksMap = ArrayListMultimap.create();

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
    public static final RegistryObject<Block> BOTANIST_WORKBENCH = register("botanist_workbench", () -> new ChippedWorkbench(BotanistWorkbenchContainer::new,
            AbstractBlock.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final RegistryObject<Block> GLASSBLOWER = register("glassblower", () -> new ChippedWorkbench(GlassblowerContainer::new,
            AbstractBlock.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final RegistryObject<Block> CARPENTERS_TABLE = register("carpenters_table", () -> new ChippedWorkbench(CarpentersTableContainer::new,
            AbstractBlock.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final RegistryObject<Block> LOOM_TABLE = register("loom_table", () -> new ChippedWorkbench(LoomTableContainer::new,
            AbstractBlock.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final RegistryObject<Block> MASON_TABLE = register("mason_table", () -> new ChippedWorkbench(MasonTableContainer::new,
            AbstractBlock.Properties.of(Material.METAL).strength(5F, 6F).sound(SoundType.METAL).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ALCHEMY_BENCH = register("alchemy_bench", () -> new ChippedWorkbench(AlchemyBenchContainer::new,
            AbstractBlock.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
                    .isValidSpawn(VALID_SPAWN).isRedstoneConductor(ALWAYS_FALSE_POSITION)
                    .isSuffocating(ALWAYS_FALSE_POSITION).isViewBlocking(ALWAYS_FALSE_POSITION)));

    public static final RegistryObject<Block> MECHANIST_WORKBENCH = register("mechanist_workbench", () -> new ChippedWorkbench(MechanistWorkbenchContainer::new,
            AbstractBlock.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
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

        //Register Wools and Carpets
        for (int id = 0; id < 16; ++id) {
            DyeColor color = DyeColor.byId(id);
            registerVanillaBlocks(color + "_wool", 18);
            registerBlocks(color + "_carpet", () -> new CarpetBlock(color, WOOL_PROPERTIES), 18);
        }

        //Register Glasses and Stained Glasses
        registerBlocks("glass", () -> new GlassBlock(GLASS_PROPERTIES), 14);
        registerBlocks("glass_pane", () -> new PaneBlock(GLASS_PANE_PROPERTIES), 14);

        for (String wood : woodsList) {
            registerBlocks(wood + "_wood_glass", () -> new GlassBlock(GLASS_PROPERTIES), 6);
            registerBlocks(wood + "_wood_glass_pane", () -> new PaneBlock(GLASS_PANE_PROPERTIES), 6);
        }

        for (int id = 0; id < 16; ++id) {
            DyeColor color = DyeColor.byId(id);
            registerBlocks(color + "_stained_glass", () -> new StainedGlassBlock(color, GLASS_PROPERTIES), 8);
            registerBlocks(color + "_stained_glass_pane", () -> new StainedGlassPaneBlock(color, GLASS_PANE_PROPERTIES), 8);
        }

        //Register Misc
        registerVanillaBlocks(Blocks.CLAY, "clay", 19);

        for (String wood : woodsList) {
            registerBlocks(wood + "_planks", () -> new Block(WOOD_PROPERTIES), 18);
        }

        registerBlocks("hay_block", () -> new HayBlock(HAY_BLOCK_PROPERTIES), 8);
        registerBlocks("melon", () -> new MelonBlock(MELON_PROPERTIES), 10);
        registerBlocks("vine", () -> new VineBlock(VINE_PROPERTIES), 8);

        RegistryObject<Block> lantern1 = BLOCKS.register("lantern_1", () -> new ChippedLantern(LANTERN_PROPERTIES, CHONK_LANTERN_SHAPE));
        RegistryObject<Block> lantern2 = BLOCKS.register("lantern_2", () -> new ChippedLantern(LANTERN_PROPERTIES, DONUT_LANTERN_SHAPE_EAST, DONUT_LANTERN_SHAPE_NORTH));
        RegistryObject<Block> lantern3 = BLOCKS.register("lantern_3", () -> new ChippedLantern(LANTERN_PROPERTIES, TALL_LANTERN_SHAPE));
        blocksMap.put("lantern", lantern1);
        blocksMap.put("lantern", lantern2);
        blocksMap.put("lantern", lantern3);

        RegistryObject<Block> soul_lantern_1 = BLOCKS.register("soul_lantern_1", () -> new ChippedLantern(LANTERN_PROPERTIES, CHONK_LANTERN_SHAPE));
        RegistryObject<Block> soul_lantern_2 = BLOCKS.register("soul_lantern_2", () -> new ChippedLantern(LANTERN_PROPERTIES, DONUT_LANTERN_SHAPE_EAST, DONUT_LANTERN_SHAPE_NORTH));
        RegistryObject<Block> soul_lantern_3 = BLOCKS.register("soul_lantern_3", () -> new ChippedLantern(LANTERN_PROPERTIES, TALL_LANTERN_SHAPE));
        blocksMap.put("soul_lantern", soul_lantern_1);
        blocksMap.put("soul_lantern", soul_lantern_2);
        blocksMap.put("soul_lantern", soul_lantern_3);

        //Redstone Torches
        for (int i = 2; i <= 51; i++) {
            RegistryObject<Block> redstoneWallTorch = BLOCKS.register("redstone_wall_torch_" + i, () -> new RedstoneWallTorchBlock(REDSTONE_WALL_TORCH_PROPERTIES));
            RegistryObject<Block> redstoneTorch = BLOCKS.register("redstone_torch_" + i, () -> new RedstoneTorchBlock(REDSTONE_TORCH_PROPERTIES));
            ChippedItems.ITEMS.register("redstone_torch_" + i, () -> new WallOrFloorItem(redstoneTorch.get(), redstoneWallTorch.get(), new Item.Properties().tab(Chipped.CHIPPED)));
            blocksMap.put("redstone_torch", redstoneTorch);
            blocksMap.put("redstone_wall_torch", redstoneWallTorch);
        }

        //Regular Torches
        for (int i = 1; i <= 9; i++) {
            RegistryObject<Block> wallTorch = BLOCKS.register("wall_torch_" + i, () -> new WallTorchBlock(TORCH_PROPERTIES, ParticleTypes.FLAME));
            RegistryObject<Block> torch = BLOCKS.register("torch_" + i, () -> new TorchBlock(WALL_TORCH_PROPERTIES, ParticleTypes.FLAME));
            ChippedItems.ITEMS.register("torch_" + i, () -> new WallOrFloorItem(torch.get(), wallTorch.get(), new Item.Properties().tab(Chipped.CHIPPED)));
            blocksMap.put("torch", torch);
            blocksMap.put("wall_torch", wallTorch);
        }

        //Pumpkins
        for (String pumpkin : specialPumpkinList) {
            RegistryObject<Block> pumpkinBlock = register("pumpkin_" + pumpkin, () -> new PumpkinBlock(PUMPKIN_PROPERTIES));
            RegistryObject<Block> jackOLanternBlock = register("jack_o_lantern_" + pumpkin, () -> new CarvedPumpkinBlock(JACK_O_LANTERN_PROPERTIES));
            RegistryObject<Block> carvedPumpkinBlock = register("carved_pumpkin_" + pumpkin, () -> new CarvedPumpkinBlock(PUMPKIN_PROPERTIES));
            blocksMap.put("jack_o_lantern", jackOLanternBlock);
            blocksMap.put("carved_pumpkin", carvedPumpkinBlock);
            blocksMap.put("carved_pumpkin_special", jackOLanternBlock);
            blocksMap.put("carved_pumpkin_special", carvedPumpkinBlock);
            blocksMap.put("pumpkin", pumpkinBlock);
        }

        //Jack'o'Lantern & Carved Pumpkins
        for (int i = 1; i <= carvedPumpkinList.length; i++) {
            RegistryObject<Block> jackOLanternBlock = register("jack_o_lantern_" + i, () -> new CarvedPumpkinBlock(JACK_O_LANTERN_PROPERTIES));
            RegistryObject<Block> carvedPumpkinBlock = register("carved_pumpkin_" + i, () -> new CarvedPumpkinBlock(PUMPKIN_PROPERTIES));
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
        registerVanillaBlocks(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft", name)), name, count);
    }

    /**
     * Only use if a vanilla block counterpart exists and the same properties should be used.
     *
     * @param vanillaBlock The vanilla equivalent, passed explicitly 'cause explicit > implicit.
     * @param name         The registry name to be used.
     * @param count        How many of the block should be registered, the index is used as the suffix.
     */
    private static void registerVanillaBlocks(Block vanillaBlock, String name, int count) {
        registerBlocks(name, () -> new Block(AbstractBlock.Properties.copy(vanillaBlock)), count);
    }

    /**
     * Only use if a vanilla block counterpart exists and the same properties should be used.
     *
     * @param name  The registry name to be used.
     * @param count How many of the block should be registered, the index is used as the suffix.
     */
    private static void registerBlocks(String name, Supplier<Block> block, int count) {
        for (int i = 1; i <= count; i++) {
            blocksMap.put(name, register(name + "_" + i, block));
        }
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> block) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, block);
        ChippedItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(Chipped.CHIPPED)));
        return toReturn;
    }
}
