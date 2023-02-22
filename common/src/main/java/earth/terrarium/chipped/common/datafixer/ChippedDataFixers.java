package earth.terrarium.chipped.common.datafixer;

import com.mojang.datafixers.DataFix;
import com.mojang.datafixers.schemas.Schema;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.util.PlatformUtils;
import net.minecraft.util.datafix.fixes.BlockRenameFix;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class ChippedDataFixers {

    private static final List<String> FIXER_IDS = List.of(
            "amethyst_block",
            "ancient_debris",
            "andesite",
            "basalt",
            "blackstone",
            "blue_ice",
            "bricks",
            "calcite",
            "clay",
            "coal_block",
            "cobblestone",
            "crying_obsidian",
            "dark_prismarine",
            "diorite",
            "dirt",
            "dripstone_block",
            "end_stone",
            "gilded_blackstone",
            "granite",
            "ice",
            "lapis_block",
            "lodestone",
            "magma_block",
            "misc",
            "mossy_cobblestone",
            "mossy_stone_bricks",
            "nether_bricks",
            "netherrack",
            "obsidian",
            "packed_ice",
            "prismarine",
            "purpur_block",
            "quartz_block",
            "raw_copper_block",
            "raw_gold_block",
            "raw_iron_block",
            "red_nether_bricks",
            "red_sandstone",
            "redstone_block",
            "sandstone",
            "smooth_stone",
            "snow_block",
            "stone",
            "tuff",
            "misc",
            "black_concrete",
            "blue_concrete",
            "brown_concrete",
            "cyan_concrete",
            "gray_concrete",
            "green_concrete",
            "light_blue_concrete",
            "light_gray_concrete",
            "lime_concrete",
            "magenta_concrete",
            "orange_concrete",
            "pink_concrete",
            "purple_concrete",
            "red_concrete",
            "white_concrete",
            "yellow_concrete",
            "acacia_planks",
            "birch_planks",
            "dark_oak_planks",
            "jungle_planks",
            "oak_planks",
            "spruce_planks",
            "crimson_planks",
            "warped_planks",
            "iron_block",
            "gold_block",
            "diamond_block",
            "emerald_block",
            "netherite_block",
            "glowstone",
            "gravel",
            "bookshelf",
            "iron_bars",
            "glass",
            "glass_pane"
            );

    public static void addDataFixers(Schema schema, Consumer<DataFix> fixer) {
        for (CsvMapper mapper : loadJarResources("/data/chipped/datafixers", FIXER_IDS)) {
            fixer.accept(BlockRenameFix.create(schema, mapper.displayName(), mapper));
        }
    }

    public static List<CsvMapper> loadJarResources(@NotNull String devPath, List<String> resources) {
        final List<CsvMapper> fixers = new ArrayList<>();
        for (String resource : resources) {
            try (final var stream = ChippedDataFixers.class.getResourceAsStream(devPath + "/" + resource + ".csv")) {
                if (stream == null) {
                    Chipped.LOGGER.error("Failed to load data fixer csv: " + resource + ", skipping... expected things to break. Input stream was null.");
                    continue;
                }
                final String data = IOUtils.toString(stream, StandardCharsets.UTF_8);
                fixers.add(new CsvMapper(data, resource));
                if (PlatformUtils.isDevelopmentEnvironment()) {
                    Chipped.LOGGER.info("Loaded data fixer csv: " + resource);
                }
            } catch (Exception e) {
                Chipped.LOGGER.warn("Failed to load data fixer csv: " + resource + ", skipping... expected things to break.");
                e.printStackTrace();
            }
        }
        return fixers;
    }
}
