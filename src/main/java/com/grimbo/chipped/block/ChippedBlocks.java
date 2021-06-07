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
import net.minecraft.block.PaneBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StainedGlassBlock;
import net.minecraft.block.StainedGlassPaneBlock;
import net.minecraft.block.VineBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ChippedBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Chipped.MOD_ID);

	public static Multimap<String, RegistryObject<Block>> blocksMap = ArrayListMultimap.create();
	
	//Simple Blocks which have 18 of its own variant
	public static String[] stones18 = { "stone", "granite", "diorite", "andesite", "prismarine", "dark_prismarine", "purpur_block", 
			"cobblestone", "quartz_block", "sandstone", "red_sandstone", "nether_bricks", "red_nether_bricks", "end_stone", "netherrack" };
	
	public static String[] colorsList = { "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black" };
	public static String[] woodsList = { "oak", "birch", "spruce", "jungle", "acacia", "dark_oak", "warped", "crimson" };
	
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

	public static final RegistryObject<Block> MECHANIST_WORKBENCH = register(() -> new ChippedWorkbench(6, "mechanist_workbench",
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
		for (String type : stones18) {
			registerBlocks(type, 18);
		}
		
		registerBlocks("gilded_blackstone", 26);
		registerBlocks("blackstone", 21);
		registerBlocks("basalt", 20);
		registerBlocks("obsidian", 20);
		
		for (String color : colorsList) {
			registerBlocks(color + "_terracotta", 18);
			registerBlocks(color + "_concrete", 18);
		}
		
		for (int i = 1; i <= 20; i++) {
			blocksMap.put("crying_obsidian", register("crying_obsidian_" + i, () -> new CryingObsidianBlock(AbstractBlock.Properties.copy(Blocks.CRYING_OBSIDIAN))));
		}
		for (int i = 1; i <= 20; i++) {
			blocksMap.put("glowstone", register("glowstone_" + i, () -> new Block(AbstractBlock.Properties.copy(Blocks.GLOWSTONE))));
		}
		
		//Register Wools and Carpets
		for (String color : colorsList) {
			registerBlocks(color + "_wool", 18);
			for (int i = 1; i <= 18; i++) {
				blocksMap.put(color + "_carpet", register(color + "_carpet_" + i, () -> new CarpetBlock(DyeColor.byName(color, DyeColor.BLACK), 
						AbstractBlock.Properties.of(Material.WOOL).strength(0.1F).sound(SoundType.WOOL))));
			}
		}
		
		//Register Glasses and Stained Glasses
		for (int i = 1; i <= 14; i++) {
			blocksMap.put("glass", register("glass_" + i, () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS)
					.strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(ChippedBlocks::neverAllowSpawn)
					.isRedstoneConductor(ChippedBlocks::isntSolid).isSuffocating(ChippedBlocks::isntSolid)
					.isViewBlocking(ChippedBlocks::isntSolid))));
			blocksMap.put("glass_pane", register("glass_pane_" + i, () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS)
					.strength(0.3F).sound(SoundType.GLASS).noOcclusion())));
		}
		
		for (String wood : woodsList) {
			for (int i = 1; i <= 6; i++) {
				blocksMap.put(wood + "_wood_glass", register(wood + "_wood_glass_" + i, () -> new GlassBlock(AbstractBlock.Properties.of(Material.GLASS)
						.strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(ChippedBlocks::neverAllowSpawn)
						.isRedstoneConductor(ChippedBlocks::isntSolid).isSuffocating(ChippedBlocks::isntSolid)
						.isViewBlocking(ChippedBlocks::isntSolid))));
				blocksMap.put(wood + "_wood_glass_pane", register(wood + "_wood_glass_pane_" + i, () -> new PaneBlock(AbstractBlock.Properties.of(Material.GLASS)
						.strength(0.3F).sound(SoundType.GLASS).noOcclusion())));
			}
		}

		for (String color : colorsList) {
			for (int i = 1; i <= 8; i++) {
				blocksMap.put(color + "_stained_glass", register(color + "_stained_glass_" + i, () -> new StainedGlassBlock(DyeColor.byName(color, DyeColor.BLACK),
						AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()
								.isValidSpawn(ChippedBlocks::neverAllowSpawn)
								.isRedstoneConductor(ChippedBlocks::isntSolid).isSuffocating(ChippedBlocks::isntSolid)
								.isViewBlocking(ChippedBlocks::isntSolid))));;
				blocksMap.put(color + "_stained_glass_pane", register(color + "_stained_glass_pane_" + i, () -> new StainedGlassPaneBlock(DyeColor.byName(color, DyeColor.BLACK), 
						AbstractBlock.Properties.of(Material.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion())));
			}
		}


		//Register Misc
		registerBlocks("clay", 19);
		
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
	/**
	 * Only use if a vanilla block counterpart exists and the same properties should be used.
	 * @param type
	 * @param count
	 */
	private static void registerBlocks(String type, int count) {
		Block vanillaBlock = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("minecraft:" + type));
		for (int i = 1; i <= count; i++) {
			blocksMap.put(type, register(type + "_" + i, () -> new Block(AbstractBlock.Properties.copy(vanillaBlock))));
		}
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
	 * Alternate registry of ChippedWorkbenches.
	 * @param <T>
	 * @param block
	 * @return
	 */
	private static <T extends Block> RegistryObject<Block> register(Supplier<ChippedWorkbench> block) {
		return register(block.get().ITEM_ID, block);
	}
}