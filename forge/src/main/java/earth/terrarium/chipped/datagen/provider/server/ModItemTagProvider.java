package earth.terrarium.chipped.datagen.provider.server;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.registry.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;
import java.util.Objects;

public class ModItemTagProvider extends TagsProvider<Item> {
    public ModItemTagProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Registry.ITEM, Chipped.MOD_ID, exFileHelper);
    }

    @Override
    protected void addTags() {
        ModBlockTagProvider.registerTags(this::createSet);
        ModBlockTagProvider.registerSpecial(this::createSet);
        addVanillaTags();
    }

    private void addVanillaTags() {
        createVanillaSet(ModBlocks.BLACK_CARPET, ItemTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.BLUE_CARPET, ItemTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.BROWN_CARPET, ItemTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.CYAN_CARPET, ItemTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.GRAY_CARPET, ItemTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.GREEN_CARPET, ItemTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.LIGHT_BLUE_CARPET, ItemTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.LIGHT_GRAY_CARPET, ItemTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.LIME_CARPET, ItemTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.MAGENTA_CARPET, ItemTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.ORANGE_CARPET, ItemTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.PINK_CARPET, ItemTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.PURPLE_CARPET, ItemTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.RED_CARPET, ItemTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.WHITE_CARPET, ItemTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.YELLOW_CARPET, ItemTags.WOOL_CARPETS);
        createVanillaSet(ModBlocks.DIRT, ItemTags.DIRT);
        createVanillaSet(ModBlocks.ACACIA_DOOR, ItemTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.BIRCH_DOOR, ItemTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.DARK_OAK_DOOR, ItemTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.JUNGLE_DOOR, ItemTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.MANGROVE_DOOR, ItemTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.OAK_DOOR, ItemTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.SPRUCE_DOOR, ItemTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.CRIMSON_DOOR, ItemTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.WARPED_DOOR, ItemTags.WOODEN_DOORS);
        createVanillaSet(ModBlocks.ACACIA_LEAVES, ItemTags.LEAVES);
        createVanillaSet(ModBlocks.BIRCH_LEAVES, ItemTags.LEAVES);
        createVanillaSet(ModBlocks.DARK_OAK_LEAVES, ItemTags.LEAVES);
        createVanillaSet(ModBlocks.JUNGLE_LEAVES, ItemTags.LEAVES);
        createVanillaSet(ModBlocks.OAK_LEAVES, ItemTags.LEAVES);
        createVanillaSet(ModBlocks.SPRUCE_LEAVES, ItemTags.LEAVES);
        createVanillaSet(ModBlocks.CRIMSON_PLANKS, ItemTags.NON_FLAMMABLE_WOOD);
        createVanillaSet(ModBlocks.WARPED_PLANKS, ItemTags.NON_FLAMMABLE_WOOD);
        createVanillaSet(ModBlocks.SOUL_LANTERN, ItemTags.PIGLIN_REPELLENTS);
        createVanillaSet(ModBlocks.ACACIA_PLANKS, ItemTags.PLANKS);
        createVanillaSet(ModBlocks.BIRCH_PLANKS, ItemTags.PLANKS);
        createVanillaSet(ModBlocks.DARK_OAK_PLANKS, ItemTags.PLANKS);
        createVanillaSet(ModBlocks.JUNGLE_PLANKS, ItemTags.PLANKS);
        createVanillaSet(ModBlocks.MANGROVE_PLANKS, ItemTags.PLANKS);
        createVanillaSet(ModBlocks.OAK_PLANKS, ItemTags.PLANKS);
        createVanillaSet(ModBlocks.SPRUCE_PLANKS, ItemTags.PLANKS);
        createVanillaSet(ModBlocks.CRIMSON_PLANKS, ItemTags.PLANKS);
        createVanillaSet(ModBlocks.WARPED_PLANKS, ItemTags.PLANKS);
        createVanillaSet(ModBlocks.SAND, ItemTags.SAND);
        createVanillaSet(ModBlocks.SOUL_SAND, ItemTags.SOUL_FIRE_BASE_BLOCKS);
        createVanillaSet(ModBlocks.ACACIA_TRAPDOOR, ItemTags.TRAPDOORS);
        createVanillaSet(ModBlocks.BIRCH_TRAPDOOR, ItemTags.TRAPDOORS);
        createVanillaSet(ModBlocks.DARK_OAK_TRAPDOOR, ItemTags.TRAPDOORS);
        createVanillaSet(ModBlocks.JUNGLE_TRAPDOOR, ItemTags.TRAPDOORS);
        createVanillaSet(ModBlocks.MANGROVE_TRAPDOOR, ItemTags.TRAPDOORS);
        createVanillaSet(ModBlocks.OAK_TRAPDOOR, ItemTags.TRAPDOORS);
        createVanillaSet(ModBlocks.SPRUCE_TRAPDOOR, ItemTags.TRAPDOORS);
        createVanillaSet(ModBlocks.CRIMSON_TRAPDOOR, ItemTags.TRAPDOORS);
        createVanillaSet(ModBlocks.WARPED_TRAPDOOR, ItemTags.TRAPDOORS);
        createVanillaSet(ModBlocks.NETHER_WART_BLOCK, ItemTags.WART_BLOCKS);
        createVanillaSet(ModBlocks.WARPED_WART_BLOCK, ItemTags.WART_BLOCKS);
        createVanillaSet(ModBlocks.BLACK_WOOL, ItemTags.WOOL);
        createVanillaSet(ModBlocks.BLUE_WOOL, ItemTags.WOOL);
        createVanillaSet(ModBlocks.BROWN_WOOL, ItemTags.WOOL);
        createVanillaSet(ModBlocks.CYAN_WOOL, ItemTags.WOOL);
        createVanillaSet(ModBlocks.GRAY_WOOL, ItemTags.WOOL);
        createVanillaSet(ModBlocks.GREEN_WOOL, ItemTags.WOOL);
        createVanillaSet(ModBlocks.LIGHT_BLUE_WOOL, ItemTags.WOOL);
        createVanillaSet(ModBlocks.LIGHT_GRAY_WOOL, ItemTags.WOOL);
        createVanillaSet(ModBlocks.LIME_WOOL, ItemTags.WOOL);
        createVanillaSet(ModBlocks.MAGENTA_WOOL, ItemTags.WOOL);
        createVanillaSet(ModBlocks.ORANGE_WOOL, ItemTags.WOOL);
        createVanillaSet(ModBlocks.PINK_WOOL, ItemTags.WOOL);
        createVanillaSet(ModBlocks.PURPLE_WOOL, ItemTags.WOOL);
        createVanillaSet(ModBlocks.RED_WOOL, ItemTags.WOOL);
        createVanillaSet(ModBlocks.WHITE_WOOL, ItemTags.WOOL);
        createVanillaSet(ModBlocks.YELLOW_WOOL, ItemTags.WOOL);
    }

    private void createVanillaSet(ResourcefulRegistry<Block> registry, TagKey<Item> tag) {
        registry.stream().forEach(b -> tag(tag).add(TagEntry.element(b.getId())));
    }

    private void createSet(Block block, ResourcefulRegistry<Block> registry, String tag, TagKey<Item> workbench) {
        createSet(block, registry.getEntries(), tag, workbench);
    }

    private void createSet(Block block, Collection<RegistryEntry<Block>> registry, String tag, TagKey<Item> workbench) {
        var tagKey = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Chipped.MOD_ID, tag));
        if (block != null) {
            tag(tagKey).add(TagEntry.element(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block))));
        }
        registry.forEach(b -> tag(tagKey).add(TagEntry.element(b.getId())));
    }
}
