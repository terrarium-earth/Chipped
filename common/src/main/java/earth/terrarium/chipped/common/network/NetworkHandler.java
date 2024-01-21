package earth.terrarium.chipped.common.network;

import com.teamresourceful.resourcefullib.common.networking.NetworkChannel;
import com.teamresourceful.resourcefullib.common.networking.base.NetworkDirection;
import earth.terrarium.chipped.Chipped;

public class NetworkHandler {

    public static final NetworkChannel CHANNEL = new NetworkChannel(Chipped.MOD_ID, 1, "main");

    public static void init() {
        CHANNEL.registerPacket(NetworkDirection.CLIENT_TO_SERVER, ServerboundCraftPacket.ID, ServerboundCraftPacket.HANDLER, ServerboundCraftPacket.class);
    }
}
