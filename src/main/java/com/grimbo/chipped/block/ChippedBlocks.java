package com.grimbo.chipped.block;

import java.util.function.Supplier;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.item.ChippedItems;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.CryingObsidianBlock;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.HayBlock;
import net.minecraft.block.MelonBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StainedGlassBlock;
import net.minecraft.block.VineBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ChippedBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Chipped.MOD_ID);

	public static Multimap<String, RegistryObject<Block>> blocksMap = ArrayListMultimap.create();

	// General stones of hardness 1.5F, 6F
	public static String[] stonesList = { "stone", "granite", "diorite", "andesite", "prismarine", "dark_prismarine",
			"purpur_block" };
	// General rocks of hardness 1.5F, 6F
	public static String[] stones2List = { "cobblestone", "quartz_block" };
	// Sandstones of hardness 0.8F
	public static String[] stones3List = { "sandstone", "red_sandstone" };
	// Nether bricks of hardness 2F, 6F and nether bricks sounds
	public static String[] stones4List = { "nether_bricks", "red_nether_bricks" };
	// End stones of hardness 3F, 9F
	public static String[] stones5List = { "end_stone" };

	public static String[] colorsList = { "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray",
			"light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black" };
	public static String[] woodsList = { "oak", "birch", "spruce", "jungle", "acacia", "dark_oak", "warped",
			"crimson" };
	
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
	public static final RegistryObject<Block> BOTANIST_WORKBENCH = register(() -> new ChippedWorkbench(0, "botanist_workbench",
			AbstractBlock.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
					.isValidSpawn(ChippedBlocks::neverAllowSpawn).isRedstoneConductor(ChippedBlocks::isntSolid)
					.isSuffocating(ChippedBlocks::isntSolid).isViewBlocking(ChippedBlocks::isntSolid)));
	public static final RegistryObject<Block> GLASSBLOWER = register(() -> new ChippedWorkbench(1, "glassblower",
			AbstractBlock.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
					.isValidSpawn(ChippedBlocks::neverAllowSpawn).isRedstoneConductor(ChippedBlocks::isntSolid)
					.isSuffocating(ChippedBlocks::isntSolid).isViewBlocking(ChippedBlocks::isntSolid)));
	public static final RegistryObject<Block> CARPENTERS_TABLE = register(() -> new ChippedWorkbench(2, "carpenters_table",
			AbstractBlock.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
					.isValidSpawn(ChippedBlocks::neverAllowSpawn).isRedstoneConductor(ChippedBlocks::isntSolid)
					.isSuffocating(ChippedBlocks::isntSolid).isViewBlocking(ChippedBlocks::isntSolid)));
	public static final RegistryObject<Block> LOOM_TABLE = register(() -> new ChippedWorkbench(3, "loom_table",
			AbstractBlock.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
					.isValidSpawn(ChippedBlocks::neverAllowSpawn).isRedstoneConductor(ChippedBlocks::isntSolid)
					.isSuffocating(ChippedBlocks::isntSolid).isViewBlocking(ChippedBlocks::isntSolid)));
	public static final RegistryObject<Block> MASON_TABLE = register(() -> new ChippedWorkbench(4, "mason_table",
			AbstractBlock.Properties.of(Material.METAL).strength(5F, 6F).sound(SoundType.METAL).noOcclusion()
					.isValidSpawn(ChippedBlocks::neverAllowSpawn).isRedstoneConductor(ChippedBlocks::isntSolid)
					.isSuffocating(ChippedBlocks::isntSolid).isViewBlocking(ChippedBlocks::isntSolid).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> ALCHEMY_BENCH = register(() -> new ChippedWorkbench(5, "alchemy_bench",
			AbstractBlock.Properties.of(Material.WOOD).strength(1F, 2F).sound(SoundType.WOOD).noOcclusion()
					.isValidSpawn(ChippedBlocks::neverAllowSpawn).isRedstoneConductor(ChippedBlocks::isntSolid)
					.isSuffocating(ChippedBlocks::isntSolid).isViewBlocking(ChippedBlocks::isntSolid)));

	/*
	 * To add blocks: 
	 * 1. Register the RegistryObject in this::register with properties (this::registerBlocks is for any basic blocks that extends Block)
	 * 2. Give it a client render if needed in Chipped::clientRender
	 * 3. Add it to the data generators in ChippedDataGenerator
	 * 4. Give it a block name in en_us.json
	 */
	public static void register() {
		// Register Stones
		registerBlocks(stonesList, 18, Material.STONE, 1.5F, 6.0F);
		registerBlocks(stones2List, 18, Material.STONE, 2.0F, 6.0F);
		registerBlocks(stones3List, 18, Material.STONE, 0.8F);
		registerBlocks(stones4List, 18, Material.STONE, 2.0F, 6.0F, SoundType.NETHER_BRICKS);
		registerBlocks(stones5List, 18, Material.STONE, 3.0F, 9.0F);
		registerBlocks("gilded_blackstone", 26, Material.STONE, 1.5F, 6.0F, SoundType.GILDED_BLACKSTONE);
		registerBlocks("netherrack", 18, Material.STONE, 0.4F, SoundType.NETHERRACK);
		registerBlocks("blackstone", 21, Material.STONE, 1.5F, 6.0F, SoundType.GILDED_BLACKSTONE);
		registerBlocks("basalt", 20, Material.STONE, 1.25F, 4.2F);
		registerBlocks("obsidian", 20, Material.STONE, 50.0F, 1200.0F);
		
		for (String color : colorsList) {
			registerBlocks(color + "_terracotta", 18, Material.STONE, 1.25F, 4.2F);
			registerBlocks(color + "_concrete", 18, Material.STONE, 1.8F);
		}
		
		for (int i = 1; i <= 20; i++) {
			blocksMap.put("crying_obsidian", register("crying_obsidian_" + i, () -> new CryingObsidianBlock(AbstractBlock.Properties.copy(Blocks.CRYING_OBSIDIAN))));
		}
		
		//Register Wools and Carpets
		for (String color : colorsList) {
			registerBlocks(color + "_wool", 18, Material.WOOL, 1.0F, 2.0F, SoundType.WOOL);
			for (int i = 1; i <= 18; i++) {
				blocksMap.put(color + "_carpet", register(color + "_carpet_" + i, () -> new CarpetBlock(DyeColor.byName(color, DyeColor.BLACK), 
						AbstractBlock.Properties.of(Material.WOOL).strength(0.3F).sound(SoundType.WOOL))));
			}
		}
		
		//Register Glasses and Stained Glasses
		for (int i = 1; i <= 14; i++) {
			blocksMap.put("glass", register("glass_" + i, () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS)
					.strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(ChippedBlocks::neverAllowSpawn)
					.isRedstoneConductor(ChippedBlocks::isntSolid).isSuffocating(ChippedBlocks::isntSolid)
					.isViewBlocking(ChippedBlocks::isntSolid))));
		}
		
		for (String wood : woodsList) {
			for (int i = 1; i <= 6; i++) {
				blocksMap.put(wood + "_wood_glass", register(wood + "_wood_glass_" + i, () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS)
						.strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(ChippedBlocks::neverAllowSpawn)
						.isRedstoneConductor(ChippedBlocks::isntSolid).isSuffocating(ChippedBlocks::isntSolid)
						.isViewBlocking(ChippedBlocks::isntSolid))));
			}
		}

		for (String color : colorsList) {
			for (int i = 1; i <= 8; i++) {
				blocksMap.put(color + "_stained_glass", register(color + "_stained_glass_" + i, () -> new StainedGlassBlock(DyeColor.byName(color, DyeColor.BLACK),
						AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()
								.isValidSpawn(ChippedBlocks::neverAllowSpawn)
								.isRedstoneConductor(ChippedBlocks::isntSolid).isSuffocating(ChippedBlocks::isntSolid)
								.isViewBlocking(ChippedBlocks::isntSolid))));
			}
		}
		
		//Register Misc
		registerBlocks("clay", 19, Material.CLAY, 0.6F, SoundType.GRAVEL);
		
		for (String wood : woodsList) {
			for (int i = 1; i <= 18; i++) {
				blocksMap.put(wood + "_planks", register(wood + "_planks_" + i, () -> new Block(AbstractBlock.Properties.of(Material.WOOD)
						.strength(2.0F, 3.0F).sound(SoundType.WOOD))));
			}
		}
		
		for (int i = 1; i <= 8; i++) {
			blocksMap.put("hay_block", register("hay_block_" + i, () -> new HayBlock(AbstractBlock.Properties.copy(Blocks.HAY_BLOCK))));
		}
		
		for (int i = 1; i <= 10; i++) {
			blocksMap.put("melon", register("melon_" + i, () -> new MelonBlock(AbstractBlock.Properties.copy(Blocks.MELON))));
		}
		
		for (int i = 1; i <= 8; i++) {
			blocksMap.put("vine", register("vine_" + i, () -> new VineBlock(AbstractBlock.Properties.copy(Blocks.VINE))));
		}
	}

	//Registries
	private static void registerBlocks(String type, int count, Material material, float destroyTime, float resistance) {
		for (int i = 1; i <= count; i++) {
			blocksMap.put(type, register(type + "_" + i, () -> new Block(AbstractBlock.Properties.of(material)
					.requiresCorrectToolForDrops().strength(destroyTime, resistance))));
		}
	}
	
	private static void registerBlocks(String type, int count, Material material, float destroyTime, float resistance, SoundType sound) {
		for (int i = 1; i <= count; i++) {
			blocksMap.put(type, register(type + "_" + i, () -> new Block(AbstractBlock.Properties.of(material)
					.requiresCorrectToolForDrops().strength(destroyTime, resistance).sound(SoundType.NETHER_BRICKS))));
		}
	}
	
	private static void registerBlocks(String[] typeList, int count, Material material, float destroyTime, float resistance) {
		for (String block : typeList) {
			registerBlocks(block, count, material, destroyTime, resistance);
		}
	}
	
	private static void registerBlocks(String[] typeList, int count, Material material, float destroyTime, float resistance, SoundType sound) {
		for (String block : typeList) {
			registerBlocks(block, count, material, destroyTime, resistance, sound);
		}
	}

	private static void registerBlocks(String[] typeList, int count, Material material, float strength) {
		registerBlocks(typeList, count, material, strength, strength);
	}
	
	private static void registerBlocks(String[] typeList, int count, Material material, float strength, SoundType sound) {
		registerBlocks(typeList, count, material, strength, strength, sound);
	}
	
	private static void registerBlocks(String type, int count, Material material, float strength) {
		registerBlocks(type, count, material, strength, strength);
	}
	
	private static void registerBlocks(String type, int count, Material material, float strength, SoundType sound) {
		registerBlocks(type, count, material, strength, strength, sound);
	}

	//Properties
	private static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
		return false;
	}

	private static Boolean neverAllowSpawn(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
		return (boolean) false;
	}

	private static <T extends Block> RegistryObject<Block> register(String name, Supplier<T> block) {
		RegistryObject<Block> toReturn = BLOCKS.register(name, block);
		ChippedItems.ITEMS.register(name,
				() -> new BlockItem(toReturn.get(), new Item.Properties().tab(Chipped.CHIPPED)));
		return toReturn;
	}

	/**
	 * Alternate registry of ChippedWorkbenches
	 * 
	 * @param <T>
	 * @param block
	 * @return
	 */
	private static <T extends Block> RegistryObject<Block> register(Supplier<ChippedWorkbench> block) {
		return register(block.get().ITEM_ID, block);
	}
}