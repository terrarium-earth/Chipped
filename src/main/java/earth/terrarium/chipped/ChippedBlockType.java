package earth.terrarium.chipped;

import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import com.teamresourceful.resourcefullib.common.registry.builtin.ResourcefulBlockRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.BiConsumer;
import java.util.function.Function;

public enum ChippedBlockType {
    BLOCK(Block::new, Chipped.NORMAL_BLOCKS),
    CONNECTED_BLOCK(Block::new, Chipped.CONNECTED_BLOCKS),
    PILLAR_BLOCK(RotatedPillarBlock::new, Chipped.PILLAR_BLOCKS),
    ;

    public final BiConsumer<BlockBehaviour.Properties, String> factory;

    ChippedBlockType(BiConsumer<BlockBehaviour.Properties, String> factory) {
        this.factory = factory;
    }

    ChippedBlockType(Function<BlockBehaviour.Properties, ? extends Block> consumer, ResourcefulRegistry<Block> registry) {
        this.factory = (properties, id) -> {
            Identifier modId = Chipped.id(id);
            var block = registry.register(id, () -> consumer.apply(properties.setId(ResourceKey.create(Registries.BLOCK, modId))));
            Chipped.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, modId))));
        };
    }
}
