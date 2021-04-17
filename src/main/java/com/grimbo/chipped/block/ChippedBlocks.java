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
	
	public static ArrayList<RegistryObject<Block>> wools = new ArrayList<RegistryObject<Block>>();
	public static ArrayList<RegistryObject<Block>> carpets = new ArrayList<RegistryObject<Block>>();
	
	//Same order as vanilla's coding
	public static String[] colors = {"white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"};
	
	//Workbenches
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

    // Glass

    public static final RegistryObject<Block> GLASS_1 = register("glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_2 = register("glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_3 = register("glass_3",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_4 = register("glass_4",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_5 = register("glass_5",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_6 = register("glass_6",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_7 = register("glass_7",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_8 = register("glass_8",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_9 = register("glass_9",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_10 = register("glass_10",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_11 = register("glass_11",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_12 = register("glass_12",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_13 = register("glass_13",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GLASS_14 = register("glass_14",
            () -> new Block(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Dark Oak Glass

    public static final RegistryObject<Block> DARK_OAK_GLASS_1 = register("dark_oak_glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> DARK_OAK_GLASS_2 = register("dark_oak_glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> DARK_OAK_GLASS_3 = register("dark_oak_glass_3",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> DARK_OAK_GLASS_4 = register("dark_oak_glass_4",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> DARK_OAK_GLASS_5 = register("dark_oak_glass_5",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> DARK_OAK_GLASS_6 = register("dark_oak_glass_6",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Warped Wood Glass

    public static final RegistryObject<Block> WARPED_WOOD_GLASS_1 = register("warped_wood_glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> WARPED_WOOD_GLASS_2 = register("warped_wood_glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> WARPED_WOOD_GLASS_3 = register("warped_wood_glass_3",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> WARPED_WOOD_GLASS_4 = register("warped_wood_glass_4",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> WARPED_WOOD_GLASS_5 = register("warped_wood_glass_5",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> WARPED_WOOD_GLASS_6 = register("warped_wood_glass_6",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Spruce Wood Glass

    public static final RegistryObject<Block> SPRUCE_WOOD_GLASS_1 = register("spruce_wood_glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> SPRUCE_WOOD_GLASS_2 = register("spruce_wood_glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> SPRUCE_WOOD_GLASS_3 = register("spruce_wood_glass_3",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> SPRUCE_WOOD_GLASS_4 = register("spruce_wood_glass_4",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> SPRUCE_WOOD_GLASS_5 = register("spruce_wood_glass_5",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> SPRUCE_WOOD_GLASS_6 = register("spruce_wood_glass_6",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Oak Wood Glass

    public static final RegistryObject<Block> OAK_WOOD_GLASS_1 = register("oak_wood_glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> OAK_WOOD_GLASS_2 = register("oak_wood_glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> OAK_WOOD_GLASS_3 = register("oak_wood_glass_3",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> OAK_WOOD_GLASS_4 = register("oak_wood_glass_4",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> OAK_WOOD_GLASS_5 = register("oak_wood_glass_5",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> OAK_WOOD_GLASS_6 = register("oak_wood_glass_6",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Birch Wood Glass

    public static final RegistryObject<Block> BIRCH_WOOD_GLASS_1 = register("birch_wood_glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BIRCH_WOOD_GLASS_2 = register("birch_wood_glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BIRCH_WOOD_GLASS_3 = register("birch_wood_glass_3",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BIRCH_WOOD_GLASS_4 = register("birch_wood_glass_4",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BIRCH_WOOD_GLASS_5 = register("birch_wood_glass_5",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BIRCH_WOOD_GLASS_6 = register("birch_wood_glass_6",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Jungle Wood Glass

    public static final RegistryObject<Block> JUNGLE_WOOD_GLASS_1 = register("jungle_wood_glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> JUNGLE_WOOD_GLASS_2 = register("jungle_wood_glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> JUNGLE_WOOD_GLASS_3 = register("jungle_wood_glass_3",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> JUNGLE_WOOD_GLASS_4 = register("jungle_wood_glass_4",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> JUNGLE_WOOD_GLASS_5 = register("jungle_wood_glass_5",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> JUNGLE_WOOD_GLASS_6 = register("jungle_wood_glass_6",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Crimson Wood Glass

    public static final RegistryObject<Block> CRIMSON_WOOD_GLASS_1 = register("crimson_wood_glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> CRIMSON_WOOD_GLASS_2 = register("crimson_wood_glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> CRIMSON_WOOD_GLASS_3 = register("crimson_wood_glass_3",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));


    public static final RegistryObject<Block> CRIMSON_WOOD_GLASS_4 = register("crimson_wood_glass_4",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));


    public static final RegistryObject<Block> CRIMSON_WOOD_GLASS_5 = register("crimson_wood_glass_5",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));


    public static final RegistryObject<Block> CRIMSON_WOOD_GLASS_6 = register("crimson_wood_glass_6",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Acacia Glass

    public static final RegistryObject<Block> ACACIA_WOOD_GLASS_1 = register("acacia_wood_glass_1",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> ACACIA_WOOD_GLASS_2 = register("acacia_wood_glass_2",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> ACACIA_WOOD_GLASS_3 = register("acacia_wood_glass_3",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> ACACIA_WOOD_GLASS_4 = register("acacia_wood_glass_4",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> ACACIA_WOOD_GLASS_5 = register("acacia_wood_glass_5",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> ACACIA_WOOD_GLASS_6 = register("acacia_wood_glass_6",
            () -> new GlassBlock(AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Stained Glass
    // Black Stained Glass

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_1 = register("black_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_2 = register("black_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_3 = register("black_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_4 = register("black_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_5 = register("black_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_6 = register("black_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_7 = register("black_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BLACK_STAINED_GLASS_8 = register("black_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.BLACK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Blue Stained Glass

    public static final RegistryObject<Block> BLUE_STAINED_GLASS_1 = register("blue_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BLUE_STAINED_GLASS_2 = register("blue_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BLUE_STAINED_GLASS_3 = register("blue_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BLUE_STAINED_GLASS_4 = register("blue_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BLUE_STAINED_GLASS_5 = register("blue_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BLUE_STAINED_GLASS_6 = register("blue_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BLUE_STAINED_GLASS_7 = register("blue_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BLUE_STAINED_GLASS_8 = register("blue_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Brown SG

    public static final RegistryObject<Block> BROWN_STAINED_GLASS_1 = register("brown_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor. BROWN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BROWN_STAINED_GLASS_2 = register("brown_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BROWN_STAINED_GLASS_3 = register("brown_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BROWN_STAINED_GLASS_4 = register("brown_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BROWN_STAINED_GLASS_5 = register("brown_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor. BROWN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BROWN_STAINED_GLASS_6 = register("brown_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BROWN_STAINED_GLASS_7 = register("brown_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> BROWN_STAINED_GLASS_8 = register("brown_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.BROWN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Cyan SG

    public static final RegistryObject<Block> CYAN_STAINED_GLASS_1 = register("cyan_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> CYAN_STAINED_GLASS_2 = register("cyan_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> CYAN_STAINED_GLASS_3 = register("cyan_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> CYAN_STAINED_GLASS_4 = register("cyan_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> CYAN_STAINED_GLASS_5 = register("cyan_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> CYAN_STAINED_GLASS_6 = register("cyan_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> CYAN_STAINED_GLASS_7 = register("cyan_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> CYAN_STAINED_GLASS_8 = register("cyan_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.CYAN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Purple SG

    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_1 = register("purple_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_2 = register("purple_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_3 = register("purple_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_4 = register("purple_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_5 = register("purple_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_6 = register("purple_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_7 = register("purple_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> PURPLE_STAINED_GLASS_8 = register("purple_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Gray SG

    public static final RegistryObject<Block> GRAY_STAINED_GLASS_1 = register("gray_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GRAY_STAINED_GLASS_2 = register("gray_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GRAY_STAINED_GLASS_3 = register("gray_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GRAY_STAINED_GLASS_4 = register("gray_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GRAY_STAINED_GLASS_5 = register("gray_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GRAY_STAINED_GLASS_6 = register("gray_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GRAY_STAINED_GLASS_7 = register("gray_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GRAY_STAINED_GLASS_8 = register("gray_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Green SG

    public static final RegistryObject<Block> GREEN_STAINED_GLASS_1 = register("green_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GREEN_STAINED_GLASS_2 = register("green_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GREEN_STAINED_GLASS_3 = register("green_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GREEN_STAINED_GLASS_4 = register("green_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GREEN_STAINED_GLASS_5 = register("green_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GREEN_STAINED_GLASS_6 = register("green_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GREEN_STAINED_GLASS_7 = register("green_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> GREEN_STAINED_GLASS_8 = register("green_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.GREEN, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Yellow SG

    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_1 = register("yellow_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_2 = register("yellow_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_3 = register("yellow_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_4 = register("yellow_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_5 = register("yellow_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_6 = register("yellow_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_7 = register("yellow_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> YELLOW_STAINED_GLASS_8 = register("yellow_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Light Blue SG

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_1 = register("light_blue_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_2 = register("light_blue_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_3 = register("light_blue_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_4 = register("light_blue_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_5 = register("light_blue_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_6 = register("light_blue_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_7 = register("light_blue_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_BLUE_STAINED_GLASS_8 = register("light_blue_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Light Gray SG

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_1 = register("light_gray_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_2 = register("light_gray_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_3 = register("light_gray_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_4 = register("light_gray_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_5 = register("light_gray_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_6 = register("light_gray_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_7 = register("light_gray_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIGHT_GRAY_STAINED_GLASS_8 = register("light_gray_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Lime SG

    public static final RegistryObject<Block> LIME_STAINED_GLASS_1 = register("lime_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIME_STAINED_GLASS_2 = register("lime_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIME_STAINED_GLASS_3 = register("lime_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIME_STAINED_GLASS_4 = register("lime_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIME_STAINED_GLASS_5 = register("lime_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIME_STAINED_GLASS_6 = register("lime_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIME_STAINED_GLASS_7 = register("lime_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> LIME_STAINED_GLASS_8 = register("lime_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.LIME, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Magenta SG

    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_1 = register("magenta_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_2 = register("magenta_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_3 = register("magenta_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_4 = register("magenta_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_5 = register("magenta_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_6 = register("magenta_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_7 = register("magenta_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> MAGENTA_STAINED_GLASS_8 = register("magenta_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Orange SG

    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_1 = register("orange_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_2 = register("orange_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_3 = register("orange_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_4 = register("orange_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_5 = register("orange_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_6 = register("orange_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_7 = register("orange_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_8 = register("orange_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Pink SG

    public static final RegistryObject<Block> PINK_STAINED_GLASS_1 = register("pink_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> PINK_STAINED_GLASS_2 = register("pink_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> PINK_STAINED_GLASS_3 = register("pink_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> PINK_STAINED_GLASS_4 = register("pink_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> PINK_STAINED_GLASS_5 = register("pink_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> PINK_STAINED_GLASS_6 = register("pink_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> PINK_STAINED_GLASS_7 = register("pink_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> PINK_STAINED_GLASS_8 = register("pink_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.PINK, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // Red SG

    public static final RegistryObject<Block> RED_STAINED_GLASS_1 = register("red_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> RED_STAINED_GLASS_2 = register("red_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> RED_STAINED_GLASS_3 = register("red_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> RED_STAINED_GLASS_4 = register("red_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> RED_STAINED_GLASS_5 = register("red_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> RED_STAINED_GLASS_6 = register("red_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> RED_STAINED_GLASS_7 = register("red_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> RED_STAINED_GLASS_8 = register("red_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.RED, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    // White SG

    public static final RegistryObject<Block> WHITE_STAINED_GLASS_1 = register("white_stained_glass_1",
            () -> new StainedGlassBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> WHITE_STAINED_GLASS_2 = register("white_stained_glass_2",
            () -> new StainedGlassBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> WHITE_STAINED_GLASS_3 = register("white_stained_glass_3",
            () -> new StainedGlassBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> WHITE_STAINED_GLASS_4 = register("white_stained_glass_4",
            () -> new StainedGlassBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> WHITE_STAINED_GLASS_5 = register("white_stained_glass_5",
            () -> new StainedGlassBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> WHITE_STAINED_GLASS_6 = register("white_stained_glass_6",
            () -> new StainedGlassBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> WHITE_STAINED_GLASS_7 = register("white_stained_glass_7",
            () -> new StainedGlassBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));

    public static final RegistryObject<Block> WHITE_STAINED_GLASS_8 = register("white_stained_glass_8",
            () -> new StainedGlassBlock(DyeColor.WHITE, AbstractBlock.Properties.create(Material.GLASS)
                    .hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid().setAllowsSpawn(ChippedBlocks::neverAllowSpawn).setOpaque(ChippedBlocks::isntSolid).setSuffocates(ChippedBlocks::isntSolid).setBlocksVision(ChippedBlocks::isntSolid)));
    // Vines

    public static final RegistryObject<Block> VINE_1 = register("vine_1",
            () -> new VineBlock(AbstractBlock.Properties.create(Material.PLANTS)
                    .hardnessAndResistance(0.2F).sound(SoundType.PLANT)));

    // Andesite

    public static final RegistryObject<Block> ANDESITE_1 = register("andesite_1",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_2 = register("andesite_2",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_3 = register("andesite_3",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_4 = register("andesite_4",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_5 = register("andesite_5",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_6 = register("andesite_6",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_7 = register("andesite_7",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_8 = register("andesite_8",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_9 = register("andesite_9",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_10 = register("andesite_10",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_11 = register("andesite_11",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_12 = register("andesite_12",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_13 = register("andesite_13",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_14 = register("andesite_14",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_15 = register("andesite_15",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_16 = register("andesite_16",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_17 = register("andesite_17",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ANDESITE_18 = register("andesite_18",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

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

    // Dark Prismarine


    public static final RegistryObject<Block> DARKPRISMARINE_1 = register("darkprismarine_1",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_2 = register("darkprismarine_2",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_3 = register("darkprismarine_3",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_4 = register("darkprismarine_4",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_5 = register("darkprismarine_5",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_6 = register("darkprismarine_6",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_7 = register("darkprismarine_7",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_8 = register("darkprismarine_8",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_9 = register("darkprismarine_9",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_10 = register("darkprismarine_10",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_11 = register("darkprismarine_11",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_12 = register("darkprismarine_12",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_13 = register("darkprismarine_13",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_14 = register("darkprismarine_14",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_15 = register("darkprismarine_15",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_16 = register("darkprismarine_16",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_17 = register("darkprismarine_17",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> DARKPRISMARINE_18 = register("darkprismarine_18",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    // Prismarine

    public static final RegistryObject<Block> PRISMARINE_1 = register("prismarine_1",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_2 = register("prismarine_2",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_3 = register("prismarine_3",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_4 = register("prismarine_4",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_5 = register("prismarine_5",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_6 = register("prismarine_6",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_7 = register("prismarine_7",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_8 = register("prismarine_8",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_9 = register("prismarine_9",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_10 = register("prismarine_10",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_11 = register("prismarine_11",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_12 = register("prismarine_12",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_13 = register("prismarine_13",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_14 = register("prismarine_14",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_15 = register("prismarine_15",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_16 = register("prismarine_16",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_17 = register("prismarine_17",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PRISMARINE_18 = register("prismarine_18",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(2f, 3f).sound(SoundType.STONE)));

    @OnlyIn(Dist.CLIENT)
    public static void clientRender(final FMLClientSetupEvent event) {
    	RenderTypeLookup.setRenderLayer(BOTANIST_WORKBENCH.get(), RenderType.getCutout());
        // Normal
        RenderTypeLookup.setRenderLayer(GLASS_1.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GLASS_2.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GLASS_3.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GLASS_4.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GLASS_5.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GLASS_6.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GLASS_7.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GLASS_8.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GLASS_9.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GLASS_10.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GLASS_11.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GLASS_12.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GLASS_13.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(GLASS_14.get(), RenderType.getCutout());
        // Dark Oak
        RenderTypeLookup.setRenderLayer(DARK_OAK_GLASS_1.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(DARK_OAK_GLASS_2.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(DARK_OAK_GLASS_3.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(DARK_OAK_GLASS_4.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(DARK_OAK_GLASS_5.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(DARK_OAK_GLASS_6.get(), RenderType.getCutout());
        // Warped
        RenderTypeLookup.setRenderLayer(WARPED_WOOD_GLASS_1.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(WARPED_WOOD_GLASS_2.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(WARPED_WOOD_GLASS_3.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(WARPED_WOOD_GLASS_4.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(WARPED_WOOD_GLASS_5.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(WARPED_WOOD_GLASS_6.get(), RenderType.getCutout());
        // Spruce
        RenderTypeLookup.setRenderLayer(SPRUCE_WOOD_GLASS_1.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(SPRUCE_WOOD_GLASS_2.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(SPRUCE_WOOD_GLASS_3.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(SPRUCE_WOOD_GLASS_4.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(SPRUCE_WOOD_GLASS_5.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(SPRUCE_WOOD_GLASS_6.get(), RenderType.getCutout());
        // Oak
        RenderTypeLookup.setRenderLayer(OAK_WOOD_GLASS_1.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(OAK_WOOD_GLASS_2.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(OAK_WOOD_GLASS_3.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(OAK_WOOD_GLASS_4.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(OAK_WOOD_GLASS_5.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(OAK_WOOD_GLASS_6.get(), RenderType.getCutout());
        // Birch
        RenderTypeLookup.setRenderLayer(BIRCH_WOOD_GLASS_1.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BIRCH_WOOD_GLASS_2.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BIRCH_WOOD_GLASS_3.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BIRCH_WOOD_GLASS_4.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BIRCH_WOOD_GLASS_5.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BIRCH_WOOD_GLASS_6.get(), RenderType.getCutout());
        // Jungle
        RenderTypeLookup.setRenderLayer(JUNGLE_WOOD_GLASS_1.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(JUNGLE_WOOD_GLASS_2.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(JUNGLE_WOOD_GLASS_3.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(JUNGLE_WOOD_GLASS_4.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(JUNGLE_WOOD_GLASS_5.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(JUNGLE_WOOD_GLASS_6.get(), RenderType.getCutout());
        // Crimson
        RenderTypeLookup.setRenderLayer(CRIMSON_WOOD_GLASS_1.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(CRIMSON_WOOD_GLASS_2.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(CRIMSON_WOOD_GLASS_3.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(CRIMSON_WOOD_GLASS_4.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(CRIMSON_WOOD_GLASS_5.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(CRIMSON_WOOD_GLASS_6.get(), RenderType.getCutout());
        // Acacia
        RenderTypeLookup.setRenderLayer(ACACIA_WOOD_GLASS_1.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ACACIA_WOOD_GLASS_2.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ACACIA_WOOD_GLASS_3.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ACACIA_WOOD_GLASS_4.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ACACIA_WOOD_GLASS_5.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ACACIA_WOOD_GLASS_6.get(), RenderType.getCutout());
        
        // Black SG
        RenderTypeLookup.setRenderLayer(BLACK_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BLACK_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BLACK_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BLACK_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BLACK_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BLACK_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BLACK_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BLACK_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Blue SG
        RenderTypeLookup.setRenderLayer(BLUE_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BLUE_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BLUE_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BLUE_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BLUE_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BLUE_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BLUE_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BLUE_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Brown SG
        RenderTypeLookup.setRenderLayer(BROWN_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BROWN_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BROWN_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BROWN_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BROWN_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BROWN_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BROWN_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BROWN_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Cyan SG
        RenderTypeLookup.setRenderLayer(CYAN_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(CYAN_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(CYAN_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(CYAN_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(CYAN_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(CYAN_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(CYAN_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(CYAN_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Purple SG
        RenderTypeLookup.setRenderLayer(PURPLE_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(PURPLE_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(PURPLE_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(PURPLE_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(PURPLE_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(PURPLE_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(PURPLE_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(PURPLE_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Gray SG
        RenderTypeLookup.setRenderLayer(GRAY_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(GRAY_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(GRAY_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(GRAY_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(GRAY_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(GRAY_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(GRAY_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(GRAY_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Green SG
        RenderTypeLookup.setRenderLayer(GREEN_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(GREEN_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(GREEN_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(GREEN_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(GREEN_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(GREEN_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(GREEN_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(GREEN_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Yellow SG
        RenderTypeLookup.setRenderLayer(YELLOW_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(YELLOW_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(YELLOW_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(YELLOW_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(YELLOW_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(YELLOW_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(YELLOW_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(YELLOW_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Light Blue SG
        RenderTypeLookup.setRenderLayer(LIGHT_BLUE_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIGHT_BLUE_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIGHT_BLUE_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIGHT_BLUE_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIGHT_BLUE_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIGHT_BLUE_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIGHT_BLUE_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIGHT_BLUE_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Light Gray SG
        RenderTypeLookup.setRenderLayer(LIGHT_GRAY_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIGHT_GRAY_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIGHT_GRAY_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIGHT_GRAY_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIGHT_GRAY_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIGHT_GRAY_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIGHT_GRAY_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIGHT_GRAY_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Lime SG
        RenderTypeLookup.setRenderLayer(LIME_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIME_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIME_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIME_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIME_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIME_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIME_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(LIME_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Magenta SG
        RenderTypeLookup.setRenderLayer(MAGENTA_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(MAGENTA_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(MAGENTA_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(MAGENTA_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(MAGENTA_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(MAGENTA_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(MAGENTA_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(MAGENTA_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Orange SG
        RenderTypeLookup.setRenderLayer(ORANGE_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ORANGE_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ORANGE_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ORANGE_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ORANGE_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ORANGE_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ORANGE_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ORANGE_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Pink SG
        RenderTypeLookup.setRenderLayer(PINK_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(PINK_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(PINK_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(PINK_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(PINK_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(PINK_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(PINK_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(PINK_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Red SG
        RenderTypeLookup.setRenderLayer(RED_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(RED_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(RED_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(RED_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(RED_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(RED_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(RED_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(RED_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // White SG
        RenderTypeLookup.setRenderLayer(WHITE_STAINED_GLASS_1.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(WHITE_STAINED_GLASS_2.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(WHITE_STAINED_GLASS_3.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(WHITE_STAINED_GLASS_4.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(WHITE_STAINED_GLASS_5.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(WHITE_STAINED_GLASS_6.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(WHITE_STAINED_GLASS_7.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(WHITE_STAINED_GLASS_8.get(), RenderType.getTranslucent());
        // Vines
        RenderTypeLookup.setRenderLayer(VINE_1.get(), RenderType.getTranslucent());
    }

    public static void register() {
    	registerWool();
    	registerCarpet();
    }
    
    private static void registerWool() {
    	for (String color : colors) {
    		for (int i = 1; i <= 18; i++) {
    			wools.add(register(color + "_wool_" + i, () -> new Block(AbstractBlock.Properties.create(Material.WOOL)
    	                    .hardnessAndResistance(1f, 2f).sound(SoundType.CLOTH))));
    		}
    	}
    }
    
    private static void registerCarpet() {
    	for (String color : colors) {
    		for (int i = 1; i <= 18; i++) {
    			carpets.add(register(color + "_carpet_" + i, () -> new CarpetBlock(DyeColor.byTranslationKey(color, DyeColor.BLACK), AbstractBlock.Properties.create(Material.WOOL)
    					.hardnessAndResistance(0.3F).sound(SoundType.CLOTH))));
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
