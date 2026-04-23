package earth.terrarium.chipped.common.network;

import com.teamresourceful.resourcefullib.common.network.Packet;
import com.teamresourceful.resourcefullib.common.network.base.ClientboundPacketType;
import com.teamresourceful.resourcefullib.common.network.base.PacketType;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.client.network.ClientNetwork;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

import java.util.List;

public record ClientboundSetWorkbenchItemsPacket(List<Holder<Item>> items, boolean reset) implements Packet<ClientboundSetWorkbenchItemsPacket> {

    public static final ClientboundPacketType<ClientboundSetWorkbenchItemsPacket> TYPE = new Type();

    @Override
    public PacketType<ClientboundSetWorkbenchItemsPacket> type() {
        return TYPE;
    }

    private static class Type implements ClientboundPacketType<ClientboundSetWorkbenchItemsPacket> {

        private static final StreamCodec<RegistryFriendlyByteBuf, ClientboundSetWorkbenchItemsPacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.holderRegistry(Registries.ITEM).apply(ByteBufCodecs.list()), ClientboundSetWorkbenchItemsPacket::items,
            ByteBufCodecs.BOOL, ClientboundSetWorkbenchItemsPacket::reset,
            ClientboundSetWorkbenchItemsPacket::new
        );

        @Override
        public Identifier id() {
            return Chipped.id("results");
        }

        @Override
        public void encode(ClientboundSetWorkbenchItemsPacket message, RegistryFriendlyByteBuf buffer) {
            CODEC.encode(buffer, message);
        }

        @Override
        public ClientboundSetWorkbenchItemsPacket decode(RegistryFriendlyByteBuf buffer) {
            return CODEC.decode(buffer);
        }

        @Override
        public Runnable handle(ClientboundSetWorkbenchItemsPacket message) {
            return () -> ClientNetwork.handleWorkbenchItems(message);
        }
    }
}
