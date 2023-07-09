package earth.terrarium.chipped.datagen.provider.client;

import com.google.gson.JsonObject;
import earth.terrarium.athena.impl.client.DefaultModels;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;
import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModCtmModelProvider implements DataProvider {

    private final PackOutput output;
    private final ModBlockStateProvider files;
    private final ModCtmTextureProvider textures;
    private final List<ChippedPaletteRegistry<Block>> registries = new ArrayList<>();

    public ModCtmModelProvider(PackOutput output, ModBlockStateProvider files, ModCtmTextureProvider textures) {
        this.output = output;
        this.files = files;
        this.textures = textures;
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
        registries.add(ModBlocks.WHITE_WOOL);
        registries.add(ModBlocks.BLACK_WOOL);
        registries.add(ModBlocks.BLUE_WOOL);
        registries.add(ModBlocks.CYAN_WOOL);
        registries.add(ModBlocks.GRAY_WOOL);
        registries.add(ModBlocks.GREEN_WOOL);
        registries.add(ModBlocks.BROWN_WOOL);
        registries.add(ModBlocks.LIGHT_BLUE_WOOL);
        registries.add(ModBlocks.LIGHT_GRAY_WOOL);
        registries.add(ModBlocks.LIME_WOOL);
        registries.add(ModBlocks.MAGENTA_WOOL);
        registries.add(ModBlocks.ORANGE_WOOL);
        registries.add(ModBlocks.PINK_WOOL);
        registries.add(ModBlocks.PURPLE_WOOL);
        registries.add(ModBlocks.RED_WOOL);
        registries.add(ModBlocks.YELLOW_WOOL);
        registries.add(ModBlocks.WHITE_CARPET);
        registries.add(ModBlocks.BLACK_CARPET);
        registries.add(ModBlocks.BLUE_CARPET);
        registries.add(ModBlocks.CYAN_CARPET);
        registries.add(ModBlocks.GRAY_CARPET);
        registries.add(ModBlocks.GREEN_CARPET);
        registries.add(ModBlocks.BROWN_CARPET);
        registries.add(ModBlocks.LIGHT_BLUE_CARPET);
        registries.add(ModBlocks.LIGHT_GRAY_CARPET);
        registries.add(ModBlocks.LIME_CARPET);
        registries.add(ModBlocks.MAGENTA_CARPET);
        registries.add(ModBlocks.ORANGE_CARPET);
        registries.add(ModBlocks.PINK_CARPET);
        registries.add(ModBlocks.PURPLE_CARPET);
        registries.add(ModBlocks.RED_CARPET);
        registries.add(ModBlocks.YELLOW_CARPET);

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

        registries.add(ModBlocks.GLASS_PANE);
        registries.add(ModBlocks.WHITE_STAINED_GLASS_PANE);
        registries.add(ModBlocks.BLACK_STAINED_GLASS_PANE);
        registries.add(ModBlocks.BLUE_STAINED_GLASS_PANE);
        registries.add(ModBlocks.CYAN_STAINED_GLASS_PANE);
        registries.add(ModBlocks.GRAY_STAINED_GLASS_PANE);
        registries.add(ModBlocks.GREEN_STAINED_GLASS_PANE);
        registries.add(ModBlocks.BROWN_STAINED_GLASS_PANE);
        registries.add(ModBlocks.LIGHT_BLUE_STAINED_GLASS_PANE);
        registries.add(ModBlocks.LIGHT_GRAY_STAINED_GLASS_PANE);
        registries.add(ModBlocks.LIME_STAINED_GLASS_PANE);
        registries.add(ModBlocks.MAGENTA_STAINED_GLASS_PANE);
        registries.add(ModBlocks.ORANGE_STAINED_GLASS_PANE);
        registries.add(ModBlocks.PINK_STAINED_GLASS_PANE);
        registries.add(ModBlocks.PURPLE_STAINED_GLASS_PANE);
        registries.add(ModBlocks.RED_STAINED_GLASS_PANE);
        registries.add(ModBlocks.YELLOW_STAINED_GLASS_PANE);
    }

    @Override
    public @NotNull CompletableFuture<?> run(@NotNull CachedOutput arg) {
        List<CompletableFuture<?>> futures = new ArrayList<>();

        for (ChippedPaletteRegistry<Block> registry : registries) {
            futures.add(CompletableFuture.runAsync(() -> {
                final String id = BuiltInRegistries.BLOCK.getKey(registry.getBase()).getPath();
                for (var ctm : registry.getPalette().getSpecial()) {
                    final ResourceLocation blockLoc = new ResourceLocation(Chipped.MOD_ID, "block/" + ctm.getSecond().replace("%", id));
                    final ResourceLocation location = new ResourceLocation(Chipped.MOD_ID, "blockstates/" + ctm.getSecond().replace("%", id) + ".json");
                    Path path = this.output.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(location.getNamespace()).resolve(location.getPath());
                    try {
                        Block block = BuiltInRegistries.BLOCK.get(new ResourceLocation(Chipped.MOD_ID, ctm.getSecond().replace("%", id)));
                        var json = files.getGeneratedBlockStates().get(block).toJson();
                        var textures = GsonHelper.getAsJsonObject(files.models().generatedModels.get(blockLoc).toJson(), "textures");
                        var ctmTexture = getCommonTexture(textures);

                        JsonObject ctmTextures = new JsonObject();
                        ctmTextures.addProperty("particle", ctmTexture);
                        ResourceLocation main = new ResourceLocation(ctmTexture.substring(0, ctmTexture.lastIndexOf("/")));
                        String blockName = ctmTexture.substring(ctmTexture.lastIndexOf("/") + 1);
                        String suffix = ctm.getFirst().suffix().length() > 0 ? "_" + ctm.getFirst().suffix() : "";
                        for (var entry : ctm.getFirst().getTextureIds()) {
                            ctmTextures.addProperty(entry.value(), this.textures.getTexture(main + "/ctm/" + blockName + suffix + "/" + entry.keyInt()));
                        }

                        ctm.getFirst().addTextureInfo(json);
                        json.add("ctm_textures", ctmTextures);
                        json.addProperty(new ResourceLocation(DefaultModels.MODID, "loader").toString(), new ResourceLocation(DefaultModels.MODID, ctm.getFirst().id()).toString());
                        DataProvider.saveStable(arg, json, path).join();
                    } catch (Exception e) {
                        System.out.println("Missing model: " + location);
                        throw e;
                    }
                }
            }, Util.backgroundExecutor()));
        }
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    private static String getCommonTexture(JsonObject object) {
        if (object.size() == 1) {
            return object.entrySet().iterator().next().getValue().getAsString();
        } else if (object.has("all")) {
            return GsonHelper.getAsString(object, "all");
        }
        return GsonHelper.getAsString(object, "particle");
    }

    @Override
    public @NotNull String getName() {
        return "Chipped CTM Blockstates";
    }
}
