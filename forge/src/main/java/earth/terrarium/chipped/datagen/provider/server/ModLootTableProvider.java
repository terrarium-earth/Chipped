package earth.terrarium.chipped.datagen.provider.server;

import com.mojang.datafixers.util.Pair;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.registry.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModLootTableProvider extends LootTableProvider {

    public ModLootTableProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> tables = new ArrayList<>();
        tables.add(Pair.of(BlockLootTables::new, LootContextParamSets.BLOCK));
        return tables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationTracker) {
    }


    public static class BlockLootTables extends BlockLoot {
        @Override
        protected void addTables() {
            createSet(ModBlocks.BENCHES);

            createSet(ModBlocks.AMETHYST_BLOCK);
            createSet(ModBlocks.ANCIENT_DEBRIS);
            createSet(ModBlocks.ANDESITE);
            createSet(ModBlocks.BASALT);
            createSet(ModBlocks.BLACKSTONE);
            createSet(ModBlocks.BLUE_ICE);
            createSet(ModBlocks.CALCITE);
            createSet(ModBlocks.COAL_BLOCK);
            createSet(ModBlocks.COBBLESTONE);
            createSet(ModBlocks.CRYING_OBSIDIAN);
            createSet(ModBlocks.DARK_PRISMARINE);
            createSet(ModBlocks.DEEPSLATE);
            createSet(ModBlocks.DIORITE);
            createSet(ModBlocks.DIRT);
            createSet(ModBlocks.DRIPSTONE_BLOCK);
            createSet(ModBlocks.END_STONE);
            createSet(ModBlocks.GILDED_BLACKSTONE);
            createSet(ModBlocks.GRANITE);
            createSet(ModBlocks.ICE);
            createSet(ModBlocks.LAPIS_BLOCK);
            createSet(ModBlocks.LODESTONE);
            createSet(ModBlocks.MAGMA_BLOCK);
            createSet(ModBlocks.MOSSY_COBBLESTONE);
            createSet(ModBlocks.MOSSY_STONE_BRICKS);
            createSet(ModBlocks.NETHER_BRICKS);
            createSet(ModBlocks.NETHERRACK);
            createSet(ModBlocks.OBSIDIAN);
            createSet(ModBlocks.PACKED_ICE);
            createSet(ModBlocks.PRISMARINE);
            createSet(ModBlocks.PURPUR_BLOCK);
            createSet(ModBlocks.QUARTZ_BLOCK);
            createSet(ModBlocks.RAW_COPPER_BLOCK);
            createSet(ModBlocks.RAW_GOLD_BLOCK);
            createSet(ModBlocks.RAW_IRON_BLOCK);
            createSet(ModBlocks.RED_NETHER_BRICKS);
            createSet(ModBlocks.RED_SANDSTONE);
            createSet(ModBlocks.REDSTONE_BLOCK);
            createSet(ModBlocks.SANDSTONE);
            createSet(ModBlocks.SMOOTH_STONE);
            createSet(ModBlocks.SNOW_BLOCK);
            createSet(ModBlocks.TUFF);

            createSet(ModBlocks.CLAY);
            createSet(ModBlocks.TERRACOTTA);
            createSet(ModBlocks.BLACK_TERRACOTTA);
            createSet(ModBlocks.BLUE_TERRACOTTA);
            createSet(ModBlocks.BROWN_TERRACOTTA);
            createSet(ModBlocks.CYAN_TERRACOTTA);
            createSet(ModBlocks.GRAY_TERRACOTTA);
            createSet(ModBlocks.GREEN_TERRACOTTA);
            createSet(ModBlocks.LIGHT_BLUE_TERRACOTTA);
            createSet(ModBlocks.LIGHT_GRAY_TERRACOTTA);
            createSet(ModBlocks.LIME_TERRACOTTA);
            createSet(ModBlocks.MAGENTA_TERRACOTTA);
            createSet(ModBlocks.ORANGE_TERRACOTTA);
            createSet(ModBlocks.PINK_TERRACOTTA);
            createSet(ModBlocks.PURPLE_TERRACOTTA);
            createSet(ModBlocks.RED_TERRACOTTA);
            createSet(ModBlocks.WHITE_TERRACOTTA);
            createSet(ModBlocks.YELLOW_TERRACOTTA);

            createSet(ModBlocks.BLACK_GLAZED_TERRACOTTA);
            createSet(ModBlocks.BLUE_GLAZED_TERRACOTTA);
            createSet(ModBlocks.BROWN_GLAZED_TERRACOTTA);
            createSet(ModBlocks.CYAN_GLAZED_TERRACOTTA);
            createSet(ModBlocks.GRAY_GLAZED_TERRACOTTA);
            createSet(ModBlocks.GREEN_GLAZED_TERRACOTTA);
            createSet(ModBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
            createSet(ModBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
            createSet(ModBlocks.LIME_GLAZED_TERRACOTTA);
            createSet(ModBlocks.MAGENTA_GLAZED_TERRACOTTA);
            createSet(ModBlocks.ORANGE_GLAZED_TERRACOTTA);
            createSet(ModBlocks.PINK_GLAZED_TERRACOTTA);
            createSet(ModBlocks.PURPLE_GLAZED_TERRACOTTA);
            createSet(ModBlocks.RED_GLAZED_TERRACOTTA);
            createSet(ModBlocks.WHITE_GLAZED_TERRACOTTA);
            createSet(ModBlocks.YELLOW_GLAZED_TERRACOTTA);

            createSet(ModBlocks.BLACK_CONCRETE);
            createSet(ModBlocks.BLUE_CONCRETE);
            createSet(ModBlocks.BROWN_CONCRETE);
            createSet(ModBlocks.CYAN_CONCRETE);
            createSet(ModBlocks.GRAY_CONCRETE);
            createSet(ModBlocks.GREEN_CONCRETE);
            createSet(ModBlocks.LIGHT_BLUE_CONCRETE);
            createSet(ModBlocks.LIGHT_GRAY_CONCRETE);
            createSet(ModBlocks.LIME_CONCRETE);
            createSet(ModBlocks.MAGENTA_CONCRETE);
            createSet(ModBlocks.ORANGE_CONCRETE);
            createSet(ModBlocks.PINK_CONCRETE);
            createSet(ModBlocks.PURPLE_CONCRETE);
            createSet(ModBlocks.RED_CONCRETE);
            createSet(ModBlocks.WHITE_CONCRETE);
            createSet(ModBlocks.YELLOW_CONCRETE);

            createSet(ModBlocks.BLACK_WOOL);
            createSet(ModBlocks.BLUE_WOOL);
            createSet(ModBlocks.BROWN_WOOL);
            createSet(ModBlocks.CYAN_WOOL);
            createSet(ModBlocks.GRAY_WOOL);
            createSet(ModBlocks.GREEN_WOOL);
            createSet(ModBlocks.LIGHT_BLUE_WOOL);
            createSet(ModBlocks.LIGHT_GRAY_WOOL);
            createSet(ModBlocks.LIME_WOOL);
            createSet(ModBlocks.MAGENTA_WOOL);
            createSet(ModBlocks.ORANGE_WOOL);
            createSet(ModBlocks.PINK_WOOL);
            createSet(ModBlocks.PURPLE_WOOL);
            createSet(ModBlocks.RED_WOOL);
            createSet(ModBlocks.WHITE_WOOL);
            createSet(ModBlocks.YELLOW_WOOL);

            createSet(ModBlocks.BLACK_CARPET);
            createSet(ModBlocks.BLUE_CARPET);
            createSet(ModBlocks.BROWN_CARPET);
            createSet(ModBlocks.CYAN_CARPET);
            createSet(ModBlocks.GRAY_CARPET);
            createSet(ModBlocks.GREEN_CARPET);
            createSet(ModBlocks.LIGHT_BLUE_CARPET);
            createSet(ModBlocks.LIGHT_GRAY_CARPET);
            createSet(ModBlocks.LIME_CARPET);
            createSet(ModBlocks.MAGENTA_CARPET);
            createSet(ModBlocks.ORANGE_CARPET);
            createSet(ModBlocks.PINK_CARPET);
            createSet(ModBlocks.PURPLE_CARPET);
            createSet(ModBlocks.RED_CARPET);
            createSet(ModBlocks.WHITE_CARPET);
            createSet(ModBlocks.YELLOW_CARPET);

            createSet(ModBlocks.ACACIA_PLANKS);
            createSet(ModBlocks.BIRCH_PLANKS);
            createSet(ModBlocks.DARK_OAK_PLANKS);
            createSet(ModBlocks.JUNGLE_PLANKS);
            createSet(ModBlocks.MANGROVE_PLANKS);
            createSet(ModBlocks.OAK_PLANKS);
            createSet(ModBlocks.SPRUCE_PLANKS);
            createSet(ModBlocks.CRIMSON_PLANKS);
            createSet(ModBlocks.WARPED_PLANKS);

            createSet(ModBlocks.BRICKS);
            createSet(ModBlocks.MUD);
            createSet(ModBlocks.PACKED_MUD);
            createSet(ModBlocks.MUD_BRICKS);

            createSet(ModBlocks.ACACIA_LOG);
            createSet(ModBlocks.BIRCH_LOG);
            createSet(ModBlocks.DARK_OAK_LOG);
            createSet(ModBlocks.JUNGLE_LOG);
            createSet(ModBlocks.MANGROVE_LOG);
            createSet(ModBlocks.OAK_LOG);
            createSet(ModBlocks.SPRUCE_LOG);
            createSet(ModBlocks.CRIMSON_STEM);
            createSet(ModBlocks.WARPED_STEM);

            createSet(ModBlocks.GLASS);
            createSet(ModBlocks.GLASS_PANE);
            createSet(ModBlocks.BLACK_STAINED_GLASS);
            createSet(ModBlocks.BLACK_STAINED_GLASS_PANE);
            createSet(ModBlocks.BLUE_STAINED_GLASS);
            createSet(ModBlocks.BLUE_STAINED_GLASS_PANE);
            createSet(ModBlocks.BROWN_STAINED_GLASS);
            createSet(ModBlocks.BROWN_STAINED_GLASS_PANE);
            createSet(ModBlocks.CYAN_STAINED_GLASS);
            createSet(ModBlocks.CYAN_STAINED_GLASS_PANE);
            createSet(ModBlocks.GRAY_STAINED_GLASS);
            createSet(ModBlocks.GRAY_STAINED_GLASS_PANE);
            createSet(ModBlocks.GREEN_STAINED_GLASS);
            createSet(ModBlocks.GREEN_STAINED_GLASS_PANE);
            createSet(ModBlocks.LIGHT_BLUE_STAINED_GLASS);
            createSet(ModBlocks.LIGHT_BLUE_STAINED_GLASS_PANE);
            createSet(ModBlocks.LIGHT_GRAY_STAINED_GLASS);
            createSet(ModBlocks.LIGHT_GRAY_STAINED_GLASS_PANE);
            createSet(ModBlocks.LIME_STAINED_GLASS);
            createSet(ModBlocks.LIME_STAINED_GLASS_PANE);
            createSet(ModBlocks.MAGENTA_STAINED_GLASS);
            createSet(ModBlocks.MAGENTA_STAINED_GLASS_PANE);
            createSet(ModBlocks.ORANGE_STAINED_GLASS);
            createSet(ModBlocks.ORANGE_STAINED_GLASS_PANE);
            createSet(ModBlocks.PINK_STAINED_GLASS);
            createSet(ModBlocks.PINK_STAINED_GLASS_PANE);
            createSet(ModBlocks.PURPLE_STAINED_GLASS);
            createSet(ModBlocks.PURPLE_STAINED_GLASS_PANE);
            createSet(ModBlocks.RED_STAINED_GLASS);
            createSet(ModBlocks.RED_STAINED_GLASS_PANE);
            createSet(ModBlocks.WHITE_STAINED_GLASS);
            createSet(ModBlocks.WHITE_STAINED_GLASS_PANE);
            createSet(ModBlocks.YELLOW_STAINED_GLASS);
            createSet(ModBlocks.YELLOW_STAINED_GLASS_PANE);

            createSet(ModBlocks.ACACIA_LEAVES);
            createSet(ModBlocks.BIRCH_LEAVES);
            createSet(ModBlocks.DARK_OAK_LEAVES);
            createSet(ModBlocks.JUNGLE_LEAVES);
            createSet(ModBlocks.MANGROVE_ROOTS);
            createSet(ModBlocks.OAK_LEAVES);
            createSet(ModBlocks.SPRUCE_LEAVES);

            createSet(ModBlocks.OCHRE_FROGLIGHT);
            createSet(ModBlocks.PEARLESCENT_FROGLIGHT);
            createSet(ModBlocks.VERDANT_FROGLIGHT);

            createSet(ModBlocks.DIAMOND_BLOCK);
            createSet(ModBlocks.EMERALD_BLOCK);
            createSet(ModBlocks.GOLD_BLOCK);
            createSet(ModBlocks.IRON_BLOCK);
            createSet(ModBlocks.NETHERITE_BLOCK);

            createSet(ModBlocks.BARREL);
            createSet(ModBlocks.BONE_BLOCK);
            createSet(ModBlocks.BOOKSHELF);
            createSet(ModBlocks.BROWN_MUSHROOM_BLOCK);
            createSet(ModBlocks.RED_MUSHROOM_BLOCK);
            createSet(ModBlocks.BROWN_MUSHROOM);
            createSet(ModBlocks.RED_MUSHROOM);
            createSet(ModBlocks.COBWEB);
            createSet(ModBlocks.SPONGE);
            createSet(ModBlocks.MUSHROOM_STEM);
            createSet(ModBlocks.GLOWSTONE);
            createSet(ModBlocks.GRAVEL);
            createSet(ModBlocks.HAY_BLOCK);
            createSet(ModBlocks.IRON_BARS);
            createSet(ModBlocks.MOSS_BLOCK);
            createSet(ModBlocks.LADDER);
            createSet(ModBlocks.MELON);
            createSet(ModBlocks.SHROOMLIGHT);
            createSet(ModBlocks.SEA_LANTERN);
            createSet(ModBlocks.SAND);
            createSet(ModBlocks.SOUL_SAND);
            createSet(ModBlocks.REDSTONE_LAMP);

            createSet(ModBlocks.WAXED_COPPER_BLOCK);
            createSet(ModBlocks.WAXED_EXPOSED_COPPER);
            createSet(ModBlocks.WAXED_WEATHERED_COPPER);
            createSet(ModBlocks.WAXED_OXIDIZED_COPPER);

            createSet(ModBlocks.STRIPPED_ACACIA_LOG);
            createSet(ModBlocks.STRIPPED_BIRCH_LOG);
            createSet(ModBlocks.STRIPPED_DARK_OAK_LOG);
            createSet(ModBlocks.STRIPPED_JUNGLE_LOG);
            createSet(ModBlocks.STRIPPED_MANGROVE_LOG);
            createSet(ModBlocks.STRIPPED_OAK_LOG);
            createSet(ModBlocks.STRIPPED_SPRUCE_LOG);
            createSet(ModBlocks.STRIPPED_WARPED_STEM);
            createSet(ModBlocks.STRIPPED_CRIMSON_STEM);

            createDoorSet(ModBlocks.ACACIA_DOOR);
            createDoorSet(ModBlocks.BIRCH_DOOR);
            createDoorSet(ModBlocks.DARK_OAK_DOOR);
            createDoorSet(ModBlocks.JUNGLE_DOOR);
            createDoorSet(ModBlocks.MANGROVE_DOOR);
            createDoorSet(ModBlocks.OAK_DOOR);
            createDoorSet(ModBlocks.SPRUCE_DOOR);
            createDoorSet(ModBlocks.CRIMSON_DOOR);
            createDoorSet(ModBlocks.WARPED_DOOR);

            createSet(ModBlocks.ACACIA_TRAPDOOR);
            createSet(ModBlocks.BIRCH_TRAPDOOR);
            createSet(ModBlocks.DARK_OAK_TRAPDOOR);
            createSet(ModBlocks.JUNGLE_TRAPDOOR);
            createSet(ModBlocks.MANGROVE_TRAPDOOR);
            createSet(ModBlocks.OAK_TRAPDOOR);
            createSet(ModBlocks.SPRUCE_TRAPDOOR);
            createSet(ModBlocks.CRIMSON_TRAPDOOR);
            createSet(ModBlocks.WARPED_TRAPDOOR);

            createSet(ModBlocks.CRIMSON_ROOTS);
            createSet(ModBlocks.WARPED_ROOTS);
            createSet(ModBlocks.DRIED_KELP_BLOCK);
            createSet(ModBlocks.LANTERN);
            createSet(ModBlocks.SOUL_LANTERN);
            createSet(ModBlocks.SPECIAL_LANTERN);
            createSet(ModBlocks.SPECIAL_SOUL_LANTERN);
            createSet(ModBlocks.LILY_PAD);
            createSet(ModBlocks.NETHER_SPROUTS);
            createSet(ModBlocks.NETHER_WART_BLOCK);
            createSet(ModBlocks.PUMPKIN);
            createSet(ModBlocks.CARVED_PUMPKIN);
            createSet(ModBlocks.JACK_O_LANTERN);
            createSet(ModBlocks.VINE);
            createSet(ModBlocks.WARPED_WART_BLOCK);
            createSet(ModBlocks.POINTED_DRIPSTONE);
            createSet(ModBlocks.CRIMSON_FUNGUS);
            createSet(ModBlocks.WARPED_FUNGUS);
            createTorchSet(ModBlocks.TORCH);
            createTorchSet(ModBlocks.REDSTONE_TORCH);
        }

        private void createSet(ResourcefulRegistry<Block> registry) {
            registry.stream().map(RegistryEntry::get).forEach(this::dropSelf);
        }

        private void createTorchSet(Pair<ResourcefulRegistry<Block>, ResourcefulRegistry<Block>> registry) {
            createSet(registry.getFirst());
            registry.getSecond().stream().forEach(b -> this.dropOther(b.get(), Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Chipped.MOD_ID, b.getId().getPath().replace("_wall", ""))))));
        }

        private void createDoorSet(ResourcefulRegistry<Block> registry) {
            registry.stream().map(RegistryEntry::get).forEach(d -> this.add(d, createDoorTable(d)));
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ModBlocks.BLOCKS.stream().map(RegistryEntry::get).toList();
        }
    }
}