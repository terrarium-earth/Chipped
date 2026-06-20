package earth.terrarium.chipped;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public enum ChippedBlockTypes {
    BLOCK(Block::new),
    TNT(TntBlock::new);

    public final Function<BlockBehaviour.Properties, ? extends Block> factory;

    ChippedBlockTypes(Function<BlockBehaviour.Properties, ? extends Block> factory) {
        this.factory = factory;
    }
}
