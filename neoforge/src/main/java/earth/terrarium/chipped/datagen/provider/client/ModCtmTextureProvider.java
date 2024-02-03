package earth.terrarium.chipped.datagen.provider.client;

import com.google.common.hash.HashCode;
import com.mojang.blaze3d.platform.NativeImage;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;
import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ModCtmTextureProvider implements DataProvider {

    protected static final ExistingFileHelper.ResourceType TEXTURE = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".png", "textures");

    private final PackOutput output;
    private final ExistingFileHelper files;
    private final List<ChippedPaletteRegistry<Block>> registries = new ArrayList<>();
    private final Map<ResourceLocation, ResourceLocation> commonTextures = new HashMap<>();

    public ModCtmTextureProvider(PackOutput output, ExistingFileHelper files) {
        this.output = output;
        this.files = files;
        addRegistries();
    }

    public void addRegistries() {
        registries.add(ModBlocks.AMETHYST_BLOCK);
        registries.add(ModBlocks.COAL_BLOCK);
        registries.add(ModBlocks.CRYING_OBSIDIAN);
        registries.add(ModBlocks.LAPIS_BLOCK);
        registries.add(ModBlocks.BLUE_ICE);
        registries.add(ModBlocks.DIRT);
        registries.add(ModBlocks.ICE);
        registries.add(ModBlocks.PACKED_ICE);
        registries.add(ModBlocks.SNOW_BLOCK);
        registries.add(ModBlocks.ANCIENT_DEBRIS);
        registries.add(ModBlocks.ANDESITE);
        registries.add(ModBlocks.BASALT);
        registries.add(ModBlocks.BLACKSTONE);
        registries.add(ModBlocks.CALCITE);
        registries.add(ModBlocks.COBBLESTONE);
        registries.add(ModBlocks.DARK_PRISMARINE);
        registries.add(ModBlocks.DEEPSLATE);
        registries.add(ModBlocks.DIORITE);
        registries.add(ModBlocks.DRIPSTONE_BLOCK);
        registries.add(ModBlocks.END_STONE);
        registries.add(ModBlocks.GILDED_BLACKSTONE);
        registries.add(ModBlocks.GRANITE);
        registries.add(ModBlocks.MAGMA_BLOCK);
        registries.add(ModBlocks.MOSSY_COBBLESTONE);
        registries.add(ModBlocks.MOSSY_STONE_BRICKS);
        registries.add(ModBlocks.NETHER_BRICKS);
        registries.add(ModBlocks.NETHERRACK);
        registries.add(ModBlocks.OBSIDIAN);
        registries.add(ModBlocks.PRISMARINE);
        registries.add(ModBlocks.PURPUR_BLOCK);
        registries.add(ModBlocks.QUARTZ_BLOCK);
        registries.add(ModBlocks.RAW_COPPER_BLOCK);
        registries.add(ModBlocks.RAW_GOLD_BLOCK);
        registries.add(ModBlocks.RAW_IRON_BLOCK);
        registries.add(ModBlocks.RED_NETHER_BRICKS);
        registries.add(ModBlocks.RED_SANDSTONE);
        registries.add(ModBlocks.SANDSTONE);
        registries.add(ModBlocks.STONE);
        registries.add(ModBlocks.SMOOTH_STONE);
        registries.add(ModBlocks.TUFF);
        registries.add(ModBlocks.LODESTONE);
        registries.add(ModBlocks.REDSTONE_BLOCK);
        registries.add(ModBlocks.MUD);
        registries.add(ModBlocks.MUD_BRICKS);
        registries.add(ModBlocks.PACKED_MUD);
        registries.add(ModBlocks.CLAY);
        registries.add(ModBlocks.BRICKS);
        registries.add(ModBlocks.BORDERLESS_BRICKS);
        registries.add(ModBlocks.WHITE_WOOL);
        registries.add(ModBlocks.BLACK_WOOL);
        registries.add(ModBlocks.BLUE_WOOL);
        registries.add(ModBlocks.CYAN_WOOL);
        registries.add(ModBlocks.GRAY_WOOL);
        registries.add(ModBlocks.GREEN_WOOL);
        registries.add(ModBlocks.BROWN_WOOL);
        registries.add(ModBlocks.BLACK_WOOL);
        registries.add(ModBlocks.LIGHT_BLUE_WOOL);
        registries.add(ModBlocks.LIGHT_GRAY_WOOL);
        registries.add(ModBlocks.LIME_WOOL);
        registries.add(ModBlocks.MAGENTA_WOOL);
        registries.add(ModBlocks.ORANGE_WOOL);
        registries.add(ModBlocks.PINK_WOOL);
        registries.add(ModBlocks.PURPLE_WOOL);
        registries.add(ModBlocks.RED_WOOL);
        registries.add(ModBlocks.YELLOW_WOOL);

        registries.add(ModBlocks.ACACIA_PLANKS);
        registries.add(ModBlocks.BIRCH_PLANKS);
        registries.add(ModBlocks.DARK_OAK_PLANKS);
        registries.add(ModBlocks.JUNGLE_PLANKS);
        registries.add(ModBlocks.MANGROVE_PLANKS);
        registries.add(ModBlocks.OAK_PLANKS);
        registries.add(ModBlocks.SPRUCE_PLANKS);
        registries.add(ModBlocks.CRIMSON_PLANKS);
        registries.add(ModBlocks.WARPED_PLANKS);
        registries.add(ModBlocks.CHERRY_PLANKS);
        registries.add(ModBlocks.BAMBOO_PLANKS);

        registries.add(ModBlocks.TERRACOTTA);
        registries.add(ModBlocks.WHITE_TERRACOTTA);
        registries.add(ModBlocks.BLACK_TERRACOTTA);
        registries.add(ModBlocks.BLUE_TERRACOTTA);
        registries.add(ModBlocks.CYAN_TERRACOTTA);
        registries.add(ModBlocks.GRAY_TERRACOTTA);
        registries.add(ModBlocks.GREEN_TERRACOTTA);
        registries.add(ModBlocks.BROWN_TERRACOTTA);
        registries.add(ModBlocks.LIGHT_BLUE_TERRACOTTA);
        registries.add(ModBlocks.LIGHT_GRAY_TERRACOTTA);
        registries.add(ModBlocks.LIME_TERRACOTTA);
        registries.add(ModBlocks.MAGENTA_TERRACOTTA);
        registries.add(ModBlocks.ORANGE_TERRACOTTA);
        registries.add(ModBlocks.PINK_TERRACOTTA);
        registries.add(ModBlocks.PURPLE_TERRACOTTA);
        registries.add(ModBlocks.RED_TERRACOTTA);
        registries.add(ModBlocks.YELLOW_TERRACOTTA);

        registries.add(ModBlocks.WHITE_CONCRETE);
        registries.add(ModBlocks.BLACK_CONCRETE);
        registries.add(ModBlocks.BLUE_CONCRETE);
        registries.add(ModBlocks.CYAN_CONCRETE);
        registries.add(ModBlocks.GRAY_CONCRETE);
        registries.add(ModBlocks.GREEN_CONCRETE);
        registries.add(ModBlocks.BROWN_CONCRETE);
        registries.add(ModBlocks.LIGHT_BLUE_CONCRETE);
        registries.add(ModBlocks.LIGHT_GRAY_CONCRETE);
        registries.add(ModBlocks.LIME_CONCRETE);
        registries.add(ModBlocks.MAGENTA_CONCRETE);
        registries.add(ModBlocks.ORANGE_CONCRETE);
        registries.add(ModBlocks.PINK_CONCRETE);
        registries.add(ModBlocks.PURPLE_CONCRETE);
        registries.add(ModBlocks.RED_CONCRETE);
        registries.add(ModBlocks.YELLOW_CONCRETE);

        registries.add(ModBlocks.GLASS);
        registries.add(ModBlocks.WHITE_STAINED_GLASS);
        registries.add(ModBlocks.BLACK_STAINED_GLASS);
        registries.add(ModBlocks.BLUE_STAINED_GLASS);
        registries.add(ModBlocks.CYAN_STAINED_GLASS);
        registries.add(ModBlocks.GRAY_STAINED_GLASS);
        registries.add(ModBlocks.GREEN_STAINED_GLASS);
        registries.add(ModBlocks.BROWN_STAINED_GLASS);
        registries.add(ModBlocks.LIGHT_BLUE_STAINED_GLASS);
        registries.add(ModBlocks.LIGHT_GRAY_STAINED_GLASS);
        registries.add(ModBlocks.LIME_STAINED_GLASS);
        registries.add(ModBlocks.MAGENTA_STAINED_GLASS);
        registries.add(ModBlocks.ORANGE_STAINED_GLASS);
        registries.add(ModBlocks.PINK_STAINED_GLASS);
        registries.add(ModBlocks.PURPLE_STAINED_GLASS);
        registries.add(ModBlocks.RED_STAINED_GLASS);
        registries.add(ModBlocks.YELLOW_STAINED_GLASS);
    }

    @Override
    public @NotNull CompletableFuture<?> run(@NotNull CachedOutput output) {
        List<CompletableFuture<Map<ResourceLocation, ResourceLocation>>> futures = new ArrayList<>();

        for (ChippedPaletteRegistry<Block> registry : registries) {
            futures.add(CompletableFuture.supplyAsync(() -> {
                final Map<ImageData, List<ResourceLocation>> images = new LinkedHashMap<>();
                final String id = registry.getCustomBase().orElse(BuiltInRegistries.BLOCK.getKey(registry.getBase()).getPath());
                for (var ctm : registry.getPalette().getSpecial()) {
                    final String suffix = ctm.getFirst().suffix().length() > 0 ? "_" + ctm.getFirst().suffix() : "";
                    final ResourceLocation location = new ResourceLocation(Chipped.MOD_ID, "textures/block/" + id + "/ctm/" + ctm.getSecond().replace("%", id) + suffix);
                    try {
                        Resource resource = files.getResource(new ResourceLocation(location.getNamespace(), location.getPath() + ".png"), PackType.CLIENT_RESOURCES);

                        split(new ResourceLocation(location.getNamespace(), "block/" + id + "/ctm/"), ctm.getSecond().replace("%", id) + suffix, resource, output)
                            .forEach((key, value) ->
                                images.computeIfAbsent(key, data -> new ArrayList<>()).addAll(value)
                            );
                    } catch (NoSuchElementException e) {
                        System.out.println("Missing CTM texture: " + location);
                        throw e;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    Map<ResourceLocation, ResourceLocation> commons = new LinkedHashMap<>();
                    int commonIndex = 0;
                    for (var entry : images.entrySet()) {
                        if (entry.getValue().isEmpty()) continue;
                        if (entry.getValue().size() == 1) {
                            Path path = this.output.getOutputFolder(PackOutput.Target.RESOURCE_PACK)
                                .resolve(entry.getValue().get(0).getNamespace())
                                .resolve("textures")
                                .resolve(entry.getValue().get(0).getPath());
                            output.writeIfNeeded(path, entry.getKey().bytes(), entry.getKey().code());
                            files.trackGenerated(entry.getValue().get(0), TEXTURE);
                        } else {
                            ResourceLocation newPath = entry.getKey().loc().withSuffix("common_textures/" + commonIndex);
                            Path path = this.output.getOutputFolder(PackOutput.Target.RESOURCE_PACK)
                                .resolve(newPath.getNamespace())
                                .resolve("textures")
                                .resolve(newPath.getPath() + ".png");
                            output.writeIfNeeded(path, entry.getKey().bytes(), entry.getKey().code());
                            files.trackGenerated(newPath, TEXTURE);
                            for (ResourceLocation resourceLocation : entry.getValue()) {
                                ResourceLocation key = new ResourceLocation(resourceLocation.getNamespace(), resourceLocation.getPath().substring(0, resourceLocation.getPath().length() - 4));
                                commons.put(key, newPath);
                            }
                            commonIndex++;
                        }
                    }
                    return commons;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }, Util.backgroundExecutor()));
        }
        return allOf(futures).thenAccept(commons -> {
            for (Map<ResourceLocation, ResourceLocation> common : commons) {
                commonTextures.putAll(common);
            }
        });
    }

    public <T> CompletableFuture<List<T>> allOf(List<CompletableFuture<T>> futuresList) {
        CompletableFuture<Void> allFuturesResult =
            CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[0]));
        return allFuturesResult.thenApply(v ->
            futuresList.stream().
                map(CompletableFuture::join).
                collect(Collectors.<T>toList())
        );
    }

    @Override
    public @NotNull String getName() {
        return "Chipped CTM Texture Provider";
    }

    private static Map<ImageData, List<ResourceLocation>> split(ResourceLocation path, String suffix, Resource resource, CachedOutput output) throws IOException {
        Map<ImageData, List<ResourceLocation>> paths = new LinkedHashMap<>();
        var read = NativeImage.read(resource.open());
        var width = read.getWidth();
        var height = read.getHeight();
        if (width % 16 != 0 || height % 16 != 0) {
            throw new IllegalArgumentException("Image must be a multiple of 16");
        }
        var index = 0;
        var x = 0;
        var y = 0;
        while (y < height) {
            while (x < width) {
                final var image = new NativeImage(NativeImage.Format.RGBA, 16, 16, false);
                for (int i = 0; i < 16; i++) {
                    for (int j = 0; j < 16; j++) {
                        image.setPixelRGBA(i, j, read.getPixelRGBA(x + i, y + j));
                    }
                }

                byte[] bytes = image.asByteArray();
                paths.computeIfAbsent(new ImageData(bytes, HashCode.fromBytes(bytes), path), ignored -> new ArrayList<>())
                    .add(path.withSuffix(suffix + "/" + index + ".png"));
                image.close();
                x += 16;
                index++;
            }
            x = 0;
            y += 16;
        }
        read.close();
        return paths;
    }

    private record ImageData(byte[] bytes, HashCode code, ResourceLocation loc) {

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj instanceof ImageData data) {
                return data.code().equals(code);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return code.hashCode();
        }
    }

    public String getTexture(String texture) {
        ResourceLocation location = new ResourceLocation(texture);
        return this.commonTextures.getOrDefault(location, location).toString();
    }
}
