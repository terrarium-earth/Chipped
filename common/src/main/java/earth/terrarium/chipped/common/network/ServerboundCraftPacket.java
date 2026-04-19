package earth.terrarium.chipped.common.network;

import com.teamresourceful.resourcefullib.common.network.Packet;
import com.teamresourceful.resourcefullib.common.network.base.PacketType;
import com.teamresourceful.resourcefullib.common.network.base.ServerboundPacketType;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.menus.WorkbenchMenu;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

import java.util.function.Consumer;

public record ServerboundCraftPacket(Holder<Item> item, boolean replaceAll) implements Packet<ServerboundCraftPacket> {

    public static final ServerboundPacketType<ServerboundCraftPacket> TYPE = new Type();

    @Override
    public PacketType<ServerboundCraftPacket> type() {
        return TYPE;
    }

    private static class Type implements ServerboundPacketType<ServerboundCraftPacket> {

        private static final StreamCodec<RegistryFriendlyByteBuf, ServerboundCraftPacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.holderRegistry(Registries.ITEM), ServerboundCraftPacket::item,
            ByteBufCodecs.BOOL, ServerboundCraftPacket::replaceAll,
            ServerboundCraftPacket::new
        );

        @Override
        public Identifier id() {
            return Chipped.id("craft");
        }

        @Override
        public void encode(ServerboundCraftPacket message, RegistryFriendlyByteBuf buffer) {
            CODEC.encode(buffer, message);
        }

        @Override
        public ServerboundCraftPacket decode(RegistryFriendlyByteBuf buffer) {
            return CODEC.decode(buffer);
        }

        @Override
        public Consumer<Player> handle(ServerboundCraftPacket packet) {
            return player -> {
                if (player.containerMenu instanceof WorkbenchMenu menu) {
                    menu.craft(packet.item, packet.replaceAll);
                    player.containerMenu.broadcastChanges();
                }
            };
        }
    }
}
