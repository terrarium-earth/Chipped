package earth.terrarium.chipped.mixins;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Block.class)
public interface BlockAccessor {

    @Invoker("codec")
    MapCodec<? extends Block> chipped$codec();
}
