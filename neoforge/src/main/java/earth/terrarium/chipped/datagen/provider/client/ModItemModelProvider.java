package earth.terrarium.chipped.datagen.provider.client;


import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Chipped.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        createBlockSet(ModBlocks.GLASS_PANE, "glass", "_pane");
        createBlockSet(ModBlocks.BLACK_STAINED_GLASS_PANE, "black_stained_glass", "_pane");
        createBlockSet(ModBlocks.BLUE_STAINED_GLASS_PANE, "blue_stained_glass", "_pane");
        createBlockSet(ModBlocks.BROWN_STAINED_GLASS_PANE, "brown_stained_glass", "_pane");
        createBlockSet(ModBlocks.CYAN_STAINED_GLASS_PANE, "cyan_stained_glass", "_pane");
        createBlockSet(ModBlocks.GRAY_STAINED_GLASS_PANE, "gray_stained_glass", "_pane");
        createBlockSet(ModBlocks.GREEN_STAINED_GLASS_PANE, "green_stained_glass", "_pane");
        createBlockSet(ModBlocks.LIGHT_BLUE_STAINED_GLASS_PANE, "light_blue_stained_glass", "_pane");
        createBlockSet(ModBlocks.LIGHT_GRAY_STAINED_GLASS_PANE, "light_gray_stained_glass", "_pane");
        createBlockSet(ModBlocks.LIME_STAINED_GLASS_PANE, "lime_stained_glass", "_pane");
        createBlockSet(ModBlocks.MAGENTA_STAINED_GLASS_PANE, "magenta_stained_glass", "_pane");
        createBlockSet(ModBlocks.ORANGE_STAINED_GLASS_PANE, "orange_stained_glass", "_pane");
        createBlockSet(ModBlocks.PINK_STAINED_GLASS_PANE, "pink_stained_glass", "_pane");
        createBlockSet(ModBlocks.PURPLE_STAINED_GLASS_PANE, "purple_stained_glass", "_pane");
        createBlockSet(ModBlocks.RED_STAINED_GLASS_PANE, "red_stained_glass", "_pane");
        createBlockSet(ModBlocks.WHITE_STAINED_GLASS_PANE, "white_stained_glass", "_pane");
        createBlockSet(ModBlocks.YELLOW_STAINED_GLASS_PANE, "yellow_stained_glass", "_pane");
        createBlockSet(ModBlocks.IRON_BARS, "iron_bars");
        createBlockSet(ModBlocks.LADDER, "ladder");

        createItemSet(ModBlocks.LANTERN, "lantern");
        createItemSet(ModBlocks.SOUL_LANTERN, "soul_lantern");

        createBlockSet(ModBlocks.POINTED_DRIPSTONE, "pointed_dripstone");
        createBlockSet(ModBlocks.LILY_PAD, "lily_pad");

        createItemSet(ModBlocks.ACACIA_DOOR, "acacia_door");
        createItemSet(ModBlocks.BIRCH_DOOR, "birch_door");
        createItemSet(ModBlocks.DARK_OAK_DOOR, "dark_oak_door");
        createItemSet(ModBlocks.JUNGLE_DOOR, "jungle_door");
        createItemSet(ModBlocks.MANGROVE_DOOR, "mangrove_door");
        createItemSet(ModBlocks.OAK_DOOR, "oak_door");
        createItemSet(ModBlocks.SPRUCE_DOOR, "spruce_door");
        createItemSet(ModBlocks.CRIMSON_DOOR, "crimson_door");
        createItemSet(ModBlocks.WARPED_DOOR, "warped_door");
        createItemSet(ModBlocks.CHERRY_DOOR, "cherry_door");
        createItemSet(ModBlocks.BAMBOO_DOOR, "bamboo_door");

        createBlockSet(ModBlocks.BROWN_MUSHROOM, "brown_mushroom");
        createBlockSet(ModBlocks.RED_MUSHROOM, "red_mushroom");
        createBlockSet(ModBlocks.COBWEB, "cobweb");
        createBlockSet(ModBlocks.CRIMSON_ROOTS, "crimson_roots");
        createBlockSet(ModBlocks.WARPED_ROOTS, "warped_roots");
        createBlockSet(ModBlocks.NETHER_SPROUTS, "nether_sprouts");
        createBlockSet(ModBlocks.CRIMSON_FUNGUS, "crimson_fungus");
        createBlockSet(ModBlocks.WARPED_FUNGUS, "warped_fungus");

        createBlockSet(ModBlocks.TORCH.getFirst(), "torch");
        createBlockSet(ModBlocks.REDSTONE_TORCH.getFirst(), "redstone_torch");

        basicItem(ModItems.WATERING_CAN.get());
        basicItem(ModItems.ALCHEMY_BOOK.get());
        basicItem(ModItems.SAW.get());
        basicItem(ModItems.NEEDLES.get());
        basicItem(ModItems.MULTIMETER.get());
    }

    private void createBlockSet(ResourcefulRegistry<Block> registry, String folder) {
        createBlockSet(registry, folder, "");
    }

    private void createBlockSet(ResourcefulRegistry<Block> registry, String folder, String replace) {
        List<Block> blocks = registry.stream().map(RegistryEntry::get).toList();
        for (Block block : blocks) {
            basicBlockItem(block, new ResourceLocation(Chipped.MOD_ID, Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(block)).getPath().replace(replace, "")), folder);
        }
    }

    public void basicBlockItem(Block path, ResourceLocation item, String folder) {
        getBuilder(Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(path)).toString())
            .parent(new ModelFile.UncheckedModelFile("item/generated"))
            .texture("layer0", customTexture(item, folder, true));
    }

    private void createItemSet(ResourcefulRegistry<Block> registry, String folder) {
        List<Block> blocks = registry.stream().map(RegistryEntry::get).toList();
        for (Block block : blocks) {
            basicCustomItem(block, folder);
        }
    }

    public void basicCustomItem(Block item, String folder) {
        basicItem(Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(item)), folder);
    }

    public void basicItem(ResourceLocation item, String folder) {
        getBuilder(item.toString())
            .parent(new ModelFile.UncheckedModelFile("item/generated"))
            .texture("layer0", customTexture(item, folder, false));
    }

    public ResourceLocation customTexture(ResourceLocation name, String folder, boolean blockFolder) {
        return new ResourceLocation(name.getNamespace(), (blockFolder ? ModelProvider.BLOCK_FOLDER : ModelProvider.ITEM_FOLDER) + "/" + folder + "/" + name.getPath());
    }
}
