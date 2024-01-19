package earth.terrarium.chipped.common.network;

import com.teamresourceful.resourcefullib.common.networking.base.Packet;
import com.teamresourceful.resourcefullib.common.networking.base.PacketContext;
import com.teamresourceful.resourcefullib.common.networking.base.PacketHandler;
import earth.terrarium.chipped.Chipped;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public record ServerboundFixedContainerButtonClickPacket(
    int container, int button
) implements Packet<ServerboundFixedContainerButtonClickPacket> {

    public static final ResourceLocation ID = new ResourceLocation(Chipped.MOD_ID, "container_button_click");
    public static final PacketHandler<ServerboundFixedContainerButtonClickPacket> HANDLER = new Handler();

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public PacketHandler<ServerboundFixedContainerButtonClickPacket> getHandler() {
        return HANDLER;
    }

    private static class Handler implements PacketHandler<ServerboundFixedContainerButtonClickPacket> {

        @Override
        public void encode(ServerboundFixedContainerButtonClickPacket message, FriendlyByteBuf buffer) {
            buffer.writeVarInt(message.container);
            buffer.writeVarInt(message.button);
        }

        @Override
        public ServerboundFixedContainerButtonClickPacket decode(FriendlyByteBuf buffer) {
            return new ServerboundFixedContainerButtonClickPacket(
                buffer.readVarInt(),
                buffer.readVarInt()
            );
        }

        @Override
        public PacketContext handle(ServerboundFixedContainerButtonClickPacket message) {
            return (player, level) -> {
                if (player instanceof ServerPlayer serverPlayer) {
                    boolean isCorrectContainer = serverPlayer.containerMenu.containerId == message.container;
                    boolean isNotSpectator = !serverPlayer.isSpectator();
                    boolean isContainerValid = serverPlayer.containerMenu.stillValid(serverPlayer);
                    if (isCorrectContainer && isNotSpectator && isContainerValid) {
                        if (serverPlayer.containerMenu.clickMenuButton(serverPlayer, message.button)) {
                            serverPlayer.containerMenu.broadcastChanges();
                        }
                    }
                }
            };
        }
    }
}
