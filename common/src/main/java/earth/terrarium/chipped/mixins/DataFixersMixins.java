package earth.terrarium.chipped.mixins;

import com.mojang.datafixers.DataFixerBuilder;
import com.mojang.datafixers.schemas.Schema;
import earth.terrarium.chipped.common.datafixer.ChippedDataFixers;
import net.minecraft.util.datafix.DataFixers;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BiFunction;

@Mixin(DataFixers.class)
public class DataFixersMixins {

    @Shadow
    @Final
    private static BiFunction<Integer, Schema, Schema> SAME_NAMESPACED;

    @Inject(
        method = "addFixers",
        at = @At("TAIL")
    )
    private static void chipped$addDataFixers(DataFixerBuilder builder, CallbackInfo ci) {
        Schema schema = builder.addSchema(3120, SAME_NAMESPACED);
        ChippedDataFixers.addDataFixers(schema, builder::addFixer);
    }
}
