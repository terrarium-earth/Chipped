package earth.terrarium.chipped.mixins;

import earth.terrarium.chipped.common.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EnchantmentTableBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentTableBlock.class)
public class EnchantmentTableBlockMixin {

    @Inject(method = "isValidBookShelf", at = @At("HEAD"), cancellable = true)
    private static void chipped$isValidBookShelf(Level level, BlockPos blockPos, BlockPos blockPos2, CallbackInfoReturnable<Boolean> cir) {
        if (level.getBlockState(blockPos.offset(blockPos2)).is(ModBlocks.BOOKSHELF_TAG)) {
            cir.setReturnValue(level.isEmptyBlock(blockPos.offset(blockPos2.getX() / 2, blockPos2.getY(), blockPos2.getZ() / 2)));
        }
    }
}
