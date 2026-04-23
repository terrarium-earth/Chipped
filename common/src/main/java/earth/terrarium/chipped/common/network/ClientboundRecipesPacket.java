package earth.terrarium.chipped.common.network;

import com.teamresourceful.resourcefullib.common.network.Packet;
import com.teamresourceful.resourcefullib.common.network.base.ClientboundPacketType;
import com.teamresourceful.resourcefullib.common.network.base.PacketType;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.client.network.ClientNetwork;
import earth.terrarium.chipped.common.recipes.ChippedRecipe;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;

import java.util.List;

public record ClientboundRecipesPacket(List<ChippedRecipe> recipes) implements Packet<ClientboundRecipesPacket> {

    public static final ClientboundPacketType<ClientboundRecipesPacket> TYPE = new Type();

    @Override
    public PacketType<ClientboundRecipesPacket> type() {
        return TYPE;
    }

    private static class Type implements ClientboundPacketType<ClientboundRecipesPacket> {

        private static final StreamCodec<RegistryFriendlyByteBuf, ClientboundRecipesPacket> CODEC = StreamCodec.composite(
            ChippedRecipe.NETWORK_CODEC.apply(ByteBufCodecs.list()), ClientboundRecipesPacket::recipes,
            ClientboundRecipesPacket::new
        );

        @Override
        public Identifier id() {
            return Chipped.id("recipes");
        }

        @Override
        public void encode(ClientboundRecipesPacket message, RegistryFriendlyByteBuf buffer) {
            CODEC.encode(buffer, message);
        }

        @Override
        public ClientboundRecipesPacket decode(RegistryFriendlyByteBuf buffer) {
            return CODEC.decode(buffer);
        }

        @Override
        public Runnable handle(ClientboundRecipesPacket message) {
            return () -> ClientNetwork.handleRecipes(message);
        }
    }
}
