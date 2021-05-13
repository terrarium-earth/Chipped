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
import net.minecraft.block.HayBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StainedGlassBlock;
import net.minecraft.block.VineBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
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
    
    //List of blocks by type
    public static ArrayList<RegistryObject<Block>> stones = new ArrayList<RegistryObject<Block>>();
    //Every wool must have a corresponding carpet variant for 
    public static ArrayList<RegistryObject<Block>> wools = new ArrayList<RegistryObject<Block>>();
    public static ArrayList<RegistryObject<Block>> carpets = new ArrayList<RegistryObject<Block>>();
    public static ArrayList<RegistryObject<Block>> glasses = new ArrayList<RegistryObject<Block>>();
    public static ArrayList<RegistryObject<Block>> stainedGlasses = new ArrayList<RegistryObject<Block>>();
    public static ArrayList<RegistryObject<Block>> hayBlock = new ArrayList<RegistryObject<Block>>();
    public static ArrayList<RegistryObject<Block>> clays = new ArrayList<RegistryObject<Block>>();
    public static ArrayList<RegistryObject<Block>> terracottas = new ArrayList<RegistryObject<Block>>();
    public static ArrayList<RegistryObject<Block>> concretes = new ArrayList<RegistryObject<Block>>();
    public static ArrayList<RegistryObject<Block>> woods = new ArrayList<RegistryObject<Block>>();

    
    //General stones of hardness 1.5F, 6F
    public static String[] stonesList = {"stone", "granite", "diorite", "andesite", "prismarine", "dark_prismarine", "purpur_block"};
    //General rocks of hardness 1.5F, 6F
    public static String[] stones2List = {"cobblestone", "quartz_block"};
    //Sandstones of hardness 0.8F
    public static String[] stones3List = {"sandstone", "red_sandstone"};
    //Nether bricks of hardness 2F, 6F and nether bricks sounds
    public static String[] stones4List = {"nether_bricks", "red_nether_bricks"};
    //End stones of hardness 3F, 9F
    public static String[] stones5List  = {"end_stone"};

    public static String[] colorsList = {"white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"};
    public static String[] woodsList = {"oak", "birch", "spruce", "jungle", "acacia", "dark_oak", "warped", "crimson"};

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
    public static final RegistryObject<Block> BOTANIST_WORKBENCH = register(
            () -> new ChippedWorkbench(0, "botanist_workbench", AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.WOOD).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));
    public static final RegistryObject<Block> GLASSBLOWER = register(
            () -> new ChippedWorkbench(1, "glassblower", AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.WOOD).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));
    public static final RegistryObject<Block> CARPENTERS_TABLE = register(
            () -> new ChippedWorkbench(2, "carpenters_table", AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.WOOD).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));
    public static final RegistryObject<Block> LOOM_TABLE = register(
            () -> new ChippedWorkbench(3, "loom_table", AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.WOOD).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));
    public static final RegistryObject<Block> MASON_TABLE = register(
            () -> new ChippedWorkbench(4, "mason_table", AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.WOOD).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));
    public static final RegistryObject<Block> ALCHEMY_BENCH = register(
            () -> new ChippedWorkbench(5, "alchemy_bench", AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(1f, 2f).sound(SoundType.WOOD).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    /*
     * To add blocks:
     * 1. Register the RegistryObject here with properties (alternatively register it under this::register
     * 2. Give it a client render if needed
     * 3. Add it to the data generators in ChippedDataGenerator
     * 4. Give it a block name in en_us.json
     */

     
    // Vines
    public static final RegistryObject<Block> VINE_1 = register("vine_1",
            () -> new VineBlock(AbstractBlock.Properties.create(Material.TALL_PLANTS)
            		.doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.2F).sound(SoundType.PLANT)));

    @OnlyIn(Dist.CLIENT)
    public static void clientRender(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BOTANIST_WORKBENCH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(LOOM_TABLE.get(), RenderType.getCutout());
        
        for (RegistryObject<Block> glass : glasses) {
        	RenderTypeLookup.setRenderLayer(glass.get(), RenderType.getCutout());
        }
        
        for (RegistryObject<Block> stainedGlass : stainedGlasses) {
        	RenderTypeLookup.setRenderLayer(stainedGlass.get(), RenderType.getTranslucent());
        }
        
        // Vines
        RenderTypeLookup.setRenderLayer(VINE_1.get(), RenderType.getTranslucent());
    }

    public static void register() {
    	//Register blocks
    	registerStones();
    	registerStones2();
    	registerStones3();
    	registerStones4();
    	registerStones5();
    	registerStones6();
    	registerStones7();
        registerWools();
        registerCarpets();
        registerGlasses();
        registerWoodGlasses();
        registerStainedGlasses();
        registerHayBlocks();
        registerClays();
        registerTerracottas();
        registerConcretes();
        registerWoods();
        registerStones8();
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
    
    private static void registerStones6() {
    	for (int i = 1; i <= 26; i++) {
    		stones.add(register("gilded_blackstone_" + i,
    				() -> new Block(AbstractBlock.Properties.create(Material.ROCK)
    						.setRequiresTool().hardnessAndResistance(1.5F, 6.0F).sound(SoundType.GILDED_BLACKSTONE))));
    	}
    }

    private static void registerStones7() {
        for (int i = 1; i <= 18; i++) {
            stones.add(register("netherrack_" + i,
                    () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                            .setRequiresTool().hardnessAndResistance(0.4F).sound(SoundType.NETHERRACK))));
        }
    }

    private static void registerStones8() {
        for (int i = 1; i <= 21; i++) {
            stones.add(register("blackstone_" + i,
                    () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                            .setRequiresTool().hardnessAndResistance(1.5F, 6.0F).sound(SoundType.GILDED_BLACKSTONE))));
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
        	glasses.add(register("glass_" + i,
        			 () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
        	                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid))));
        }
    }
    
    private static void registerWoodGlasses() {
        for (String wood : woodsList) {
            for (int i = 1; i <= 6; i++) {
            	glasses.add(register(wood + "_wood_glass_" + i,
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
    
    private static void registerHayBlocks() {
    	for (int i = 1; i <= 8; i++) {
    		hayBlock.add(register("hay_block_" + i,
    	            () -> new HayBlock(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.YELLOW)
    	            		.hardnessAndResistance(0.5F).sound(SoundType.PLANT))));
    	}
    }
    
    private static void registerClays() {
    	for (int i = 1; i<= 19; i++) {
    		clays.add(register("clay_" + i,
    	            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
    	            		.hardnessAndResistance(0.6F).sound(SoundType.GROUND))));
    	}
    }

    private static void registerTerracottas() {
        for (String color : colorsList) {
            for (int i = 1; i <= 18; i++) {
                terracottas.add(register(color + "_terracotta_" + i, () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                        .hardnessAndResistance(1.25f, 4.2f).sound(SoundType.STONE).setRequiresTool())));
            }
        }

    }
        private static void registerConcretes() {
            for (String color : colorsList) {
                for (int i = 1; i <= 18; i++) {
                    concretes.add(register(color + "_concrete_" + i, () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                            .hardnessAndResistance(1.8f).sound(SoundType.STONE).setRequiresTool())));

                }
            }
        }
    private static void registerWoods() {
        for (String wood : woodsList) {
            for (int i = 1; i <= 18; i++) {
                woods.add(register(wood + "_planks_" + i,
                        () -> new GlassBlock(AbstractBlock.Properties.create(Material.WOOD)
                                .hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD))));
            }
        }
    }



    private static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }

    private static Boolean neverAllowSpawn(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
        return (boolean) false;
    }

    private static <T extends Block>RegistryObject<Block> register(String name, Supplier<T> block) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, block);
        ChippedItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(Chipped.CHIPPED)));
        return toReturn;
    }
    
    /**
     * Alternate registry of ChippedWorkbenches
     * @param <T>
     * @param block
     * @return
     */
    private static <T extends Block>RegistryObject<Block> register(Supplier<ChippedWorkbench> block) {
    	return register(block.get().ITEM_ID, block);
    }
}