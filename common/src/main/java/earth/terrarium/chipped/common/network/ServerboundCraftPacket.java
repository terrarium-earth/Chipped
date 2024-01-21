package earth.terrarium.chipped.common.network;

import com.teamresourceful.resourcefullib.common.networking.base.Packet;
import com.teamresourceful.resourcefullib.common.networking.base.PacketContext;
import com.teamresourceful.resourcefullib.common.networking.base.PacketHandler;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.menus.WorkbenchMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public record ServerboundCraftPacket(
    ItemStack stack, boolean replaceAll
) implements Packet<ServerboundCraftPacket> {

    public static final ResourceLocation ID = new ResourceLocation(Chipped.MOD_ID, "craft");
    public static final PacketHandler<ServerboundCraftPacket> HANDLER = new Handler();

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public PacketHandler<ServerboundCraftPacket> getHandler() {
        return HANDLER;
    }

    private static class Handler implements PacketHandler<ServerboundCraftPacket> {

        @Override
        public void encode(ServerboundCraftPacket message, FriendlyByteBuf buffer) {
            buffer.writeItem(message.stack);
            buffer.writeBoolean(message.replaceAll);
        }

        @Override
        public ServerboundCraftPacket decode(FriendlyByteBuf buffer) {
            return new ServerboundCraftPacket(buffer.readItem(), buffer.readBoolean());
        }

        @Override
        public PacketContext handle(ServerboundCraftPacket message) {
            return (player, level) -> {
                if (player.containerMenu instanceof WorkbenchMenu menu) {
                    menu.craft(message.stack, message.replaceAll);
                    player.containerMenu.broadcastChanges();
                }
            };
        }
    }
}
