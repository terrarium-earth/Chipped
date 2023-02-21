package earth.terrarium.chipped.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.util.PlatformUtils;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.function.BiFunction;

public class ModItems {
    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(Registry.ITEM, Chipped.MOD_ID);
    public static final ResourcefulRegistry<Item> BENCHES = ResourcefulRegistries.create(ITEMS);

    public static final CreativeModeTab ITEM_GROUP = PlatformUtils.createTab(new ResourceLocation(Chipped.MOD_ID, "main"), () -> new ItemStack(ModBlocks.BOTANIST_WORKBENCH.get()));

    public static final RegistryEntry<Item> BOTANIST_WORKBENCH = BENCHES.register("botanist_workbench", () -> new BlockItem(ModBlocks.BOTANIST_WORKBENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLASSBLOWER = BENCHES.register("glassblower", () -> new BlockItem(ModBlocks.GLASSBLOWER.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CARPENTERS_TABLE = BENCHES.register("carpenters_table", () -> new BlockItem(ModBlocks.CARPENTERS_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> LOOM_TABLE = BENCHES.register("loom_table", () -> new BlockItem(ModBlocks.LOOM_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MASON_TABLE = BENCHES.register("mason_table", () -> new BlockItem(ModBlocks.MASON_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> ALCHEMY_BENCH = BENCHES.register("alchemy_bench", () -> new BlockItem(ModBlocks.ALCHEMY_BENCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> TINKERING_TABLE = BENCHES.register("tinkering_table", () -> new BlockItem(ModBlocks.TINKERING_TABLE.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static void createItemRegistry(ResourcefulRegistry<Block> blocks, BiFunction<Block, Item.Properties, BlockItem> itemType) {
        var registry = ResourcefulRegistries.create(ModItems.ITEMS);
        blocks.stream().forEach(block -> {
            registry.register(block.getId().getPath(), () -> itemType.apply(block.get(), new Item.Properties().tab(ModItems.ITEM_GROUP)));
        });
    }
}
