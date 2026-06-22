package earth.terrarium.chipped;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistryChild;
import com.teamresourceful.resourcefullib.common.registry.builtin.ResourcefulBlockRegistry;
import com.teamresourceful.resourcefullib.common.registry.builtin.ResourcefulItemRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class Chipped {
    public static final String MOD_ID = "chipped";
    public static final String BLOCK_FILE = "/blocks.json";

    public static final ResourcefulRegistry<Block> BLOCKS = new ResourcefulBlockRegistry(MOD_ID);

    public static final ResourcefulRegistry<Block> NORMAL_BLOCKS = new ResourcefulRegistryChild<>(BLOCKS);
    public static final ResourcefulRegistry<Block> CONNECTED_BLOCKS = new ResourcefulRegistryChild<>(BLOCKS);
    public static final ResourcefulRegistry<Block> PILLAR_BLOCKS = new ResourcefulRegistryChild<>(BLOCKS);

    public static final ResourcefulItemRegistry ITEMS = new ResourcefulItemRegistry(MOD_ID);

    private static final Codec<Map<String, ChippedVariantSet>> CODEC = Codec.unboundedMap(Codec.STRING, ChippedVariantSet.CODEC);

    public static void init() {
        initRegistries();
        BLOCKS.init();
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    private static Map<String, ChippedVariantSet> read() {
        try (InputStream in = Chipped.class.getResourceAsStream(BLOCK_FILE)) {
            if (in == null) {
                throw new IllegalStateException("Resource not found: " + BLOCK_FILE);
            }
            // extract json element object from input stream
            InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
            var result = CODEC.parse(JsonOps.INSTANCE, JsonParser.parseReader(reader).getAsJsonObject());
            if (result.result().isEmpty()) {
                throw new IllegalStateException("Failed to parse " + BLOCK_FILE + ": " + result.error().orElseThrow());
            }
            return result.result().get();
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read " + BLOCK_FILE, e);
        }
    }

    public static void initRegistries() {
        Map<String, ChippedVariantSet> data = read();

        data.forEach((type, values) -> {
            Identifier baseId = Identifier.parse(type);
            Block block = BuiltInRegistries.BLOCK.getValue(baseId);
            values.variants().forEach((name, variant) -> {
                var finalName = baseId.getPath() + "_" + name;
                variant.factory.accept(BlockBehaviour.Properties.ofFullCopy(block), finalName);
            });
        });
    }
}
