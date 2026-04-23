package earth.terrarium.chipped.common.network;

import com.teamresourceful.resourcefullib.common.network.Network;
import earth.terrarium.chipped.Chipped;

public class NetworkHandler {

    public static final Network CHANNEL = new Network(Chipped.id("main"), 1);

    public static void init() {
        CHANNEL.register(ServerboundWorkbenchCraftPacket.TYPE);
        CHANNEL.register(ClientboundSetWorkbenchItemsPacket.TYPE);
        CHANNEL.register(ClientboundRecipesPacket.TYPE);
    }
}
