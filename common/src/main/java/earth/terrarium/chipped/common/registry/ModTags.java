package earth.terrarium.chipped.common.registry;

import earth.terrarium.chipped.Chipped;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class ModTags {

    public static final Map<String, TagKey<Block>> BLOCK_TAGS = new HashMap<>();
    public static final Map<String, TagKey<Item>> ITEM_TAGS = new HashMap<>();

    public static void addOrCreateTag(ResourceLocation block) {
        String name = StringUtils.substringBeforeLast(block.getPath(), "_");
        if (!BLOCK_TAGS.containsKey(name)) {
            BLOCK_TAGS.put(name, TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Chipped.MOD_ID, name)));
            ITEM_TAGS.put(name, TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Chipped.MOD_ID, name)));
        }
    }
}
