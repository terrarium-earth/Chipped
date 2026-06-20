package earth.terrarium.chipped;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamresourceful.resourcefullib.common.registry.builtin.ResourcefulBlockRegistry;
import com.teamresourceful.resourcefullib.common.registry.builtin.ResourcefulItemRegistry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;


public class Chipped {
    public static final String MOD_ID = "chipped";
    public static final String BLOCK_FILE = "/blocks.json";

    public static final ResourcefulBlockRegistry BLOCKS = new ResourcefulBlockRegistry(MOD_ID);
    public static final ResourcefulItemRegistry ITEMS = new ResourcefulItemRegistry(MOD_ID);

    private static final Gson GSON = new Gson();

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
            for (String name : values.variants()) {
                var finalName = baseId.getPath() + "_" + name;
                BLOCKS.register(finalName, () -> values.type().factory.apply(BlockBehaviour.Properties.ofFullCopy(block).setId(ResourceKey.create(Registries.BLOCK, id(finalName)))));
            }
        });
    }
}
