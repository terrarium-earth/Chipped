package earth.terrarium.chipped.mixin;

import earth.terrarium.chipped.Chipped;
import net.minecraft.core.Registry;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.StringUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// FOR FABRIC DATAGEN
// Allows the texture reference to point to a directory, allowing for much better organization in the textures folder.
@Mixin(TextureMapping.class)
public abstract class TextureMappingMixin {

    @Inject(method = "getBlockTexture(Lnet/minecraft/world/level/block/Block;)Lnet/minecraft/resources/ResourceLocation;", at = @At("HEAD"), cancellable = true)
    private static void getBlockTexture(Block block, CallbackInfoReturnable<ResourceLocation> ci) {
        ResourceLocation resourceLocation = Registry.BLOCK.getKey(block);
        String name = resourceLocation.getNamespace();
        if (name.contains(Chipped.MOD_ID)) {
            String path = resourceLocation.getPath();
            String directory = StringUtils.substringBeforeLast(path, "_");
            ci.setReturnValue(new ResourceLocation(resourceLocation.getNamespace(), "block/" + directory + "/" + resourceLocation.getPath()));
        }
    }

    @Inject(method = "getBlockTexture(Lnet/minecraft/world/level/block/Block;Ljava/lang/String;)Lnet/minecraft/resources/ResourceLocation;", at = @At("HEAD"), cancellable = true)
    private static void getBlockTexture(Block block, String textureSuffix, CallbackInfoReturnable<ResourceLocation> ci) {
        ResourceLocation resourceLocation = Registry.BLOCK.getKey(block);
        String name = resourceLocation.getNamespace();
        if (name.contains(Chipped.MOD_ID)) {
            String path = resourceLocation.getPath();
            String directory = StringUtils.substringBeforeLast(path, "_");
            ci.setReturnValue(new ResourceLocation(name, "block/" + directory + "/" + path + textureSuffix));
        }
    }

    @Inject(method = "getItemTexture(Lnet/minecraft/world/item/Item;)Lnet/minecraft/resources/ResourceLocation;", at = @At("HEAD"), cancellable = true)
    private static void getItemTexture(Item item, CallbackInfoReturnable<ResourceLocation> ci) {
        ResourceLocation resourceLocation = Registry.ITEM.getKey(item);
        String name = resourceLocation.getNamespace();
        if (name.contains(Chipped.MOD_ID)) {
            String path = resourceLocation.getPath();
            String directory = StringUtils.substringBeforeLast(path, "_");
            ci.setReturnValue(new ResourceLocation(resourceLocation.getNamespace(), "item/" + directory + "/" + resourceLocation.getPath()));
        }
    }

    @Inject(method = "getItemTexture(Lnet/minecraft/world/item/Item;Ljava/lang/String;)Lnet/minecraft/resources/ResourceLocation;", at = @At("HEAD"), cancellable = true)
    private static void getItemTexture(Item item, String textureSuffix, CallbackInfoReturnable<ResourceLocation> ci) {
        ResourceLocation resourceLocation = Registry.ITEM.getKey(item);
        String name = resourceLocation.getNamespace();
        if (name.contains(Chipped.MOD_ID)) {
            String path = resourceLocation.getPath();
            String directory = StringUtils.substringBeforeLast(path, "_");
            ci.setReturnValue(new ResourceLocation(name, "item/" + directory + "/" + path + textureSuffix));
        }
    }
}
