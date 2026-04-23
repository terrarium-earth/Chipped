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

public record ServerboundWorkbenchCraftPacket(Holder<Item> item, boolean replaceAll) implements Packet<ServerboundWorkbenchCraftPacket> {

    public static final ServerboundPacketType<ServerboundWorkbenchCraftPacket> TYPE = new Type();

    @Override
    public PacketType<ServerboundWorkbenchCraftPacket> type() {
        return TYPE;
    }

    private static class Type implements ServerboundPacketType<ServerboundWorkbenchCraftPacket> {

        private static final StreamCodec<RegistryFriendlyByteBuf, ServerboundWorkbenchCraftPacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.holderRegistry(Registries.ITEM), ServerboundWorkbenchCraftPacket::item,
            ByteBufCodecs.BOOL, ServerboundWorkbenchCraftPacket::replaceAll,
            ServerboundWorkbenchCraftPacket::new
        );

        @Override
        public Identifier id() {
            return Chipped.id("craft");
        }

        @Override
        public void encode(ServerboundWorkbenchCraftPacket message, RegistryFriendlyByteBuf buffer) {
            CODEC.encode(buffer, message);
        }

        @Override
        public ServerboundWorkbenchCraftPacket decode(RegistryFriendlyByteBuf buffer) {
            return CODEC.decode(buffer);
        }

        @Override
        public Consumer<Player> handle(ServerboundWorkbenchCraftPacket packet) {
            return player -> {
                if (player.containerMenu instanceof WorkbenchMenu menu) {
                    menu.craft(packet.item, packet.replaceAll);
                    player.containerMenu.broadcastChanges();
                }
            };
        }
    }
}
