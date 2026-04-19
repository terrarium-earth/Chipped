package earth.terrarium.chipped.common.registry.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BlockConstructors {

    public static LadderBlock ladder(BlockBehaviour.Properties properties) {
        return new LadderBlock(properties) {};
    }

    public static IronBarsBlock ironBars(BlockBehaviour.Properties properties) {
        return new IronBarsBlock(properties) {};
    }

    public static SpongeBlock sponge(BlockBehaviour.Properties properties) {
        return new SpongeBlock(properties) {};
    }

    public static MangroveRootsBlock mangroveRoots(BlockBehaviour.Properties properties) {
        return new MangroveRootsBlock(properties) {};
    }

    public static LilyPadBlock lilyPad(BlockBehaviour.Properties properties) {
        return new LilyPadBlock(properties) {};
    }

    public static CarvedPumpkinBlock carvedPumpkin(BlockBehaviour.Properties properties) {
        return new CarvedPumpkinBlock(properties) {};
    }
}
