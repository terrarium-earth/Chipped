package com.grimbo.chipped.block;


import java.util.ArrayList;
import java.util.function.Supplier;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.item.ChippedItems;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StainedGlassBlock;
import net.minecraft.block.VineBlock;
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
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ChippedBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Chipped.MOD_ID);

    public static ArrayList<RegistryObject<Block>> stones = new ArrayList<RegistryObject<Block>>();
    public static ArrayList<RegistryObject<Block>> wools = new ArrayList<RegistryObject<Block>>();
    public static ArrayList<RegistryObject<Block>> carpets = new ArrayList<RegistryObject<Block>>();
    public static ArrayList<RegistryObject<Block>> glasses = new ArrayList<RegistryObject<Block>>();
    public static ArrayList<RegistryObject<Block>> woodGlasses = new ArrayList<RegistryObject<Block>>();
    public static ArrayList<RegistryObject<Block>> stainedGlasses = new ArrayList<RegistryObject<Block>>();
    
    //General stones of hardness 1.5F, 6F
    public static String[] stonesList = {"stone", "granite", "diorite", "andesite", "prismarine", "dark_prismarine", "purpur"};
    //General rocks of hardness 1.5F, 6F
    public static String[] stones2List = {"cobblestone", "quartz"};
    //Sandstones of hardness 0.8F
    public static String[] stones3List = {"sandstone", "red_sandstone"};
    //Nether bricks of hardness 2F, 6F and nether bricks sounds
    public static String[] stones4List = {"nether_bricks", "red_nether_bricks"};
    //End stones of hardness 3F, 9F
    public static String[] stones5List  = {"end_stone"};
    public static String[] colorsList = {"white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"};
    public static String[] woodsList = {"oak", "birch", "spruce", "jungle", "acacia", "dark_oak", "warped", "crimson"};
    
    // Workbenches
    public static final RegistryObject<Block> BOTANIST_WORKBENCH = register("botanist_workbench",
            () -> new ChippedWorkbench(0, "container.chipped.botanist_workbench", AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.WOOD).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

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

    // Vines

    public static final RegistryObject<Block> VINE_1 = register("vine_1",
            () -> new VineBlock(AbstractBlock.Properties.create(Material.TALL_PLANTS)
            		.doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.2F).sound(SoundType.PLANT)));
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
    
// gilded blackstone
    
    public static final RegistryObject<Block> GILDEDBLACKSTONE_1 = register("gildedblackstone_1", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK)));
    public static final RegistryObject<Block> GILDEDBLACKSTONE_2 = register("gildedblackstone_2", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK)));
    public static final RegistryObject<Block> GILDEDBLACKSTONE_3 = register("gildedblackstone_3", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK)));
    public static final RegistryObject<Block> GILDEDBLACKSTONE_4 = register("gildedblackstone_4", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK)));
    public static final RegistryObject<Block> GILDEDBLACKSTONE_5 = register("gildedblackstone_5", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK)));


    @OnlyIn(Dist.CLIENT)
    public static void clientRender(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BOTANIST_WORKBENCH.get(), RenderType.getCutout());
        
        for (RegistryObject<Block> glass : glasses) {
        	RenderTypeLookup.setRenderLayer(glass.get(), RenderType.getCutout());
        }

        for (RegistryObject<Block> woodGlass : woodGlasses) {
        	RenderTypeLookup.setRenderLayer(woodGlass.get(), RenderType.getCutout());
        }

        for (RegistryObject<Block> stainedGlass : stainedGlasses) {
        	RenderTypeLookup.setRenderLayer(stainedGlass.get(), RenderType.getTranslucent());
        }
        
        // Vines
        RenderTypeLookup.setRenderLayer(VINE_1.get(), RenderType.getTranslucent());
    }

    public static void register() {
    	registerStones();
    	registerStones2();
    	registerStones3();
    	registerStones4();
    	registerStones5();
        registerWools();
        registerCarpets();
        registerGlasses();
        registerWoodGlasses();
        registerStainedGlasses();
    }
    
    private static void registerStones() {
    	for (String stone : stonesList) {
        	for (int i = 1; i <= 18; i++) {
        		stones.add(register(stone + "_" + i,
                    () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    		.setRequiresTool().hardnessAndResistance(1.5F, 6.0F))));
        	}
    	}
    }
    
    private static void registerStones2() {
    	for (String stone : stones2List) {
        	for (int i = 1; i <= 18; i++) {
        		stones.add(register(stone + "_" + i,
                    () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    		.setRequiresTool().hardnessAndResistance(2F, 6.0F))));
        	}
    	}
    }
    
    private static void registerStones3() {
    	for (String stone : stones3List) {
        	for (int i = 1; i <= 18; i++) {
        		stones.add(register(stone + "_" + i,
                    () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    		.setRequiresTool().hardnessAndResistance(0.8F))));
        	}
    	}
    }
    
    private static void registerStones4() {
    	for (String stone : stones4List) {
        	for (int i = 1; i <= 18; i++) {
        		stones.add(register(stone + "_" + i,
                    () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    		.setRequiresTool().hardnessAndResistance(2.0F, 6.0F).sound(SoundType.NETHER_BRICK))));
        	}
    	}
    }
    
    private static void registerStones5() {
    	for (String stone : stones5List) {
        	for (int i = 1; i <= 18; i++) {
        		stones.add(register(stone + "_" + i,
                    () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    		.setRequiresTool().hardnessAndResistance(3F, 9.0F))));
        	}
    	}
    }

    private static void registerWools() {
        for (String color : colorsList) {
            for (int i = 1; i <= 18; i++) {
                wools.add(register(color + "_wool_" + i, () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
                        .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH))));
            }
        }
    }

    private static void registerCarpets() {
        for (String color : colorsList) {
            for (int i = 1; i <= 18; i++) {
                carpets.add(register(color + "_carpet_" + i, () -> new CarpetBlock(DyeColor.byTranslationKey(color, DyeColor.BLACK), AbstractBlock.Properties.create(Material.WOOL)
                        .hardnessAndResistance(0.3F).sound(SoundType.CLOTH))));
            }
        }
    }
    
    private static void registerGlasses() {
        for (int i = 1; i <= 14; i++) {
        	stainedGlasses.add(register("glass_" + i,
        			 () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
        	                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid))));
        }
    }
    
    private static void registerWoodGlasses() {
        for (String wood : woodsList) {
            for (int i = 1; i <= 6; i++) {
            	stainedGlasses.add(register(wood + "_wood_glass_" + i,
            			 () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
            	                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid))));
            }
        }
    }
    
    private static void registerStainedGlasses() {
        for (String color : colorsList) {
            for (int i = 1; i <= 8; i++) {
            	stainedGlasses.add(register(color + "_stained_glass_" + i,
                        () -> new StainedGlassBlock(DyeColor.byTranslationKey(color, DyeColor.BLACK), AbstractBlock.Properties.create(Material.GLASS)
                                .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid))));
            }
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

    private  static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        ChippedItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(Chipped.CHIPPED)));
        return toReturn;
    }
}