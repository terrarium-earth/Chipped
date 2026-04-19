package earth.terrarium.chipped.common.registry;

import com.teamresourceful.resourcefullib.common.item.tabs.ResourcefulCreativeModeTab;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import com.teamresourceful.resourcefullib.common.registry.builtin.ResourcefulItemRegistry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.items.ChippedBlockItemProperties;
import earth.terrarium.chipped.common.items.WorkbenchItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ModItems {
    public static final ResourcefulItemRegistry ITEMS = ResourcefulRegistries.createForItems(Chipped.MOD_ID);
    public static final ResourcefulItemRegistry BENCHES = ResourcefulRegistries.createForItems(ITEMS);

    public static final RegistryEntry<Item> BOTANIST_WORKBENCH = BENCHES.register("botanist_workbench", (properties) -> new BlockItem(ModBlocks.BOTANIST_WORKBENCH.get(), properties), ChippedBlockItemProperties::base);
    public static final RegistryEntry<Item> GLASSBLOWER = BENCHES.register("glassblower", (properties) -> new BlockItem(ModBlocks.GLASSBLOWER.get(), properties), ChippedBlockItemProperties::base);
    public static final RegistryEntry<Item> CARPENTERS_TABLE = BENCHES.register("carpenters_table", (properties) -> new BlockItem(ModBlocks.CARPENTERS_TABLE.get(), properties), ChippedBlockItemProperties::base);
    public static final RegistryEntry<Item> LOOM_TABLE = BENCHES.register("loom_table", (properties) -> new BlockItem(ModBlocks.LOOM_TABLE.get(), properties), ChippedBlockItemProperties::base);
    public static final RegistryEntry<Item> MASON_TABLE = BENCHES.register("mason_table", (properties) -> new BlockItem(ModBlocks.MASON_TABLE.get(), properties), ChippedBlockItemProperties::base);
    public static final RegistryEntry<Item> ALCHEMY_BENCH = BENCHES.register("alchemy_bench", (properties) -> new BlockItem(ModBlocks.ALCHEMY_BENCH.get(), properties), ChippedBlockItemProperties::base);
    public static final RegistryEntry<Item> TINKERING_TABLE = BENCHES.register("tinkering_table", (properties) -> new BlockItem(ModBlocks.TINKERING_TABLE.get(), properties), ChippedBlockItemProperties::base);

    public static final RegistryEntry<Item> WATERING_CAN = ITEMS.register("watering_can", WorkbenchItem::new, Item.Properties::new);
    public static final RegistryEntry<Item> ALCHEMY_BOOK = ITEMS.register("alchemy_book", WorkbenchItem::new, Item.Properties::new);
    public static final RegistryEntry<Item> SAW = ITEMS.register("saw", WorkbenchItem::new, Item.Properties::new);
    public static final RegistryEntry<Item> NEEDLES = ITEMS.register("needles", WorkbenchItem::new, Item.Properties::new);
    public static final RegistryEntry<Item> CHISEL = ITEMS.register("chisel", WorkbenchItem::new, Item.Properties::new);
    public static final RegistryEntry<Item> MULTIMETER = ITEMS.register("multimeter", WorkbenchItem::new, Item.Properties::new);

    public static final ResourcefulRegistry<CreativeModeTab> TABS = ResourcefulRegistries.create(BuiltInRegistries.CREATIVE_MODE_TAB, Chipped.MOD_ID);
    public static final RegistryEntry<CreativeModeTab> TAB = TABS.register("main", () -> new ResourcefulCreativeModeTab(Chipped.id("main"))
        .setItemIcon(ModItems.BOTANIST_WORKBENCH)
        .addRegistry(ITEMS)
        .build());

    public static void createItemRegistry(ResourcefulRegistry<Block> blocks, BiFunction<Block, Item.Properties, BlockItem> itemType, Supplier<Item.Properties> itemProperties) {
        var registry = ResourcefulRegistries.createForItems(ModItems.ITEMS);
        blocks.stream().forEach(block ->
            registry.register(
                block.getId().getPath(),
                (properties) -> itemType.apply(block.get(), properties),
                itemProperties
            )
        );
    }
}
