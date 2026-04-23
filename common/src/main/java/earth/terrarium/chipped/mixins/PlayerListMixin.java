package earth.terrarium.chipped.mixins;

import earth.terrarium.chipped.common.network.ClientboundRecipesPacket;
import earth.terrarium.chipped.common.network.NetworkHandler;
import earth.terrarium.chipped.common.recipes.ChippedRecipe;
import net.minecraft.network.Connection;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.CommonListenerCookie;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.item.crafting.RecipeManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(PlayerList.class)
public class PlayerListMixin {

    @Shadow
    @Final
    private MinecraftServer server;

    @Inject(method = "placeNewPlayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;getRecipeManager()Lnet/minecraft/world/item/crafting/RecipeManager;"))
    private void placeNewPlayer(Connection connection, ServerPlayer player, CommonListenerCookie cookie, CallbackInfo ci) {
        NetworkHandler.CHANNEL.sendToPlayer(chipped$createRecipesPacket(this.server.getRecipeManager()), player);
    }

    @Inject(method = "reloadResources", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/players/PlayerList;broadcastAll(Lnet/minecraft/network/protocol/Packet;)V"))
    private void broadcastAll(CallbackInfo ci) {
        NetworkHandler.CHANNEL.sendToAllPlayers(chipped$createRecipesPacket(this.server.getRecipeManager()), this.server);
    }

    @Unique
    private ClientboundRecipesPacket chipped$createRecipesPacket(RecipeManager manager) {
        List<ChippedRecipe> recipes = new ArrayList<>();
        for (var holder : manager.getRecipes()) {
            if (holder.value() instanceof ChippedRecipe recipe) {
                recipes.add(recipe);
            }
        }
        return new ClientboundRecipesPacket(recipes);
    }
}
